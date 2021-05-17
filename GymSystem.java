package gymsystem;

import gymsystem.GymSystem;
import gymsystem.controladores.ControladorClienteBD;
import gymsystem.modelo.Cliente;
import gymsystem.modelo.ClienteE;

import gymsystem.utils.ListaClientesWrapper;
import gymsystem.vistas.AbonoController;

import gymsystem.vistas.ClientesController;
import gymsystem.vistas.LoginController;
import gymsystem.vistas.PrincipalController;
import gymsystem.vistas.PrincipalEscenaController;
import gymsystem.vistas.ClasesController;
import gymsystem.vistas.EstadisticasController;

import gymsystem.vistas.TurnosController;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class GymSystem extends Application {

    GymSystem main;
    ObservableList<ClienteE> lista = FXCollections.observableArrayList();
    ControladorClienteBD ccc = new ControladorClienteBD();
    private Stage stage;
    private BorderPane principalPane;
    private AnchorPane vistaClientes;
    private AnchorPane vistaAbonos;
    private AnchorPane vistaTurnos;
    private ObservableList<Cliente> listaCopiaCliente = FXCollections.observableArrayList();
    private PrincipalController pr;
//   private  ControladorClienteBD daoCliente;
    ClientesController cc = new ClientesController();
    ControladorClienteBD daoCliente = new ControladorClienteBD();

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
//        stage.setHeight(750);
//        stage.setWidth(455);
        mostrarLogin();
    }

    public void mostrarLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GymSystem.class.getResource("vistas/login1.fxml"));
            AnchorPane login = loader.load();

            Scene scene = new Scene(login);
            stage.setScene(scene);
            LoginController controlador = loader.getController();
            controlador.setMain(this);
            stage.setTitle("Gimnasio  CORPORE FIT");
            stage.getIcons().add(new Image(getClass().getResource("recursos/imagen_sistema.png").toExternalForm()));
            stage.show();
            

        } catch (IOException e) {
            e.getMessage();
        }
    }

    //ventana principal menu
    public void mostrarPrincipal() {
        listaCopiaCliente.addAll(daoCliente.buscarTodos());
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GymSystem.class.getResource("vistas/Principal.fxml"));
            principalPane = loader.load();
            Scene sc = new Scene(principalPane);
            PrincipalController pc = loader.getController();
            pc.setMain(this);
            stage.setScene(sc);
            stage.show();
           
            mostrarPrincipalEscena();
        } catch (IOException ex) {
            Logger.getLogger(GymSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarPrincipalEscena() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GymSystem.class.getResource("vistas/PrincipalEscena.fxml"));
        try {
            vistaClientes = (AnchorPane) loader.load();
            PrincipalEscenaController c = loader.getController();
            c.setMain(this);
            principalPane.setCenter(vistaClientes);

        
           
        } catch (IOException ex) {
            System.err.println("Error al cargar rootLayout" + ex.getMessage());
        }
    }

    public void mostrarVentanaClientes() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GymSystem.class.getResource("vistas/clientes.fxml"));

            vistaClientes = (AnchorPane) loader.load();
//            Scene scene = new Scene(vistaClientes);
            ClientesController cc = loader.getController();
            cc.setMain(this);
            principalPane.setCenter(vistaClientes);

//            stage.setScene(scene);
//            stage.show();
//            principalPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(GymSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarVentanaClases() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GymSystem.class.getResource("vistas/Clases.fxml"));

            vistaClientes = (AnchorPane) loader.load();
            ClasesController cc = loader.getController();
//            rcc.setMainApp(this);
            principalPane.setCenter(vistaClientes);
                principalPane.setMaxSize(832, 650);
                stage.setMaxHeight(800);
               stage.setMaxWidth(1024);
//           principalPane.setMaxSize(832, 650);
//            stage.setMaxHeight(800);
//           stage.setMaxWidth(1024);
        } catch (IOException ex) {
            Logger.getLogger(GymSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarRegistroUsuarios() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GymSystem.class.getResource("vistas/Usuarios.fxml"));
        try {
            vistaClientes = (AnchorPane) loader.load();
            PrincipalEscenaController c = loader.getController();
            c.setMain(this);
            principalPane.setCenter(vistaClientes);

            principalPane.setMaxSize(832, 650);
            stage.setMaxHeight(800);
            stage.setMaxWidth(1024);

        } catch (IOException ex) {
            System.err.println("Error al cargar rootLayout" + ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public GymSystem() {
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void registrarUsuario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GymSystem.class.getResource("vistas/Usuarios.fxml"));
            AnchorPane login = loader.load();

            Scene scene = new Scene(login);
            stage.setScene(scene);
            LoginController controlador = loader.getController();
            controlador.setMain(this);
            stage.show();

        } catch (IOException e) {
            e.getMessage();

        }
    }

    public AnchorPane getVistaClientes() {
        return vistaClientes;
    }

    public void setVistaClientes(AnchorPane vistaClientes) {
        this.vistaClientes = vistaClientes;
    }

    public void mostrarVentanaAbonos() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GymSystem.class.getResource("vistas/Abonos.fxml"));

            vistaAbonos = (AnchorPane) loader.load();
            AbonoController ab = loader.getController();
//            rcc.setMainApp(this);
            principalPane.setCenter(vistaAbonos);

//           principalPane.setMaxSize(832, 650);
//            stage.setMaxHeight(800);
//            stage.setMaxWidth(1024);
        } catch (IOException ex) {
            Logger.getLogger(GymSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarVentanaTurnos() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GymSystem.class.getResource("vistas/Turnos.fxml"));

            vistaTurnos = (AnchorPane) loader.load();
            TurnosController tc = loader.getController();
//            rcc.setMainApp(this);
            principalPane.setCenter(vistaTurnos);

//           principalPane.setMaxSize(832, 650);
//            stage.setMaxHeight(800);
//            stage.setMaxWidth(1024);
        } catch (IOException ex) {
            Logger.getLogger(GymSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void estadisticas() {

        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GymSystem.class.getResource("vistas/estadisticas.fxml"));

            vistaTurnos = (AnchorPane) loader.load();
            EstadisticasController tc = loader.getController();
            lista.addAll(ccc.buscarFechasNac());
            tc.setPersonData(lista); 
            
//            rcc.setMainApp(this);
            principalPane.setCenter(vistaTurnos);
            
           principalPane.setMaxSize(600, 500);
//            stage.setMaxHeight(800);
//            stage.setMaxWidth(1024);
        } catch (IOException ex) {
            Logger.getLogger(GymSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public File getClientFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(GymSystem.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {

            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setClienteFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(GymSystem.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            stage.setTitle("Corpore Fit - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            stage.setTitle("Corpore Fit");
        }
    }

    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     *
     * @param file
     */
//    public void cargarClienteDeArchivo(File file) {
//        try {
//            JAXBContext context = JAXBContext
//                    .newInstance(ListaClienteWrapper.class);
//            Unmarshaller um = context.createUnmarshaller();
//
//            // Reading XML from the file and unmarshalling.
//            ListaClienteWrapper wrapper = (ListaClienteWrapper) um.unmarshal(file);
//
//            listaCopiaCliente.clear();
//
//            listaCopiaCliente.addAll(wrapper.getCliente());
//
//            // Save the file path to the registry.
//            setClienteFilePath(file);
//            pr.setLista(listaCopiaCliente);
//        } catch (JAXBException e) { // catches ANY exception
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("No se pudo cargar datos");
//            alert.setContentText("No se pudo cargar datos del archivo:\n" + file.getPath());
//
//            alert.showAndWait();
//        }
//    }

    public void guardarClientesXML(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ListaClientesWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            ListaClientesWrapper wrapper = new ListaClientesWrapper();
            listaCopiaCliente.setAll(daoCliente.buscarTodos());
            wrapper.setClientes(listaCopiaCliente);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);                       //recien comentado

            // Save the file path to the registry.
            setClienteFilePath(file);
        } catch (JAXBException e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pudo guardar datos");
            alert.setContentText("CNo se pudo guardar datos en el archivo:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    public void cargarClienteDeArchivo(File file) {

        try {
            JAXBContext context = JAXBContext
                    .newInstance(ListaClientesWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            ListaClientesWrapper wrapper = (ListaClientesWrapper) um.unmarshal(file);

            listaCopiaCliente.clear();

            listaCopiaCliente.addAll(wrapper.getCliente());

            // Save the file path to the registry.
            setClienteFilePath(file);
            cc.setLista(listaCopiaCliente);

        } catch (JAXBException e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pudo cargar datos");
            alert.setContentText("No se pudo cargar datos del archivo:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    public ObservableList<ClienteE> getLista() {
        return lista;
    }

    public void setLista(ObservableList<ClienteE> lista) {
        this.lista = lista;
    }

    
    
}

//    public File getPersonFilePath() {
//        Preferences prefs = Preferences.userNodeForPackage(GymSystem.class);
//        String filePath = prefs.get("filePath", null);
//        if (filePath != null) {
//            return new File(filePath);
//        } else {
//            return null;
//        }
//    }
/**
 * Sets the file path of the currently loaded file. The path is persisted in the
 * OS specific registry.
 *
 * @param file the file or null to remove the path
 */
//    public void setPersonFilePath(File file) {
//        Preferences prefs = Preferences.userNodeForPackage(GymSystem.class);
//        if (file != null) {
//            prefs.put("filePath", file.getPath());
//
//            // Update the stage title.
////           setTitle("Direcciones - " + file.getName());
//        } else {
//            prefs.remove("filePath");
//
//            // Update the stage title.
////            Stage.setTitle("Direcciones");
//        }
//    }
//
//    /**
//     * Loads person data from the specified file. The current person data will
//     * be replaced.
//     *
//     * @param file
//     */
//    public void loadPersonDataFromFile(File file) {
//        try {
//            JAXBContext context = JAXBContext
//                    .newInstance(ListaClienteWrapper.class);
//            Unmarshaller um = context.createUnmarshaller();
//
//            // Reading XML from the file and unmarshalling.
//            ListaClienteWrapper wrapper = (ListaClienteWrapper) um.unmarshal(file);
//
//            listaCopiaCliente.clear();
//            listaCopiaCliente.addAll(wrapper.getCliente());
//
//            // Save the file path to the registry.
//            setPersonFilePath(file);
//
//        } catch (Exception e) { // catches ANY exception
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Could not load data");
//            alert.setContentText("Could not load data from file:\n" + file.getPath());
//
//            alert.showAndWait();
//        }
//    }
//
//    /**
//     * Saves the current person data to the specified file.
//     *
//     * @param file
//     */
//    public void savePersonDataToFile(File file) {
//        try {
//
////        try {
//            JAXBContext context = JAXBContext
//                    .newInstance(ListaClienteWrapper.class);
//            Marshaller m = context.createMarshaller();
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//// Wrapping our person data.
//            ListaClienteWrapper wrapper = new ListaClienteWrapper();
//            wrapper.setClientes(listaCopiaCliente);
//
//// Marshalling and saving XML to the file.
//            m.marshal(wrapper, file);
//
//// Save the file path to the registry.
//            setPersonFilePath(file);
////        } catch (Exception e) { // catches ANY exception
////        	Alert alert = new Alert(Alert.AlertType.ERROR);
////        	alert.setTitle("Error");
////        	alert.setHeaderText("Could not save data");
////        	alert.setContentText("Could not save data to file:\n" + file.getPath());
////        	
////        	alert.showAndWait();
////        }
//        } catch (JAXBException ex) {
//            System.out.println("Error" + ex.getMessage());
//        }
//    }
//
//    public ObservableList<Cliente> getListaCopiaCliente() {
//        return listaCopiaCliente;
//    }
//
//    public void setListaCopiaCliente(ObservableList<Cliente> listaCopiaCliente) {
//        this.listaCopiaCliente = listaCopiaCliente;
//    }

