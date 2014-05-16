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
    
    public AnchorPane home;
    public AnchorPane begeleiderStageEditor;  
    public AnchorPane studentEditor;  
    public AnchorPane stageEditor;
    
    @FXML
    private MenuItem test1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        System.out.println("initialize hoofdschermcontroller called");
    }    

    public void setApp(Main app)
    {
        this.application = app;
    }

    public void setUpWithModel(Model model)
    {
        this.model = model;
        
        if(model == null)
            System.out.println("No link");
        
        if(homeController == null)
            System.out.println("No controller");
        
        homeController.setUpWithModel(model);
        setChildrenHome();
    }
    private void setChildrenHome()
    {
        System.out.println("setChildrenHome called");
        //debatable of ik dit niet via javafx loader kan doen
        homeController.setMaster(this);
        begeleiderStageEditorController.setMaster(this);
        studentEditorController.setMaster(this);
        stageEditorController.setMaster(this);
    }

    public HomeController getHomeController()
    {
        return homeController;
    }    
    
    public BegeleiderStageEditorController getBegeleiderStageEditorController()
    {
        System.out.println("getBegStaEdiCon called");
        return begeleiderStageEditorController;
    }
    
    public StageEditorController getStageEditorController()
    {
        return stageEditorController;
    }
    
    public StudentEditorController getStudentEditorController()
    {
        return studentEditorController;
    }
    
    public void changeView (int v)
    {
        switch (v)
        {
            case 0: 
            {
                hideAllViews();
                home.setVisible(true);
                break;                
            }
            case 1:
            {
                hideAllViews();
                begeleiderStageEditor.setVisible(true);
                break; 
            }
            case 2:
            {
                hideAllViews();
                studentEditor.setVisible(true);
                break; 
            }
            case 3:
            {
                hideAllViews();
                stageEditor.setVisible(true);
                break; 
            }
        }
    }
    
    private void hideAllViews()
    {
        //home.setVisible(false); //keep menu bar
        begeleiderStageEditor.setVisible(false);        
        studentEditor.setVisible(false);
        stageEditor.setVisible(false);

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
