package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pruebas {
	
	static Connection conn = null;
	
	public static void main(String[] args) {
		
		int opc = 0;
		Scanner sc = new Scanner(System.in);
		
		conectar();
		menu();
		System.out.println("Elija una opción");
		opc = sc.nextInt();
		switch(opc) {
		
			case 1 -> {
				listadoEdad();
			}
			default ->{
				System.out.println("No se ha elegido una opción correcta");
			}
			
		}
		
	}

	public static void conectar() {
		String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_rgarcia";
		String user = "rgarcia";
		String password = "12345";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void listadoEdad() {
		
		ResultSet lista = null;
		
		try {
			PreparedStatement listaEdad = conn.prepareStatement("SELECT * FROM Persona ORDER BY edad");
			lista = listaEdad.executeQuery();
			int rowCount = 0;
			
			while(lista.next()) {
				rowCount++;
				System.out.println("ID: " + lista.getInt("id") + " ");
				System.out.println("ID: " + lista.getString("nombre"));
				System.out.println("ID: " + lista.getString("apellido"));
				System.out.println("ID: " + lista.getInt("edad"));
				System.out.println("-----------------------------------------------");
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				lista.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
	}
	
	public static void menu() {
		System.out.println(" --------------");
		System.out.println("|     Menú     |");
		System.out.println(" --------------");
		System.out.println("1. Listado por Edad");
	}
	
}