package actividad3_1;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreacionTablas {

	public static boolean crearTablaMesas() {
		
		boolean creada = false;
		PreparedStatement query = null;
		
		try {
			
			query = CRUD.conn.prepareStatement("CREATE TABLE Mesas ( "
					+ "idMesa INT AUTO_INCREMENT PRIMARY KEY, "
					+ "numComensales INT NOT NULL, "
					+ "reserva INT NOT NULL);");
			query.executeUpdate();
			creada = true;
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (query != null) query.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return creada;
		
	}

	public static boolean crearTablaProductos() {
		
		boolean creada = false;
		PreparedStatement query = null;
		
		try {
			
			query = CRUD.conn.prepareStatement("CREATE TABLE Productos ( "
					+ "idProducto INT AUTO_INCREMENT PRIMARY KEY, "
					+ "Denominacion VARCHAR(45) NOT NULL, "
					+ "Precio DECIMAL(10,2) NOT NULL);");
			query.executeUpdate();
			creada = true;
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if(query != null) query.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return creada;
		
	}

	public static boolean crearTablaFacturas() {
		
		boolean creada = false;
		PreparedStatement query = null;
		
		try {
			
			query = CRUD.conn.prepareStatement("CREATE TABLE Facturas ( "
					+ "idFactura INT AUTO_INCREMENT PRIMARY KEY, "
					+ "idMesa INT NOT NULL, "
					+ "tipoPago VARCHAR(45) NOT NULL, "
					+ "Importe DECIMAL(10,2) NOT NULL,"
					+ "FOREIGN KEY (idMesa) REFERENCES Mesas(idMesa) );");
			query.executeUpdate();
			creada = true;
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if(query != null) query.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return creada;
		
	}

	public static boolean crearTablaPedidos() {
		
		boolean creada = false;
		PreparedStatement query = null;
		
		try {
			
			query = CRUD.conn.prepareStatement("CREATE TABLE Pedidos ( "
					+ "idPedido INT AUTO_INCREMENT PRIMARY KEY, "
					+ "idFactura INT NOT NULL, "
					+ "idProducto INT NOT NULL, "
					+ "cantidad INT NOT NULL, "
					+ "FOREIGN KEY (idFactura) REFERENCES Facturas(idFactura),"
					+ "FOREIGN KEY (idProducto) REFERENCES Productos(idProducto) );");
			query.executeUpdate();
			creada = true;
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if(query != null) query.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return creada;
	}

	public static boolean crearTodaLasTablas() {
		
		boolean creadas = false;
		
		if(crearTablaMesas() &&
		   crearTablaProductos() &&
		   crearTablaFacturas() &&
		   crearTablaPedidos()
		   ) 
		{
			creadas = true;
		}
		
		return creadas;
	
	}

}
