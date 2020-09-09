/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao.Rest;


import Modelo.Bean.Rest.Frequencia;
import com.google.common.reflect.TypeToken;

import com.google.gson.GsonBuilder;

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
public class FrequenciaREST {
    
     private final String USER_AGENT = "Mozilla/5.0";
      
      
      public void Salvar(Frequencia u) throws Exception {
       String url =  "http://localhost:8085/WebServiceDiarioTom/webresources/generic/Frequencia/inserir/";
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
          Type usuarioType =  new TypeToken<Frequencia>(){}.getType();
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
      
      
      
      
      
      
      public ArrayList<Frequencia > listarFrequenciaPorData(Frequencia b) throws Exception {
                     String urlteste = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/SelecionarFrequencia/" + 
                             b.getData() + "," + b.getData_Saida() + "," + b.getFalta() + "," + b.getId_Professor() + "," + b.getId_Aluno() + "," + b.getId_Turma();
   
    URL url= new URL(urlteste);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
       String urlStr =uri.toASCIIString();

		Client c = Client.create();
           // String suatia =  URLDecoder.decode(url2, "utf-8");
                ArrayList<Frequencia> usuario = new ArrayList<Frequencia>();
               System.out.println(urlStr);
            
         // System.out.println(suatia);
               WebResource wr = c.resource(urlStr);
        
        String json5 = wr.get(String.class);
      
                Gson gson = new Gson();
               usuario = gson.fromJson(json5, new TypeToken<ArrayList<Frequencia>>() {}.getType());
        return usuario;
 
	}
    
    
}
