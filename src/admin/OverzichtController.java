/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Pieter Pletinckx
 */
public class OverzichtController extends AnchorPane implements Initializable {



    /**
     * Initializes the controller class.
     */
    
    private Main application;
    
    public void setApp(Main application)
    {
    this.application = application;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
