/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem.utils;

import gymsystem.modelo.Cliente;
import gymsystem.modelo.Cliente;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ceci
 */
@XmlRootElement(name = "clientes")
public class ListaClientesWrapper {
    


    private List<Cliente> clientes;

    @XmlElement(name = "cliente")
    public List<Cliente> getCliente() {
        return clientes;
    }
    @XmlElement(name = "cliente")
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}

/*@XmlRootElement define el nombre del elemento raíz del XML.
@XmlElement es un nombre opcional que podemos especificar para el elemento 
(usado en su representación XML).    

Haremos a nuestra clase MainApp responsable de leer y escribir los datos XML. 
Añade la siguiente pareja de métodos al final de la clase MainApp.java:
 */


