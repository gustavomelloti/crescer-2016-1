package com.mycompany.dao;

import com.mycompay.entity.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {
    public ClienteDAO() {
        super(Cliente.class);
    }
}
