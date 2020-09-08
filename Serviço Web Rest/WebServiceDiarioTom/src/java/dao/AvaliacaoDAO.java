/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import Conexão.conexaobanco;
import Modelo.Bean.Avaliacao;
import Modelo.Bean.Bimestre;
import Modelo.Bean.ProfessorCadastro;
import Modelo.Bean.Usuario;
import factory.ConnectionFactory;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Scarlxrd2112
 */
public class AvaliacaoDAO extends ConnectionFactory {
    
  private static AvaliacaoDAO instance;
    
    
  
public static AvaliacaoDAO getInstance(){
		if(instance == null)
			instance = new AvaliacaoDAO();
		return instance;
	}

    public AvaliacaoDAO()  {
    
    }
    
    public boolean Salvar(Avaliacao avaliar){
        
        String sql = "Insert Into avaliacao(Id_Professor,Id_Bimestre,Id_Turma,Serie,Bimestre,Titulo,Descricao,Data_Avaliacao) Values (?,?,?,?,?,?,?,?)";
     
        
        PreparedStatement pst = null;
        Connection conex = null;     
        conex = criarConexao();
        boolean retorno = false;
        try {
             pst = conex.prepareStatement(sql);
          
           pst.setInt(1,avaliar.getId_Professor());
            pst.setInt(2, avaliar.getId_Bimestre());
            pst.setInt(3, avaliar.getId_Turma());
           
            pst.setString(4,avaliar.getSerie());
           pst.setString(5,avaliar.getBimestre());
            pst.setString(6,avaliar.getTitulo());
            pst.setString(7,avaliar.getDescrição());
             pst.setDate(8,avaliar.getData_Avaliacao());
            
            if(pst.executeUpdate()>0){
            retorno = true;                
            }
             
          
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
       
        } 
        return retorno;

        
        }
    
    
    
    
     public ArrayList<Avaliacao> SelecionarAvaliacoesnOTAS(Avaliacao a){
   
    String sql = "Select * From avaliacao where Id_Professor = ? and Id_Bimestre = ? and Id_Turma = ?";
        PreparedStatement pst = null; 
        ResultSet rs = null;
         Connection conex = null;     
        conex = criarConexao();
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        try {
            pst = conex.prepareStatement(sql);
            pst.setInt(1, a.getId_Professor());
            pst.setInt(2, a.getId_Bimestre());
            pst.setInt(3, a.getId_Turma());
            rs = pst.executeQuery();
            while(rs.next()){
             
             Avaliacao avaliar = new Avaliacao();
             avaliar.setTitulo(rs.getString("Titulo"));
               avaliar.setDescrição(rs.getString("Descricao"));
               avaliar.setId_Avaliacao(rs.getInt("Id_Avaliacao"));
               avaliar.setBimestre(rs.getString("Bimestre"));
               avaliar.setData_Avaliacao(rs.getDate("Data_Avaliacao"));
               avaliacoes.add(avaliar);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return avaliacoes;
    }
     
     public Avaliacao SelecionarComIdAvaliacao(Avaliacao a){
   
    String sql = "Select * From avaliacao where Id_Avaliacao = ?";
        PreparedStatement pst = null; 
        ResultSet rs = null;
         Connection conex = null;     
        conex = criarConexao();
     Avaliacao avaliar = new Avaliacao();
        try {
            pst = conex.prepareStatement(sql);
            pst.setInt(1, a.getId_Avaliacao());
        
            rs = pst.executeQuery();
            while(rs.next()){
             
             
             avaliar.setTitulo(rs.getString("Titulo"));
               avaliar.setDescrição(rs.getString("Descricao"));
               avaliar.setId_Avaliacao(rs.getInt("Id_Avaliacao"));
               avaliar.setBimestre(rs.getString("Bimestre"));
               avaliar.setData_Avaliacao(rs.getDate("Data_Avaliacao"));
              
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return avaliar;
    }
     
     
     
     public Avaliacao SelecionarIdAvaliacao(Avaliacao a){
   
    String sql = "Select * From avaliacao where Id_Professor = ? and Id_Bimestre = ? and Id_Turma = ? and Titulo=?";
        PreparedStatement pst = null; 
        ResultSet rs = null;
         Connection conex = null;     
        conex = criarConexao();
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
         Avaliacao avaliar = new Avaliacao();
        try {
            pst = conex.prepareStatement(sql);
            pst.setInt(1, a.getId_Professor());
            pst.setInt(2, a.getId_Bimestre());
            pst.setInt(3, a.getId_Turma());
             pst.setString(4, a.getTitulo());
            rs = pst.executeQuery();
           
            while(rs.next()){
               avaliar.setDescrição(rs.getString("Descricao"));
               avaliar.setId_Avaliacao(rs.getInt("Id_Avaliacao"));
               avaliar.setBimestre(rs.getString("Bimestre"));
               avaliar.setData_Avaliacao(rs.getDate("Data_Avaliacao"));
               avaliacoes.add(avaliar);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return avaliar;
    }
     
    }


     

     
    
    

     

