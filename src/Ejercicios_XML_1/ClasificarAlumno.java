package Ejercicios_XML_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ClasificarAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static ArrayList<Alumno> alumnos = new ArrayList<>();
	
	public static List <Alumno> leerAlumnosXml(String archivoEntrada){
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			File f = new File(archivoEntrada);
			Document doc = dBuilder.parse(f);
			
			NodeList nodos = doc.getElementsByTagName("alumno");
			
			for (int i=0;i<nodos.getLength();i++){
				Node nodo=nodos.item(i);
				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element)nodo;
					elemento.getElementsByTagName("nombre").item(0).getTextContent();
					String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
					int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
					double nota = Double.parseDouble(elemento.getElementsByTagName("nota").item(0).getTextContent());
					alumnos.add(new Alumno (nombre, edad, nota));
					
					
				}
				}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void crearArchivoClasificado(List<Alumno> alumnos, String ficheroSalida) {
		List <Alumno> suspensos = new ArrayList <Alumno>();
		List <Alumno> aprobados = new ArrayList <Alumno>();
		List <Alumno> notable = new ArrayList <Alumno>();
		List <Alumno> sobresalientes = new ArrayList <Alumno>();
		
		for (Alumno alumno:alumnos) {
			if(alumno.getNota()<4)
				suspensos.add(alumno);
			else if (alumno.getNota()<7) {
				aprobados.add(alumno);
			}
			else if (alumno.getNota()<9) {
				notable.add(alumno);
		}
			else if (alumno.getNota()<10) {
				sobresalientes.add(alumno);
	}
		}
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder
		}
		
		
}
	
	private static 
	
	
	
}