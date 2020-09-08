/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modelo.Bean.Frequencia;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Scarlxrd2112
 */
public class FrequenciaDAO extends ConnectionFactory {
         private static FrequenciaDAO instance;
    
    
  
public static FrequenciaDAO getInstance(){
		if(instance == null)
			instance = new FrequenciaDAO();
		return instance;
	}
    public boolean Salvar(Frequencia avaliar){
        
        String sql = "Insert Into frequencia(Id_Professor,Id_Bimestre,Id_Turma,Id_Aluno,Data,Falta) Values (?,?,?,?,?,?)";
     
        
        PreparedStatement pst = null;
        Connection conex = null;     
        conex = criarConexao();
        boolean retorno = false;
        try {
             pst = conex.prepareStatement(sql);
          
           pst.setInt(1,avaliar.getId_Professor());
            pst.setInt(2, avaliar.getId_Bimestre());
            pst.setInt(3, avaliar.getId_Turma());
           
            pst.setInt(4,avaliar.getId_Aluno());
           pst.setDate(5,avaliar.getData());
            pst.setString(6,avaliar.getFalta());
        
            
            if(pst.executeUpdate()>0){
            retorno = true;                
            }
             
          
            
        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
       
        } 
        return retorno;

        
        }
    
    
     
      public ArrayList<Frequencia> Selecionarfre(Frequencia a){
   
    String sql = "Select Id_Aluno,COUNT(Falta) as Total_Falta From frequencia where Data Between ? and ? and Falta = ? and Id_Professor = ? and Id_Aluno = ? and Id_Turma = ? Group By Id_Aluno";
        PreparedStatement pst = null; 
        ResultSet rs = null;
         Connection conex = null;     
        conex = criarConexao();
         ArrayList<Frequencia> faltas = new ArrayList<Frequencia>();
         Frequencia avaliar = null;
        try {
            pst = conex.prepareStatement(sql);
          
           pst.setDate(1, a.getData());
             pst.setDate(2, a.getData_Saida());
            pst.setString(3,a.getFalta());
            pst.setInt(4, a.getId_Professor());
             pst.setInt(5, a.getId_Aluno());
               pst.setInt(6, a.getId_Turma());
            rs = pst.executeQuery();
           
           while(rs.next()){
           
             avaliar = new Frequencia();
             avaliar.setId_Aluno(rs.getInt("Id_Aluno"));
              
               avaliar.setTotal_Falta(rs.getInt("Total_Falta"));
            
         faltas.add(avaliar);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return faltas;
    }
     
      
     public ArrayList<Frequencia> SelecionarTudo(Frequencia a){
   
    String sql = "Select Data From frequencia where Falta = ? and Id_Professor = ? and Id_Aluno = ? and Id_Turma = ? and Id_Bimestre = ? ";
        PreparedStatement pst = null; 
        ResultSet rs = null;
         Connection conex = null;     
        conex = criarConexao();
         ArrayList<Frequencia> faltas = new ArrayList<Frequencia>();
         Frequencia avaliar = null;
        try {
            pst = conex.prepareStatement(sql);
          
            pst.setString(1,a.getFalta());
            pst.setInt(2, a.getId_Professor());
             pst.setInt(3, a.getId_Aluno());
            pst.setDouble(4, a.getId_Bimestre());
            rs = pst.executeQuery();
           
           while(rs.next()){
           
             avaliar = new Frequencia();
                //  avaliar.setId_Aluno(rs.getInt("Id_Aluno"));
                 //  avaliar.setFalta(rs.getString("Falta"));
                  //  avaliar.setId_Turma(rs.getInt("Id_Turma"));
              avaliar.setData(rs.getDate("Data"));
             // avaliar.setTotal_Falta(rs.getInt("Total_Falta"));
         faltas.add(avaliar);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return faltas;
    }
     
      public Frequencia SelecionarFrequenciaBimestre(Frequencia a){
   
    String sql = "Select Id_Aluno,COUNT(Falta) as Total_Falta From frequencia where Falta = ? and Id_Professor = ? and Id_Aluno = ? and Id_Turma = ? and Id_Bimestre = ?";
        PreparedStatement pst = null; 
        ResultSet rs = null;
         Connection conex = null;     
        conex = criarConexao();
        
         Frequencia avaliar = new Frequencia();
        try {
            pst = conex.prepareStatement(sql);
          
         
            pst.setString(1,a.getFalta());
            pst.setInt(2, a.getId_Professor());
             pst.setInt(3, a.getId_Aluno());
          
       
               pst.setInt(4, a.getId_Turma());
                    pst.setInt(5, a.getId_Bimestre());
            rs = pst.executeQuery();
           
           while(rs.next()){
           
         
             avaliar.setId_Aluno(rs.getInt("Id_Aluno"));
              
               avaliar.setTotal_Falta(rs.getInt("Total_Falta"));
            
         
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return avaliar;
    }
     
}
