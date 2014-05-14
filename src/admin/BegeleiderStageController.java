/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import admin.model.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;
/**
 * FXML Controller class
 *
 * @author Shevan
 */
    public class BegeleiderStageController implements Initializable {
    private Model model;
    private Main application;
    
    @FXML
    private TableView<Begeleiderstageaanvraag> begeleiderAanvragenTabel;
    @FXML
    private TableColumn<Begeleiderstageaanvraag, String> begeleiderKolom;
    @FXML
    private TableColumn<Begeleiderstageaanvraag, String> bedrijfKolom;
    @FXML
    private TextArea projectOmschrijvingTxt;
    @FXML
    private BegeleiderStageController begeleiderStageController;
    @FXML
    private OverzichtController overzichtController;
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
    private HoofdSchermController master;
    
    @FXML
    private void goBack(ActionEvent action)
    {
        master.changeView(1);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        begeleiderKolom.setCellValueFactory( new Callback < CellDataFeatures < Begeleiderstageaanvraag, String >, ObservableValue < String > >(){ @ Override
        public ObservableValue < String > call(CellDataFeatures < Begeleiderstageaanvraag, String > p ) {
            return new ReadOnlyStringWrapper( ( p.getValue().getBegeleiderBegeleiderId() == null ) ? "" : p.getValue().getBegeleiderBegeleiderId().getFamilienaam()+" "+p.getValue().getBegeleiderBegeleiderId().getVoornaam()); }});
        
        bedrijfKolom.setCellValueFactory( new Callback < CellDataFeatures < Begeleiderstageaanvraag, String >, ObservableValue < String > >(){ @ Override
        public ObservableValue < String > call(CellDataFeatures < Begeleiderstageaanvraag, String > p ) {
            return new ReadOnlyStringWrapper( ( p.getValue().getStageStageId().getBedrijfId().getBedrijfsNaam() == null ) ? "" : p.getValue().getStageStageId().getBedrijfId().getBedrijfsNaam()); }});
        
        // Auto resize columns
        begeleiderAanvragenTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        
	showStageAanvraagDetails(null);
		
        // Listen for selection changes
        begeleiderAanvragenTabel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Begeleiderstageaanvraag>()
        {
            @Override
            public void changed(ObservableValue<? extends Begeleiderstageaanvraag> observable,
                            Begeleiderstageaanvraag oldValue, Begeleiderstageaanvraag newValue) {
                    showStageAanvraagDetails(newValue);
            }
        });
    }    
   
    private void showStageAanvraagDetails(Begeleiderstageaanvraag stageaanvraag)
    {
        emptyTextFields(); // moet geleegd worden, anders kunnen velden die nu leeg moeten zijn nog oude gegevens van vorige stage bevatten
        if (stageaanvraag != null)
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
    
    private void saveStageAanvraagDetails(Begeleiderstageaanvraag stageaanvraag)
    {
        if (stageaanvraag != null)
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
        } 
    }
    
    void setApp(Main app) {
        
        this.application=app;
        begeleiderAanvragenTabel.getItems().addAll(app.getBegeleiderStageAanvraagData());
       
    }
    public void setMaster(HoofdSchermController master) 
    {
        this.master = master;
    }

    void setUpWithModel(Model model) {
        this.model = model;
        if(model==null) System.out.println("No Link");
    }
    
    public OverzichtController getOController() //vervangen door loader
    {
        return overzichtController;
    }
    //navigatie

    // Methodes voor configureren van deze vieuw per gebruik
    public void bewerkGegevens (Stage stage)
    {
        //showStageAanvraagDetails(master.getOController.);
    }

    public void bewerkGegevens (Begeleiderstageaanvraag stageaanvraag)
    {
        showStageAanvraagDetails(stageaanvraag);
    }
    
    public void bewerkGegevens (Bedrijf bedrijf)
    {
        
    }
    
    public void bewerkGegevens (Student student)
    {
        
    }
    
    public void bewerkGegevens (Begeleider begeleider)
    {
        
    }
    
    public void bewerkGegevens (/*contactondertekenaar*/)
    {
        
    }
    
    
    
    
}
