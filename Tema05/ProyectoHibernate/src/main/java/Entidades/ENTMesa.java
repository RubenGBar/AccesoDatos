package Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "Mesas")
public class ENTMesa {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //La opción más usada con MySQL
    @Column(name="idMesa")
    private int idMesa;

    @Column(name = "numComensales")
    private int numComensales;
    @Column(name = "reserva")
    private int reserva;

    public ENTMesa(int numComensales, int reserva) {
        setNumComensales(numComensales);
        setReserva(reserva);
    }

    public ENTMesa() {

    }

    public int getIdMesa() {
        return idMesa;
    }

    public int getNumComensales() {
        return numComensales;
    }

    public void setNumComensales(int numComensales) {
        this.numComensales = numComensales;
    }

    public int getReserva() {
        return reserva;
    }

    public void setReserva(int reserva) {
        this.reserva = reserva;
    }

}
