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
    private Usuario Id_Usuario;
    private String Nome;

    public Professor() {
    }

    public Professor(Usuario Id_Usuario, String Nome, String Diciplina) {
        this.Id_Professor = Id_Professor;
        this.Id_Usuario = Id_Usuario;
        this.Nome = Nome;
        this.Diciplina = Diciplina;
    }

    public int getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(int Id_Professor) {
        this.Id_Professor = Id_Professor;
    }

    public Usuario getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(Usuario Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDiciplina() {
        return Diciplina;
    }

    public void setDiciplina(String Diciplina) {
        this.Diciplina = Diciplina;
    }
    private String Diciplina;
}
