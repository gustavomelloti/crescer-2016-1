package com.mycompany.dao;

import com.mycompay.entity.Pedido;

public class PedidoDAO extends GenericDAO<Pedido>{
    
    public PedidoDAO() {
        super(Pedido.class);
    }
    
    @Override
    public void delete(long id) {
        Pedido p = super.findById(id);
        
        super.transaction.begin();
            p.getPedidoItem().forEach(produtoItem -> super.em.remove(produtoItem));
            super.em.remove(p);
        super.transaction.commit();
    }
}
