package admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class StageController extends AnchorPane implements Initializable
{
    private Main application;

    public void setApp(Main application)
    {
        this.application = application;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }
    
    public void processLogin(ActionEvent event)
    {
    }
}
