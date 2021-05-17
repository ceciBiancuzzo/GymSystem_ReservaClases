package gymsystem.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControladorDeBaseDatos {

//    private String nombreBaseDatos = "turnosgim";
//    private String urlServidor = "jdbc:mysql://localhost:3306/" + nombreBaseDatos;
//    private String usuario = "root";
//    private String password = "";
//    private Connection conexion;
    
   public Connection conectarSQL() {
        //MI CONEXION A SQL
        Connection con = null;
        String servidor = "jdbc:sqlserver://localhost:1434;databaseName=turnosgimM;";
        //String servidor = "jdbc:sqlserver://TERM250619:1433;";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(servidor, "ceci", "1234");

            //JOptionPane.showMessageDialog(null, "Conectado a SQL");
            System.out.println("CONECTADO");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());

        }

        return con;
    }


}
