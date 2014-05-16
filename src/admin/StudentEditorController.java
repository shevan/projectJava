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

public class StudentEditorController implements Initializable
{
    private Model model;
    private Main application;
    
    @FXML
    private TableView<Student> begeleiderAanvragenTabel;
    @FXML
    private TableColumn<Student, String> begeleiderKolom;
    @FXML
    private TableColumn<Student, String> bedrijfKolom;
    @FXML
    private TextArea projectOmschrijvingTxt;
    @FXML
    private BegeleiderStageEditorController studentEditorController;
    @FXML
    private HomeController homeController;
    @FXML 
    Button back;
    private HoofdSchermController master;
    
    @FXML
    private void goBack(ActionEvent action)
    {
        master.changeView(1);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        /*begeleiderKolom.setCellValueFactory( new Callback < CellDataFeatures < Student, String >, ObservableValue < String > >(){ @ Override
        public ObservableValue < String > call(CellDataFeatures < Student, String > p ) {
            return new ReadOnlyStringWrapper( ( p.getValue().getBegeleiderBegeleiderId() == null ) ? "" : p.getValue().getBegeleiderBegeleiderId().getFamilienaam()+" "+p.getValue().getBegeleiderBegeleiderId().getVoornaam()); }});
        
        bedrijfKolom.setCellValueFactory( new Callback < CellDataFeatures < Student, String >, ObservableValue < String > >(){ @ Override
        public ObservableValue < String > call(CellDataFeatures < Student, String > p ) {
            return new ReadOnlyStringWrapper( ( p.getValue().getStageStageId().getBedrijfId().getBedrijfsNaam() == null ) ? "" : p.getValue().getStageStageId().getBedrijfId().getBedrijfsNaam()); }});
        */
        // Auto resize columns
        begeleiderAanvragenTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
        // Listen for selection changes
        begeleiderAanvragenTabel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>()
        {
            @Override
            public void changed(ObservableValue<? extends Student> observable,
                            Student oldValue, Student newValue) {
                    showStudentDetails(newValue);
            }
        });
    }    
   
    protected void showStudentDetails(Student student)
    {
        emptyTextFields(); // moet geleegd worden, anders kunnen velden die nu leeg moeten zijn nog oude gegevens van vorige stage bevatten
        /*if (stageaanvraag != null)
        {
            projectTitelTxt.setText(stageaanvraag.getStageStageId().getProjectTitel());
            projectOmschrijvingTxt.setText(stageaanvraag.getStageStageId().getProjectOmschrijving());
            specialisatieTxt.setText(stageaanvraag.getStageStageId().getSpecialisatie());
            periodeTxt.setText(stageaanvraag.getStageStageId().getPeriode());
            aantalStudentenTxt.setText(stageaanvraag.getStageStageId().getAantalStudenten()+"");

            bedrijfsnaamTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getBedrijfsNaam());
            bedrijfStraatEnNrTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getStraat());
            bedrijfsGemeenteTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getGemeente());
            bedrijfPostcodeTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getPostcode()+"");

            if (stageaanvraag.getStageStageId().getStagementorId() != null)
            {
                mentorVoornaamTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getVoornaam());
                mentorFamilienaamTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getFamilienaam());
                mentorFunctieTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getFunctie());
                mentorTelefoonTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getTelefoon()+"");
                mentorEmailTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getEmail());
            }

            if (stageaanvraag.getStageStageId().getContractondertekenaarId() != null)
            {
                ondertekenaarVoornaamTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getVoornaam());
                ondertekenaarFamilienaamTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getFamilienaam());
                ondertekenaarFunctieTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getFunctie());
                ondertekenaarTelefoonTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getTelefoon()+"");
                ondertekenaarEmailTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getEmail());
            }
        } */
    }
    
    private void emptyTextFields()
    {
        //projectTitelTxt.setText("");
    }
    
    private void saveStudentDetails(Student student)
    {
        /*if (stageaanvraag != null)
        {         
            stageaanvraag.getStageStageId().setProjectTitel(projectTitelTxt.getText());
            stageaanvraag.getStageStageId().setProjectOmschrijving(projectOmschrijvingTxt.getText());
            stageaanvraag.getStageStageId().setSpecialisatie(specialisatieTxt.getText());
            stageaanvraag.getStageStageId().setPeriode(periodeTxt.getText());
            stageaanvraag.getStageStageId().setAantalStudenten(Integer.parseInt(aantalStudentenTxt.getText()));

            stageaanvraag.getStageStageId().getBedrijfId().setBedrijfsNaam(bedrijfsnaamTxt.getText());
            stageaanvraag.getStageStageId().getBedrijfId().setStraat(bedrijfStraatEnNrTxt.getText());
            stageaanvraag.getStageStageId().getBedrijfId().setGemeente(bedrijfsGemeenteTxt.getText());
            stageaanvraag.getStageStageId().getBedrijfId().setPostcode(Integer.parseInt(bedrijfPostcodeTxt.getText()));

            stageaanvraag.getStageStageId().getStagementorId().setVoornaam(mentorVoornaamTxt.getText());
            stageaanvraag.getStageStageId().getStagementorId().setFamilienaam(mentorFamilienaamTxt.getText());
            stageaanvraag.getStageStageId().getStagementorId().setFunctie(mentorFunctieTxt.getText());
            stageaanvraag.getStageStageId().getStagementorId().setTelefoon(Integer.parseInt(mentorTelefoonTxt.getText()));
            stageaanvraag.getStageStageId().getStagementorId().setEmail(mentorEmailTxt.getText());

            stageaanvraag.getStageStageId().getContractondertekenaarId().setVoornaam(ondertekenaarVoornaamTxt.getText());
            stageaanvraag.getStageStageId().getContractondertekenaarId().setFamilienaam(ondertekenaarFamilienaamTxt.getText());
            stageaanvraag.getStageStageId().getContractondertekenaarId().setFunctie(ondertekenaarFunctieTxt.getText());
            stageaanvraag.getStageStageId().getContractondertekenaarId().setTelefoon(Integer.parseInt(ondertekenaarTelefoonTxt.getText()));
            stageaanvraag.getStageStageId().getContractondertekenaarId().setEmail(ondertekenaarEmailTxt.getText());
        } */
    }
    
    void setApp(Main app) {
        
        this.application=app;
        begeleiderAanvragenTabel.getItems().addAll(app.getStudentData());
       
    }
    public void setMaster(HoofdSchermController master) 
    {
        this.master = master;
    }

    void setUpWithModel(Model model) {
        this.model = model;
        if(model==null) System.out.println("No Link");
    }
    
    public void bewerkGegevens (Student student)
    {
        showStudentDetails(student);
    }
}