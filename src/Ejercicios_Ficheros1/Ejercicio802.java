package Ejercicios_Ficheros1;

import java.io.*;
import java.util.Scanner;

public class Ejercicio802 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta para leer el archivo");
		String entrada= sc.nextLine();
		if(entrada.equals("D:\\GabrielHC\\Java\\documento\\ficherin.txt")) {
			File f = new File (entrada);
	        DataInputStream diS;

	        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                System.out.println(linea);
	            }

		    } catch (EOFException e) {
		    	System.out.println("Fin de fichero");
		    
		    } catch (FileNotFoundException fnfe) {
		        System.err.println("Archivo no encontrado: " + fnfe.getMessage());
		    } catch (IOException ioex) {
		        System.err.println("Error de lectura: " + ioex.getMessage());
		}

		}
	}

}
