
package br.com.crescer.controller;

import br.com.crescer.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cidade")
public class CidadeController {
    @Autowired
    CidadeService service;
    
    @RequestMapping(value = "/",  method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("cidades", service.findAll());
        return "cidade/listar-cidade";
    }
}
