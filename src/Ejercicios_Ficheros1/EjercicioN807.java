package Ejercicios_Ficheros1;

import java.io.*;

public class EjercicioN807 {

	public static void main(String[] args) throws IOException {
		/*807.- Crea un programa en Java que lea un fichero de datos numéricos enteros 
		(datos807.dat). Independientemente del número de datos numéricos enteros grabados, 
		solo se leerán y procesarán los 20 primeros. Estos se deben leer e introducir en un array 
		de 20 elementos enteros previamente declarado. Ordenar este array según uno de los 
		métodos de ordenación vistos y mostralo por pantalla. A continuación, grabar un nuevo 
		fichero: 
		Opción A) con los 20 elementos numéricos enteros en formato datos binarios. 
		Opción B) a través de serialización, grabando el objeto array.*/
		
			escribirObjeto1();
			leerObjeto1();
		}
		
		private static void escribirObjeto1() throws IOException {
			int [] numeros= {23,33,42,13, 41, 10, 14, 34, 35,99, 12, 123, 54, 41 ,1, 44, 142, 88};
			
			File f = new File ("datos807.dat");
			
			FileOutputStream fo;
			
			fo = new FileOutputStream(f);
			
			ObjectOutputStream ooS = new ObjectOutputStream(fo);
			
			for(int i = 0; i<4; i++) {
				Ej807 ej = new Ej807 (numeros[i]);
				ooS.writeObject(ej);
			}
			
			ooS.close();
		}

		private static void leerObjeto1() {
			File f = new File ("datos807.dat");
			FileInputStream fis;
			try {
			    fis = new FileInputStream("ficheroObjetos.dat");
			    ObjectInputStream ois = new ObjectInputStream(fis);
			    try {
			        while(true) {
			        	Ej807 ej = (Ej807)ois.readObject();
			            System.out.println(ej.toString());
			        }
			    }catch (EOFException e) {
			        System.out.println("Fin de fichero");
			    }catch (ClassNotFoundException e) {
			        e.printStackTrace();
			    }
			    ois.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
		
	}

}
