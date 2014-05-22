package admin;

import admin.model.*;
import admin.security.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application
{
    
    private Stage stage;
    private Model model;
    
    private final double MIN_WINDOW_HEIGHT = 1024.0;
    private final double MIN_WINDOW_WIDTH = 600.0;
    
    
    public static void main(String[] args)
    {
        Application.launch(Main.class, (java.lang.String[]) null);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        model = new Model();
        try
        {
            stage = primaryStage;
            stage.setTitle("STUA");

            gotoHome();
            initializeUsers();
            stage.show();
        } catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,  ex);
        }
    }
 
    /*------------------------------ VIEWS ------------------------------*/
    protected void gotoHome()
    {
        try
        {
             HomeController home = (HomeController) replaceSceneContent("view/Home.fxml");
             home.setApp(this);
             home.setUpWithModel(model);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
   
    private Initializable replaceSceneContent(String fxml) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));
        loader.load();
        AnchorPane root = loader.getRoot();

        Scene scene = new Scene(root, MIN_WINDOW_HEIGHT, MIN_WINDOW_WIDTH);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
    
    private void initializeUsers()
    {
        Authenticator.putUser("admin", "admin");
    }
    

    
    /*------------------------------ OBSERVABLE LISTS ------------------------------*/
    public ObservableList<Bedrijf> getBedrijfData()
    {
        ObservableList<Bedrijf> data = FXCollections.observableArrayList();
        List <Bedrijf> list = model.getBedrijvenFromDatabase(); 
        for(Bedrijf item : list)
        {
            data.add(item);  
        }
       	return data;
    } 
    
    public ObservableList<Bedrijfspersoon> getBedrijfspersoonData()
    {
        ObservableList<Bedrijfspersoon> data = FXCollections.observableArrayList();
        List <Bedrijfspersoon> list = model.getBedrijfpersonenFromDatabase(); 
        
        for(Bedrijfspersoon item : list)
        {
            data.add(item);
        }    
       	return data;
    } 
    
    public ObservableList<Begeleider> getBegeleiderData()
    {
        ObservableList<Begeleider> data = FXCollections.observableArrayList();
        List <Begeleider> list = model.getBegeleidersFromDatabase();
        for(Begeleider item : list)
        {
            data.add(item);
        }
       	return data;
    }
    
    public ObservableList<admin.model.Stages> getStageData()
    {
        ObservableList<Stages> data = FXCollections.observableArrayList();
        List <Stages> list = model.getStageFromDatabase();
        for(Stages item : list)
        {
            data.add(item);
        }  
       	return data;
    } 
   
    public ObservableList<Student> getStudentData()
    {
        ObservableList<Student> data = FXCollections.observableArrayList();
        List <Student> list = model.getStudentenFromDatabase();
        for(Student item : list)
        {
            data.add(item);
        }  
        return data;
    }
    
    public ObservableList<Studentstagesollicitatie> getStudenStageSollicitatietData()
    {
        ObservableList<Studentstagesollicitatie> data = FXCollections.observableArrayList();
        List <Studentstagesollicitatie> list = model.getStudentenStageSollicitatieFromDatabase();
        for(Studentstagesollicitatie item : list)
        {
            data.add(item);
        }  
        return data;
    }
    
    public ObservableList<Gegeven> getGegevensData()
    {
        ObservableList<Gegeven> data = FXCollections.observableArrayList();
        List <Gegeven> list = model.getGegevensFromDatabase();
        for(Gegeven item : list)
        {
            data.add(item);
        }  
        return data;
    }
    
    public ObservableList<Begeleiderstageaanvraag> getBegeleiderStageAanvraagData()
    {
        ObservableList<Begeleiderstageaanvraag> data = FXCollections.observableArrayList();
        List <Begeleiderstageaanvraag> list =  model.getBegeleiderStageAanvraagOnbeslistFromDatabase();
        for(Begeleiderstageaanvraag item : list)
        {
            data.add(item);
        }
       	return data;
    } 
    public ObservableList<Studentstage> getStudentStageAanvraagData()
    {
        ObservableList<Studentstage> data = FXCollections.observableArrayList();
        List <Studentstage> list =  model.getStudentStageAanvraagOnbeslistFromDatabase();
        for(Studentstage item : list)
        {
            data.add(item);
        }
       	return data;
    }   
    public ObservableList<Stages> getStageAanvraagData()
    {
        ObservableList<Stages> data = FXCollections.observableArrayList();
        List <Stages> list =  model.getStageAanvraagOnbeslistFromDatabase();
        for(Stages item : list)
        {
            data.add(item);
        }
       	return data;
    }         
}