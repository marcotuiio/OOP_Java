package com.example.Prova1ConsumidorMarcoBarros.Controller;

import com.example.Prova1ConsumidorMarcoBarros.Model.Item_Cardapio;
import com.example.Prova1ConsumidorMarcoBarros.Model.Item_Pedido;
import com.example.Prova1ConsumidorMarcoBarros.Model.Restaurante;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CardapioController {
    private static final String SESSION_PEDIDOS = "sessionPedidos";
    private static final String PRECO_PEDIDOS = "precoPedidos";
    @Autowired
    Item_CardapioRepository cardapioRepository;
    @Autowired
    RestauranteRepository restauranteRepository;

    @GetMapping("/adicionar-pedido/{id_rest}/{id_card}")
    public String adicionarPedido(@PathVariable("id_rest") int id_rest, @PathVariable("id_card") int id_card,
                                  HttpServletRequest request) {
        Restaurante restaurante = restauranteRepository.findById(id_rest)
                .orElseThrow(() -> new IllegalArgumentException("O id do restaurante é inválido:" + id_rest));
        Item_Cardapio item_cardapio = cardapioRepository.findById(id_card)
                .orElseThrow(() -> new IllegalArgumentException("O id do cardapio é inválido:" + id_card));

        clearSessionTrash(request);

        HashMap<Item_Cardapio, Item_Pedido> pedidos =
                (HashMap<Item_Cardapio, Item_Pedido>) request.getSession().getAttribute(SESSION_PEDIDOS);
        if (pedidos == null) {
            pedidos = new HashMap<>();
        }


        Item_Pedido item_pedido = pedidos.get(item_cardapio);
        if (item_pedido == null) {
            item_pedido = new Item_Pedido(item_cardapio, restaurante.getNome());
        }

        item_pedido.setQuantidade(item_pedido.getQuantidade() + 1);
        pedidos.put(item_cardapio, item_pedido);

        double precoPedido = calculatePreco(pedidos);

        request.getSession().setAttribute(SESSION_PEDIDOS, pedidos);
        request.getSession().setAttribute(PRECO_PEDIDOS, precoPedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/sub-pedido/{id_rest}/{id_card}")
    public String subUmPedido(@PathVariable("id_rest") int id_rest, @PathVariable("id_card") int id_card,
                                  HttpServletRequest request) {
        clearSessionTrash(request);
        Item_Cardapio item_cardapio = cardapioRepository.findById(id_card)
                .orElseThrow(() -> new IllegalArgumentException("O id do cardapio é inválido:" + id_card));

        HashMap<Item_Cardapio, Item_Pedido> pedidos =
                (HashMap<Item_Cardapio, Item_Pedido>) request.getSession().getAttribute(SESSION_PEDIDOS);

        Item_Pedido item_pedido = pedidos.get(item_cardapio);

        if (item_pedido.getQuantidade() > 1) {
            item_pedido.setQuantidade(item_pedido.getQuantidade() - 1);
            pedidos.put(item_cardapio, item_pedido);
        } else if (item_pedido.getQuantidade() == 1) {
            pedidos.remove(item_cardapio);
        }

        double precoPedido = calculatePreco(pedidos);

        request.getSession().setAttribute(SESSION_PEDIDOS, pedidos);
        request.getSession().setAttribute(PRECO_PEDIDOS, precoPedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/remover-pedido/{id_rest}/{id_card}")
    public String removerPedido(@PathVariable("id_rest") int id_rest, @PathVariable("id_card") int id_card,
                                HttpServletRequest request) {
        clearSessionTrash(request);
        Item_Cardapio item_cardapio = cardapioRepository.findById(id_card)
                .orElseThrow(() -> new IllegalArgumentException("O id do cardapio é inválido:" + id_card));

        HashMap<Item_Cardapio, Item_Pedido> pedidos =
                (HashMap<Item_Cardapio, Item_Pedido>) request.getSession().getAttribute(SESSION_PEDIDOS);

        Item_Pedido item_pedido = pedidos.get(item_cardapio);

        pedidos.remove(item_cardapio);
        double precoPedido = calculatePreco(pedidos);

        request.getSession().setAttribute(SESSION_PEDIDOS, pedidos);
        request.getSession().setAttribute(PRECO_PEDIDOS, precoPedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/pedidos")
    public String mostrarPedidos(Model model, HttpServletRequest request) {
        HashMap<Item_Cardapio, Item_Pedido> pedidos =
                (HashMap<Item_Cardapio, Item_Pedido>) request.getSession().getAttribute(SESSION_PEDIDOS);
        clearSessionTrash(request);
        double precoTotal = calculatePreco(pedidos);
        request.getSession().setAttribute(PRECO_PEDIDOS, precoTotal);
        model.addAttribute("precoPedidos", precoTotal);
        model.addAttribute("sessionPedidos",
                !CollectionUtils.isEmpty(pedidos) ? pedidos : new HashMap<>());

        return "pedidos";
    }

    public double calculatePreco(HashMap<Item_Cardapio, Item_Pedido> pedidos) {
        double total = 0;
        if (pedidos == null) { return total; }
        for (Map.Entry<Item_Cardapio, Item_Pedido> mapElement : pedidos.entrySet()) {
            Item_Pedido item_pedido = mapElement.getValue();
            Item_Cardapio item_cardapio = mapElement.getKey();

            int quantidade = item_pedido.getQuantidade();
            double preco = item_cardapio.getPreco();

            total = quantidade * preco + total;
        }
        return total;
    }

    public void clearSessionTrash(HttpServletRequest request) {
        HashMap<Item_Cardapio, Item_Pedido> pedidos =
                (HashMap<Item_Cardapio, Item_Pedido>) request.getSession().getAttribute(SESSION_PEDIDOS);

        if (pedidos == null) {
            return;
        }

        HashMap<Item_Cardapio, Item_Pedido> pedidosValidos = new HashMap<>();

        for (Map.Entry<Item_Cardapio, Item_Pedido> entry : pedidos.entrySet()) {
            Item_Cardapio itemCardapio = entry.getKey();
            Restaurante restaurante = restauranteRepository.findById(itemCardapio.getId_restaurante()).orElse(null);
            Item_Cardapio itemBanco = cardapioRepository.findById(itemCardapio.getId()).orElse(null);

            if (restaurante != null && itemBanco != null) {
                pedidosValidos.put(itemCardapio, entry.getValue());
            }
        }

        request.getSession().setAttribute(SESSION_PEDIDOS, pedidosValidos);
    }
}
