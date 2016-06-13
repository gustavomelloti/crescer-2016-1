package com.mycompany.services;

import FileUtils.WriterUtils;
import com.mycompany.dao.CidadeDAO;
import com.mycompany.interfaces.IGenericEntity;
import com.mycompay.entity.Cidade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CidadeService implements IGenericEntity<Cidade>{
    CidadeDAO cDAO;
    WriterUtils writer;
    
    public CidadeService () {
        cDAO = new CidadeDAO();
        writer = new WriterUtils();
    }

    @Override
    public void insert(Cidade cidade) {
        cDAO.insert(cidade);
    }

    @Override
    public void update(Cidade cidade) {
        cDAO.update(cidade);
    }

    @Override
    public void delete(long id) {
        cDAO.delete(id);
    }

    @Override
    public List<Cidade> listAll() {
        return cDAO.listAll();
    }

    @Override
    public Cidade findById(long id) {
        return cDAO.findById(id);
    }

    @Override
    public void exportarCSV() {
        List<String> linhas = new ArrayList<>();
        
        linhas.add("Código;Nome;UF");
        
        for ( Cidade c : cDAO.listAll()) {
            linhas.add(
                c.getId()+ ";" +
                c.getNome() + ";" + 
                c.getUf() + 
                "\n"
            );
        }
        
        try {
            writer.writeLines("Cidades.csv", linhas);
        } catch (IOException ex) {
            Logger.getLogger(CidadeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
