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
 * @author Mati10
 */
public class Usuario {

  

    private IntegerProperty idUsuario;
    private StringProperty nombre;
    private StringProperty password;
    private StringProperty tipo;

    public Usuario(int idUsuario, String nombre, String password,
            String tipo) {
        this.idUsuario = new SimpleIntegerProperty(idUsuario);
        this.nombre = new SimpleStringProperty(nombre);
        this.password = new SimpleStringProperty(password);
        this.tipo = new SimpleStringProperty(tipo);
    }

    public Usuario(String nombre, String password) {
        this.nombre = new SimpleStringProperty(nombre);
        this.password = new SimpleStringProperty(password);
    }

    public Usuario() {
           }

    //Metodos atributo: idUsuario
    public int getIdUsuario() {
        return idUsuario.get();
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = new SimpleIntegerProperty(idUsuario);
    }

    public IntegerProperty IdUsuarioProperty() {
        return idUsuario;
    }
    //Metodos atributo: nombre

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public StringProperty NombreProperty() {
        return nombre;
    }
    //Metodos atributo: password

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }

    public StringProperty PasswordProperty() {
        return password;
    }
    //Metodos atributo: tipo

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String tipo) {
        this.tipo = new SimpleStringProperty(tipo);
    }

    public StringProperty TipoProperty() {
        return tipo;
    }
    
    
    
}
