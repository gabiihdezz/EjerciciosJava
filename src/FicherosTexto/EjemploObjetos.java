package FicherosTexto;

import java.io.*;

public class EjemploObjetos {

	public static void main(String[] args) throws IOException {
		escribirObjeto();
		leerObjeto();
	}
	
	private static void escribirObjeto() throws IOException {
		String [] nombre = {"Sergio", "Pedro", "Juan", "Otero"};
		int [] edades= {23,33,42,13};
		
		File f = new File ("ficheroObjetos.dat");
		
		FileOutputStream fo;
		
		fo = new FileOutputStream(f);
		
		ObjectOutputStream ooS = new ObjectOutputStream(fo);
		
		for(int i = 0; i<4; i++) {
			Persona p = new Persona (nombre[i], edades[i]);
			ooS.writeObject(p);
		}
		
		ooS.close();
	}

	private static void leerObjeto() {
		File f = new File ("ficheroObjetos.dat");
		FileInputStream fis;
		try {
		    fis = new FileInputStream("ficheroObjetos.dat");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    try {
		        while(true) {
		            Persona p = (Persona)ois.readObject();
		            System.out.println(p.toString());
		        }
		    }catch (EOFException e) {
		        System.out.println("Fin de fichero");
		    }catch (ClassNotFoundException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		    ois.close();
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	}

}
