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
public class Chamada {
 private int Id_Turma;
 private int Id_Aluno;
 private int Numero_Chamada;
 private String Nome;
 
    public Chamada() {
    }

    public Chamada(int Id_Turma, int Id_Aluno, int Numero_Chamada, String Nome) {
        this.Id_Turma = Id_Turma;
        this.Id_Aluno = Id_Aluno;
        this.Numero_Chamada = Numero_Chamada;
        this.Nome = Nome;
    }

    public int getId_Turma() {
        return Id_Turma;
    }

    public void setId_Turma(int Id_Turma) {
        this.Id_Turma = Id_Turma;
    }

    public int getId_Aluno() {
        return Id_Aluno;
    }

    public void setId_Aluno(int Id_Aluno) {
        this.Id_Aluno = Id_Aluno;
    }

    public int getNumero_Chamada() {
        return Numero_Chamada;
    }

    public void setNumero_Chamada(int Numero_Chamada) {
        this.Numero_Chamada = Numero_Chamada;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
}
