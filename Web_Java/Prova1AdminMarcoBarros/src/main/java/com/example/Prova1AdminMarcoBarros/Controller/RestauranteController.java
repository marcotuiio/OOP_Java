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

import java.util.ArrayList;


@Controller
public class RestauranteController {
    @Autowired
    RestauranteRepository restauranteRepository;
    @Autowired
    Item_CardapioRepository cardapioRepository;

    @GetMapping("/novo-restaurante")
    public String mostarFormNovoRestaurante(Restaurante restaurante) {
        return "novo-restaurante";
    }

    @PostMapping("/adicionar-restaurante")
    public String adicionarRestaurante(@Valid Restaurante restaurante, BindingResult result) {
        if (result.hasErrors()) { return "novo-restaurante"; }
        restauranteRepository.save(restaurante);
        return "redirect:/novo-restaurante";
    }

    @GetMapping(value = {"/index", "/"})
    public String mostrarRestaurantes(Model model) {
        model.addAttribute("restaurantes", restauranteRepository.findAll());
        return "index";
    }

    @GetMapping("/editar-rest/{id}")
    public String mostrarFormEditarRestaurante(@PathVariable("id") int id, Model model) {
        Restaurante restaurante = restauranteRepository.findById(id).
                orElseThrow(() -> {
                    return new IllegalArgumentException("O id do restaurante é inválido:" + id);
                });
        model.addAttribute("restaurante", restaurante);
        return "editar-restaurante";
    }

    @PostMapping("/atualizar-rest/{id}")
    public String atualizarRestaurante(@PathVariable("id") int id, @Valid Restaurante restaurante,
                                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            restaurante.setId(id);
            return "editar-restaurante";
        }
        restauranteRepository.save(restaurante);
        return "redirect:/index";
    }

    @GetMapping("/remover-rest/{id}")
    public String removerRestaurante(@PathVariable("id") int id, HttpServletRequest request) {
        Restaurante restaurante = restauranteRepository.findById(id).
                orElseThrow(() -> {
                    return new IllegalArgumentException("O id do restaurante é inválido:" + id);
                });
        ArrayList<Item_Cardapio> cardapios = (ArrayList<Item_Cardapio>) cardapioRepository.findAll();
        for (Item_Cardapio c : cardapios) {
            if (c.getId_restaurante() == id) {
                cardapioRepository.delete(c);
            }
        }
        restauranteRepository.delete(restaurante);
        return "redirect:/index";
    }

    @GetMapping("/cardapio-rest/{id}")
    public String mostrarCardapioRestaurante(@PathVariable("id") int id, Model model) {

        ArrayList<Item_Cardapio> cardapios = (ArrayList<Item_Cardapio>) cardapioRepository.findAll();
        ArrayList<Item_Cardapio> cardapio_restaurant = new ArrayList<>();

        for (Item_Cardapio c : cardapios) {
            if (c.getId_restaurante() == id) {
                cardapio_restaurant.add(c);
            }
        }

        Restaurante restaurante = restauranteRepository.findById(id).
                orElseThrow(() -> {
                    return new IllegalArgumentException("O id do restaurante é inválido:" + id);
                });

        model.addAttribute("cardapios", cardapio_restaurant);
        model.addAttribute("idRest", id);
        model.addAttribute("nomeRest", restaurante.getNome());
        return "cardapio";
    }

}
