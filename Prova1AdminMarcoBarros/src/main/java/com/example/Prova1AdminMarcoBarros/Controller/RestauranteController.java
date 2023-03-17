package com.example.Prova1AdminMarcoBarros.Controller;

import com.example.Prova1AdminMarcoBarros.Model.Cardapio;
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
import java.util.Collections;


@Controller
public class RestauranteController {
    private static final String SESSION_CARDAPIOS = "sessionCardapios";
    @Autowired
    RestauranteRepository restauranteRepository;
    @Autowired
    CardapioRepository cardapioRepository;

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

    @GetMapping("/cardapio-rest")
    public String mostrarCardapioRestaurante(@PathVariable("id") int id, Model model) {
        ArrayList<Cardapio> cardapios = (ArrayList<Cardapio>) cardapioRepository.findAll();
        if (!cardapios.isEmpty()) {
            for (Cardapio c : cardapios) {
                if (c.getId_restaurante() != id) {
                    cardapios.remove(c);
                }
            }
        }
        model.addAttribute("cardapios", cardapios);
        model.addAttribute("idRest", id);
        return "cardapio";
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
        ArrayList<Cardapio> cardapios = (ArrayList<Cardapio>) cardapioRepository.findAll();
        if (!cardapios.isEmpty()) {
            for (Cardapio c : cardapios) {
                if (c.getId_restaurante() == id) {
                    cardapios.remove(c);
                }
            }
        }
        restauranteRepository.delete(restaurante);
        return "redirect:/index";
    }
}
