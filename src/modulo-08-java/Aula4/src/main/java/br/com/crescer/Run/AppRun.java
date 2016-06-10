package br.com.crescer.Run;

import br.com.crescer.Entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppRun {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16"); 
        final EntityManager em = emf.createEntityManager();
        
        //em.getTransaction().begin();
        //em.persist(new Pessoa("Fernando"));
        //em.getTransaction().commit();
        
        //Query query = em.createQuery("SELECT p FROM PESSOA p");
        //List<Pessoa> listaPessoas = query.getResultList();
        
        //em.getTransaction().begin();
        //em.remove(new Pessoa(1, "Gustavo"));
        //em.getTransaction().commit();
    }
}
