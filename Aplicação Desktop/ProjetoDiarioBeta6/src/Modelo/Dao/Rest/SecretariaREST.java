/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao.Rest;

import Modelo.Bean.Rest.Professor;
import Modelo.Bean.Rest.Secretaria;
import Modelo.Bean.Rest.Usuario;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.net.URI;
import java.net.URL;

/**
 *
 * @author Scarlxrd2112
 */
public class SecretariaREST {
      public boolean LoginUsuarioa(Secretaria a) throws Exception {
 
		  
                  String urlcerta = "http://localhost:8085/WebServiceDiarioTom/webresources/generic/SelecionarSecretariaObjeto/"
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
          return true;
  
 
	}
}
