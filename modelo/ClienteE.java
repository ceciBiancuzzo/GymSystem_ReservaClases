package gymsystem.modelo;

import gymsystem.utils.LocalDateAdapter;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class ClienteE {

    private LocalDate birthday;
    private StringProperty dni;

    public ClienteE(ObjectProperty<LocalDate> fechaNacimiento, StringProperty dni) {
        this.birthday = fechaNacimiento.get();
        this.dni = dni;
    }

    public ClienteE(LocalDate fechaNacimiento) {
        this.birthday = fechaNacimiento;
    }

    public ClienteE(String dni, LocalDate fechaNacimiento) {
        this.dni = new SimpleStringProperty(dni);
        this.birthday = fechaNacimiento;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public StringProperty getDni() {
        return dni;
    }

    public void setDni(StringProperty dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "ClienteE{" + "birthday=" + birthday + ", idCliente=" + dni + '}';
    }

}
