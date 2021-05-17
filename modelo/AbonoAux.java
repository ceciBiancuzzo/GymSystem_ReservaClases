package gymsystem.modelo;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author cecilia
 */
public class AbonoAux {

    private IntegerProperty idAbono;
    private Date fechaInicial;
    private Date fechaVto;
    private IntegerProperty cantClases;
    private IntegerProperty clasesAsistidas;
    private IntegerProperty clasesRestantes;
    private Cliente cliente;

    public AbonoAux(int cantClases) {
        this.cantClases = new SimpleIntegerProperty(cantClases);

    }

    public AbonoAux(IntegerProperty idAbono) {
        this.idAbono = idAbono;
    }

    public AbonoAux(int idAbono, int cantClases) {
        this.cantClases = new SimpleIntegerProperty(cantClases);
        this.idAbono = new SimpleIntegerProperty(idAbono);

    }

    public AbonoAux(Integer idAbono, Date fechaInicial,
            Date fechaVto, Integer cantClases, Integer clasesAsistidas,
            Integer clasesRestantes, Cliente cliente) {
        this.idAbono = new SimpleIntegerProperty(idAbono);
        this.fechaInicial = fechaInicial;
        this.fechaVto = fechaVto;
        this.cantClases = new SimpleIntegerProperty(cantClases);
        this.clasesAsistidas = new SimpleIntegerProperty(clasesAsistidas);
        this.clasesRestantes = new SimpleIntegerProperty(clasesRestantes);
        this.cliente = cliente;
    }

//    //constructor que estoy modificando
//    public AbonoAux(Integer idAbonos, Cliente cliente, Date fechaInicial,
//            Date fechaVto, Integer cantClases, Integer clasesAsistidas,
//            Integer clasesRestantes) {
//        this.idAbono = new SimpleIntegerProperty(idAbonos);
//        this.fechaInicial = fechaInicial;
//        this.fechaVto = fechaVto;
//        this.cantClases = new SimpleIntegerProperty(cantClases);
//        this.clasesAsistidas = new SimpleIntegerProperty(clasesAsistidas);
//        this.clasesRestantes = new SimpleIntegerProperty(clasesRestantes);
//        this.cliente = cliente;
//    }

    public AbonoAux(Integer idAbonos, Date fechaInicial, Date fechaVto,
            Integer cantClases, Integer clasesAsistidas, Integer clasesRestantes) {
        this.idAbono = new SimpleIntegerProperty(idAbonos);
        this.fechaInicial = fechaInicial;
        this.fechaVto = fechaVto;
        this.cantClases = new SimpleIntegerProperty(cantClases);
        this.clasesAsistidas = new SimpleIntegerProperty(clasesAsistidas);
        this.clasesRestantes = new SimpleIntegerProperty(clasesRestantes);

    }

    public AbonoAux(Integer cantClases, Integer clasesAsistidas, Integer clasesRestantes) {
        this.cantClases = new SimpleIntegerProperty(cantClases);
        this.clasesAsistidas = new SimpleIntegerProperty(clasesAsistidas);
        this.clasesRestantes = new SimpleIntegerProperty(clasesRestantes);
    }

    public AbonoAux() {

    }

    public AbonoAux(IntegerProperty idAbono, Cliente cliente) {
        this.idAbono = idAbono;
        this.cliente = cliente;
    }

 


    public AbonoAux(String dni) {
        this.cliente = cliente;
    }

    public AbonoAux(Integer idAbono) {
        this.idAbono= new SimpleIntegerProperty(idAbono);
    }

    public AbonoAux(Integer idAbono, Cliente cliente) {
    this.idAbono= new SimpleIntegerProperty(idAbono);
    this.cliente = cliente;
    }

    //Metodos atributo: idAbonos
    public int getIdAbonos() {
        return idAbono.get();
    }

    public void setIdAbonos(int idAbonos) {
        this.idAbono = new SimpleIntegerProperty(idAbonos);
    }

    public IntegerProperty IdAbonosProperty() {
        return idAbono;
    }
    //Metodos atributo: fechaIncial

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaIncial) {
        this.fechaInicial = fechaIncial;
    }
    //Metodos atributo: fechaVto

    public Date getFechaVto() {
        return fechaVto;
    }

    public void setFechaVto(Date fechaVto) {
        this.fechaVto = fechaVto;
    }
    //Metodos atributo: idClientes

//    public int getIdClientes() {
//        return idCliente.get();
//    }
//
//    public void setIdClientes(int idClientes) {
//        this.idCliente = new SimpleIntegerProperty(idClientes);
//    }
//
//    public IntegerProperty IdClientesProperty() {
//        return idCliente;
//    }
    //Metodos atributo: cantClases
    public int getCantClases() {
        return cantClases.get();
    }

    public void setCantClases(int cantClases) {
        this.cantClases = new SimpleIntegerProperty(cantClases);
    }

    public IntegerProperty CantClasesProperty() {
        return cantClases;
    }
    //Metodos atributo: clasesAsistidas

    public int getClasesAsistidas() {
        return clasesAsistidas.get();
    }

    public void setClasesAsistidas(int clasesAsistidas) {
        this.clasesAsistidas = new SimpleIntegerProperty(clasesAsistidas);
    }

    public IntegerProperty ClasesAsistidasProperty() {
        return clasesAsistidas;
    }
    //Metodos atributo: clasesRestantes

    public int getClasesRestantes() {
        return clasesRestantes.get();
    }

    public void setClasesRestantes(int clasesRestantes) {
        this.clasesRestantes = new SimpleIntegerProperty(clasesRestantes);
    }

    public IntegerProperty ClasesRestantesProperty() {
        return clasesRestantes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public IntegerProperty getIdAbono() {
        return idAbono;
    }

    @Override
    public String toString() {
        return idAbono.get() + " | " + cliente.getDni();
    }

   

  

}
