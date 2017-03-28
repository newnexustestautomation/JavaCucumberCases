package database.acties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Tester on 3/28/2017.
 */
public class DatabaseActies {

    private static DatabaseActies ourInstance;
public boolean valid= false;
    public boolean Init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        valid = true;
        return true;
    }



    public static DatabaseActies getInstance() {
        if(ourInstance==null)
            ourInstance = new DatabaseActies();
        return ourInstance;
    }

    public boolean accountAanwezig(String email){

        return false;
    }

}
