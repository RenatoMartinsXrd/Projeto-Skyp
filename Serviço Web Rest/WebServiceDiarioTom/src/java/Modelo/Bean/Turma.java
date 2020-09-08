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
public class Turma {
    private int Id_Turma;
    
    private String Serie;
    private String Diciplina;
    private boolean Incluir;
    private String Ano;
    private String Periodo;
    
    public Turma() {
    }

    public Turma(String Serie, String Diciplina, boolean Incluir, String Ano, String Periodo) {
        this.Id_Turma = Id_Turma;
        this.Serie = Serie;
        this.Diciplina = Diciplina;
        this.Incluir = Incluir;
        this.Ano = Ano;
        this.Periodo = Periodo;
    }

    public int getId_Turma() {
        return Id_Turma;
    }

    public void setId_Turma(int Id_Turma) {
        this.Id_Turma = Id_Turma;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public String getDiciplina() {
        return Diciplina;
    }

    public void setDiciplina(String Diciplina) {
        this.Diciplina = Diciplina;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        this.Ano = Ano;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

   

    public boolean isIncluir() {
        return Incluir;
    }

    public void setIncluir(boolean Incluir) {
        this.Incluir = Incluir;
    }
    

   



   

    




    @Override
    public String toString() {
        return getSerie(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
