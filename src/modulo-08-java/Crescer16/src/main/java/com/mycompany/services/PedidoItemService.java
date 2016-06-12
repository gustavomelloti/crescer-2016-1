package com.mycompany.services;

import FileUtils.WriterUtils;
import com.mycompany.dao.PedidoItemDAO;
import com.mycompany.interfaces.IGenericEntity;
import com.mycompay.entity.PedidoItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoItemService implements IGenericEntity<PedidoItem> {
    PedidoItemDAO piDAO;
    WriterUtils writer;
    
    public PedidoItemService () {
        piDAO = new PedidoItemDAO();
        writer = new WriterUtils();
    }
    
    @Override
    public void exportarCSV() {
        List<String> linhas = new ArrayList<>();
        
        linhas.add("Código;Produto;Quantidade;Preço Unitário; Situação");
        
        for (PedidoItem pi : piDAO.listAll()) {
            linhas.add(
                pi.getId()+ ";" +
                pi.getProduto().getNome() + ";" + 
                pi.getQuantidade() + ";" + 
                pi.getPrecoUnitario()+ ";" +   
                pi.getSituacao()+ ";" +  
                "\n"
            );
        }
        
        try {
            writer.writeLines("PedidosItem.csv", linhas);
        } catch (IOException ex) {
            Logger.getLogger(PedidoItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(PedidoItem pedidoItem) {
       piDAO.insert(pedidoItem);
    }

    @Override
    public void update(PedidoItem pedidoItem) {
       piDAO.update(pedidoItem);
    }

    @Override
    public void delete(PedidoItem pedidoItem) {
        piDAO.delete(pedidoItem);
    }

    @Override
    public List<PedidoItem> listAll() {
        return piDAO.listAll();
    }

    @Override
    public PedidoItem findById(long id) {
       return piDAO.findById(id);
    }
}
