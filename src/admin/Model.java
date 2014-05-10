/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
/**
 *
 * @author Pieter Pletinckx
 * Model gaat over databank toegang, uiteindelijk met Task uit concurrency
 */
public class Model {
    EntityManagerFactory emf;
    EntityManager em;
    
    public Model()
    {
        emf = Persistence.createEntityManagerFactory("ProjectJavaPU");
        em = emf.createEntityManager();
    }
    
    public List <Aspnetusers> getUsersFromDatabase(){
        TypedQuery<Aspnetusers> qurey = em.createNamedQuery("Aspnetusers.findAll", Aspnetusers.class);
        return qurey.getResultList();
    }
    
    public List <Bedrijf> getBedrijvenFromDatabase(){
          TypedQuery<Bedrijf> qurey = em.createNamedQuery("Bedrijf.findAll", Bedrijf.class);
          return qurey.getResultList();
    }
    
    public List <Bedrijfspersoon> getBedrijfpersonenFromDatabase(){
          TypedQuery<Bedrijfspersoon> qurey = em.createNamedQuery("Bedrijfspersoon.findAll", Bedrijfspersoon.class);
          return qurey.getResultList();
    }
    
    public List <Begeleider> getBegeleidersFromDatabase(){
        TypedQuery<Begeleider> qurey = em.createNamedQuery("Begeleider.findAll", Begeleider.class);
        return qurey.getResultList();
    }
    
    public List <Begeleiderstageaanvraag> getBegeleiderStageAanvraagFromDatabase(){
        TypedQuery<Begeleiderstageaanvraag> qurey = em.createNamedQuery("Begeleiderstageaanvraag.findAll", Begeleiderstageaanvraag.class);
        return qurey.getResultList();
    }
    
    public List <Gegeven> getGegevensFromDatabase(){
        TypedQuery<Gegeven> qurey = em.createNamedQuery("Gegeven.findAll", Gegeven.class);
        return qurey.getResultList();
    }
    
    public List <Stage> getStageFromDatabase(){
        TypedQuery<Stage> qurey = em.createNamedQuery("Stage.findAll", Stage.class);
        return qurey.getResultList();
    }
    
    public List <Student> getStudentenFromDatabase(){
        TypedQuery<Student> qurey = em.createNamedQuery("Student.findAll", Student.class);
        return qurey.getResultList();
    }
    
    public List <Studentstagesollicitatie> getStudentStageSollicitatieFromDatabase(){
        TypedQuery<Studentstagesollicitatie> qurey = em.createNamedQuery("Studentstagesollicitatie.findAll", Studentstagesollicitatie.class);
        return qurey.getResultList();
    }
}
