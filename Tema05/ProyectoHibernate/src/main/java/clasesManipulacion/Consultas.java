package clasesManipulacion;

import Entidades.ENTFactura;
import Entidades.ENTMesa;
import Entidades.ENTPedido;
import Entidades.ENTProducto;

public class Consultas {

    public static Accesobd instancia = new Accesobd();

    public static ENTMesa obtenerUnaMesaPorID(int id) throws Exception {
        instancia.abrir();
        ENTMesa mesa = Accesobd.sesion.get(ENTMesa.class, id);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
        return mesa;
    }

    public static ENTProducto obtenerUnProductoPorID(int id) throws Exception {
        instancia.abrir();
        ENTProducto producto = Accesobd.sesion.get(ENTProducto.class, id);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
        return producto;
    }

    public static ENTPedido obtenerUnPedidoPorID(int id) throws Exception {
        instancia.abrir();
        ENTPedido pedido = Accesobd.sesion.get(ENTPedido.class, id);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
        return pedido;
    }

    public static ENTFactura obtenerUnaFacturaPorID(int id) throws Exception {
        instancia.abrir();
        ENTFactura factura = Accesobd.sesion.get(ENTFactura.class, id);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
        return factura;
    }

}
