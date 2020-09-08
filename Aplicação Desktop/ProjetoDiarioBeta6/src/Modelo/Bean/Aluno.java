/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bean;

import java.sql.Date;

/**
 *
 * @author Scarlxrd2112
 */
public class Aluno {
     private int Id_Aluno;
     private Turmacerta Id_Turma;
     private String Nome;  
     private java.sql.Date Data_Nascimento;
     private String RA;
     private String Data;

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public Aluno() {
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
    

    public Aluno(Turmacerta Id_Turma, String Nome, int Numero_Chamada) {
        this.Id_Aluno = Id_Aluno;
        this.Id_Turma = Id_Turma;
        this.Nome = Nome;
    }
    
    

    public int getId_Aluno() {
        return Id_Aluno;
    }

    public void setId_Aluno(int Id_Aluno) {
        this.Id_Aluno = Id_Aluno;
    }

    public Turmacerta getId_Turma() {
        return Id_Turma;
    }

    public void setId_Turma(Turmacerta Id_Turma) {
        this.Id_Turma = Id_Turma;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
 
    }

 
}
