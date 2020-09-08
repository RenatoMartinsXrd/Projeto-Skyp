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
public class Secretaria {
    private int Id_Secretaria;
    private String Login;
    private String Senha;

      public Secretaria() {
    }
    public Secretaria( String Login, String Senha) {
        this.Id_Secretaria = Id_Secretaria;
        this.Login = Login;
        this.Senha = Senha;
    }

    public int getId_Secretaria() {
        return Id_Secretaria;
    }

    public void setId_Secretaria(int Id_Secretaria) {
        this.Id_Secretaria = Id_Secretaria;
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
