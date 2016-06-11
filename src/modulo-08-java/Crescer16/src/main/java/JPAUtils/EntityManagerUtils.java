package JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16"); 
    private static final EntityManager em = emf.createEntityManager();

    public static EntityManager createEntityManager() {
        return em;
    }
}
