/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modelo.Bean.Nota;
import dao.NotaDAO;
import java.util.ArrayList;

/**
 *
 * @author Scarlxrd2112
 */
public class NotaController {
      public boolean InserirNota(Nota aluno){

		System.out.println("Enviando para o GIT");
         
                
		return NotaDAO.getInstance().Salvar(aluno);
	}
      
      public ArrayList<Nota> ConsultarNotasBimestre(Nota aluno){

		System.out.println("Enviando para o GIT");
         
                
		return NotaDAO.getInstance().SelecionarAvaliacoesnOTAS(aluno);
	}
}
