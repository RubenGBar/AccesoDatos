package clasesManipulacion;

import Colores.Colores;
import Entidades.ENTFactura;
import Entidades.ENTMesa;
import Entidades.ENTPedido;
import Entidades.ENTProducto;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static Scanner sc = new Scanner(System.in);

    public static void menu() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|     Menú     |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Insertar Datos");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Listar Datos");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Editar Datos");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Borrar Datos");
        System.out.println(Colores.amarillo + "5. " + Colores.blanco + "Borrar Tablas");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir");
    }

    public static void main(String[] args) throws Exception {

        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        int opc = -1;

        do {

            menu();
            System.out.println("Elija una opción");
            opc = sc.nextInt();

            switch(opc) {

                case 1 ->{

                    agregar();

                }

                case 2 ->{

                    listar();

                }

                case 3 ->{

                    editar();

                }

                case 4 ->{

                    System.out.println("a");

                }

                case 5 ->{

                    System.out.println("e");

                }

                case 0 ->{

                    System.out.println("Saliendo del programa");

                }

                default ->{

                    System.out.println("Opción no válida");

                }

            }

        }while (opc != 0);

        sc.close();

    }

    public static void menuAgregar() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|    Agregar   |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Agregar Mesa");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Agregar Producto");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Agregar Factura");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Agregar Pedido");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir Menú Agregar");
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
            opc = sc.nextInt();

            switch (opc){

                case 1 ->{

                    System.out.println("Introduzca el número de comensales de la mesa");
                    numComensales = sc.nextInt();
                    System.out.println("Introduzca si tiene resrva (1 Sí 0 No)");
                    reserva = sc.nextInt();
                    mesa = new ENTMesa(numComensales, reserva);

                    try {
                        Agregar.agregarMesa(mesa);
                        System.out.println(Colores.verde + "Mesa añdida correctamente" + Colores.blanco);
                    } catch (Exception e) {
                        System.out.println("Error al crear la mesa");
                    }
                }

                case 2 ->{

                    System.out.println("Introduzca el nombre del producto");
                    nombre = sc.next();
                    System.out.println("Introduzca el precio del producto");
                    precio = sc.nextDouble();

                    producto = new ENTProducto(nombre, precio);

                    try {
                        Agregar.agregarProductos(producto);
                        System.out.println(Colores.verde + "Producto añdida correctamente" + Colores.blanco);
                    } catch (Exception e) {
                        System.out.println("Error al crear el producto");
                    }
                }

                case 3 ->{

                    System.out.println("Introduzca el id de la mesa asociada a la factura");
                    idMesa = sc.nextInt();
                    System.out.println("Introduzca el importe de la factura");
                    importe = sc.nextDouble();
                    System.out.println("Introduzca el tipo de pago");
                    tipoPago = sc.next();

                    mesa = Consultas.obtenerUnaMesaPorID(idMesa);
                    factura = new ENTFactura(mesa, tipoPago, importe);

                    try {
                        Agregar.agregarFacturas(factura);
                        System.out.println(Colores.verde + "Factura añdida correctamente" + Colores.blanco);
                    } catch (Exception e) {
                        System.out.println("Error al crear la factura");
                    }
                }

                case 4 ->{

                    System.out.println("Introduzca el id del producto asociado al pedido");
                    idProducto = sc.nextInt();
                    System.out.println("Introduzca el id de la factura asociada al pedido");
                    idFactura = sc.nextInt();
                    System.out.println("Introduzca la cantidad del pedido");
                    cantidad = sc.nextInt();

                    producto = Consultas.obtenerUnProductoPorID(idProducto);
                    factura = Consultas.obtenerUnaFacturaPorID(idFactura);

                    pedido = new ENTPedido(factura, producto, cantidad);

                    try {
                        Agregar.agregarPedidos(pedido);
                        System.out.println(Colores.verde + "Pedido añdida correctamente" + Colores.blanco);
                    } catch (Exception e) {
                        System.out.println("Error al crear el pedido");
                    }
                }

            }

        }while(opc != 0);

    }

    public static void menuListar() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|    Listar    |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Listar Mesa");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Listar Producto");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Listar Factura");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Listar Pedido");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir Menú Listar");
    }

    public static void listar(){

        int opc = -1;

        do {

            menuListar();
            System.out.println("Elija una opción");
            opc = sc.nextInt();

            switch (opc){

                case 1 ->{
                    Consultas.listarMesa();
                }

                case 2 ->{
                    Consultas.listarProducto();
                }

                case 3 ->{
                    Consultas.listarFactura();
                }

                case 4 ->{
                    Consultas.listarPedido();
                }

                case 0 ->{
                    System.out.println("Saliendo del menú listar");
                }

                default ->{
                    System.out.println("Opción no válida");
                }

            }

        }while (opc != 0);

    }

    public static void menuEditar() {
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.verde + "|    Editar    |");
        System.out.println(Colores.verde + " --------------");
        System.out.println(Colores.amarillo + "1. " + Colores.blanco + "Editar Mesa");
        System.out.println(Colores.amarillo + "2. " + Colores.blanco + "Editar Producto");
        System.out.println(Colores.amarillo + "3. " + Colores.blanco + "Editar Factura");
        System.out.println(Colores.amarillo + "4. " + Colores.blanco + "Editar Pedido");
        System.out.println(Colores.rojo + "0. " + Colores.blanco + "Salir Menú Editar");
    }

    public static void editar(){

        int opc = -1;

        do {

            menuEditar();
            System.out.println("Elija una opción");
            opc = sc.nextInt();

            switch (opc){

                case 1 ->{
                    Editar.editarMesa();
                }

                case 2 ->{
                    Editar.editarProducto();
                }

                case 3 ->{
                    Editar.editarFactura();
                }

                case 4 ->{
                    Editar.editarPedido();
                }

                case 0 ->{
                    System.out.println("Saliendo del Menú editar");
                }

                default ->{
                    System.out.println(Colores.rojo + "Opción no válida" + Colores.blanco);
                }

            }

        }while (opc != 0);

    }

}
