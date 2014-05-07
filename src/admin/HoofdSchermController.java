/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Pieter Pletinckx
 */
public class HoofdSchermController extends VBox implements Initializable {
    private Model model;
    private Main application;
    
    /**
     * Controllers
     */
    @FXML
    private OverzichtController overzichtController;
    
    //@FXML
    //private  "die andere controller"
       
    /**
     * Views
     */
    @FXML
    private AnchorPane overzicht ;
    
    @FXML
    private AnchorPane moderatieScherm;
    
    /**
     * Andere Elementen
     */
    @FXML
    private TitledPane takenlijst;

    
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setApp(Main app) {
        this.application=app;
    }

    void setUpWithModel(Model model) {
        this.model = model;
        if(model==null) System.out.println("No Link");
        if(overzichtController==null) System.out.println("No controler");
        overzichtController.setUpWithModel(model);
    }
    
}
