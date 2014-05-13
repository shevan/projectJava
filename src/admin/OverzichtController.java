package admin;

import admin.model.Aspnetusers;
import admin.model.Bedrijf;
import admin.model.Bedrijfspersoon;
import admin.model.Stage;
import admin.model.Student;
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
import javafx.scene.layout.Pane;


public class OverzichtController extends AnchorPane implements Initializable
{   
    private List activelist;
    private HoofdSchermController master;
    @FXML
    Button stageButton;
    
    @FXML
    Button studentenButton;
    
    @FXML
    Button gebruikersButton;
    
    @FXML
    Button button4;
    
    @FXML
    Button button5;
    
    @FXML 
    Button button6;
    
    @FXML
    Button button7;
    
    
    
    @FXML
    ListView <String>tabListView;
    
    private Main application;
    private Model model;
    final ObservableList<String> listItems = FXCollections.observableArrayList();
    
    //add event handlers
    @FXML
    private void addAction(ActionEvent action){
        System.out.println("Test button pushed");
    }
    /**
     *         Voor elke tabel die moet getoond worden in de lijst
     *  moet er een ander type opgehaald worden
     *  met respectievelijk elk een knop
     *  hierop moet per type een geformateerde string van gemaakt worden 
     */
     @FXML 
     private void displayStages(ActionEvent action){
         listItems.clear();
         //goede plaats voor een try catch blok
         List<Stage> stages = model.getStageFromDatabase();
         activelist = stages;
         if(stages.isEmpty())listItems.add("<<Tabel is leeg>>");
         for(Stage stage : stages)
         {
             listItems.add(stage.getProjectTitel()+" "+stage.getProjectOmschrijving());
         }
         
     }
     
     @FXML 
     private void displayStudenten(ActionEvent action){
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
     private void displayGebruikers(ActionEvent action){
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
     private void displayAction(ActionEvent action){
         
     }
     
            
    public void setApp(Main application)
    {
        this.application = application;
    }
    public void setMaster(HoofdSchermController master) 
    {
        this.master = master;
    }
            
    /**
    public OverzichtController()
    { 
        emf = Persistence.createEntityManagerFactory("ProjectJavaPU");
        em = emf.createEntityManager();

        TypedQuery<Aspnetusers> queryAspnetusers = em.createNamedQuery("Aspnetusers.findAll", Aspnetusers.class);
        aspnetusers = queryAspnetusers.getResultList();
        for(Aspnetusers user : aspnetusers)
        {
            listItems.add(user.getUserName()+" "+user.getDiscriminator());
            //set username max char = tab space
        }
             
               
    }
    **/
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
        List <Aspnetusers> aspnetusers = model.getUsersFromDatabase();
                for (Aspnetusers user: aspnetusers){
            System.out.println(user.getUserName());
        }
        for(Aspnetusers user : aspnetusers)
        {
            listItems.add(user.getUserName());
            //set username max char = tab space
        }
            
    }
    public void itemDoubleclickAction (MouseEvent event){
         if (event.getClickCount() > 1) 
         {
            if(!activelist.isEmpty())
            {
            
                int s = tabListView.getSelectionModel().getSelectedIndex();
                if(activelist.get(0) instanceof Stage)
                {
                    master.getBSControler().bewerkGegevens((Stage)activelist.get(s));
                    master.changeView(3);
                    System.out.println("Stage double clicked");
                }
                if(activelist.get(0) instanceof Student)
                {
                    //master.getBSControler().bewerkGegevens((Student)activelist.get(s));
                    //ERROR view bevat geen student
                    master.changeView(3);
                    System.out.println("Student double clicked");/*openview*/
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
