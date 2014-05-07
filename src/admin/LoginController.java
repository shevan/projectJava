package admin;

import admin.model.Aspnetusers;
import admin.security.Authenticator;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.persistence.TypedQuery;
import java.lang.Object;

public class LoginController extends AnchorPane implements Initializable
{
    @FXML
    TextField adminId;
    
    @FXML
    PasswordField password;
    
    @FXML
    Button login;
    
    @FXML
    Button cancel;
    
    @FXML
    Button help; // eventueel naar label veranderen en tekst verschijnt bij hoveren
    
    @FXML
    Label errorMsg;
    
    //image click = website + vermelden
    
    private Main application;
    private Model model;

    public void setApp(Main application)
    {
        this.application = application;
    }
    
    public void setUpWithModel(Model model)
    {
        this.model = model;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        errorMsg.setText("");
    }
    
    public void processLogin(ActionEvent event)
    {
        if (application != null)
        {
            try
            {
                if (adminId.getText().isEmpty())
                {
                    errorMsg.setText("Gebruikersnaam mag niet leeg zijn!");
                    return;
                }
                
                if (password.getText().isEmpty())
                {
                    errorMsg.setText("Wachtwoord mag niet leeg zijn!");
                    return;
                }
                
                if (!application.userLogging(adminId.getText(), hashCode(password.getText())))
                {
                    errorMsg.setText("Gebruikersnaam en/of wachtwoord is incorrect!");
                    return;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return;
            }
            
            application.gotoOverzicht();
        }
    }
    
    public void processCancel(ActionEvent event)
    {
        System.exit(1);
    }
    
    public String hashCode(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); //PBKDF2WithHmacSHA256
        digest.reset();

        byte[] byteData = digest.digest(input.getBytes("UTF-8"));
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < byteData.length; i++){
          sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
  
        return sb.toString();
    }
}
