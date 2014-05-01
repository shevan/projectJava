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
    
    public List <Aspnetusers> getUsersFromDatabase(){
        //verplaats dit op een andere thread        
        emf = Persistence.createEntityManagerFactory("ProjectJavaPU");
        em = emf.createEntityManager();

        TypedQuery<Aspnetusers> queryAspnetusers = em.createNamedQuery("Aspnetusers.findAll", Aspnetusers.class);
        return queryAspnetusers.getResultList();
    }
}
