package actividad3_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD {
	
	static Connection conn = null;
	static Scanner sc = new Scanner(System.in);;
	
	public static void main(String[] args) {
		
		int opc = 0;
		
		conectar();
		
		do {
			
			menu();
			System.out.println("Elija una opción");
			opc = sc.nextInt();
			switch(opc) {
				
				case 1 ->{
					crearTablas();
				}
				
				case 2 ->{
					
				}
				
				case 3 ->{
					
				}
				
				case 4 ->{
					
				}
				
				case 5 ->{
					
				}
				
				case 0 ->{
					
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
		sc.close();
		System.out.println("Desconectando...");
		
	}
	
	public static void conectar() {
		String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_rgarcia";
		String user = "rgarcia";
		String password = "12345";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void menu() {
		System.out.println(" --------------");
		System.out.println("|     Menú     |");
		System.out.println(" --------------");
		System.out.println("1. Crear Tablas");
		System.out.println("2. Insertar Datos");
		System.out.println("3. Listar Datos");
		System.out.println("4. Modificar Datos");
		System.out.println("5. Borrar Datos");
		System.out.println("0. Salir");
	}
	
	public static void menuCreacion() {
		System.out.println(" --------------");
		System.out.println("|     Menú     |");
		System.out.println(" --------------");
		System.out.println("1. Crear Todas las Tablas");
		System.out.println("2. Crear Tabla Factura");
		System.out.println("3. Crear Tabla Pedido");
		System.out.println("4. Crear Tabla Mesa");
		System.out.println("5. Crear Tabla Productos");
	}
	
	public static void crearTablas() {
		
		int opc = 0;
		
		do {
			
			menuCreacion();
			System.out.println("Elija una opción");
			opc = sc.nextInt();
			switch(opc) {
				
				case 1 ->{
					crearTodaLasTablas();
				}
				
				case 2 ->{
					crearTablaFacturas();
				}
				
				case 3 ->{
					crearTablaPedidos();
				}
				
				case 4 ->{
					crearTablaMesas();
				}
				
				case 5 ->{
					crearTablaProductos();
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
		sc.close();
		
	}
	
	public static void crearTodaLasTablas() {
		
		ResultSet lista = null;
		PreparedStatement query = null;

		crearTablaMesas();
		crearTablaProductos();
		crearTablaFacturas();
		crearTablaPedidos();

	}
	
	public static void crearTablaMesas() {
		
		ResultSet lista = null;
		PreparedStatement query = null;
		
		try {
			
			query = conn.prepareStatement("CREATE TABLE Mesas ( "
					+ "idMesa INT AUTO_INCREMENT PRIMARY KEY, "
					+ "numComensales INT NOT NULL, "
					+ "reserva INT NOT NULL);");
			lista = query.executeQuery();
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				lista.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
	}
	
	public static void crearTablaProductos() {
		
		ResultSet lista = null;
		PreparedStatement query = null;
		
		try {
			
			query = conn.prepareStatement("CREATE TABLE Productos ( "
					+ "idProducto INT AUTO_INCREMENT PRIMARY KEY, "
					+ "Denominacion VARCHAR(45) NOT NULL, "
					+ "Precio DECIMAL(10,2) NOT NULL);");
			lista = query.executeQuery();
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				lista.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
	}
	
	public static void crearTablaFacturas() {
		
		ResultSet lista = null;
		PreparedStatement query = null;
		
		try {
			
			query = conn.prepareStatement("CREATE TABLE Facturas ( "
					+ "idFactura INT AUTO_INCREMENT PRIMARY KEY, "
					+ "idMesa INT NOT NULL, "
					+ "tipoPago VARCHAR(45) NOT NULL, "
					+ "Importe DECIMAL(10,2) NOT NULL,"
					+ "FOREIGN KEY (idMesa) REFERENCES Mesas(idMesa) );");
			lista = query.executeQuery();
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				lista.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
	}
	
	public static void crearTablaPedidos() {
		
		ResultSet lista = null;
		PreparedStatement query = null;
		
		try {
			
			query = conn.prepareStatement("CREATE TABLE Pedidos ( "
					+ "idPedido INT AUTO_INCREMENT PRIMARY KEY, "
					+ "idFactura INT NOT NULL, "
					+ "idProducto INT NOT NULL, "
					+ "cantidad INT NOT NULL, "
					+ "FOREIGN KEY (idMesa) REFERENCES Mesas(idMesa),"
					+ "FOREIGN KEY (idProducto) REFERENCES Productos(idProducto) );");
			lista = query.executeQuery();
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				lista.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
	}
	
}
