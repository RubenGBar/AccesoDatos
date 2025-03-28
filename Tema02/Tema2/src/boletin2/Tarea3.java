package boletin2;
import java.io.*;

public class Tarea3 {

	public static void main(String[] args) throws IOException {
		
		/* String letra = leerFicheroMierdoso();
		escribe5a(letra); */
		
		String letras = leerFichero3();
		escribeFichero3(letras);
		
		/*
		 * No sé cómo hacer el tercer apartado
		 * */
		
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
	
	public static String leerFichero2() {
		
		String ruta = "src/boletin2/5letras.txt";
		RandomAccessFile file;
		int pos = 0;
		byte aux;
		char letra = '\0';
		String letras = "";
		
		try {
			
			file = new RandomAccessFile(ruta, "r");
			
			while(file.getFilePointer() != file.length()) {
				file.seek(pos);
				aux = file.readByte();
				letra = (char)aux;
				letras += letra;
				pos++;
			}
			
			file.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		letras = letras.replace("\n", "");
		
		return letras;
		
	}
	
	public static void escribeFichero2(String letras) {
		
		char letra;
		String ruta = "src/boletin2/5letrasreves.txt";
		RandomAccessFile file;
		int fin = letras.length();
		
		try {
			
			file = new RandomAccessFile(ruta, "rw");

			for (int i = 0; i < fin; i++) {
				if(letras.charAt(i) != '\n' && letras.charAt(i) != '\r') {
					letra = letras.charAt(fin - i - 1);
					file.writeChar(letra);
					file.writeChar('\n');
				}
			}
			
			file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static String leerFichero3() {
		
		String ruta = "src/boletin2/a1e5.txt";
		RandomAccessFile file;
		int pos = 0;
		byte aux;
		char letra = '\0';
		String letras = "";
		
		try {
			
			file = new RandomAccessFile(ruta, "r");
			
			while(file.getFilePointer() != file.length()) {
				file.seek(pos);
				aux = file.readByte();
				letra = (char)aux;
				letras += letra;
				pos++;
			}
			
			file.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		letras = letras.replace("\n", "");
		
		return letras;
		
	}
	
	public static void escribeFichero3(String letras) {
		
		char letra;
		String ruta = "src/boletin2/e5a1.txt";
		RandomAccessFile file;
		int fin = letras.length();
		
		try {
			
			file = new RandomAccessFile(ruta, "rw");

			for (int i = 0; i < fin; i++) {
				if(letras.charAt(i) != '\n' && letras.charAt(i) != '\r') {
					letra = letras.charAt(fin - i - 1);
					file.writeChar(letra);
					file.writeChar('\n');
				}
			}
			
			file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
