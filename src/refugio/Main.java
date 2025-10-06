package refugio;

import java.util.*;

public class Main {

    private static ArrayList<Animal> animales = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        System.out.println("---MENÚ---");
        do {
            System.out.println("1- Añadir animal");
            System.out.println("2- Mostrar Datos");
            System.out.println("0- Salir");
            num = sc.nextInt();
            switch (num) {
                case 1:
                    anadir();
                    break;
                case 2:
                    mostrar();
                    break;
                case 0:
                    System.out.print("FIN");
                    break;
                default:
                    System.out.println("Incorrecto - Introduce un número del menú");
            }
        } while (num != 0);

        sc.close();
    }

    private static void mostrar() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales guardados.");
        } else {
            for (Animal a : animales) {
                a.mostrarDatos();
                System.out.println();
            }
        }
    }

    private static void anadir() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.println("1- Para Perro \n2- Para Gato");
        num = sc.nextInt();
        sc.nextLine(); 

        if (num == 1) {
            System.out.println("Has escogido Perro");
            System.out.print("Introduce Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Introduce edad: ");
            int edad = sc.nextInt();
            sc.nextLine();
            System.out.print("Introduce tipo de raza: ");
            String raza = sc.nextLine();
            animales.add(new Perro(nombre, edad, raza));

        } else if (num == 2) {
            System.out.println("Has escogido Gato");
            System.out.print("Introduce Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Introduce edad: ");
            int edad = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Introduce la longitud de los bigotes: ");
            int longitudBigotes = sc.nextInt();
            animales.add(new Gato(nombre, edad, longitudBigotes));

        } else {
            System.out.println("O perro 1 o gato 2");
        }
    }
}
