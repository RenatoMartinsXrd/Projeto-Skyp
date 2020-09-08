/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexão.conexaobanco;

import Modelo.Bean.Avaliacao;
import Modelo.Bean.Media;
import Modelo.Bean.Nota;

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
public class MediaDAO extends ConnectionFactory {
       
  private static MediaDAO instance;
    
    
public static MediaDAO getInstance(){
		if(instance == null)
			instance = new MediaDAO();
		return instance;
	}    
    
    public MediaDAO(){
      
    }
    
    public boolean Salvar(Media nota){
        //String sql = "Insert Into aluno(Numero_Chamada,Nome) Values (?,?)";
        String sql = "Insert Into media_final(Id_Aluno,Id_Turma,Id_Professor,Id_Bimestre,Falta_Total,Media) Values (?,?,?,?,?,?)";
        PreparedStatement pst = null;
         Connection conex = null;     
        conex = criarConexao();
        try {
            
            pst = conex.prepareStatement(sql);
           
             pst.setInt(1, nota.getId_Aluno());
            pst.setInt(2,nota.getId_Turma());
             pst.setInt(3,nota.getId_Professor());
        
             pst.setInt(4, nota.getId_Bimestre());
               pst.setInt(5, nota.getFalta_Total());
               pst.setDouble(6,nota.getMedia()) ;
           
   
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    public ArrayList<Media> SelecionarMediaBimestre(Media a){
   
    String sql = "Select * From media_final where Id_Turma = ? and Id_Aluno = ? and Id_Bimestre= ? ";
        PreparedStatement pst = null; 
        ResultSet rs = null;
         Connection conex = null;     
        conex = criarConexao();
        ArrayList<Media> avaliacoes = new ArrayList<Media>();
        try {
            pst = conex.prepareStatement(sql);
            
           pst.setInt(1, a.getId_Turma());
           pst.setInt(2, a.getId_Aluno());
            pst.setInt(3, a.getId_Bimestre());
           
   
            rs = pst.executeQuery();
            while(rs.next()){
             
             Media avaliar = new Media();
           
               avaliar.setFalta_Total(rs.getInt("Falta_Total"));
               avaliar.setMedia(rs.getDouble("Media"));
               avaliar.setId_Professor(rs.getInt("Id_Professor"));
               avaliacoes.add(avaliar);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return avaliacoes;
    }
      public ArrayList<Media> SelecionarTodasMedia(Media a){
   
    String sql = "Select * From media_final where Id_Turma = ? and Id_Aluno = ?";
        PreparedStatement pst = null; 
        ResultSet rs = null;
         Connection conex = null;     
        conex = criarConexao();
        ArrayList<Media> avaliacoes = new ArrayList<Media>();
        try {
            pst = conex.prepareStatement(sql);
           
           pst.setInt(2, a.getId_Aluno());
           
           
   
            rs = pst.executeQuery();
            while(rs.next()){
             
             Media avaliar = new Media();
           
               avaliar.setFalta_Total(rs.getInt("Falta_Total"));
               avaliar.setMedia(rs.getDouble("Media"));
               avaliar.setId_Professor(rs.getInt("Id_Professor"));
               avaliacoes.add(avaliar);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return avaliacoes;
    }
                
}
