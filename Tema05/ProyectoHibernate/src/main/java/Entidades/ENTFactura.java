package Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "Facturas")
public class ENTFactura {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //La opción más usada con MySQL
    @Column(name="idFactura")
    private int idFactura;

    @ManyToOne
    @JoinColumn(name = "idMesa", nullable = false, foreignKey = @ForeignKey(name = "Facturas_ibfk_1"))
    private ENTMesa mesa;
    @Column(name = "tipoPago")
    private String tipoPago;
    @Column(name = "importe")
    private double importe;

    public ENTFactura(ENTMesa mesa, String tipoPago, double importe) {
        setIdMesa(mesa);
        setTipoPago(tipoPago);
        setImporte(importe);
    }

    public ENTFactura() {

    }

    public int getIdFactura() {
        return idFactura;
    }

    public int getIdMesa(){
        return mesa.getIdMesa();
    }

    public void setIdMesa(ENTMesa mesa){
        this.mesa = mesa;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

}
