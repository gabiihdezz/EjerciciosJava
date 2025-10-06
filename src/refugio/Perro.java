package refugio;

public class Perro extends Animal {

	public Perro(String nombre, int edad, String raza) {
		super(nombre, edad);
		this.raza=raza;
	}
	public String raza;
	public void ladrar(){
	System.out.print("El perro ta ladrando");	
	}
	
	@Override
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("La raza del perro es un "+ raza);
		ladrar();
	}
	
}
