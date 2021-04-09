/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lxml;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 *
 * @author Usuario
 */
public class LXml {

    public static void main(String[] args) {
        Conexion c= new Conexion();
        Docente [] docentes=null;
        docentes = c.leerXML();
        c.insertarXml(docentes);
    
    }
}
