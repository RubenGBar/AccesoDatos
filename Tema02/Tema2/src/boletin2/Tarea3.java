package boletin2;
import java.io.*;

public class Tarea3 {

	public static void main(String[] args) throws IOException {
		
		String letra = leerFicheroMierdoso();
		escribe5a(letra);
		
	}
	
	public static String leerFicheroMierdoso() {
		String ruta = "src/boletin2/1letra.txt";
		RandomAccessFile file;
		int pos = 0;
		String aux = "";
		
		try {
			
			file = new RandomAccessFile(ruta, "r");
			
			while(file.getFilePointer() != file.length()) {
				file.seek(pos);
				aux = file.readLine();
			}
			
			file.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return aux;
		
	}
	
	public static void escribe5a(String letra) {
		
		char letraAChar = letra.charAt(0);
		String ruta = "src/boletin2/5a.txt";
		RandomAccessFile file;
		try {
			
			file = new RandomAccessFile(ruta, "rw");

			for (int i = 0; i < 5; i++) { 
				file.writeChar(letraAChar);
			}
			
			file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void leerByte() {
		
		String ruta = "src/boletin2/1letra.txt";
		RandomAccessFile file;
		int pos = 0;
		byte aux;
		char letra = '\0';
		
		
		try {
			
			file = new RandomAccessFile(ruta, "r");
			
			while(file.getFilePointer() != file.length()) {
				file.seek(pos);
				aux = file.readByte();
				letra = (char)aux;
			}
			
			file.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}