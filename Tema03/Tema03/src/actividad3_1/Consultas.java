package actividad3_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {

<<<<<<< Updated upstream
=======
	public static void listadoFacturas(Connection conn) {
	    ResultSet lista = null;
	    PreparedStatement listaComlpeta = null;
	    try {
	        listaComlpeta = conn.prepareStatement("SELECT * FROM Facturas");
	        lista = listaComlpeta.executeQuery();
	        while(lista.next()) {
	            System.out.println("ID: " + lista.getInt("idFactura") + " ");
	            System.out.println("ID Mesa Asociada: " + lista.getString("idMesa"));
	            System.out.println("Tipo de Pago: " + lista.getString("tipoPago"));
	            System.out.println("Importe de la Factura: " + lista.getString("Importe"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoFacturasPorId(Connection conn, int compara) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idFactura = ?");
	        listaCompleta.setInt(1, compara);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idFactura") + " ");
	            System.out.println("ID Mesa Asociada: " + lista.getString("idMesa"));
	            System.out.println("Tipo de Pago: " + lista.getString("tipoPago"));
	            System.out.println("Importe de la Factura: " + lista.getString("Importe"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoFacturasPorIdMesa(Connection conn, int compara) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idMesa = ?");
	        listaCompleta.setInt(1, compara);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idFactura") + " ");
	            System.out.println("ID Mesa Asociada: " + lista.getString("idMesa"));
	            System.out.println("Tipo de Pago: " + lista.getString("tipoPago"));
	            System.out.println("Importe de la Factura: " + lista.getString("Importe"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoFacturasPorTipoPago(Connection conn, String pago) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE tipoPago = ?");
	        listaCompleta.setString(1, pago);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idFactura") + " ");
	            System.out.println("ID Mesa Asociada: " + lista.getString("idMesa"));
	            System.out.println("Tipo de Pago: " + lista.getString("tipoPago"));
	            System.out.println("Importe de la Factura: " + lista.getString("Importe"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoFacturasPorImporte(Connection conn, double precio) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE tipoPago = ?");
	        listaCompleta.setDouble(1, precio);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idFactura") + " ");
	            System.out.println("ID Mesa Asociada: " + lista.getString("idMesa"));
	            System.out.println("Tipo de Pago: " + lista.getString("tipoPago"));
	            System.out.println("Importe de la Factura: " + lista.getString("Importe"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

>>>>>>> Stashed changes
	public static void listadoMesas(Connection conn) {
	    ResultSet lista = null;
	    PreparedStatement listaComlpeta = null;
	    try {
<<<<<<< Updated upstream
	        listaComlpeta = conn.prepareStatement("SELECT * FROM Mesas;");
=======
	        listaComlpeta = conn.prepareStatement("SELECT * FROM Mesas");
>>>>>>> Stashed changes
	        lista = listaComlpeta.executeQuery();
	        while(lista.next()) {
	            System.out.println("ID: " + lista.getInt("idMesa") + " ");
	            System.out.println("Numero de Comensales: " + lista.getString("numComensales"));
	            System.out.println("¿Has hecho reserva?: " + lista.getString("reserva"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoMesasPorId(Connection conn, int compara) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
<<<<<<< Updated upstream
	        listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE idMesa = ?;");
=======
	        listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE idMesa = ?");
>>>>>>> Stashed changes
	        listaCompleta.setInt(1, compara);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idMesa") + " ");
	            System.out.println("Numero de Comensales: " + lista.getString("numComensales"));
	            System.out.println("¿Has hecho reserva?: " + lista.getString("reserva"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoMesasPorComensales(Connection conn, int compara) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
<<<<<<< Updated upstream
	        listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE numComensales = ?;");
=======
	        listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE numComensales = ?");
>>>>>>> Stashed changes
	        listaCompleta.setInt(1, compara);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idMesa") + " ");
	            System.out.println("Numero de Comensales: " + lista.getString("numComensales"));
	            System.out.println("¿Has hecho reserva?: " + lista.getString("reserva"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoMesasPorReserva(Connection conn, String reserva) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    int reservado = 0;
	    if(reserva.equals("Si")) {
	    	reservado = 1;
	    }
	    try {
<<<<<<< Updated upstream
	        listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE reserva = ?;");
=======
	        listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE reserva = ?");
>>>>>>> Stashed changes
	        listaCompleta.setInt(1, reservado);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idMesa") + " ");
	            System.out.println("Numero de Comensales: " + lista.getString("numComensales"));
	            System.out.println("¿Has hecho reserva?: " + lista.getString("reserva"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

<<<<<<< Updated upstream
	public static void listadoFacturas(Connection conn) {
	    ResultSet lista = null;
	    PreparedStatement listaComlpeta = null;
	    try {
	        listaComlpeta = conn.prepareStatement("SELECT * FROM Facturas;");
	        lista = listaComlpeta.executeQuery();
	        while(lista.next()) {
	            System.out.println("ID: " + lista.getInt("idFactura") + " ");
	            System.out.println("ID Mesa Asociada: " + lista.getString("idMesa"));
	            System.out.println("Tipo de Pago: " + lista.getString("tipoPago"));
	            System.out.println("Importe de la Factura: " + lista.getString("Importe"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoFacturasPorId(Connection conn, int compara) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idFactura = ?;");
	        listaCompleta.setInt(1, compara);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idFactura") + " ");
	            System.out.println("ID Mesa Asociada: " + lista.getString("idMesa"));
	            System.out.println("Tipo de Pago: " + lista.getString("tipoPago"));
	            System.out.println("Importe de la Factura: " + lista.getString("Importe"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoFacturasPorIdMesa(Connection conn, int compara) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idMesa = ?;");
	        listaCompleta.setInt(1, compara);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idFactura") + " ");
	            System.out.println("ID Mesa Asociada: " + lista.getString("idMesa"));
	            System.out.println("Tipo de Pago: " + lista.getString("tipoPago"));
	            System.out.println("Importe de la Factura: " + lista.getString("Importe"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoFacturasPorTipoPago(Connection conn, String pago) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE tipoPago = ?;");
	        listaCompleta.setString(1, pago);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idFactura") + " ");
	            System.out.println("ID Mesa Asociada: " + lista.getString("idMesa"));
	            System.out.println("Tipo de Pago: " + lista.getString("tipoPago"));
	            System.out.println("Importe de la Factura: " + lista.getString("Importe"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoFacturasPorImporte(Connection conn, double precio) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE tipoPago = ?;");
	        listaCompleta.setDouble(1, precio);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idFactura") + " ");
	            System.out.println("ID Mesa Asociada: " + lista.getString("idMesa"));
	            System.out.println("Tipo de Pago: " + lista.getString("tipoPago"));
	            System.out.println("Importe de la Factura: " + lista.getString("Importe"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

=======
>>>>>>> Stashed changes
	public static void listadoPedidos(Connection conn) {
	    ResultSet lista = null;
	    PreparedStatement listaComlpeta = null;
	    try {
<<<<<<< Updated upstream
	        listaComlpeta = conn.prepareStatement("SELECT * FROM Pedidos;");
=======
	        listaComlpeta = conn.prepareStatement("SELECT * FROM Pedidos");
>>>>>>> Stashed changes
	        lista = listaComlpeta.executeQuery();
	        while(lista.next()) {
	            System.out.println("ID: " + lista.getInt("idPedido") + " ");
	            System.out.println("ID Factura Asociada: " + lista.getString("idFactura"));
	            System.out.println("ID Producto Asociada: " + lista.getString("idProducto"));
	            System.out.println("Cantidad: " + lista.getString("cantidad"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoPedidosPorId(Connection conn, int compara) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
<<<<<<< Updated upstream
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idPedido = ?;");
=======
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idPedido = ?");
>>>>>>> Stashed changes
	        listaCompleta.setInt(1, compara);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idPedido") + " ");
	            System.out.println("ID Factura Asociada: " + lista.getString("idFactura"));
	            System.out.println("ID Producto Asociada: " + lista.getString("idProducto"));
	            System.out.println("Cantidad: " + lista.getString("cantidad"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoPedidosPorIdFactura(Connection conn, int compara) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
<<<<<<< Updated upstream
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idFactura = ?;");
=======
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idFactura = ?");
>>>>>>> Stashed changes
	        listaCompleta.setInt(1, compara);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idPedido") + " ");
	            System.out.println("ID Factura Asociada: " + lista.getString("idFactura"));
	            System.out.println("ID Producto Asociada: " + lista.getString("idProducto"));
	            System.out.println("Cantidad: " + lista.getString("cantidad"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoPedidosPorIdProducto(Connection conn, int compara) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
<<<<<<< Updated upstream
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idProducto = ?;");
=======
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idProducto = ?");
>>>>>>> Stashed changes
	        listaCompleta.setInt(1, compara);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idPedido") + " ");
	            System.out.println("ID Factura Asociada: " + lista.getString("idFactura"));
	            System.out.println("ID Producto Asociada: " + lista.getString("idProducto"));
	            System.out.println("Cantidad: " + lista.getString("cantidad"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoPedidosPorCantidad(Connection conn, int cantidad) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
<<<<<<< Updated upstream
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE cantidad = ?;");
=======
	        listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE cantidad = ?");
>>>>>>> Stashed changes
	        listaCompleta.setInt(1, cantidad);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idPedido") + " ");
	            System.out.println("ID Factura Asociada: " + lista.getString("idFactura"));
	            System.out.println("ID Producto Asociada: " + lista.getString("idProducto"));
	            System.out.println("Cantidad: " + lista.getString("cantidad"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoProductos(Connection conn) {
	    ResultSet lista = null;
	    PreparedStatement listaComlpeta = null;
	    try {
<<<<<<< Updated upstream
	        listaComlpeta = conn.prepareStatement("SELECT * FROM Productos;");
=======
	        listaComlpeta = conn.prepareStatement("SELECT * FROM Productos");
>>>>>>> Stashed changes
	        lista = listaComlpeta.executeQuery();
	        while(lista.next()) {
	            System.out.println("ID: " + lista.getInt("idProducto") + " ");
	            System.out.println("Denominación: " + lista.getString("Denominacion"));
	            System.out.println("Precio: " + lista.getString("Precio"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoProductosPorId(Connection conn, int compara) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
<<<<<<< Updated upstream
	        listaCompleta = conn.prepareStatement("SELECT * FROM Productos WHERE idProducto = ?;");
=======
	        listaCompleta = conn.prepareStatement("SELECT * FROM Productos WHERE idProducto = ?");
>>>>>>> Stashed changes
	        listaCompleta.setInt(1, compara);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idProducto") + " ");
	            System.out.println("Denominación: " + lista.getString("Denominacion"));
	            System.out.println("Precio: " + lista.getString("Precio"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoProductosPorDenominacion(Connection conn, String Denominacion) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
<<<<<<< Updated upstream
	        listaCompleta = conn.prepareStatement("SELECT * FROM Productos WHERE Denominacion = ?;");
=======
	        listaCompleta = conn.prepareStatement("SELECT * FROM Productos WHERE Denominacion = ?");
>>>>>>> Stashed changes
	        listaCompleta.setString(1, Denominacion);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idProducto") + " ");
	            System.out.println("Denominación: " + lista.getString("Denominacion"));
	            System.out.println("Precio: " + lista.getString("Precio"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

	public static void listadoProductosPorPrecio(Connection conn, double precio) {
	    ResultSet lista = null;
	    PreparedStatement listaCompleta = null;
	    try {
<<<<<<< Updated upstream
	        listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE precio = ?;");
=======
	        listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE precio = ?");
>>>>>>> Stashed changes
	        listaCompleta.setDouble(1, precio);
	        lista = listaCompleta.executeQuery();
	        while(lista.next()) {
	        	System.out.println("ID: " + lista.getInt("idProducto") + " ");
	            System.out.println("Denominación: " + lista.getString("Denominacion"));
	            System.out.println("Precio: " + lista.getString("Precio"));
	            System.out.println("-----------------------------------------------");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            lista.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	}

}
