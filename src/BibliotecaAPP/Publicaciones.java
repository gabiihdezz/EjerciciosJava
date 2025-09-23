package BibliotecaAPP;

import java.io.Serializable;

public class Publicaciones implements Serializable {
    private String nombre;
    private String autor;
    private int anho;

    public Publicaciones(String nombre, String autor, int anho) {
        this.nombre = nombre;
        this.autor = autor;
        this.anho = anho;
    }

    @Override
    public String toString() {
        return "Publicaciones{" +
                "nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", anho=" + anho +
                '}';
    }
}
