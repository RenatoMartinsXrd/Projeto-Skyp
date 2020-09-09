/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao.Rest;

import Modelo.Bean.Rest.Nota;
import Modelo.Bean.Rest.ProfessorCadastro;
import Modelo.Bean.Rest.Turma;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
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
import java.util.ArrayList;

/**
 *
 * @author Scarlxrd2112
 */
public class ProfessorCadastroREST {
     private final String USER_AGENT = "Mozilla/5.0";
      public void Salvar(ProfessorCadastro u) throws Exception {
       String url =  "http://localhost:8085/WebServiceDiarioTom/webresources/generic/ProfessorCadastro/inserir/";
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
          Type usuarioType =  new TypeToken<ProfessorCadastro>(){}.getType();
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
      
      
          
        public ArrayList<ProfessorCadastro > listarId_Professor(ProfessorCadastro b) throws Exception {
                     String urlteste = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/listarId_Professor/" + b.getNome();
   
    URL url= new URL(urlteste);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();

		Client c = Client.create();
           // String suatia =  URLDecoder.decode(url2, "utf-8");
                ArrayList<ProfessorCadastro> usuario = new ArrayList<ProfessorCadastro>();
               System.out.println(urlStr);
            
         // System.out.println(suatia);
               WebResource wr = c.resource(urlStr);
        
        String json5 = wr.get(String.class);
      
                Gson gson = new Gson();
               usuario = gson.fromJson(json5, new TypeToken<ArrayList<ProfessorCadastro>>() {}.getType());
        return usuario;
 
	}
        
        
             public ArrayList<ProfessorCadastro> ListarTodosProfessores() throws Exception {
 
		  
                  String urlcerta = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/listarTododProfessores";
         
		Client c = Client.create();
              
                ArrayList<ProfessorCadastro> usuario = new ArrayList<ProfessorCadastro>();
               
                   URL url= new URL(urlcerta);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();
           
               
                WebResource wr = c.resource(urlStr);
             
    String json = wr.get(String.class);
                Gson gson = new Gson();
               usuario = gson.fromJson(json, new TypeToken<ArrayList<ProfessorCadastro>>() {}.getType());
        return usuario;
 
	}
             
                 public ArrayList<ProfessorCadastro > listarIdProfessorCpf(ProfessorCadastro b) throws Exception {
                     String urlteste = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/listarCpfCadastro/" + b.getCPF();
   
    URL url= new URL(urlteste);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();

		Client c = Client.create();
           // String suatia =  URLDecoder.decode(url2, "utf-8");
                ArrayList<ProfessorCadastro> usuario = new ArrayList<ProfessorCadastro>();
               System.out.println(urlStr);
            
         // System.out.println(suatia);
               WebResource wr = c.resource(urlStr);
        
        String json5 = wr.get(String.class);
      
                Gson gson = new Gson();
               usuario = gson.fromJson(json5, new TypeToken<ArrayList<ProfessorCadastro>>() {}.getType());
        return usuario;
 
	}
}
