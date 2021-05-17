package gymsystem.modelo;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author cecilia
 */
public class Abono {

    private IntegerProperty idAbono;
    private Date fechaInicial;
    private Date fechaVto;
    private IntegerProperty cantClases;
    private IntegerProperty clasesAsistidas;
    private IntegerProperty clasesRestantes;
    private Cliente cliente;

    public Abono(int cantClases) {
        this.cantClases = new SimpleIntegerProperty(cantClases);

    }

    public Abono(IntegerProperty idAbono) {
        this.idAbono = idAbono;
    }

    public Abono(int idAbono, int cantClases) {
        this.cantClases = new SimpleIntegerProperty(cantClases);
        this.idAbono = new SimpleIntegerProperty(idAbono);

    }

    public Abono(Integer idAbono, Date fechaInicial,
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

    //constructor que estoy modificando
    public Abono(Integer idAbono, Cliente cliente, Date fechaInicial,
            Date fechaVto, Integer cantClases, Integer clasesAsistidas,
            Integer clasesRestantes) {
        this.idAbono = new SimpleIntegerProperty(idAbono);
        this.fechaInicial = fechaInicial;
        this.fechaVto = fechaVto;
        this.cantClases = new SimpleIntegerProperty(cantClases);
        this.clasesAsistidas = new SimpleIntegerProperty(clasesAsistidas);
        this.clasesRestantes = new SimpleIntegerProperty(clasesRestantes);
        this.cliente = cliente;
    }

    public Abono(Integer idAbonos, Date fechaInicial, Date fechaVto,
            Integer cantClases, Integer clasesAsistidas, Integer clasesRestantes) {
        this.idAbono = new SimpleIntegerProperty(idAbonos);
        this.fechaInicial = fechaInicial;
        this.fechaVto = fechaVto;
        this.cantClases = new SimpleIntegerProperty(cantClases);
        this.clasesAsistidas = new SimpleIntegerProperty(clasesAsistidas);
        this.clasesRestantes = new SimpleIntegerProperty(clasesRestantes);

    }

    public Abono(Integer cantClases, Integer clasesAsistidas, Integer clasesRestantes) {
        this.cantClases = new SimpleIntegerProperty(cantClases);
        this.clasesAsistidas = new SimpleIntegerProperty(clasesAsistidas);
        this.clasesRestantes = new SimpleIntegerProperty(clasesRestantes);
    }

    public Abono() {

    }

    public Abono(Integer idCliente, String dni) {
        this.cliente = cliente;

    }
//
//    public Abono(Integer idCliente, Cliente cliente) {
//
//        this.cliente = cliente;
//    }

    public Abono(Abono a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public Abono(String dni) {
//        this.cliente = cliente;
//    }

    //Metodos atributo: idAbonos
    public int getIdAbono() {
        return idAbono.get();
    }

    public void setIdAbono(int idAbono) {
        this.idAbono = new SimpleIntegerProperty(idAbono);
    }

    public IntegerProperty IdAbonoProperty() {
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

    @Override
    public String toString() {
        return "cantidad Clases=" + cantClases.get();
    }

}
