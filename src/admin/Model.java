/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import admin.model.*;
import java.util.List;
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
        //verplaats dit op een andere thread      
        TypedQuery<Aspnetusers> queryAspnetusers = em.createNamedQuery("Aspnetusers.findAll", Aspnetusers.class);
        return queryAspnetusers.getResultList();
    }
    public List <Stage> getStagesFromDatabase(){
        //verplaats dit op een andere thread      
        TypedQuery<Stage> queryAspnetusers = em.createNamedQuery("Stage.findAll", Stage.class);
        return queryAspnetusers.getResultList();
    }
    public List <Student> getStudentenFromDatabase(){
        //verplaats dit op een andere thread      
        TypedQuery<Student> queryAspnetusers = em.createNamedQuery("Student.findAll", Student.class);
        return queryAspnetusers.getResultList();
    }
    
    
}
