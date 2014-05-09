package admin;

import admin.model.*;
import java.io.InputStream;
import admin.security.Authenticator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    
    private Stage stage;
  //  private User loggedUser;
    private Model model;
    
    private final double MIN_WINDOW_HEIGHT = 800.0;
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
            /*stage.setMinHeight(MIN_WINDOW_HEIGHT);
            stage.setMinWidth(MIN_WINDOW_WIDTH);*/

           //gotoLogin(); // <------------------------------------tijdelijke verandering voor development
           // gotoOverzicht();
        //    gotoHoofdscherm();
            gotobegHoofdscherm();
            stage.show();
        } catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,  ex);
        }
    }
    
    

    
    
    private void gotoLogin()
    {
        try
        {
            LoginController login = (LoginController) replaceSceneContent("login.fxml");
            login.setApp(this);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void gotoOverzicht()
    {
        try
        {
            OverzichtController overzicht = (OverzichtController) replaceSceneContent("overzicht.fxml");
            overzicht.setApp(this);
            overzicht.setUpWithModel(model);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void gotoHoofdscherm()
    {
        try
        {
            //gelieve nieuwe methode van Van Impe toepassen hier
             HoofdSchermController hoofdscherm = (HoofdSchermController) replaceSceneContent("hoofdScherm.fxml");
             hoofdscherm.setApp(this);
             hoofdscherm.setUpWithModel(model);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void gotobegHoofdscherm()
    {
        try
        {
            //gelieve nieuwe methode van Van Impe toepassen hier
             BegeleiderStageController hoofdscherm = (BegeleiderStageController) replaceSceneContent("BegeleiderStage.fxml");
             hoofdscherm.setApp(this);
             hoofdscherm.setUpWithModel(model);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    /*private void gotoStudenten(){
        try{
            StudentController studenten = (StudentController) replaceSceneContent("student.fxml");
            studenten.setApp(this);
        }
        catch(Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    private Initializable replaceSceneContent(String fxml) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));
        loader.load();
        VBox root = loader.getRoot();

        //Scene scene = new Scene(page, MAX_WINDOW_WIDTH, MIN_WINDOW_WIDTH);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
    
    //---------------------- lijst naar observable lijst --------------------------------
    
    public ObservableList<Bedrijf> getBedrijfData() {
        ObservableList<Bedrijf> bedrijvenData = FXCollections.observableArrayList();
        List <Bedrijf> bedrijven = model.getBedrijvenFromDatabase();
        for(Bedrijf bedrijf : bedrijven)
        {
            bedrijvenData.add(bedrijf);
        }  
       	return bedrijvenData;
    } 
    
    public ObservableList<Begeleider> getBegeleiderData() {
        ObservableList<Begeleider> begeleidersData = FXCollections.observableArrayList();
        List <Begeleider> begeleiders = model.getBegeleidersFromDatabase();
        for(Begeleider begeleider : begeleiders)
        {
            begeleidersData.add(begeleider);
        }  
       	return begeleidersData;
    } 
    
   
    public ObservableList<admin.model.Stage> getStageData() {
        ObservableList<admin.model.Stage> stagesData = FXCollections.observableArrayList();
        List <admin.model.Stage> stages = model.getStageFromDatabase();
        for(admin.model.Stage stage : stages)
        {
            stagesData.add(stage);
        }  
       	return stagesData;
    } 
   
    public ObservableList<Student> getStudentData() {
        ObservableList<Student> studentenData = FXCollections.observableArrayList();
        List <Student> studenten = model.getStudentenFromDatabase();
        for(Student student : studenten)
        {
            studentenData.add(student);
        }  
       	return studentenData;
    } 
}