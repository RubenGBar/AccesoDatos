package clasesManipulacion;

import Colores.Colores;
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

    public static void menuAgregar() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|    Agregar   |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1." + Colores.blanco + "Agregar Mesa");
        System.out.println(Colores.amarillo + "2." + Colores.blanco + "Agregar Producto");
        System.out.println(Colores.amarillo + "3." + Colores.blanco + "Agregar Factura");
        System.out.println(Colores.amarillo + "4." + Colores.blanco + "Agregar Pedido");
        System.out.println(Colores.rojo + "0." + Colores.blanco + "Salir");
    }

    public static void agregar() throws Exception {

        int opc = -1;
        int numComensales = 0;
        int reserva = 0;
        int idProducto = 0;
        int idFactura = 0;
        int cantidad = 0;
        int idMesa = 0;
        double precio = 0;
        double importe = 0;
        String nombre = "";
        String tipoPago = "";
        ENTMesa mesa;
        ENTPedido pedido;
        ENTFactura factura;
        ENTProducto producto;

        do{

            menuAgregar();
            System.out.println("Elija una opción");
            opc = Principal.sc.nextInt();

            switch (opc){

                case 1 ->{

                    System.out.println("Introduzca el número de comensales de la mesa");
                    numComensales = Principal.sc.nextInt();
                    System.out.println("Introduzca si tiene resrva (1 Sí 0 No)");
                    reserva = Principal.sc.nextInt();
                    mesa = new ENTMesa(numComensales, reserva);

                    try {
                        agregarMesa(mesa);
                    } catch (Exception e) {
                        System.out.println("Error al crear la mesa");
                    }
                }

                case 2 ->{

                    System.out.println("Introduzca el nombre del producto");
                    nombre = Principal.sc.next();
                    System.out.println("Introduzca el precio del producto");
                    precio = Principal.sc.nextDouble();

                    producto = new ENTProducto(nombre, precio);

                    try {
                        agregarProductos(producto);
                    } catch (Exception e) {
                        System.out.println("Error al crear el producto");
                    }
                }

                case 3 ->{

                    System.out.println("Introduzca el id de la mesa asociada a la factura");
                    idMesa = Principal.sc.nextInt();
                    System.out.println("Introduzca el importe de la factura");
                    importe = Principal.sc.nextDouble();
                    System.out.println("Introduzca el tipo de pago");
                    tipoPago = Principal.sc.next();

                    mesa = Consultas.obtenerUnaMesaPorID(idMesa);
                    factura = new ENTFactura(mesa, tipoPago, importe);

                    try {
                        agregarFacturas(factura);
                    } catch (Exception e) {
                        System.out.println("Error al crear la factura");
                    }
                }

                case 4 ->{

                    System.out.println("Introduzca el id del producto asociado al pedido");
                    idProducto = Principal.sc.nextInt();
                    System.out.println("Introduzca el id de la factura asociada al pedido");
                    idFactura = Principal.sc.nextInt();
                    System.out.println("Introduzca la cantidad del pedido");
                    cantidad = Principal.sc.nextInt();

                    producto = Consultas.obtenerUnProductoPorID(idProducto);
                    factura = Consultas.obtenerUnaFacturaPorID(idFactura);

                    pedido = new ENTPedido(factura, producto, cantidad);

                    try {
                        agregarPedidos(pedido);
                    } catch (Exception e) {
                        System.out.println("Error al crear el pedido");
                    }
                }

            }

        }while(opc != 0);

    }

}
