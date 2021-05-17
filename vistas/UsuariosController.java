

package gymsystem.vistas;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import gymsystem.GymSystem;
import gymsystem.controladores.ControladorDeBaseDatos;
import gymsystem.controladores.ControladorUsuarioBD;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;





public class UsuariosController implements Initializable {
 Stage stage;
    private GymSystem main;
    
     private PrincipalController principalController;
    private boolean buttonConfirmarClicked;
    
      private JFXComboBox<String> cbmTipoUsuario;
 ObservableList<String> listaUsuarios = FXCollections.observableArrayList();
    @FXML
    private Label tfContrasenia;
    @FXML
    private Label cbTipo;
    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXComboBox<?> cmbTipoUsuario;

    void onCancelar(ActionEvent event) {

    }

    @FXML
    void onRegistrarUsuario(ActionEvent event) {

    }
    
  ControladorDeBaseDatos cb = new ControladorDeBaseDatos();
    ControladorUsuarioBD cbd = new ControladorUsuarioBD();   
    
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listaUsuarios.add("administrador");
        listaUsuarios.add("Profesores");
        
         cbmTipoUsuario.setItems(listaUsuarios);
        
    }


    @FXML
    private void CerrarVentUsuario(ActionEvent event) {
        main.mostrarPrincipal();
    }

    
    
       public GymSystem getMain() {
        return main;
    }

    public void setMain(GymSystem main) {
        this.main = main;
    }

    boolean isButtonConfirmarClicked() {
        return true;
    }

    public void setPrincipalController(PrincipalController principalController) {
        this.principalController = principalController;
    }

  


}
