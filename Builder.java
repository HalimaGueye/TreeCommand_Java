
import java.io.Console;
import java.io.File;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncProvider;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Builder extends Doc {

    public static final String xmlFilePath = "C:\\Users\\HalimaG\\Desktop\\Java\\Projet_PDC\\XML\\CreateXMLFileJava.xml";

    // File Tree with path to XML file in params
    public String createXMLFile(String chemin) {
        File file = new File(chemin);

        // Create XML file
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
        DocumentBuilder dBuilder = null; 
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document doc = dBuilder.newDocument(); // Create new document
        Element rootElement = doc.createElement("root"); // Create root element
        
    

        File[] fileListe = file.listFiles(); // Get list of files in directory
        //nomber of files in directory
        int nbFiles = fileListe.length;
        Factory.fabrique(file.isDirectory(), file.getName()).afficher();

        for (File item : fileListe) {

            
            if(item.isDirectory()) { // If item is directory
                Element dirElement = doc.createElement("directory");
                rootElement.appendChild(dirElement);
                Attr attr = doc.createAttribute("name");
                attr.setValue(item.getName());
                dirElement.setAttributeNode(attr);
                createXMLFile(item.getAbsolutePath());
                
            }
            if (item.isFile()) { // If file
                Element fileElement = doc.createElement("file");
                rootElement.appendChild(fileElement);
                Attr attr = doc.createAttribute("name");
                attr.setValue(item.getName());
                fileElement.setAttributeNode(attr);

                System.out.print("\n │");
                Factory.fabrique(item.isDirectory(), item.getName()).afficher();
            } 
           
            else if(!item.isDirectory()&&item.isFile()){ // If file is not a directory or a file
                Element dirElement = doc.createElement("document");
                rootElement.appendChild(dirElement);
                Attr attr = doc.createAttribute("name");
                attr.setValue(item.getName());
                dirElement.setAttributeNode(attr);
                
            }
            
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            //print in console the XML content
            // StreamResult consoleResult = new StreamResult(System.out);
            // transformer.transform(source, consoleResult);

        } catch (TransformerException e) {
            e.printStackTrace();}
        return chemin;
        }


    @Override
    public void afficher() {
        // TODO Auto-generated method stub

    }

}
