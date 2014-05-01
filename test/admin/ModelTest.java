/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import admin.model.Aspnetusers;
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
    
}
