package gymsystem.vistas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import gymsystem.GymSystem;
import gymsystem.controladores.ControladorAbonoBD;
import gymsystem.controladores.ControladorClaseBD;
import gymsystem.controladores.ControladorClienteBD;
import gymsystem.controladores.ControladorDeBaseDatos;
import gymsystem.controladores.ControladorTipoClaseBD;
import gymsystem.modelo.Clase;
import gymsystem.modelo.TipoClase;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class ClasesController implements Initializable {

    ControladorDeBaseDatos ab = new ControladorDeBaseDatos();
    ControladorAbonoBD cab = new ControladorAbonoBD();
    ControladorClienteBD ccl = new ControladorClienteBD();
    ControladorClaseBD cc = new ControladorClaseBD();
    ControladorTipoClaseBD ctc = new ControladorTipoClaseBD();
    @FXML
    private TableColumn<Clase, LocalTime> clmnHorarios;
    @FXML
    private TableColumn<Clase, Date> clmnFecha;
    @FXML
    private TableColumn<Clase, String> clmnTipoClase;

    ObservableList<Clase> listaClases = FXCollections.observableArrayList();
    @FXML
    private TextField txtIdClase;
    @FXML
    private JFXComboBox<TipoClase> cmbTipoClase;
    // colecciones
    private ObservableList<TipoClase> listaTipoClases = FXCollections.observableArrayList();

    @FXML
    private DatePicker dateFecha;
    @FXML
    private TableView<Clase> tablaClases;
    @FXML
    private JFXTimePicker horariosField;

    private GymSystem main;
    ControladorDeBaseDatos cb = new ControladorDeBaseDatos();
    ControladorClaseBD cbd = new ControladorClaseBD();
    ControladorTipoClaseBD tclase = new ControladorTipoClaseBD();
    private JFXButton btOKtipoClase;
    @FXML
    private Label lbNotificaciones;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listaTipoClases = FXCollections.observableArrayList();

        tablaClases.setItems(listaClases);
        cmbTipoClase.setItems(listaTipoClases);

        cargarTablaClases();

//        cmbTipoClase.setValue(listaTipoClases.get(0));
    }

    public void cargarListas() {
        listaTipoClases.setAll(ctc.buscarTodos());
        listaClases.setAll(cc.buscarTodos());

    }

    private void cargarTablaClases() {
        //  IdColumn.setCellValueFactory(new PropertyValueFactory<Clase, Number>("idClase"));
//         clmnHorarios.setCellValueFactory(cellData -> cellData.getValue().horaProperty());
        clmnHorarios.setCellValueFactory(new PropertyValueFactory<>("hora"));
        clmnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
//        clmnTipoClase.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        clmnTipoClase.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Clase, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Clase, String> data) {
                return data.getValue().getTipoClase().DescripcionProperty();

            }

        });

        cargarListas();
        gestionarClases();
        //System.out.println();
    }

    public void setMainApp(GymSystem main) {
        this.main = main;

//        tablaClases.setItems(listaClases);
    }

    public void gestionarClases() {

        tablaClases.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Clase>() {

            @Override
            public void changed(ObservableValue<? extends Clase> arg0,
                    Clase valorAnterior, Clase valorSeleccionado) {

                if (valorSeleccionado != null) {
                    txtIdClase.setText(String.valueOf(valorSeleccionado.getIdClase()));
                    horariosField.setValue(valorSeleccionado.getHora());
                    dateFecha.setValue(valorSeleccionado.getFecha());
                    cmbTipoClase.setValue(valorSeleccionado.getTipoClase());
                    // cmbTipoClase.getItems().add(valorSeleccionado.getTipoClase());
                    System.out.println(valorSeleccionado.getFecha());

//                else if (valorSeleccionado.getEstado().equals("Suspendido")) {
//                    rbActivo.setSelected(false);
//                    rbInactivo.setSelected(true);
//                }
                }

            }

        });
    }

    @FXML
    private void handleLimpiar() {
        txtIdClase.setText("");
        horariosField.setValue(LocalTime.now());
        dateFecha.setValue(LocalDate.now());
        cmbTipoClase.setValue(null);

//        idField.requestFocus();
    }

    @FXML
    private void handleNuevaClase() throws ClassNotFoundException {

        ControladorClaseBD cp = new ControladorClaseBD();

        Clase a = new Clase(
                //                   Integer.parseInt(txtIdClase.getText()),
                horariosField.getValue(),
                dateFecha.getValue(),
                cmbTipoClase.getSelectionModel().getSelectedItem()
        );

        cp.insertarClaseSQL(a);
        cargarTablaClases();
//        tablaClientes.setItems(listaClientes);
        //JDK 8u>40
        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro agregado");
        mensaje.setContentText("El registro ha sido agregado exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();


    }

    @FXML
    private void handleEditarClase() {
        ControladorClaseBD cc = new ControladorClaseBD();

        Clase clase = new Clase(
                Integer.parseInt(txtIdClase.getText()),
                horariosField.getValue(),
                dateFecha.getValue(),
                cmbTipoClase.getSelectionModel().getSelectedItem()
        );

        cc.actualizarClaseSQL(clase);
        cargarTablaClases();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Editado");
        a.setHeaderText("Agenda Editada con exito");
        a.showAndWait();
    }

    @FXML
    private void handleEliminarClase() {
        ControladorClaseBD cp = new ControladorClaseBD();

        Clase cl = tablaClases.getSelectionModel().getSelectedItem();

        if (cl != null) {

            if (cp.eliminarClaseSQL(cl)) {
//                tablaClases.getItems().remove(cl.getIdClase());
           cargarTablaClases();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Eliminando");
                alert.setHeaderText("Persona eliminada con exito");
                alert.showAndWait();

            };

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No seleccionado");
            alert.setHeaderText("Persona no selecciona");
            alert.setContentText("Por favor selecciona un producto de la tabla");
            alert.showAndWait();
        }
        
    }

    public void handleCerrarSesion() {
//       mainApp.cerrarSesion();
//       mainApp.inicio();
    }
    
//    
// @FXML
//    private void verOcultarTipoClase(ActionEvent event) {
//     
//        
//     cmbTipoClase.setVisible(true);
//     tfAgregarTipoClase.setVisible(false);
////        btOKtipoClase.setVisible(false);
//      
////        okAgregarCategoria();
//        btAtras.setVisible(false);
//        btAgregarTipoClase.setVisible(true);
//    }
//    
//   @FXML
//    private void verAgregarTipoClase(ActionEvent event) {
//    
//        cmbTipoClase.setVisible(false);
//        tfAgregarTipoClase.setVisible(true);
//        btOKtipoClase.setVisible(true);
//        btAtras.setVisible(true);
////        bteliminCat.setVisible(false);
//        btAgregarTipoClase.setVisible(true);
//    }

   

//    @FXML
//    private void OkAgregarTipoClase(ActionEvent event) {
//   
//       TipoClase tc = new TipoClase( tfAgregarTipoClase.getText());
//        //validacion para que no llene una categoria vacia
//        if ( tfAgregarTipoClase.getText().length() == 0) {
//            lbNotificaciones.setText("No ha ingresado ninguna categoria");
//            
//            cmbTipoClase.setVisible(true);
//            tfAgregarTipoClase.setVisible(false);
//            btOKtipoClase.setVisible(false);
//            btAtras.setVisible(true);
//            System.out.println("Correcto insert categoria");
//            
//        } else {
//            
//            tclase.insertarTIpoClaseSQL(tc);
//            verOcultarTipoClase(event);
//            
//            cargarListas();
////            tablaCategoria.setItems(listaCategorias);
//    
//    }
    
   
    
   
    
            
      
            
}
