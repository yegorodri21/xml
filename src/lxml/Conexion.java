/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lxml;

import java.util.ArrayList;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import lxml.Docente;
import com.db4o.ext.DatabaseReadOnlyException;
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
public class Conexion {
 
    private ObjectContainer oc;
    private void open(){
        this.oc=Db4o.openFile("database.yap");
    }
    public boolean Insertar (Docente objeto){
        try{
            this.open();
            oc.set(objeto);
            this.oc.close();
            return true;
        } catch(Exception e){
            System.out.println("bdoo.Controador.InsertarPersona(): "+e);
            return false;
        }
    }
    public void insertarXml(Docente[] d){
        //si el objeto se encuentra ya guardado colocar un mensaje 
        //y si el objeto no se encuentra entonces guardelo al objeto
        if (d==null){
            System.out.println("");
        }else{
            System.out.println("Este objeto ya se encuentra guardado");
        }
    }
    
    public Docente buscarPersona(Docente objeto){
        this.open();
        Docente encontrado=null;
        ObjectSet resultados =this.oc.get(objeto);
        if(resultados.hasNext()){
            encontrado=(Docente)resultados.next();
        }
        this.oc.close();
        return encontrado;
    }
    public Docente[] leerXML(){
        Docente[] docentes =new Docente[10];
             try{
                 Docente docentexml=null;
            File archivo = new File("datos.xml");
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d=db.parse(archivo);
            d.getDocumentElement().normalize();
            System.out.println("elemento principal:"+d.getDocumentElement().getNodeName());
            //cargando todos los docentes en una coleccion de tipo nodo
            NodeList listDocentes = d.getElementsByTagName("docente");
            
            for(int i=0;i<listDocentes.getLength();i++){
                Node nodo=listDocentes.item(i);
                System.out.println("Docente:"+nodo.getNodeName()+i);
                if(nodo.getNodeType()==Node.ELEMENT_NODE){
                    Element element =(Element)nodo;
                    String id=element.getAttribute("id");
                    String nombre=element.getElementsByTagName("nombre").item(0).getTextContent();
                    String username=element.getElementsByTagName("username").item(0).getTextContent();
                    String password=element.getElementsByTagName("password").item(0).getTextContent();
                  
                  docentexml=new Docente (id, nombre, username, password);  
                  docentes[i]=docentexml;
                  //Insertar(docentexml);
                  
                    System.out.println("id:"+id);
                    System.out.println("Nombre:"+nombre);
                    System.out.println("username:"+username);
                    System.out.println("password: " +password);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    return docentes;    
      
    }
}


