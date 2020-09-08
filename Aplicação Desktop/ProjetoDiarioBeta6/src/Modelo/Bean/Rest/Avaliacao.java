/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bean.Rest;

import java.util.Calendar;
import java.util.Date;

 /**
 *
 * @author Scarlxrd2112
 */
public class Avaliacao {
    private int Id_Avaliacao;
    private int Id_Professor;
    private int Id_Turma;
    private int Id_Bimestre;
    private String Bimestre;
    private String Titulo;
    public String Serie;
    private String Descrição;
    private java.sql.Date Data_Avaliacao;

    public Avaliacao() {
     
                ;
    }

    public Avaliacao(int Id_Professor, int Id_Turma, int Id_Bimestre, String Bimestre, String Titulo, String Serie, String Descrição, java.sql.Date Data_Avaliacao) {
        this.Data_Avaliacao = Data_Avaliacao;
                
        this.Id_Avaliacao = Id_Avaliacao;
        this.Id_Professor = Id_Professor;
        this.Id_Turma = Id_Turma;
        this.Id_Bimestre = Id_Bimestre;
        this.Bimestre = Bimestre;
        this.Titulo = Titulo;
        this.Serie = Serie;
        this.Descrição = Descrição;

    }

    public java.sql.Date getData_Avaliacao() {
        return Data_Avaliacao;
    }

    public void setData_Avaliacao(java.sql.Date Data_Avaliacao) {
       // Data_Avaliacao = String.valueOf(calendar.get(Calendar.YEAR)) +"-"+
                //tring.valueOf(calendar.get(Calendar.MONTH)+1)+"-"+String.valueOf(calendar.get(Calendar.DATE));
        this.Data_Avaliacao = Data_Avaliacao;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public int getId_Avaliacao() {
        return Id_Avaliacao;
    }

    public void setId_Avaliacao(int Id_Avaliacao) {
        this.Id_Avaliacao = Id_Avaliacao;
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

    public String getBimestre() {
        return Bimestre;
    }

    public void setBimestre(String Bimestre) {
        this.Bimestre = Bimestre;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public String getDescrição() {
        return Descrição;
    }

    public void setDescrição(String Descrição) {
        this.Descrição = Descrição;
    }


Calendar calendar = Calendar.getInstance();


    
        @Override
    public String toString() {
        return getSerie(); //To change body of generated methods, choose Tools | Templates.
    }
}
