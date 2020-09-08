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
    
    public int Id_Aluno;
    public int Id_Turma;
     public int Id_Professor;
      public int Id_Avaliacao;
       public int Id_Bimestre;
       public double Nota;

    public Nota(int Id_Aluno, int Id_Turma, int Id_Professor, int Id_Avaliacao, int Id_Bimestre, double Nota) {
        this.Id_Aluno = Id_Aluno;
        this.Id_Turma = Id_Turma;
        this.Id_Professor = Id_Professor;
        this.Id_Avaliacao = Id_Avaliacao;
        this.Id_Bimestre = Id_Bimestre;
        this.Nota = Nota;
    }

    public int getId_Aluno() {
        return Id_Aluno;
    }

    public void setId_Aluno(int Id_Aluno) {
        this.Id_Aluno = Id_Aluno;
    }

    public int getId_Turma() {
        return Id_Turma;
    }

    public void setId_Turma(int Id_Turma) {
        this.Id_Turma = Id_Turma;
    }

    public int getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(int Id_Professor) {
        this.Id_Professor = Id_Professor;
    }

    public int getId_Avaliacao() {
        return Id_Avaliacao;
    }

    public void setId_Avaliacao(int Id_Avaliacao) {
        this.Id_Avaliacao = Id_Avaliacao;
    }

    public int getId_Bimestre() {
        return Id_Bimestre;
    }

    public void setId_Bimestre(int Id_Bimestre) {
        this.Id_Bimestre = Id_Bimestre;
    }

    public double getNota() {
        return Nota;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }

    

       
    
}
