package Ejercicios_Ficheros1;

import java.io.Serializable;

public class Ej807 implements Serializable{

	private int numeros;

	public int getNumeros() {
		return numeros;
	}

	public void setNumeros(int numeros) {
		this.numeros = numeros;
	}

	public Ej807(int numeros) {
		super();
		this.numeros = numeros;
	}

	public Ej807() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Numero=" + numeros;
	}
	
}
