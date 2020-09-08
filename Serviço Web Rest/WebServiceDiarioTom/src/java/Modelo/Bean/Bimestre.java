/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bean;


public class Bimestre {
    private int Id_Bimestre;
    private String Bimestre;

    public Bimestre() {
    }

    public Bimestre(int Id_Bimestre, String Bimestre) {
        this.Id_Bimestre = Id_Bimestre;
        this.Bimestre = Bimestre;
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

   
       @Override
    public String toString() {
        return getBimestre(); //To change body of generated methods, choose Tools | Templates.
    }
}
