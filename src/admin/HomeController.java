package admin;

import admin.model.Aspnetusers;
import admin.model.Bedrijf;
import admin.model.Bedrijfspersoon;
import admin.model.Stage;
import admin.model.Begeleiderstageaanvraag;
import admin.model.Student;
import java.awt.Component;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.DefaultListCellRenderer;

public class HomeController extends AnchorPane implements Initializable
{
    private Main application;
    private Model model;
    final ObservableList<String> listItems = FXCollections.observableArrayList();
    private List activelist;
    private HoofdSchermController master;
    
    @FXML
    private Button begeleiderstageaanvraagButton;
        
    @FXML
    private Button stageButton;
    
    @FXML
    private Button studentenButton;
    
    @FXML
    private Button gebruikersButton;
    
    @FXML
    private Button button4;
    
    @FXML
    private Button button5;
    
    @FXML 
    private Button button6;
    
    @FXML
    private Button button7;
    
    @FXML
    ListView<String> tabListView;
    @FXML
    private Button aanvraagButton;
    
    //add event handlers
    private void addAction(ActionEvent action)
    {
        System.out.println("Test button pushed");
    }
    /**
    *         Voor elke tabel die moet getoond worden in de lijst
    *  moet er een ander type opgehaald worden
    *  met respectievelijk elk een knop
    *  hierop moet per type een geformateerde string van gemaakt worden 
    */
    @FXML 
    private void displayBegeleiderStageAanvragen(ActionEvent action)
    {
        listItems.clear();
        //goede plaats voor een try catch blok         
        List<Begeleiderstageaanvraag> stages = model.getBegeleiderStageAanvraagFromDatabase();
        activelist = stages;

        if (stages.isEmpty())
            listItems.add("<<Tabel is leeg>>");

        for (Begeleiderstageaanvraag stage : stages)
        {
            listItems.add(stage.getStageStageId().getProjectTitel()+" "+stage.getStageStageId().getProjectOmschrijving());
        }
    }
    

    @FXML 
    private void displayStages(ActionEvent action)
    {
        listItems.clear();
        //goede plaats voor een try catch blok

        List<Stage> stages = model.getStageFromDatabase();
        activelist = stages;

        if(stages.isEmpty())
            listItems.add("<<Tabel is leeg>>");

        for(Stage stage : stages)
        {
            listItems.add(stage.getProjectTitel()+" "+stage.getProjectOmschrijving());
        }
    }     

    @FXML 
    private void displayStudenten(ActionEvent action)
    {
       listItems.clear();
       List <Student> studenten = model.getStudentenFromDatabase();
       activelist = studenten;
       if(studenten.isEmpty())listItems.add("<<Tabel is leeg>>");
       for(Student student : studenten)
       {
           listItems.add(student.getVoornaam()+" "+student.getFamilienaam());
           //set username max char = tab space
       }         
    }

    @FXML 
    private void displayGebruikers(ActionEvent action)
    {
       listItems.clear();
       List <Aspnetusers> aspnetusers = model.getUsersFromDatabase();
       activelist= aspnetusers;
       if(aspnetusers.isEmpty())listItems.add("<<Tabel is leeg>>");
       for(Aspnetusers user : aspnetusers)
       {
           listItems.add(user.getUserName()+" "+user.getDiscriminator());
           //set username max char = tab space
       }
    }

    @FXML
    private void displayBedrijven(ActionEvent action)
    {
       listItems.clear();
       List<Bedrijf> bedrijven= model.getBedrijvenFromDatabase();
       activelist=bedrijven;
       if(bedrijven.isEmpty())listItems.add("<<Tabel is leeg>>");
       for(Bedrijf bedrijf : bedrijven)
       {
           listItems.add(bedrijf.getBedrijfsNaam()+""+bedrijf.getWebsite());
           //set username max char = tab space
       }
    }
      
    public void setApp(Main application)
    {
        this.application = application;
    }
    public void setMaster(HoofdSchermController master) 
    {
        this.master = master;
    }
            
    public void setUpWithModel(Model model)
    {
        this.model = model;
        setTabListView();  //deze hoort hier niet maar moet aangeroepen worden na init en setupwithmodel
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb)
    { 
        tabListView.setItems(listItems);
    }
    
    @FXML
    public void processStages(ActionEvent event)
    {
        if (application == null)
        {
            
        } else {

        }
    }
    private void setTabListView () //Make one for each class to display
    {   //controller has to hold various of these, one for every action
        /*
        Voor elke tabel die moet getoond worden in de lijst
        moet er een ander type opgehaald worden
        met respectievelijk elk een knop
        hierop moet per type een geformateerde string van gemaakt worden
        
        */
//        listItems.add("Gelieve een Tabel te selecteren");
        /*
        List <Aspnetusers> aspnetusers = model.getUsersFromDatabase();
                for (Aspnetusers user: aspnetusers){
            System.out.println(user.getUserName());
        }
        for(Aspnetusers user : aspnetusers)
        {
            listItems.add(user.getUserName());
            //set username max char = tab space
        }
         */
        List<Stage> stages = model.getStageFromDatabase();
        activelist = stages;

        if(stages.isEmpty())
            listItems.add("<<Tabel is leeg>>");

        for(Stage stage : stages)
        {
            listItems.add(stage.getProjectTitel()+" "+stage.getProjectOmschrijving());
        }
    }
    @FXML
    public void itemDoubleclickAction (MouseEvent event)
    {
         if (event.getClickCount() > 1) 
         {
            if(!activelist.isEmpty())
            {
            
                int s = tabListView.getSelectionModel().getSelectedIndex();
                
                if(activelist.get(0) instanceof Begeleiderstageaanvraag)
                {
                    System.out.println("Begeleiderstageaanvraag double clicked => " + activelist.get(s));
                    try {master.getBegeleiderStageEditorController().showStageAanvraagDetails((Begeleiderstageaanvraag)activelist.get(s));
                    } catch (NullPointerException e)
                    {
                        e.printStackTrace();
                        
                    }
                    master.changeView(2);
                }
                if(activelist.get(0) instanceof Stage)
                {
                    System.out.println("Stage double clicked");                   
                    master.getStageEditorController().bewerkGegevens((Stage)activelist.get(s));
                    master.changeView(3);
                }                
                if(activelist.get(0) instanceof Student)
                {
                    System.out.println("Student double clicked");                    
                    master.getStudentEditorController().bewerkGegevens((Student)activelist.get(s));
                    master.changeView(4);
                }
                if(activelist.get(0) instanceof Aspnetusers)
                {
                    System.out.println("Gebruikers double clicked");
                    /*openview*/
                }
                if(activelist.get(0) instanceof Bedrijf)
                {
                    System.out.println("Bedrijf double clicked");
                    /*openview*/
                }
                if(activelist.get(0) instanceof Bedrijfspersoon)
                {   
                    System.out.println("Bedrijfspersoon double clicked");
                    /*openview*/
                }
            } 
         }
    }
}
