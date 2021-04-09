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
//        try{
//            File archivo = new File("datos.xml");
//            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            Document d=db.parse(archivo);
//            d.getDocumentElement().normalize();
//            System.out.println("elemento principal:"+d.getDocumentElement().getNodeName());
//            cargando todos los docentes en una coleccion de tipo nodo
//            NodeList listDocentes = d.getElementsByTagName("docente");
//            
//            for(int i=0;i<listDocentes.getLength();i++){
//                Node nodo=listDocentes.item(i);
//                System.out.println("Docente:"+nodo.getNodeName()+i);
//                if(nodo.getNodeType()==Node.ELEMENT_NODE){
//                    Element element =(Element)nodo;
//                    System.out.println("id:"+element.getAttribute("id"));
//                    System.out.println("Nombre:"+element.getElementsByTagName("nombre").item(0).getTextContent());
//                    System.out.println("username:"+element.getElementsByTagName("username").item(0).getTextContent());
//                    System.out.println("password: " + element.getElementsByTagName("321423").item(0).getTextContent());
//                }
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//    }
    
    }
}
