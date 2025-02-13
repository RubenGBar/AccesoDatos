package clasesManipulacion;

import Entidades.ENTFactura;
import Entidades.ENTMesa;
import Entidades.ENTPedido;
import Entidades.ENTProducto;

public class Agregar {

    public static Accesobd instancia = new Accesobd();

    public static void agregarMesa(ENTMesa mesa) throws Exception {
        instancia.abrir();
        Accesobd.sesion.persist(mesa);
        Accesobd.sesion.close();
    }

    public static void agregarProductos(ENTProducto producto) throws Exception {
        instancia.abrir();
        Accesobd.sesion.persist(producto);
        Accesobd.sesion.close();
    }

    public static void agregarFacturas(ENTFactura factura) throws Exception {
        instancia.abrir();
        Accesobd.sesion.persist(factura);
        Accesobd.sesion.close();
    }

    public static void agregarPedidos(ENTPedido pedido) throws Exception {
        instancia.abrir();
        Accesobd.sesion.persist(pedido);
        Accesobd.sesion.close();
    }

}
