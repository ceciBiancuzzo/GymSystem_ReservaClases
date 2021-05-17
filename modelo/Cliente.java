/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem.modelo;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Mati10
 */
@XmlRootElement(name = "cliente")
public class Cliente {

    private IntegerProperty idCliente;
    private Date fechaNacimiento;
    private StringProperty nombre;
    private StringProperty apellido;
    private StringProperty dni;
    private StringProperty telefono;
    private StringProperty email;
    private StringProperty estado;

    public Cliente(IntegerProperty idCliente, StringProperty dni) {
        this.idCliente = idCliente;
        this.dni = dni;

    }

    public Cliente() {
    }
    
    

    public Cliente(int idCliente, Date fechaNacimiento, String nombre,
            String apellido, String dni, String telefono,
            String email, String estado) {
        this.idCliente = new SimpleIntegerProperty(idCliente);
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.dni = new SimpleStringProperty(dni);
        this.telefono = new SimpleStringProperty(telefono);
        this.email = new SimpleStringProperty(email);
        this.estado = new SimpleStringProperty(estado);

    }

    //del nuevo proyecto
    public Cliente(String dni, Date fechaNacimiento, String nombre,
            String apellido, String telefono,
            String email, String estado) {

        this.fechaNacimiento = fechaNacimiento;
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.dni = new SimpleStringProperty(dni);
        this.telefono = new SimpleStringProperty(telefono);
        this.email = new SimpleStringProperty(email);
        this.estado = new SimpleStringProperty(estado);

    }

    //constructor para la composicion  08/02
//    public Cliente(int idCliente, String apellido, String nombre, String dni) {
//        this.idCliente = new SimpleIntegerProperty(idCliente);
//        this.nombre = new SimpleStringProperty(nombre);
//        this.apellido = new SimpleStringProperty(apellido);
////        this.abono = abono;
//    }

    public Cliente(Date fechaNacimiento, String nombre,
            String apellido, String dni, String telefono,
            String email, String estado) {

        this.fechaNacimiento = fechaNacimiento;
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.dni = new SimpleStringProperty(dni);
        this.telefono = new SimpleStringProperty(telefono);
        this.email = new SimpleStringProperty(email);
        this.estado = new SimpleStringProperty(estado);
    }

//    public Cliente(int idCliente, String apellido, String nombre, String dni) {
//        this.idCliente = new SimpleIntegerProperty(idCliente);
//        this.apellido = new SimpleStringProperty(apellido);
//        this.nombre = new SimpleStringProperty(nombre);
//        this.dni = new SimpleStringProperty(dni);
//    }
//    public Cliente(String dni, Integer idCliente) {
//        this.idCliente = new SimpleIntegerProperty(idCliente);
//        this.dni = new SimpleStringProperty(dni);
//    }
    public Cliente(int idCliente, String dni) {
        this.idCliente = new SimpleIntegerProperty(idCliente);
        this.dni = new SimpleStringProperty(dni);
    }

//    public Cliente(String dni) {
//          this.dni= new SimpleStringProperty(dni);
//    }
    public Cliente(String dni, String nombre, String apellido) {
        this.dni = new SimpleStringProperty(dni);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
    }

    public Cliente(String apellido, String dni) {
        this.apellido = new SimpleStringProperty(apellido);
        this.dni = new SimpleStringProperty(dni);
    }

    public Cliente(String dni) {

        this.dni = new SimpleStringProperty(dni);
    }

    //del nuevo proyecto
    public Cliente(String dni, Date fechaNacimiento, String nombre, String apellido) {
        this.dni = new SimpleStringProperty(dni);
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
    }

    public Cliente(String dni, String nombre, String apellido, Date fechaNac,
            String telefono, String email, String estado) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.dni = new SimpleStringProperty(dni);
        this.telefono = new SimpleStringProperty(telefono);
        this.email = new SimpleStringProperty(email);
        this.estado = new SimpleStringProperty(estado);

    }

    public Cliente(String nombre, String apellido, String dni, String telefono, String email, String estado) {
       this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.dni = new SimpleStringProperty(dni);
        this.telefono = new SimpleStringProperty(telefono);
        this.email = new SimpleStringProperty(email);
        this.estado = new SimpleStringProperty(estado);
    }




//Metodos atributo: idCliente
//    @XmlElement(name = "idCliente")
//    public int getIdCliente() {
//        return idCliente.get();
//    }
//
//    public void setIdCliente(int idCliente) {
//        this.idCliente = new SimpleIntegerProperty(idCliente);
//    }
//
//    public IntegerProperty IdClienteProperty() {
//        return idCliente;
//    }
    //Metodos atributo: fechaNacimiento

    @XmlElement(name = "fechaNacimiento")
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    //Metodos atributo: nombre
@XmlElement(name = "nombre")
    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public StringProperty NombreProperty() {
        return nombre;
    }
    //Metodos atributo: apellido
@XmlElement(name = "apellido")
    public String getApellido() {
        return apellido.get();
    }

    public void setApellido(String apellido) {
        this.apellido = new SimpleStringProperty(apellido);
    }

    public StringProperty ApellidoProperty() {
        return apellido;
    }
    //Metodos atributo: dni
@XmlElement(name = "dni")
    public String getDni() {
        return dni.get();
    }

    public void setDni(String dni) {
        this.dni = new SimpleStringProperty(dni);
    }

    public StringProperty DniProperty() {
        return dni;
    }
    //Metodos atributo: telefono
@XmlElement(name = "telefono")
    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono = new SimpleStringProperty(telefono);
    }

    public StringProperty TelefonoProperty() {
        return telefono;
    }
    //Metodos atributo: email
@XmlElement(name = "email")
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public StringProperty EmailProperty() {
        return email;
    }
    //Metodos atributo: estado
@XmlElement(name = "estado")
    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado = new SimpleStringProperty(estado);
    }

    public StringProperty EstadoProperty() {
        return estado;
    }

//    @Override
//    public String toString() {
//        return "Cliente" + idCliente.get() + ", nombre=" + nombre.get() + ", apellido=" + apellido.get() + ", dni=" + dni.get();
//    }
    @Override
    public String toString() {
        return dni.get();
    }
    
    
     public static void llenarComboEnTurno1(){
    
    
    
    
    }

}
