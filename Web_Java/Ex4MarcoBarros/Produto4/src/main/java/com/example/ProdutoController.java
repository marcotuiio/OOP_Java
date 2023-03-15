package com.example;

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

import java.util.HashMap;

@Controller
public class ProdutoController {
    private static final String SESSION_FAVORITOS = "sessionFavoritos";
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/novo-produto")
    public String mostrarFormNovoProduto(Produto produto) {
        return "novo-produto";
    }

    @PostMapping("/adicionar-produto")
    public String adicionarProduto(@Valid Produto produto, BindingResult result) {
        if (result.hasErrors()) { return "novo-produto"; }
        produtoRepository.save(produto);
        return "redirect:/novo-produto";
    }

    @GetMapping(value={"/index", "/"})
    public String mostrarListaProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "index";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormAtualizar(@PathVariable("id") int id, Model model) {
        Produto produto = produtoRepository.findById(id).
                orElseThrow(() -> {
                    return new IllegalArgumentException("O id do produto é inválido:" + id);
                });
        model.addAttribute("produto", produto);
        return "atualizar-produto";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarProduto(@PathVariable("id") int id, @Valid Produto produto,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            produto.setId(id);
            return "atualizar-produto";
        }
        produtoRepository.save(produto);
        return "redirect:/index";
    }

    @GetMapping("/remover/{id}")
    public String removerProduto(@PathVariable("id") int id, HttpServletRequest request) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id do produto é inválido:" + id));

        produtoRepository.delete(produto);
        HashMap<Produto, ProdutoCarrinho> favoritos =
                (HashMap<Produto, ProdutoCarrinho>) request.getSession().getAttribute(SESSION_FAVORITOS);
        if (!CollectionUtils.isEmpty(favoritos)) {
            favoritos.remove(produto);
        }
        request.getSession().setAttribute(SESSION_FAVORITOS, favoritos);
        return "redirect:/index";
    }

    @GetMapping(value={"/favoritar/{id}", "/addCarrinho/{id}"})
    public String favoritarProduto(@PathVariable("id") int id, HttpServletRequest request){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id do produto é inválido:" + id));

        HashMap<Produto, ProdutoCarrinho> favoritos =
                (HashMap<Produto, ProdutoCarrinho>) request.getSession().getAttribute(SESSION_FAVORITOS);
        if (favoritos == null) {
            favoritos = new HashMap<>();
        }

        ProdutoCarrinho produtoCarrinho = favoritos.get(produto);
        if (produtoCarrinho == null) {
            produtoCarrinho = new ProdutoCarrinho(produto, 0);
        }

        if (produto.getQuantidade() > produtoCarrinho.getQuantidade()) {
            produtoCarrinho.setQuantidade(produtoCarrinho.getQuantidade() + 1);
            favoritos.put(produto, produtoCarrinho);
        }

        request.getSession().setAttribute(SESSION_FAVORITOS, favoritos);
        return "redirect:/favoritos";
    }

    @GetMapping("/desfavoritar/{id}")
    public String desfavoritarProduto(@PathVariable("id") int id, HttpServletRequest request){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id do produto é inválido:" + id));

        HashMap<Produto, ProdutoCarrinho> favoritos = (HashMap<Produto, ProdutoCarrinho>) request.getSession().getAttribute(SESSION_FAVORITOS);

        favoritos.remove(produto);
        request.getSession().setAttribute(SESSION_FAVORITOS, favoritos);
        return "redirect:/favoritos";
    }

    @GetMapping("/favoritos")
    public String mostrarFavoritos(Model model, HttpServletRequest request){
        HashMap<Produto, ProdutoCarrinho> favoritos = (HashMap<Produto, ProdutoCarrinho>) request.getSession().getAttribute(SESSION_FAVORITOS);
        model.addAttribute("sessionFavoritos",
                !CollectionUtils.isEmpty(favoritos) ? favoritos : new HashMap<>());

        return "favoritos";
    }

    @GetMapping(value={"/subCarrinho/{id}"})
    public String removeUmCarrinho(@PathVariable("id") int id, HttpServletRequest request){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id do produto é inválido:" + id));

        HashMap<Produto, ProdutoCarrinho> favoritos = (HashMap<Produto, ProdutoCarrinho>) request.getSession().getAttribute(SESSION_FAVORITOS);

        ProdutoCarrinho produtoCarrinho = favoritos.get(produto);

        if (produtoCarrinho.getQuantidade() > 1) {
            produtoCarrinho.setQuantidade(produtoCarrinho.getQuantidade() - 1);
            favoritos.put(produto, produtoCarrinho);
        } else if (produtoCarrinho.getQuantidade() == 1) {
            favoritos.remove(produto);
        }

        request.getSession().setAttribute(SESSION_FAVORITOS, favoritos);
        return "redirect:/favoritos";
    }

}