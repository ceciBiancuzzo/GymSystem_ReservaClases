/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem.vistas;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ceci
 */
public class RegistroClasesController implements Initializable {

    @FXML
    private TableView<?> tablaClases;
    @FXML
    private TableColumn<?, ?> clmnHorarios;
    @FXML
    private TableColumn<?, ?> clmnFecha;
    @FXML
    private TableColumn<?, ?> clmnTipoClase;
    @FXML
    private TextField txtIdClase;
    @FXML
    private DatePicker dateFecha;
    @FXML
    private JFXTimePicker horariosField;
    @FXML
    private JFXComboBox<?> cmbTipoClase;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLimpiar(ActionEvent event) {
    }

    @FXML
    private void handleNuevaClase(ActionEvent event) {
    }

    @FXML
    private void handleEditarClase(ActionEvent event) {
    }

    @FXML
    private void handleEliminarClase(ActionEvent event) {
    }
    
}
