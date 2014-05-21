package admin;

import admin.model.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javax.swing.JOptionPane;

public class StudentStageEditorController implements Initializable, ControllerInterface
{
    private Main application;
    private Model model;
    private HomeController master;
    
    @FXML
    private TableView<Studentstage> studentAanvragenTabel;
    @FXML
    private TableColumn<Studentstage, String> bedrijfKolom;
    @FXML
    private TableColumn<Studentstage, String> studentKolom;
    @FXML
    private TextArea projectOmschrijvingTxt;
    @FXML
    private TextField ondertekenaarVoornaamTxt;
    @FXML
    private TextField ondertekenaarFamilienaamTxt;
    @FXML
    private TextField ondertekenaarFunctieTxt;
    @FXML
    private TextField ondertekenaarTelefoonTxt;
    @FXML
    private TextField ondertekenaarEmailTxt;
    @FXML
    private TextField projectTitelTxt;
    @FXML
    private TextField specialisatieTxt;
    @FXML
    private TextField periodeTxt;
    @FXML
    private TextField aantalStudentenTxt;
    @FXML
    private TextField bedrijfsnaamTxt;
    @FXML
    private TextField bedrijfStraatEnNrTxt;
    @FXML
    private TextField bedrijfPostcodeTxt;
    @FXML
    private TextField bedrijfsGemeenteTxt;
    @FXML
    private TextField mentorVoornaamTxt;
    @FXML
    private TextField mentorFamilienaamTxt;
    @FXML
    private TextField mentorFunctieTxt;
    @FXML
    private TextField mentorTelefoonTxt;
    @FXML
    private TextField mentorEmailTxt;
    
    @FXML
    private Button btnGoedkeuren;
    @FXML
    private Button btnAfkeuren;        
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // only called when controller is run directly, not when going through HomeController
        
    }
    
    public void initStudentStageEditor()
    {   
        bedrijfKolom.setCellValueFactory( new Callback < CellDataFeatures < Studentstage, String >, ObservableValue < String > >()
        {
            @Override
            public ObservableValue < String > call(CellDataFeatures < Studentstage, String > p )
            {
                return new ReadOnlyStringWrapper( ( p.getValue().getStageId().getBedrijfId().getBedrijfsNaam() == null ) ? "" : p.getValue().getStageId().getBedrijfId().getBedrijfsNaam());
            }        
        });
        
        studentKolom.setCellValueFactory( new Callback < CellDataFeatures < Studentstage, String >, ObservableValue < String > >()
        {
            @Override
            public ObservableValue < String > call(CellDataFeatures < Studentstage, String > p )
            {
                return new ReadOnlyStringWrapper( ( p.getValue().getStudentId() == null ) ? "" : p.getValue().getStudentId().getFamilienaam()+" "+p.getValue().getStudentId().getVoornaam());
            }
        });

        // Auto resize columns
        studentAanvragenTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        studentAanvragenTabel.getSelectionModel().select(0);
        
//        showStageAanvraagDetails(null); //dit doet absoluut niets        
        
        // Listen for selection changes
        studentAanvragenTabel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Studentstage>()
        {
            @Override
            public void changed(ObservableValue<? extends Studentstage> observable,
                            Studentstage oldValue, Studentstage newValue) {
                    showStageAanvraagDetails(newValue); //laad new values in bewerkscherm
            }
        });
    }     
         
    protected void showStageAanvraagDetails(Studentstage stageaanvraag)
    {
        emptyTextFields(); // moet geleegd worden, anders kunnen velden die nu leeg moeten zijn nog oude gegevens van vorige stage bevatten
        if (stageaanvraag != null)
        {
            projectTitelTxt.setText(stageaanvraag.getStageId().getProjectTitel());
            projectOmschrijvingTxt.setText(stageaanvraag.getStageId().getProjectOmschrijving());
            specialisatieTxt.setText(stageaanvraag.getStageId().getSpecialisatie());
            periodeTxt.setText(stageaanvraag.getStageId().getPeriode());
            aantalStudentenTxt.setText(stageaanvraag.getStageId().getAantalStudenten()+"");

            bedrijfsnaamTxt.setText(stageaanvraag.getStageId().getBedrijfId().getBedrijfsNaam());
            bedrijfStraatEnNrTxt.setText(stageaanvraag.getStageId().getBedrijfId().getStraat());
            bedrijfsGemeenteTxt.setText(stageaanvraag.getStageId().getBedrijfId().getGemeente());
            bedrijfPostcodeTxt.setText(stageaanvraag.getStageId().getBedrijfId().getPostcode()+"");

            if (stageaanvraag.getStageId().getStagementorId() != null)
            {
                mentorVoornaamTxt.setText(stageaanvraag.getStageId().getStagementorId().getVoornaam());
                mentorFamilienaamTxt.setText(stageaanvraag.getStageId().getStagementorId().getFamilienaam());
                mentorFunctieTxt.setText(stageaanvraag.getStageId().getStagementorId().getFunctie());
                mentorTelefoonTxt.setText(stageaanvraag.getStageId().getStagementorId().getTelefoon()+"");
                mentorEmailTxt.setText(stageaanvraag.getStageId().getStagementorId().getEmail());
            }

            if (stageaanvraag.getStageId().getContractondertekenaarId() != null)
            {
                ondertekenaarVoornaamTxt.setText(stageaanvraag.getStageId().getContractondertekenaarId().getVoornaam());
                ondertekenaarFamilienaamTxt.setText(stageaanvraag.getStageId().getContractondertekenaarId().getFamilienaam());
                ondertekenaarFunctieTxt.setText(stageaanvraag.getStageId().getContractondertekenaarId().getFunctie());
                ondertekenaarTelefoonTxt.setText(stageaanvraag.getStageId().getContractondertekenaarId().getTelefoon()+"");
                ondertekenaarEmailTxt.setText(stageaanvraag.getStageId().getContractondertekenaarId().getEmail());
            }
        } 
    }
    
    private void emptyTextFields()
    {
        projectTitelTxt.setText("");
        projectOmschrijvingTxt.setText("");
        specialisatieTxt.setText("");
        periodeTxt.setText("");
        aantalStudentenTxt.setText("");

        bedrijfsnaamTxt.setText("");
        bedrijfStraatEnNrTxt.setText("");
        bedrijfsGemeenteTxt.setText("");
        bedrijfPostcodeTxt.setText("");

        mentorVoornaamTxt.setText("");
        mentorFamilienaamTxt.setText("");
        mentorFunctieTxt.setText("");
        mentorTelefoonTxt.setText("");
        mentorEmailTxt.setText("");

        ondertekenaarVoornaamTxt.setText("");
        ondertekenaarFamilienaamTxt.setText("");
        ondertekenaarFunctieTxt.setText("");
        ondertekenaarTelefoonTxt.setText("");
        ondertekenaarEmailTxt.setText(""); 
    }
    
    @FXML
    private void keurgoedStageAanvraagDetails(ActionEvent action)
    {
        saveStageAanvraagDetails(studentAanvragenTabel.getSelectionModel().selectedItemProperty().get());
        studentAanvragenTabel.getSelectionModel().selectedItemProperty().get().setGoedgekeurd(true);
        Mail.sendMail(studentAanvragenTabel.getSelectionModel().selectedItemProperty().get().getStudentId().getEmailHogent(), "Goedkeuring stage",
            "Geachte " + studentAanvragenTabel.getSelectionModel().selectedItemProperty().get().getStudentId().getVoornaam() + " " +
                    studentAanvragenTabel.getSelectionModel().selectedItemProperty().get().getStudentId().getFamilienaam() + "<br/><br/>" +
            "Uw aanvraag voor de stage van bedrijf " + studentAanvragenTabel.getSelectionModel().selectedItemProperty().get().getStageId().getBedrijfId().getBedrijfsNaam() +
                    " is goedgekeurd.<br/><br/>" +
            "met vriendelijke groeten,<br/>" +
            "het administrator-team.");
    } 
    
    private void saveStageAanvraagDetails(Studentstage stageaanvraag)
    {
        if (stageaanvraag != null)
        {         
            stageaanvraag.getStageId().setProjectTitel(projectTitelTxt.getText());
            stageaanvraag.getStageId().setProjectOmschrijving(projectOmschrijvingTxt.getText());
            stageaanvraag.getStageId().setSpecialisatie(specialisatieTxt.getText());
            stageaanvraag.getStageId().setPeriode(periodeTxt.getText());
            stageaanvraag.getStageId().setAantalStudenten(Integer.parseInt(aantalStudentenTxt.getText()));

            stageaanvraag.getStageId().getBedrijfId().setBedrijfsNaam(bedrijfsnaamTxt.getText());
            stageaanvraag.getStageId().getBedrijfId().setStraat(bedrijfStraatEnNrTxt.getText());
            stageaanvraag.getStageId().getBedrijfId().setGemeente(bedrijfsGemeenteTxt.getText());
            stageaanvraag.getStageId().getBedrijfId().setPostcode(Integer.parseInt(bedrijfPostcodeTxt.getText()));

            if (stageaanvraag.getStageId().getStagementorId() != null)
            {
                stageaanvraag.getStageId().getStagementorId().setVoornaam(mentorVoornaamTxt.getText());
                stageaanvraag.getStageId().getStagementorId().setFamilienaam(mentorFamilienaamTxt.getText());
                stageaanvraag.getStageId().getStagementorId().setFunctie(mentorFunctieTxt.getText());
                stageaanvraag.getStageId().getStagementorId().setTelefoon(mentorTelefoonTxt.getText());
                stageaanvraag.getStageId().getStagementorId().setEmail(mentorEmailTxt.getText());
            }

            if (stageaanvraag.getStageId().getContractondertekenaarId() != null)
            {
                stageaanvraag.getStageId().getContractondertekenaarId().setVoornaam(ondertekenaarVoornaamTxt.getText());
                stageaanvraag.getStageId().getContractondertekenaarId().setFamilienaam(ondertekenaarFamilienaamTxt.getText());
                stageaanvraag.getStageId().getContractondertekenaarId().setFunctie(ondertekenaarFunctieTxt.getText());
                stageaanvraag.getStageId().getContractondertekenaarId().setTelefoon(ondertekenaarTelefoonTxt.getText());
                stageaanvraag.getStageId().getContractondertekenaarId().setEmail(ondertekenaarEmailTxt.getText());
            }
        } 
    }

    @FXML
    private void keurafStageAanvraagDetails(ActionEvent action)
    {
        String reden;
        reden = (String)JOptionPane.showInputDialog(
                null,
                "Geef een geldige reden op voor het afkeuren van deze aanvraag:",
                "Student aanvraag afkeuren",
                JOptionPane.QUESTION_MESSAGE); 
        
        if (reden.isEmpty())
        {
            JOptionPane.showMessageDialog(
                null,
                "Deze actie werd geannuleerd wegens geen geldige reden.",
                "Student aanvraag afkeuren",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        saveStageAanvraagDetails(studentAanvragenTabel.getSelectionModel().selectedItemProperty().get());
        studentAanvragenTabel.getSelectionModel().selectedItemProperty().get().setGoedgekeurd(false);
        Mail.sendMail(studentAanvragenTabel.getSelectionModel().selectedItemProperty().get().getStudentId().getEmailHogent(), "Stage afgekeurd",
            "Geachte " + studentAanvragenTabel.getSelectionModel().selectedItemProperty().get().getStudentId().getVoornaam() + " " +
                    studentAanvragenTabel.getSelectionModel().selectedItemProperty().get().getStudentId().getFamilienaam() + "<br/><br/>" +
            "Uw aanvraag voor de stage van bedrijf " + studentAanvragenTabel.getSelectionModel().selectedItemProperty().get().getStageId().getBedrijfId().getBedrijfsNaam() +
                    " is helaas afgekeurd.<br/>" +
                    "Reden: " + reden + "<br/><br/>" +
            "met vriendelijke groeten,<br/>" +
            "het administrator-team.");
        //refresh list?
    } 
    
    @Override
    public void setApp(Main app)
    {
        this.application = app;
        studentAanvragenTabel.setItems(app.getStudentStageAanvraagData());
    }
    
    @Override
    public void setMaster(HomeController master) 
    {
        this.master = master;
    }

    @Override
    public void setUpWithModel(Model model)
    {
        this.model = model;
        
        if(model == null)
            System.out.println("No Link");
    }
}