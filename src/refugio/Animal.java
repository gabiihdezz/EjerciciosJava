package refugio;

public class Animal {

	public String nombre;
	public int edad;

	public Animal(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	public void mostrarDatos() {
		System.out.println("Animal: "+"N:" + nombre + ", edad=" + edad + " años");
	}
	
}
