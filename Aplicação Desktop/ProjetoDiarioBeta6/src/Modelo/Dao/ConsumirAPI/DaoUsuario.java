/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao.ConsumirAPI;


import Modelo.Bean.Aluno;
import Modelo.Bean.Chamada;
import Modelo.Bean.Professorcerto;
import Modelo.Bean.Secretaria;
import Modelo.Bean.Turma;
import Modelo.Bean.Usuario;
import static com.google.common.base.Charsets.ISO_8859_1;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.lang.reflect.Type;
import com.sun.jersey.spi.scanning.WebAppResourcesScanner;








import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javafx.concurrent.Task;
import javax.net.ssl.HttpsURLConnection;
import static org.jvnet.fastinfoset.FastInfosetSerializer.UTF_8;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




/**
 *
 * @author Automação
 */
public class DaoUsuario {
    private final String USER_AGENT = "Mozilla/5.0";
 private static final String URI_BOOK = "http://node174195-skypsenac.jelasticlw.com.br/WebServiceDiarioTom/";
	public static void main(String[] args) throws Exception {

		DaoUsuario http = new DaoUsuario();
 
		System.out.println("Testing 1 - Send Http GET request");
             
		Turma a = new Turma();
                int v = 9;
                a.setId_Turma(v);   
                String url = "http://node174195-skypsenac.jelasticlw.com.br/WebServiceDiarioTom/webresources/generic/listarTodos";
          
            Chamada c = new Chamada();
            c.setNumero_Chamada(1);
            c.setNome("João");
           // for(Usuario u : http.getAllBooks()){
           Usuario conteudo = new Usuario();
           conteudo.setLogin("Pujo");
           conteudo.setSenha("123");
            
           http.sendGet(conteudo);
         
            
        // }
            
            
		/*for(Professorcerto user : http.senGet(userlogin,usersenha)){
            ArrayList<Usuario> usuarios = new ArrayList<>();
            ArrayList r = new ArrayList();
         
            r.add(user);
         
           int a = 0;
                    System.out.println(r);
                    a++;
        }
*/
        }
      
 
	// HTTP GET request
	private String sendGet(Usuario u) throws Exception {
 String a = u.getLogin();
 String b = u.getSenha();
       byte[] bytes = u.getLogin().getBytes(StandardCharsets.UTF_8);
String texto = new String( bytes );
 byte[] bytes2 = u.getSenha().getBytes(StandardCharsets.UTF_8);
String texto2 = new String( bytes2 );
        
		String site = "http://node174195-skypsenac.jelasticlw.com.br/WebServiceDiarioTom/webresources/generic/SelecionarLoginObjeto/" + 
                        texto +","+texto2;
  byte[] bytes3 = site.getBytes(StandardCharsets.UTF_8);
String texto3 = new String( bytes3 );
		URL obj = new URL(site);
               
                
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
               // con.setRequestProperty("Accept-Charset", "UTF-8"); 
              
               con.setRequestProperty("Content-Type", "application/json;");
              
		//add request header
      
		con.setRequestProperty("User-Agent", USER_AGENT);
               
      
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + site);
		System.out.println("Response Code : " + responseCode);
                
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream(),"utf-8"));
               

            
		String inputLine;
                //byte ptext[] = inputLine.getBytes(ISO_8859_1); 


		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
                Gson g = new Gson();
            
                String json = response.toString();
                
                Usuario kk = new Usuario();
                
              // kk = g.fromJson(response.toString(), Usuario.class);
		
               // ArrayList<Usuario> lll = new ArrayList<>();
                //lll.add(kk);
                //System.out.println(response);
                //System.out.println(lll.size());
        return json;
      
 
	}
 // HTTP GET request
	private String senGet() throws Exception {
 
		
                  String urlcerta = "http://node174195-skypsenac.jelasticlw.com.br/WebServiceDiarioTom/webresources/generic/listarTodos";
		Client c = Client.create();
                ArrayList<String> usuarios = new ArrayList<String>();
                WebResource wr = c.resource(urlcerta);
              String json = wr.get(String.class);
             
               // Gson gson = new Gson();
                //usuarios = gson.fromJson(json, new TypeToken<List<String>>() {}.getType());
                ArrayList abb = new ArrayList();
                abb.add(json);
              // kk = g.fromJson(response.toString(), Usuario.class);
		
               // ArrayList<Usuario> lll = new ArrayList<>();
                //lll.add(kk);
                //System.out.println(response);
                //System.out.println(lll.size());
        return json;
 
	}
	// HTTP POST request
	
        
         public void salvar(Usuario conteudo) {
             Client c = Client.create();
             boolean verificar = false;
        WebResource wr = c.resource(
          "http://node174195-skypsenac.jelasticlw.com.br/WebServiceDiarioTom/webresources/generic/Usuario/inserir/" + conteudo);
        
        Usuario i = new Usuario();
   Gson gson = new Gson();
  Type utype =  new TypeToken<Usuario>(){}.getType();
            wr.type("application/json").accept("application/json")
              .post(gson.toJson(conteudo,utype));

       
     
     
    }
         
     
         
         private void sendPost(Usuario u) throws Exception {
       String url =  "http://node174195-skypsenac.jelasticlw.com.br/WebServiceDiarioTom/webresources/generic/Usuario/inserir/";
        URL obj = new URL(url);
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
          Gson gson = new Gson();
          Type usuarioType =  new TypeToken<Usuario>(){}.getType();
        String json = gson.toJson(u, usuarioType);
       System.out.println(json.toString());
  
        wr.writeBytes(json);
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

    }
 
         
          public ArrayList<Usuario> getAllBooks() throws Exception {
        //Create retrofit, set the API base URL and GSonConverterFactory
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URI_BOOK)
                .addConverterFactory(GsonConverterFactory.create()).build();
        //Create service
          UsuarioService us = retrofit.create(UsuarioService.class);
         Call<ArrayList<Usuario>> books = us.getAllBooks();
        return books.execute().body();
      
       
     
        

    }
         
         
         
         
         
         
}


