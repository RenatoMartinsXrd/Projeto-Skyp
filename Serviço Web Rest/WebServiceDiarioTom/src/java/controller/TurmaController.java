package controller;

import Modelo.Bean.Turma;
import Modelo.Bean.Usuario;
import dao.TurmaDAO;
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
public class TurmaController {
	
        public  ArrayList<Turma> SelecionarTodasTurmas(){

		System.out.println("Enviando para o GIT");
           
		return TurmaDAO.getInstance().SelecionarTodasTurmas();
	}
        
            public  ArrayList<Turma> SelecionarId_TurmaSerie(Turma tur){

		System.out.println("Enviando para o GIT");
           
		return TurmaDAO.getInstance().SelecionarId_TurmaSerie(tur);
	}
        
          public boolean InserirTurma(Turma turma){

		System.out.println("Enviando para o GIT");
              
		return TurmaDAO.getInstance().Salvar(turma);
	}
	
}
