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
    private StageEditorController stageEditorController;
    
    @FXML
    private Button btnBegeleidersAanvragen;
    @FXML
    private Button btnStudentenAanvragen;
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
        
        if (master == null)
            System.out.println("No controller");
        
        setMaster(this);
        setChildrenHome();
    }

    private void setChildrenHome()
    {
        //debatable of ik dit niet via javafx loader kan doen
        ControllerInterface[] children =
        {
            begeleiderStageEditorController,
            studentEditorController,
            stageEditorController
        };
        for(ControllerInterface controller: children)
        {
            controller.setMaster(this);
            controller.setApp(application);
            controller.setUpWithModel(model);
        }
        
//        begeleiderStageEditorController.setMaster(this);
//        studentEditorController.setMaster(this);
//        stageEditorController.setMaster(this);
    }    
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb)
    { 
    }    
    
//    public BegeleiderStageEditorController getBegeleiderStageEditorController()
//    {
//        return begeleiderStageEditorController;
//    }
//    
//    public StageEditorController getStageEditorController()
//    {
//        return stageEditorController;
//    }
//    
//    public StudentEditorController getStudentEditorController()
//    {
//        return studentEditorController;
//    }    
    
    @FXML 
    private void displayBegeleiderStageAanvragen(ActionEvent action)
    {
        begeleiderStageEditorController.initBegeleiderStageEditor();
        changeView(1);      
    }
    
    @FXML 
    private void displayStudentenStageAanvragen(ActionEvent action)
    {
        changeView(2);
    }    

    @FXML 
    private void displayStudenten(ActionEvent action)
    {
       changeView(3);
    }
    
    @FXML 
    private void displayStages(ActionEvent action)
    {
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
    
//    private void setTabListView () //Make one for each class to display
//    {   //controller has to hold various of these, one for every action
//        /*
//        Voor elke tabel die moet getoond worden in de lijst
//        moet er een ander type opgehaald worden
//        met respectievelijk elk een knop
//        hierop moet per type een geformateerde string van gemaakt worden*/
//        
//        listItems.add("Gelieve een Tabel te selecteren");
//        
//        /*List <Aspnetusers> aspnetusers = model.getUsersFromDatabase();
//                for (Aspnetusers user: aspnetusers){
//            System.out.println(user.getUserName());
//        }
//        for(Aspnetusers user : aspnetusers)
//        {
//            listItems.add(user.getUserName());
//            //set username max char = tab space
//        }
//         */
//    }
    
//    @FXML
//    public void itemDoubleclickAction (MouseEvent event)
//    {
//         if (event.getClickCount() > 1) 
//         {
//            if (!activelist.isEmpty())
//            {
//            
//                int s = tabListView.getSelectionModel().getSelectedIndex();
//                
//                if (activelist.get(0) instanceof Begeleiderstageaanvraag)
//                {
//                    master.getBegeleiderStageEditorController().showStageAanvraagDetails((Begeleiderstageaanvraag)activelist.get(s));
//                    master.changeView(1);
//                }
//                if(activelist.get(0) instanceof Stage)
//                {                 
//                    master.getStageEditorController().showStageDetails((Stage)activelist.get(s));
//                    master.changeView(2);
//                }                
//                if(activelist.get(0) instanceof Student)
//                {
//                    master.getStudentEditorController().showStudentDetails((Student)activelist.get(s));
//                    master.changeView(3);
//                }
//                if(activelist.get(0) instanceof Aspnetusers)
//                {
//                    /*openview*/
//                }
//                if(activelist.get(0) instanceof Bedrijf)
//                {
//                    /*openview*/
//                }
//                if(activelist.get(0) instanceof Bedrijfspersoon)
//                {   
//                    /*openview*/
//                }
//            } 
//         }
//    }
    
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
                studentStageEditor.setVisible(true);
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
                stageEditor.setVisible(true);
                break; 
            }
        }
    }
    
    private void hideAllViews()
    {
        begeleiderStageEditor.setVisible(false);        
        studentEditor.setVisible(false);
        stageEditor.setVisible(false);

    }    
}
