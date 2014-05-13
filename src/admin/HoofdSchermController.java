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
    
    @FXML
    private OverzichtController overzichtController;
    
    @FXML 
    private BegeleiderStageController begeleiderStageController;
    
    @FXML 
    private ModeratieSchermController moderatieSchermController;
    
    //@FXML
    //private  "die andere controller"
            
    @FXML
    private VBox begeleiderStage;
    
    @FXML
    private AnchorPane overzicht;
    
    @FXML
    private AnchorPane moderatieScherm;
    
    
    


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
        setChildrenHome();
    }
    private void setChildrenHome()
    { //debatable of ik dit niet via javafx loader kan doen
        overzichtController.setMaster(this);
    }
    
    public BegeleiderStageController getBSControler() //vervangen door loader
    {
        return begeleiderStageController;
    }
    
    public void veranderView (int v)
    {
        switch (v)
        {
            case 1: 
            {
                hideAllViews();
                overzicht.visibleProperty().set(true);
            }
            case 2:
            {
                hideAllViews();
                moderatieScherm.visibleProperty().set(true);
            }
            case 3:
            {
                hideAllViews();
                begeleiderStage.visibleProperty().set(true);
            }
        }
    }
    
    private void hideAllViews()
    {
        moderatieScherm.visibleProperty().set(false);
        overzicht.visibleProperty().set(false);
        begeleiderStage.visibleProperty().set(false);
    }

    
}
