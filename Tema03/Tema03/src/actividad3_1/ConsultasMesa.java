package actividad3_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasMesa {
	
	 public static void listadoMesas(Connection conn) {
	        ResultSet lista = null;
	        PreparedStatement listaComlpeta = null;
	        try {
	            listaComlpeta = conn.prepareStatement("SELECT * FROM Mesas");
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
	            listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE idMesa = ?");
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
	            listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE numComensales = ?");
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
	            listaCompleta = conn.prepareStatement("SELECT * FROM Mesas WHERE reserva = ?");
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

}
