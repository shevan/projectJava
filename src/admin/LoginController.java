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

public class LoginController extends AnchorPane implements Initializable
{
    @FXML
    TextField adminId;
    
    @FXML
    PasswordField password;
    
    @FXML
    Button login;
    
    @FXML
    Button help; // eventueel naar label veranderen en tekst verschijnt bij hoveren
    
    @FXML
    Label errorMsg;
    
    //image click = website + vermelden
    
    private Main application;

    public void setApp(Main application)
    {
        this.application = application;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        adminId.setPromptText("Gebruikersnaam");
        password.setPromptText("Wachtwoord");
        errorMsg.setText("");
    }   
    
    public void processLogin(ActionEvent event)
    {
        if (application != null)
        {
            if (adminId.getText().isEmpty())
            {
                errorMsg.setText("Het veld gebruikersnaam moet ingevuld worden!");
                return;
            }
            if (password.getText().isEmpty())
            {
                errorMsg.setText("Het veld wachtwoord moet ingevuld worden!");
                return;
            }
            if (!application.userLogging(adminId.getText(), password.getText()))
            {
                errorMsg.setText("Gebruikersnaam en/of wachtwoord is incorrect!");
                return;
            }
            
            application.gotoHome();
        }
    }
    
    public void processCancel(ActionEvent event)
    {
        System.exit(1);
    }
}
