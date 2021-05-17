/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ceci
 */
public class ReservaTurno {

    private Integer idTurno;
    private Integer idAbono;
    private Integer idClase;
    private String estado;
    private String detalle;

    public ReservaTurno() {
    }

    public ReservaTurno(Integer idTurno, Integer idAbono, Integer idClase, String estado, String detalle) {
        this.idTurno = idTurno;
        this.idAbono = idAbono;
        this.idClase = idClase;
        this.estado = estado;
        this.detalle = detalle;
    }

    
    
    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Integer getIdAbono() {
        return idAbono;
    }

    public void setIdAbono(Integer idAbono) {
        this.idAbono = idAbono;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    

}
