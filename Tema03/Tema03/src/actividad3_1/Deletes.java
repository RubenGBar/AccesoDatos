package actividad3_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deletes {
	
	public static void borradoMesas(Connection conn) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Mesas;");
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar porque porque hay resgistros asociados a una o varias facturas");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoMesasPorId(Connection conn, int compara) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Mesas WHERE idMesa = ?;");
		        query.setInt(1, compara);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar porque porque hay resgistros asociados a una o varias facturas");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoMesasPorComensales(Connection conn, int compara) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Mesas WHERE numComensales = ?;");
		        query.setInt(1, compara);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar porque porque hay resgistros asociados a una o varias facturas");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoMesasPorReserva(Connection conn, String reserva) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Mesas WHERE reserva = ?;");
		        query.setString(1, reserva);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar porque porque hay resgistros asociados a una o varias facturas");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoProductos(Connection conn) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Productos;");
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	    	System.out.println("No se ha podido eliminar el producto porque está asociado a un pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoProductosPorId(Connection conn, int id) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Productos Where idProducto = ?;");
	    		query.setInt(1, id);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	    	System.out.println("No se ha podido eliminar el producto porque está asociado a un pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}
	
	public static void borradoProductosPorDenominacion(Connection conn, String denominacion) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Productos Where Denominacion = ?;");
	    		query.setString(1, denominacion);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	    	System.out.println("No se ha podido eliminar el producto porque está asociado a un pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoProductosPorPrecio(Connection conn, double precio) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Productos Where Precio = ?;");
	    		query.setDouble(1, precio);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar el producto porque está asociado a un pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoFacturas(Connection conn) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Facturas;");
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar la factura porque está asociada a un pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoFacturasPorId(Connection conn, int id) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Facturas WHERE idFactura = ?;");
	    		query.setInt(1, id);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar la factura porque está asociada a un pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoFacturasPorIdMesa(Connection conn, int idMesa) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Facturas WHERE idMesa = ?;");
	    		query.setInt(1, idMesa);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar la factura porque está asociada a un pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoFacturasPorTipoPago(Connection conn, String tipoPago) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Facturas WHERE tipoPago = ?;");
	    		query.setString(1, tipoPago);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar la factura porque está asociada a un pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoFacturasPorImporte(Connection conn, double importe) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Facturas WHERE Importe = ?;");
	    		query.setDouble(1, importe);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar la factura porque está asociada a un pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoPedidos(Connection conn) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Pedidos;");
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar el pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoPedidosPorId(Connection conn, int id) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Pedidos WHERE idPedido = ?;");
	    		query.setInt(1, id);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar el pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoPedidosPorIdFactura(Connection conn, int id) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Pedidos WHERE idFactura = ?;");
	    		query.setInt(1, id);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar el pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoPedidosPorIdProducto(Connection conn, int id) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Pedidos WHERE idProducto = ?;");
	    		query.setInt(1, id);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar el pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void borradoPedidosPorCantidad(Connection conn, int cantidad) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres borrarlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DELETE FROM Pedidos WHERE cantidad = ?;");
	    		query.setInt(1, cantidad);
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar el pedido");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

}
