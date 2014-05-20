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

//            gotoLogin();
            gotoHome();
           //gotoBegeleiderStageEditor();
//            gotoStudentStageEditor();
           // gotoHomeBorderLayout();
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
            //gelieve nieuwe methode van Van Impe toepassen hier
             HomeController home = (HomeController) replaceSceneContent("view/Home.fxml");
             home.setApp(this);
             home.setUpWithModel(model);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
    private void gotoHomeBorderLayout()
    {
        try
        {
            //gelieve nieuwe methode van Van Impe toepassen hier
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/HomeBorderLayout.fxml"));
            loader.load();
            BorderPane root = loader.getRoot();
            Scene scene = new Scene(root, MIN_WINDOW_HEIGHT, MIN_WINDOW_WIDTH);
            stage.setScene(scene);
            stage.sizeToScene();
            HomeBorderLayoutController HBLContoller = loader.getController();
            HBLContoller.setApp(this);
            HBLContoller.setUpWithModel(model);
            ///loader.getController();
            /*
             HomeController home = (HomeController) replaceSceneContent("view/Home.fxml");
             home.setApp(this);
             home.setUpWithModel(model);
            */
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
            
    
    protected void gotoBegeleiderStageEditor()
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

    protected void gotoStudentStageEditor()
    {
        try
        {
            //gelieve nieuwe methode van Van Impe toepassen hier
            StudentStageEditorController studentStage = (StudentStageEditorController) replaceSceneContent("view/StudentStageEditor.fxml");
            studentStage.setApp(this);
            studentStage.setUpWithModel(model);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
//    protected void gotoStageEditor()
//    {
//        try
//        {
//            //gelieve nieuwe methode van Van Impe toepassen hier
//            StageEditorController stage = (StageEditorController) replaceSceneContent("view/StageEditor.fxml");
//            stage.setApp(this);
//            stage.setUpWithModel(model);
//        }
//        catch(Exception ex)
//        {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    protected void gotoStudentEditor()
//    {
//        try
//        {
//            //gelieve nieuwe methode van Van Impe toepassen hier
//            StudentEditorController student = (StudentEditorController) replaceSceneContent("view/StudentEditor.fxml");
//            student.setApp(this);
//            student.setUpWithModel(model);
//        }
//        catch(Exception ex)
//        {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
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
    
    public ObservableList<Studentstage> getStudenStageSollicitatietData()
    {
        ObservableList<Studentstage> data = FXCollections.observableArrayList();
        List <Studentstage> list = model.getStudentenStageAanvraagOnbeslistFromDatabase();
        for(Studentstage item : list)
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
                                                    //getBegeleiderStageAanvraagOnbeslistFromDatabase();
                                                    //wissel mij terug
        for (Begeleiderstageaanvraag item : list)
        {
            System.out.println(item.getBegeleiderId());
        }
        
        for(Begeleiderstageaanvraag item : list)
        {
            data.add(item);
        }
       	return data;
    } 
}