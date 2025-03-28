package boletin2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tarea1 {
	
	public static void main(String[] args) {
        leeDocumento();
    }
    
    public static void leeDocumento() {
        String rutaArchivo = "src/boletin2/palabras.txt";
        String palabras[];
        String linea;

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {

            linea = reader.readLine();

            palabras = linea.split("(?=\\p{Lu})");

            for (String palabra : palabras) {
                escribeArchivo(palabra);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void escribeArchivo(String palabra) {
        String ruta = "src/boletin2/palabrasSeparadas.txt";
        BufferedWriter bw = null;
        try {
            // Abrir el archivo en modo append para no sobrescribir
            bw = new BufferedWriter(new FileWriter(ruta, true));
            bw.write(palabra + "\n");
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
