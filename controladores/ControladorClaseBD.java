package gymsystem.controladores;

import gymsystem.modelo.Clase;
import gymsystem.modelo.ClaseAux;
import gymsystem.modelo.TipoClase;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class ControladorClaseBD extends ControladorDeBaseDatos {

    JdbcHelper jh = new JdbcHelper();

    //  private String insertarClaseSQL = "INSERT INTO clases (idClases,hora,fecha,tipoClase) VALUES (%s,'%s','%s','%s')";
    // private String actualizarClaseSQL = "UPDATE clases  SET `hora`= '%s',`fecha`= '%s',`tipoClase`= '%s' WHERE `idClases`= %s";
    // private String eliminarClase = "DELETE FROM clases WHERE `idClases` = %s";
//    private String todosSQL = "SELECT * FROM producto";
    public ControladorClaseBD() {
        super();
    }

    public boolean insertarClaseSQL(Clase c) {
        String sql = "INSERT INTO clase (hora,fecha,id_tipoClase,baja) VALUES ('"
                + c.getHora() + "','"
                + c.getFecha() + "',"
                + c.getTipoClase().getIdTipoClase()
                + ",0)";

        boolean exito = jh.ejecutarQuery(sql);
        return exito;

    }

    public boolean actualizarClaseSQL(Clase c) {
        String query = "UPDATE clase SET  hora='" + c.getHora() + "',"
                + "fecha='" + c.getFecha() + "',"
                + "id_TipoClase=" + c.getTipoClase().getIdTipoClase() + " "
                + " where idClase = " + c.getIdClase();
        jh.ejecutarQuery(query);

        return true;
    }

    public boolean eliminarClaseSQL(Clase cl) {
        String query = "update clase set baja=1 where idClase = " + cl.getIdClase();

        boolean exito = jh.ejecutarQuery(query);
        return exito;
    }

    public ObservableList<Clase> buscarTodos() {
        //String query = "SELECT idClase,hora,fecha,id_tipoClase FROM clase  where baja=0";
        String query = "Select* from clase_tipoClase ";
        ResultSet rs = jh.realizarConsulta(query);

        ObservableList<Clase> Clases = FXCollections.observableArrayList();

        try {
            while (rs.next()) {
                int idClase = rs.getInt("idClase");
                Time hora = rs.getTime("hora");
                Date fecha = rs.getDate("fecha");
                String descripcion = rs.getString("DESCRIPCION");
                Integer idTipoClase = rs.getInt("id_tipoClase");
                Clases.add(new Clase(idClase, hora.toLocalTime(), fecha.toLocalDate(),
                        new TipoClase(idTipoClase, descripcion))
                );
                System.out.println("Hora: " + hora.toString());
            }
            //idClases, hora.toLocalTime(), fecha.toLocalDate(),descripcion
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar las personas: " + ex,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return Clases;
    }

    public ObservableList<ClaseAux> buscarTablaClase() {

        String query = "select*from clase where baja=0";

        JdbcHelper jdbc = new JdbcHelper();
        ResultSet rs = jdbc.realizarConsulta(query);

        ObservableList<ClaseAux> lista = FXCollections.observableArrayList();

        try {
            while (rs.next()) {

                Integer idClase = rs.getInt(1);
                Time hora = rs.getTime(2);
                Date fecha = rs.getDate(3);
//                String descripcion = rs.getString(4);

                lista.add( new ClaseAux(idClase,hora,fecha));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar tipos de clases " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
//        System.out.println("resultset: " + Clase.toString());
        return lista;
    }

    public ObservableList<Clase> buscarTodos2() {

        String query = "select fecha FROM Clase";

        JdbcHelper jdbc = new JdbcHelper();
        ResultSet rs = jdbc.realizarConsulta(query);

        ObservableList<Clase> FechaYHoraClase = FXCollections.observableArrayList();

        try {
            while (rs.next()) {

                Date fecha = rs.getDate(1);

                Clase unaClase = new Clase(fecha.toLocalDate());

                FechaYHoraClase.add(unaClase);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar tipos de clases " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
//        System.out.println("resultset: " + Clase.toString());
        return FechaYHoraClase;
    }

}
