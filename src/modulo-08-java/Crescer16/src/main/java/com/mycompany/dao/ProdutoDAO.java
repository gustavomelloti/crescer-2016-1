package com.mycompany.dao;

import com.mycompay.entity.Produto;

public class ProdutoDAO extends GenericDAO<Produto>{

    public ProdutoDAO() {
        super(Produto.class);
    }
}
