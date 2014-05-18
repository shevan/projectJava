package admin;


import admin.model.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Font;

public class StageEditorController implements Initializable, ControllerInterface
{
    private Model model;
    private Main application;
    
    @FXML
    private TableView<Stage> begeleiderAanvragenTabel;
    @FXML
    private TableColumn<Stage, String> begeleiderKolom;
    @FXML
    private TableColumn<Stage, String> bedrijfKolom;
    @FXML
    private TextArea projectOmschrijvingTxt;
    @FXML
    private StageEditorController stageEditorController;
    @FXML
    private HomeController homeController;
    @FXML
    private TitledPane x2;
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
    private Font x3;
    @FXML
    private TitledPane stageTab;
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
    Button back;
    private HomeController master;
    
    @FXML
    private void goBack(ActionEvent action)
    {
        master.changeView(1);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        /*begeleiderKolom.setCellValueFactory( new Callback < CellDataFeatures < Stage, String >, ObservableValue < String > >()
        {
            @ Override
            public ObservableValue < String > call(CellDataFeatures < Stage, String > p )
            {
                return new ReadOnlyStringWrapper( ( p.getValue().getBegeleiderBegeleiderId() == null ) ? "" : p.getValue().getBegeleiderBegeleiderId().getFamilienaam()+" "+p.getValue().getBegeleiderBegeleiderId().getVoornaam());
            }
        });
        
        bedrijfKolom.setCellValueFactory( new Callback < CellDataFeatures < Stage, String >, ObservableValue < String > >()
        {
            @ Override
            public ObservableValue < String > call(CellDataFeatures < Stage, String > p )
            {
                return new ReadOnlyStringWrapper( ( p.getValue().getStageId().getBedrijfId().getBedrijfsNaam() == null ) ? "" : p.getValue().getStageId().getBedrijfId().getBedrijfsNaam());
            }
        });*/

        // Auto resize columns
        begeleiderAanvragenTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //showStageAanvraagDetails(null);
		
        // Listen for selection changes
        begeleiderAanvragenTabel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Stage>()
        {
            @Override
            public void changed(ObservableValue<? extends Stage> observable,
                            Stage oldValue, Stage newValue) {
                    showStageDetails(newValue);
            }
        });
    }    
   
    protected void showStageDetails(Stage stage)
    {
        emptyTextFields(); // moet geleegd worden, anders kunnen velden die op dit moment leeg moeten zijn nog oude gegevens van vorige stage bevatten
//        if (stageaanvraag != null)
//        {
//            projectTitelTxt.setText(stageaanvraag.getStageStageId().getProjectTitel());
//            projectOmschrijvingTxt.setText(stageaanvraag.getStageStageId().getProjectOmschrijving());
//            specialisatieTxt.setText(stageaanvraag.getStageStageId().getSpecialisatie());
//            periodeTxt.setText(stageaanvraag.getStageStageId().getPeriode());
//            aantalStudentenTxt.setText(stageaanvraag.getStageStageId().getAantalStudenten()+"");
//
//            bedrijfsnaamTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getBedrijfsNaam());
//            bedrijfStraatEnNrTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getStraat());
//            bedrijfsGemeenteTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getGemeente());
//            bedrijfPostcodeTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getPostcode()+"");
//
//            if (stageaanvraag.getStageStageId().getStagementorId() != null)
//            {
//                mentorVoornaamTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getVoornaam());
//                mentorFamilienaamTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getFamilienaam());
//                mentorFunctieTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getFunctie());
//                mentorTelefoonTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getTelefoon()+"");
//                mentorEmailTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getEmail());
//            }
//
//            if (stageaanvraag.getStageStageId().getContractondertekenaarId() != null)
//            {
//                ondertekenaarVoornaamTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getVoornaam());
//                ondertekenaarFamilienaamTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getFamilienaam());
//                ondertekenaarFunctieTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getFunctie());
//                ondertekenaarTelefoonTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getTelefoon()+"");
//                ondertekenaarEmailTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getEmail());
//            }
//        }
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
    
    private void saveStageDetails(Stage stage)
    {
//        if (stageaanvraag != null)
//        {         
//            stageaanvraag.getStageStageId().setProjectTitel(projectTitelTxt.getText());
//            stageaanvraag.getStageStageId().setProjectOmschrijving(projectOmschrijvingTxt.getText());
//            stageaanvraag.getStageStageId().setSpecialisatie(specialisatieTxt.getText());
//            stageaanvraag.getStageStageId().setPeriode(periodeTxt.getText());
//            stageaanvraag.getStageStageId().setAantalStudenten(Integer.parseInt(aantalStudentenTxt.getText()));
//
//            stageaanvraag.getStageStageId().getBedrijfId().setBedrijfsNaam(bedrijfsnaamTxt.getText());
//            stageaanvraag.getStageStageId().getBedrijfId().setStraat(bedrijfStraatEnNrTxt.getText());
//            stageaanvraag.getStageStageId().getBedrijfId().setGemeente(bedrijfsGemeenteTxt.getText());
//            stageaanvraag.getStageStageId().getBedrijfId().setPostcode(Integer.parseInt(bedrijfPostcodeTxt.getText()));
//
//            stageaanvraag.getStageStageId().getStagementorId().setVoornaam(mentorVoornaamTxt.getText());
//            stageaanvraag.getStageStageId().getStagementorId().setFamilienaam(mentorFamilienaamTxt.getText());
//            stageaanvraag.getStageStageId().getStagementorId().setFunctie(mentorFunctieTxt.getText());
//            stageaanvraag.getStageStageId().getStagementorId().setTelefoon(Integer.parseInt(mentorTelefoonTxt.getText()));
//            stageaanvraag.getStageStageId().getStagementorId().setEmail(mentorEmailTxt.getText());
//
//            stageaanvraag.getStageStageId().getContractondertekenaarId().setVoornaam(ondertekenaarVoornaamTxt.getText());
//            stageaanvraag.getStageStageId().getContractondertekenaarId().setFamilienaam(ondertekenaarFamilienaamTxt.getText());
//            stageaanvraag.getStageStageId().getContractondertekenaarId().setFunctie(ondertekenaarFunctieTxt.getText());
//            stageaanvraag.getStageStageId().getContractondertekenaarId().setTelefoon(Integer.parseInt(ondertekenaarTelefoonTxt.getText()));
//            stageaanvraag.getStageStageId().getContractondertekenaarId().setEmail(ondertekenaarEmailTxt.getText());
//        } 
    }
    
    public void setApp(Main app)
    {
        this.application = app;
        begeleiderAanvragenTabel.getItems().addAll(app.getStageData());
       
    }
    public void setMaster(HomeController master) 
    {
        this.master = master;
    }

    public void setUpWithModel(Model model)
    {
        this.model = model;
        
        if(model == null)
            System.out.println("No Link");
    }
}
