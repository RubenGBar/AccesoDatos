package boletin2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tarea1 {
	
	public static void main(String[] args) {
		
		leerFichero();

	}
	
	public static void leerFichero()  {
        
        String rutaArchivo = "src/boletin2/palabras.txt";
		File fichero=new File(rutaArchivo);
		String[] palabras;
		String linea;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
			
			linea = reader.readLine();
			
			palabras = linea.split("[\\p{A-Z}]");
			
			reader.close();//cerrar fichero 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}
