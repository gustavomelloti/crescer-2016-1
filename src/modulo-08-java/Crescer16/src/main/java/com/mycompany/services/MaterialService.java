package com.mycompany.services;

import FileUtils.WriterUtils;
import com.mycompany.dao.MaterialDAO;
import com.mycompany.interfaces.IGenericEntity;
import com.mycompay.entity.Material;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaterialService implements IGenericEntity<Material> {
    MaterialDAO mDAO;
    WriterUtils writer;
    
    public MaterialService () {
        mDAO = new MaterialDAO();
        writer = new WriterUtils();
    }
    
    @Override
    public void exportarCSV() {
        List<String> linhas = new ArrayList<>();
        
        linhas.add("Código;Descrição;Peso Líquido;Preço Custo");
        
        for (Material m : mDAO.listAll()) {
            linhas.add(
                m.getId()+ ";" +
                m.getDescricao()+ ";" + 
                m.getPesoLiquido()+ ";" + 
                m.getPrecoCusto() + ";" +  
                "\n"
            );
        }
        
        try {
            writer.writeLines("Materiais.csv", linhas);
        } catch (IOException ex) {
            Logger.getLogger(MaterialService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Material material) {
        mDAO.insert(material);
    }

    @Override
    public void update(Material material) {
        mDAO.update(material);
    }

    @Override
    public void delete(Material material) {
        mDAO.delete(material);
    }

    @Override
    public List<Material> listAll() {
       return mDAO.listAll();
    }

    @Override
    public Material findById(long id) {
        return mDAO.findById(id);
    }
}
