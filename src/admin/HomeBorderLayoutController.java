/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import admin.model.Begeleiderstageaanvraag;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Pieter Pletinckx
 */
public class HomeBorderLayoutController implements Initializable 
{    
    private Main application;
    private Model model;
    
    @FXML
    private TitledPane x2;
    @FXML
    private Font x3;
    @FXML
    private Font x1;
    @FXML
    private BorderPane begeleidersStageEditor;
    @FXML
    private BorderPane bewerkScherm;

    /**
     * BegeleidersStageEditorElementen
     */
        @FXML
    private TableView<Begeleiderstageaanvraag> begeleiderAanvragenTabel;
    @FXML
    private TableColumn<Begeleiderstageaanvraag, String> begeleiderKolom;
    @FXML
    private TableColumn<Begeleiderstageaanvraag, String> bedrijfKolom;
    @FXML
    private TableColumn<Begeleiderstageaanvraag, String> StudentKolom;
    @FXML
    private TableColumn<Begeleiderstageaanvraag, String> StageKolom;
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
    /**
     * BegeleiderStageEditor Methodes
     */
        public void initBegeleiderStageEditor()
        {
            System.out.println("initBegeleider called");
            begeleiderKolom.setCellValueFactory( new Callback < TableColumn.CellDataFeatures < Begeleiderstageaanvraag, String >, ObservableValue < String > >()
            {
                @Override
                public ObservableValue < String > call(TableColumn.CellDataFeatures < Begeleiderstageaanvraag, String > p )
                {
                    return new ReadOnlyStringWrapper( ( p.getValue().getBegeleiderBegeleiderId() == null ) ? "" : p.getValue().getBegeleiderBegeleiderId().getFamilienaam()+" "+p.getValue().getBegeleiderBegeleiderId().getVoornaam());
                }
            });

            bedrijfKolom.setCellValueFactory( new Callback < TableColumn.CellDataFeatures < Begeleiderstageaanvraag, String >, ObservableValue < String > >()
            {
                @Override
                public ObservableValue < String > call(TableColumn.CellDataFeatures < Begeleiderstageaanvraag, String > p )
                {
                    return new ReadOnlyStringWrapper( ( p.getValue().getStageStageId().getBedrijfId().getBedrijfsNaam() == null ) ? "" : p.getValue().getStageStageId().getBedrijfId().getBedrijfsNaam());
                }
            });

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
        protected void showStageAanvraagDetails(Begeleiderstageaanvraag stageaanvraag)
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

        //hercode pieter
        //prior 80
        private void InitialiseerBegeleiderAanvraag(){
            //verwijder ongebruikte tabel kolommen
            //gray out ongebruikte veld waarden
            //vul data in tabel
            List data = model.getBegeleiderStageAanvraagFromDatabase();
        }
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    public void setApp(Main application)
    {
        this.application = application;
    }
    
    public void setUpWithModel(Model model)
    {
        this.model = model;
        
        if (model == null)
            System.out.println("No link");
    }

    /**
     * Knoppen bovenaan het scherm
     * @param event 
     */
    @FXML
    private void displayBegeleiderStageAanvragen(ActionEvent event) { //prior 80
        hideAllViews();
        initBegeleiderStageEditor(); //zorg dat alle knoppen voor deze case staan ingesteld
        begeleidersStageEditor.setVisible(true);
    }
    @FXML
    private void displayStagevoorstel (ActionEvent event) { //prior 60
        hideAllViews();
        //voegdata toe aan view
        //stageAanvraagEditor.setVisible(true);
        
    }
    @FXML
    private void displayStudentenStageAanvragen(ActionEvent event) { // geen prior
        hideAllViews();
    }

    @FXML
    private void displayStages(ActionEvent event) {
        hideAllViews();
    }

    @FXML
    private void displayStudenten(ActionEvent event) {
        hideAllViews();
    }

    @FXML
    private void displayBedrijven(ActionEvent event) {
        hideAllViews();
    }

    @FXML
    private void displayGebruikers(ActionEvent event) {
        hideAllViews();
    }
    

    private void hideAllViews(){
        begeleidersStageEditor.setVisible(false);
       // stageAanvraagEditor.setVisible(false);
    }
    
}
