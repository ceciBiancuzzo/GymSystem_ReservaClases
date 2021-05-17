
package gymsystem.controladores;

import gymsystem.modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ControladorUsuarioBD {

    //recibe y verifica si es login correcto, login traido del LoginController que son de los txtFields
    public boolean validarLoginDB(Usuario usuario) {
        String query = "SELECT * FROM usuario where baja=0";
        JdbcHelper jdbc = new JdbcHelper();
        ResultSet rs = jdbc.realizarConsulta(query);

        try {
            while (rs.next()) {
                //   Integer idLogin = rs.getInt("idLogin");
                if (usuario.getNombre().equals(rs.getString("usuario"))
                        && usuario.getPassword().equals(rs.getString("password"))) {
                    System.out.println("Correcto validar login");
                    return true;
                } else {
                    System.out.println("Login incorrecto");
                    return false;
                }

                //      String tipo = rs.getString("tipo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar logins: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean insertarLogin(Usuario l) {
        String query = "INSERT INTO login (usuario, password, tipo "
                + ") "
                + "VALUES ('"
                + l.getNombre() + "', '"
                + l.getPassword() + "',' "
                + l.getTipo() + "',' "
                + ")";

        JdbcHelper jdbc = new JdbcHelper();
        boolean exito = jdbc.ejecutarQuery(query);
        return exito;
    }

    public boolean editarLogin(Usuario login) {

        JdbcHelper jdbc = new JdbcHelper();

        int id = login.getIdUsuario();
        String usuario = login.getNombre();
        String password = login.getPassword();
        String tipo = login.getTipo();

        String query = "UPDATE login SET "
                + "usuario='" + usuario + "'"
                + ",password='" + password + "'"
                + ",tipo='" + tipo + "'"
                + "WHERE idLogin=" + id
                + ";";

        boolean exito = jdbc.ejecutarQuery(query);

        return exito;

    }

    public Usuario buscarLoginPorId(int idUsuario) {

        try {
            String query = "SELECT * FROM usuario where idLogin =  " + idUsuario;
            JdbcHelper jdbc = new JdbcHelper();
            ResultSet rs = jdbc.realizarConsulta(query);

            while (rs.next()) {
                if (idUsuario == rs.getInt("idLogin")) {

                    int id = rs.getInt("idLogin");
                    String usuario = rs.getString("usuario");
                    String password = rs.getString("password");
                    String tipo = rs.getString("tipo");

//                    int baja = rs.getInt("baja");
                    Usuario login = new Usuario(id, usuario, password, tipo
                    );

                    System.out.println("Conexion cerrada");
                    rs.close();

                    return login;
                }

            }
        } catch (SQLException ex) {
            ex.getMessage();
            System.out.println("Error al procesar con la bd");
        }
        return null;

    }

    public boolean eliminarLogin(int idLogin) {

        JdbcHelper jdbc = new JdbcHelper();

        String query = "UPDATE usuario SET baja=1 where idUsuario = "
                + idLogin;

        boolean exito = jdbc.ejecutarQuery(query);

        return exito;

    }

}
