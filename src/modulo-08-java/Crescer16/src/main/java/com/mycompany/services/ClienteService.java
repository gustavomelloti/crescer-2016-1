package com.mycompany.services;

import FileUtils.WriterUtils;
import com.mycompany.dao.ClienteDAO;
import com.mycompany.interfaces.IGenericEntity;
import com.mycompay.entity.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteService implements IGenericEntity<Cliente>{
    ClienteDAO cDAO;
    WriterUtils writer;
    
    public ClienteService () {
        cDAO = new ClienteDAO();
        writer = new WriterUtils();
    }
    
    @Override
    public void exportarCSV() {
        List<String> linhas = new ArrayList<>();
        
        linhas.add("Código;Nome;Razão Social;Endereço;Bairro;Cidade;Cep;Situação");
        
        for (Cliente c : cDAO.listAll()) {
            linhas.add(
                c.getId()+ ";" +
                c.getNome() + ";" + 
                c.getRazaoSocial() + ";" + 
                c.getEndereco() + ";" + 
                c.getBairro() + ";" + 
                c.getCidade().getNome() + ";" + 
                c.getCep() + ";" + 
                c.getSituacao() + ";" + 
                "\n"
            );
        }
        
        try {
            writer.writeLines("Clientes.csv", linhas);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Cliente cliente) {
        cDAO.insert(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        cDAO.update(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
       cDAO.delete(cliente);
    }

    @Override
    public List<Cliente> listAll() {
       return cDAO.listAll();
    }

    @Override
    public Cliente findById(long id) {
        return cDAO.findById(id);
    }
}
