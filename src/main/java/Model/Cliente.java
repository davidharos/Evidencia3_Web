package Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {

    private Connection DBConnection = new Connection();

    private int idCliente = 0;
    private String nombre = "";
    private String calle = "";
    private String colonia = "";
    private String telefono = "";
    private String tamano = "";
    private String ciudad = "";
    private String cantidad = "";

    public Cliente(int idCliente, String nombre, String calle, String colonia, String telefono, String tamano, String ciudad, String cantidad) {

        setIdCliente(idCliente);
        setNombre(nombre);
        setCalle(calle);
        setColonia(colonia);
        setTelefono(telefono);
        setTamano(tamano);
        setCiudad(ciudad);
        setCantidad(cantidad);

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) { this.colonia = colonia;}

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

}
