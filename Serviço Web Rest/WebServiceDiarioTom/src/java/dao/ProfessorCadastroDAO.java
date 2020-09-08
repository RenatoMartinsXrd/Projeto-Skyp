/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;




import Modelo.Bean.ProfessorCadastro;
import Modelo.Bean.Usuario;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Scarlxrd2112
 */
public class ProfessorCadastroDAO extends ConnectionFactory {
      
    private static ProfessorCadastroDAO instance;
 public static ProfessorCadastroDAO getInstance(){
		if(instance == null)
			instance = new ProfessorCadastroDAO ();
		return instance;
	}

    public ProfessorCadastroDAO() {
      
    }
            public boolean Salvar(ProfessorCadastro Profecadastro){
        String sql = "Insert Into professor_cadastro(Nome,Disciplina,CPF) Values (?,?,?)";
        PreparedStatement pst = null;
        Connection conex = null;
        conex = criarConexao();
        boolean retorno = false;
        try {
            pst = conex.prepareStatement(sql);
            pst.setString(1,Profecadastro.getNome());
            pst.setString(2,Profecadastro.getDisciplina());
             pst.setString(3,Profecadastro.getCPF());
            if(pst.executeUpdate()>0){
                retorno = true;
            }
     
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
          
         
        }
          return retorno;
    }
            public ProfessorCadastro SelecionarId_Professor(ProfessorCadastro Nome){
      Connection conex = null;
        conex = criarConexao();
    String sql = "Select * From professor_cadastro where Nome = ?";
        PreparedStatement pst = null; 
        ResultSet rs = null;
        
        ProfessorCadastro professores = new ProfessorCadastro();
             ProfessorCadastro profcadastro = new ProfessorCadastro();
        try {
            pst = conex.prepareStatement(sql);
          
              pst.setString(1,Nome.getNome());
             
            
            rs = pst.executeQuery();
           
            
            while(rs.next()){
             
          
               profcadastro.setId_Professor(rs.getInt("Id_Professor"));
              
             Usuario usu = new Usuario();
           
        
             
            }
          
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return profcadastro;
    }
            
             public ArrayList<ProfessorCadastro> SelecionarCPFProfessor(ProfessorCadastro CPF){
       
    String sql = "Select * From professor_cadastro where CPF = ? ";
        PreparedStatement pst = null; 
        ResultSet rs = null;
         Connection conex = null;
        conex = criarConexao();
        ArrayList<ProfessorCadastro> professores = new ArrayList<ProfessorCadastro>();
         ProfessorCadastro profcadastro = new ProfessorCadastro();
        try {
            pst = conex.prepareStatement(sql);
          
              pst.setString(1,CPF.getCPF());
              
            rs = pst.executeQuery();
           
            
            while(rs.next()){
             
              
               profcadastro.setId_Professor(rs.getInt("Id_Professor"));
              
             Usuario usu = new Usuario();
           
        
                professores.add(profcadastro);
            }
          
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return professores;
    }   
            
                      
                      
              public ArrayList<ProfessorCadastro> SelecionarTodosProfessores(){
       Connection conex = null;
        conex = criarConexao();
    String sql = "Select * From professor_cadastro";
        PreparedStatement pst = null; 
        ResultSet rs = null;
        
        ArrayList<ProfessorCadastro> professores = new ArrayList<>();
        try {
            pst = conex.prepareStatement(sql);
          
            rs = pst.executeQuery();
           
            
            while(rs.next()){
             
               ProfessorCadastro profcadastro = new ProfessorCadastro();
               profcadastro.setId_Professor(rs.getInt("Id_Professor"));
               profcadastro.setCPF(rs.getString("CPF"));
                profcadastro.setDisciplina(rs.getString("Disciplina"));
               profcadastro.setNome(rs.getString("Nome"));
               
             Usuario usu = new Usuario();
           
        
                professores.add(profcadastro);
            }
          
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return professores;
    }
       
             public boolean ValidarCPFProfessor(ProfessorCadastro CPF){
      
    String sql = "Select * From professor_cadastro where CPF = ? ";
        PreparedStatement pst = null; 
        ResultSet rs = null;
         Connection conex = null;
        conex = criarConexao();
        boolean autenticar = false;
        
        List<ProfessorCadastro> professores = new ArrayList<>();
        try {
            pst = conex.prepareStatement(sql);
          
              pst.setString(1,CPF.getCPF());
              
            rs = pst.executeQuery();
           
            
              if(rs.next()){
                
                autenticar = true;
            }
          
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return autenticar;
    }
            
                       
              public ProfessorCadastro SelecionarProfessorComId_Professor(ProfessorCadastro p){
       Connection conex = null;
        conex = criarConexao();
    String sql = "Select * From professor_cadastro where Id_Professor = ?";
        PreparedStatement pst = null; 
        ResultSet rs = null;
        
        ProfessorCadastro profcadastro = new ProfessorCadastro();
        try {
            pst = conex.prepareStatement(sql);
           pst.setInt(1,p.getId_Professor());
            rs = pst.executeQuery();
           
            
            while(rs.next()){
             
               
               profcadastro.setId_Professor(rs.getInt("Id_Professor"));
               profcadastro.setCPF(rs.getString("CPF"));
                profcadastro.setDisciplina(rs.getString("Disciplina"));
               profcadastro.setNome(rs.getString("Nome"));
               
            
        
             
            }
          
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return profcadastro;
    }
         
              
        
           

    
    
    }


