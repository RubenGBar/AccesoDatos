package actividad3_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasFacturas {

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
	
}
