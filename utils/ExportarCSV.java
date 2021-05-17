/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem.utils;

import com.csvreader.CsvWriter;
import gymsystem.controladores.ControladorClienteBD;
import gymsystem.modelo.Cliente;
import gymsystem.modelo.ClienteE;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

/**
 *
 * @author Ceci
 */
public class ExportarCSV {
    
    

    public  void ExportarCSV(ObservableList<Cliente> lista) {
        ControladorClienteBD cc = new ControladorClienteBD();
      lista = FXCollections.observableArrayList();
        try {

            lista.addAll(cc.buscarTodos());

            String direccion = "C:\\Users\\Ceci\\Desktop";
            String nombreCSV = "clientes.csv";

            CsvWriter csvWriter = new CsvWriter(direccion + nombreCSV);

            csvWriter.write("dni");
            csvWriter.write("Birthday:");

            csvWriter.endRecord();

            for (Cliente c : lista) {
                csvWriter.write(c.getDni());
                csvWriter.write(c.getNombre());
                csvWriter.write(c.getApellido());
                

                csvWriter.endRecord();
                csvWriter.close();
            }
            System.out.println("Descarga Iniciada");
        } catch (IOException ex) {
            Logger.getLogger(ExportarCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
     
}
