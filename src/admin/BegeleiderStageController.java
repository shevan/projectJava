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
    private TableView<Student> begeleiderTabel;
    @FXML
    private TableColumn<Student, String> begeleiderKolom;
    @FXML
    private TableColumn<Student, String> studentKolom;

    @FXML
    private BegeleiderStageController begeleiderStageController;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   //     begeleiderKolom.setCellValueFactory(new PropertyValueFactory<Stage, String>("stageStageId"));
  //    begeleiderKolom.setCellValueFactory(new PropertyValueFactory<Begeleider, String>("voornaam"));
   //     studentKolom.setCellValueFactory(Stage.class);
    begeleiderKolom.setCellValueFactory( new Callback < CellDataFeatures < Student, String >, ObservableValue < String > >()
            {

                @ Override
                public ObservableValue < String > call(
                    CellDataFeatures < Student, String > p )
                {

                    return new ReadOnlyStringWrapper( ( p.getValue()
                        .getGemeente()== null )
                        ? ""
                        : p.getValue()
                            .getStageStageId().getHardware());
                }

            } );
  //    studentKolom.setCellValueFactory(new SimpleStringProperty("sdf"));
		// Auto resize columns
      begeleiderTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }    
    public abstract class CellValueFactory<S, T> implements Callback<TableColumn.CellDataFeatures<S,T>,ObservableValue<T>> {

    @Override
    public final ObservableValue<T> call(TableColumn.CellDataFeatures<S,T> p) {
        return createObservableValue(p.getTableView(), p.getTableColumn(), p.getValue());
    }
    
    protected abstract ObservableValue<T> createObservableValue (TableView<S> table, TableColumn<S,T> column, S value);
}

    void setApp(Main app) {
        
        this.application=app;
         begeleiderTabel.getItems().addAll(app.getStudentData());
    //     System.print.out()
    //    begeleiderTabel.setItems(app.getStudentData());
        
   //     model.test();
 //       begeleiderTabel.setItems(model.test());
        
    }
    
    

    void setUpWithModel(Model model) {
        this.model = model;
        if(model==null) System.out.println("No Link");
    }
    
}
