
package br.com.crescer.controller;

import br.com.crescer.entity.Cidade;
import br.com.crescer.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cidade")
public class CidadeController {
    
    private final int qtdCidadesPorRequisicao = 20;
    
    @Autowired
    CidadeService service;
    
    @RequestMapping(value = "/",  method = RequestMethod.GET)
    public String index() {
        return "cidade/listar_cidade";
    }
    
    @ResponseBody
    @RequestMapping(value = "/listar",  method = RequestMethod.GET)
    public ModelAndView listar(@RequestParam int pagina, Model model) {
        model.addAttribute("cidades", service.findAllPagined(pagina, qtdCidadesPorRequisicao));
        return new ModelAndView("cidade/_estrutura_cidade_list");
    }
    
    @RequestMapping(value = "cadastrar", method = RequestMethod.GET)
    public String cadastrar(Model model) {
        model.addAttribute("cidade", new Cidade());
        return "cidade/manter_cidade";
    }
    
    @RequestMapping(value = "editar", method = RequestMethod.GET)
    public String editar(@RequestParam long id, Model model) {
        model.addAttribute("cidade", service.findById(id));
        return "cidade/manter_cidade";
    }
    
    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public String salvar(@ModelAttribute Cidade c, Model model) {
        service.save(c);
        return index();
    }
    
    @RequestMapping(value = "deletar", method = RequestMethod.POST)
    public String salvar(long id, Model model) {
        service.delete(id);
        return index();
    }    
}
