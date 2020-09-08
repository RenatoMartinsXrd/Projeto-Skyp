/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modelo.Bean.Media;
import Modelo.Bean.Nota;
import dao.MediaDAO;
import java.util.ArrayList;

/**
 *
 * @author Scarlxrd2112
 */
public class MediaController {
      public boolean InserirMedia(Media aluno){

		System.out.println("Enviando para o GIT");
         
                
		return MediaDAO.getInstance().Salvar(aluno);
	}
      
      public ArrayList<Media> ConsultarMediaBimestre(Media aluno){

		System.out.println("Enviando para o GIT");
         
                
		return MediaDAO.getInstance().SelecionarMediaBimestre(aluno);
	}
      
       public ArrayList<Media> ConsultarMediaTotal(Media aluno){

		System.out.println("Enviando para o GIT");
         
                
		return MediaDAO.getInstance().SelecionarTodasMedia(aluno);
	}
}
