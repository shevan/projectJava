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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
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
    private Button terugBtn;
    @FXML
    private Button aanvaardenBtn;
    @FXML
    private Button WeigerenBtn;
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
    private TitledPane x2;
    @FXML
    private TextField ondertekenaarNaamTxt;
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
    private TextField mentorNaamTxt;
    @FXML
    private TextField mentorFunctieTxt;
    @FXML
    private TextField mentorTelefoonTxt;
    @FXML
    private TextField mentorEmailTxt;
    
    private int begeleiderAanvraagId;
    
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
        begeleiderAanvraagId = 0;
        aanvaardenBtn.setVisible(false);
        WeigerenBtn.setVisible(false);
		
        // Listen for selection changes
        begeleiderAanvragenTabel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Begeleiderstageaanvraag>() { @Override
                public void changed(ObservableValue<? extends Begeleiderstageaanvraag> observable, Begeleiderstageaanvraag oldValue, Begeleiderstageaanvraag newValue) {
                        showStageAanvraagDetails(newValue); }});
    }    
   
    private void showStageAanvraagDetails(Begeleiderstageaanvraag stageaanvraag) {
        if (stageaanvraag != null) {
                projectTitelTxt.setText(stageaanvraag.getStageStageId().getProjectTitel());
                projectOmschrijvingTxt.setText(stageaanvraag.getStageStageId().getProjectOmschrijving());
                specialisatieTxt.setText(stageaanvraag.getStageStageId().getSpecialisatie());
                periodeTxt.setText(stageaanvraag.getStageStageId().getPeriode());
                aantalStudentenTxt.setText(stageaanvraag.getStageStageId().getAantalStudenten()+"");

                bedrijfsnaamTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getBedrijfsNaam());
                bedrijfStraatEnNrTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getStraat());
                bedrijfsGemeenteTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getGemeente());
                bedrijfPostcodeTxt.setText(stageaanvraag.getStageStageId().getBedrijfId().getPostcode()+"");

                mentorNaamTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getVoornaam()+" "+stageaanvraag.getStageStageId().getStagementorId().getFamilienaam());
                mentorFunctieTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getFunctie());
                mentorTelefoonTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getTelefoon()+"");
                mentorEmailTxt.setText(stageaanvraag.getStageStageId().getStagementorId().getEmail());

                ondertekenaarNaamTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getVoornaam()+" "+stageaanvraag.getStageStageId().getContractondertekenaarId().getFamilienaam());
                ondertekenaarFunctieTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getFunctie());
                ondertekenaarTelefoonTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getTelefoon()+"");
                ondertekenaarEmailTxt.setText(stageaanvraag.getStageStageId().getContractondertekenaarId().getEmail());
                
                aanvaardenBtn.setVisible(true);
                WeigerenBtn.setVisible(true);
               
        } 
                
    }
    
    @FXML
    private void handleAanvaardStageAanvraag() {
            int selectedIndex = begeleiderAanvragenTabel.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                  model.setBegeleiderStageAanvraagGoedgekeurd(begeleiderAanvragenTabel.getSelectionModel().getSelectedItem().getBegeleiderStageAanvraagId());
                  begeleiderAanvragenTabel.getItems().remove(selectedIndex);
            } 
            else 
                Dialogs.showWarningDialog(application.getStage(),"Gelieve een aanvraag te selecteren uit het lijst");
    }
    
    @FXML
    private void handleWeigerStageAanvraag() {
            int selectedIndex = begeleiderAanvragenTabel.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                  model.setBegeleiderStageAanvraagGeweigerd(begeleiderAanvragenTabel.getSelectionModel().getSelectedItem().getBegeleiderStageAanvraagId());
                  begeleiderAanvragenTabel.getItems().remove(selectedIndex);
                  aanvaardenBtn.setVisible(false);
                WeigerenBtn.setVisible(false);
            } 
            else 
                Dialogs.showWarningDialog(application.getStage(),"Gelieve een aanvraag te selecteren uit het lijst");
    }
    
    void setApp(Main app) {
        
        this.application=app;
        begeleiderAanvragenTabel.getItems().addAll(app.getBegeleiderStageAanvraagData());
       
    }
    
    

    void setUpWithModel(Model model) {
        this.model = model;
        if(model==null) System.out.println("No Link");
    }
    
}
