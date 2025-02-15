package boletin1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tarea1 {
	
	private static String PATH_PREFIX = "../../carpetas/";
	
	public static void main(String[] args) {
		
		try {
			
			String directorio = "C:\\Users\\rgarcia\\";
			
			
			leerDocumento(directorio);
			
			
		}catch(Exception e) {
			
			System.out.println("Error: " + e.getMessage());
			
		}
		
		
	}

    private static void leerDocumento(String directorio) {
        String ruta = "src/boletin1/carpetas.txt";
        String line = "";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {

            while ((line = reader.readLine()) != null) {
                
    			if(crearDirectorio(directorio, line)) {
    				
    				System.out.println("Se ha creado el directorio: " + directorio);
    				
    			} else {
    				
    				System.out.println("No se ha creado el directorio: " + directorio);
    				
    			}
                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	
    private static boolean crearDirectorio(String directorio, String linea) {
    	
    	return  (new File(directorio+linea)).mkdir();
 
    }
    
}
