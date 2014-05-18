package admin;

import admin.model.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Model
{
    EntityManagerFactory emf;
    EntityManager em;
    
    public Model()
    {
        emf = Persistence.createEntityManagerFactory("ProjectJavaPU");
        em = emf.createEntityManager();
    }
    
    public List <Aspnetusers> getUsersFromDatabase()
    {
        TypedQuery<Aspnetusers> query = em.createNamedQuery("Aspnetusers.findAll", Aspnetusers.class);
        return query.getResultList();
    }
    
    public List <Bedrijf> getBedrijvenFromDatabase()
    {
          TypedQuery<Bedrijf> query = em.createNamedQuery("Bedrijf.findAll", Bedrijf.class);
          return query.getResultList();
    }
    
    public List <Bedrijfspersoon> getBedrijfpersonenFromDatabase()
    {
          TypedQuery<Bedrijfspersoon> query = em.createNamedQuery("Bedrijfspersoon.findAll", Bedrijfspersoon.class);
          return query.getResultList();
    }
    
    public List <Begeleider> getBegeleidersFromDatabase()
    {
        TypedQuery<Begeleider> query = em.createNamedQuery("Begeleider.findAll", Begeleider.class);
        return query.getResultList();
    }
    
    public List <Begeleiderstageaanvraag> getBegeleiderStageAanvraagFromDatabase()
    {
        TypedQuery<Begeleiderstageaanvraag> query = em.createNamedQuery("Begeleiderstageaanvraag.findAll", Begeleiderstageaanvraag.class);
        return query.getResultList();
    }  
    
    public List <Begeleiderstageaanvraag> getBegeleiderStageAanvraagOnbeslistFromDatabase()
    {
        TypedQuery<Begeleiderstageaanvraag> query = em.createNamedQuery("Begeleiderstageaanvraag.findNogNietBeslist", Begeleiderstageaanvraag.class);
        return query.getResultList();
    }
    
    public List <Studentstagesollicitatie> getStudentenStageAanvraagFromDatabase()
    {
        TypedQuery<Studentstagesollicitatie> query = em.createNamedQuery("Studentstagesollicitatie.findAll", Studentstagesollicitatie.class);
        return query.getResultList();
    }
    
    public List <Studentstagesollicitatie> getStudentenStageAanvraagOnbeslistFromDatabase()
    {
        TypedQuery<Studentstagesollicitatie> query = em.createNamedQuery("Studentstagesollicitatie.findNogNietBeslist", Studentstagesollicitatie.class);
        return query.getResultList();
    }    
    
    public List <Gegeven> getGegevensFromDatabase()
    {
        TypedQuery<Gegeven> query = em.createNamedQuery("Gegeven.findAll", Gegeven.class);
        return query.getResultList();
    }
    
    public List <Stage> getStageFromDatabase()
    {
        TypedQuery<Stage> query = em.createNamedQuery("Stage.findAll", Stage.class);
        return query.getResultList();
    }
    
    public List <Student> getStudentenFromDatabase()
    {
        TypedQuery<Student> query = em.createNamedQuery("Student.findAll", Student.class);
        return query.getResultList();
    }
}
