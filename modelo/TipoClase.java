/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem.modelo;

import java.sql.Date;
import java.sql.Time;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ceci
 */
public class TipoClase {
    
 public IntegerProperty idTipoClase;
    private StringProperty descripcion;

    public TipoClase( String descripcion) {
        
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public TipoClase(StringProperty descripcion) {
        this.descripcion = descripcion;
        System.out.println("esta es :"+descripcion);
    }

   

    public TipoClase() {

    }

    public TipoClase(Integer idTipoClase, String descripcion) {
        this.idTipoClase= new SimpleIntegerProperty(idTipoClase);
        this.descripcion = new SimpleStringProperty(descripcion);
    }

   

  

    //Metodos atributo: idCategoria
    public int getIdTipoClase() {
        return idTipoClase.get();
    }

    public void setIdTipoClase(int idTipoClase) {
        this.idTipoClase = new SimpleIntegerProperty(idTipoClase);
    }

    public IntegerProperty IdTipoClaseProperty() {
        return idTipoClase;
    }
    //Metodos atributo: nombre

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public StringProperty DescripcionProperty() {
        return descripcion;
    }

    @Override
    public String toString() {
        return  idTipoClase.get() + "," + descripcion.get() ;
    }

 
   

  

  

}
