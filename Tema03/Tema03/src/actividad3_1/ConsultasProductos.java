package actividad3_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasProductos {
	
	public static void listadoProductos(Connection conn) {
        ResultSet lista = null;
        PreparedStatement listaComlpeta = null;
        try {
            listaComlpeta = conn.prepareStatement("SELECT * FROM Productos");
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
            listaCompleta = conn.prepareStatement("SELECT * FROM Productos WHERE idProducto = ?");
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
            listaCompleta = conn.prepareStatement("SELECT * FROM Productos WHERE Denominacion = ?");
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
            listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE precio = ?");
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
