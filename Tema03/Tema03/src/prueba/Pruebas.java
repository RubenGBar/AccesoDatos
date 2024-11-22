package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pruebas {
	
	static Connection conn = null;
	
	/*
	 * Me conecto con la base de datos y en un bucle se llaman a las diferentes consultas hasta que se salga
	 */
	public static void main(String[] args) {
		
		int opc = 0;
		int edadMin = 0;
		int edadMax = 0;
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
					creaColumnaLaboral();
				}
				case 11 ->{
					actualizaLaboral();
				}
				case 12 ->{
					listadoTodo();
				}
				case 13 ->{
					
					System.out.println("Introduzca una edad mínima");
					edadMin = sc.nextInt();
					
					System.out.println("Introduzca una edad máxima");
					edadMax = sc.nextInt();
					
					listadoPorRangoDeEdad(edadMin, edadMax);
					
				}
				case 14 ->{
					edadPorMinMaxMed();
				}
				case 0 ->{
					
				}
				default ->{
					System.out.println("No se ha elegido una opción correcta");
				}
				
			}
			
		} while(opc != 0);
		
	}
	
	/*
	 * Conexión con la base de datos
	 */
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
	
	/*
	 * 1. Listado ordenado por edad
	 */
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
	
	/*
	 * 2. Listado de los nombres y apellidos ordenados por apellido
	 */
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
	
	/*
	 * 3. Listado de nombres y apellidos de más de 30 años
	 */
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
	
	/*
	 * 4. Listado de los nombres que comiencen por "J" ordenados por apellido
	 */
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
	
	/*
	 * 5. Listado de los nombres que comiencen por "C" y los apellidos por "A" ordenados por edad de mayor a menor
	 */
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
	
	/*
	 * 6. Media de edad de la muestra
	 */
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
	
	/*
	 * 7. Listado de los apellidos que contengan las letras "oh" o las letras "ma" (si el resultado fuera nulo, cambiar las letras)
	 */
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
	
	/*
	 * 8. Listado de las personas en la franja de edad comprendida entre los 24 y los 32 años
	 */
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
	
	/*
	 * 9. Listado de las personas mayores de 65 años
	 */
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
	
	/*
	 * 10. Crea una columna denominada "laboral" que contendrá los siguientes valores: estudiante, ocupado, parado, jubilado
	 */
	public static void creaColumnaLaboral() {
	    ResultSet lista = null;
	    PreparedStatement listaEdad = null;
	    PreparedStatement alterarTabla = null;
        PreparedStatement agregarRestriccion = null;

	    try {
	        String alterTableQuery = "ALTER TABLE Persona ADD COLUMN laboral VARCHAR(20)";
	        alterarTabla = conn.prepareStatement(alterTableQuery);
	        
	        alterarTabla.executeUpdate();
	        
	        String agregarCheckSQL = "ALTER TABLE Persona ADD CONSTRAINT chk_laboral CHECK (laboral IN ('estudiante', 'ocupado', 'parado', 'jubilado'))";
            agregarRestriccion = conn.prepareStatement(agregarCheckSQL);
            agregarRestriccion.executeUpdate();
	        
	        System.out.println("Columna 'laboral' creada correctamente.");
	    } catch (SQLException e) {
	        System.out.println("Error SQL: " + e.getMessage());
	    } finally {
	        try {
	            if (lista != null) lista.close();
	            if (listaEdad != null) listaEdad.close();
	            if (alterarTabla != null) alterarTabla.close();
                if (agregarRestriccion != null) agregarRestriccion.close();
	        } catch (SQLException e) {
	            System.out.println("Error al cerrar recursos: " + e.getMessage());
	        }
	    }
	}
	
	/*
	 * 11. Actualiza la columna laboral con el siguiente criterio:
	 *		- Los menores de 18 son estudiantes
	 *		- Los mayores de 65 son jubilados
	 *		- Los de edad impar, que no pertenezcan a los colectivos anteriores, están parados
	 *		- El resto, ocupados
	 */
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

                if (edad <= 18) {
                    laboral = "estudiante";
                } else if (edad >= 65) {
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
	/*
	 * Consulta extra: consulta para ver registror por una edad pasada por el usuario
	 */
    public static void listadoPorRangoDeEdad(int edadMin, int edadMax) {
        ResultSet lista = null;

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT nombre, apellido, edad FROM Persona WHERE edad BETWEEN ? AND ?");
            stmt.setInt(1, edadMin);
            stmt.setInt(2, edadMax);
            lista = stmt.executeQuery();

            while (lista.next()) {
                System.out.println("Nombre: " + lista.getString("nombre"));
                System.out.println("Apellido: " + lista.getString("apellido"));
                System.out.println("Edad: " + lista.getInt("edad"));
                System.out.println("-----------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (lista != null) lista.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    /*
     * Consulta extra de edad máxima, mínima y promedio por apellido
     */
    public static void edadPorMinMaxMed() {
        ResultSet lista = null;

        try {
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT nombre, MIN(edad) AS edadMinima, MAX(edad) AS edadMaxima, AVG(edad) AS edadPromedio FROM Persona GROUP BY nombre"
            );
            lista = stmt.executeQuery();

            while (lista.next()) {
                System.out.println("Nombre: " + lista.getString("nombre"));
                System.out.println("Edad Mínima: " + lista.getInt("edadMinima"));
                System.out.println("Edad Máxima: " + lista.getInt("edadMaxima"));
                System.out.println("Edad Promedio: " + lista.getDouble("edadPromedio"));
                System.out.println("-----------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (lista != null) lista.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
	/*
	 * Consulta extra para revisar todos los campos
	 */
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
	
	/*
	 * Menú a imprimir
	 */
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
		System.out.println("13. Listado por edad específica");
		System.out.println("14. Listado por edad Min, Max y Media");
		System.out.println("0. Salir");
	}
	
}
