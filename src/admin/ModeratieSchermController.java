/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Pieter Pletinckx
 */
public class ModeratieSchermController implements Initializable {
 private Pane master;
 private Main application;
 private Model model;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    public void setApp(Main application)
    {
        this.application = application;
    }
    public void setMaster(Pane master) //algemeen omdat "HoofdSchermController" niet te strikt is
    {
        this.master = master;
    }
     
    
}
