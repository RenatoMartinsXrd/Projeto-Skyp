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
public class Frequencia {
    
    private int Id_Professor;
    private int Id_Turma;
    private int Id_Bimestre;
   private int Id_Aluno;
    private String Falta;
    private Date Data;
     private int Total_Falta;
    private java.sql.Date Data_Saida;
    private boolean Checar;

    public Frequencia(int Id_Professor, int Id_Turma, int Id_Bimestre, int Id_Aluno, String Falta, Date Data,Date Data_Saida,int Total_Falta,boolean Checar) {
        this.Id_Professor = Id_Professor;
        this.Id_Turma = Id_Turma;
        this.Id_Bimestre = Id_Bimestre;
        this.Id_Aluno = Id_Aluno;
        this.Falta = Falta;
        this.Data = Data;
        this.Data_Saida = Data_Saida;
        this.Total_Falta = Total_Falta;
        this.Checar = Checar;
    }

    public Frequencia() {
    }

    public boolean isChecar() {
        return Checar;
    }

    public void setChecar(boolean Checar) {
        this.Checar = Checar;
    }

    public int getTotal_Falta() {
        return Total_Falta;
    }

    public void setTotal_Falta(int Total_Falta) {
        this.Total_Falta = Total_Falta;
    }

    public Date getData_Saida() {
        return Data_Saida;
    }

    public void setData_Saida(Date Data_Saida) {
        this.Data_Saida = Data_Saida;
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

    public int getId_Aluno() {
        return Id_Aluno;
    }

    public void setId_Aluno(int Id_Aluno) {
        this.Id_Aluno = Id_Aluno;
    }

    public String getFalta() {
        return Falta;
    }

    public void setFalta(String Falta) {
        this.Falta = Falta;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }
    
    
    
    
    
}
