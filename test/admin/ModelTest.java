/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import admin.model.Aspnetusers;
import admin.model.Stage;
import admin.model.Student;
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
    public void testGetStagesFromDatabase()
    {
        System.out.println("getStagesFromDatabase");
        Model instance = new Model();
        List<Stage> expResult = null;
        List<Stage> result = instance.getStagesFromDatabase();

        // TODO review the generated test code and remove the default call to fail.
        
        for (Stage stage : result){
            System.out.println(stage.getProgrammeertaal());
        }
        
    }

    /**
     * Test of getStudentenFromDatabase method, of class Model.
     */
    @Test
    public void testGetStudentenFromDatabase()
    {
        System.out.println("getStudentenFromDatabase");
        Model instance = new Model();
        List<Student> expResult = null;
        List<Student> result = instance.getStudentenFromDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
