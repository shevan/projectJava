package admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HomeController extends AnchorPane implements Initializable
{   private Main application;
    private Model model;
   
    private HomeController master;
    
    @FXML
    private BegeleiderStageEditorController begeleiderStageEditorController;
    @FXML
    private StudentStageEditorController studentStageEditorController;    
    @FXML
    private StudentEditorController studentEditorController;
    @FXML
    private StageEditorController stageEditorController; // stage opdrachten
    @FXML
    private StagesEditorController stagesEditorController;    
    
    @FXML
    private Button btnBegeleidersAanvragen;
    @FXML
    private Button btnStageAanvragen;
    @FXML
    private Button btnStages;
    @FXML
    private Button btnStudenten;
    @FXML
    private Button btnBedrijven;    
    @FXML
    private Button btnGebruikers;
    @FXML
    private Button aanvraagButton;

    public AnchorPane begeleiderStageEditor;  
    public AnchorPane studentStageEditor;
    public AnchorPane studentEditor;  
    public AnchorPane stageEditor;    
    public AnchorPane stagesEditor;   
      
    public void setApp(Main application)
    {
        this.application = application;
    }
    
    public void setMaster(HomeController master) 
    {
        this.master = master;
    }

    public void setUpWithModel(Model model)
    {
        this.model = model;
        
        if (model == null)
            System.out.println("No link");
        
        setMaster(this);
        
        if (master == null)
            System.out.println("No controller");
        
        
        setChildrenHome();
    }

    private void setChildrenHome()
    {
        //debatable of ik dit niet via javafx loader kan doen
        ControllerInterface[] children =
        {
            begeleiderStageEditorController,
            studentStageEditorController,
            studentEditorController,
            stageEditorController,
            stagesEditorController
        };
        for(ControllerInterface controller: children)
        {
            controller.setMaster(this);
            controller.setApp(application);
            controller.setUpWithModel(model);
        }
    }    
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb)
    { 
    }       
    
    @FXML 
    private void displayBegeleiderStageAanvragen(ActionEvent action)
    {
        begeleiderStageEditorController.initBegeleiderStageEditor();
        changeView(1);      
    }
    
    @FXML 
    private void displayStageAanvragen(ActionEvent action)
    {
        stageEditorController.initStageEditor();        
        changeView(2);
    }    

    @FXML 
    private void displayStudenten(ActionEvent action)
    {
        studentStageEditorController.initStudentStageEditor();           
        changeView(3);
    }
    
    @FXML 
    private void displayStages(ActionEvent action)
    {
        stagesEditorController.initStageEditor();             
        changeView(4);
    }     

    @FXML
    private void displayBedrijven(ActionEvent action)
    {
    } 
    
    @FXML 
    private void displayGebruikers(ActionEvent action)
    {

    }   
    
    public void changeView (int v)
    {
        switch (v)
        {
            case 0:
            {
                hideAllViews();
                // set visible unread messages count?
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
                stageEditor.setVisible(true);
                break; 
            }            
            case 3:
            {
                hideAllViews();
                studentEditor.setVisible(true);
                break; 
            }
            case 4:
            {
                hideAllViews();
                stagesEditor.setVisible(true);
                break; 
            }
        }
    }
    
    private void hideAllViews()
    {
        begeleiderStageEditor.setVisible(false);    
        studentStageEditor.setVisible(false);  
        studentEditor.setVisible(false);
        stageEditor.setVisible(false);
        stagesEditor.setVisible(false);

    }    
}
