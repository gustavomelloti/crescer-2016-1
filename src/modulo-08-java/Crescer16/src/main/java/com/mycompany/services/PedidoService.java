package com.mycompany.services;

import FileUtils.WriterUtils;
import com.mycompany.dao.PedidoDAO;
import com.mycompany.interfaces.IGenericEntity;
import com.mycompay.entity.Pedido;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PedidoService implements IGenericEntity<Pedido> {
    PedidoDAO pDAO;
    WriterUtils writer;
    
    public PedidoService () {
        pDAO = new PedidoDAO();
        writer = new WriterUtils();
    }
    
    @Override
    public void insert(Pedido pedido) {
        pDAO.insert(pedido);
    }

    @Override
    public void update(Pedido pedido) {
        pDAO.update(pedido);
    }

    @Override
    public void delete(long id) {
        pDAO.delete(id);
    }
     
    @Override
    public List<Pedido> listAll() {
        return pDAO.listAll();
    }

    @Override
    public Pedido findById(long id) {
        return pDAO.findById(id);
    }
    
    @Override
    public void exportarCSV() {
        List<String> linhas = new ArrayList<>();
        
        linhas.add("Código;Cliente;Data Pedido;Data Entrega;Valor Pedido;Situação");
        
        for ( Pedido p : pDAO.listAll()) {
            linhas.add(
                p.getId()+ ";" +
                p.getCliente().getNome() + ";" + 
                p.getDataPedido() + ";" +
                p.getDataEntrega() + ";" +
                p.getValorPedido()+ ";" +
                p.getSituacao()+ ";" +
                "\n"
            );
        }
        
        try {
            writer.writeLines("Pedidos.csv", linhas);
        } catch (IOException ex) {
            Logger.getLogger(PedidoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
