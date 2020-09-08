/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modelo.Bean.UsuarioAluno;
import dao.UsuarioAlunoDAO;

/**
 *
 * @author Scarlxrd2112
 */
public class UsuarioAlunoController {
     public boolean Salvar(UsuarioAluno user){

		System.out.println("Enviando para o GIT");
              UsuarioAluno u = new UsuarioAluno();
		return UsuarioAlunoDAO.getInstance().Salvar(user);
	}
     
            public  UsuarioAluno SelecionarId_UsuarioAluno(UsuarioAluno aluno){

		System.out.println("Enviando para o GIT");
           
		return UsuarioAlunoDAO.getInstance().SelecionarId_UsuarioAluno(aluno);
	}
}
