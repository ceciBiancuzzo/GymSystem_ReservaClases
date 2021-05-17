/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem.vistas;

import gymsystem.GymSystem;
import gymsystem.controladores.ControladorClienteBD;
import gymsystem.controladores.ControladorDeBaseDatos;
import gymsystem.modelo.Cliente;
import gymsystem.modelo.ClienteE;
import gymsystem.utils.ExportarCSV;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

/**
 * FXML Controller class
 *
 * @author Mati10
 */
public class PrincipalController implements Initializable {


    private Stage stage;
    private GymSystem main;
    @FXML
    private MenuItem bartChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    //menu sistema   
//inicio
    @FXML
    private void onMostrarPrincipal() {
        main.mostrarPrincipalEscena();
//     main.mostrarPrincipal();
    }

    //usuarios
    @FXML
    private void onVistaUsuarios() {
        main.registrarUsuario();

    }

    //cerrar sesion
    @FXML
    private void onCerrarSesion() {

        main.mostrarLogin();
    }

// salir
    @FXML
    private void onSalir() {

        System.exit(0);

    }

    //menu clientes
    // gestionar
    @FXML
    private void verClientes(ActionEvent event) {
        main.mostrarVentanaClientes();
    }

    //importar a xml
    @FXML
    private void onImportarXml(ActionEvent event) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            main.cargarClienteDeArchivo(file);
        }
    }

    //menu clases
// gestionar
    @FXML
    private void verClases(ActionEvent event) {
        main.mostrarVentanaClases();
    }

    public GymSystem getMain() {
        return main;
    }

    public void setMain(GymSystem main) {
        this.main = main;

    }

    @FXML
    private void onVerAbonos(ActionEvent event) {

        main.mostrarVentanaAbonos();
    }

    @FXML
    private void onVerTurnos(ActionEvent event) {

        main.mostrarVentanaTurnos();
    }

    public void mostrarReporte(String dir) {

        try {
            ControladorDeBaseDatos conexionMySql = new ControladorDeBaseDatos();
            Connection conn = conexionMySql.conectarSQL();
            JasperReport jp = null;

            JasperReport jr = JasperCompileManager.compileReport(dir);
            JasperPrint print = JasperFillManager.fillReport(jr, null, conn);

            JRViewer test = new JRViewer(print);
            JFrame frame = new JFrame("Reporte");
            frame.getContentPane().add(test);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (JRException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String path = null;

    @FXML
    private void okReporte(ActionEvent event) throws JRException {

//        if (checkPorDni.isSelected() == false) {
        System.out.println("Reporte general por dni");
//            tfDni.setDisable(false);
        setPath("src/gymsystem/reportes/clientes.jrxml");
        mostrarReporte(path);

    }

    @FXML
    private void okReporteTurnos(ActionEvent event) throws JRException {
        path = null;
//        if (checkPorDni.isSelected() == false) {
        System.out.println("Reporte general por dni");
//            tfDni.setDisable(false);
        setPath("src/gymsystem/reportes/TurnosReservados.jrxml");
        mostrarReporte(path);

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @FXML
    private void handleSaveAs() {

//          System.out.println(main.getListaCopiaCliente().toString());
//        FileChooser fileChooser = new FileChooser();
//
//        // Set extension filter
//        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
//                "XML files (*.xml)", "*.xml");
//        fileChooser.getExtensionFilters().add(extFilter);
//
//        // Show save file dialog
//        File file = fileChooser.showSaveDialog(stage);
//
//        if (file != null) {
//            // Make sure it has the correct extension
//            if (!file.getPath().endsWith(".xml")) {
//                file = new File(file.getPath() + ".xml");
//            }
//            main.savePersonDataToFile(file);
//        }
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            main.guardarClientesXML(file);
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void handleShowBirthdayStatistics() {
        main.estadisticas();
    }

    @FXML
    private void exportarCSV()  {
    
    ExportarCSV listado =  new ExportarCSV ();
        ObservableList<Cliente> lista = null;
    listado.ExportarCSV(lista);
      

    }

}
