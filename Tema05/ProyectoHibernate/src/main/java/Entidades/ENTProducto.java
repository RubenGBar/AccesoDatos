package Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "Productos")
public class ENTProducto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //La opción más usada con MySQL
    @Column(name="idProducto")
    private int idProducto;

    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "precio")
    private double precio;

    public ENTProducto(String denominacion, double precio) {
        setDenominacion(denominacion);
        setPrecio(precio);
    }

    public ENTProducto() {

    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getDenominacion() { return denominacion; }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecio() { return precio;}

    public void setPrecio(double precio) { this.precio = precio;}

}
