package admin;

import admin.model.Aspnetusers;
import java.io.InputStream;
import admin.security.Authenticator;
import java.util.List;
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
    private Model model;
    
    private final double MIN_WINDOW_WIDTH = 1366.0;
    private final double MIN_WINDOW_HEIGHT = 768.0;
    
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

            initializeUsers();
            gotoLogin(); //<------------------------------------tijdelijke verandering voor development
            //gotoOverzicht();
            stage.show();
        } catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,  ex);
        }
    }
    
    protected boolean userLogging(String userId, String password)
    {
        if (Authenticator.validate(userId, password))
        {
            gotoOverzicht();
            return true;
        } else {
            return false;
        }
    }
    
    private void initializeUsers()
    {
        List <Aspnetusers> aspnetusers = model.getUsersFromDatabase();
        
        if (aspnetusers.isEmpty())
        {
            // error geen users bekend
        } else {
            for (Aspnetusers user : aspnetusers)
            {
                Authenticator.putUser(user.getUserName(), user.getPasswordHash());
            }
        }
    }
    
    protected void gotoLogin()
    {
        try
        {
            LoginController login = (LoginController) replaceSceneContent("login.fxml");
            login.setApp(this);
            login.setUpWithModel(model);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void gotoOverzicht()
    {
        try
        {
            OverzichtController overzicht = (OverzichtController) replaceSceneContent("overzicht.fxml");
            overzicht.setApp(this);
        }
        catch(Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
        Scene scene = new Scene(page, MIN_WINDOW_WIDTH, MIN_WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
    
}
