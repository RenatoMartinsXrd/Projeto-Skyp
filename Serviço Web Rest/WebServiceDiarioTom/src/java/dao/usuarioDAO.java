/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import Modelo.Bean.Usuario;
import static factory.ConnectionFactory.criarConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;




import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Scarlxrd2112
 */
public class usuarioDAO {
    	private static usuarioDAO instance;


    public usuarioDAO() {
      
    }
    
    	public static usuarioDAO getInstance(){
		if(instance == null)
			instance = new usuarioDAO ();
		return instance;
	}
    
    public boolean Salvar(Usuario usuario){
        String sql = "Insert Into usuario(Login,Senha) Values (?,?)";
         Connection conexao = null;
          Boolean retorno = false;
        conexao = criarConexao();
        PreparedStatement pst = null;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,usuario.getLogin());
            pst.setString(2,usuario.getSenha());
       if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        
        }
                return retorno;
    }
    public boolean AutenticarLogin(String Login){
    
        con.conexao();
    String sql = "Select * From usuario where Login = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean autenticar = false;
        
        List<Usuario> usuarios = new ArrayList<>();
        try {
            pst = con.conex.prepareStatement(sql);
            pst.setString(1,Login);
            
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
    public Usuario SelecionarLogin(String Login){
       con.conexao();
    String sql = "Select * From usuario where Login ";
        PreparedStatement pst = null;
        ResultSet rs = null;
        
       
        try {
            pst = con.conex.prepareStatement(sql);
          
            pst.setString(1,Login);
           
            rs = pst.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
             usuario.setId_Usuario(rs.getInt("Id_Usuario"));
             usuario.setLogin(rs.getString("Login"));
             usuario.setSenha(rs.getString("Senha"));
                usuarios.add(usuario);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return Usuario;
    }
        public List<Usuario> ListarTudoTeste(){
       con.conexao();
    String sql = "Select * From usuario";
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        try {
            pst = con.conex.prepareStatement(sql);
            rs = pst.executeQuery();
         
            while(rs.next()){
                Usuario usuario = new Usuario();
             usuario.setId_Usuario(rs.getInt("Id_Usuario"));
             usuario.setLogin(rs.getString("Login"));
             usuario.setSenha(rs.getString("Senha"));
                usuarios.add(usuario);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return usuarios;
    }
     
  
   
    

    
    
    

     
}
