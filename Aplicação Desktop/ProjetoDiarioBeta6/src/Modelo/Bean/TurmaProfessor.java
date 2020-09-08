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
public class TurmaProfessor {

    private ProfessorCadastro IdProfessor;
   private Professorcerto Id_Professor;
   private Turmacerta Id_Turma;
   private String Serie;
       private boolean Incluir;

    public TurmaProfessor() {
    }

   
   
    public TurmaProfessor(Professorcerto Id_Professor,ProfessorCadastro IdProfessor, Turmacerta Id_Turma, String Serie, boolean Incluir) {
        this.Id_Professor = Id_Professor;
        this.Id_Turma = Id_Turma;
        this.Serie = Serie;
             this.Incluir = Incluir;
             this.IdProfessor = IdProfessor;
    }

    public ProfessorCadastro getIdProfessor() {
        return IdProfessor;
    }

    public void setIdProfessor(ProfessorCadastro IdProfessor) {
        this.IdProfessor = IdProfessor;
    }

    public boolean isIncluir() {
        return Incluir;
    }

    public void setIncluir(boolean Incluir) {
        this.Incluir = Incluir;
    }
    

    public Professorcerto getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(Professorcerto Id_Professor) {
        this.Id_Professor = Id_Professor;
    }

    public Turmacerta getId_Turma() {
        return Id_Turma;
    }

    public void setId_Turma(Turmacerta Id_Turma) {
        this.Id_Turma = Id_Turma;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }
    
    
    @Override
    public String toString() {
        return getSerie(); //To change body of generated methods, choose Tools | Templates.
    }
   
}
