/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TFG;

/**
 *
 * @author luisre
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Attribute;

import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Lector_XML {
    
    private String legislatura;
    private String numero_diario;
    private String tipo_sesion;
    private String organo;
    private String presidente;
    private String dia;
    private String mes;
    private String anio;
    private String tipo_epigrafe;
    private String tipo_iniciativa;
    private String extracto;
    private String intervienen;
    
    private ArrayList<String> interviniente;
    private ArrayList<String> parrafo;
    
    public Lector_XML(){
        
        this.legislatura = null;
        this.numero_diario = null;
        this.tipo_sesion = null;
        this.organo = null;
        this.presidente = null;
        this.dia = null;
        this.mes = null;
        this.anio = null;
        this.tipo_epigrafe = null;
        this.tipo_iniciativa = null;
        this.extracto = null;
        this.intervienen = null;
        
        this.interviniente = new ArrayList<String>();
        this.parrafo = new ArrayList<String>();
        
        
    }
    
    
    //Funciones SET
    public void set_legislatura(String cadena){
        this.legislatura = cadena;
    }
    
    public void set_numero_diario(String cadena){
        this.numero_diario = cadena;
    }
    
    public void set_tipo_sesion(String cadena){
        this.tipo_sesion = cadena;
    }
    
    public void set_organo(String cadena){
        this.organo = cadena;
    }
    
    public void set_presidente(String cadena){
        this.presidente = cadena;
    }
    
    public void set_dia(String cadena){
        this.dia = cadena;
    }
    
    public void set_mes(String cadena){
        this.mes = cadena;
    }
    
    public void set_anio(String cadena){
        this.anio = cadena;
    }
    
    public void set_tipo_epigrafe(String cadena){
        this.tipo_epigrafe = cadena;
    }
    
    public void set_tipo_iniciativa(String cadena){
        this.tipo_iniciativa = cadena;
    }
    
    public void set_extracto(String cadena){
        this.extracto = cadena;
    }
    
    public void set_intervienen(String cadena){
        this.intervienen = cadena;
    }
    
    public void set_interviniente(String cadena){
        this.interviniente.add(cadena);
    }
    
    public void set_parrafo(String cadena){
        this.parrafo.add(cadena);
    }
    
    
    //Funciones GET
    public String get_legislatura(){
        return this.legislatura;
    }
    
    public String get_numero_diario(){
        return this.numero_diario;
    }
    
    public String get_tipo_sesion(){
        return this.tipo_sesion;
    }
    
    public String get_organo(){
        return this.organo;
    }
    
    public String get_presidente(){
        return this.presidente;
    }
    
    public String get_dia(){
        return this.dia;
    }
    
    public String get_mes(){
        return this.mes;
    }
    
    public String get_anio(){
        return this.anio;
    }
    
    public String get_tipo_epigrafe(){
        return this.tipo_epigrafe;
    }
    
    public String get_tipo_iniciativa(){
        return this.tipo_iniciativa;
    }
    
    public String get_extracto(){
        return this.extracto;
    }
    
    public String get_intervienen(){
        return this.intervienen;
    }
    
    public ArrayList<String> get_interviniente(){
        return this.interviniente;
    }
    
    public ArrayList<String> get_parrafo(){
        return this.parrafo;
    }
    
    public void formato_nombres(String cadena){
        
        String nombre = new String();
        
        for ( int i=1; i<cadena.length(); i++ ){
            if(Character.isUpperCase(cadena.charAt(i))) {
                nombre=nombre + cadena.charAt(i);
            }else{
                if(Character.isSpaceChar(cadena.charAt(i))){
                    if(nombre.length() > 0){
                        nombre=nombre + cadena.charAt(i);
                    }
                }
            }
        }
        
        set_interviniente(nombre);
        
    }
    
    public void read_xml(String xml_path){
        
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( xml_path );
        
        try{
            
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build( xmlFile );
            
            //Se obtiene la raiz <iniciativa_completa>
            Element rootNode = document.getRootElement();
            
            set_legislatura(rootNode.getChildText("legislatura"));
            set_numero_diario(rootNode.getChildText("numero_diario"));
            set_tipo_sesion(rootNode.getChildText("tipo_sesion"));
            set_organo(rootNode.getChildText("organo"));
            set_presidente(rootNode.getChildText("presidente"));
            
            Element fecha = rootNode.getChild("fecha"); 
            set_dia(fecha.getChildText("dia"));
            set_mes(fecha.getChildText("mes"));
            set_anio(fecha.getChildText("anio"));
            
            set_tipo_epigrafe(rootNode.getChildText("tipo_epigrafe"));
            
            Element iniciativa = rootNode.getChild("iniciativa"); 
            set_tipo_iniciativa(iniciativa.getChildText("tipo_iniciativa"));
            set_extracto(iniciativa.getChildText("extracto"));
            set_intervienen(iniciativa.getChildText("intervienen"));
            
            List<Element> intervencion = iniciativa.getChildren("intervencion");
            
            for ( int i = 0; i < intervencion.size(); i++ ){
                Element elem_intervencion = (Element)intervencion.get(i);
                formato_nombres(elem_intervencion.getChildText("interviniente"));
                
                String cadena_parrafo = "";
                Element discurso = elem_intervencion.getChild("discurso");
                List<Element> parrafo = discurso.getChildren("parrafo");
                
                for( int j = 0; j < parrafo.size(); j++ ){
                    Element elem_parrafo = (Element)parrafo.get(j);
                    cadena_parrafo = cadena_parrafo + elem_parrafo.getValue();
                }
                set_parrafo(cadena_parrafo);
            }

        }catch ( IOException io ){
            System.out.println( io.getMessage() );
        }catch ( JDOMException jdomex ){
            System.out.println( jdomex.getMessage() );
        }
        
    }
    
    public void listaNombres(ArrayList<String> ListaCadenas, ArrayList<String> ListaDiscurso, String id_iniciativa){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<String> ListaNombres = new ArrayList<String>();
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("nombres/nombres.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null){
                //System.out.println(linea);
                ListaNombres.add((String)linea);
            }
            
            for(int i = 0;i<ListaNombres.size();i++){
                for (int j = 0;j<ListaCadenas.size();j++){
                    if (ListaNombres.get(i).contains(ListaCadenas.get(j))){
                        if(ListaCadenas.get(j).length() > 5){
                            System.out.println("Lo contiene: " + ListaNombres.get(i) + " contiene a " + ListaCadenas.get(j));
                            write_xml(ListaNombres.get(i), ListaDiscurso.get(j), id_iniciativa);
                        }
                        
                    }
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{                   
                if( null != fr ){  
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public void write_xml(String path, String cad_string, String id_iniciativa){
 
        //Creamos un elemento root 
        Element iniciativa = new Element("iniciativa");
        iniciativa.setAttribute("id",id_iniciativa);
        //Creamos un hijo para el root  
        Element discurso = new Element("discurso").setText(cad_string); 
        iniciativa.addContent(discurso); 
        Document doc = new Document(iniciativa);
        //Creamos el documento   
        try{ 
            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat()); 
            FileOutputStream file = new FileOutputStream("discursos/" + path + ".xml", true); 
            out.output(doc,file); 
            file.flush(); 
            file.close(); 
            out.output(doc,System.out); 
        }catch(Exception e){
            e.printStackTrace();
        }
      
    }
}
