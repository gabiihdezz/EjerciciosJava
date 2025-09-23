package Ejercicios_Ficheros1;

import java.io.*;
import java.util.*;

public class Ejercicio801 {

	/*801.- Codificar un programa en lenguaje Java que realice unos cálculos estadísticos sobre las 
	edades de los alumnos matriculados en un ciclo de formación profesional al principio de curso. El 
	número de alumnos no está definido, pero las edades de cada uno de ellos están grabadas en un 
	fichero llamado “estadística.dat”, que se proporciona, grabado con flujos de bytes. 
	Los cálculos estadísticos a medir y a mostrar al final del proceso por pantalla son: 
	• Número de alumnos procesados. 
	• Media aritmética de las edades del grupo. 
	• Edad del alumno/a más joven. 
	• Edad del alumno/a más viejo. 
	• Número de alumnos/as menores de edad. 
	• Desviación estándar de las edades del grupo. 
	La desviación estándar se calcula fácilmente: Es la raíz cuadrada de la media de las diferencias con la 
	media elevadas al cuadrado. 
	La manera de calcularla es fácil siguiendo estos pasos: 
	1. Calcula la media. 
	2. Ahora, por cada número resta la media y eleva el resultado al cuadrado (la diferencia 
	elevada al cuadrado). 
	3. Ahora calcula la media de esas diferencias al cuadrado. 
	4. Se calcula la raíz cuadrada del resultado anterior.
	La desviación estándar será siempre un valor positivo o cero, en el caso de que las puntuaciones sean 
	iguales. 
	Cuanta más pequeña sea la desviación estándar mayor será la concentración de datos alrededor de la 
	media, luego la esta será más representativa. */

    public static void main(String[] args) {
        File f = new File("entrada801.dat");

        try (DataInputStream diS = new DataInputStream(new FileInputStream(f))) {
            
            List<Integer> edades = new ArrayList<>();
            try {
                while (true) {
                    edades.add(diS.readInt());
                }
            } catch (EOFException e) {
                // fin de fichero
            }

            if (edades.isEmpty()) {
                System.out.println("El fichero está vacío");
                return;
            }

            int numAlumnos = edades.size();
            int sumEdades = 0;
            int edadJoven = edades.get(0);
            int edadViejo = edades.get(0);
            int numMenores = 0;

            for (int edad : edades) {
                sumEdades += edad;
                if (edad < 18) numMenores++;
                if (edad < edadJoven) edadJoven = edad;
                if (edad > edadViejo) edadViejo = edad;
            }

            double media = (double) sumEdades / numAlumnos;

            // cálculo de la desviación estándar
            double sumaCuadrados = 0;
            for (int edad : edades) {
                sumaCuadrados += Math.pow(edad - media, 2);
            }
            double desviacionEstandar = Math.sqrt(sumaCuadrados / numAlumnos);

            // salida
            System.out.println("Número de alumnos: " + numAlumnos);
            System.out.println("Media de edades: " + media);
            System.out.println("Edad mínima: " + edadJoven);
            System.out.println("Edad máxima: " + edadViejo);
            System.out.println("Número de menores de edad: " + numMenores);
            System.out.println("Desviación estándar: " + desviacionEstandar);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
