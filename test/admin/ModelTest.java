/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import admin.model.Aspnetusers;
import admin.model.Bedrijf;
import admin.model.Bedrijfspersoon;
import admin.model.Begeleider;
import admin.model.Begeleiderstageaanvraag;
import admin.model.Gegeven;
import admin.model.Stages;
import admin.model.Student;
import admin.model.Studentstage;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pieter Pletinckx
 */
public class ModelTest {
    
    public ModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsersFromDatabase method, of class Model.
     */
    @Test
    public void testGetUsersFromDatabase() {
        System.out.println("getUsersFromDatabase");
        Model instance = new Model();
        List<Aspnetusers> expResult = null;
        
        List<Aspnetusers> result = instance.getUsersFromDatabase();
        //assertEquals(expResult, result);
        assertNotNull(instance.getUsersFromDatabase());
        
        for (Aspnetusers user: result){
            System.out.println(user.getUserName());
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getStagesFromDatabase method, of class Model.
     */
    @Test
    public void testGetStagesFromDatabase() {
        System.out.println("getStagesFromDatabase");
        Model instance = new Model();
        List<Stages> expResult = null;
        List<Stages> result = instance.getStageFromDatabase();

        // TODO review the generated test code and remove the default call to fail.
        
        for (Stages stage : result){
            System.out.println(stage.getProgrammeertaal());
        }
        
    }

    /**
     * Test of getStudentenFromDatabase method, of class Model.
     */
    @Test
    public void testGetStudentenFromDatabase() {
        System.out.println("getStudentenFromDatabase");
        Model instance = new Model();
        List<Student> expResult = null;
        List<Student> result = instance.getStudentenFromDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBedrijvenFromDatabase method, of class Model.
     */
    @Test
    public void testGetBedrijvenFromDatabase() {
        System.out.println("getBedrijvenFromDatabase");
        Model instance = new Model();
        List<Bedrijf> expResult = null;
        List<Bedrijf> result = instance.getBedrijvenFromDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBedrijfpersonenFromDatabase method, of class Model.
     */
    @Test
    public void testGetBedrijfpersonenFromDatabase() {
        System.out.println("getBedrijfpersonenFromDatabase");
        Model instance = new Model();
        List<Bedrijfspersoon> expResult = null;
        List<Bedrijfspersoon> result = instance.getBedrijfpersonenFromDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBegeleidersFromDatabase method, of class Model.
     */
    @Test
    public void testGetBegeleidersFromDatabase() {
        System.out.println("getBegeleidersFromDatabase");
        Model instance = new Model();
        List<Begeleider> expResult = null;
        List<Begeleider> result = instance.getBegeleidersFromDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBegeleiderStageAanvraagFromDatabase method, of class Model.
     */
    @Test
    public void testGetBegeleiderStageAanvraagFromDatabase() {
        System.out.println("getBegeleiderStageAanvraagFromDatabase");
        Model instance = new Model();
        List<Begeleiderstageaanvraag> expResult = null;
        List<Begeleiderstageaanvraag> result = instance.getBegeleiderStageAanvraagFromDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBegeleiderStageAanvraagOnbeslistFromDatabase method, of class Model.
     */
    @Test
    public void testGetBegeleiderStageAanvraagOnbeslistFromDatabase() {
        System.out.println("getBegeleiderStageAanvraagOnbeslistFromDatabase");
        Model instance = new Model();
        List<Begeleiderstageaanvraag> expResult = null;
        List<Begeleiderstageaanvraag> result = instance.getBegeleiderStageAanvraagOnbeslistFromDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentenStageAanvraagFromDatabase method, of class Model.
     */
    @Test
    public void testGetStudentenStageAanvraagFromDatabase() {
        System.out.println("getStudentenStageAanvraagFromDatabase");
        Model instance = new Model();
        List<Studentstage> expResult = null;
        List<Studentstage> result = instance.getStudentenStageAanvraagFromDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentenStageAanvraagOnbeslistFromDatabase method, of class Model.
     */
    @Test
    public void testGetStudentenStageAanvraagOnbeslistFromDatabase() {
        System.out.println("getStudentenStageAanvraagOnbeslistFromDatabase");
        Model instance = new Model();
        List<Studentstage> expResult = null;
        List<Studentstage> result = instance.getStudentStageAanvraagOnbeslistFromDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGegevensFromDatabase method, of class Model.
     */
    @Test
    public void testGetGegevensFromDatabase() {
        System.out.println("getGegevensFromDatabase");
        Model instance = new Model();
        List<Gegeven> expResult = null;
        List<Gegeven> result = instance.getGegevensFromDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStageFromDatabase method, of class Model.
     */
    @Test
    public void testGetStageFromDatabase() {
        System.out.println("getStageFromDatabase");
        Model instance = new Model();
        List<Stages> expResult = null;
        List<Stages> result = instance.getStageFromDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
