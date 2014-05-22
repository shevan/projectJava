package admin;

import admin.model.*;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class StagesEditorController implements Initializable, ControllerInterface
{
    private Main application;
    private Model model;
    private HomeController master;
    
    @FXML
    private TableView<Stages> stageAanvragenTabel;
    @FXML
    private TableColumn<Stages, String> bedrijfKolom;
    @FXML
    private TableColumn<Stages, String> specialisatieKolom;
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
    private TextField beginDatumTxt;
    @FXML
    private TextField eindDatumTxt;    
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
    private Button btnOpslaan;        
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // only called when controller is run directly, not when going through HomeController
        
    }
    
    public void initStageEditor()
    {   
        bedrijfKolom.setCellValueFactory( new Callback < CellDataFeatures < Stages, String >, ObservableValue < String > >()
        {
            @Override
            public ObservableValue < String > call(CellDataFeatures < Stages, String > p )
            {
                return new ReadOnlyStringWrapper( ( p.getValue().getBedrijfId().getBedrijfsNaam() == null ) ? "" : p.getValue().getBedrijfId().getBedrijfsNaam());
            }        
        });
        
        specialisatieKolom.setCellValueFactory( new Callback < CellDataFeatures < Stages, String >, ObservableValue < String > >()
        {
            @Override
            public ObservableValue < String > call(CellDataFeatures < Stages, String > p )
            {
                return new ReadOnlyStringWrapper( ( p.getValue().getStageId() == null ) ? "" : p.getValue().getSpecialisatie());
            }
        });

        // Auto resize columns
        stageAanvragenTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        studentAanvragenTabel.getSelectionModel().select(0);
        
//        showStageAanvraagDetails(null); //dit doet absoluut niets        
        
        // Listen for selection changes
        stageAanvragenTabel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Stages>()
        {
            @Override
            public void changed(ObservableValue<? extends Stages> observable,
                            Stages oldValue, Stages newValue) {
                    showStageAanvraagDetails(newValue); //laad new values in bewerkscherm
            }
        });
    }     
         
    protected void showStageAanvraagDetails(Stages stageaanvraag)
    {
        emptyTextFields(); // moet geleegd worden, anders kunnen velden die nu leeg moeten zijn nog oude gegevens van vorige stage bevatten
        if (stageaanvraag != null)
        {
            projectTitelTxt.setText(stageaanvraag.getProjectTitel());
            projectOmschrijvingTxt.setText(stageaanvraag.getProjectOmschrijving());
            specialisatieTxt.setText(stageaanvraag.getSpecialisatie());
            periodeTxt.setText(stageaanvraag.getPeriode());
            
            if (stageaanvraag.getStageBegindatum() != null)
            {
                SimpleDateFormat formatDateToString = new SimpleDateFormat("dd-MM-yyyy");
                String beginDatum = formatDateToString.format(stageaanvraag.getStageBegindatum());                                   
                beginDatumTxt.setText(beginDatum);
            }
               
            if (stageaanvraag.getStageEindatum() != null)
            {
                SimpleDateFormat formatDateToString = new SimpleDateFormat("dd-MM-yyyy");
                String eindDatum = formatDateToString.format(stageaanvraag.getStageEindatum());                                   
                eindDatumTxt.setText(eindDatum);
            }
            
            aantalStudentenTxt.setText(stageaanvraag.getAantalStudenten()+"");

            bedrijfsnaamTxt.setText(stageaanvraag.getBedrijfId().getBedrijfsNaam());
            bedrijfStraatEnNrTxt.setText(stageaanvraag.getBedrijfId().getStraat());
            bedrijfsGemeenteTxt.setText(stageaanvraag.getBedrijfId().getGemeente());
            bedrijfPostcodeTxt.setText(stageaanvraag.getBedrijfId().getPostcode()+"");

            if (stageaanvraag.getStagementorId() != null)
            {
                mentorVoornaamTxt.setText(stageaanvraag.getStagementorId().getVoornaam());
                mentorFamilienaamTxt.setText(stageaanvraag.getStagementorId().getFamilienaam());
                mentorFunctieTxt.setText(stageaanvraag.getStagementorId().getFunctie());
                mentorTelefoonTxt.setText(stageaanvraag.getStagementorId().getTelefoon()+"");
                mentorEmailTxt.setText(stageaanvraag.getStagementorId().getEmail());
            }

            if (stageaanvraag.getContractondertekenaarId() != null)
            {
                ondertekenaarVoornaamTxt.setText(stageaanvraag.getContractondertekenaarId().getVoornaam());
                ondertekenaarFamilienaamTxt.setText(stageaanvraag.getContractondertekenaarId().getFamilienaam());
                ondertekenaarFunctieTxt.setText(stageaanvraag.getContractondertekenaarId().getFunctie());
                ondertekenaarTelefoonTxt.setText(stageaanvraag.getContractondertekenaarId().getTelefoon()+"");
                ondertekenaarEmailTxt.setText(stageaanvraag.getContractondertekenaarId().getEmail());
            }
        } 
    }
    
    private void emptyTextFields()
    {
        projectTitelTxt.setText("");
        projectOmschrijvingTxt.setText("");
        specialisatieTxt.setText("");
        periodeTxt.setText("");
        beginDatumTxt.setText("");
        eindDatumTxt.setText("");
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
    private void opslaanStageAanvraagDetails(ActionEvent action)
    {
        saveStageAanvraagDetails(stageAanvragenTabel.getSelectionModel().selectedItemProperty().get());
    }      
    
    private void saveStageAanvraagDetails(Stages stageaanvraag)
    {
        if (stageaanvraag != null)
        {         
            stageaanvraag.setProjectTitel(projectTitelTxt.getText());
            stageaanvraag.setProjectOmschrijving(projectOmschrijvingTxt.getText());
            stageaanvraag.setSpecialisatie(specialisatieTxt.getText());
            stageaanvraag.setPeriode(periodeTxt.getText());
            
            if (!beginDatumTxt.getText().isEmpty())
            {
                Date beginDatum = null;
                try {
                    beginDatum = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH).parse(beginDatumTxt.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(StagesEditorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stageaanvraag.setStageBegindatum(beginDatum);
            }
            if (!eindDatumTxt.getText().isEmpty())
            {
                Date eindDatum = null;
                try {
                    eindDatum = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH).parse(eindDatumTxt.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(StagesEditorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stageaanvraag.setStageEindatum(eindDatum);
            }
            
            stageaanvraag.setAantalStudenten(Integer.parseInt(aantalStudentenTxt.getText()));

            stageaanvraag.getBedrijfId().setBedrijfsNaam(bedrijfsnaamTxt.getText());
            stageaanvraag.getBedrijfId().setStraat(bedrijfStraatEnNrTxt.getText());
            stageaanvraag.getBedrijfId().setGemeente(bedrijfsGemeenteTxt.getText());
            stageaanvraag.getBedrijfId().setPostcode(Integer.parseInt(bedrijfPostcodeTxt.getText()));

            if (stageaanvraag.getStagementorId() != null)
            {
                stageaanvraag.getStagementorId().setVoornaam(mentorVoornaamTxt.getText());
                stageaanvraag.getStagementorId().setFamilienaam(mentorFamilienaamTxt.getText());
                stageaanvraag.getStagementorId().setFunctie(mentorFunctieTxt.getText());
                stageaanvraag.getStagementorId().setTelefoon(mentorTelefoonTxt.getText());
                stageaanvraag.getStagementorId().setEmail(mentorEmailTxt.getText());
            }

            if (stageaanvraag.getContractondertekenaarId() != null)
            {
                stageaanvraag.getContractondertekenaarId().setVoornaam(ondertekenaarVoornaamTxt.getText());
                stageaanvraag.getContractondertekenaarId().setFamilienaam(ondertekenaarFamilienaamTxt.getText());
                stageaanvraag.getContractondertekenaarId().setFunctie(ondertekenaarFunctieTxt.getText());
                stageaanvraag.getContractondertekenaarId().setTelefoon(ondertekenaarTelefoonTxt.getText());
                stageaanvraag.getContractondertekenaarId().setEmail(ondertekenaarEmailTxt.getText());
            }
        } 
    }
    
    @Override
    public void setApp(Main app)
    {
        this.application = app;
        stageAanvragenTabel.setItems(app.getStageAanvraagData());
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