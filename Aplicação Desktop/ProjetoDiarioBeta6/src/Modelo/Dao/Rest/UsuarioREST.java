/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao.Rest;

import Modelo.Bean.Chamada;
import Modelo.Bean.Rest.Professor;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import Modelo.Bean.Rest.Usuario;
import Modelo.Bean.Secretaria;
import Modelo.Bean.Turma;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.lang.reflect.Type;
import com.sun.jersey.spi.scanning.WebAppResourcesScanner;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.Encoded;
import javax.ws.rs.core.MultivaluedMap;
/**
 *
 * @author Scarlxrd2112
 */
public class UsuarioREST {
   
    public static void main(String[] args) throws Exception {
        
            UsuarioREST ty = new UsuarioREST();
              String teste = "Pufod";
               Usuario userlogin = new Usuario();
                userlogin.setLogin(teste);
                userlogin.setSenha("123");
            Chamada a = new Chamada();
            a.setNome("Maria");
            a.setNumero_Chamada(1);
             Usuario conteudo = new Usuario();
              String Login = "PaulãoGeo";
           String Senha = "123";
            byte[] bytes = Login.getBytes(StandardCharsets.UTF_8);
String texto = new String( bytes );
          

           // Professor prof = ty.LoginUsuario(userlogin);
           
          
        // ty.Salvar(conteudo);
       
           //ty.Salvar(conteudo);
    }
  
     private final String USER_AGENT = "Mozilla/5.0";
     public boolean Salvar(Usuario u) throws Exception {
          boolean retornar = false;
       String url =  "http://localhost:8085/WebServiceDiarioTom/webresources/generic/Usuario/inserir/";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type" ,"application/json;charset=utf-8");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "pt-Br");

		//String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
      Gson gson = new Gson();
          Type usuarioType =  new TypeToken<Usuario>(){}.getType();
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
                new InputStreamReader(con.getInputStream(),"utf-8"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
        if(responseCode == 200){
         retornar = true;
      }else {
                  retornar = false;
      }
              
        return retornar;

    }
    
    
    
    
    
    public Professor LoginUsuarioa(Usuario a) throws Exception {
 
		  
                  String urlcerta = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/SelecionarLoginObjeto/"
                         + a.getLogin()+ "," + a.getSenha();
                  URL url= new URL(urlcerta);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();
		Client c = Client.create();
              
                Professor usuario = new Professor();
                Professor p = new Professor();
                WebResource wr = c.resource(urlStr);
              
                wr.accept("Accept-Charset", "utf-8");
                wr.accept("Content-Type", "application/json; charset=utf-8");
            wr.accept("encoding","UTF-8");
        System.out.println(urlStr);
       
    String json = wr.get(String.class);
                Gson gson = new Gson();
               usuario = gson.fromJson(json, Professor.class);

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
