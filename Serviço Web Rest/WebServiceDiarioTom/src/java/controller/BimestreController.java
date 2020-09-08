package controller;

import Modelo.Bean.Bimestre;
import Modelo.Bean.Usuario;
import dao.BimestreDAO;
import dao.usuarioDAO;
import java.util.ArrayList;





/**
 * 
 * Classe respons�vel por ser o controlador entre o resource e a camada DAO
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 02:04:21
 * @version 1.0
 */
public class BimestreController {
	
	public ArrayList<Bimestre> listarBimestre(){
		System.out.println("Enviando para o GIT");
		return BimestreDAO.getInstance().SelecionarBimestre();
	}
        
        	public ArrayList<Bimestre> listarId_Bimestre(Bimestre b){
		System.out.println("Enviando para o GIT");
           
		return BimestreDAO.getInstance().SelecionarId_Bimestre(b);
	}
     
	
}
