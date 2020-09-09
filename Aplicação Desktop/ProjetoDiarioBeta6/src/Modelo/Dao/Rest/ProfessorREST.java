/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao.Rest;

import Modelo.Bean.Rest.Chamada;
import Modelo.Bean.Rest.Professor;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Scarlxrd2112
 */
public class ProfessorREST {
    public static void main(String[] args) throws Exception {
        ProfessorREST pr = new ProfessorREST();
        Professor p = new Professor();
        p.setId_Professor(122);
        p.setId_Usuario(64);
        System.out.println(pr.Salvar(p));
    }
     private final String USER_AGENT = "Mozilla/5.0";
     public boolean Salvar(Professor u) throws Exception {
         boolean retornar = false;
       String url =  "http://localhost:8085/WebServiceDiarioTom/webresources/generic/ProfessorUsuario/inserir/";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("User-Agent", USER_AGENT);
      

		//String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
      Gson gson = new Gson();
          Type usuarioType =  new TypeToken<Professor>(){}.getType();
        String json = gson.toJson(u,usuarioType);
       System.out.println(json.toString());
  
        wr.writeBytes(json);
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
    if(responseCode == 200){
         retornar = true;
      }else {
                  retornar = false;
      }
              
        return retornar;
    } 
}
