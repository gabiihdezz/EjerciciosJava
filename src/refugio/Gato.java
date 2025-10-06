package refugio;

public class Gato extends Animal{

	public int longitudBigotes;
	public Gato(String nombre, int edad, int longitudBigotes) {
		super(nombre, edad);
		this.longitudBigotes=longitudBigotes;
	}
	
	public void maullar() {
		System.out.print("Mera Miau");
	}
	@Override
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Longitud de bigotes : "+ longitudBigotes + " mm");
		maullar();
		System.out.println();
	}

}
