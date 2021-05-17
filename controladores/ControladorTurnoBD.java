package gymsystem.controladores;

import gymsystem.modelo.Abono;
import gymsystem.modelo.Clase;
import gymsystem.modelo.Cliente;
import gymsystem.modelo.ReservaTurno;
import gymsystem.modelo.TipoClase;
import gymsystem.modelo.Turno;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ceci
 */
public class ControladorTurnoBD {

    public ObservableList<Turno> buscarTodos() {

        String query
                = "select*from reservaTurno";

//      "SELECT t.idTurno, c.nombre, c.apellido, c.dni, cl.hora, cl.fecha, a.cantClases"
//              + "FROM dbo.reserva_turno AS t INNER JOIN"
//              + "dbo.abono AS a ON t.idAbono = a.idAbonos INNER JOIN"
//              + "dbo.clase AS cl ON t.idClase = cl.idClase INNER JOIN"
//              + "dbo.cliente AS c ON a.dni = c.dni";
//SELECT        t.idTurno, t.idAbono, t.idClase, cl.hora, cl.fecha, a.dni, a.cantClases, c.nombre, c.apellido, tc.descripcion, cl.id_tipoClase
//FROM            dbo.reserva_turno AS t INNER JOIN
//                         dbo.abono AS a ON t.idAbono = a.idAbonos INNER JOIN
//                         dbo.clase AS cl ON t.idClase = cl.idClase INNER JOIN
//                         dbo.cliente AS c ON a.dni = c.dni INNER JOIN
//                         dbo.tipoClase AS tc ON cl.id_tipoClase = tc.id_tipoClase
        JdbcHelper jdbc = new JdbcHelper();
        ResultSet rs = jdbc.realizarConsulta(query);
        ObservableList<Turno> turnos = FXCollections.observableArrayList();

        try {
            while (rs.next()) {

                Integer idTurno = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String dni = rs.getString(4);
                //Integer idClase= rs.getInt(5);
                Time hora = rs.getTime(5);
                Date fecha = rs.getDate(6);
                //  Integer idAbono = rs.getInt(8);
                Integer cantClases = rs.getInt(7);
                
                Turno t = new Turno(idTurno,
                        new Cliente(nombre, apellido, dni),
                        new Clase(hora.toLocalTime(), fecha.toLocalDate()),
                        new Abono(cantClases)
                    
                );

                turnos.add(t);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar turnos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return turnos;

    }

    // otro metodo buscar todos
//    public ObservableList<Turno> buscarTurnoCompleto() {
//
//        String query
//                = "select*from turnoCompleto";
//
//        JdbcHelper jdbc = new JdbcHelper();
//        ResultSet rs = jdbc.realizarConsulta(query);
//        ObservableList<Turno> turnos = FXCollections.observableArrayList();
//
//        try {
//            while (rs.next()) {
//                /*  dbo.abono.fechaInicial, dbo.abono.fechaVto, dbo.abono.cantClases, dbo.abono.clasesRestantes, dbo.abono.clasesAsistidas, dbo.clase.hora, dbo.clase.fecha, 
//                         dbo.clase.id_tipoClase, dbo.reserva_turno.estadoTurno AS Expr4, dbo.reserva_turno.detalle AS Expr5, dbo.cliente.nombre, dbo.cliente.apellido, dbo.cliente.telefono, dbo.cliente.email, dbo.cliente.estado, 
//                         dbo.tipoClase.descripcion, dbo.abono.idAbonos, dbo.clase.idClase AS Expr1, dbo.cliente.dni AS Expr3, dbo.tipoClase.id_tipoClase */
//                Integer idTurno = rs.getInt(1);
//                Date fechaInicial = rs.getDate("fechaInicial");
//                Date fechaVto = rs.getDate("fechaVto");
//                Integer cantClases = rs.getInt(7);
//                Integer clasesRestantes = rs.getInt("clasesRestantes");
//                Integer clasesAsistidas = rs.getInt("clasesAsistidas");
//                Time hora = rs.getTime(5);
//                Date fecha = rs.getDate(6);
//                Integer id_tipoClase = rs.getInt("id_tipoClase");
//                String estadoTurno = rs.getString("estadoTurno");
//                String detalle = rs.getString("detalle");
//                String nombre = rs.getString(2);
//                String apellido = rs.getString(3);
//                String telefono = rs.getString("telefono");
//                String email = rs.getString("email");
//                String estado = rs.getString("estado");
//                String descripcion = rs.getString("descripcion");
//                Integer idAbono = rs.getInt("idAbono");
//
//                Integer idClase = rs.getInt("idClase");
//                String dni = rs.getString(4);
//
//                //Integer idClase= rs.getInt(5);
//                //  Integer idAbono = rs.getInt(8);
//                Turno t = new Turno(idTurno, estadoTurno, detalle,
//                        new Cliente(nombre, apellido, dni, telefono, email, estado),
//                        new Clase(idClase, hora.toLocalTime(), fecha.toLocalDate()),
//                        new Abono(idAbono, fechaInicial, fechaVto, clasesRestantes, clasesAsistidas, cantClases),
//                        new TipoClase(id_tipoClase, descripcion));
//
//                turnos.add(t);
//
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al buscar turnos: " + ex.getMessage(),
//                    "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        return turnos;
//
//    }

    public boolean insertarTurno(ReservaTurno t) {
        
//         t = new ReservaTurno(a,c,"","");
//        System.out.println("Turno: " + t.getAbono().getIdAbono());
//        System.out.println("en insertar turno " + t.toString() + "\n ");
        String query = "insert into reserva_turno values ("+
               
                //                + a.getIdAbonos() + ","
                +t.getIdAbono()+","
//                + t.getAbono().getIdAbono()+","
                + t.getIdClase() + ","
                //                + t.getEstadoTurno() + "','"
                + "'Confirmado'" + ",'"
                + t.getDetalle() + "'"
                + ")";

        JdbcHelper jdbc = new JdbcHelper();
        boolean exito = jdbc.ejecutarQuery(query);
        return exito;
    }

    public ObservableList<Clase> buscarFechaYHora() {
//        String query = "SELECT * FROM Productos";

        String query = "select*from View_1";

        JdbcHelper jdbc = new JdbcHelper();
        ResultSet rs = jdbc.realizarConsulta(query);

        ObservableList<Clase> FechaYHoraClase = FXCollections.observableArrayList();

        try {
            while (rs.next()) {
              Integer idClase = rs.getInt(1);
//              Integer idAbono= rs.getInt(2);
                Time hora = rs.getTime(3);
                Date fecha = rs.getDate(4);
                String descripcion = rs.getString(5);
                

                Clase unaClase = new Clase(
                       
                        idClase, hora.toLocalTime(), fecha.toLocalDate(),
                        new TipoClase( descripcion)
                );

                FechaYHoraClase.add(unaClase);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar tipos de clases " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
//        System.out.println("resultset: " + Clase.toString());
        return FechaYHoraClase;
    }

    public ObservableList<Clase> ComboBox() {
        return null;
//        String query = "select idClase,hora,fecha from Clase";
//
//        JdbcHelper jdbc = new JdbcHelper();
//        ResultSet rs = jdbc.realizarConsulta(query);
//        ObservableList<Clase> cmbClasesTurnos = FXCollections.observableArrayList();
//
//        try {
//            while (rs.next()) {
//                Integer idClase= rs.getInt(1);  
//                Time hora = rs.getTime(2);
//                Date fecha = rs.getDate(3);
//               
//                
//
//                Clase c = new Clase(idClase,hora.toLocalTime(), fecha.toLocalDate()
//                       
//                );
//
//                cmbClasesTurnos.add(c);
//
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al buscar abonos: " + ex.getMessage(),
//                    "Error", JOptionPane.ERROR_MESSAGE);
//        }
////        System.out.println("resultset: " + cmbClasesTurnos.toString());
//        return cmbClasesTurnos;
//
//    }
//    
    }
}
