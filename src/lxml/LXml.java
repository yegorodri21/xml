/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lxml;
import java.io.File;
import java.util.Scanner;
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
                    Scanner ent=new Scanner (System.in);
        String id, nombre,username,password;
        Conexion c= new Conexion();
        Docente [] docentes=null;
        
        
        System.out.println("Ingrese los datos del docente que desea ingresar");
        System.out.print("Id:");
        id=ent.next();
        System.out.print("Nombre:");
        nombre=ent.next();
        System.out.print("Username:");
        username=ent.next();
        System.out.print("Password: ");
        password=ent.next();
    Docente objeto = new Docente (id, nombre, username, password);
    c.leerXML(objeto);
    
        
    }
}
