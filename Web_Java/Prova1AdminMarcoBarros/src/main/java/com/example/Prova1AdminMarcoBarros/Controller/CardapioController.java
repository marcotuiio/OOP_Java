//    package com.example.Prova1AdminMarcoBarros.Controller;
//
//    import com.example.Prova1AdminMarcoBarros.Model.Cardapio;
//    import com.example.Prova1AdminMarcoBarros.Model.Restaurante;
//    import jakarta.servlet.http.HttpServletRequest;
//    import jakarta.validation.Valid;
//    import org.springframework.beans.factory.annotation.Autowired;
//    import org.springframework.stereotype.Controller;
//    import org.springframework.ui.Model;
//    import org.springframework.validation.BindingResult;
//    import org.springframework.web.bind.annotation.GetMapping;
//    import org.springframework.web.bind.annotation.PathVariable;
//    import org.springframework.web.bind.annotation.PostMapping;
//    import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//    @Controller
//    public class CardapioController {
//        private static final String SESSION_CARDAPIOS = "sessionCardapios";
//        @Autowired
//        CardapioRepository cardapioRepository;
//
//        @GetMapping("/novo-item-cardapio/{id_rest}")
//        public String mostrarFormNovoItemCardapio(@PathVariable("id_rest") int id, Cardapio cardapio, RedirectAttributes attributes) {
//            attributes.addAttribute("id_rest", id);
//            return "novo-item-cardapio";
//        }
//
//        @PostMapping("/adicionar-item-cardapio")
//        public String adicionarItemCardapio(@Valid Cardapio cardapio, BindingResult result, RedirectAttributes attributes) {
//            if (result.hasErrors()) { return "novo-item-cardapio"; }
//            int id_rest = (Integer) attributes.getAttribute("id_rest");
//            cardapio.setId_restaurante(id_rest);
//            cardapioRepository.save(cardapio);
//            return "redirect:/novo-item-cardapio";
//        }
//
//        @GetMapping("/editar-cardapio/{id}")
//        public String mostrarFormEditarCardapio(@PathVariable("id") int id, Model model) {
//            Cardapio cardapio = cardapioRepository.findById(id).
//                    orElseThrow(() -> {
//                        return new IllegalArgumentException("O id do cardapio é inválido:" + id);
//                    });
//            model.addAttribute("item_cardapio", cardapio);
//            return "editar-item-cardapio";
//        }
//
//        @PostMapping("/atualizar-cardapio/{id}")
//        String atualizarCardapio(@PathVariable("id") int id, @Valid Cardapio cardapio,
//                                              BindingResult result, Model model) {
//            if (result.hasErrors()) {
//                cardapio.setId(id);
//                return "editar-item-cardapio";
//            }
//            cardapioRepository.save(cardapio);
//            return "redirect:/cardapio";
//        }
//
//        @GetMapping("/remove-cardapio/{id}")
//        public String removerCardapio(@PathVariable("id") int id, HttpServletRequest request) {
//            Cardapio cardapio = cardapioRepository.findById(id).
//                    orElseThrow(() -> {
//                        return new IllegalArgumentException("O id do cardápio é inválido:" + id);
//                    });
//            cardapioRepository.delete(cardapio);
//            return "redirect:/cardapio";
//        }
//    }
