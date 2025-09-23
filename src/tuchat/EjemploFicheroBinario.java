package tuchat;

import java.io.*;

public class EjemploFicheroBinario {

	public static void main(String[] args) throws IOException {
		escribirDatos();
		leerDatos();
	}
	
    static private void escribirDatos() {
        File fich = new File("fich2.dat");

        DataOutputStream doS;
        
        int [] edades = {16,43,54,65};
        String [] nombre = {"Eu Farei", "Pedro", "Juan","Laura"};
        
        
        try {
        
        	doS = new DataOutputStream(new FileOutputStream(fich));
        
        	for(int i=0; i<4; i++) {
        		doS.writeInt(edades[i]);
        		doS.writeUTF(nombre[i]);
        	}
        	doS.close();
        	
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException ioex) {
            System.err.println("Error de escritura: " + ioex.getMessage());
        }
    }

    

    static private void leerDatos () throws IOException{
    	
		File f = new File ("fich2.dat");
        DataInputStream diS;

	    try {
	        diS = new DataInputStream(new FileInputStream(f));

	        while (true) {
	            int edad = diS.readInt();
	            String nombre = diS.readUTF();

	            System.out.println("Nombre: " + nombre + ", Edad: " + edad);
	        }

	    } catch (EOFException e) {
	    	System.out.println("Fin de fichero");
	    
	    } catch (FileNotFoundException fnfe) {
	        System.err.println("Archivo no encontrado: " + fnfe.getMessage());
	    } catch (IOException ioex) {
	        System.err.println("Error de lectura: " + ioex.getMessage());
	}
	}

	
	
	static private void escribir() {
		File f = new File ("fich2.dat");
		try {
			FileOutputStream fo = new FileOutputStream(f);
			for (int i = 0 ; i <11; i++) {
				try {
				fo.write(i);
			}
			catch (IOException e) {
				e.printStackTrace();
			}}}
		catch (FileNotFoundException e) {
			System.out.print("Error 404");
		}
		

		
		}
	
	static private void leer (){
	
		File f = new File ("fich2.dat");

		try {
			FileInputStream fi = new FileInputStream (f);
			int i ; 
			while((i=fi.read())!=-1) {
				System.out.println(i);
			}
		}
		catch (IOException e) {
			System.out.print("Error 404");
		}
		
	}
}
