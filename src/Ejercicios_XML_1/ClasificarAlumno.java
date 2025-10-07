package Ejercicios_XML_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class ClasificarAlumno {

	public static void main(String[] args) {
		
		
		List<Alumno> alumnos = leerAlumnoXml("alumnos.xml");
		crearArchivoClasificado(alumnos, "notas_clasificadas.xml");
	}
	public static List<Alumno> leerAlumnoXml(String archivoEntrada){
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			File f = new File(archivoEntrada);
			Document doc = dBuilder.parse(f);
			
			NodeList nodos = doc.getElementsByTagName("alumno");
			
			for(int i=0; i<nodos.getLength(); i++) {
				Node nodo = nodos.item(i);
				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					  // Obtener y mostrar el contenido de cada elemento hijo
                    Element elemento = (Element)nodo;
					
					String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
                    double nota = Double.parseDouble(elemento.getElementsByTagName("nota").item(0).getTextContent());
                    alumnos.add(new Alumno(nombre,edad,nota));
				}
			}
			
		} catch (ParserConfigurationException | SAXException | IOException  e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	
	public static void crearArchivoClasificado(List<Alumno> alumnos, String ficheroSalida) {
		List<Alumno> suspensos = new ArrayList<Alumno>();
		List<Alumno> aprobados = new ArrayList<Alumno>();
		List<Alumno> notables = new ArrayList<Alumno>();
		List<Alumno> sobresalientes = new ArrayList<Alumno>();
		
		for(Alumno alumno: alumnos) {
			if(alumno.getNota()<4)
				suspensos.add(alumno);
			else if(alumno.getNota()<7)
				suspensos.add(alumno);
			else if(alumno.getNota()<9)
				notables.add(alumno);
			else sobresalientes.add(alumno);
		}
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.newDocument();
				
				Element rootElement = doc.createElement("notas");
				doc.appendChild(rootElement);
				
				crearSeleccion(doc, rootElement, "suspensos", suspensos);
				crearSeleccion(doc, rootElement, "aprobados", aprobados);
				crearSeleccion(doc, rootElement, "notables", notables);
				crearSeleccion(doc, rootElement, "sobresalientes", sobresalientes);
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				
				Transformer transformer = transformerFactory.newTransformer();
				
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(ficheroSalida));
				
				transformer.transform(source, result);
				
				result = new StreamResult(System.out);
				transformer.transform(source, result);
			} catch(ParserConfigurationException | TransformerException e){
				e.printStackTrace();
			}
	}
	
	private static void crearSeleccion(Document doc, Element root, String categoria, List<Alumno> alumnos) {
		
		Element seccion = doc.createElement(categoria);
		root.appendChild(seccion);
		
		Element numero = doc.createElement("numero");
		
		numero.appendChild(doc.createTextNode(String.valueOf(alumnos.size())));
		
		seccion.appendChild(numero);
		
		Element listaAlumnos = doc.createElement("alumnos");
		
		seccion.appendChild(listaAlumnos);
		
		for(Alumno alumno: alumnos) {
			Element elAlumno = doc.createElement("alumno");
			elAlumno.appendChild(doc.createTextNode(String.valueOf(alumno.getNombre())));
			listaAlumnos.appendChild(elAlumno);
		}
	}
	
}