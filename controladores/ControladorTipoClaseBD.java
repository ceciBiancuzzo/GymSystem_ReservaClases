
package gymsystem.controladores;

import gymsystem.modelo.Clase;
import gymsystem.modelo.TipoClase;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ceci
 */
public class ControladorTipoClaseBD {
    
    public ObservableList<TipoClase> buscarTodos() {


        String query = "select * from TipoClase";
        
        
        JdbcHelper jdbc = new JdbcHelper();
        ResultSet rs = jdbc.realizarConsulta(query);

        ObservableList<TipoClase> tipoClase = FXCollections.observableArrayList();

        try {
            while (rs.next()) {
                Integer idTipoClase = rs.getInt(1);
                String descripcion = rs.getString(2);
                
                TipoClase tc = new TipoClase(idTipoClase, descripcion);

                tipoClase.add(tc);

            }
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Error al buscar tipos de clases " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
     
        }
        System.out.println("resultset: " + tipoClase.toString());
        return tipoClase;
}
    
    public boolean insertarTIpoClaseSQL(TipoClase tc) {
        String sql = "INSERT INTO TipoClase (id_tipoClase,descripcion,baja) VALUES ('"
                + tc.getIdTipoClase() + "','"
                + tc.getDescripcion() + "',"
                 + "',0)";

         JdbcHelper jdbc = new JdbcHelper();
       
        boolean exito = jdbc.ejecutarQuery(sql);
        return exito;

    }  
    
    
    
}
