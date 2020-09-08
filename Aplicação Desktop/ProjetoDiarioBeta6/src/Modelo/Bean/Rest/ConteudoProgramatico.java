/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bean.Rest;

import java.sql.Date;

/**
 *
 * @author Scarlxrd2112
 */
public class ConteudoProgramatico {
    int Id_ConteudoProgramatico;
    int Id_Aluno;
    int Id_Professor;
    int Id_Turma;
    int Id_Bimestre;
    String ConteudoProgramatico;
    Date Data_ConteudoProgramatico;

    public ConteudoProgramatico() {
    }

    public ConteudoProgramatico( int Id_Aluno, int Id_Professor, int Id_Turma, int Id_Bimestre, String ConteudoProgramatico, Date Data_ConteudoProgramatico) {
        this.Id_ConteudoProgramatico = Id_ConteudoProgramatico;
        this.Id_Aluno = Id_Aluno;
        this.Id_Professor = Id_Professor;
        this.Id_Turma = Id_Turma;
        this.Id_Bimestre = Id_Bimestre;
        this.ConteudoProgramatico = ConteudoProgramatico;
        this.Data_ConteudoProgramatico = Data_ConteudoProgramatico;
    }

    public int getId_ConteudoProgramatico() {
        return Id_ConteudoProgramatico;
    }

    public void setId_ConteudoProgramatico(int Id_ConteudoProgramatico) {
        this.Id_ConteudoProgramatico = Id_ConteudoProgramatico;
    }

    public int getId_Aluno() {
        return Id_Aluno;
    }

    public void setId_Aluno(int Id_Aluno) {
        this.Id_Aluno = Id_Aluno;
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

    public int getId_Bimestre() {
        return Id_Bimestre;
    }

    public void setId_Bimestre(int Id_Bimestre) {
        this.Id_Bimestre = Id_Bimestre;
    }

    public String getConteudoProgramatico() {
        return ConteudoProgramatico;
    }

    public void setConteudoProgramatico(String ConteudoProgramatico) {
        this.ConteudoProgramatico = ConteudoProgramatico;
    }

    public Date getData_ConteudoProgramatico() {
        return Data_ConteudoProgramatico;
    }

    public void setData_ConteudoProgramatico(Date Data_ConteudoProgramatico) {
        this.Data_ConteudoProgramatico = Data_ConteudoProgramatico;
    }
    
    
    
}
