package com.mycompany.services;

import FileUtils.WriterUtils;
import com.mycompany.dao.PessoaDAO;
import com.mycompany.interfaces.IGenericEntity;
import com.mycompay.entity.Pessoa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PessoaService implements IGenericEntity<Pessoa> {
    PessoaDAO pDAO;
    WriterUtils writer;
    
    public PessoaService () {
        pDAO = new PessoaDAO();
        writer = new WriterUtils();
    }
    
    @Override
    public void insert(Pessoa pessoa) {
        pDAO.insert(pessoa);
    }

    @Override
    public void update(Pessoa pessoa) {
        pDAO.update(pessoa);
    }

    @Override
    public void delete(long id) {
        pDAO.delete(id);
    }
     
    @Override
    public List<Pessoa> listAll() {
        return pDAO.listAll();
    }

    @Override
    public Pessoa findById(long id) {
        return pDAO.findById(id);
    }
    
    @Override
    public void exportarCSV() {
        List<String> linhas = new ArrayList<>();
        
        linhas.add("Código;Nome;Idade");
        
        for ( Pessoa p : pDAO.listAll()) {
            linhas.add(
                p.getId()+ ";" +
                p.getNome() + ";" + 
                p.getIdade()+ ";" +
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
