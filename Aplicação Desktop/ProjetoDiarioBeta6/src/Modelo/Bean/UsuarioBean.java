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
public class UsuarioBean {
        private int Id_Usuario;
    private int Id_Professor;

    public UsuarioBean(int Id_Usuario, int Id_Professor) {
        this.Id_Usuario = Id_Usuario;
        this.Id_Professor = Id_Professor;
    }

    public UsuarioBean() {
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public int getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(int Id_Professor) {
        this.Id_Professor = Id_Professor;
    }
   
}
