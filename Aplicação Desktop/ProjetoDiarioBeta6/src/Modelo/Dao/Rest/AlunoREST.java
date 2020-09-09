/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao.Rest;

import Modelo.Bean.Rest.Aluno;
import Modelo.Bean.Rest.Avaliacao;
import Modelo.Bean.Usuario;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Scarlxrd2112
 */

public class AlunoREST {
    public static void main(String[] args) throws Exception {
        AlunoREST as = new AlunoREST();
      Aluno alun = new Aluno();
      //alun.setId_Turma(9);
        alun.setId_Aluno(71);
     // alun.setNome("Maria da Silva Maria");
               //ArrayList<Aluno> b = as.SelecionarId_Alunos(alun);
               
              //System.out.println(b.get(0).toString());
              // for(Aluno a : as.listarAlunos(alun)){
              //     System.out.println(a.getId_Aluno() + ", " +a.getNome()+a.getData_Nascimento()+a.getId_Turma() );
               //}
             as.DeletarAluno(alun);
    }
      private final String USER_AGENT = "Mozilla/5.0";
      
      
      public void Salvar(Aluno u) throws Exception {
       String url1 =  "http://localhost:8085/WebServiceDiarioTom/webresources/generic/Aluno/inserir/";
        URL url= new URL(url1);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();
        URL obj = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		//String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
          Type usuarioType =  new TypeToken<Aluno>(){}.getType();
        String json = gson.toJson(u, usuarioType);
       System.out.println(json.toString());
   byte[] test = json.getBytes(StandardCharsets.UTF_8);
        wr.write(test);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + json);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
      
      
      
       public ArrayList<Aluno> SelecionarId_Alunos(Aluno a) throws Exception {
 
		  
                  String urlcerta = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/SelecionarId_Alunos/"
                         + a.getId_Turma()+ "," + replaceSpecial(a.getNome());
		Client c = Client.create();
              
                ArrayList<Aluno> usuario = new ArrayList<Aluno>();
               
                    URL url= new URL(urlcerta);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();
           
               
                WebResource wr = c.resource(urlStr);
              
                wr.accept("Accept-Charset", "utf-8");
                wr.accept("Content-Type", "application/json; charset=utf-8");
            wr.accept("encoding","UTF-8");
    String json = wr.get(String.class);
                Gson gson = new Gson();
               usuario = gson.fromJson(json, new TypeToken<ArrayList<Aluno>>() {}.getType());
        return usuario;
 
	}
       
        public ArrayList<Aluno> listarAlunos(Aluno a) throws Exception {
 
		  
                  String urlcerta = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/listarAlunos/"
                         + a.getId_Turma();
		Client c = Client.create();
              
                ArrayList<Aluno> usuario = new ArrayList<Aluno>();
               
                     URL url= new URL(urlcerta);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();
           
               
                WebResource wr = c.resource(urlStr);
      
    
       Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    String json = wr.get(String.class);
              
               usuario = gson.fromJson(json, new TypeToken<ArrayList<Aluno>>() {}.getType());
      
            
         
		
               // ArrayList<Usuario> lll = new ArrayList<>();
                //lll.add(kk);
                //System.out.println(response);
                //System.out.println(lll.size());
        return usuario;
 
	}
        
        
         public void DeletarAluno(Aluno a) throws Exception {
 
		  
                  String urlcerta = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/DeletarAluno/"
                         + a.getId_Aluno();
		Client c = Client.create();
              
                Aluno usuario = new Aluno();
               
                WebResource wr = c.resource(tratarString(urlcerta));
                  String json = wr.get(String.class);
        
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
