package gymsystem.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ceci
 */
public class Turno {

    private IntegerProperty idTurno;
    private Abono abono;
    private Clase clase;
    private Cliente cliente;
    private StringProperty estadoTurno;
    private StringProperty detalle;
    private IntegerProperty idClase;
    private ObjectProperty<LocalDate> fecha;
    private ObjectProperty<LocalTime> hora;
    private TipoClase tipoClase;
//    private IntegerProperty idAbonos;

    public Turno() {
    }

    //en beta
    public Turno(Clase clase, ObjectProperty<LocalDate> fecha, ObjectProperty<LocalTime> hora, TipoClase tipoClase, String estadoTurno, String detalle) {
        this.clase = clase;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoClase = tipoClase;
        this.estadoTurno = new SimpleStringProperty(estadoTurno);
        this.detalle = new SimpleStringProperty(detalle);
    }

    public Turno(int idTurno, Abono abono, Clase clase,
            String estadoTurno, String detalle) {

        this.idTurno = new SimpleIntegerProperty(idTurno);
        this.abono = abono;
        this.clase = clase;
        this.estadoTurno = new SimpleStringProperty(estadoTurno);
        this.detalle = new SimpleStringProperty(detalle);
    }

    public Turno(Clase clase, Abono abono,
            String estadoTurno, String detalle) {

        this.clase = clase;

        this.estadoTurno = new SimpleStringProperty(estadoTurno);
        this.detalle = new SimpleStringProperty(detalle);
    }

//    public Turno(String estadoTurno, Cliente cliente, Clase clase, Abono abono) {
//        this.estadoTurno = new SimpleStringProperty(estadoTurno);
//        this.cliente = cliente;
//        this.clase = clase;
//        this.abono = abono;
//
//    }
//    public Turno(StringProperty estadoTurno, Cliente cliente, Clase clase, Abono abono) {
//        this.estadoTurno = estadoTurno;
//        this.abono = abono;
//        this.clase = clase;
//        this.cliente = cliente;
//    }
//       public Turno(int idTurno,Abono abono,Clase clase,String estadoTurno, String detalle  ) {
//        this.estadoTurno = new SimpleStringProperty(estadoTurno);
//        this.cliente = cliente;
//        this.clase = clase;
//        this.abono = abono;
//
//    }
    //este acabo de modificar
//este es el que estamos usando para combobox de turno
    public Turno(Integer idClase, LocalTime hora, LocalDate fecha, TipoClase tipoClase) {
        this.idClase = new SimpleIntegerProperty(idClase);

        this.fecha = this.fecha = new SimpleObjectProperty(fecha);;
        this.hora = this.hora = new SimpleObjectProperty(hora);
        this.tipoClase = tipoClase;

    }

    //nuevo constructor turnoCompleto
    public Turno(int idTurno, String estadoTurno, String detalle,
            Cliente cliente, Clase clase, Abono abono, TipoClase tipoClase) {
        this.idTurno = new SimpleIntegerProperty(idTurno);
        this.estadoTurno = new SimpleStringProperty(estadoTurno);
        this.detalle = new SimpleStringProperty(detalle);
        this.cliente = cliente;
        this.clase = clase;
        this.abono = abono;
        this.tipoClase = tipoClase;
    }

    public Turno(Abono abono, Clase clase) {
        this.abono = abono;
        this.clase = clase;
    }

    public Turno(Integer idTurno, Cliente cliente, Clase clase, Abono abono) {
        this.idTurno = new SimpleIntegerProperty(idTurno);
        this.cliente = cliente;
        this.clase = clase;
        this.abono = abono;
    }

    public Turno(Abono a, Clase c, String string, String string0) {
        this.abono=abono;
        this.clase=clase;
    }

    //Metodos atributo: idTurno
    public int getIdTurno() {
        return idTurno.get();
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = new SimpleIntegerProperty(idTurno);
    }

    public IntegerProperty IdTurnoProperty() {
        return idTurno;
    }
    //Metodos atributo: abono

    public Abono getAbono() {
        return abono;
    }

    public void setAbono(Abono abono) {
        this.abono = abono;
    }
    //Metodos atributo: clase

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
    //Metodos atributo: estadoTurno

    public String getEstadoTurno() {
        return estadoTurno.get();
    }

    public void setEstadoTurno(String estadoTurno) {
        this.estadoTurno = new SimpleStringProperty(estadoTurno);
    }

    public StringProperty EstadoTurnoProperty() {
        return estadoTurno;
    }
    //Metodos atributo: detalle

    public String getDetalle() {
        return detalle.get();
    }

    public void setDetalle(String detalle) {
        this.detalle = new SimpleStringProperty(detalle);
    }

    public StringProperty DetalleProperty() {
        return detalle;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

//    
//   
//    public String toString(ObservableList<Turno> buscarFechaYHora) {
//       
//        return  + idClase + ", fecha=" + fecha + ", hora=" + hora + ", tipoClase=" + tipoClase + '}';
//    }
}
