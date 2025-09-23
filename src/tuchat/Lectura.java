package tuchat;

import java.io.*;
import java.util.*;

public class Lectura {

	public static void main(String[] args) throws IOException {
		escribirBuffer();
		leerBuffer();
		/*String texto = new String();
		try {
		    FileReader fr = new FileReader("archivo.txt");
		    BufferedReader entrada = new BufferedReader(fr);
		    String s;
		    while ((s = entrada.readLine()) != null)
		        texto += s;
		    entrada.close();
		}
		catch (FileNotFoundException fnfex) {
		    System.out.println("Archivo no encontrado: " + fnfex);
		}
		catch (IOException ioex) {
		    System.out.println("Error desconocido encontrado: ");

		}*/
		
		
	}
	
	static private void escribirFich() throws IOException {
		File fich = new File("fichero.txt");
		String cadena = "A tu lado todo era diferente";
		try {
		FileWriter f = new FileWriter(fich);
		char [] cad = cadena.toCharArray();
		for(int i = 0 ; i<cad.length;i++) {
			f.write(cad[i]);
		}
		f.close();
	}
		catch (IOException e) {
			System.out.print("Error 404");
		}
	}
	
	static private void leerFich() throws IOException {
		File fich = new File("fichero.txt");
		try { 
			FileReader f = new FileReader (fich);
			int i;
			while ((i = f.read())!=-1) {
				System.out.print((char)i);
			}
			System.out.println();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static private void leerBuffer() {
		File fich = new File ("fichero.txt");
		try {
			BufferedReader br = new BufferedReader((new FileReader(fich)));
			String linea; 
			while ((linea = br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
	}
		}
	
	static private void escribirBuffer (){
		File fich = new File("fichero.txt");
		String cadena = "El verano pasa rapido";
		char [] cad=cadena.toCharArray();
		try {
			BufferedWriter bw = new BufferedWriter (new FileWriter(fich));
			for(int i = 0 ; i<cad.length; i++) {
				bw.write(cad[i]);
				bw.newLine();
			}
			bw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
