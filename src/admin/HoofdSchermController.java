/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Pieter Pletinckx
 */
public class HoofdSchermController extends VBox implements Initializable
{
    private Model model;
    private Main application;
    
    @FXML
    private HomeController homeController;
    
    @FXML 
    private BegeleiderStageEditorController begeleiderStageEditorController;
    @FXML 
    private StudentEditorController studentEditorController;
    @FXML 
    private StageEditorController stageEditorController;
    
    //@FXML
    //private  "die andere controller"
            
    @FXML
    private VBox begeleiderStage;
    
    @FXML
    private AnchorPane overzicht;
    
    @FXML
    private AnchorPane moderatieScherm;
    
    @FXML
    private MenuItem test1;
    
    @FXML
    private MenuItem test2;  
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    void setApp(Main app)
    {
        this.application = app;
    }

    void setUpWithModel(Model model)
    {
        this.model = model;
        
        if(model == null)
            System.out.println("No Link");
        
        if(homeController == null)
            System.out.println("No controler");
        
        homeController.setUpWithModel(model);
        setChildrenHome();
    }
    private void setChildrenHome()
    {
        //debatable of ik dit niet via javafx loader kan doen
        homeController.setMaster(this);
        begeleiderStageEditorController.setMaster(this);
    }
    
    public BegeleiderStageEditorController getBegeleiderStageEditorController() //vervangen door loader
    {
        return begeleiderStageEditorController;
    }
    
    public StageEditorController getStageEditorController() //vervangen door loader
    {
        return stageEditorController;
    }
    
    public void changeView (int v)
    {
        switch (v)
        {
            case 1: 
            {
                hideAllViews();
                overzicht.setVisible(true);
            }
            break;
            case 2:
            {
                hideAllViews();
                moderatieScherm.setVisible(true);
            }
            break;
            case 3:
            {
                hideAllViews();
                begeleiderStage.setVisible(true);
            }
            break;
        }
    }
    
    private void hideAllViews()
    {
       moderatieScherm.setVisible(false);
       overzicht.setVisible(false);
       begeleiderStage.setVisible(false);
    }
    
    @FXML
    void testView1(ActionEvent Action)
    {
        changeView(1);
        System.out.println("button works");
    }
    @FXML
    void testView2(ActionEvent Action)
    {
        changeView(2);
    }
    @FXML
    void testView3(ActionEvent Action)
    {
        changeView(3);
    }
    
}
