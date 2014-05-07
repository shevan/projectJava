/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Pieter Pletinckx
 */
public class HoofdSchermController extends VBox implements Initializable {
    private Model model;
    private Main application;
    final ObservableList<String> taskListItems = FXCollections.observableArrayList("");
    /**
     * Controllers
     */
    @FXML
    private OverzichtController overzichtController;
    
    //@FXML
    //private  "die andere controller"
       
    /**
     * Views
     */
    @FXML
    private AnchorPane overzicht ;
    
    @FXML
    private AnchorPane moderatieScherm;
    
    /**
     * Andere Elementen
     */
    @FXML
    private TitledPane takenlijst;
    
    @FXML 
    private ListView<String> takenListView;

    
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        takenListView.setItems(taskListItems);
        linkNumberOfTasks();
        //test
        taskListItems.add("item");
    }    

    void setApp(Main app) {
        this.application=app;
    }

    void setUpWithModel(Model model) {
        this.model = model;
        if(model==null) System.out.println("No Link");
        if(overzichtController==null) System.out.println("No controler");
        overzichtController.setUpWithModel(model);
    }
    public void linkNumberOfTasks(){
        taskListItems.addListener(new ListChangeListener<String>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends String> change) {
                takenlijst.setText("Taken ("+taskListItems.size()+")");
                //set css id
            }
        });
    }
    
}
