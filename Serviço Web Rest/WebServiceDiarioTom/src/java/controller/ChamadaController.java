/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modelo.Bean.Chamada;
import dao.ChamadaDAO;
import java.util.ArrayList;

/**
 *
 * @author Scarlxrd2112
 */
public class ChamadaController {
    
     public  boolean AutenticarListaChamada(Chamada ch){

		System.out.println("Enviando para o GIT");
           
		return ChamadaDAO.getInstance().AutenticarListaChamada(ch);
	}
        
            public  ArrayList<Chamada>  SelecionarChamadaId_TurmaSerie(Chamada ch){

		System.out.println("Enviando para o GIT");
           
		return ChamadaDAO.getInstance().SelecionarChamada(ch);
	}
        
          public boolean InserirChamada(Chamada ch){

		System.out.println("Enviando para o GIT");
              
		return ChamadaDAO.getInstance().InserirChamada(ch);
	}
          
           public boolean DeletarAluno(Chamada aluno){

		System.out.println("Enviando para o GIT");
           
		return ChamadaDAO.getInstance().ExcluirChamada(aluno);
	}
    
}
