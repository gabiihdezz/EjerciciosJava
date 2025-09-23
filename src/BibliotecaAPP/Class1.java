package BibliotecaAPP;

import java.util.Scanner;

public class Class1 {
    
    public static void main(String[] args) {
        GuardarFichero objetoA = new GuardarFichero();
        LeerFichero objetoB = new LeerFichero();
        Scanner sc = new Scanner(System.in);
        String nombre = null;
        String autor = null;
        int opcion = 0;
        int anho = 0;
        String[] array = new String[3];

        do {
            System.out.print("1. Añadir libro:\n"
                    + "2. Añadir revista:\n"
                    + "3. Listar todas las publicaciones:\n"
                    + "4. Buscar publicaciones por título:\n"
                    + "5. Contar cuántas publicaciones hay por año:\n"
                    + "6. [Opcional] Guardar publicaciones en fichero:\n"
                    + "7. [Opcional] Cargar publicaciones desde fichero:\n"
                    + "8. Salir.\n"
                    + "Introduzca la opción que quieras: ");
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, introduce un número válido.");
                sc.next(); // Limpiar el buffer
                continue; // Volver a mostrar el menú
            }

            switch (opcion) {
                case 1:
                    System.out.println("Añadir libro");
                    anadirL(sc, nombre, anho, autor, array);
                    break;
                case 2:
                    System.out.println("Añadir revista: ");
                    anadirR(sc, nombre, anho, autor, array);
                    break;
                case 3:
                    System.out.println("Listar todas las publicaciones: ");
                    listar(sc, nombre, array);
                    break;
                case 4:
                    System.out.println("Buscar Nombre: ");
                    buscar(sc, nombre, array);
                    break;
                case 5:
                    System.out.println("Listar por año: ");
                    listarA(sc, anho, array);
                    break;
                case 6:
                    System.out.println("Guardando en fichero: ");
                    try {
                        GuardarFichero.main(args);
                    } catch (Exception e) {
                        System.out.println("Se produjo un error: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Cargando publicaciones desde fichero: ");
                    try {
                        LeerFichero.main(args);
                    } catch (Exception e) {
                        System.out.println("Se produjo un error: " + e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Ha acabado su programa");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 8);

        sc.close(); // Cerrar el scanner al final
    }

    private static void listarA(Scanner sc, int anho, String[] array) {
        boolean encontrado = false;
        System.out.print("Introduzca Año: ");
        anho = sc.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(String.valueOf(anho))) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("El año '" + anho + "' se encuentra en la lista.");
            System.out.println("Titulo | Año | Autor");
            for (String item : array) {
                if (item != null) {
                    System.out.print(item + " | ");
                }
            }
            System.out.println();
        } else {
            System.out.println("El año '" + anho + "' NO se encuentra en la lista.");
        }
    }

    private static void listar(Scanner sc, String nombre, String[] array) {
        System.out.println("Titulo | Año | Autor");
        for (String item : array) {
            if (item != null) {
                System.out.print(item + " | ");
            }
        }
        System.out.println();
    }

    private static void buscar(Scanner sc, String nombre, String[] array) {
        boolean encontrado = false;
        System.out.print("Introduzca Nombre: ");
        nombre = sc.next();
        for (String n : array) {
            if (n != null && n.equalsIgnoreCase(nombre)) { 
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("El nombre '" + nombre + "' se encuentra en la lista.");
        } else {
            System.out.println("El nombre '" + nombre + "' NO se encuentra en la lista.");
        }
    }

    private static void anadirL(Scanner sc, String nombre, int anho, String autor, String[] array) {
        System.out.print("Introduzca Nombre de libro: ");
        nombre = sc.next();
        System.out.print("Introduzca el año: ");
        anho = sc.nextInt();
        System.out.print("Introduzca el nombre del autor: ");
        autor = sc.next();
        array[0] = nombre; 
        array[1] = Integer.toString(anho);
        array[2] = autor; 
    }
    
    private static void anadirR(Scanner sc, String nombre, int anho, String autor, String[] array) {
        System.out.print("Introduzca Nombre de la revista: ");
        nombre = sc.next();
        System.out.print("Introduzca el año: ");
        anho = sc.nextInt();
        System.out.print("Introduzca el nombre del autor: ");
        autor = sc.next();
        array[0] = nombre; 
        array[1] = Integer.toString(anho);
        array[2] = autor; 
    }
}
