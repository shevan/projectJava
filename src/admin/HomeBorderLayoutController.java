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
                    return new ReadOnlyStringWrapper( ( p.getValue().getBegeleiderId() == null ) ? "" : p.getValue().getBegeleiderId().getFamilienaam()+" "+p.getValue().getBegeleiderId().getVoornaam());
                }
            });

            bedrijfKolom.setCellValueFactory( new Callback < TableColumn.CellDataFeatures < Begeleiderstageaanvraag, String >, ObservableValue < String > >()
            {
                @Override
                public ObservableValue < String > call(TableColumn.CellDataFeatures < Begeleiderstageaanvraag, String > p )
                {
                    return new ReadOnlyStringWrapper( ( p.getValue().getStageId().getBedrijfId().getBedrijfsNaam() == null ) ? "" : p.getValue().getStageId().getBedrijfId().getBedrijfsNaam());
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
        private void saveStageAanvraagDetails(Begeleiderstageaanvraag stageaanvraag)
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

                stageaanvraag.getStageId().getStagementorId().setVoornaam(mentorVoornaamTxt.getText());
                stageaanvraag.getStageId().getStagementorId().setFamilienaam(mentorFamilienaamTxt.getText());
                stageaanvraag.getStageId().getStagementorId().setFunctie(mentorFunctieTxt.getText());
                stageaanvraag.getStageId().getStagementorId().setTelefoon(mentorTelefoonTxt.getText());
                stageaanvraag.getStageId().getStagementorId().setEmail(mentorEmailTxt.getText());

                stageaanvraag.getStageId().getContractondertekenaarId().setVoornaam(ondertekenaarVoornaamTxt.getText());
                stageaanvraag.getStageId().getContractondertekenaarId().setFamilienaam(ondertekenaarFamilienaamTxt.getText());
                stageaanvraag.getStageId().getContractondertekenaarId().setFunctie(ondertekenaarFunctieTxt.getText());
                stageaanvraag.getStageId().getContractondertekenaarId().setTelefoon(ondertekenaarTelefoonTxt.getText());
                stageaanvraag.getStageId().getContractondertekenaarId().setEmail(ondertekenaarEmailTxt.getText());
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
