package br.com.crescer.controller;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.service.PessoaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaRest {

    @Autowired
    PessoaService service;
      
    @RequestMapping(value = "/rest_current_date_time")
    public Date date() {
        return new Date();
    }

    @RequestMapping(value = "/rest_pessoa")
    public List<Pessoa> list() {
        return new ArrayList<>();
    }
}
