/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import Modelo.Bean.Secretaria;
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
public class secretariaDAO1 extends ConnectionFactory {
    
    private static secretariaDAO1 instance;
    
    
  
public static secretariaDAO1 getInstance(){
		if(instance == null)
			instance = new secretariaDAO1();
		return instance;
	}

  
    
 
    public boolean AutenticarLoginSecretaria(Secretaria Login,Secretaria Senha){
     Connection conexao = null; 
        
    PreparedStatement pst = null;
      ResultSet rs = null;
       ArrayList<Secretaria> usuarioSecretaria = null;
        String sql = "Select Id_Secretaria From secretaria where Login = ? and Senha= ? ";
   
      
        conexao = criarConexao();
        boolean autenticar = false;
        Secretaria s = null;
        
       usuarioSecretaria = new ArrayList<Secretaria>();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,Login.getLogin());
            pst.setString(2,Senha.getSenha());
            rs = pst.executeQuery();
            if(rs.next()){
                s = new Secretaria();
                s.setId_Secretaria(rs.getInt("Id_Secretaria"));
                usuarioSecretaria.add(s);
                autenticar = true;
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(secretariaDAO1.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
       
        }
        return autenticar;
    

    
    }
   
    
    
    
    
    
    public boolean AutenticarLoginSecretariaObjeto(Secretaria Login){
     Connection conexao = null; 
        
    PreparedStatement pst = null;
      ResultSet rs = null;
       ArrayList<Secretaria> usuarioSecretaria = null;
        String sql = "Select Id_Secretaria From secretaria where Login = ? and Senha= ? ";
   
      
        conexao = criarConexao();
        boolean autenticar = false;
        Secretaria s = null;
        
       usuarioSecretaria = new ArrayList<Secretaria>();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,Login.getLogin());
            pst.setString(2,Login.getSenha());
            rs = pst.executeQuery();
            if(rs.next()){
                s = new Secretaria();
                s.setId_Secretaria(rs.getInt("Id_Secretaria"));
                usuarioSecretaria.add(s);
                autenticar = true;
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(secretariaDAO1.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
       
        }
        return autenticar;
    

    
    }
    }
     
  
   
    

    
    
    

     

