/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modelo.Bean.Aluno;
import Modelo.Bean.ProfessorCadastro;
import Modelo.Bean.Turma;
import dao.AlunoDAO;
import dao.ProfessorCadastroDAO;
import java.util.ArrayList;

/**
 *
 * @author Scarlxrd2112
 */
public class AlunoController extends AlunoDAO {
     public boolean InserirAluno(Aluno aluno){

		System.out.println("Enviando para o GIT");
         
                
		return Salvar(aluno);
	}
     
             public  ArrayList<Aluno>  SelecionarId_Professor(Aluno aluno){

		System.out.println("Enviando para o GIT");
           
		return AlunoDAO.getInstance().SelecionarAlunos(aluno);
	}
             
                   public boolean DeletarAluno(Aluno aluno){

		System.out.println("Enviando para o GIT");
           
		return AlunoDAO.getInstance().DeletarAlunos(aluno);
	}
                   
               public  ArrayList<Aluno>  SelecionarId_Aluno(Aluno aluno){

		System.out.println("Enviando para o GIT");
           
		return AlunoDAO.getInstance().SelecionarIdAlunos(aluno);
	}
               
               
                  public  Aluno SelecionarId_AlunoRA(Aluno aluno){

		System.out.println("Enviando para o GIT");
           
		return AlunoDAO.getInstance().AutenticarRAaluno(aluno);
	}
}
