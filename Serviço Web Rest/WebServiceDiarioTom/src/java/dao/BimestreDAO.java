/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import Modelo.Bean.Bimestre;
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
 * @author Automação
 */

public class BimestreDAO extends ConnectionFactory {
    	private static BimestreDAO instance;
	
	
	/**
	 * 
	 * M�todo respons�vel por criar uma instancia da classe ClienteDAO (Singleton)
	 *
	 * @return
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 02:03:47
	 * @version 1.0
	 */
	public static BimestreDAO getInstance(){
		if(instance == null)
			instance = new BimestreDAO();
		return instance;
	}
    
     public  ArrayList<Bimestre> SelecionarBimestre(){
      
      
    String sql = "Select * From bimestre";
        PreparedStatement pst = null; 
        ResultSet rs = null;
        Connection conexaobanco = null;
        conexaobanco = criarConexao();
        ArrayList<Bimestre> bi = new ArrayList<>();
        try {
            pst = conexaobanco.prepareStatement(sql);
          
            
            rs = pst.executeQuery();
            while(rs.next()){
              
                Bimestre bimestre = new Bimestre();
             bimestre.setId_Bimestre(rs.getInt("Id_Bimestre"));
           bimestre.setBimestre(rs.getString("Bimestre"));
 
               bi.add(bimestre);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return bi;
    }
     
 public  ArrayList<Bimestre> SelecionarId_Bimestre(Bimestre bimestre){
       
      
    String sql = "Select Id_Bimestre From bimestre where Bimestre = ?";
        PreparedStatement pst = null; 
        ResultSet rs = null;
        Connection conex = null;
        ArrayList<Bimestre> bimestres = new ArrayList<>();
        Bimestre bis = null;
        conex = criarConexao();
        try {
            
            pst = conex.prepareStatement(sql);
          
            pst.setString(1, bimestre.getBimestre());
            rs = pst.executeQuery();
            while(rs.next()){
              bis = new Bimestre();
        
             bis.setId_Bimestre(rs.getInt("Id_Bimestre"));
        
 
               bimestres.add(bis);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return bimestres;
    }
    
    
}
