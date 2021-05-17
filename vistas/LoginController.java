package gymsystem.vistas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import gymsystem.GymSystem;
import gymsystem.controladores.ControladorUsuarioBD;
import gymsystem.modelo.Usuario;
import gymsystem.utils.Cifrado;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

public class LoginController implements Initializable {

    @FXML
    private JFXTextField txtUsuario;

    @FXML
    private JFXPasswordField txtContrasenia;
   
    
    private GymSystem main;
//    private JdbcHelper jh;

    private JFXButton btnSalir;
    private JFXButton btnRegistro;
    

    public boolean isOkClicked() {
        boolean okClicked = false;
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    /**
     * Called when the user clicks cancel.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setMain(GymSystem main) {
        this.main = main;
    }

    public boolean validarLogin() {
        ControladorUsuarioBD usuarioBD = new ControladorUsuarioBD();
//        if ("".equals(txtUsuario.getText()) || txtContrasenia.getText() == "") {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Campos vacíos");
//            alert.setContentText("Por favor digite su usuario y contraseña:\n");
//
//            alert.showAndWait();
//        }
        Usuario usuario = new Usuario(txtUsuario.getText(), txtContrasenia.getText());

        System.out.println("Cifrado sh: " + Cifrado.sha1(txtContrasenia.getText()));
        System.out.println("Cifrado md5: " + Cifrado.md5(txtContrasenia.getText()));

        if (usuarioBD.validarLoginDB(usuario)) {
            System.out.println("Validacion correcta recibida");

            main.mostrarPrincipal();
            return true;
        } else {
            System.out.println("Validacion incorrecta");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Usuario y/o contraseña inválidos");
            alert.setHeaderText("Por favor digite su usuario y contraseña");
            alert.setContentText("Acceso no autorizado");

            alert.showAndWait();
        }
        return false;
    }

    private void onCancelar(ActionEvent event) {
        try {
            main.stop();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnIngresar(ActionEvent event) {
        //        ESTA PARTE SOLO ES PARA FINES DE PRUEBA AQUI DEBE HABER LA CONDICION DE SI ES ADMINISTRADOR O CLIENTE
//        if (txtUsuario.getText().equals("admin") && txtContrasenia.getText().equals("admin")) {
//
//            main.mostrarVentanaClientes();
//            //Lo que hace el NODE es cerrar la ventana Login
//            ((Node) (event.getSource())).getScene().getWindow().hide();
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
//        }
//        if (validarLogin()) {
//            System.out.println("Cargando vista principal");
////            main.mostrarPrincipal();
//Usuario login = new Usuario(txtUsuario.getText(), txtContrasenia.getText());

        validarLogin();
    }

    @FXML
    private void btnFinalizar() throws Exception, Throwable {
        System.exit(0);

    }
    
   
       
        

     

}
