package gymsystem.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class JdbcHelper {
    
    //para read 
    public ResultSet realizarConsulta(String query){
        ControladorDeBaseDatos con = new ControladorDeBaseDatos();
        
        Connection conn = con.conectarSQL();
        ResultSet rs = null;
        Statement stQuery;
        try {
            stQuery = conn.createStatement();
            rs = stQuery.executeQuery(query);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar consulta a la base de datos, no hay conexión " + ": " + ex);
            return null;

        }
        return rs;
    }
    
    //para insert, update y delete
    public boolean ejecutarQuery(String query){
        ControladorDeBaseDatos con = new ControladorDeBaseDatos();
        Connection conn = con.conectarSQL();
        boolean exito = false;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            int affectedRows = ps.executeUpdate();
            if (affectedRows != 0) {
                exito = true;
//                Conexion.cierraConexion();
            } else {
                exito = false;
//                Conexion.cierraConexion();
            }
            System.out.println("Affected rows: " + affectedRows);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar " + query + ": " + ex);
            ex.getMessage();
            exito = false;
        }
        return exito;
    }

}