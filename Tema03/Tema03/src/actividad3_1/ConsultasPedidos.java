package actividad3_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasPedidos {

	public static void listadoPedidos(Connection conn) {
        ResultSet lista = null;
        PreparedStatement listaComlpeta = null;
        try {
            listaComlpeta = conn.prepareStatement("SELECT * FROM Pedidos");
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
            listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idPedido = ?");
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
            listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idFactura = ?");
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
            listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE idProducto = ?");
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
            listaCompleta = conn.prepareStatement("SELECT * FROM Facturas WHERE cantidad = ?");
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
	
}
