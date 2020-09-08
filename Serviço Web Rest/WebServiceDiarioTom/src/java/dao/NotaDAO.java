/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexão.conexaobanco;

import Modelo.Bean.Avaliacao;
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
public class NotaDAO extends ConnectionFactory {
       
  private static NotaDAO instance;
    
    
public static NotaDAO getInstance(){
		if(instance == null)
			instance = new NotaDAO();
		return instance;
	}    
    
    public NotaDAO(){
      
    }
    
    public boolean Salvar(Nota nota){
        //String sql = "Insert Into aluno(Numero_Chamada,Nome) Values (?,?)";
        String sql = "Insert Into nota(Id_Professor,Id_Aluno,Id_Turma,Id_Avaliacao,Id_Bimestre,Nota) Values (?,?,?,?,?,?)";
        PreparedStatement pst = null;
         Connection conex = null;     
        conex = criarConexao();
        try {
            
            pst = conex.prepareStatement(sql);
           
             pst.setInt(1, nota.getId_Professor());
            pst.setInt(2,nota.getId_Aluno());
             pst.setInt(3,nota.getId_Turma());
        
             pst.setInt(4, nota.getId_Avaliacao());
               pst.setInt(5, nota.getId_Bimestre());
               pst.setDouble(6,nota.getNota()) ;
           
   
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    public ArrayList<Nota> SelecionarAvaliacoesnOTAS(Nota a){
   
    String sql = "Select * From nota where Id_Professor = ? and Id_Turma = ? and Id_Aluno = ? and Id_Bimestre= ? ";
        PreparedStatement pst = null; 
        ResultSet rs = null;
         Connection conex = null;     
        conex = criarConexao();
        ArrayList<Nota> avaliacoes = new ArrayList<Nota>();
        try {
            pst = conex.prepareStatement(sql);
            pst.setInt(1, a.getId_Professor());
           pst.setInt(2, a.getId_Turma());
           pst.setInt(3, a.getId_Aluno());
            pst.setInt(4, a.getId_Bimestre());
           
   
            rs = pst.executeQuery();
            while(rs.next()){
             
             Nota avaliar = new Nota();
           
               avaliar.setId_Avaliacao(rs.getInt("Id_Avaliacao"));
               avaliar.setNota(rs.getDouble("Nota"));
               avaliacoes.add(avaliar);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return avaliacoes;
    }
      
                
}
