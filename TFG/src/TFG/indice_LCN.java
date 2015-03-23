/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TFG;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.lucene.search.Query;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import static org.apache.lucene.search.BooleanQuery.getMaxClauseCount;
import static org.apache.lucene.search.BooleanQuery.setMaxClauseCount;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 *
 * @author luisre
 */
public class indice_LCN {
    
    public void crearIndice() throws Exception{
        
        borrarIndice();
        
        File directorioGuardarIndice = new File("indice");
        File directorioCorpus = new File("discursos");
 
        Directory RecorreDirectorio = FSDirectory.open(directorioGuardarIndice.toPath());
 
        Analyzer analizador = new StandardAnalyzer();
 
        IndexWriterConfig configuracionIndice = new IndexWriterConfig(analizador);
 
        IndexWriter Indice = new IndexWriter(RecorreDirectorio, configuracionIndice);
 
        File[] archivos = directorioCorpus.listFiles();
        System.out.println("Tamaño " + archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            File f = archivos[i];
            if (!f.isDirectory() && !f.isHidden() && f.exists() && f.canRead() && (f.getName().endsWith(".xml"))) {
                System.out.println("Indexing " + f.getCanonicalPath());
                Document doc = new Document();
                // Campo nombre archivo
                Field camponombre = new Field("rutaArchivo", f.getName(), Field.Store.YES, Field.Index.ANALYZED_NO_NORMS);
                doc.add(camponombre);
                // Campo contenido del archivo
                Field campocontenido = new Field("contenido", new                                                                        FileReader(f));
                doc.add(campocontenido);
                               
                Indice.addDocument(doc);
            }
        }
                
        System.out.println("El numero de documentos indexados es " + Indice.numDocs());
        Indice.close();
    }
    
    public ArrayList<String> consultarIndice(ArrayList<String> ListaDiscurso) throws Exception{
        File NombreDirectorio = new File("indice");
        Directory directorio = FSDirectory.open(NombreDirectorio.toPath());
        DirectoryReader indexReader = DirectoryReader.open(directorio);
        IndexSearcher Busca = new IndexSearcher(indexReader);
        
        setMaxClauseCount(16384);
 
        String CadenaABuscar = new String();
        String CadenaLimpia = new String();
        for(int i=0; i<ListaDiscurso.size(); i++){
            CadenaABuscar = CadenaABuscar + ListaDiscurso.get(i);
        }
        
        CadenaLimpia = limpiarCadena(CadenaABuscar);
        
        System.out.println("La consulta es " + CadenaLimpia);
 
        Analyzer analizador = new StandardAnalyzer();
 
        QueryParser consultaEnBruto = new QueryParser("contenido", analizador);
 
        Query consulta = consultaEnBruto.parse(CadenaLimpia);
        
        System.out.println("La consulta parseada es " + consulta);
 
        TopDocs resultado = Busca.search(consulta, 10);
 
        System.out.println("Se han obtenido " + resultado.totalHits
                                + " resultados");
        ScoreDoc[] arrayResultados = resultado.scoreDocs;
        
        ArrayList<String> ListaConsulta = new ArrayList<String>();
 
        for (int i = 0; i < arrayResultados.length; i++) {
            Document doc = Busca.doc(arrayResultados[i].doc);
            System.out.print("puntuacion --> " + arrayResultados[i].score + " -> ");
            System.out.println(doc.get("rutaArchivo"));
            ListaConsulta.add(doc.get("rutaArchivo"));
        }
        return ListaConsulta;
    }
    
    public void borrarIndice() throws Exception{
        File indexDir = new File( "indice" );
        
        File[] ficheros = indexDir.listFiles();
 
        for (int i=0; i<ficheros.length; i++){
            if(ficheros[i].delete()){
                System.out.println(ficheros[i] + " borrado.");
            }
        }
    }
    
    public String limpiarCadena(String cadena){
        String cadenaLimpia = new String();
        ArrayList<String> stopwords = new ArrayList<String>();
        
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("stopwords/stopword.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
 
            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null){
               stopwords.add(linea);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //Se omiten caracteres especiales, números y signos de puntuación.
        String signosDePuntuacion = "¡!¿?.,;:][-)(_—";
        int iterador = 0;
        String caracterInspeccionado;
        while (iterador < cadena.length()) {
            caracterInspeccionado = cadena.substring(iterador, iterador+1);
            if (signosDePuntuacion.contains(caracterInspeccionado)) {
                cadena = cadena.replaceAll("\\"+caracterInspeccionado, " ");
            } else {
                iterador++;
            }
        }
        
        //Se omiten las palabras carentes de significado semantico.
        StringTokenizer strTkn = new StringTokenizer(cadena," ");
        int contadorTerm = 0;
        while (strTkn.hasMoreTokens()){
            contadorTerm++;
            String token = strTkn.nextToken();
            if(!stopwords.contains(token.toLowerCase())){
                cadenaLimpia = cadenaLimpia + token + " ";   
            }
        }
        System.out.println( "Terminos: " + contadorTerm );
        System.out.println( "Terminos permitidos: " + getMaxClauseCount() ); 
        return cadenaLimpia;
    }
    
}