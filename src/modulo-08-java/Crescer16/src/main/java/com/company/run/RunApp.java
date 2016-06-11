package com.company.run;

import com.mycompay.entity.Cidade;
import com.mycompay.entity.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunApp {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();
    
    public static void main(String[] args) {
        Cliente cliente = em.find(Cliente.class, 2l);
        System.out.println(cliente.getNome());
    }
}
