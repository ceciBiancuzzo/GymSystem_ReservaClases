package gymsystem.controladores;

import gymsystem.modelo.Abono;
import gymsystem.modelo.AbonoAux;
import gymsystem.modelo.ClaseAux;
import gymsystem.modelo.Cliente;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cecilia
 */
public class ControladorAbonoBD extends ControladorDeBaseDatos {

    public ObservableList<Abono> buscarTodos() {
        String query = "Select* from abono_cliente";
//        String query = "SELECT a.idAbono,"
//                + "a.fechaInicial,"
//                + "a.fechaVto,"
//                + "a.cantClases,"
//                + "a.clasesAsistidas,"
//                + "a.clasesRestantes,"
//                + "c.dni "
//                + "FROM abono a "
//                + "INNER JOIN cliente c ON a.idCliente=c.idCliente where a.baja=0";

        JdbcHelper jdbc = new JdbcHelper();
        ResultSet rs = jdbc.realizarConsulta(query);

        ObservableList<Abono> abonos = FXCollections.observableArrayList();

        try {
            while (rs.next()) {
//                
                Integer idAbonos = rs.getInt(1);
                Date fechaInicial = rs.getDate(2);
                Date fechaVto = rs.getDate(3);
                Integer cantClases = rs.getInt(4);
                Integer clasesAsistidas = rs.getInt(5);
                Integer clasesRestantes = rs.getInt(6);
                String dni = rs.getString(7);
                String apellido = rs.getString(8);
                String nombre = rs.getString(9);
                Date fechaNac = rs.getDate("fechaNacimiento");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String estado = rs.getString("estado");

//                String dni = rs.getString(8);
//                Date fechaNac = rs.getDate("fechaNacimiento");
//                String nombre = rs.getString("nombre");
//                String apellido = rs.getString("apellido");
//                String dni = rs.getString("dni");
//                String telefono = rs.getString("telefono");
//                String email = rs.getString("email");
//                String estado = rs.getString("estado");
                Abono a = new Abono(idAbonos, fechaInicial,
                        fechaVto, cantClases, clasesAsistidas, clasesRestantes,
                        new Cliente(dni, nombre, apellido, fechaNac, telefono, email, estado)
                );

                abonos.add(a);

//                System.out.println("Abono: " + abonos.toString());
            }
            System.out.println("Lista: " + abonos.toString());
            return abonos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar abonos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("resultset: " + abonos.toString());
        return null;

    }

    public ControladorAbonoBD() {
    }

  
     
    public boolean insertarAbono(Abono a) {
//insert into Productos values('103','vaso','plastico chico','x50',30,10,19.5,16.6,14.7,1,1,'nose',1,getdate())

        System.out.println("en insertar abono " + a.toString() + "\n ");
        String query = "insert into abono values ('"
                //                + a.getIdAbonos() + ","
                + a.getCliente().getDni() + "','"
                + a.getFechaInicial() + "','"
                + a.getFechaVto() + "',"
                + a.getCantClases() + ","
                +   "0,"
                +a.getCantClases() + ","
                + 0 + ")";
        //  'plastico mediano','x50',30,90,19.5,16.6,14.7,1,1,'matias' ,1)
        JdbcHelper jdbc = new JdbcHelper();
        boolean exito = jdbc.ejecutarQuery(query);
        return exito;
    }

    public boolean actualizarAbono(Abono a) {

        JdbcHelper jdbc = new JdbcHelper();
        System.out.println("p: " + a.toString());

        String query = "UPDATE abono SET  dni='" + a.getCliente().getDni() + "',"
                + "fechaInicial='" + a.getFechaInicial() + "',"
                + "fechaVto='" + a.getFechaVto() + "',"
                + "cantClases='" + a.getCantClases() + "',"
                + "clasesAsistidas='" + a.getClasesAsistidas() + "',"
                + "clasesRestantes='" + a.getClasesRestantes() + "'"
                + " where idAbonos = '" + a.getIdAbono() + "';";

        jdbc.ejecutarQuery(query);

        return true;
    }

    public Abono buscarAbonoPorId(int idAbonos) {

        try {
            String query = "SELECT * FROM abono where IdAbono =  " + idAbonos;
            JdbcHelper jdbc = new JdbcHelper();
            ResultSet rs = jdbc.realizarConsulta(query);

            while (rs.next()) {
                if (idAbonos == rs.getInt("idAbono")) {
                    System.out.println("Validación de id correcta desde la bd");

                    System.out.println("Abono db");

                    System.out.println("Conexion cerrada");
                    rs.close();

                    return null;
                }

            }
        } catch (SQLException ex) {
            ex.getMessage();
            System.out.println("Error al procesar con la bd");
        }
        return null;

    }

    public boolean eliminarAbono(Abono abo) {
        String query = "update abono set baja=1 where idAbonos = " + abo.getIdAbono();
        JdbcHelper jh = new JdbcHelper();
        boolean exito = jh.ejecutarQuery(query);
        return exito;
    }

//    public boolean actualizarAbono(Abono a, int cantClases) {   //hacer el procedimiento almacenado
//
//        JdbcHelper jdbc = new JdbcHelper();
//        System.out.println("p: " + a.toString());
//
//        String query = "Exec DESCONTAR_STOCK " + "'" + a.getCliente().getDni() + "'" + "," + cantClases;
//
//        jdbc.ejecutarQuery(query);
//
//        return true;
//    }
//    public boolean restablecerAbono(Abono a, int cantClases) {   //hacer el procedimiento almacenado
//
//        JdbcHelper jdbc = new JdbcHelper();
//        System.out.println("p: " + a.toString());
//
//        String query = "Exec REESTABLECER_STOCK " + "'" + a.getCliente().getDni() + "'" + "," + cantClases;
//
//        jdbc.ejecutarQuery(query);
//
//        return true;
//    }
    
    
     public ObservableList<AbonoAux> buscarDatosCliente() {

        String query = "select idAbonos,dni from abono where baja=0";

        JdbcHelper jdbc = new JdbcHelper();
        ResultSet rs = jdbc.realizarConsulta(query);

        ObservableList<AbonoAux> lista = FXCollections.observableArrayList();

        try {
            while (rs.next()) {

                Integer idAbonos = rs.getInt(1);
                String dni = rs.getString(2);
                
//                String descripcion = rs.getString(4);

                AbonoAux ab=  new AbonoAux(idAbonos, (new Cliente(dni)));
//                System.out.println(lista.toString());
                lista.add(ab);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar tipos de clases " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
//        System.out.println("resultset: " + lista.toString());
        return lista;
    }
}
