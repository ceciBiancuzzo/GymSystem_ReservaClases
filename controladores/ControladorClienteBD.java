package gymsystem.controladores;

import gymsystem.modelo.Abono;
import gymsystem.modelo.Cliente;
import gymsystem.modelo.ClienteE;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class ControladorClienteBD extends ControladorDeBaseDatos {

    JdbcHelper jh = new JdbcHelper();

//    private final String insertarClienteSQL = "INSERT INTO clientes (idClientes,fechaNacimiento,nombre,apellido,dni,telefono,"
//            + "email, estado,baja) VALUES ('%s','%s','%s','%s',%s,'%s','%s','%s')";
//    private final String actualizarClienteSQL = "UPDATE clientes  SET `fechaNacimiento`= '%s',`nombre`= '%s',`apellido`= '%s', `dni`= %s, `telefono`= '%s',"
//            + "`email`= '%s', `estado`= '%s' WHERE `idClientes`= '%s'";
//    private final String eliminarCliente = "UPDATE clientes SET baja=1 WHERE `idClientes` = %s";
    public ControladorClienteBD() {
        super();
    }

    public boolean insertarClienteSQL(Cliente c) {
        String sql = "INSERT INTO cliente (dni,fechaNacimiento,nombre,apellido,telefono,email,estado) VALUES ('"
                + c.getDni() + "','"
                + c.getFechaNacimiento() + "','"
                + c.getNombre() + "','"
                + c.getApellido() + "','"
                + c.getTelefono() + "','"
                + c.getEmail() + "','"
                + c.getEstado()
                + "')";

        boolean exito = jh.ejecutarQuery(sql);
        return exito;

    }

    public boolean actualizarClienteSQL(Cliente c) {
        String query = "UPDATE cliente SET  fechaNacimiento='" + c.getFechaNacimiento() + "',"
                + "nombre='" + c.getNombre() + "',"
                + "apellido='" + c.getApellido() + "',"
                + "telefono='" + c.getTelefono() + "',"
                + "email='" + c.getEmail() + "',"
                + "estado='" + c.getEstado() + "'  "
                + " where dni = " + c.getDni();
        jh.ejecutarQuery(query);

        return false;
    }

    public boolean eliminarClienteSQL(String dni) {
        String query = "update cliente set baja=1 where dni = " + dni;

        boolean exito = jh.ejecutarQuery(query);
        return exito;
    }

    public ObservableList<Cliente> buscarTodos() {
        String query = "SELECT * FROM cliente  where baja=0";
        ResultSet rs = jh.realizarConsulta(query);

        ObservableList<Cliente> clientes = FXCollections.observableArrayList();

        try {
            while (rs.next()) {
                String dni = rs.getString("dni");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");

                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String estado = rs.getString("estado");
                clientes.add(new Cliente(dni, fechaNacimiento, nombre, apellido, telefono, email, estado));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar las personas: " + ex,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return clientes;
    }

//     public ObservableList<Cliente> buscarTodosCmb() {
//        String query = "SELECT * FROM cliente  where baja=0";
//        ResultSet rs = jh.realizarConsulta(query);
//
//        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
//
//        try {
//            while (rs.next()) {
//                int idCliente = rs.getInt("idCliente");
//                String nombre = rs.getString("nombre");
//                String apellido = rs.getString("apellido");
//                String dni = rs.getString("dni");
//               
//
//                clientes.add(new Cliente(idCliente, nombre, apellido, dni));
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al buscar las personas: " + ex,
//                    "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        return clientes;
//    }
//     
    public ObservableList<ClienteE> buscarFechasNac() {
        try {
            String query = "SELECT dni,fechaNacimiento FROM cliente  where baja=0";
            ResultSet rs = jh.realizarConsulta(query);

            ObservableList<ClienteE> lista = FXCollections.observableArrayList();

            while (rs.next()) {
               
                String dni = rs.getString("dni");
                LocalDate fechaNacimiento = rs.getDate("fechaNacimiento").toLocalDate();

                lista.add(new ClienteE(dni,fechaNacimiento));

                System.out.println("lista" + lista.toString());
                
            }
            return lista;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
        return null;

    }
}
