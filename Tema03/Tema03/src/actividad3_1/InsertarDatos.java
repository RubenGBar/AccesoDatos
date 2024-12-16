package actividad3_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertarDatos {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void iniciarTablaFacturas(Connection conn) {
		
		BufferedReader br = null;
		String linea =  "";
		String insert = "";
		int filasAfectadas = 0;
		
		try {
			br = new BufferedReader (new FileReader("src/actividad3_1/ficheros/facturas.txt"));
			linea = br.readLine();

			while(linea!=null) {
				insert =  linea ;

				Statement insertFacturas = conn.createStatement();
				insertFacturas.executeUpdate(insert);

				filasAfectadas++;
				
				linea = br.readLine();
			}
			
			System.out.println("Filas afectadas: " + filasAfectadas);

			br.close();				
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo");
		} catch (IOException e) {
			System.out.println("Ocurrió algún error");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo en la insercion");
		}
		
	}
	
	public static boolean insertarTablaFacturas(Connection conn) {
		
		boolean insertado = false;
		int idFacturas = 0;
		int idMesa = 0;
		String tipoPago = "";
		int Importe = 0;
		String insert = "";
		
		System.out.println("Introduzca un nuevo id: ");
		idMesa = sc.nextInt();
		
		System.out.println("Introduzca el id de la mesa asociada a la factura: ");
		idFacturas = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca el tipo de pago: ");
		tipoPago = sc.nextLine();
		
		System.out.println("Introduzca el importe: ");
		Importe = sc.nextInt();
		
		try {
			
			insert = "INSERT INTO Facturas (idFactura, idMesa, tipoPago, Importe) VALUES (?, ?, ?, ?);";
			
			PreparedStatement insertFacturas = conn.prepareStatement(insert);
			
			insertFacturas.setInt(1, idFacturas);
			insertFacturas.setInt(2, idMesa);
			insertFacturas.setString(3, tipoPago);
			insertFacturas.setInt(4, Importe);
			
			insertFacturas.executeUpdate();
			
			insertado = true;
			
			System.out.println();
			
			insertFacturas.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo en la inserción");
		}
		
		return insertado;
		
	}
	
	public static void iniciarTablaMesas(Connection conn) {
		
		BufferedReader br = null;
		String linea =  "";
		String insert = "";
		int filasAfectadas = 0;
		
		try {
			br = new BufferedReader (new FileReader("src/actividad3_1/ficheros/mesas.txt"));
			linea = br.readLine();

			while(linea!=null) {
				insert =  linea ;

				Statement insertMesas = conn.createStatement();
				insertMesas.executeUpdate(insert);

				filasAfectadas++;
				
				linea = br.readLine();
			}
			
			System.out.println("Filas afectadas: " + filasAfectadas);

			br.close();				
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo");
		} catch (IOException e) {
			System.out.println("Ocurrió algún error");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo en la insercion");
		}
		
	}
	
	public static boolean insertarTablaMesas(Connection conn) {
		
		boolean insertado = false;
		int idMesa = 0;
		int numComensales = 0;
		int reserva = 0;
		String insert = "";
		
		System.out.println("Introduzca un nuevo id: ");
		idMesa = sc.nextInt();
		
		System.out.println("Introduzca un número de comensales: ");
		numComensales = sc.nextInt();
		
		System.out.println("¿Ha hecho una reserva? (Sí: 1, No: 0)");
		reserva = sc.nextInt();
		
		try {
			
			insert = "INSERT INTO Mesas (idMesa, numComensales, reserva) VALUES (?, ?, ?);";
			
			PreparedStatement insertMesas = conn.prepareStatement(insert);
			
			insertMesas.setInt(1, idMesa);
			insertMesas.setInt(2, numComensales);
			insertMesas.setInt(3, reserva);
			
			insertMesas.executeUpdate();
			
			insertado = true;
			
			System.out.println();
			
			insertMesas.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo en la inserción");
		}
		
		return insertado;
		
	}
	
	public static void iniciarTablaPedidos(Connection conn) {
		
		BufferedReader br = null;
		String linea =  "";
		String insert = "";
		int filasAfectadas = 0;
		
		try {
			br = new BufferedReader (new FileReader("src/actividad3_1/ficheros/pedidos.txt"));
			linea = br.readLine();

			while(linea!=null) {
				insert =  linea ;

				Statement insertPedidos = conn.createStatement();
				insertPedidos.executeUpdate(insert);

				filasAfectadas++;
				
				linea = br.readLine();
			}
			
			System.out.println("Filas afectadas: " + filasAfectadas);

			br.close();				
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo");
		} catch (IOException e) {
			System.out.println("Ocurrió algún error");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo en la insercion");
		}
		
	}
	
	public static boolean insertarTablaPedidos(Connection conn) {
		
		boolean insertado = false;
		int idPedido = 0;
		int idFactura = 0;
		int idProducto = 0;
		int cantidad = 0;
		String insert = "";
		
		System.out.println("Introduzca un nuevo id: ");
		idPedido = sc.nextInt();
		
		System.out.println("Introduzca el id de la factura a la que está asociado el pedido: ");
		idFactura = sc.nextInt();
		
		System.out.println("Introduzca el id del producto a la que está asociado el pedido: ");
		idProducto = sc.nextInt();
		
		System.out.println("Introduzca la cantidad del pedido: ");
		cantidad = sc.nextInt();
		
		try {
			
			insert = "INSERT INTO Pedidos (idPedido, idFactura, idProducto, cantidad) VALUES (?, ?, ?, ?);";
			
			PreparedStatement insertPedidos = conn.prepareStatement(insert);
			
			insertPedidos.setInt(1, idPedido);
			insertPedidos.setInt(2, idFactura);
			insertPedidos.setInt(3, idProducto);
			insertPedidos.setInt(4, cantidad);
			
			insertPedidos.executeUpdate();
			
			insertado = true;
			
			System.out.println();
			
			insertPedidos.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo en la inserción");
		}
		
		return insertado;
		
	}
	
	public static void iniciarTablaProductos(Connection conn) {
		
		BufferedReader br = null;
		String linea =  "";
		String insert = "";
		int filasAfectadas = 0;
		
		try {
			br = new BufferedReader (new FileReader("src/actividad3_1/ficheros/productos.txt"));
			linea = br.readLine();

			while(linea!=null) {
				insert =  linea ;

				Statement insertProductos = conn.createStatement();
				insertProductos.executeUpdate(insert);

				filasAfectadas++;
				
				linea = br.readLine();
			}
			
			System.out.println("Filas afectadas: " + filasAfectadas);

			br.close();				
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo");
		} catch (IOException e) {
			System.out.println("Ocurrió algún error");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo en la insercion");
		}
		
	}
	
	public static boolean insertarTablaProductos(Connection conn) {
		
		boolean insertado = false;
		int idProducto = 0;
		String Denominacion = "";
		int Precio = 0;
		String insert = "";
		
		System.out.println("Introduzca un nuevo id: ");
		idProducto = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca la denominación del producto: ");
		Denominacion = sc.nextLine();
		
		System.out.println("Introduzca el precio del producto: ");
		Precio = sc.nextInt();
		
		try {
			
			insert = "INSERT INTO Productos (idProducto, Denominacion, Precio) VALUES (?, ?, ?);";
			
			PreparedStatement insertProductos = conn.prepareStatement(insert);
			
			insertProductos.setInt(1, idProducto);
			insertProductos.setString(2, Denominacion);
			insertProductos.setInt(3, Precio);
			
			insertProductos.executeUpdate();
			
			insertado = true;
			
			System.out.println();
			
			insertProductos.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo en la inserción");
		}
		
		return insertado;
		
	}
	
	
}
