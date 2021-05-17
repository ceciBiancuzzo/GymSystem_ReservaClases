package gymsystem.vistas;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import gymsystem.GymSystem;
import gymsystem.controladores.ControladorClienteBD;
import gymsystem.controladores.ControladorDeBaseDatos;

import gymsystem.modelo.Cliente;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ClientesController implements Initializable {

    @FXML
    private TableView<Cliente> tablaClientes;
    private TableColumn<Cliente, Integer> idColumn;
    @FXML
    private TableColumn<Cliente, Date> fechaColumn;
    @FXML
    private TableColumn<Cliente, String> nombreColumn;
    @FXML
    private TableColumn<Cliente, String> apellidoColumn;
    @FXML
    private TableColumn<Cliente, Integer> dniColumn;
    @FXML
    private TableColumn<Cliente, String> telefonoColumn;
    @FXML
    private TableColumn<Cliente, String> emailColumn;
    @FXML
    private TableColumn<Cliente, String> estadoColumn;

    private GymSystem main;

    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
     private ObservableList<Cliente> lista = FXCollections.observableArrayList();
    private TextField idField;
    @FXML
    private TextField ApellidoField;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField dniField;
    @FXML
    private TextField telefonoField;
    @FXML
    private TextField emailField;
    @FXML
    private JFXDatePicker fechaPicker;

    ControladorDeBaseDatos cb = new ControladorDeBaseDatos();
    ControladorClienteBD cbd = new ControladorClienteBD();
    @FXML
    private JFXRadioButton rbActivo;
    @FXML
    private JFXRadioButton rbInactivo;
    @FXML
    private AnchorPane APcliente;
    @FXML
    private ToggleGroup activo;
    @FXML
    private Label lNotificaciones;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         alertaCodRepetido();
        cargarTablaCliente();

    }

    private void cargarTablaCliente() {
        dniColumn.setCellValueFactory(new PropertyValueFactory<>("dni"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidoColumn.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));
        listaClientes.setAll(cbd.buscarTodos());
        gestionarClientes();
        tablaClientes.setItems(listaClientes);
    }


//    public void setMainApp(GymSystem main) {
//        this.main = main;
//
//        tablaClientes.setItems(listaClientes);
//    }
    public void gestionarClientes() {

        tablaClientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cliente>() {
            @Override
            public void changed(ObservableValue<? extends Cliente> arg0,
                    Cliente valorAnterior, Cliente valorSeleccionado) {
                if (valorSeleccionado != null) {
                    dniField.setText(String.valueOf(valorSeleccionado.getDni()));
                    fechaPicker.setValue(valorSeleccionado.getFechaNacimiento().toLocalDate());
                    nombreField.setText(valorSeleccionado.getNombre());
                    ApellidoField.setText(valorSeleccionado.getApellido());

                    telefonoField.setText(valorSeleccionado.getTelefono());
                    emailField.setText(valorSeleccionado.getEmail());

                    if (valorSeleccionado.getEstado().equals("Activo")) {
                        rbActivo.setSelected(true);
                        rbInactivo.setSelected(false);
                    } else if (valorSeleccionado.getEstado().equals("Suspendido")) {

                        rbActivo.setSelected(false);
                        rbInactivo.setSelected(true);
                    }
                }

//                else if (valorSeleccionado.getEstado().equals("Suspendido")) {
//                    rbActivo.setSelected(false);
//                    rbInactivo.setSelected(true);
//                }
            }

        }
        );

    }

    @FXML
    private void handleLimpiar() {
        dniField.setText("");
        fechaPicker.setValue(LocalDate.now());
        nombreField.setText("");
        ApellidoField.setText("");
        telefonoField.setText("");
        emailField.setText("");
        rbActivo.isSelected();
//        idField.requestFocus();
    }

    @FXML
    private void handleNuevoCliente() {
        ControladorClienteBD cp = new ControladorClienteBD();

        String activo = null;

        if (rbActivo.isSelected()) {
            activo = "Activo";
        } else {
            activo = "Suspendido";
        }

        Cliente a = new Cliente(
                dniField.getText(),
                Date.valueOf(fechaPicker.getValue()),
                nombreField.getText(),
                ApellidoField.getText(),
               
                telefonoField.getText(),
                emailField.getText(),
                activo
        );

        cp.insertarClienteSQL(a);
        cargarTablaCliente();
//        tablaClientes.setItems(listaClientes);
        //JDK 8u>40
        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro agregado");
        mensaje.setContentText("El registro ha sido agregado exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();

//        } catch (Exception ex) {
//            Logger.getLogger(PantillaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
    }

    @FXML
    private void handleEditarCliente() {
        ControladorClienteBD cc = new ControladorClienteBD();
        String activo = null;

        if (rbActivo.isSelected()) {
            activo = "Activo";
        } else {
            activo = "Suspendido";
        }
        Cliente cliente = new Cliente(
                dniField.getText(),
                Date.valueOf(fechaPicker.getValue()),
                nombreField.getText(),
                ApellidoField.getText(),
              
                telefonoField.getText(),
                emailField.getText(),
                activo
        );
        try {
            cc.actualizarClienteSQL(cliente);
            cargarTablaCliente();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Editado");
            a.setHeaderText("Agenda Editada con exito");
            a.showAndWait();
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("error");
            a.setHeaderText("No se pudo editar" + e.getMessage());
            a.setContentText(e.getMessage());
            a.showAndWait();
        }
    }

    @FXML
    private void handleEliminarCliente() {
        ControladorClienteBD cp = new ControladorClienteBD();
        int selectedIndex = tablaClientes.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            cp.eliminarClienteSQL((tablaClientes.getSelectionModel().getSelectedItem().getDni()));
            tablaClientes.getItems().remove(selectedIndex);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminando");
            alert.setHeaderText("Persona eliminada con exito");
            alert.showAndWait();

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No seleccionado");
            alert.setHeaderText("Persona no selecciona");
            alert.setContentText("Por favor selecciona un producto de la tabla");
            alert.showAndWait();
        }
        tablaClientes.refresh();
    }
    
    
    
 public void alertaCodRepetido() {
        dniField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // CREAR CON DO-WHILE
                for (int i = 0; i < listaClientes.size(); i++) {
                    //String codigo = tablaClientes.getItems().get(i).getDni().toString();

                    if (tablaClientes.getItems().get(i).getDni().equalsIgnoreCase(dniField.getText())) {
                        lNotificaciones.setText("El dni ya fue registrado");
                        break;
                        
                    } else {
                        lNotificaciones.setText("");
                    }
                    //System.out.println(codigo);
                }
                
            }
        });
 }

    public void handleCerrarSesion() {
//       mainApp.cerrarSesion();
//       mainApp.inicio();
    }

    public void setMain(GymSystem main) {
        this.main = main;
    }

    public AnchorPane getAPcliente() {
        return APcliente;
    }

    public void setAPcliente(AnchorPane APcliente) {
        this.APcliente = APcliente;
    }

    
     public ObservableList<Cliente> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Cliente> lista) {
        this.lista = lista;
    }
}
