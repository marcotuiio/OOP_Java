package com.example.Prova1AdminMarcoBarros.Controller;

import com.example.Prova1AdminMarcoBarros.Model.Item_Cardapio;
import com.example.Prova1AdminMarcoBarros.Model.Restaurante;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CardapioController {
    @Autowired
    Item_CardapioRepository cardapioRepository;

    @GetMapping("/novo-item-cardapio/{id}")
    public String mostrarFormNovoItemCardapio(@PathVariable("id") int id, Model model) {
        model.addAttribute("idRest", id);
        model.addAttribute("item_cardapio", new Item_Cardapio());
        return "novo-item-cardapio";
    }

    @PostMapping("/adicionar-item-cardapio/{id}")
    public String adicionarItemCardapio(@PathVariable("id") int id, @Valid Item_Cardapio item_cardapio, BindingResult result) {
        if (result.hasErrors()) {
            return "novo-item-cardapio";
        }
        item_cardapio.setId_restaurante(id);
        cardapioRepository.save(item_cardapio);
        return "redirect:/novo-item-cardapio/{id}";
    }

    @GetMapping("/editar-cardapio/{id_rest}/{id_card}")
    public String mostrarFormEditarCardapio(@PathVariable("id_rest") int id_rest, @PathVariable("id_card") int id_card,
                                            Model model) {
        Item_Cardapio item_cardapio = cardapioRepository.findById(id_card).
                orElseThrow(() -> {
                    return new IllegalArgumentException("O id do item_cardapio é inválido:" + id_card);
                });
        model.addAttribute("idCard", item_cardapio.getId());
        model.addAttribute("idRest", item_cardapio.getId_restaurante());
        model.addAttribute("item_cardapio", item_cardapio);
        return "editar-item-cardapio";
    }

    @PostMapping("/atualizar-cardapio/{id_rest}/{id_card}")
    String atualizarCardapio(@PathVariable("id_rest") int id_rest, @PathVariable("id_card") int id_card,
                             @Valid Item_Cardapio item_cardapio, BindingResult result, Model model) {
        if (result.hasErrors()) {
            item_cardapio.setId(id_card);
            return "editar-item-cardapio";
        }
        item_cardapio.setId(id_card);
        item_cardapio.setId_restaurante(id_rest);
        cardapioRepository.save(item_cardapio);
        return "redirect:/cardapio-rest/" + id_rest;
    }

    @GetMapping("/remover-cardapio/{id_rest}/{id_card}")
    public String removerCardapio(@PathVariable("id_rest") int id_rest, @PathVariable("id_card") int id_card,
                                  HttpServletRequest request) {
        Item_Cardapio item_cardapio = cardapioRepository.findById(id_card).
                orElseThrow(() -> {
                    return new IllegalArgumentException("O id do item_cardápio é inválido:" + id_card);
                });
        cardapioRepository.delete(item_cardapio);
        return "redirect:/cardapio-rest/" + id_rest;
    }
}
