/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bean.Rest;

/**
 *
 * @author Scarlxrd2112
 */
public class ProfessorCadastro {
    private int Id_Professor;
    private String Nome;
    private String Disciplina;
    private String CPF;

    public ProfessorCadastro() {
    }

    public ProfessorCadastro(String Nome, String Disciplina, String CPF) {
        this.Nome = Nome;
        this.Disciplina = Disciplina;
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }


    public int getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(int Id_Professor) {
        this.Id_Professor = Id_Professor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(String Disciplina) {
        this.Disciplina = Disciplina;
    }

 



 

   

}
