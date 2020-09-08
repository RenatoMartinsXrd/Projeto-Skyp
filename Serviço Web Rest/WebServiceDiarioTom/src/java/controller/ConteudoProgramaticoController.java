package controller;

import Modelo.Bean.ConteudoProgramatico;
import dao.ConteudoProgramaticoDAO;







/**
 * 
 * Classe respons�vel por ser o controlador entre o resource e a camada DAO
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 02:04:21
 * @version 1.0
 */
public class ConteudoProgramaticoController {
	public  boolean Salvar(ConteudoProgramatico cp){

		System.out.println("Enviando para o GIT");
           
		return ConteudoProgramaticoDAO.getInstance().Salvar(cp);
	}

     
	
}
