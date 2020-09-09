/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao.Rest;

import Modelo.Bean.Rest.Aluno;
import Modelo.Bean.Rest.Bimestre;
import static Modelo.Dao.Rest.AlunoREST.replaceSpecial;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javax.management.Query.gt;

/**
 *
 * @author Scarlxrd2112
 */
public class BimestreREST {
     public static void main(String[] args) throws Exception {
        BimestreREST as = new BimestreREST();
     
     // alun.setNome("Maria da Silva Maria");
               //ArrayList<Aluno> b = as.SelecionarId_Alunos(alun);
               
              //System.out.println(b.get(0).toString());
              Bimestre b = new Bimestre();
              b.setBimestre("1º Bimestre");
              for(Bimestre a : as.ListarId_Bimestre(b)){
               System.out.println(a.getId_Bimestre() );
              }
          //System.out.println(as.ListarId_Bimestre(b));
    }
    
    
    
    
    
    
    
     public ArrayList<Bimestre> ListarTodosBimestres() throws Exception {
 
		  
                  String urlcerta = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/listarBimestre";
         
		Client c = Client.create();
              
                ArrayList<Bimestre> usuario = new ArrayList<Bimestre>();
               
                WebResource wr = c.resource(urlcerta);
             
    String json = wr.get(String.class);
                Gson gson = new Gson();
               usuario = gson.fromJson(json, new TypeToken<ArrayList<Bimestre>>() {}.getType());
        return usuario;
 
	}
     
     
      public ArrayList<Bimestre> ListarId_Bimestre(Bimestre b) throws Exception {
                     String urlteste = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/listarId_Bimestre/" + b.getBimestre();
   
    URL url= new URL(urlteste);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();

		Client c = Client.create();
           // String suatia =  URLDecoder.decode(url2, "utf-8");
                ArrayList<Bimestre> usuario = new ArrayList<Bimestre>();
               System.out.println(urlStr);
            
         // System.out.println(suatia);
               WebResource wr = c.resource(urlStr);
        
        String json5 = wr.get(String.class);
      
                Gson gson = new Gson();
               usuario = gson.fromJson(json5, new TypeToken<ArrayList<Bimestre>>() {}.getType());
        return usuario;
 
	}
      
      
      
       public String tratarString(String palavra) {
	  char one;
      StringBuffer n = new StringBuffer( palavra.length() );
      for (int i=0; i<palavra.length(); i++) {
         one = palavra.charAt(i);
         switch( one ) {
            case ' ':
		   n.append('%');
		   n.append('2');
		   n.append('0');
               break;
            default:
               n.append( one );
          }
      }
	  return n.toString();
   }
   public static String[] REPLACES = { "a", "e", "i", "o", "u", "c", "A", "E", "I", "O", "U", "C" };
 
    public static Pattern[] PATTERNS = null;
 
    public static void compilePatterns() {
        PATTERNS = new Pattern[REPLACES.length];
        PATTERNS[0]  = Pattern.compile("[âãáàä]");
        PATTERNS[1]  = Pattern.compile("[éèêë]");
        PATTERNS[2]  = Pattern.compile("[íìîï]");
        PATTERNS[3]  = Pattern.compile("[óòôõö]");
        PATTERNS[4]  = Pattern.compile("[úùûü]");
        PATTERNS[5]  = Pattern.compile("[ç]");
        PATTERNS[6]  = Pattern.compile("[ÂÃÁÀÄ]");
        PATTERNS[7]  = Pattern.compile("[ÉÈÊË]");
        PATTERNS[8]  = Pattern.compile("[ÍÌÎÏ]");
        PATTERNS[9]  = Pattern.compile("[ÓÒÔÕÖ]");
        PATTERNS[10] = Pattern.compile("[ÚÙÛÜ]");
        PATTERNS[11] = Pattern.compile("[Ç]");
    }
 
    public static String replaceSpecial(String text) {
        if (PATTERNS == null) {
            compilePatterns();
        }
 
        String result = text;
        for (int i = 0; i < PATTERNS.length; i++) {
            Matcher matcher = PATTERNS[i].matcher(result);
            result = matcher.replaceAll(REPLACES[i]);
        }
        return result;
    }
}
