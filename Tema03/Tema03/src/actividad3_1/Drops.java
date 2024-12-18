package actividad3_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Drops {
	
	public static void eliminadoTablaMesas(Connection conn) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres dropearlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DROP TABLE IF EXISTS Mesas;");
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar porque porque hay campos asociados a una o varias facturas");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	        	System.out.println("No se ha podido eliminar porque porque hay campos asociados a una o varias facturas");
	        }
	    }
	}
	
	public static void eliminadoTablaProductos(Connection conn) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres dropearlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DROP TABLE IF EXISTS Productos;");
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar porque porque hay campos asociados a uno o varias pedidos");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	        	System.out.println("No se ha podido eliminar porque porque hay campos asociados a uno o varias pedidos");
	        }
	    }
	}
	
	public static void eliminadoTablaFacturas(Connection conn) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres dropearlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DROP TABLE IF EXISTS Facturas;");
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar porque porque hay campos asociados a uno o varias pedidos");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	        	System.out.println("No se ha podido eliminar porque porque hay campos asociados a uno o varias pedidos");
	        }
	    }
	}
	
	public static void eliminadoTablaPedidos(Connection conn) {
	    PreparedStatement query = null;
	    String borrar = "";
	    
	    try {
	    	
	    	Transaccion.empezarTransaccion(conn);
	    	
	    	System.out.println("¿Estás seguro que quieres dropearlo?");
	    	borrar = CRUD.sc.nextLine();
	    	
	    	if(borrar.equalsIgnoreCase(borrar)) {
	    		query = conn.prepareStatement("DROP TABLE IF EXISTS Pedidos;");
		        query.executeUpdate();
		        
		        Transaccion.confirmarTransaccion(conn);
		        
		        System.out.println("Borrado correctamente");
		        
	    	}else {
	    		
	    		Transaccion.cancelarTransaccion(conn);
	    		
	    		System.out.println("No se ha borrado");
	    		
	    	}
	        
	    } catch (SQLException e) {
	        System.out.println("No se ha podido eliminar");
	    } finally {
	        try {
	            query.close();
	        } catch (SQLException e) {
	        	System.out.println("No se ha podido eliminar");
	        }
	    }
	}

}
