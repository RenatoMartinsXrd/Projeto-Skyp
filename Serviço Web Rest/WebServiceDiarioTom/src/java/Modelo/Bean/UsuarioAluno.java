/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bean;

/**
 *
 * @author Scarlxrd2112
 */
public class UsuarioAluno {
    private int Id_Usuario_Aluno;	
    private int Id_Aluno;	
    private String Login;	
    private String Senha;

    public UsuarioAluno() {
    }

    public int getId_Usuario_Aluno() {
        return Id_Usuario_Aluno;
    }

    public void setId_Usuario_Aluno(int Id_Usuario_Aluno) {
        this.Id_Usuario_Aluno = Id_Usuario_Aluno;
    }

    public int getId_Aluno() {
        return Id_Aluno;
    }

    public void setId_Aluno(int Id_Aluno) {
        this.Id_Aluno = Id_Aluno;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    

}
