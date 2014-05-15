package admin;

import admin.model.*;
import java.io.InputStream;
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
    // private User loggedUser;
    private Model model;
    
    private final double MIN_WINDOW_HEIGHT = 1366.0;
    private final double MIN_WINDOW_WIDTH = 768.0;
    
    
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

            //gotoLogin();
            gotoHomepage();
            //gotoBegeleiderStageEditor();
            //gotoStageEditor();
            //gotoStudentEditor();
            stage.show();
        } catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,  ex);
        }
    }
    
    /*------------------------------ VIEWS ------------------------------*/
    private void gotoLogin()
    {
        try
        {
            LoginController login = (LoginController) replaceSceneContent("view/Login.fxml");
            login.setApp(this);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void gotoHomepage()
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
    
    private void gotoBegeleiderStageEditor()
    {
        try
        {
            //gelieve nieuwe methode van Van Impe toepassen hier
            BegeleiderStageEditorController begeleiderStage = (BegeleiderStageEditorController) replaceSceneContent("view/BegeleiderStageEditor.fxml");
            begeleiderStage.setApp(this);
            begeleiderStage.setUpWithModel(model);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gotoStageEditor()
    {
        try
        {
            //gelieve nieuwe methode van Van Impe toepassen hier
            StageEditorController stage = (StageEditorController) replaceSceneContent("view/StageEditor.fxml");
            stage.setApp(this);
            stage.setUpWithModel(model);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void gotoStudentEditor()
    {
        try
        {
            //gelieve nieuwe methode van Van Impe toepassen hier
            StudentEditorController student = (StudentEditorController) replaceSceneContent("view/StudentEditor.fxml");
            student.setApp(this);
            student.setUpWithModel(model);
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
        VBox root = loader.getRoot();

        Scene scene = new Scene(root, MIN_WINDOW_HEIGHT, MIN_WINDOW_WIDTH);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
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
    
    public ObservableList<admin.model.Stage> getStageData()
    {
        ObservableList<admin.model.Stage> data = FXCollections.observableArrayList();
        List <admin.model.Stage> list = model.getStageFromDatabase();
        for(admin.model.Stage item : list)
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
        List <Studentstagesollicitatie> list = model.getStudentStageSollicitatieFromDatabase();
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
        List <Begeleiderstageaanvraag> list =  model.getBegeleiderStageAanvraagFromDatabase();
        for(Begeleiderstageaanvraag item : list)
        {
            data.add(item);
        }
       	return data;
    } 
}