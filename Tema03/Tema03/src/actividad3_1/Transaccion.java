package actividad3_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaccion {
	
	public static void empezarTransaccion(Connection conn) {
		
	    try {
	    	
	    	PreparedStatement query = conn.prepareStatement("START TRANSACTION;");
	    	query.executeUpdate();
	    	
	    	query.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } 
		
	}
	
	public static void confirmarTransaccion(Connection conn) {
		
		try {
	    	
	    	PreparedStatement query = conn.prepareStatement("COMMIT;");
	    	query.executeUpdate();
	    	
	    	query.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
		
	}
	
	public static void cancelarTransaccion(Connection conn) {
		
		try {
	    	
	    	PreparedStatement query = conn.prepareStatement("ROLLBACK;");
	    	query.executeUpdate();
	    	
	    	query.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
		
	}

}
