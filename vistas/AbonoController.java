/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem.vistas;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import gymsystem.GymSystem;
import gymsystem.controladores.ControladorAbonoBD;
import gymsystem.controladores.ControladorClienteBD;
import gymsystem.controladores.ControladorDeBaseDatos;
import gymsystem.modelo.Abono;
import gymsystem.modelo.AbonoAux;
import gymsystem.modelo.Cliente;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Ceci
 */
public class AbonoController implements Initializable {

    //Nuevo Abono
    @FXML
    private JFXTextField tfIdAbonosN;
    @FXML
    private JFXDatePicker fechaInicialPickerN;
    @FXML
    private JFXDatePicker fechaVtoPickerN;
    @FXML
    private JFXComboBox<Abono> cmbCantClasesN;
    @FXML
    private JFXComboBox<Cliente> cmbClienteN;

    //Editar Abono
    @FXML
    private Tab tabEditar;
    @FXML
    private JFXTextField tfIdAbonosE;

    @FXML
    private JFXDatePicker fechaInicialPickerE;
    @FXML
    private JFXDatePicker fechaVtoPickerE;
    @FXML
    private JFXComboBox<Abono> cmbCantClasesE;
    @FXML
    private JFXComboBox<Cliente> cmbClienteE;

    //tabla abonos
    @FXML
    private TableView<Abono> tablaAbonos;
    @FXML
    private TableColumn<Abono, Integer> clIdAbonos;
    @FXML
    private TableColumn<Abono, Date> clFechaInicial;
    @FXML
    private TableColumn<Abono, Date> clFechaVto;
    @FXML
    private TableColumn<Abono, Integer> clCantClases;
    @FXML
    private TableColumn<Abono, Integer> clCantClasesAsistidas;
    @FXML
    private TableColumn<Abono, Integer> clCantClasesRestantes;

    @FXML
    private TableColumn<Abono, String> clDniAbono;

    //tab Abono
    @FXML
    private TableView<Abono> tablaLosAbonos;

    @FXML
    private TableColumn<Abono, Integer> clAbonosAb;
    @FXML
    private JFXTextField tfAbono;
    @FXML
    private JFXTextField jftBuscarAbono;

    ObservableList<Abono> listaCantClases = FXCollections.observableArrayList();
 
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    ObservableList<Abono> listaAbonos = FXCollections.observableArrayList();


    private GymSystem main;
    ControladorDeBaseDatos ab = new ControladorDeBaseDatos();
    ControladorAbonoBD cab = new ControladorAbonoBD();
    ControladorClienteBD ccl = new ControladorClienteBD();
    private JFXTextField tfClasesAsistidas;
    private JFXTextField tfClasesRestantes;
    @FXML
    private TableColumn<Abono, String> clApellido;
    @FXML
    private TableColumn<Abono, String> clNombre;
    @FXML
    private JFXTextField tfClasesAsistidasE;
    @FXML
    private JFXTextField tfClasesRestantesE;
    @FXML
    private JFXTextField tfClasesAsistidasN;
    @FXML
    private JFXTextField tfClasesRestantesN;
    @FXML
    private Label lbNotificaciones;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        listaCantClases = FXCollections.observableArrayList();
        listaClientes = FXCollections.observableArrayList();
       
        cargarListas();

        cmbClienteE.setItems(listaClientes);
        cmbClienteN.setItems(listaClientes);
        cmbClienteN.setValue(listaClientes.get(0));

        cmbCantClasesN.setItems(listaCantClases);
        cmbCantClasesE.setItems(listaCantClases);
   
        cmbCantClasesN.setValue(listaCantClases.get(0));
       
        
        configurarTablaAbonos();
        llenarCamposEditar(null);
    }

    private void cargarListas() {
        //lenar lista TipoClase
        listaCantClases.add(new Abono(4));
        listaCantClases.add(new Abono(8));
        listaCantClases.add(new Abono(12));
        listaCantClases.add(new Abono(16));
        listaCantClases.add(new Abono(20));
        listaCantClases.add(new Abono(24));
        listaCantClases.add(new Abono(28));
        listaCantClases.add(new Abono(36));
        
        
        listaAbonos.addAll(cab.buscarTodos());
        listaClientes.addAll(ccl.buscarTodos());
        tablaAbonos.setItems(listaAbonos);
        tablaLosAbonos.setItems(listaCantClases);
    }

    private void configurarTablaAbonos() {

        clIdAbonos.setCellValueFactory(new PropertyValueFactory<Abono, Integer>("idAbono"));

        clFechaInicial.setCellValueFactory(new PropertyValueFactory<Abono, Date>("fechaInicial"));
        clFechaVto.setCellValueFactory(new PropertyValueFactory<Abono, Date>("fechaVto"));
        clCantClases.setCellValueFactory(new PropertyValueFactory<Abono, Integer>("cantClases"));
        clCantClasesAsistidas.setCellValueFactory(new PropertyValueFactory<Abono, Integer>("clasesAsistidas"));
        clCantClasesRestantes.setCellValueFactory(new PropertyValueFactory<Abono, Integer>("clasesRestantes"));
//        clDniAbono.setCellValueFactory(new PropertyValueFactory<Abono,String>("dni"));
        clDniAbono.setCellValueFactory(new Callback<CellDataFeatures<Abono, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Abono, String> data) {
                return data.getValue().getCliente().DniProperty();

            }
        });
        clApellido.setCellValueFactory(new Callback<CellDataFeatures<Abono, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Abono, String> data) {
                return data.getValue().getCliente().ApellidoProperty();

            }
        });
        clNombre.setCellValueFactory(new Callback<CellDataFeatures<Abono, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Abono, String> data) {
                return data.getValue().getCliente().NombreProperty();

            }
        });

        clAbonosAb.setCellValueFactory(new PropertyValueFactory<Abono, Integer>("cantClases"));


    }

    public void setMainApp(GymSystem main) {
        this.main = main;

//        tablaClases.setItems(listaClases);
    }

    @FXML
    public void llenarCamposEditar(Event event) {  //listener
        cmbCantClasesE.setValue(listaCantClases.get(0));
        cmbClienteE.setValue(listaClientes.get(0));
        tablaAbonos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Abono>() {

            @Override
            public void changed(ObservableValue<? extends Abono> arg0,
                    Abono valorAnterior, Abono valorSeleccionado) {

                if (valorSeleccionado != null) {
                    tfIdAbonosE.setText(String.valueOf(valorSeleccionado.getIdAbono()));
                    cmbClienteE.getSelectionModel().getSelectedItem();
//                    
                    fechaInicialPickerE.setValue(valorSeleccionado.getFechaInicial().toLocalDate());
                    fechaVtoPickerE.setValue(valorSeleccionado.getFechaVto().toLocalDate());
//                     cmbCantClasesE.setValue(listaCantClases.get(0));
                    cmbCantClasesE.setValue(valorSeleccionado);

                    tfClasesAsistidasE.setText(String.valueOf(valorSeleccionado.getClasesAsistidas()));
                    tfClasesRestantesE.setText(String.valueOf(valorSeleccionado.getClasesRestantes()));
//                    tfDniAbono.setText(valorSeleccionado.getCliente().getDni());

                }

            }

        });

    }

    @FXML
    private void handleNuevoAbono(ActionEvent event) {
        ControladorAbonoBD ab = new ControladorAbonoBD();

        Abono a = new Abono(
                0,
                cmbClienteN.getSelectionModel().getSelectedItem(),
                Date.valueOf(fechaInicialPickerN.getValue()),
                Date.valueOf(fechaVtoPickerN.getValue()),
                cmbCantClasesN.getSelectionModel().getSelectedItem().getCantClases(),
                Integer.parseInt(tfClasesAsistidasN.getText()),
                Integer.parseInt(tfClasesRestantesN.getText())
        );
        System.out.println("Abono capturado: " + a);
        if (ab.insertarAbono(a)) {
            listaAbonos.clear();
            cargarListas();
            tablaAbonos.refresh();
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro agregado");
            mensaje.setContentText("El registro ha sido agregado exitosamente");
            mensaje.setHeaderText("Resultado:");
            mensaje.show();
        }

//        tablaClientes.setItems(listaClientes);
        //JDK 8u>40
    }

    @FXML
    private void handleEditarAbono(ActionEvent event) {

        int id = tablaAbonos.getSelectionModel().getSelectedItem().getIdAbono();
        ControladorAbonoBD abn = new ControladorAbonoBD();
        Abono abono = new Abono(id,
                cmbClienteE.getSelectionModel().getSelectedItem(),
                Date.valueOf(fechaInicialPickerE.getValue()),
                Date.valueOf(fechaVtoPickerE.getValue()),
                cmbCantClasesE.getSelectionModel().getSelectedItem().getCantClases(),
                Integer.parseInt(tfClasesAsistidasE.getText()),
                Integer.parseInt(tfClasesRestantesE.getText())
        );
        try {
            abn.actualizarAbono(abono);
//            cargarTablaAbonos();

            listaAbonos.clear();
            cargarListas();
            tablaAbonos.refresh();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Editado");
            a.setHeaderText("Abono Editado con exito");
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
    private void handleEliminarAbono(ActionEvent event) {
        ControladorAbonoBD ua = new ControladorAbonoBD();

        Abono abon = tablaAbonos.getSelectionModel().getSelectedItem();

        if (ua.eliminarAbono(abon)) {
//                tablaClases.getItems().remove(cl.getIdClase());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminando");
            alert.setHeaderText("Abono eliminado con exito");
            alert.showAndWait();
            
            listaAbonos.clear();
            cargarListas();
            tablaAbonos.refresh();

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No seleccionado");
            alert.setHeaderText("Persona no selecciona");
            alert.setContentText("Por favor selecciona un producto de la tabla");
            alert.showAndWait();
        }

    }

    @FXML
    private void okAgregarAbonoAb(ActionEvent event
    ) {

        ControladorAbonoBD aa = new ControladorAbonoBD();
        Abono abc = new Abono(Integer.valueOf(tfAbono.getText()));
        //validacion para que no llene una categoria vacia
        if (tfAbono.getText().length() == 0) {

        } else {

            aa.insertarAbono(abc);
            System.out.println("Correcto insert categoria");

            tfAbono.setText("");
        }
    }
    
    @FXML
    
    private void okAgregarAbonoAbon() throws SQLException {
//        Abono a = new Abono(0, tfAbono.getText());
//        //validacion para que no llene una categoria vacia
//        if (tfAbono.getText().length() == 0) {
//            lbNotificaciones.setText("No ha ingresado ninguna categoria");
//            
//        } else {
//            
//             listaCantClases.addAll( tfAbono.getText()));
//            tablaLosAbonos.setItems(listaCantClases);
//            System.out.println("Correcto insert categoria");
//            cargarListas();
//            tfAbono.setText("");
//        }
//    }
}
}