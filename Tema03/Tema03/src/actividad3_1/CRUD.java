package actividad3_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
					
				}
				
				case 5 ->{
					
				}
				
				case 6 ->{
					
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
		System.out.println("|    Inerta    |");
		System.out.println(" --------------");
		System.out.println("1. Insertar Tabla Mesas");
		System.out.println("2. Insertar Tabla Productos");
		System.out.println("3. Insertar Tabla Facturas");
		System.out.println("4. Insertar Tabla Pedidos");
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
					
					InsertarDatos.iniciarTablaMesas(conn);
					
					if(InsertarDatos.insertarTablaMesas(conn)) {
						System.out.println("Insert ejecutado correctamente");
					} else {
						System.out.println("No se ha podido ejecutar el insert");
					}
					
				}
				
				case 2 ->{
					
					InsertarDatos.iniciarTablaProductos(conn);
					
					if(InsertarDatos.insertarTablaProductos(conn)) {
						System.out.println("Insert ejecutado correctamente");
					} else {
						System.out.println("No se ha podido ejecutar el insert");
					}
				}
				
				case 3 ->{
					
					InsertarDatos.iniciarTablaFacturas(conn);
					
					if(InsertarDatos.insertarTablaFacturas(conn)) {
						System.out.println("Insert ejecutado correctamente");
					} else {
						System.out.println("No se ha podido ejecutar el insert");
					}
				}
				
				case 4 ->{
					
					InsertarDatos.iniciarTablaPedidos(conn);
					
					if(InsertarDatos.insertarTablaPedidos(conn)) {
						System.out.println("Insert ejecutado correctamente");
					} else {
						System.out.println("No se ha podido ejecutar el insert");
					}
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
					
					SubMenuConsultasMesas.listarTablaMesas();
				}
				
				case 2 ->{
					
					SubMenuConsultasProductos.listarTablaProductos();
				}
				
				case 3 ->{
					
					SubMenuConsultasFacturas.listarTablaFacturas();
				}
				
				case 4 ->{
					
					SubMenuConsultasPedidos.listarTablaPedidos();
				}
				case 0 ->{
					System.out.println("Saliendo del menú de listado");
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
	}
	
}
