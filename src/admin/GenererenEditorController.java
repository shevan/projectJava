package admin;

import admin.model.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

public class GenererenEditorController implements Initializable, ControllerInterface
{
    private Main application;
    private Model model;
    private HomeController master;
    
    @FXML
    private TableView<Stages> genererenTabel;
    @FXML
    private TableColumn<Stages, String> stageKolom;
    @FXML
    private TableColumn<Stages, String> bedrijfKolom;

    @FXML
    private Button btnFilter;
    @FXML
    private Button btnGenereer;     
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // only called when controller is run directly, not when going through HomeController
        
    }

    public void initGenererenEditor()
    {   
//        stageKolom.setCellValueFactory( new Callback < CellDataFeatures < Stages, String >, ObservableValue < String > >()
//        {
//            @Override
//            public ObservableValue < String > call(CellDataFeatures < Stages, String > p )
//            {
//                return new ReadOnlyStringWrapper( ( p.getValue().getStageId() == null ) ? "" : p.getValue().getStudentCollection().iterator().next().getFamilienaam()+" "+p.getValue().getStudentCollection().iterator().next().getVoornaam());
//            }
//        });
//        
//        bedrijfKolom.setCellValueFactory( new Callback < CellDataFeatures < Stages, String >, ObservableValue < String > >()
//        {
//            @Override
//            public ObservableValue < String > call(CellDataFeatures < Stages, String > p )
//            {
//                return new ReadOnlyStringWrapper( ( p.getValue().getBedrijfId() == null ) ? "" : p.getValue().getBedrijfId().getBedrijfsNaam());
//            }
//        });
//
//        // Auto resize columns
//        genererenTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }     

    @FXML
    private void filterNieuweStageContracten(ActionEvent action)
    {
        filterNieuweStageContracten(genererenTabel.getSelectionModel().selectedItemProperty().get());
    }    
    
    protected void filterNieuweStageContracten(Stages stageaanvraag)
    {
        
    }    
    
    @FXML
    private void genereerNieuweStageContracten(ActionEvent action)
    {
        genereerNieuweStageContracten(genererenTabel.getSelectionModel().selectedItemProperty().get());
    }    
    
    protected void genereerNieuweStageContracten(Stages stageaanvraag)
    {
        
    }
    
    @Override
    public void setApp(Main app)
    {
        this.application = app;
//        genererenTabel.setItems(app.getStageData());
    }
    
    @Override    
    public void setMaster(HomeController master) 
    {
        this.master = master;
    }

    @Override
    public void setUpWithModel(Model model)
    {
        this.model = model;
        
        if(model == null)
            System.out.println("No Link");
    }
}