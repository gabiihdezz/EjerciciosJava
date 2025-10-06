package ejemplosFicheros;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class FicherosXmlSax {

	public static void main(String[] args) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
		
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			XMLReader procesadorXML = saxParser.getXMLReader();
			
			GestorContenido gestor = new GestorContenido();
			procesadorXML.setContentHandler (gestor);
			InputSource fileXml = new InputSource ("Empleados.xml");
			
			procesadorXML.parse(fileXml);
			
			
		}
		catch (ParserConfigurationException e){
			System.out.print("Error"+ e);
		}
		catch (SAXException e){
			System.out.print("Error"+ e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
