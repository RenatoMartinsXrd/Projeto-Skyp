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
public class Turma {
    private int Id_Turma;
    private Professor Id_Professor;
    private String Serie;
    private String Diciplina;
    private boolean Incluir;

    public Turma() {
    }

    public Turma( Professor Id_Professor, String Serie, String Diciplina, boolean Incluir) {
        this.Id_Turma = Id_Turma;
        this.Id_Professor = Id_Professor;
        this.Serie = Serie;
        this.Diciplina = Diciplina;
           this.Incluir = Incluir;
    }
    

    public int getId_Turma() {
        return Id_Turma;
    }

    public void setId_Turma(int Id_Turma) {
        this.Id_Turma = Id_Turma;
    }

    public Professor getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(Professor Id_Professor) {
        this.Id_Professor = Id_Professor;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public String getDiciplina() {
        return Diciplina;
    }

    public void setDiciplina(String Diciplina) {
        this.Diciplina = Diciplina;
    }

    @Override
    public String toString() {
        return getSerie(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean isIncluir() {
        return Incluir;
    }

    public void setIncluir(boolean Incluir) {
        this.Incluir = Incluir;
    }
    
    
}
