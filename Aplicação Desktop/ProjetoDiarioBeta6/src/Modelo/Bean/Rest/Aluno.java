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
public class Aluno {
     private int Id_Aluno;
     private int Id_Turma;
     private String Nome;  
     private Date Data_Nascimento;
     private String RA;
     private boolean Excluir;

    public Aluno() {
    }

    public Aluno( int Id_Turma, String Nome, Date Data_Nascimento, String RA, boolean Excluir) {
        this.Id_Aluno = Id_Aluno;
        this.Id_Turma = Id_Turma;
        this.Nome = Nome;
        this.Data_Nascimento = Data_Nascimento;
        this.RA = RA;
        this.Excluir = Excluir;
    }

    public boolean isExcluir() {
        return Excluir;
    }

    public void setExcluir(boolean Excluir) {
        this.Excluir = Excluir;
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

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Date getData_Nascimento() {
        return Data_Nascimento;
    }

    public void setData_Nascimento(Date Data_Nascimento) {
        this.Data_Nascimento = Data_Nascimento;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }
    
    
}

    