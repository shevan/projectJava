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
            gotoHoofdscherm();
            //gotobegHoofdscherm();
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
            LoginController login = (LoginController) replaceSceneContent("view/login.fxml");
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
            OverzichtController overzicht = (OverzichtController) replaceSceneContent("view/overzicht.fxml");
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
             HoofdSchermController hoofdscherm = (HoofdSchermController) replaceSceneContent("view/hoofdScherm.fxml");
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
             BegeleiderStageController hoofdscherm = (BegeleiderStageController) replaceSceneContent("view/BegeleiderStage.fxml");
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
        ObservableList<Bedrijf> data = FXCollections.observableArrayList();
        List <Bedrijf> list = model.getBedrijvenFromDatabase(); 
        for(Bedrijf item : list){
            data.add(item);}  
       	return data;
    } 
    
    public ObservableList<Bedrijfspersoon> getBedrijfspersoonData() {
        ObservableList<Bedrijfspersoon> data = FXCollections.observableArrayList();
        List <Bedrijfspersoon> list = model.getBedrijfpersonenFromDatabase(); 
        for(Bedrijfspersoon item : list){
            data.add(item);}  
       	return data;
    } 
    
    public ObservableList<Begeleider> getBegeleiderData() {
        ObservableList<Begeleider> data = FXCollections.observableArrayList();
        List <Begeleider> list = model.getBegeleidersFromDatabase();
        for(Begeleider item : list){
            data.add(item);}  
       	return data;
    }
    
    public ObservableList<admin.model.Stage> getStageData() {
        ObservableList<admin.model.Stage> data = FXCollections.observableArrayList();
        List <admin.model.Stage> list = model.getStageFromDatabase();
        for(admin.model.Stage item : list){
            data.add(item);
        }  
       	return data;
    } 
   
    public ObservableList<Student> getStudentData() {
        ObservableList<Student> data = FXCollections.observableArrayList();
        List <Student> list = model.getStudentenFromDatabase();
        for(Student item : list){
            data.add(item);}  
        return data;
    }
    
    public ObservableList<Studentstagesollicitatie> getStudenStageSollicitatietData() {
        ObservableList<Studentstagesollicitatie> data = FXCollections.observableArrayList();
        List <Studentstagesollicitatie> list = model.getStudentStageSollicitatieFromDatabase();
        for(Studentstagesollicitatie item : list){
            data.add(item);}  
        return data;
    }
    
    public ObservableList<Gegeven> getGegevensData() {
        ObservableList<Gegeven> data = FXCollections.observableArrayList();
        List <Gegeven> list = model.getGegevensFromDatabase();
        for(Gegeven item : list){
            data.add(item);}  
        return data;
    }
    
    public ObservableList<Begeleiderstageaanvraag> getBegeleiderStageAanvraagData() {
        ObservableList<Begeleiderstageaanvraag> data = FXCollections.observableArrayList();
        List <Begeleiderstageaanvraag> list =  model.getBegeleiderStageAanvraagFromDatabase();
        for(Begeleiderstageaanvraag item : list){
            data.add(item);}
       	return data;
    } 
}