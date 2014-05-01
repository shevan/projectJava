package admin;

import admin.model.User;
import java.io.InputStream;
import admin.security.Authenticator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    
    private Stage stage;
    private User loggedUser;
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

           //gotoLogin(); <------------------------------------tijdelijke verandering voor development
            gotoOverzicht();
            stage.show();
        } catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,  ex);
        }
    }

    public User getLoggedUser()
    {
        return loggedUser;
    }
    
    public boolean userLogging(String userId, String password)
    {
        if (Authenticator.validate(userId, password))
        {
            loggedUser = User.of(userId);
            gotoOverzicht();
            return true;
        } else {
            return false;
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
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        } 
        //Scene scene = new Scene(page, MAX_WINDOW_WIDTH, MIN_WINDOW_WIDTH);
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
    
}
