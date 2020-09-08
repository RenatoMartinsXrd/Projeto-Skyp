/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;




import Modelo.Bean.Aluno;
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
public class AlunoDAO extends ConnectionFactory {
     private static AlunoDAO instance;
    
    
  
public static AlunoDAO getInstance(){
		if(instance == null)
			instance = new AlunoDAO();
		return instance;
	}

    public AlunoDAO() {
   
    }
    public boolean Salvar(Aluno aluno){
        //String sql = "Insert Into aluno(Numero_Chamada,Nome) Values (?,?)";
        String sql = "Insert Into aluno(Id_Turma,Nome,RA,Data_Nascimento) Values (?,?,?,?)";
        PreparedStatement pst = null;
        Connection conex = null;
        conex = criarConexao();
        boolean retorno = false;
        try {
            pst = conex.prepareStatement(sql);

            pst.setInt(1,aluno.getId_Turma());
            pst.setString(2,aluno.getNome());
             pst.setString(3,aluno.getRA());
             pst.setDate(4, aluno.getData_Nascimento());
           
   
            if(pst.executeUpdate()>0){
           retorno = true;     
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
       
    
        public boolean AutenticarCadastroAlunos(Aluno coisas){
    	Connection conexao = null;
                conexao = criarConexao();
    String sql = "Select * From aluno where Nome = ? and Id_Turma = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean autenticar = false;
        
       
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,coisas.getNome());
             pst.setInt(2,coisas.getId_Turma());
            rs = pst.executeQuery();
            if(rs.next()){
                
                autenticar = true;
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
       
        }
        return autenticar;
    

    
    }
    
         public Aluno AutenticarRAaluno(Aluno coisas){
    	Connection conexao = null;
                conexao = criarConexao();
    String sql = "Select * From aluno where RA = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
    
        Aluno a = new Aluno();
        try {
            pst = conexao.prepareStatement(sql);
           
             pst.setString(1,coisas.getRA());
            rs = pst.executeQuery();
           while(rs.next()){
                
             
            
           
                 a.setId_Aluno(rs.getInt("Id_Aluno"));
               
                 a.setNome(rs.getString("Nome"));
             
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
       
        }
        return a;
    

    
    }
        
        
        
        
          public ArrayList<Aluno> SelecionarAlunos(Aluno Id_Turma){
    Connection conex = null;
        conex = criarConexao();
    String sql = "Select * From aluno where Id_Turma = ? Order By Nome ASC";
        PreparedStatement pst = null;
        ResultSet rs = null;
       
        
        ArrayList<Aluno> Alunos = new ArrayList<>();
        try {
            pst = conex.prepareStatement(sql);
            pst.setInt(1, Id_Turma.getId_Turma());
            rs = pst.executeQuery();
            while(rs.next()){
                
                 Aluno a = new Aluno();
            
           
                 a.setId_Aluno(rs.getInt("Id_Aluno"));
               
                 a.setNome(rs.getString("Nome"));
                  a.setRA(rs.getString("RA"));
                   a.setData_Nascimento(rs.getDate("Data_Nascimento"));
                 Alunos.add(a);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
       
        }
        return Alunos;
    

    
    }
          
           public boolean DeletarAlunos(Aluno aluno){
    Connection conex = null;
    boolean retornar = false;
        conex = criarConexao();
    String sql = "Delete From aluno where Id_Aluno = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conex.prepareStatement(sql);
            pst.setInt(1, aluno.getId_Aluno());
            pst.executeUpdate();
            retornar = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
       
        }
        return retornar;
    

    
    }
           
         
             
          public ArrayList<Aluno> SelecionarIdAlunos(Aluno Nome){
    
       
    String sql = "Select Id_Aluno From aluno where Id_Turma = ? and Nome = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection conex = null;
        conex = criarConexao();
        ArrayList<Aluno> Alunos = new ArrayList<>();
        try {
            pst = conex.prepareStatement(sql);
            pst.setInt(1, Nome.getId_Turma());
              pst.setString(2, Nome.getNome());
            rs = pst.executeQuery();
            while(rs.next()){
                
                 Aluno a = new Aluno();
            
           
                 a.setId_Aluno(rs.getInt("Id_Aluno"));
                 Alunos.add(a);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
       
        }
        return Alunos;
    

    
    }
}
