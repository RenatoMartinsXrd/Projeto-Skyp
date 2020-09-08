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
public class Professor {
    private int Id_Professor;
    private int Id_Usuario;

    public Professor() {
    }

    public Professor(int Id_Usuario, String Nome) {
        this.Id_Professor = Id_Professor;
        this.Id_Usuario = Id_Usuario;
     
    }

    public int getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(int Id_Professor) {
        this.Id_Professor = Id_Professor;
    }

 

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }
}
