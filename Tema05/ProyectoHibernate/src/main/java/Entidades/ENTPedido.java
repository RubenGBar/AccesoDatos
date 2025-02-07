package Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "Pedidos")
public class ENTPedido {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //La opción más usada con MySQL
    @Column(name="idPedido")
    private int idPedido;

    @OneToOne
    @JoinColumn(name = "idFactura", nullable = false)
    private ENTFactura factura;
    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private ENTProducto producto;
    @Column(name = "cantidad")
    private int cantidad;

    public ENTPedido(ENTFactura factura, ENTProducto producto, int cantidad) {
        setIdFactura(factura);
        setIdProducto(producto);
        setCantidad(cantidad);
    }

    public ENTPedido() {

    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdFactura(){
        return factura.getIdFactura();
    }

    public void setIdFactura(ENTFactura factura){
        this.factura = factura;
    }

    public int getIdProducto(){
        return producto.getIdProducto();
    }

    public void setIdProducto(ENTProducto producto){
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
