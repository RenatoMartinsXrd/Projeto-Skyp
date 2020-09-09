/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao.Rest;



import Modelo.Bean.Rest.Aluno;
import Modelo.Bean.Rest.Avaliacao;
import static Modelo.Dao.Rest.AlunoREST.replaceSpecial;
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
import java.util.ArrayList;

/**
 *
 * @author Scarlxrd2112
 */
public class AvaliacaoREST {
    
        private final String USER_AGENT = "Mozilla/5.0";
      public void Salvar(Avaliacao u) throws Exception {
       String url =  "http://localhost:8085/WebServiceDiarioTom/webresources/generic/Avaliacao/inserir/";
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
      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
          Type usuarioType =  new TypeToken<Avaliacao>(){}.getType();
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
      
      
       public ArrayList<Avaliacao> SelecionarAvaliacao(Avaliacao a) throws Exception {
 
		  
                  String urlcerta = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/SelecionarAvaliacao/"
                         + a.getId_Professor()+"," + a.getId_Bimestre()+"," + a.getId_Turma();
		Client c = Client.create();
              URL url= new URL(urlcerta);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();
                
                
                
                
                ArrayList<Avaliacao> usuario = new ArrayList<Avaliacao>();
               
                WebResource wr = c.resource(urlStr);
              
                wr.accept("Accept-Charset", "utf-8");
                wr.accept("Content-Type", "application/json; charset=utf-8");
            wr.accept("encoding","UTF-8");
    String json = wr.get(String.class);
               
                 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
               usuario = gson.fromJson(json, new TypeToken<ArrayList<Avaliacao>>() {}.getType());
        return usuario;
 
	}
       
        public Avaliacao SelecionarIdAvaliacao(Avaliacao a) throws Exception {
 
		  
                  String urlcerta = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/SelecionarId_Avaliacao/"
                         + a.getId_Professor()+"," + a.getId_Bimestre()+"," + a.getId_Turma() + "," +a.getTitulo();
		Client c = Client.create();
                 URL url= new URL(urlcerta);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();
                Avaliacao usuario = new Avaliacao();
               
                WebResource wr = c.resource(urlStr);
              
                wr.accept("Accept-Charset", "utf-8");
                wr.accept("Content-Type", "application/json; charset=utf-8");
            wr.accept("encoding","UTF-8");
    String json = wr.get(String.class);
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
               usuario = gson.fromJson(json, Avaliacao.class);
        return usuario;
 
	}
        
        
            public Avaliacao SelecionarComIdAvaliacao(Avaliacao a) throws Exception {
 
		  
                  String urlcerta = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/SelecionarComId_Avaliacao/"
                         + a.getId_Avaliacao();
		Client c = Client.create();
                 URL url= new URL(urlcerta);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();
                Avaliacao usuario = new Avaliacao();
               
                WebResource wr = c.resource(urlStr);
              
                wr.accept("Accept-Charset", "utf-8");
                wr.accept("Content-Type", "application/json; charset=utf-8");
            wr.accept("encoding","UTF-8");
    String json = wr.get(String.class);
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
               usuario = gson.fromJson(json, Avaliacao.class);
        return usuario;
 
	}
}
