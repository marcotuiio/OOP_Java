package com.example.RegisterSql;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class ContatoController {

    private static final String SESSION_FAVORITOS = "sessionFavoritos";

    @Autowired // injeção de dependências, o framework cria e gerencia este atributo
    ContatoRepository contatoRepository;

    @GetMapping("/novo-contato")
    public String mostrarFormNovoContato(Contato contato){
        return "novo-contato";
    }

    @PostMapping("/adicionar-contato")
    public String adicionarContato(@Valid Contato contato,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return "/novo-contato";
        }
        contatoRepository.save(contato);
        return "redirect:/novo-contato";
    }

    @GetMapping(value={"/index", "/"})
    public String mostrarListaContatos(Model model) {
        model.addAttribute("contatos", contatoRepository.findAll());
        return "index";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormAtualizar(@PathVariable("id") int id, Model model) {
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id do contato é inválido:" + id));
        model.addAttribute("contato", contato);
        return "atualizar-contato";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarContato(@PathVariable("id") int id, @Valid Contato contato,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            contato.setId(id);
            return "atualizar-contato";
        }
        contatoRepository.save(contato);
        return "redirect:/index";
    }

    @GetMapping("/remover/{id}")
    public String removerContato(@PathVariable("id") int id, HttpServletRequest request) {
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id do contato é inválido:" + id));
        contatoRepository.delete(contato);
        HashSet<Contato> favoritos = (HashSet<Contato>) request.getSession().getAttribute(SESSION_FAVORITOS);
        favoritos.remove(contato);

        return "redirect:/index";
    }

    @GetMapping("/favoritar/{id}")
    public String favoritarContato(@PathVariable("id") int id, HttpServletRequest request){
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id do contato é inválido: " + id));

        HashSet<Contato> favoritos = (HashSet<Contato>) request.getSession().getAttribute(SESSION_FAVORITOS);
        if (CollectionUtils.isEmpty(favoritos)) {
            favoritos = new HashSet<>();
        }

        favoritos.add(contato);
        request.getSession().setAttribute(SESSION_FAVORITOS, favoritos);
        return "redirect:/favoritos";
    }

    @GetMapping("/desfavoritar/{id}")
    public String desfavoritarContato(@PathVariable("id") int id, HttpServletRequest request) {
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id do contato é inválido:" + id));
        HashSet<Contato> favoritos = (HashSet<Contato>) request.getSession().getAttribute(SESSION_FAVORITOS);
        favoritos.remove(contato);

        return "redirect:/index";
    }
    @GetMapping("/favoritos")
    public String mostrarFavoritos(Model model, HttpServletRequest request){
        HashSet<Contato> favoritos = (HashSet<Contato>) request.getSession().getAttribute(SESSION_FAVORITOS);
        model.addAttribute("sessionFavoritos",
                !CollectionUtils.isEmpty(favoritos) ? favoritos : new HashSet<>());

        return "favoritos";
    }

}