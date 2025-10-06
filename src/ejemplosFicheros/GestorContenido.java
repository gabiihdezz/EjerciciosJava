package ejemplosFicheros;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class GestorContenido extends DefaultHandler {
    private StringBuilder valor = new StringBuilder();
    private String nombre;
    private String departamento;
    private int edad;

    private List<Integer> edadesVentas = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        valor.setLength(0); // limpiar el buffer
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        valor.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "nombre":
                nombre = valor.toString().trim();
                break;
            case "departamento":
                departamento = valor.toString().trim();
                break;
            case "edad":
                edad = Integer.parseInt(valor.toString().trim());
                break;
            case "empleado":
                if ("Ventas".equalsIgnoreCase(departamento)) {
                    System.out.println("Empleado de Ventas: " + nombre);
                    edadesVentas.add(edad);
                }
                // reset para siguiente empleado
                nombre = null;
                departamento = null;
                edad = 0;
                break;
        }
    }

    @Override
    public void endDocument() {
        if (!edadesVentas.isEmpty()) {
            double media = edadesVentas.stream().mapToInt(Integer::intValue).average().orElse(0);
            System.out.println("Media de edades (Ventas): " + media);
        } else {
            System.out.println("No hay empleados en Ventas.");
        }
    }
}
