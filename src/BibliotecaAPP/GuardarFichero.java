package BibliotecaAPP;

import java.io.*;
import java.util.*;

public class GuardarFichero {
	
    public static void guardarPublicaciones(Scanner sc) {
        Publicaciones a;
        String nombre = "";
        String autor = null;
        int anho;

        try (ObjectOutputStream fsal = new ObjectOutputStream(new FileOutputStream("Biblioteca.dat"))) {
            while (true) {
                System.out.print("Introduzca Nombre de libro (o 'FIN' para terminar): ");
                nombre = sc.next();
                
                if (nombre.equalsIgnoreCase("FIN")) {
                    break; // Terminar el bucle si el usuario introduce "FIN"
                }

                System.out.print("Introduzca el año: ");
                anho = sc.nextInt();
                System.out.print("Introduzca el nombre del autor: ");
                autor = sc.next();

                a = new Publicaciones(nombre, autor, anho);
                System.out.println(a.toString());
                fsal.writeObject(a);
            }
        } catch (IOException ex) {
            System.out.println("Error en la escritura del fichero: " + ex.getMessage());
        }
    }

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		guardarPublicaciones(sc);		
	}
}
