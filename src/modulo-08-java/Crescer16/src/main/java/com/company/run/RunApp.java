package com.company.run;

import com.mycompay.entity.Cidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunApp {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();
    
    public static void main(String[] args) {
        Cidade cidade = em.find(Cidade.class, 2l);
        System.out.println(cidade.getNome());
    }
}
