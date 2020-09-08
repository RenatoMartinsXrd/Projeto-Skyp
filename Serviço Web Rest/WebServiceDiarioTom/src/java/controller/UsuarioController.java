package controller;

import Modelo.Bean.Professor;
import Modelo.Bean.Usuario;
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
public class UsuarioController {
	
	public ArrayList<Usuario> listarTodos(){
		System.out.println("Enviando para o GIT");
		return UsuariotestDAO.getInstance().listarTodos();
	}
        
        public  ArrayList SelecionarLogin(Usuario user,Usuario Senha){

		System.out.println("Enviando para o GIT");
              Usuario u = new Usuario();
		return UsuariotestDAO.getInstance().SelecionarLogin(user,Senha);
	}
        
          public Professor SelecionarLoginObject(Usuario user){

		System.out.println("Enviando para o GIT");
              Usuario u = new Usuario();
		return UsuariotestDAO.getInstance().SelecionarLoginObjeto(user);
	}
        
          public boolean InserirUsuario(Usuario user){

		System.out.println("Enviando para o GIT");
              Usuario u = new Usuario();
		return usuarioDAO.getInstance().Salvar(user);
	}
	
}
