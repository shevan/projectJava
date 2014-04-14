/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import admin.OverzichtController;
import java.io.InputStream;
import admin.security.Authenticator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author Pieter Pletinckx
 */
public class Main extends Application {
    
    private Stage stage;
    private Admin loggedAdmin;
    
    private final double MIN_WINDOW_HEIGHT = 800.0;
    private final double MIN_WINDOW_WIDTH = 600.0;
    
    public static void main(String[] args)
    {
        Application.launch(Main.class, (java.lang.String[]) null);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            stage = primaryStage;
            stage.setTitle("STUA");
            stage.setMinHeight(MIN_WINDOW_HEIGHT);
            stage.setMinWidth(MIN_WINDOW_WIDTH);

            gotoLogin(); 
            stage.show();
        } catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,  ex);
        }
    }

    public Admin getLoggedAdmin()
    {
        return loggedAdmin;
    }
    
    public boolean adminLogging(String adminId, String password)
    {
        if (Authenticator.validate(adminId, password))
        {
            loggedAdmin = User.of(adminId);
            gotoOverzicht();
            return true;
        } else {
            return false;
        }
    }
    
    private void gotoLogin(){
        try{
            LoginController login = (LoginController) replaceSceneContent("Login.fxml");
            login.setApp(this);
        }
        catch(Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void gotoOverzicht(){
        try{
            OverzichtController overzicht = (OverzichtController) replaceSceneContent("Overzicht.fxml");
            overzicht.setApp(this);
        }
        catch(Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*private void gotoStudenten(){
        try{
            StudentController studenten = (StudentController) replaceSceneContent("Student.fxml");
            studenten.setApp(this);
        }
        catch(Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    //this next method is an fxml loader from JavaFX example
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
        Scene scene = new Scene(page, 800, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    public boolean userLogging(String adminId, String password)
    {
        if (Authenticator.validate(adminId, password))
        {
            loggedAdmin = Admin.of(adminId);
            gotoOverzicht();
            return true;
        } else {
            return false;
        }
    }
}
