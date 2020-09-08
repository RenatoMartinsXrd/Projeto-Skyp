/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bean;

/**
 *
 * @author Aluno
 */
public class TurmaProfessor{

   private int Id_Professor;
   private int Id_Turma;
   private String Serie;

    public TurmaProfessor() {
    }

   
   
    public TurmaProfessor(int Id_Professor, int Id_Turma, String Serie) {
        this.Id_Professor = Id_Professor;
        this.Id_Turma = Id_Turma;
        this.Serie = Serie;
    }

    public int getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(int Id_Professor) {
        this.Id_Professor = Id_Professor;
    }

    public int getId_Turma() {
        return Id_Turma;
    }

    public void setId_Turma(int Id_Turma) {
        this.Id_Turma = Id_Turma;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }
   
}
