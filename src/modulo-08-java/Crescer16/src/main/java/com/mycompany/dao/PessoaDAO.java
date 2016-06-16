package com.mycompany.dao;

import com.mycompay.entity.*;

public class PessoaDAO extends GenericDAO<Pessoa> {
    
    public PessoaDAO() {
        super(Pessoa.class);
    }
}