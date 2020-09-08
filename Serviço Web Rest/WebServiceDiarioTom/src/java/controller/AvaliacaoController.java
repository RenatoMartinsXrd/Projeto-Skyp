/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modelo.Bean.Avaliacao;
import Modelo.Bean.ProfessorCadastro;
import dao.AvaliacaoDAO;
import dao.ProfessorCadastroDAO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Scarlxrd2112
 */
public class AvaliacaoController {
     public boolean InserirAvaliacao(Avaliacao a){

		System.out.println("Enviando para o GIT");
              
		return AvaliacaoDAO.getInstance().Salvar(a);
	}
     
      public  ArrayList<Avaliacao>  SelecionarAvaliacoes(Avaliacao a){

		System.out.println("Enviando para o GIT");
           
		return AvaliacaoDAO.getInstance().SelecionarAvaliacoesnOTAS(a);
	}
      
        public Avaliacao SelecionarIdAvaliacoes(Avaliacao a){

		System.out.println("Enviando para o GIT");
           
		return AvaliacaoDAO.getInstance().SelecionarIdAvaliacao(a);
	}
        
         public Avaliacao SelecionarAvaliacoesComIdAvaliacao(Avaliacao a){

		System.out.println("Enviando para o GIT");
           
		return AvaliacaoDAO.getInstance().SelecionarComIdAvaliacao(a);
	}
}
