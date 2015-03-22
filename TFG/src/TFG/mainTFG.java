/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TFG;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luisre
 */
public class mainTFG {
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.print("Especifica una acción:"
                + "\n\t1: Añadir un solo fichero .xml"
                + "\n\t2: Añadir una colección de ficheros .xml");
        int opc = input.nextInt();
        
        Lector_XML xml_file = new Lector_XML();
        ArrayList<String> ListaCadenas = new ArrayList<String>();
        ArrayList<String> ListaDiscurso = new ArrayList<String>();
       
        switch(opc){
            case 1:
                xml_file.read_xml("iniciativas/DSCA080120_3.xml");

                ListaCadenas = xml_file.get_interviniente();
                ListaDiscurso = xml_file.get_parrafo();

                xml_file.listaNombres(ListaCadenas, ListaDiscurso, "DSCA080120_3.xml");

                System.out.println( "Legislatura: " + xml_file.get_legislatura() );
                System.out.println( "Numero diario: " + xml_file.get_numero_diario() );
                System.out.println( "Tipo sesion: " + xml_file.get_tipo_sesion() );
                System.out.println( "Organo: " + xml_file.get_organo() );
                System.out.println( "Presidente: " + xml_file.get_presidente() );

                System.out.println( "Fecha: " + xml_file.get_dia() + "/" + xml_file.get_mes() + "/" + xml_file.get_anio());

                System.out.println( "Tipo epigrafe: " + xml_file.get_tipo_epigrafe() );

                System.out.println( "Tipo iniciativa: " + xml_file.get_tipo_iniciativa() );
                System.out.println( "Extracto: " + xml_file.get_extracto() );
                System.out.println( "Intervienen: " + xml_file.get_intervienen() );

                System.out.println( "Interviniente: " + xml_file.get_interviniente()  );
                System.out.println( "Parrafo: " + xml_file.get_parrafo()  );
            break;
                
            case 2:
                File xmlDir = new File( "iniciativas" );
                String[] ficheros = xmlDir.list();
                for(int i=0; i<ficheros.length; i++){
                    xml_file = new Lector_XML();
                    ListaCadenas = new ArrayList<String>();
                    ListaDiscurso = new ArrayList<String>();
                    System.out.println( "Fichero: iniciativas/" + ficheros[i] + "->" + i);
                    xml_file.read_xml("iniciativas/" + ficheros[i]);

                    ListaCadenas = xml_file.get_interviniente();
                    ListaDiscurso = xml_file.get_parrafo();

                    xml_file.listaNombres(ListaCadenas, ListaDiscurso, ficheros[i]);

                    System.out.println( "Legislatura: " + xml_file.get_legislatura() );
                    System.out.println( "Numero diario: " + xml_file.get_numero_diario() );
                    System.out.println( "Tipo sesion: " + xml_file.get_tipo_sesion() );
                    System.out.println( "Organo: " + xml_file.get_organo() );
                    System.out.println( "Presidente: " + xml_file.get_presidente() );

                    System.out.println( "Fecha: " + xml_file.get_dia() + "/" + xml_file.get_mes() + "/" + xml_file.get_anio());

                    System.out.println( "Tipo epigrafe: " + xml_file.get_tipo_epigrafe() );

                    System.out.println( "Tipo iniciativa: " + xml_file.get_tipo_iniciativa() );
                    System.out.println( "Extracto: " + xml_file.get_extracto() );
                    System.out.println( "Intervienen: " + xml_file.get_intervienen() );

                    System.out.println( "Interviniente: " + xml_file.get_interviniente()  );
                    System.out.println( "Parrafo: " + xml_file.get_parrafo()  );
                }
            break;
        }
//        Lector_XML xml_file = new Lector_XML();
//        ArrayList<String> ListaCadenas = new ArrayList<String>();
//        ArrayList<String> ListaDiscurso = new ArrayList<String>();
//        
//        xml_file.read_xml("nuevas_iniciativas/DSCA080120_3.xml");
//        
//        ListaCadenas = xml_file.get_interviniente();
//        ListaDiscurso = xml_file.get_parrafo();
//        
//        xml_file.listaNombres(ListaCadenas, ListaDiscurso, "nuevas_iniciativas/DSCA080120_3.xml");
//        
//        System.out.println( "Legislatura: " + xml_file.get_legislatura() );
//        System.out.println( "Numero diario: " + xml_file.get_numero_diario() );
//        System.out.println( "Tipo sesion: " + xml_file.get_tipo_sesion() );
//        System.out.println( "Organo: " + xml_file.get_organo() );
//        System.out.println( "Presidente: " + xml_file.get_presidente() );
//
//        System.out.println( "Fecha: " + xml_file.get_dia() + "/" + xml_file.get_mes() + "/" + xml_file.get_anio());
//
//        System.out.println( "Tipo epigrafe: " + xml_file.get_tipo_epigrafe() );
//
//        System.out.println( "Tipo iniciativa: " + xml_file.get_tipo_iniciativa() );
//        System.out.println( "Extracto: " + xml_file.get_extracto() );
//        System.out.println( "Intervienen: " + xml_file.get_intervienen() );
//
//        System.out.println( "Interviniente: " + xml_file.get_interviniente()  );
//        System.out.println( "Parrafo: " + xml_file.get_parrafo()  );
//        
//        indice_LCN indice = new indice_LCN();
//            
//        indice.crearIndice();
//        indice.consultarIndice(ListaDiscurso);
        
//        File xmlDir = new File( "iniciativas" );
//        String[] ficheros = xmlDir.list();
//        for(int i=0; i<ficheros.length; i++){
//            Lector_XML xml_file = new Lector_XML();
//            ArrayList<String> ListaCadenas = new ArrayList<String>();
//            ArrayList<String> ListaDiscurso = new ArrayList<String>();
//            System.out.println( "Fichero: iniciativas/" + ficheros[i] + "->" + i);
//            xml_file.read_xml("iniciativas/" + ficheros[i]);
//            
//            ListaCadenas = xml_file.get_interviniente();
//            ListaDiscurso = xml_file.get_parrafo();
//        
//            xml_file.listaNombres(ListaCadenas, ListaDiscurso, ficheros[i]);
//            
//            System.out.println( "Legislatura: " + xml_file.get_legislatura() );
//            System.out.println( "Numero diario: " + xml_file.get_numero_diario() );
//            System.out.println( "Tipo sesion: " + xml_file.get_tipo_sesion() );
//            System.out.println( "Organo: " + xml_file.get_organo() );
//            System.out.println( "Presidente: " + xml_file.get_presidente() );
//
//            System.out.println( "Fecha: " + xml_file.get_dia() + "/" + xml_file.get_mes() + "/" + xml_file.get_anio());
//
//            System.out.println( "Tipo epigrafe: " + xml_file.get_tipo_epigrafe() );
//
//            System.out.println( "Tipo iniciativa: " + xml_file.get_tipo_iniciativa() );
//            System.out.println( "Extracto: " + xml_file.get_extracto() );
//            System.out.println( "Intervienen: " + xml_file.get_intervienen() );
//
//            System.out.println( "Interviniente: " + xml_file.get_interviniente()  );
//            System.out.println( "Parrafo: " + xml_file.get_parrafo()  );
//            
//            
//        }
        
        
        
    }
}

