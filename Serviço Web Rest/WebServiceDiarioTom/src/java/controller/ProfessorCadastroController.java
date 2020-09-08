package controller;

import Modelo.Bean.ProfessorCadastro;
import Modelo.Bean.Turma;
import Modelo.Bean.TurmaProfessor;
import Modelo.Bean.Usuario;
import dao.ProfessorCadastroDAO;
import dao.TurmaDAO;
import dao.TurmaProfessorDAO;
import dao.usuarioDAO;
import java.util.ArrayList;



import dao.UsuariotestDAO;

/**
 * 
 * Classe respons�vel por ser o controlador entre o resource e a camada DAO
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 02:04:21
 * @version 1.0
 */
public class ProfessorCadastroController {
	

        
          public boolean InserirProfessorCadastro(ProfessorCadastro prof){

		System.out.println("Enviando para o GIT");
                
		return ProfessorCadastroDAO.getInstance().Salvar(prof);
	}
          
                 public  ArrayList<ProfessorCadastro> SelecionarTodosProfesosres(){

		System.out.println("Enviando para o GIT");
           
		return ProfessorCadastroDAO.getInstance().SelecionarTodosProfessores();
	}
                 
                          public  ProfessorCadastro SelecionarId_Professor(ProfessorCadastro Nome){

		System.out.println("Enviando para o GIT");
           
		return ProfessorCadastroDAO.getInstance().SelecionarId_Professor(Nome);
	}
	 
     public  boolean ValidarCpf(ProfessorCadastro ch){

		System.out.println("Enviando para o GIT");
           
		return ProfessorCadastroDAO.getInstance().ValidarCPFProfessor(ch);
	}
     
      public  ArrayList<ProfessorCadastro> SelecionarCpfCadastro(ProfessorCadastro Nome){

		System.out.println("Enviando para o GIT");
           
		return ProfessorCadastroDAO.getInstance().SelecionarCPFProfessor(Nome);
     
     
 
}
      
           public  ProfessorCadastro SelecionarProfessorComId_Profesosr(ProfessorCadastro Nome){

		System.out.println("Enviando para o GIT");
           
		return ProfessorCadastroDAO.getInstance().SelecionarProfessorComId_Professor(Nome);
     
     
 
}
}
