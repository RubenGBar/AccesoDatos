package boletin1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tarea2 {
	
	public static void main(String[] args) {
		
		String username = System.getProperty("user.name");
		String directorio = "C:\\Users\\" + username + "\\";
		
		
		try {			
			
			leerDocumento(directorio, username);
			
		}catch(Exception e) {
			
			System.out.println("Error: " + e.getMessage());
			
		}
		
		
	}
	
	private static void leerDocumento(String directorio, String usuario) {
		String ruta = "src/boletin1/carpetas.txt";
		String rutaCompleta = "";
        String line = "";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
        
            while ((line = reader.readLine()) != null) {
                
            	rutaCompleta = directorio + line;
            	crearFichero(rutaCompleta, usuario);
                
            }
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	
	private static void crearFichero(String ruta, String usuario) {
    	
		String rutaCompleta = ruta + "\\index.html";
		String carpetaPadre = "";
		
		try {
			   
			   File fichero = new File(rutaCompleta);
			   carpetaPadre = fichero.getParentFile().getName();
			   
			   if (fichero.createNewFile()) {			   
				   System.out.println("El fichero se ha creado correctamente");
			   }
			   else {				   
				   System.out.println("No se ha podido crear el fichero");
			   }
			   
			} catch (Exception e){
			   e.getMessage();
			}
		escribeArchivo(rutaCompleta, carpetaPadre, usuario, ruta);
 
    }
	
	public static void escribeArchivo(String ruta, String carpeta, String usuario, String rutaNoCompleta) {
		String doc = "<html>\r\n"
				+ "   <head>\r\n"
				+ "      <title>" + carpeta + "</title>\r\n"
				+ "   </head>\r\n"
				+ "   <body>\r\n"
				+ "      <h1>[" + rutaNoCompleta + "]</h1>\r\n"
				+ "      <h3>Autor:" + usuario + "</h3>\r\n"
				+ "   </body>\r\n"
				+ "</html>";
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter (new FileWriter (ruta));
			
			bw.write(doc);
		
		} catch (IOException e) {
			System.out.println("Ha habido algún error");
		}finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				System.out.println("Ha habido algún error");
			}
		}
		
	}
	
}
