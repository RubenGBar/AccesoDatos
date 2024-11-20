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
		
		do {
			
			menu();
			System.out.println("Elija una opción");
			opc = sc.nextInt();
			switch(opc) {
			
				case 1 -> {
					listadoEdad();
				}
				case 2 -> {
					listadoApellidos();
				}
				case 3 -> {
					listadoEdad30();
				}
				case 4 ->{
					listadoJApellidos();
				}
				case 5 ->{
					listadoNombreApellidoAEdadMenosAMas();
				}
				case 6 ->{
					edadMedia();
				}
				case 7 ->{
					listadoApellidoOlOMa();
				}
				case 8 ->{
					listadoAdultos();
				}
				case 9 ->{
					listadoViejos();
				}
				case 10 ->{
					creaColumnaActualizar();
				}
				case 11 ->{
					actualizaLaboral();
				}
				case 12 ->{
					listadoTodo();
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
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
			
			while(lista.next()) {
				System.out.println("ID: " + lista.getInt("id") + " ");
				System.out.println("Nombre: " + lista.getString("nombre"));
				System.out.println("Apellido: " + lista.getString("apellido"));
				System.out.println("Edad: " + lista.getInt("edad"));
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
	
	public static void listadoApellidos() {
		
		ResultSet lista = null;
		
		try {
			PreparedStatement listaEdad = conn.prepareStatement("SELECT nombre, apellido FROM Persona ORDER BY apellido");
			lista = listaEdad.executeQuery();
			
			while(lista.next()) {
				System.out.println("Nombre: " + lista.getString("nombre"));
				System.out.println("Apellido: " + lista.getString("apellido"));
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
	
	public static void listadoEdad30() {
		
		ResultSet lista = null;
		
		try {
			PreparedStatement listaEdad = conn.prepareStatement("SELECT nombre, apellido FROM Persona Where edad >= 30");
			lista = listaEdad.executeQuery();
			
			while(lista.next()) {
				System.out.println("Nombre: " + lista.getString("nombre"));
				System.out.println("Apellido: " + lista.getString("apellido"));
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
	
	public static void listadoJApellidos() {
		
		ResultSet lista = null;
		
		try {
			PreparedStatement listaEdad = conn.prepareStatement("SELECT nombre FROM Persona Where nombre like 'J%' ORDER BY apellido");
			lista = listaEdad.executeQuery();
			
			while(lista.next()) {
				System.out.println("Nombre: " + lista.getString("nombre"));
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
	
	public static void listadoNombreApellidoAEdadMenosAMas() {
		
		ResultSet lista = null;
		
		try {
			PreparedStatement listaEdad = conn.prepareStatement("SELECT nombre, edad FROM Persona Where nombre like 'C%' AND apellido like 'A%' ORDER BY edad desc");
			lista = listaEdad.executeQuery();
			
			while(lista.next()) {
				System.out.println("Nombre: " + lista.getString("nombre"));
				System.out.println("Edad: " + lista.getString("edad"));
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
	
	public static void edadMedia() {
		
		ResultSet lista = null;
		
		try {
			PreparedStatement listaEdad = conn.prepareStatement("SELECT AVG(edad) as edadMedia FROM Persona");
			lista = listaEdad.executeQuery();
			
			while(lista.next()) {
				System.out.println("Edad Media: " + lista.getInt("edadMedia"));
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
	
	public static void listadoApellidoOlOMa() {
		
		ResultSet lista = null;
		
		try {
			PreparedStatement listaEdad = conn.prepareStatement("SELECT nombre, apellido FROM Persona Where apellido like '%ol%' or apellido like '%ma%'");
			lista = listaEdad.executeQuery();
			
			while(lista.next()) {
				System.out.println("Nombre: " + lista.getString("nombre"));
				System.out.println("Apellido: " + lista.getString("apellido"));
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
	
	public static void listadoAdultos() {
		
		ResultSet lista = null;
		
		try {
			PreparedStatement listaEdad = conn.prepareStatement("SELECT nombre, apellido, edad FROM Persona Where edad >= 24 and edad <= 32");
			lista = listaEdad.executeQuery();
			
			while(lista.next()) {
				System.out.println("Nombre: " + lista.getString("nombre"));
				System.out.println("Apellido: " + lista.getString("apellido"));
				System.out.println("Edad: " + lista.getInt("edad"));
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
	
	public static void listadoViejos() {
		
		ResultSet lista = null;
		
		try {
			PreparedStatement listaEdad = conn.prepareStatement("SELECT nombre, apellido, edad FROM Persona Where edad >= 65");
			lista = listaEdad.executeQuery();
			
			while(lista.next()) {
				System.out.println("Nombre: " + lista.getString("nombre"));
				System.out.println("Apellido: " + lista.getString("apellido"));
				System.out.println("Edad: " + lista.getInt("edad"));
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
	
	public static void creaColumnaActualizar() {
	    ResultSet lista = null;
	    PreparedStatement listaEdad = null;
	    PreparedStatement alterarTabla = null;

	    try {
	        String alterTableQuery = "ALTER TABLE Persona ADD COLUMN laboral VARCHAR(20)";
	        alterarTabla = conn.prepareStatement(alterTableQuery);
	        
	        alterarTabla.executeUpdate();

	        System.out.println("Columna 'laboral' creada correctamente.");
	    } catch (SQLException e) {
	        System.out.println("Error SQL: " + e.getMessage());
	    } finally {
	        try {
	            if (lista != null) lista.close();
	            if (listaEdad != null) listaEdad.close();
	            if (alterarTabla != null) alterarTabla.close();
	        } catch (SQLException e) {
	            System.out.println("Error al cerrar recursos: " + e.getMessage());
	        }
	    }
	}
	
    public static void actualizaLaboral() {
        ResultSet lista = null;
        PreparedStatement listaEdad = null;
        PreparedStatement actualizar = null;

        try {
            String selectQuery = "SELECT id, edad FROM Persona";
            listaEdad = conn.prepareStatement(selectQuery);
            lista = listaEdad.executeQuery();

            String actualizaQuery = "UPDATE Persona SET laboral = ? WHERE id = ?";
            actualizar = conn.prepareStatement(actualizaQuery);

            while (lista.next()) {
                int id = lista.getInt("id");
                int edad = lista.getInt("edad");
                String laboral = "";

                if (edad < 18) {
                    laboral = "estudiante";
                } else if (edad > 65) {
                    laboral = "jubilado";
                } else if (edad % 2 != 0) {
                    laboral = "parado";
                } else {
                    laboral = "ocupado";
                }

                actualizar.setString(1, laboral);
                actualizar.setInt(2, id);

                actualizar.executeUpdate();
            }

            System.out.println("Columna 'laboral' actualizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } finally {
            try {
                if (lista != null) lista.close();
                if (listaEdad != null) listaEdad.close();
                if (actualizar != null) actualizar.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
	
	
	public static void listadoTodo() {
		
		ResultSet lista = null;
		
		try {
			PreparedStatement listaEdad = conn.prepareStatement("SELECT * FROM Persona");
			lista = listaEdad.executeQuery();
			
			while(lista.next()) {
				System.out.println("ID: " + lista.getInt("id") + " ");
				System.out.println("Nombre: " + lista.getString("nombre"));
				System.out.println("Apellido: " + lista.getString("apellido"));
				System.out.println("Edad: " + lista.getInt("edad"));
				System.out.println("Laboral: " + lista.getString("laboral"));
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
		System.out.println("2. Listado por Apellido");
		System.out.println("3. Listado de mayores de 30");
		System.out.println("4. Listado de nombres que empiezan por J");
		System.out.println("5. Listado de nombres que empiezan por C y apellidos por A");
		System.out.println("6. Edad Media");
		System.out.println("7. Listado de apellidos que contienen ol o ma");
		System.out.println("8. Listado de adultos");
		System.out.println("9. Listado de viejos");
		System.out.println("10. Añadir columna Laboral");
		System.out.println("11. Actualiza columna Laboral");
		System.out.println("12. Listado todo");
		System.out.println("0. Salir");
	}
	
}
