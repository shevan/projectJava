package admin;

import admin.model.Aspnetusers;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class OverzichtController extends AnchorPane implements Initializable
{
    EntityManagerFactory emf;
    EntityManager em;
    List<Aspnetusers> aspnetusers;
    
    @FXML
    Button stage;
    
    @FXML
    Label lblOverzicht;
    
    @FXML
    ListView <String>tabListView;
    
    private Main application;
    
    final ObservableList<String> listItems = FXCollections.observableArrayList("Add Items Here");
    
    public void setApp(Main application)
    {
        this.application = application;
    }
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    { 
        lblOverzicht.setText(aspnetusers.toString());
        tabListView.setItems(listItems);
        
    }
    
    public void processStages(ActionEvent event)
    {
        if (application == null)
        {
            
        } else {

        }
    }
}
