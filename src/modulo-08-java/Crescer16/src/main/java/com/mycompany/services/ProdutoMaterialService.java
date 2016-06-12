package com.mycompany.services;

import FileUtils.WriterUtils;
import com.mycompany.dao.ProdutoMaterialDAO;
import com.mycompany.interfaces.IGenericEntity;
import com.mycompay.entity.ProdutoMaterial;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoMaterialService implements IGenericEntity<ProdutoMaterial> {
    ProdutoMaterialDAO pmDAO;
    WriterUtils writer;
    
    public ProdutoMaterialService () {
        pmDAO = new ProdutoMaterialDAO();
        writer = new WriterUtils();
    }
    
    @Override
    public void exportarCSV() {
        List<String> linhas = new ArrayList<>();
        
        linhas.add("Código;Produto;Material;Quantidade");
        
        for (ProdutoMaterial mp : pmDAO.listAll()) {
            linhas.add(
                mp.getId()+ ";" +
                mp.getProduto().getNome()+ ";" + 
                mp.getMaterial().getDescricao() + ";" + 
                mp.getQuantidade()+ ";" +     
                "\n"
            );
        }
        
        try {
            writer.writeLines("ProdutosMateriais.csv", linhas);
        } catch (IOException ex) {
            Logger.getLogger(ProdutoMaterialService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(ProdutoMaterial produtoMaterial) {
        pmDAO.insert(produtoMaterial);
    }

    @Override
    public void update(ProdutoMaterial produtoMaterial) {
        pmDAO.update(produtoMaterial);
    }

    @Override
    public void delete(ProdutoMaterial produtoMaterial) {
        pmDAO.delete(produtoMaterial);
    }

    @Override
    public List<ProdutoMaterial> listAll() {
        return pmDAO.listAll();
    }

    @Override
    public ProdutoMaterial findById(long id) {
       return pmDAO.findById(id);
    }
}
