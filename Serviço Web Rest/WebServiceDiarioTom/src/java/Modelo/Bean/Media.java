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
public class Media {
    public int Id_Media;
     public int Id_Aluno;
    public int Id_Turma;
     public int Id_Professor;
       public int Id_Bimestre;
       public double Media;
       public int Falta_Total;

    public Media() {
    }

    public Media(int Id_Aluno, int Id_Turma, int Id_Professor, int Id_Bimestre, double Media, int Falta_Total) {
        this.Id_Media = Id_Media;
        this.Id_Aluno = Id_Aluno;
        this.Id_Turma = Id_Turma;
        this.Id_Professor = Id_Professor;
        this.Id_Bimestre = Id_Bimestre;
        this.Media = Media;
        this.Falta_Total = Falta_Total;
    }

    public int getId_Media() {
        return Id_Media;
    }

    public void setId_Media(int Id_Media) {
        this.Id_Media = Id_Media;
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

    public int getId_Bimestre() {
        return Id_Bimestre;
    }

    public void setId_Bimestre(int Id_Bimestre) {
        this.Id_Bimestre = Id_Bimestre;
    }

    public double getMedia() {
        return Media;
    }

    public void setMedia(double Media) {
        this.Media = Media;
    }

    public int getFalta_Total() {
        return Falta_Total;
    }

    public void setFalta_Total(int Falta_Total) {
        this.Falta_Total = Falta_Total;
    }

   
}
