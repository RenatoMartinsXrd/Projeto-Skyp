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
public class Professorcerto {
    private ProfessorCadastro Id_Professor;
    private Usuario Id_Usuario;

    public Professorcerto() {
    }

    public Professorcerto(Usuario Id_Usuario, String Nome) {
        this.Id_Professor = Id_Professor;
        this.Id_Usuario = Id_Usuario;
     
    }

    public ProfessorCadastro getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(ProfessorCadastro Id_Professor) {
        this.Id_Professor = Id_Professor;
    }

 

    public Usuario getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(Usuario Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }
}
