package clasesManipulacion;

import Colores.Colores;
import Entidades.ENTFactura;
import Entidades.ENTMesa;
import Entidades.ENTPedido;
import Entidades.ENTProducto;

public class Editar {

    public static Accesobd instancia = new Accesobd();

    public static void actualizarMesa(int id, ENTMesa mesa) throws Exception {
        instancia.abrir();
        ENTMesa mes = Accesobd.sesion.get(ENTMesa.class, id);
        mes.setReserva(mesa.getReserva());
        mes.setNumComensales(mesa.getNumComensales());
        Accesobd.sesion.merge(mes);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void actualizarProducto(int id, ENTProducto producto) throws Exception {
        instancia.abrir();
        ENTProducto prod = Accesobd.sesion.get(ENTProducto.class, id);
        prod.setDenominacion(producto.getDenominacion());
        prod.setPrecio(producto.getPrecio());
        Accesobd.sesion.merge(prod);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void actualizarFactura(int id, ENTFactura factura) throws Exception {
        instancia.abrir();

        int idMesaAsociada = factura.getIdMesa();
        ENTMesa mesaFactura = Consultas.obtenerUnaMesaPorID(idMesaAsociada);

        ENTFactura fact = Accesobd.sesion.get(ENTFactura.class, id);
        fact.setImporte(factura.getImporte());
        fact.setTipoPago(factura.getTipoPago());
        fact.setIdMesa(mesaFactura);
        Accesobd.sesion.merge(fact);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void actualizarPedido(int id, ENTPedido pedido) throws Exception {
        instancia.abrir();

        int idProductoAsociado = pedido.getIdProducto();
        ENTProducto productoPedido = Consultas.obtenerUnProductoPorID(idProductoAsociado);

        int idFacturaAsociada = pedido.getIdFactura();
        ENTFactura facturaPedido = Consultas.obtenerUnaFacturaPorID(idFacturaAsociada);

        ENTPedido ped = Accesobd.sesion.get(ENTPedido.class, id);
        ped.setCantidad(pedido.getCantidad());
        ped.setIdProducto(productoPedido);
        ped.setIdFactura(facturaPedido);
        Accesobd.sesion.merge(ped);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void editarMesa(){

        int idMesa = 0;
        ENTMesa mesaAEditar;
        int numComensales = 0;
        int reserva = 0;
        String editar = "";

        try{

            Consultas.listarTodasLasMesas();

            System.out.println("Introduce el id de la mesa a editar");
            idMesa = Principal.sc.nextInt();
            Principal.sc.nextLine();

            mesaAEditar = Consultas.obtenerUnaMesaPorID(idMesa);
            System.out.println(Colores.amarillo + "ID: " + mesaAEditar.getIdMesa());
            System.out.println("Número Comensales: " + mesaAEditar.getNumComensales());
            System.out.println("Reserva: " + mesaAEditar.getReserva());
            System.out.println("--------------------------------------" + Colores.blanco);

            System.out.println(Colores.azul + "Quiere editar el número de comensales de la mesa?(Si/No)" + Colores.blanco);
            editar = Principal.sc.nextLine();

            if(editar.equalsIgnoreCase("Si")){

                System.out.println("Introduce el nuevo número de comensales de la mesa");
                numComensales = Principal.sc.nextInt();
                Principal.sc.nextLine();

            } else {

                System.out.println(Colores.naranja + "No se editará el número de comensales" + Colores.blanco);
                numComensales = mesaAEditar.getNumComensales();

            }

            System.out.println(Colores.azul + "Quiere editar si la mesa tiene reserva?(Si/No)" + Colores.blanco);
            editar = Principal.sc.nextLine();

            if(editar.equalsIgnoreCase("Si")){

                System.out.println("Introduce si la mesa tiene reserva (1 Sí | 0 No)");
                reserva = Principal.sc.nextInt();

            } else {

                System.out.println(Colores.naranja + "No se editará si la mesa tiene reserva" + Colores.blanco);
                reserva = mesaAEditar.getReserva();

            }

            ENTMesa mesa = new ENTMesa(numComensales, reserva);
            Editar.actualizarMesa(idMesa, mesa);

            mesaAEditar = Consultas.obtenerUnaMesaPorID(idMesa);
            System.out.println(Colores.verde + "Mesa Editada");
            System.out.println("ID: " + mesaAEditar.getIdMesa());
            System.out.println("Número Comensales: " + mesaAEditar.getNumComensales());
            System.out.println("Reserva: " + mesaAEditar.getReserva());
            System.out.println("--------------------------------------" + Colores.blanco);


        }catch(Exception e){

            System.out.println(Colores.rojo + "Error al editar la mesa" + Colores.blanco);

        }

    }

    public static void editarProducto(){

        int idProducto = 0;
        String denominacion = "";
        double precio = 0;
        String editar = "";
        ENTProducto productoAEditar;

        try{

            Consultas.listarTodosLosProductos();

            System.out.println("Introduce el id del producto a editar");
            idProducto = Principal.sc.nextInt();
            Principal.sc.nextLine();

            productoAEditar = Consultas.obtenerUnProductoPorID(idProducto);
            System.out.println(Colores.amarillo + "ID: " + productoAEditar.getIdProducto());
            System.out.println("Denominación: " + productoAEditar.getDenominacion());
            System.out.println("Precio: " + productoAEditar.getPrecio());
            System.out.println("--------------------------------------" + Colores.blanco);

            System.out.println(Colores.azul + "Quiere editar la denominación del producto?(Si/No)" + Colores.blanco);
            editar = Principal.sc.nextLine();

            if(editar.equalsIgnoreCase("Si")){

                System.out.println("Introduce la nueva denominación del producto");
                denominacion = Principal.sc.nextLine();

            } else {

                System.out.println(Colores.naranja + "No se editará la denominación del producto" + Colores.blanco);
                denominacion = productoAEditar.getDenominacion();

            }

            System.out.println(Colores.azul + "Quiere editar el precio del producto?(Si/No)" + Colores.blanco);
            editar = Principal.sc.nextLine();

            if(editar.equalsIgnoreCase("Si")){

                System.out.println("Introduce el nuevo precio del producto");
                precio = Principal.sc.nextDouble();

            } else {

                System.out.println(Colores.naranja + "No se editará el precio del producto" + Colores.blanco);
                precio = productoAEditar.getPrecio();

            }

            ENTProducto producto = new ENTProducto(denominacion, precio);
            Editar.actualizarProducto(idProducto, producto);

            productoAEditar = Consultas.obtenerUnProductoPorID(idProducto);
            System.out.println(Colores.verde + "Producto Editado");
            System.out.println("ID: " + productoAEditar.getIdProducto());
            System.out.println("Denominación: " + productoAEditar.getDenominacion());
            System.out.println("Precio: " + productoAEditar.getPrecio());
            System.out.println("--------------------------------------" + Colores.blanco);


        }catch(Exception e){

            System.out.println(Colores.rojo + "Error al editar el producto" + Colores.blanco);

        }

    }

    public static void editarFactura(){

        int idFactura = 0;
        double importe = 0;
        String tipoPago = "";
        ENTMesa mesaFacftura;
        int idMesa = 0;
        String editar = "";
        ENTFactura facturaAEditar;

        try{

            Consultas.listarTodasLasFacturas();

            System.out.println("Introduce el id de la factura a editar");
            idFactura = Principal.sc.nextInt();
            Principal.sc.nextLine();

            facturaAEditar = Consultas.obtenerUnaFacturaPorID(idFactura);
            System.out.println(Colores.amarillo + "ID: " + facturaAEditar.getIdFactura());
            System.out.println("ID Mesa Asocida: " + facturaAEditar.getIdMesa());
            System.out.println("Tipo de Pago: " + facturaAEditar.getTipoPago());
            System.out.println("Importe: " + facturaAEditar.getImporte());
            System.out.println("--------------------------------------" + Colores.blanco);

            System.out.println(Colores.azul + "Quiere editar el importe de la factura?(Si/No)" + Colores.blanco);
            editar = Principal.sc.nextLine();

            if(editar.equalsIgnoreCase("Si")){

                System.out.println("Introduce el nuevo importe de la factura");
                importe = Principal.sc.nextDouble();
                Principal.sc.nextLine();

            } else {

                System.out.println(Colores.naranja + "No se editará el importe de la factura" + Colores.blanco);
                importe = facturaAEditar.getImporte();

            }

            System.out.println(Colores.azul + "Quiere editar el tipo de pago de la factura?(Si/No)" + Colores.blanco);
            editar = Principal.sc.nextLine();

            if(editar.equalsIgnoreCase("Si")){

                System.out.println("Introduce el nuevo tipo de pago de la factura");
                tipoPago = Principal.sc.nextLine();

            } else {

                System.out.println(Colores.naranja + "No se editará el tipo de pago de la factura" + Colores.blanco);
                tipoPago = facturaAEditar.getTipoPago();

            }

            System.out.println(Colores.azul + "Quiere editar la mesa asociada a la factura?(Si/No)" + Colores.blanco);
            editar = Principal.sc.nextLine();

            if(editar.equalsIgnoreCase("Si")){

                System.out.println("Introduce el id de la mesa asociada a la factura");
                idMesa = Principal.sc.nextInt();

            } else {

                System.out.println(Colores.naranja + "No se editará la mesa asociada a la factura" + Colores.blanco);
                idMesa = facturaAEditar.getIdMesa();

            }

            mesaFacftura = Consultas.obtenerUnaMesaPorID(idMesa);

            ENTFactura factura = new ENTFactura(mesaFacftura, tipoPago, importe);
            Editar.actualizarFactura(idFactura, factura);

            facturaAEditar = Consultas.obtenerUnaFacturaPorID(idFactura);
            System.out.println(Colores.verde + "Factura Editada");
            System.out.println("ID: " + facturaAEditar.getIdFactura());
            System.out.println("ID Mesa Asocida: " + facturaAEditar.getIdMesa());
            System.out.println("Tipo de Pago: " + facturaAEditar.getTipoPago());
            System.out.println("Importe: " + facturaAEditar.getImporte());
            System.out.println("--------------------------------------" + Colores.blanco);

        }catch(Exception e){

            e.printStackTrace();
            System.out.println(Colores.rojo + "Error al editar la factura" + Colores.blanco);

        }

    }

    public static void editarPedido(){

        int idPedido = 0;
        int cantidad = 0;
        ENTProducto productoPedido;
        int idProducto = 0;
        ENTFactura facturaPedido;
        int idFactura = 0;
        String editar = "";
        ENTPedido pedidoAEditar;

        try{

            Consultas.listarTodosLosPedidos();

            System.out.println("Introduce el id del pedido a editar");
            idPedido = Principal.sc.nextInt();
            Principal.sc.nextLine();

            pedidoAEditar = Consultas.obtenerUnPedidoPorID(idPedido);

            System.out.println(Colores.amarillo + "ID: " + pedidoAEditar.getIdPedido());
            System.out.println("ID Factura Asocida: " + pedidoAEditar.getIdFactura());
            System.out.println("ID Producto Asocido: " + pedidoAEditar.getIdProducto());
            System.out.println("Cantidad: " + pedidoAEditar.getCantidad());
            System.out.println("--------------------------------------" + Colores.blanco);

            System.out.println(Colores.azul + "Quiere editar la cantidad del pedido?(Si/No)" + Colores.blanco);
            editar = Principal.sc.nextLine();

            if(editar.equalsIgnoreCase("Si")){

                System.out.println("Introduce la nueva cantidad del pedido");
                cantidad = Principal.sc.nextInt();
                Principal.sc.nextLine();

            } else {

                System.out.println(Colores.naranja + "No se editará la cantidad del pedido" + Colores.blanco);
                cantidad = pedidoAEditar.getCantidad();

            }

            System.out.println(Colores.azul +"Quiere editar el producto asociado al pedido?(Si/No)" + Colores.blanco);
            editar = Principal.sc.nextLine();

            if(editar.equalsIgnoreCase("Si")){

                System.out.println("Introduce el id del producto asociado al pedido");
                idProducto = Principal.sc.nextInt();
                Principal.sc.nextLine();

            } else {

                System.out.println(Colores.naranja + "No se editará el producto asociado al pedido" + Colores.blanco);
                idProducto = pedidoAEditar.getIdProducto();

            }

            System.out.println(Colores.azul + "Quiere editar la factura asociada al pedido?(Si/No)" + Colores.blanco);
            editar = Principal.sc.nextLine();

            if(editar.equalsIgnoreCase("Si")){

                System.out.println("Introduce el id de la factura asociada al pedido");
                idFactura = Principal.sc.nextInt();

            } else {

                System.out.println(Colores.naranja + "No se editará la factura asociada al pedido" + Colores.blanco);
                idFactura = pedidoAEditar.getIdFactura();

            }

            productoPedido = Consultas.obtenerUnProductoPorID(idProducto);
            facturaPedido = Consultas.obtenerUnaFacturaPorID(idFactura);

            ENTPedido pedido = new ENTPedido(facturaPedido, productoPedido, cantidad);
            Editar.actualizarPedido(idPedido, pedido);

            pedidoAEditar = Consultas.obtenerUnPedidoPorID(idPedido);
            System.out.println(Colores.verde + "Pedido Editado");
            System.out.println("ID: " + pedidoAEditar.getIdPedido());
            System.out.println("ID Factura Asocida: " + pedidoAEditar.getIdFactura());
            System.out.println("ID Producto Asocido: " + pedidoAEditar.getIdProducto());
            System.out.println("Cantidad: " + pedidoAEditar.getCantidad());
            System.out.println("--------------------------------------" + Colores.blanco);


        }catch(Exception e){

            System.out.println(Colores.rojo + "Error al editar el pedido" + Colores.blanco);

        }

    }

}
