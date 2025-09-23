package BibliotecaAPP;

import java.io.*;

public class LeerFichero {
    public static void main(String[] args) {

        FileInputStream fis = null;
        ObjectInputStream fentrada = null;

        try {
            fis = new FileInputStream("Biblioteca.dat");
            fentrada = new ObjectInputStream(fis);

            Publicaciones Objalumno;
            while ((Objalumno= (Publicaciones) fentrada.readObject()) != null) {
                if (Objalumno instanceof Publicaciones) {
                    System.out.println(Objalumno.toString());
                }
            }
        } catch (EOFException e) {
            // End of file reached, do nothing
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fentrada != null) fentrada.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    
    }
