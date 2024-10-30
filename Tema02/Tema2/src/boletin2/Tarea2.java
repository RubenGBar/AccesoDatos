package boletin2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Tarea2 {
	
	public static void main(String[] args) {
        leeDocumento();
    }
    
    public static void leeDocumento() {
        String rutaArchivo = "src/boletin2/palabrasSeparadas.txt";
        ArrayList <String> palabras = new ArrayList<>();
        String linea;
        int contador = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            
            while((linea = reader.readLine()) != null) {
            	palabras.add(linea);
            	contador++;
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Collections.sort(palabras);
        escribeArchivo(palabras);
        
    }
    
    public static void escribeArchivo(ArrayList <String> palabras) {
        String ruta = "src/boletin2/palabrasOrdenadas.txt";
        BufferedWriter bw = null;
        try {
            // Abrir el archivo en modo append para no sobrescribir
            bw = new BufferedWriter(new FileWriter(ruta, true));
            
            for(String palabra: palabras) {
            	bw.write(palabra + "\n");
            }
            
        } catch (IOException e) {
            System.out.println("Ha habido algún error");
        } finally {
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Ha habido algún error al cerrar el archivo");
            }
        }

    }
	
}
