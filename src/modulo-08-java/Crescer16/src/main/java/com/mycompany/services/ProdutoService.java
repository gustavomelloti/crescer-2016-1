package com.mycompany.services;

import FileUtils.WriterUtils;
import com.mycompany.dao.ProdutoDAO;
import com.mycompany.interfaces.IGenericEntity;
import com.mycompay.entity.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoService implements IGenericEntity<Produto> {
    ProdutoDAO pDAO;
    WriterUtils writer;
    
    public ProdutoService () {
        pDAO = new ProdutoDAO();
        writer = new WriterUtils();
    }
    
    @Override
    public void exportarCSV() {
        List<String> linhas = new ArrayList<>();
        
        linhas.add("Código;Nome;Data Cadastro;Preço Custo;Preço Venda;Situação");
        
        for (Produto p : pDAO.listAll()) {
            linhas.add(
                p.getId()+ ";" +
                p.getNome() + ";" + 
                p.getData() + ";" + 
                p.getPrecoCusto() + ";" +
                p.getPrecoVenda()+ ";" +
                p.getSituacao()+ ";" +       
                "\n"
            );
        }
        
        try {
            writer.writeLines("Produtos.csv", linhas);
        } catch (IOException ex) {
            Logger.getLogger(ProdutoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Produto produto) {
        pDAO.insert(produto);
    }

    @Override
    public void update(Produto produto) {
       pDAO.update(produto);
    }

    @Override
    public void delete(long id) {
        pDAO.delete(id);
    }

    @Override
    public List<Produto> listAll() {
       return pDAO.listAll();
    }

    @Override
    public Produto findById(long id) {
        return pDAO.findById(id);
    }
}
