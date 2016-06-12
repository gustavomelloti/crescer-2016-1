package com.mycompany.dao;

import com.mycompay.entity.*;

public class ProdutoItemDAO extends GenericDAO<PedidoItem> {
    
    public ProdutoItemDAO() {
        super(PedidoItem.class);
    }
}