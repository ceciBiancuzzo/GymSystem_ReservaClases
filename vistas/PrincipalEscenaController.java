/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem.vistas;

import gymsystem.GymSystem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author cecilia
 */
public class PrincipalEscenaController implements Initializable {

    private GymSystem main;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public GymSystem getMain() {
        return main;
    }

    public void setMain(GymSystem main) {
        this.main = main;
    }
    
}
