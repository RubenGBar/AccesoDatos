package actividad3_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD {
	
	static Connection conn = null;
	static Scanner sc = new Scanner(System.in);;
	
	public static void menu() {
		System.out.println(" --------------");
		System.out.println("|     Menú     |");
		System.out.println(" --------------");
		System.out.println("1. Crear Tablas");
		System.out.println("2. Insertar Datos");
		System.out.println("3. Listar Datos");
		System.out.println("4. Modificar Datos");
		System.out.println("5. Borrar Datos");
		System.out.println("6. Eliminar Tablas");
		System.out.println("0. Salir");
	}
	
	public static void main(String[] args) {
		
		int opc = 0;
		
		conectar();
		
		do {
			
			menu();
			System.out.println("Elija una opción: ");
			opc = sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					crearTablas();
				}
				
				case 2 ->{
					insertarTablas();
				}
				
				case 3 ->{
					listarTablas();
				}
				
				case 4 ->{
					editarTablas();
				}
				
				case 5 ->{
					borrarTablas();
				}
				
				case 6 ->{
					eliminarTablas();
				}
				
				case 0 ->{
					System.out.println("Desconectando...");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
		sc.close();
		
	}
	
	public static Connection conectar() {
		String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_rgarcia";
		String user = "rgarcia";
		String password = "12345";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return conn;
		
	}
	
	public static void menuCreacion() {
		System.out.println(" --------------");
		System.out.println("|     Crear    |");
		System.out.println(" --------------");
		System.out.println("1. Crear Todas las Tablas");
		System.out.println("2. Crear Tabla Mesas");
		System.out.println("3. Crear Tabla Productos");
		System.out.println("4. Crear Tabla Facturas");
		System.out.println("5. Crear Tabla Pedidos");
		System.out.println("0. Salir");
	}
	
	public static void crearTablas() {
		
		int opc = 0;
		
		do {
			
			menuCreacion();
			System.out.println("Elija una opción: ");
			opc = sc.nextInt();
			switch(opc) {
				
				case 1 ->{
					if(CreacionTablas.crearTodaLasTablas()) {
						System.out.println("Todas las tablas creadas correctamente");
					} else {
						System.out.println("No se han podido crear las tablas");
					}
					
				}
				
				case 2 ->{
					if(CreacionTablas.crearTablaMesas()) {
						System.out.println("Tabla Mesas creada creadascorrectamente");
					} else {
						System.out.println("No se ha podido crear la tabla Mesas");
					}
				}
				
				case 3 ->{
					if(CreacionTablas.crearTablaProductos()) {
						System.out.println("Tabla Productos creada creadascorrectamente");
					} else {
						System.out.println("No se ha podido crear la tabla Productos");
					}
				}
				
				case 4 ->{
					if(CreacionTablas.crearTablaFacturas()) {
						System.out.println("Tabla Factura creada creadascorrectamente");
					} else {
						System.out.println("No se ha podido crear la tabla Factura");
					}
				}
				
				case 5 ->{
					if(CreacionTablas.crearTablaPedidos()) {
						System.out.println("Tabla Pedidos creada creadascorrectamente");
					} else {
						System.out.println("No se ha podido crear la tabla Pedidos");
					}
				}
				case 0 ->{
					System.out.println("Saliendo del menú creación");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
		
	}
	
	public static void menuInsertar() {
		
		System.out.println(" --------------");
		System.out.println("|    Inertar   |");
		System.out.println(" --------------");
		System.out.println("1. Insertar Tabla Mesas");
		System.out.println("2. Insertar Tabla Productos");
		System.out.println("3. Insertar Tabla Facturas");
		System.out.println("4. Insertar Tabla Pedidos");
		System.out.println("5. Rellenar Todas las Tablas");
		System.out.println("0. Salir");
		
	}
	
	public static void insertarTablas() {
		
		int opc = 0;
		
		do {
			
			menuInsertar();
			System.out.println("Elija una opción: ");
			opc = sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					if(InsertarDatos.insertarTablaMesas(conn)) {
						System.out.println("Insert ejecutado correctamente");
					} else {
						System.out.println("No se ha podido ejecutar el insert");
					}
					
				}
				
				case 2 ->{
					
					if(InsertarDatos.insertarTablaProductos(conn)) {
						System.out.println("Insert ejecutado correctamente");
					} else {
						System.out.println("No se ha podido ejecutar el insert");
					}
				}
				
				case 3 ->{
					
					if(InsertarDatos.insertarTablaFacturas(conn)) {
						System.out.println("Insert ejecutado correctamente");
					} else {
						System.out.println("No se ha podido ejecutar el insert");
					}
				}
				
				case 4 ->{
					
					if(InsertarDatos.insertarTablaPedidos(conn)) {
						System.out.println("Insert ejecutado correctamente");
					} else {
						System.out.println("No se ha podido ejecutar el insert");
					}
				}
				case 5 ->{
					
					InsertarDatos.iniciarTablaMesas(conn);
					InsertarDatos.iniciarTablaProductos(conn);
					InsertarDatos.iniciarTablaFacturas(conn);
					InsertarDatos.iniciarTablaPedidos(conn);
					
				}
				case 0 ->{
					System.out.println("Saliendo del menú insertar");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
	}
	
	public static void menuListar() {
		
		System.out.println(" --------------");
		System.out.println("|    Listar    |");
		System.out.println(" --------------");
		System.out.println("1. Listar Tabla Mesas");
		System.out.println("2. Listar Tabla Productos");
		System.out.println("3. Listar Tabla Facturas");
		System.out.println("4. Listar Tabla Pedidos");
		System.out.println("0. Salir");
		
	}
	
	public static void listarTablas() {
		
		int opc = 0;
		
		do {
			
			menuListar();
			System.out.println("Elija una opción: ");
			opc = sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					MenuConsultas.listarTablaMesas();
				}
				
				case 2 ->{
					
					MenuConsultas.listarTablaProductos();
				}
				
				case 3 ->{
					
					MenuConsultas.listarTablaFacturas();
				}
				
				case 4 ->{
					
					MenuConsultas.listarTablaPedidos();
				}
				case 0 ->{
					System.out.println("Saliendo del menú de listar");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
	}
	
	public static void menuEditar() {
		
		System.out.println(" --------------");
		System.out.println("|    Editar    |");
		System.out.println(" --------------");
		System.out.println("1. Editar Tabla Mesas");
		System.out.println("2. Editar Tabla Productos");
		System.out.println("3. Editar Tabla Facturas");
		System.out.println("4. Editar Tabla Pedidos");
		System.out.println("0. Salir");
		
	}
	
	public static void editarTablas() {
		
		int opc = 0;
		int id = 0;
		
		do {
			
			menuEditar();
			System.out.println("Elija una opción: ");
			opc = sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					Consultas.listadoMesas(conn);
					System.out.println("¿Qué Mesa quieres editar? Introduzca el ID por favor");
					id = sc.nextInt();
					sc.nextLine();
					
					Editar.editarTablaMesas(conn, id);
				}
				
				case 2 ->{
					
					Consultas.listadoProductos(conn);
					System.out.println("¿Qué Producto quieres editar? Introduzca el ID por favor");
					id = sc.nextInt();
					sc.nextLine();
					
					Editar.editarTablaProductos(conn, id);
				}
				
				case 3 ->{
					
					Consultas.listadoFacturas(conn);
					System.out.println("¿Qué Mesa quieres editar? Introduzca el ID por favor");
					id = sc.nextInt();
					sc.nextLine();
					
					Editar.editarTablaFacturas(conn, id);
				}
				
				case 4 ->{
					
					Consultas.listadoPedidos(conn);
					System.out.println("¿Qué Mesa quieres editar? Introduzca el ID por favor");
					id = sc.nextInt();
					sc.nextLine();
					
					Editar.editarTablaPedidos(conn, id);
				}
				case 0 ->{
					System.out.println("Saliendo del menú de editar");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
	}
	
	public static void menuBorrar() {
		
		System.out.println(" --------------");
		System.out.println("|    Borrar    |");
		System.out.println(" --------------");
		System.out.println("1. Borrar Tabla Mesas");
		System.out.println("2. Borrar Tabla Productos");
		System.out.println("3. Borrar Tabla Facturas");
		System.out.println("4. Borrar Tabla Pedidos");
		System.out.println("5. Borrar Todas las Tablas");
		System.out.println("0. Salir");
		
	}
	
	public static void borrarTablas() {
		
		int opc = 0;
		
		do {
			
			menuBorrar();
			System.out.println("Elija una opción: ");
			opc = sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					MenuDeletes.borrarTablaMesas();
				}
				
				case 2 ->{
					
					MenuDeletes.borrarTablaProductos();
				}
				
				case 3 ->{
					
					MenuDeletes.borrarTablaFacturas();
				}
				
				case 4 ->{
					
					MenuDeletes.borrarTablaPedidos();
				}
				case 5 ->{
					
					sc.nextLine();
					Deletes.borradoPedidos(conn);
					Deletes.borradoFacturas(conn);
					Deletes.borradoProductos(conn);
					Deletes.borradoMesas(conn);
					
				}
				case 0 ->{
					System.out.println("Saliendo del menú de borrar");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
	}
	
	public static void menuEliminado() {
		
		System.out.println(" --------------");
		System.out.println("|   Eliminar   |");
		System.out.println(" --------------");
		System.out.println("1. Eliminar Tabla Mesas");
		System.out.println("2. Eliminar Tabla Productos");
		System.out.println("3. Eliminar Tabla Facturas");
		System.out.println("4. Eliminar Tabla Pedidos");
		System.out.println("5. Eliminar Todas las Tablas");
		System.out.println("0. Salir");
		
	}
	
	public static void eliminarTablas() {
		
		int opc = 0;
		
		do {
			
			menuBorrar();
			System.out.println("Elija una opción: ");
			opc = sc.nextInt();
			
			switch(opc) {
				
				case 1 ->{
					
					sc.nextLine();
					Drops.eliminadoTablaMesas(conn);
				}
				
				case 2 ->{
					
					sc.nextLine();
					Drops.eliminadoTablaProductos(conn);
				}
				
				case 3 ->{
					
					sc.nextLine();
					Drops.eliminadoTablaFacturas(conn);
				}
				
				case 4 ->{
					
					sc.nextLine();
					Drops.eliminadoTablaPedidos(conn);
				}
				case 5 ->{
					
					sc.nextLine();
					Drops.eliminadoTablaPedidos(conn);
					Drops.eliminadoTablaProductos(conn);
					Drops.eliminadoTablaFacturas(conn);
					Drops.eliminadoTablaMesas(conn);
					
				}
				case 0 ->{
					System.out.println("Saliendo del menú de eliminar");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
	}
	
}
