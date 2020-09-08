/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modelo.Bean.Frequencia;
import dao.FrequenciaDAO;
import java.util.ArrayList;

/**
 *
 * @author Scarlxrd2112
 */
public class FrequenciaController {
       public  boolean Salvar(Frequencia ch){

		System.out.println("Enviando para o GIT");
           
		return FrequenciaDAO.getInstance().Salvar(ch);
	}
       
       
        
        
             public ArrayList<Frequencia> SelecionarData(Frequencia a){

		System.out.println("Enviando para o GIT");
           
		return FrequenciaDAO.getInstance().Selecionarfre(a);
	}
             
             
                  public ArrayList<Frequencia> SelecionarTeste(Frequencia a){

		System.out.println("Enviando para o GIT");
           
		return FrequenciaDAO.getInstance().SelecionarTudo(a);
	}
                  
                     public Frequencia SelecionarFrequenciaBimestre(Frequencia a){

		System.out.println("Enviando para o GIT");
           
		return FrequenciaDAO.getInstance().SelecionarFrequenciaBimestre(a);
	}
}
