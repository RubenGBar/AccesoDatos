package clasesManipulacion;

import Colores.Colores;
import Entidades.ENTFactura;
import Entidades.ENTMesa;
import Entidades.ENTPedido;
import Entidades.ENTProducto;

import java.util.List;

public class Consultas {

    public static Accesobd instancia = new Accesobd();

    public static void listarTodasLasMesas() throws Exception {
        instancia.abrir();
        List<ENTMesa> mesas = Accesobd.sesion.createQuery("From ENTMesa", ENTMesa.class).list();
        for (ENTMesa mesa : mesas) {
            System.out.println("ID: " + mesa.getIdMesa());
            System.out.println("Número Comensales: " + mesa.getNumComensales());
            System.out.println("Reserva: " + mesa.getReserva());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static ENTMesa obtenerUnaMesaPorID(int id) throws Exception {
        instancia.abrir();
        ENTMesa mesa = Accesobd.sesion.get(ENTMesa.class, id);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
        return mesa;
    }

    public static void listarMesasPorNumeroComensales(int numComensales) throws Exception {
        instancia.abrir();
        List<ENTMesa> mesas = Accesobd.sesion.createQuery("From ENTMesa Where numComensales = numComensales", ENTMesa.class).list();
        for (ENTMesa mesa : mesas) {
            System.out.println("ID: " + mesa.getIdMesa());
            System.out.println("Número Comensales: " + mesa.getNumComensales());
            System.out.println("Reserva: " + mesa.getReserva());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void listarMesasPorReserva(int reserva) throws Exception {
        instancia.abrir();
        List<ENTMesa> mesas = Accesobd.sesion.createQuery("From ENTMesa Where reserva = reserva", ENTMesa.class).list();
        for (ENTMesa mesa : mesas) {
            System.out.println("ID: " + mesa.getIdMesa());
            System.out.println("Número Comensales: " + mesa.getNumComensales());
            System.out.println("Reserva: " + mesa.getReserva());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void listarTodosLosProductos() throws Exception {
        instancia.abrir();
        List<ENTProducto> productos = Accesobd.sesion.createQuery("From ENTProducto ", ENTProducto.class).list();
        for (ENTProducto producto : productos) {
            System.out.println("ID: " + producto.getIdProducto());
            System.out.println("Denominación: " + producto.getDenominacion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static ENTProducto obtenerUnProductoPorID(int id) throws Exception {
        instancia.abrir();
        ENTProducto producto = Accesobd.sesion.get(ENTProducto.class, id);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
        return producto;
    }

    public static void listarProductosPorDenominacion(String denominacion) throws Exception {
        instancia.abrir();
        List<ENTProducto> productos = Accesobd.sesion.createQuery("From ENTProducto where denominacion = denominacion", ENTProducto.class).list();
        for (ENTProducto producto : productos) {
            System.out.println("ID: " + producto.getIdProducto());
            System.out.println("Denominación: " + producto.getDenominacion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void listarProductosPorDenominacion(double precio) throws Exception {
        instancia.abrir();
        List<ENTProducto> productos = Accesobd.sesion.createQuery("From ENTProducto where precio = precio", ENTProducto.class).list();
        for (ENTProducto producto : productos) {
            System.out.println("ID: " + producto.getIdProducto());
            System.out.println("Denominación: " + producto.getDenominacion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void listarTodasLasFacturas() throws Exception {
        instancia.abrir();
        List<ENTFactura> facturas = Accesobd.sesion.createQuery("From ENTFactura ", ENTFactura.class).list();
        for (ENTFactura factura : facturas) {
            System.out.println("ID: " + factura.getIdFactura());
            System.out.println("ID Mesa Asocida: " + factura.getIdMesa());
            System.out.println("Tipo de Pago: " + factura.getTipoPago());
            System.out.println("Importe: " + factura.getImporte());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static ENTFactura obtenerUnaFacturaPorID(int id) throws Exception {
        instancia.abrir();
        ENTFactura factura = Accesobd.sesion.get(ENTFactura.class, id);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
        return factura;
    }

    public static void listarFacturasPorIDMesa(int idMesa) throws Exception {
        instancia.abrir();
        List<ENTFactura> facturas = Accesobd.sesion.createNativeQuery("SELECT * FROM Facturas WHERE idMesa = ?", ENTFactura.class).setParameter(1, idMesa).getResultList();
        for (ENTFactura factura : facturas) {
            System.out.println("ID: " + factura.getIdFactura());
            System.out.println("ID Mesa Asocida: " + factura.getIdMesa());
            System.out.println("Tipo de Pago: " + factura.getTipoPago());
            System.out.println("Importe: " + factura.getImporte());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void listarFacturasPorTipoPago(String tipoPago) throws Exception {
        instancia.abrir();
        List<ENTFactura> facturas = Accesobd.sesion.createQuery("From ENTFactura where tipoPago = tipoPago", ENTFactura.class).getResultList();
        for (ENTFactura factura : facturas) {
            System.out.println("ID: " + factura.getIdFactura());
            System.out.println("ID Mesa Asocida: " + factura.getIdMesa());
            System.out.println("Tipo de Pago: " + factura.getTipoPago());
            System.out.println("Importe: " + factura.getImporte());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void listarFacturasPorTipoPago(double importe) throws Exception {
        instancia.abrir();
        List<ENTFactura> facturas = Accesobd.sesion.createQuery("From ENTFactura where importe = importe", ENTFactura.class).getResultList();
        for (ENTFactura factura : facturas) {
            System.out.println("ID: " + factura.getIdFactura());
            System.out.println("ID Mesa Asocida: " + factura.getIdMesa());
            System.out.println("Tipo de Pago: " + factura.getTipoPago());
            System.out.println("Importe: " + factura.getImporte());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void listarTodosLosPedidos() throws Exception {
        instancia.abrir();
        List<ENTPedido> pedidos = Accesobd.sesion.createQuery("From ENTPedido ", ENTPedido.class).list();
        for (ENTPedido pedido : pedidos) {
            System.out.println("ID: " + pedido.getIdPedido());
            System.out.println("ID Factura Asocida: " + pedido.getIdFactura());
            System.out.println("ID Producto Asocido: " + pedido.getIdProducto());
            System.out.println("Cantidad: " + pedido.getCantidad());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static ENTPedido obtenerUnPedidoPorID(int id) throws Exception {
        instancia.abrir();
        ENTPedido pedido = Accesobd.sesion.get(ENTPedido.class, id);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
        return pedido;
    }

    public static void listarPedidosPorIDFactura(int idFactura) throws Exception {
        instancia.abrir();
        List<ENTPedido> pedidos = Accesobd.sesion.createNativeQuery("SELECT * FROM Pedidos WHERE idFactura = ?", ENTPedido.class).setParameter(1, idFactura).getResultList();
        for (ENTPedido pedido : pedidos) {
            System.out.println("ID: " + pedido.getIdPedido());
            System.out.println("ID Factura Asocida: " + pedido.getIdFactura());
            System.out.println("ID Producto Asocido: " + pedido.getIdProducto());
            System.out.println("Cantidad: " + pedido.getCantidad());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void listarPedidosPorIDProducto(int idProducto) throws Exception {
        instancia.abrir();
        List<ENTPedido> pedidos = Accesobd.sesion.createNativeQuery("SELECT * FROM Pedidos WHERE idProducto = ?", ENTPedido.class).setParameter(1, idProducto).getResultList();
        for (ENTPedido pedido : pedidos) {
            System.out.println("ID: " + pedido.getIdPedido());
            System.out.println("ID Factura Asocida: " + pedido.getIdFactura());
            System.out.println("ID Producto Asocido: " + pedido.getIdProducto());
            System.out.println("Cantidad: " + pedido.getCantidad());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void listarPedidosPorCantidad(int cantidad) throws Exception {
        instancia.abrir();
        List<ENTPedido> pedidos = Accesobd.sesion.createQuery("From ENTPedido where cantidad = cantidad", ENTPedido.class).list();
        for (ENTPedido pedido : pedidos) {
            System.out.println("ID: " + pedido.getIdPedido());
            System.out.println("ID Factura Asocida: " + pedido.getIdFactura());
            System.out.println("ID Producto Asocido: " + pedido.getIdProducto());
            System.out.println("Cantidad: " + pedido.getCantidad());
            System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
        }
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void menuListarMesa() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|     Mesa     |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Listar Todas las Mesas");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Listar Mesa por ID");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Listar Mesa por Número de Comensales");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Listar Mesa por Reserva");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir Menú Listar Mesa");
    }

    public static void listarMesa(){
        int opc = -1;

        do{

            menuListarMesa();
            System.out.println("Elija una opción");
            opc = Principal.sc.nextInt();

            switch(opc) {

                case 1 ->{
                    try {
                        listarTodasLasMesas();
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar las mesas" + Colores.blanco);
                    }
                }

                case 2 ->{
                    System.out.println("Introduzca el ID de la mesa a buscar: ");
                    int id = Principal.sc.nextInt();
                    try {
                        ENTMesa mesa = obtenerUnaMesaPorID(id);
                        System.out.println("ID: " + mesa.getIdMesa());
                        System.out.println("Número Comensales: " + mesa.getNumComensales());
                        System.out.println("Reserva: " + mesa.getReserva());
                        System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar la mesa" + Colores.blanco);
                    }
                }

                case 3 ->{
                    System.out.println("Introduzca el número de comensales de la mesa a buscar: ");
                    int numComensales = Principal.sc.nextInt();
                    try {
                        listarMesasPorNumeroComensales(numComensales);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar las mesas" + Colores.blanco);
                    }
                }

                case 4 ->{
                    System.out.println("Introduzca la reserva de la mesa a buscar: ");
                    int reserva = Principal.sc.nextInt();
                    try {
                        listarMesasPorReserva(reserva);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar las mesas" + Colores.blanco);
                    }
                }

                case 0 ->{
                    System.out.println("Saliendo del menú Listar Mesas");
                }

                default ->{
                    System.out.println(Colores.rojo + "Opción no válida" + Colores.blanco);
                }

            }

        }while (opc != 0);

    }

    public static void menuListarProducto() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|   Producto   |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Listar Todos los Productos");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Listar Producto por ID");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Listar Producto por Denominación");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Listar Producto por Precio");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir Menú Listar Producto");
    }

    public static void listarProducto(){
        int opc = -1;

        do{

            menuListarProducto();
            System.out.println("Elija una opción");
            opc = Principal.sc.nextInt();

            switch(opc) {

                case 1 ->{
                    try {
                        listarTodosLosProductos();
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar los productos" + Colores.blanco);
                    }
                }

                case 2 ->{
                    System.out.println("Introduzca el ID del producto a buscar: ");
                    int id = Principal.sc.nextInt();
                    try {
                        ENTProducto producto = obtenerUnProductoPorID(id);
                        System.out.println("ID: " + producto.getIdProducto());
                        System.out.println("Denominación: " + producto.getDenominacion());
                        System.out.println("Precio: " + producto.getPrecio());
                        System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar el producto" + Colores.blanco);
                    }
                }

                case 3 ->{
                    System.out.println("Introduzca la denominación del producto a buscar: ");
                    String denominacion = Principal.sc.next();
                    try {
                        listarProductosPorDenominacion(denominacion);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar los productos" + Colores.blanco);
                    }
                }

                case 4 ->{
                    System.out.println("Introduzca el precio del producto a buscar: ");
                    double precio = Principal.sc.nextDouble();
                    try {
                        listarProductosPorDenominacion(precio);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar los productos" + Colores.blanco);
                    }
                }

                case 0 ->{
                    System.out.println("Saliendo del menú Listar Productos");
                }

                default ->{
                    System.out.println(Colores.rojo + "Opción no válida" + Colores.blanco);
                }

            }

        }while (opc != 0);

    }

    public static void menuListarFactura(){
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|   Factura    |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Listar Todas las Facturas");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Listar Factura por ID");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Listar Factura por ID Mesa");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Listar Factura por Tipo de Pago");
        System.out.println(Colores.amarillo + "5. " + Colores.blanco + "Listar Factura por Importe");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir Menú Listar Factura");
    }

    public static void listarFactura(){
        int opc = -1;

        do{

            menuListarFactura();
            System.out.println("Elija una opción");
            opc = Principal.sc.nextInt();

            switch(opc) {

                case 1 ->{
                    try {
                        listarTodasLasFacturas();
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar las facturas" + Colores.blanco);
                    }
                }

                case 2 ->{
                    System.out.println("Introduzca el ID de la factura a buscar: ");
                    int id = Principal.sc.nextInt();
                    try {
                        ENTFactura factura = obtenerUnaFacturaPorID(id);
                        System.out.println("ID: " + factura.getIdFactura());
                        System.out.println("ID Mesa Asocida: " + factura.getIdMesa());
                        System.out.println("Tipo de Pago: " + factura.getTipoPago());
                        System.out.println("Importe: " + factura.getImporte());
                        System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar la factura" + Colores.blanco);
                    }
                }

                case 3 ->{
                    System.out.println("Introduzca el ID de la mesa de la factura a buscar: ");
                    int idMesa = Principal.sc.nextInt();

                    try {
                        listarFacturasPorIDMesa(idMesa);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar las facturas" + Colores.blanco);
                    }
                }

                case 4 ->{
                    System.out.println("Introduzca el tipo de pago de la factura a buscar: ");
                    String tipoPago = Principal.sc.next();
                    try {
                        listarFacturasPorTipoPago(tipoPago);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar las facturas" + Colores.blanco);
                    }
                }

                case 5 ->{
                    System.out.println("Introduzca el importe de la factura a buscar: ");
                    double importe = Principal.sc.nextDouble();
                    try {
                        listarFacturasPorTipoPago(importe);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar las facturas" + Colores.blanco);
                    }
                }

                case 0 ->{
                    System.out.println("Saliendo del menú Listar Facturas");
                }

                default ->{
                    System.out.println(Colores.rojo + "Opción no válida" + Colores.blanco);
                }

            }

        }while (opc != 0);

    }

    public static void menuListarPedido()
    {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|    Pedido    |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Listar Todos los Pedidos");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Listar Pedido por ID");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Listar Pedido por ID Factura");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Listar Pedido por ID Producto");
        System.out.println(Colores.amarillo + "5. " + Colores.blanco + "Listar Pedido por Cantidad");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir Menú Listar Pedido");
    }

    public static void listarPedido(){
        int opc = -1;

        do{

            menuListarPedido();
            System.out.println("Elija una opción");
            opc = Principal.sc.nextInt();

            switch(opc) {

                case 1 ->{
                    try {
                        listarTodosLosPedidos();
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar los pedidos" + Colores.blanco);
                    }
                }

                case 2 ->{
                    System.out.println("Introduzca el ID del pedido a buscar: ");
                    int id = Principal.sc.nextInt();
                    try {
                        ENTPedido pedido = obtenerUnPedidoPorID(id);
                        System.out.println("ID: " + pedido.getIdPedido());
                        System.out.println("ID Factura Asocida: " + pedido.getIdFactura());
                        System.out.println("ID Producto Asocido: " + pedido.getIdProducto());
                        System.out.println("Cantidad: " + pedido.getCantidad());
                        System.out.println(Colores.azul + "--------------------------------------" + Colores.blanco);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar el pedido" + Colores.blanco);
                    }
                }

                case 3 ->{
                    System.out.println("Introduzca el ID de la factura del pedido a buscar: ");
                    int idFactura = Principal.sc.nextInt();
                    try {
                        listarPedidosPorIDFactura(idFactura);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar los pedidos" + Colores.blanco);
                    }
                }

                case 4 ->{
                    System.out.println("Introduzca el ID del producto del pedido a buscar: ");
                    int idProducto = Principal.sc.nextInt();
                    try {
                        listarPedidosPorIDProducto(idProducto);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar los pedidos" + Colores.blanco);
                    }
                }

                case 5 ->{
                    System.out.println("Introduzca la cantidad del pedido a buscar: ");
                    int cantidad = Principal.sc.nextInt();
                    try {
                        listarPedidosPorCantidad(cantidad);
                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al listar los pedidos" + Colores.blanco);
                    }
                }

                case 0 ->{
                    System.out.println("Saliendo del menú Listar Pedidos");
                }

                default ->{
                    System.out.println(Colores.rojo + "Opción no válida" + Colores.blanco);
                }

            }

        }while (opc != 0);

    }

}
