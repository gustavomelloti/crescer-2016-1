package br.com.crescer.controller;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pessoa/")
public class PessoaController {
    
    @Autowired
    PessoaService service;
    
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "nova", method = RequestMethod.GET)
    public String nova(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "cadastro_pessoa";
    }
    
    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public String salvar(@ModelAttribute Pessoa p, Model model) {
        service.save(p);
        return "index";
    }
    
    @RequestMapping(value = "remover")
    public String nova(@ModelAttribute long id, Model model) {
        service.delete(id);
        return "index";
    }
}
