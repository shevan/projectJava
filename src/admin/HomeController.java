package admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HomeController extends AnchorPane implements Initializable
{
    private Main application;
    private Model model;
   
    private HomeController master;
    
    @FXML
    private BegeleiderStageEditorController begeleiderStageEditorController; // aanvragen voor begeleiders = goedkeuren of afkeuren (prior 80)
    @FXML
    private StageEditorController stageEditorController; // aanvragen voor stageopdrachten = goedkeuren of afkeuren (prior 60 + 70)
    @FXML
    private StagesEditorController stagesEditorController;    // alle stages (prior 110 - aanduiden opgesteld & getekend) + (prior 90 - begin/einddatums aanpassen indien nodig)
    @FXML
    private GenererenEditorController genererenEditorController;    // alle stages + zoekcriteria (prior 100)   
    
    @FXML
    private Button btnBegeleidersAanvragen;
    @FXML
    private Button btnStageAanvragen;
    @FXML
    private Button btnStages;

    public AnchorPane begeleiderStageEditor;  
    public AnchorPane stageEditor;    
    public AnchorPane stagesEditor;   
    public AnchorPane genererenEditor;
      
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
            stageEditorController,
            stagesEditorController,
            genererenEditorController
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
    private void displayStages(ActionEvent action)
    {
        stagesEditorController.initStageEditor();             
        changeView(3);
    }     

    @FXML
    private void displayFilteredStages(ActionEvent action)
    {
        genererenEditorController.initGenererenEditor();             
        changeView(4);        
    }    
    
    public void changeView (int v)
    {
        switch (v)
        {
            case 0:
            {
                hideAllViews();
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
                stagesEditor.setVisible(true);
                break; 
            }
            case 4:
            {
                hideAllViews();
                genererenEditor.setVisible(true);
                break; 
            }
        }
    }
    
    private void hideAllViews()
    {
        begeleiderStageEditor.setVisible(false);    
        stageEditor.setVisible(false);
        stagesEditor.setVisible(false);
        genererenEditor.setVisible(false);          
    }    
}
