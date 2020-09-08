/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Scarlxrd2112
 */
@XmlRootElement
public class Usuario {
    private int Id_Usuario;
    private String Login;
    private String Senha;

    public Usuario() {
    }

    public Usuario(String Login, String Senha) {
        this.Id_Usuario = Id_Usuario;
        this.Login = Login;
        this.Senha = Senha;
    }
    
    

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
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
