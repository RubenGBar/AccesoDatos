package actividad3_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Editar {
	
	public static void editarTablaMesas(Connection conn, int id) {
		
		int reserva = 0;
		int numComensales = 0;
		String edit = "";
		String modificar = "";
		String confirmar = "";
		PreparedStatement editMesa = null;
		
		try {
			
			System.out.println("¿Quieres editar el número de comensales? (Si/No)");
			modificar = CRUD.sc.nextLine();
			
			if(modificar.equalsIgnoreCase("si")) {
				
				Transaccion.empezarTransaccion(conn);
				
				System.out.println("Introduzca el nuevo número de comensales");
				numComensales = CRUD.sc.nextInt();
				CRUD.sc.nextLine();
				
				System.out.println("¿Quieres guardar los cambios? (Si/No)");
				confirmar = CRUD.sc.nextLine();
				
				if(confirmar.equalsIgnoreCase("si")) {
					
					edit = "UPDATE Mesas SET numComensales = ? WHERE idMesa = " + id;
					
					editMesa = conn.prepareStatement(edit);
					
					editMesa.setInt(1, numComensales);
					
					editMesa.executeUpdate();
					
					Transaccion.confirmarTransaccion(conn);
					System.out.println("Se ha editado el número de comensales de la mesa");
					
					
				}else {
					
					Transaccion.cancelarTransaccion(conn);
					System.out.println("No se ha editado el número de comensales de la mesa");
					
				}
				
			}
			
			System.out.println("¿Quieres editar la reserva? (Si/No)");
			modificar = CRUD.sc.nextLine();
			
			if(modificar.equalsIgnoreCase("si")) {
				
				Transaccion.empezarTransaccion(conn);
				
				System.out.println("Introduzca el nuevo estado de la reserva. 0 = No, 1 = Si");
				reserva = CRUD.sc.nextInt();
				CRUD.sc.nextLine();
				
				System.out.println("¿Quieres guardar los cambios? (Si/No)");
				confirmar = CRUD.sc.nextLine();
				
				if(confirmar.equalsIgnoreCase("si")) {
					
					edit = "UPDATE Mesas SET reserva = ? WHERE idMesa = " + id;
					
					editMesa = conn.prepareStatement(edit);
					
					editMesa.setInt(1, reserva);
					
					editMesa.executeUpdate();
					
					Transaccion.confirmarTransaccion(conn);
					System.out.println("Se ha editado la reserva");
					
				}else {
					
					Transaccion.cancelarTransaccion(conn);
					System.out.println("No se ha editado la reserva");
					
				}
				
			}
			
			System.out.println();
			
			editMesa.close();
			
		} catch (SQLException e) {
			System.out.println("Fallo en la edición");
		}
		
	}
	
	public static void editarTablaProductos(Connection conn, int id) {
		
		String Denominacion = "";
		double Precio = 0;
		String edit = "";
		String modificar = "";
		String confirmar = "";
		PreparedStatement editProducto = null;
		
		try {
			
			System.out.println("¿Quieres editar la denominación del Producto? (Si/No)");
			modificar = CRUD.sc.nextLine();
			
			if(modificar.equalsIgnoreCase("si")) {
				
				Transaccion.empezarTransaccion(conn);
				
				System.out.println("Introduzca la nueva Denominación");
				Denominacion = CRUD.sc.nextLine();
				
				System.out.println("¿Quieres guardar los cambios? (Si/No)");
				confirmar = CRUD.sc.nextLine();
				
				if(confirmar.equalsIgnoreCase("si")) {
					
					edit = "UPDATE Mesas SET Denominacion = ? WHERE idProducto = " + id;
					
					editProducto = conn.prepareStatement(edit);
					
					editProducto.setString(1, Denominacion);
					
					editProducto.executeUpdate();
					
					Transaccion.confirmarTransaccion(conn);
					System.out.println("Se ha editado la denominación");
					
					
				}else {
					
					Transaccion.cancelarTransaccion(conn);
					System.out.println("No se ha editado la denominación");
					
				}
				
			}
			
			System.out.println("¿Quieres editar el precio? (Si/No)");
			modificar = CRUD.sc.nextLine();
			
			if(modificar.equalsIgnoreCase("si")) {
				
				Transaccion.empezarTransaccion(conn);
				
				System.out.println("Introduzca el nuevo precio del producto");
				Precio = CRUD.sc.nextDouble();
				CRUD.sc.nextLine();
				
				System.out.println("¿Quieres guardar los cambios? (Si/No)");
				confirmar = CRUD.sc.nextLine();
				
				if(confirmar.equalsIgnoreCase("si")) {
					
					edit = "UPDATE Mesas SET Precio = ? WHERE idProducto = " + id;
					
					editProducto = conn.prepareStatement(edit);
					
					editProducto.setDouble(1, Precio);
					
					editProducto.executeUpdate();
					
					Transaccion.confirmarTransaccion(conn);
					System.out.println("Se ha editado el precio");
					
				}else {
					
					Transaccion.cancelarTransaccion(conn);
					System.out.println("No se ha editado el precio");
					
				}
				
			}
			
			System.out.println();
			
			editProducto.close();
			
		} catch (SQLException e) {
			System.out.println("Fallo en la edición");
		}
		
	}
	
	public static void editarTablaFacturas(Connection conn, int id) {
		
		int idMesa = 0;
		String tipoPago = "";
		double Importe = 0;
		String edit = "";
		String modificar = "";
		String confirmar = "";
		PreparedStatement editFactura = null;
		
		try {
			
			System.out.println("¿Quieres editar el ID de la mesa asociada a la factura? (Si/No)");
			modificar = CRUD.sc.nextLine();
			
			if(modificar.equalsIgnoreCase("si")) {
				
				Transaccion.empezarTransaccion(conn);
				
				System.out.println("Introduzca el nuevo ID de la mesa");
				idMesa = CRUD.sc.nextInt();
				CRUD.sc.nextLine();
				
				System.out.println("¿Quieres guardar los cambios? (Si/No)");
				confirmar = CRUD.sc.nextLine();
				
				if(confirmar.equalsIgnoreCase("si")) {
					
					edit = "UPDATE Facturas SET idMesa = ? WHERE idFactura = " + id;
					
					editFactura = conn.prepareStatement(edit);
					
					editFactura.setInt(1, idMesa);
					
					editFactura.executeUpdate();
					
					Transaccion.confirmarTransaccion(conn);
					System.out.println("Se ha editado el ID de la mesa");
					
					
				}else {
					
					Transaccion.cancelarTransaccion(conn);
					System.out.println("No se ha editado el ID de la mesa");
					
				}
				
			}
			
			System.out.println("¿Quieres editar el tipo de pago de la factura? (Si/No)");
			modificar = CRUD.sc.nextLine();
			
			if(modificar.equalsIgnoreCase("si")) {
				
				Transaccion.empezarTransaccion(conn);
				
				System.out.println("Introduzca el nuevo tipo de pago");
				tipoPago = CRUD.sc.nextLine();
				
				System.out.println("¿Quieres guardar los cambios? (Si/No)");
				confirmar = CRUD.sc.nextLine();
				
				if(confirmar.equalsIgnoreCase("si")) {
					
					edit = "UPDATE Facturas SET tipoPago = ? WHERE idFactura = " + id;
					
					editFactura = conn.prepareStatement(edit);
					
					editFactura.setString(1, tipoPago);
					
					editFactura.executeUpdate();
					
					Transaccion.confirmarTransaccion(conn);
					System.out.println("Se ha editado el tipo de pago");
					
				}else {
					
					Transaccion.cancelarTransaccion(conn);
					System.out.println("No se ha editado el tipo de pago");
					
				}
				
			}
			
			System.out.println("¿Quieres editar el importe de la factura? (Si/No)");
			modificar = CRUD.sc.nextLine();
			
			if(modificar.equalsIgnoreCase("si")) {
				
				Transaccion.empezarTransaccion(conn);
				
				System.out.println("Introduzca el nuevo importe");
				Importe = CRUD.sc.nextDouble();
				CRUD.sc.nextLine();
				
				System.out.println("¿Quieres guardar los cambios? (Si/No)");
				confirmar = CRUD.sc.nextLine();
				
				if(confirmar.equalsIgnoreCase("si")) {
					
					edit = "UPDATE Facturas SET Importe = ? WHERE idFactura = " + id;
					
					editFactura = conn.prepareStatement(edit);
					
					editFactura.setDouble(1, Importe);
					
					editFactura.executeUpdate();
					
					Transaccion.confirmarTransaccion(conn);
					System.out.println("Se ha editado el importe");
					
				}else {
					
					Transaccion.cancelarTransaccion(conn);
					System.out.println("No se ha editado el importe");
					
				}
				
			}
			
			System.out.println();
			
			editFactura.close();
			
		} catch (SQLException e) {
			System.out.println("Fallo en la edición");
		}
		
	}
	
	public static void editarTablaPedidos(Connection conn, int id) {
		
		int idFactura = 0;
		int idProducto = 0;
		int cantidad = 0;
		String edit = "";
		String modificar = "";
		String confirmar = "";
		PreparedStatement editPedido = null;
		
		try {
			
			System.out.println("¿Quieres editar el ID de la Factura asociada al Pedido? (Si/No)");
			modificar = CRUD.sc.nextLine();
			
			if(modificar.equalsIgnoreCase("si")) {
				
				Transaccion.empezarTransaccion(conn);
				
				System.out.println("Introduzca el nuevo ID de la Factura");
				idFactura = CRUD.sc.nextInt();
				CRUD.sc.nextLine();
				
				System.out.println("¿Quieres guardar los cambios? (Si/No)");
				confirmar = CRUD.sc.nextLine();
				
				if(confirmar.equalsIgnoreCase("si")) {
					
					edit = "UPDATE Pedidos SET idFactura = ? WHERE idPedido = " + id;
					
					editPedido = conn.prepareStatement(edit);
					
					editPedido.setInt(1, idFactura);
					
					editPedido.executeUpdate();
					
					Transaccion.confirmarTransaccion(conn);
					System.out.println("Se ha editado el ID de la Factura");
					
					
				}else {
					
					Transaccion.cancelarTransaccion(conn);
					System.out.println("No se ha editado el ID de la Factura");
					
				}
				
			}
			
			System.out.println("¿Quieres editar el ID del producto asociado al Pedido? (Si/No)");
			modificar = CRUD.sc.nextLine();
			
			if(modificar.equalsIgnoreCase("si")) {
				
				Transaccion.empezarTransaccion(conn);
				
				System.out.println("Introduzca el nuevo ID del producto");
				idProducto = CRUD.sc.nextInt();
				CRUD.sc.nextLine();
				
				System.out.println("¿Quieres guardar los cambios? (Si/No)");
				confirmar = CRUD.sc.nextLine();
				
				if(confirmar.equalsIgnoreCase("si")) {
					
					edit = "UPDATE Pedidos SET idProducto = ? WHERE idPedido = " + id;
					
					editPedido = conn.prepareStatement(edit);
					
					editPedido.setInt(1, idProducto);
					
					editPedido.executeUpdate();
					
					Transaccion.confirmarTransaccion(conn);
					System.out.println("Se ha editado el ID del producto");
					
					
				}else {
					
					Transaccion.cancelarTransaccion(conn);
					System.out.println("No se ha editado el ID del producto");
					
				}
				
			}
			
			System.out.println("¿Quieres editar la cantidad del pedido? (Si/No)");
			modificar = CRUD.sc.nextLine();
			
			if(modificar.equalsIgnoreCase("si")) {
				
				Transaccion.empezarTransaccion(conn);
				
				System.out.println("Introduzca la nueva cantidad del pedido");
				cantidad = CRUD.sc.nextInt();
				CRUD.sc.nextLine();
				
				System.out.println("¿Quieres guardar los cambios? (Si/No)");
				confirmar = CRUD.sc.nextLine();
				
				if(confirmar.equalsIgnoreCase("si")) {
					
					edit = "UPDATE Pedidos SET cantidad = ? WHERE idPedido = " + id;
					
					editPedido = conn.prepareStatement(edit);
					
					editPedido.setInt(1, cantidad);
					
					editPedido.executeUpdate();
					
					Transaccion.confirmarTransaccion(conn);
					System.out.println("Se ha editado la cantidad del pedido");
					
					
				}else {
					
					Transaccion.cancelarTransaccion(conn);
					System.out.println("No se ha editado la cantidad del producto");
					
				}
				
			}
			
			System.out.println();
			
			editPedido.close();
			
		} catch (SQLException e) {
			System.out.println("Fallo en la edición");
		}
		
	}

}
