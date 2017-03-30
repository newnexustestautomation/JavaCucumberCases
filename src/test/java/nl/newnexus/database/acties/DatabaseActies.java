package nl.newnexus.database.acties;

import nl.newnexus.database.entiteiten.Customers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by Tester on 3/28/2017.
 */
public class DatabaseActies {

    private static DatabaseActies ourInstance;
    public boolean valid= false;
    private EntityManager em = null;

    public boolean init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        em = emf.createEntityManager();
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
        if(valid==false) {
            System.out.println("Geen databaseconnectie gemaakt (aanroepen init!)");
            return false;
        }
        Customers customers = new Customers();
            Query query = em.createNativeQuery("select count(c) from Customers c where c.customersEmailAddress = '"+ email+"'" );
        if((Integer)query.getResultList().get(0)>=1)
            return true;
        return false;
    }

}
