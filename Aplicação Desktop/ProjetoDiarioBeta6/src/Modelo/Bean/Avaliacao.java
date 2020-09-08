/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bean;

import java.util.Date;

 /**
 *
 * @author Scarlxrd2112
 */
public class Avaliacao {
    private int Id_Avaliacao;
    private Professorcerto Id_Professor;
    private TurmaProfessor Id_Turma;
    private Bimestre Id_Bimestre;
    private String Bimestre;
    private String Titulo;
    public String Serie;
    private String Descrição;
    private java.sql.Date Data_Avaliacao;

    public Avaliacao() {
    }

    public Avaliacao( Professorcerto Id_Professor, TurmaProfessor Id_Turma, Bimestre Id_Bimestre, String Bimestre, String Titulo, String Serie, String Descrição, java.sql.Date Data_Avaliacao) {
        this.Id_Avaliacao = Id_Avaliacao;
        this.Id_Professor = Id_Professor;
        this.Id_Turma = Id_Turma;
        this.Id_Bimestre = Id_Bimestre;
        this.Bimestre = Bimestre;
        this.Titulo = Titulo;
        this.Serie = Serie;
        this.Descrição = Descrição;
        this.Data_Avaliacao = Data_Avaliacao;
    }

    public TurmaProfessor getId_Turma() {
        return Id_Turma;
    }

    public void setId_Turma(TurmaProfessor Id_Turma) {
        this.Id_Turma = Id_Turma;
    }



    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public int getId_Avaliacao() {
        return Id_Avaliacao;
    }

    public void setId_Avaliacao(int Id_Avaliacao) {
        this.Id_Avaliacao = Id_Avaliacao;
    }

    public Professorcerto getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(Professorcerto Id_Professor) {
        this.Id_Professor = Id_Professor;
    }

    public Bimestre getId_Bimestre() {
        return Id_Bimestre;
    }

    public void setId_Bimestre(Bimestre Id_Bimestre) {
        this.Id_Bimestre = Id_Bimestre;
    }

    public String getBimestre() {
        return Bimestre;
    }

    public void setBimestre(String Bimestre) {
        this.Bimestre = Bimestre;
    }
    
       public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }
       
         public String getTitulo() {
        return Titulo;
    }
    public String getDescrição() {
        return Descrição;
    }

    public void setDescrição(String Descrição) {
        this.Descrição = Descrição;
    }

    public java.sql.Date getData_Avaliacao() {
        return Data_Avaliacao;
    }

    public void setData_Avaliacao(java.sql.Date Data_Avaliacao) {
        this.Data_Avaliacao = Data_Avaliacao;
    }
    
        @Override
    public String toString() {
        return getSerie();
       //To change body of generated methods, choose Tools | Templates.
    }
   
}
