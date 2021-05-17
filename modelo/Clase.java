/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem.modelo;

import gymsystem.controladores.JdbcHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mati10
 */
public class Clase {
//en el join no traemos la descripcion, puede ser eso?

    private IntegerProperty idClase;
//    private Time hora;
//    private Date fecha;
//    private IntegerProperty idTipoClase;
    private ObjectProperty<LocalDate> fecha;
    private ObjectProperty<LocalTime> hora;
    private TipoClase tipoClase;
//mostrame la clase

    public Clase(Integer idClase, ObjectProperty<LocalTime> hora, ObjectProperty<LocalDate> fecha, TipoClase tipoClase) {
        this.idClase = new SimpleIntegerProperty(idClase);
        this.fecha = new SimpleObjectProperty(fecha);
        this.hora = new SimpleObjectProperty(hora);
        this.tipoClase = tipoClase;
    }

    public Clase(int idClase, LocalTime hora,
            LocalDate fecha, TipoClase tipoClase) {
        this.idClase = new SimpleIntegerProperty(idClase);
        this.fecha = new SimpleObjectProperty(fecha);
        this.hora = new SimpleObjectProperty(hora);
        this.tipoClase = tipoClase;
    }

    public Clase(LocalTime hora, LocalDate fecha, TipoClase tipoClase) {
        this.fecha = this.fecha = new SimpleObjectProperty(fecha);
        this.hora = this.hora = new SimpleObjectProperty(hora);
        this.tipoClase = tipoClase;
    }

    public Clase(LocalTime hora, LocalDate fecha) {
        this.hora = this.hora = new SimpleObjectProperty(hora);
        this.fecha = this.fecha = new SimpleObjectProperty(fecha);
    }

    public Clase(LocalTime hora, LocalDate fecha, int idTipoClase) {
        this.fecha = this.fecha = new SimpleObjectProperty(fecha);
        this.hora = this.hora = new SimpleObjectProperty(hora);
        this.tipoClase = tipoClase;
    }

    public Clase(Integer idClase, LocalTime toLocalTime, LocalDate toLocalDate) {
        this.idClase = new SimpleIntegerProperty(idClase);
        this.hora = this.hora = new SimpleObjectProperty(hora);
        this.fecha = this.fecha = new SimpleObjectProperty(fecha);
    }

    public Clase(Integer idClase, Time hora, Date fecha) {
        this.idClase = new SimpleIntegerProperty(idClase);
        this.hora = this.hora = new SimpleObjectProperty(hora);
        this.fecha = this.fecha = new SimpleObjectProperty(fecha);
    }

    public Clase(LocalDate toLocalDate) {
        this.fecha = this.fecha = new SimpleObjectProperty(fecha);
    }
//

    public Clase(Integer idClase) {
        this.idClase = new SimpleIntegerProperty(idClase);
    }

    public Clase() {

    }

   

    //Metodos atributo: idClase
    //Metodos atributo: hora
    //Metodos atributo: fecha
    //Metodos atributo: tipoClase
    public TipoClase getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
    }

    public LocalTime getHora() {
        return hora.get();
    }

    public void setHora(LocalTime hora) {
        this.hora.set(hora);
    }

    public ObjectProperty<LocalTime> horaProperty() {
        return hora;
    }

    public LocalDate getFecha() {
        return fecha.get();
    }

    public void setFecha(LocalDate fecha) {
        this.fecha.set(fecha);
    }

    public ObjectProperty<LocalDate> fechaProperty() {
        return fecha;
    }

    public LocalDate fecha() {
        return fecha.get();
    }

    //Metodos atributo: idClase
    public int getIdClase() {
        return idClase.get();
    }

    public void setIdClase(int idClase) {
        this.idClase = new SimpleIntegerProperty(idClase);
    }

    public IntegerProperty IdClaseProperty() {
        return idClase;
    }

    @Override
    public String toString() {
        return idClase.get() + " | " + tipoClase.getDescripcion();

    }

   
}
