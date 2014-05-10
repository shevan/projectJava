/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import admin.model.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    private TableView<Begeleiderstageaanvraag> begeleiderTabel;
    @FXML
    private TableColumn<Begeleiderstageaanvraag, String> begeleiderKolom;
    @FXML
    private TableColumn<Begeleiderstageaanvraag, String> studentKolom;

    @FXML
    private Label firstNameLabel;
        
    @FXML
    private BegeleiderStageController begeleiderStageController;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        begeleiderKolom.setCellValueFactory( new Callback < CellDataFeatures < Begeleiderstageaanvraag, String >, ObservableValue < String > >(){ @ Override
        public ObservableValue < String > call(CellDataFeatures < Begeleiderstageaanvraag, String > p ) {
            return new ReadOnlyStringWrapper( ( p.getValue().getBegeleiderBegeleiderId() == null ) ? "" : p.getValue().getBegeleiderBegeleiderId().getFamilienaam()+" "+p.getValue().getBegeleiderBegeleiderId().getVoornaam()); }});
        
        studentKolom.setCellValueFactory( new Callback < CellDataFeatures < Begeleiderstageaanvraag, String >, ObservableValue < String > >(){ @ Override
        public ObservableValue < String > call(CellDataFeatures < Begeleiderstageaanvraag, String > p ) {
            return new ReadOnlyStringWrapper( ( p.getValue().getStageStageId().getBedrijfId().getBedrijfsNaam() == null ) ? "" : p.getValue().getStageStageId().getBedrijfId().getBedrijfsNaam()); }});
        
        // Auto resize columns
        begeleiderTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        // clear person
	showStageDetails(null);
		
        // Listen for selection changes
        begeleiderTabel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Begeleiderstageaanvraag>() {

                @Override
                public void changed(ObservableValue<? extends Begeleiderstageaanvraag> observable,
                                Begeleiderstageaanvraag oldValue, Begeleiderstageaanvraag newValue) {
                        showStageDetails(newValue);
                }
        });
    }    
   
    
    private void showStageDetails(Begeleiderstageaanvraag stage) {
		if (stage != null) {
			firstNameLabel.setText(stage.getStageStageId().getProjectTitel());
		} else {
			firstNameLabel.setText("");
		}
	}
    
    void setApp(Main app) {
        
        this.application=app;
        begeleiderTabel.getItems().addAll(app.getBegeleiderStageAanvraagData());
       
    }
    
    

    void setUpWithModel(Model model) {
        this.model = model;
        if(model==null) System.out.println("No Link");
    }
    
}
