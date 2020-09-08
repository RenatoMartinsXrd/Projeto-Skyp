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
public class Nota {

    public Nota() {
    }
    
    public Aluno Id_Aluno;
    public Turmacerta Id_Turma;
     public ProfessorCadastro Id_Professor;
      public Avaliacao Id_Avaliacao;
       public Bimestre Id_Bimestre;
       public double Nota;

    public Nota(Aluno Id_Aluno, Turmacerta Id_Turma, ProfessorCadastro Id_Professor, Avaliacao Id_Avaliacao, Bimestre Id_Bimestre, double Nota) {
        this.Id_Aluno = Id_Aluno;
        this.Id_Turma = Id_Turma;
        this.Id_Professor = Id_Professor;
        this.Id_Avaliacao = Id_Avaliacao;
        this.Id_Bimestre = Id_Bimestre;
        this.Nota = Nota;
    }

    public Aluno getId_Aluno() {
        return Id_Aluno;
    }

    public void setId_Aluno(Aluno Id_Aluno) {
        this.Id_Aluno = Id_Aluno;
    }

    public Turmacerta getId_Turma() {
        return Id_Turma;
    }

    public void setId_Turma(Turmacerta Id_Turma) {
        this.Id_Turma = Id_Turma;
    }

    public ProfessorCadastro getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(ProfessorCadastro Id_Professor) {
        this.Id_Professor = Id_Professor;
    }

    public Avaliacao getId_Avaliacao() {
        return Id_Avaliacao;
    }

    public void setId_Avaliacao(Avaliacao Id_Avaliacao) {
        this.Id_Avaliacao = Id_Avaliacao;
    }

    public Bimestre getId_Bimestre() {
        return Id_Bimestre;
    }

    public void setId_Bimestre(Bimestre Id_Bimestre) {
        this.Id_Bimestre = Id_Bimestre;
    }

    public double getNota() {
        return Nota;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }




       
    
}
