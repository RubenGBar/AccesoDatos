package clasesManipulacion;

import Colores.Colores;
import Entidades.ENTFactura;
import Entidades.ENTMesa;
import Entidades.ENTPedido;
import Entidades.ENTProducto;

public class Deletes {

    public static Accesobd instancia = new Accesobd();

    public static void borrarTodasLasMesas() throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Mesas", ENTMesa.class).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarMesaPorID(int id) throws Exception {
        instancia.abrir();
        ENTMesa mesa = Accesobd.sesion.get(ENTMesa.class, id);
        Accesobd.sesion.remove(mesa);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarMesasPorNumeroComensales(int numeroComensales) throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Mesas WHERE numComensales = ?", ENTMesa.class).setParameter(1, numeroComensales).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarMesasPorReserva(int reserva) throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Mesas WHERE reserva = ?", ENTMesa.class).setParameter(1, reserva).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarTodosLosProductos() throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Productos", ENTProducto.class).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarProductoPorID(int id) throws Exception {
        instancia.abrir();
        ENTProducto producto = Accesobd.sesion.get(ENTProducto.class, id);
        Accesobd.sesion.remove(producto);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarProductoPorDenominacion(String denominacion) throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Productos WHERE denominacion = ?", ENTProducto.class).setParameter(1, denominacion).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarProductoPorPrecio(double precio) throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Productos WHERE precio = ?", ENTProducto.class).setParameter(1, precio).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarTodasLasFacturas() throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Facturas", ENTFactura.class).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarFacturaPorID(int id) throws Exception {
        instancia.abrir();
        ENTFactura factura = Accesobd.sesion.get(ENTFactura.class, id);
        Accesobd.sesion.remove(factura);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarFacturasPorTipoPago(String tipoPago) throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Facturas where tipoPago = ?", ENTFactura.class).setParameter(1, tipoPago).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarFacturasPorImporte(double importe) throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Facturas where importe = ?", ENTFactura.class).setParameter(1, importe).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarFacturasPorIDMesa(ENTMesa mesa) throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Facturas where idMesa = ?", ENTFactura.class).setParameter(1, mesa.getIdMesa()).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarTodosLosPedidos() throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Pedidos", ENTPedido.class).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarPedidoPorID(int id) throws Exception {
        instancia.abrir();
        ENTPedido pedido = Accesobd.sesion.get(ENTPedido.class, id);
        Accesobd.sesion.remove(pedido);
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarLosPedidosPorCantidad(int cantidad) throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Pedidos where cantidad = ?", ENTPedido.class).setParameter(1, cantidad).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarLosPedidosPorIDFactura(ENTFactura factura) throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Pedidos where idFactura = ?", ENTPedido.class).setParameter(1, factura.getIdFactura()).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void borrarLosPedidosPorIDProducto(ENTProducto producto) throws Exception {
        instancia.abrir();
        Accesobd.sesion.createNativeQuery("DELETE FROM Pedidos where idProducto = ?", ENTPedido.class).setParameter(1, producto.getIdProducto()).executeUpdate();
        Accesobd.transaction.commit();
        Accesobd.sesion.close();
    }

    public static void menuBorrarMesa() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|     Mesa     |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Borrar Todas las Mesas");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Borrar Mesa por ID");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Borrar Mesa por Número de Comensales");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Borrar Mesa por Reserva");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir Menú Borrar Mesa");
    }

    public static void borrarMesa(){

        int opc = -1;
        int idMesa = 0;
        int numeroComensales = 0;
        int reserva = 0;
        String confirmacion = "";

        do{

            menuBorrarMesa();
            System.out.println("Elija una opción");
            opc = Principal.sc.nextInt();

            switch(opc) {

                case 1 ->{
                    try {

                        Principal.sc.nextLine();
                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar todas las mesas? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarTodasLasMesas();
                            System.out.println(Colores.verde + "Se han borrado todas las mesas" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado las mesas" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar las mesas" + Colores.blanco);
                    }
                }

                case 2 ->{
                    try {

                        Consultas.listarTodasLasMesas();
                        System.out.println("Introduzca el ID por el que borrar las mesas");
                        idMesa = Principal.sc.nextInt();
                        Principal.sc.nextLine();

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar las mesas? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarMesaPorID(idMesa);
                            System.out.println(Colores.verde + "Se han borrado las mesas" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado las mesas" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar las mesas" + Colores.blanco);
                    }
                }

                case 3 ->{
                    try {

                        Consultas.listarTodasLasMesas();
                        System.out.println("Introduzca el número de comensales por el que borrar las mesas");
                        numeroComensales = Principal.sc.nextInt();
                        Principal.sc.nextLine();

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar las mesas? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarMesasPorNumeroComensales(numeroComensales);
                            System.out.println(Colores.verde + "Se han borrado las mesas" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado las mesas" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar las mesas" + Colores.blanco);
                    }
                }

                case 4 ->{
                    try {

                        Consultas.listarTodasLasMesas();
                        System.out.println("Introduzca el estado de la reserva (1/2) por el que borrar las mesas");
                        reserva = Principal.sc.nextInt();
                        Principal.sc.nextLine();

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar las mesas? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarMesasPorReserva(reserva);
                            System.out.println(Colores.verde + "Se han borrado las mesas" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado las mesas" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar las mesas" + Colores.blanco);
                    }
                }

                case 0 ->{
                    System.out.println(Colores.magenta + "Saliendo del menú Listar Mesas" + Colores.blanco);
                }

                default ->{
                    System.out.println(Colores.rojo + "Opción no válida" + Colores.blanco);
                }

            }

        }while (opc != 0);

    }

    public static void menuBorrarProducto() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|   Producto   |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Borrar Todos los Productos");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Borrar Producto por ID");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Borrar Producto por Denominación");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Borrar Producto por Precio");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir Menú Borrar Producto");
    }

    public static void borrarProducto(){

        int opc = -1;
        int idProducto = 0;
        String denominacion = "";
        double precio = 0;
        String confirmacion = "";

        do{

            menuBorrarProducto();
            System.out.println("Elija una opción");
            opc = Principal.sc.nextInt();

            switch(opc) {

                case 1 ->{
                    try {

                        Principal.sc.nextLine();
                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar todos los productos? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarTodosLosProductos();
                            System.out.println(Colores.verde + "Se han borrado todos los productos" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado los productos" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar los productos" + Colores.blanco);
                    }
                }

                case 2 ->{
                    try {

                        Consultas.listarTodosLosProductos();
                        System.out.println("Introduzca el ID por el que borrar los productos");
                        idProducto = Principal.sc.nextInt();
                        Principal.sc.nextLine();

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar los productos? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarProductoPorID(idProducto);
                            System.out.println(Colores.verde + "Se han borrado los productos" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado los productos" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar los productos" + Colores.blanco);
                    }
                }

                case 3 ->{
                    try {

                        Principal.sc.nextLine();
                        Consultas.listarTodosLosProductos();
                        System.out.println("Introduzca la denominacion por la que borrar los productos");
                        denominacion = Principal.sc.nextLine();

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar los productos? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarProductoPorDenominacion(denominacion);
                            System.out.println(Colores.verde + "Se han borrado los productos" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado los productos" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar los productos" + Colores.blanco);
                    }
                }

                case 4 ->{
                    try {

                        Consultas.listarTodosLosProductos();
                        System.out.println("Introduzca el precio por el que borrar los productos");
                        precio = Principal.sc.nextDouble();
                        Principal.sc.nextLine();

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar los productos? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarProductoPorPrecio(precio);
                            System.out.println(Colores.verde + "Se han borrado los productos" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado los productos" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar los productos" + Colores.blanco);
                    }
                }

                case 0 ->{
                    System.out.println(Colores.magenta + "Saliendo del menú Borrar Productos" + Colores.blanco);
                }

                default ->{
                    System.out.println(Colores.rojo + "Opción no válida" + Colores.blanco);
                }

            }

        }while (opc != 0);

    }

    public static void menuBorrarFactura() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|    Factura   |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Borrar Todas las Facturas");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Borrar Factura por ID");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Borrar Factura por ID de Mesa Asociada");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Borrar Factura por Tipo de Pago");
        System.out.println(Colores.amarillo + "5. " + Colores.blanco + "Borrar Factura por Importe");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir Menú Borrar Factura");
    }

    public static void borrarFactura(){

        int opc = -1;
        int idFactura = 0;
        int idMesa = 0;
        ENTMesa mesaAsociada;
        String tipoPago = "";
        double importe = 0;
        String confirmacion = "";

        do{

            menuBorrarFactura();
            System.out.println("Elija una opción");
            opc = Principal.sc.nextInt();

            switch(opc) {

                case 1 ->{
                    try {

                        Principal.sc.nextLine();
                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar todas las facturas? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarTodasLasFacturas();
                            System.out.println(Colores.verde + "Se han borrado todas las facturas" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado las facturas" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar las facturas" + Colores.blanco);
                    }
                }

                case 2 ->{
                    try {

                        Consultas.listarTodasLasFacturas();
                        System.out.println("Introduzca el ID por el que borrar las facturas");
                        idFactura = Principal.sc.nextInt();
                        Principal.sc.nextLine();

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar las facturas? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarFacturaPorID(idFactura);
                            System.out.println(Colores.verde + "Se han borrado las facturas" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado las facturas" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar las facturas" + Colores.blanco);
                    }
                }

                case 3 ->{
                    try {

                        Consultas.listarTodasLasFacturas();
                        System.out.println("Introduzca el ID de la mesa asociada por la que borrar las facturas");
                        idMesa = Principal.sc.nextInt();
                        Principal.sc.nextLine();

                        mesaAsociada = Consultas.obtenerUnaMesaPorID(idMesa);

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar las facturas? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarFacturasPorIDMesa(mesaAsociada);
                            System.out.println(Colores.verde + "Se han borrado las facturas" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado las facturas" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar las facturas" + Colores.blanco);
                    }
                }

                case 4 ->{
                    try {

                        Consultas.listarTodasLasFacturas();
                        Principal.sc.nextLine();
                        System.out.println("Introduzca el tipo de pago por el que borrar las facturas");
                        tipoPago = Principal.sc.nextLine();

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar las facturas? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarFacturasPorTipoPago(tipoPago);
                            System.out.println(Colores.verde + "Se han borrado las facturas" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado las facturas" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar las facturas" + Colores.blanco);
                    }
                }

                case 5 ->{
                    try {

                        Consultas.listarTodasLasFacturas();
                        System.out.println("Introduzca el importe por el que borrar las facturas");
                        importe = Principal.sc.nextDouble();
                        Principal.sc.nextLine();

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar las facturas? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarFacturasPorImporte(importe);
                            System.out.println(Colores.verde + "Se han borrado las facturas" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado las facturas" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar las facturas" + Colores.blanco);
                    }
                }

                case 0 ->{
                    System.out.println(Colores.magenta + "Saliendo del menú Borrar Facturas" + Colores.blanco);
                }

                default ->{
                    System.out.println(Colores.rojo + "Opción no válida" + Colores.blanco);
                }

            }

        }while (opc != 0);

    }

    public static void menuBorrarPedido() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|    Pedido    |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Borrar Todos los Pedidos");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Borrar Pedidos por ID");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Borrar Pedidos por ID de Factura Asociada");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Borrar Pedidos por ID de Producto Asociado");
        System.out.println(Colores.amarillo + "5. " + Colores.blanco + "Borrar Pedidos por Cantidad");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir Menú Borrar Pedido");
    }

    public static void borrarPedido(){

        int opc = -1;
        int idPedido = 0;
        int idFactura = 0;
        int idProducto = 0;
        ENTProducto productoAsociado;
        ENTFactura facturaAsociada;
        int cantidad = 0;
        String confirmacion = "";

        do{

            menuBorrarPedido();
            System.out.println("Elija una opción");
            opc = Principal.sc.nextInt();

            switch(opc) {

                case 1 ->{
                    try {

                        Principal.sc.nextLine();
                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar todos los pedidos? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarTodosLosPedidos();
                            System.out.println(Colores.verde + "Se han borrado todos los pedidos" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado los pedidos" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar los pedidos" + Colores.blanco);
                    }
                }

                case 2 ->{
                    try {

                        Consultas.listarTodosLosPedidos();
                        System.out.println("Introduzca el ID por el que borrar los pedidos");
                        idPedido = Principal.sc.nextInt();
                        Principal.sc.nextLine();

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar los pedidos? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarPedidoPorID(idPedido);
                            System.out.println(Colores.verde + "Se han borrado los pedidos" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado los pedidos" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar los pedidos" + Colores.blanco);
                    }
                }

                case 3 ->{
                    try {

                        Consultas.listarTodosLosPedidos();
                        System.out.println("Introduzca el ID de la factura asociada por la que borrar los pedidos");
                        idFactura = Principal.sc.nextInt();
                        Principal.sc.nextLine();

                        facturaAsociada = Consultas.obtenerUnaFacturaPorID(idFactura);

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar los pedidos? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarLosPedidosPorIDFactura(facturaAsociada);
                            System.out.println(Colores.verde + "Se han borrado los pedidos" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado los pedidos" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar los pedidos" + Colores.blanco);
                    }
                }

                case 4 ->{
                    try {

                        Consultas.listarTodosLosPedidos();
                        System.out.println("Introduzca el ID de Producto asociado por el que borrar los pedidos");
                        idProducto = Principal.sc.nextInt();
                        Principal.sc.nextLine();

                        productoAsociado = Consultas.obtenerUnProductoPorID(idProducto);

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar los pedidos? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarLosPedidosPorIDProducto(productoAsociado);
                            System.out.println(Colores.verde + "Se han borrado los pedidos" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado los pedidos" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(Colores.rojo + "Error al borrar los pedidos" + Colores.blanco);
                    }
                }

                case 5 ->{
                    try {

                        Consultas.listarTodosLosPedidos();
                        System.out.println("Introduzca la cantidad por la que borrar los pedidos");
                        cantidad = Principal.sc.nextInt();
                        Principal.sc.nextLine();

                        System.out.println(Colores.azul + "¿Está seguro de que desea borrar los pedidos? (Si/No)" + Colores.blanco);
                        confirmacion = Principal.sc.nextLine();

                        if(confirmacion.equalsIgnoreCase("Si")){
                            borrarLosPedidosPorCantidad(cantidad);
                            System.out.println(Colores.verde + "Se han borrado los pedidos" + Colores.blanco);
                        } else {
                            System.out.println(Colores.naranja + "No se han borrado los pedidos" + Colores.blanco);
                        }

                    } catch (Exception e) {
                        System.out.println(Colores.rojo + "Error al borrar los pedidos" + Colores.blanco);
                    }
                }

                case 0 ->{
                    System.out.println(Colores.magenta + "Saliendo del menú Borrar Pedidos" + Colores.blanco);
                }

                default ->{
                    System.out.println(Colores.rojo + "Opción no válida" + Colores.blanco);
                }

            }

        }while (opc != 0);

    }

}
