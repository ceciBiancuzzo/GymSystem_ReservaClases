package gymsystem.vistas;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import gymsystem.GymSystem;
import gymsystem.controladores.ControladorAbonoBD;
import gymsystem.controladores.ControladorClaseBD;
import gymsystem.controladores.ControladorClienteBD;
import gymsystem.controladores.ControladorTurnoBD;
import gymsystem.modelo.Abono;
import gymsystem.modelo.AbonoAux;
import gymsystem.modelo.Clase;
import gymsystem.modelo.ClaseAux;
import gymsystem.modelo.ReservaTurno;
import gymsystem.modelo.Turno;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class TurnosController implements Initializable {

    @FXML
    private TableView<Turno> tablaTurno;

    @FXML
    private TableColumn<Turno, String> clApellidoTurnos;
    @FXML
    private TableColumn<Turno, String> clDniTurnos;
    @FXML
    private TableColumn<Turno, LocalTime> clHoraTurnos;
    @FXML
    private TableColumn<Turno, LocalDate> clFechaTurnos;
    private TableColumn<Turno, String> clEstadoTurnoTurnos;
    @FXML
    private TableColumn<Turno, Integer> clCantClasesTurnos;
    @FXML
    private JFXTextField tfBuscarClientes;

    ObservableList<ClaseAux> listaClase = FXCollections.observableArrayList();
    ObservableList<AbonoAux> listaAbonoTurnos = FXCollections.observableArrayList();
//    ObservableList<Clase> listaClase = FXCollections.observableArrayList();
    ObservableList<Turno> listaTurnos = FXCollections.observableArrayList();

    //    private ObservableList<Turno> listaAbonos = FXCollections.observableArrayList();
    ControladorTurnoBD tur = new ControladorTurnoBD();
    ControladorClienteBD cc = new ControladorClienteBD();
    ControladorClaseBD cl = new ControladorClaseBD();
    ControladorAbonoBD ca = new ControladorAbonoBD();

    private TableColumn<Turno, Integer> clClasesAsistidasT;
    private TableColumn<Turno, Integer> clClasesRestantesT;

    private JFXComboBox<Turno> cmbDniClienteRT;
    private JFXTextField tfEstadoTurnoRT;
    private JFXTextField tfDetalleTurnoRT;

//    private JFXComboBox<Clase> cmbFechaYhhoraRT;
    @FXML
    private JFXComboBox<ClaseAux> cmbFHTclaseRT;
    @FXML
    private TableColumn<Turno, String> clNombreTurnos;
    private JFXTextField tfTipoClaseTurnoRT;
    @FXML
    private TableColumn<Turno, Integer> clIdTurnos;
    @FXML
    private JFXTextField tfIDturnos;
    @FXML
    private JFXTextField tfEstadoTurno;
    @FXML
    private JFXTextField tfDetalleTurno;
    @FXML
    private JFXComboBox<AbonoAux> cmbDatosCliente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listaClase = FXCollections.observableArrayList();
        listaTurnos = FXCollections.observableArrayList();

        listaClase.addAll(cl.buscarTablaClase());
        cmbFHTclaseRT.setItems(listaClase);
        listaAbonoTurnos.addAll(ca.buscarDatosCliente());
        cmbDatosCliente.setItems(listaAbonoTurnos);

        listaTurnos.addAll(tur.buscarTodos());
        tablaTurno.setItems(listaTurnos);
        cargarTablaTurnos();

// TODO
//        listaClientes = FXCollections.observableArrayList();
//        listaClases = FXCollections.observableArrayList();
////        listaClientesEnAbonos=FXCollections.observableArrayList();
//         listaTurnos = FXCollections.observableArrayList();
//         
//       
////        listaClientes.addAll(tur.buscarTodos());
//        listaClases.addAll(cl.buscarTodos1());
//        listaTurnos.addAll(tur.buscarTodos());
//        tablaTurno.setItems(listaTurnos);
////        listaAbonos.addAll(tur.buscarTodos());
////        listaClientesEnAbonos.addAll(tur.ComboBoxAbono());
//
////        cmbDniClienteRT.setItems(listaClientes);
//
//        cmbFHTclaseRT.setItems(listaClases);
//
//       // tfEstadoTurnoRT.getText();
//        
//        tfCliente.getText();
//
//        cargarTablaTurnos();
    }

    private void cargarTablaTurnos() {
        //clEstadoTurnoTurnos.setCellValueFactory(new PropertyValueFactory<Turno, String>("estadoTurno"));

        clIdTurnos.setCellValueFactory(cellData -> cellData.getValue().IdTurnoProperty().asObject());

        clNombreTurnos.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turno, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turno, String> data) {
                return data.getValue().getCliente().NombreProperty();
            }
        });

        clApellidoTurnos.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turno, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turno, String> data) {
                return data.getValue().getCliente().ApellidoProperty();
            }
        });
        clDniTurnos.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turno, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turno, String> data) {
                return data.getValue().getCliente().DniProperty();
            }
        });
        clHoraTurnos.setCellValueFactory(cellData -> cellData.getValue().getClase().horaProperty());
        clFechaTurnos.setCellValueFactory(cellData -> cellData.getValue().getClase().fechaProperty());

        clCantClasesTurnos.setCellValueFactory(cellData -> cellData.getValue().getAbono().CantClasesProperty().asObject());

//    clTipoClaseTurnos.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turno, String>, ObservableValue<String>>() {
//         @Override
//          public ObservableValue<String> call(TableColumn.CellDataFeatures<Turno, String> data) {    
//              return data.getValue().getClase().getTipoClase().DescripcionProperty();           }
//       });
//        //clClasesAsistidasT.setCellValueFactory(cellData -> cellData.getValue().getAbono().ClasesAsistidasProperty().asObject());
//
//       // clClasesRestantesT.setCellValueFactory(cellData -> cellData.getValue().getAbono().ClasesRestantesProperty().asObject());
////       listaCantClientes.addAll(ccl.buscarTodosCmb());
//       cmbDniClienteRT.setItems(listaClientes);
//        cmbFHTclaseRT.setItems(listaClases);
//        tablaTurno.setItems(listaTurnos);
//      
////        listaCantClientes.setAll(ccl.buscarTodos());
////        tablaAbonos.setItems(listaCantClientes);
////        gestionarAbonos();
    }
//

    public void GymSystem(GymSystem main) {
//       
//
////       tablaClases.setItems(listaClases);
    }
//

    public void gestionarTurnos() {  //listener
////
////        tablaAbonos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Abono>() {
////
////            @Override
////            public void changed(ObservableValue<? extends Abono> arg0,
////                    Abono valorAnterior, Abono valorSeleccionado) {
////                if (valorSeleccionado != null) {
//////                    tfIdAbonosE.setText(String.valueOf(valorSeleccionado.getIdAbonos()));
////                    cmbClienteE.getSelectionModel().getSelectedItem();
////                    fechaInicialPickerE.setValue(valorSeleccionado.getFechaInicial().toLocalDate());
////                    fechaVtoPickerE.setValue(valorSeleccionado.getFechaVto().toLocalDate());
////                    cmbCantClasesE.setValue(valorSeleccionado);
////                    tfClasesAsistidas.setText(String.valueOf(valorSeleccionado.getClasesAsistidas()));
////                    tfClasesRestantes.setText(String.valueOf(valorSeleccionado.getClasesRestantes()));
////                    tfDniAbono.setText(valorSeleccionado.getCliente().getDni());
//////                else if (valorSeleccionado.getEstado().equals("Suspendido")) {
//////                    rbActivo.setSelected(false);
//////                    rbInactivo.setSelected(true);
//////                }
////                }
////
////            }
////
////        });
////    
////    
////    
////    
////    
////    }    
//    
    }

    @FXML
    private void handleNuevoTurno(ActionEvent event) {

        ControladorTurnoBD tr = new ControladorTurnoBD();

        Integer idAbono = cmbDatosCliente.getSelectionModel().getSelectedItem().getIdAbonos();
        Integer idClase = cmbFHTclaseRT.getSelectionModel().getSelectedItem().getIdClase();
        System.out.println("idAbono:" + idAbono);
        System.out.println("idClase:" + idClase);
//        Abono ab ;

        String estado = tfEstadoTurno.getText();
        String detalle = tfDetalleTurno.getText();

        ReservaTurno rt = new ReservaTurno(0, idAbono, idClase, estado, detalle);

//        a.setIdAbono(idAbono);
//        cc.setIdClase(idClase);
//        Turno tu = new Turno(new Clase(cc.getIdClase()),new Abono(a.getIdAbono()),estado,detalle);        
//             System.out.println("imprimir turno" +tu.getAbono().toString());
        tur.insertarTurno(rt);

    }

    @FXML
    private void tfBuscar(ActionEvent event) {

//        FilteredList<Turno> filteredData = new FilteredList<>(listaTurnos, p -> true);
//
//        // 2. Set the filter Predicate whenever the filter changes.
//        tfBuscarClientes.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
//            filteredData.setPredicate((Turno turno) -> {
//                // If filter text is empty, display all persons.
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (turno.getEstadoTurno().toLowerCase().contains(newValue)) {
//                    return true; // Filter matches first name.
//                }
//
//                return false; // Does not match.
//            });
//        });
//
//        // 3. Wrap the FilteredList in a SortedList.
//        SortedList<Turno> sortedData = new SortedList<>(filteredData);
//
//        // 4. Bind the SortedList comparator to the TableView comparator.
//        // 	  Otherwise, sorting the TableView would have no effect.
//        sortedData.comparatorProperty().bind(tablaTurno.comparatorProperty());
//
//        // 5. Add sorted (and filtered) data to the table.
//        tablaTurno.setItems(sortedData);
//
//    }
    }
}
