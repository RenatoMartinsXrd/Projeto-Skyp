package controller;

import Modelo.Bean.Professor;
import Modelo.Bean.ProfessorCadastro;
import Modelo.Bean.Turma;
import Modelo.Bean.TurmaProfessor;
import Modelo.Bean.Usuario;
import dao.ProfessorDAO;
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
public class ProfessorController {
	

        
          public boolean InserirProfessorUsuario(Professor prof){

		System.out.println("Enviando para o GIT");
              
		return ProfessorDAO.getInstance().SalvarId_ProfessorComId_Usuario(prof);
	}
          
         
	
}
