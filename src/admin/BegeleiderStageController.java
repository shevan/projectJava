/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import admin.model.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Shevan
 */
    public class BegeleiderStageController implements Initializable {
    private Model model;
    private Main application;
    
    @FXML
    private TableView<Begeleider> begeleiderTabel;
    @FXML
    private TableColumn<Begeleider, String> begeleiderKolom;
    @FXML
    private TableColumn<Begeleider, String> studentKolom;

    @FXML
    private BegeleiderStageController begeleiderStageController;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      begeleiderKolom.setCellValueFactory(new PropertyValueFactory<Begeleider, String>("voornaam"));
      studentKolom.setCellValueFactory(new PropertyValueFactory<Begeleider, String>("voornaam"));
		// Auto resize columns
      begeleiderTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }    

    void setApp(Main app) {
        
        this.application=app;
        begeleiderTabel.setItems(app.getBegeleiderData());
   //     model.test();
 //       begeleiderTabel.setItems(model.test());
        
    }
    
    

    void setUpWithModel(Model model) {
        this.model = model;
        if(model==null) System.out.println("No Link");
    }
    
}
