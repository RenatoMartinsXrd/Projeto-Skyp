/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modelo.Bean.Secretaria;
import dao.secretariaDAO1;
import java.util.ArrayList;

/**
 *
 * @author Scarlxrd2112
 */
public class SecretariaController {
    
      public boolean SelecionarLoginSecretaria(Secretaria Login,Secretaria Senha){

		System.out.println("Enviando para o GIT");
		return secretariaDAO1.getInstance().AutenticarLoginSecretaria(Login,Senha);
	}
      
      
      public boolean SelecionarLoginSecretariaObjeto(Secretaria Login){

		System.out.println("Enviando para o GIT");
		return secretariaDAO1.getInstance().AutenticarLoginSecretariaObjeto(Login);
	}
    
}
