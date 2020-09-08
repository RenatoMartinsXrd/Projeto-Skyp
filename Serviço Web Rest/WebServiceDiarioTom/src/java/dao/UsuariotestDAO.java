package dao;

import Modelo.Bean.Professor;
import Modelo.Bean.ProfessorCadastro;
import Modelo.Bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import factory.ConnectionFactory;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Classe respons�vel por conter os metodos do CRUD
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 01:55:13
 * @version 1.0
 */
public class UsuariotestDAO extends ConnectionFactory {

	private static UsuariotestDAO instance;
	
	
	/**
	 * 
	 * M�todo respons�vel por criar uma instancia da classe ClienteDAO (Singleton)
	 *
	 * @return
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 02:03:47
	 * @version 1.0
	 */
	public static UsuariotestDAO getInstance(){
		if(instance == null)
			instance = new UsuariotestDAO();
		return instance;
	}
	
	/**
	 * 
	 * M�todo respons�vel por listar todos os clientes do banco
	 *
	 * @return ArrayList<CLiente> clientes
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 02:01:35
	 * @version 1.0
	 */
	public ArrayList<Usuario> listarTodos(){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Usuario> usuarios = null;
		
		conexao = criarConexao();
		usuarios = new ArrayList<Usuario>();
		try {
			pstmt = conexao.prepareStatement("select * from usuario");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				Usuario usuario = new Usuario();
                                usuario.setId_Usuario(rs.getInt("Id_Usuario"));
			        usuario.setLogin(rs.getString("Login"));
				 usuario.setSenha(rs.getString("Senha"));
				usuarios.add(usuario);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os clientes: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return usuarios;
	}
        
            public ArrayList SelecionarLogin(Usuario usuariologi,Usuario Senha){
      
    String sql = "Select * From usuario where Login = ? and Senha = ?";
      String sql2 = "Select Id_Professor from professor where Id_Usuario = ? ";
        PreparedStatement pst = null;
       PreparedStatement pst2 = null;
        Connection conexao = null;
       conexao = criarConexao();
       ArrayList usuarios;
       
       usuarios = new ArrayList();
       boolean autenticar = false;
             Usuario usuario = null;
             ProfessorCadastro professor = null;
             int Id_Usuario = 0;
        try {
            pst = conexao.prepareStatement(sql);;
          
            pst.setString(1,usuariologi.getLogin());
               pst.setString(2,Senha.getSenha());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            usuario = new Usuario();
            professor = new ProfessorCadastro();
             usuario.setId_Usuario(rs.getInt("Id_Usuario"));
         
  
             for(int i = 0;i<usuarios.size();i++){
                 Id_Usuario = usuario.getId_Usuario();
             }
             
              pst2 = conexao.prepareStatement(sql2);;
          
            pst2.setInt(1,Id_Usuario);
            
            ResultSet rs2 = pst2.executeQuery();
            if(rs2.next()){
                professor.setId_Professor(rs2.getInt("Id_Professor"));
               
            }
       
            }
           
      
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return usuarios;
    }
            
            public boolean buscar(Usuario usuario) 
    {
         String sql = "SELECT * FROM usuario where Login=?";
       boolean retorno = false;
       Usuario user = null;
        Connection conexao = null;
        conexao = criarConexao();
       
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario.getLogin());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
              user = new Usuario();
               user.setId_Usuario(res.getInt("Id_Usuario"));
               user.setLogin(res.getString("Login"));
                user.setSenha(res.getString("Senha"));
             retorno = true;
                
                
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariotestDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }

       public Professor SelecionarLoginObjeto(Usuario usuariologi){
      
    String sql = "Select * From usuario where Login = ? and Senha = ?";
      String sql2 = "Select Id_Professor from professor where Id_Usuario = ? ";
        PreparedStatement pst = null;
       PreparedStatement pst2 = null;
        Connection conexao = null;
       conexao = criarConexao();
         Professor p = null;
   
             Usuario usuario = null;
             ProfessorCadastro professor = null;
             int Id_Usuario = 0;
             int Id_Professor = 0;
        try {
            pst = conexao.prepareStatement(sql);;
          
            pst.setString(1,usuariologi.getLogin());
               pst.setString(2,usuariologi.getSenha());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            usuario = new Usuario();
            professor = new ProfessorCadastro();
             usuario.setId_Usuario(rs.getInt("Id_Usuario"));
         
        
           
                 Id_Usuario = usuario.getId_Usuario();
             
             
              pst2 = conexao.prepareStatement(sql2);;
          
            pst2.setInt(1,Id_Usuario);
            
            ResultSet rs2 = pst2.executeQuery();
            if(rs2.next()){
                professor.setId_Professor(rs2.getInt("Id_Professor"));
                Id_Professor = professor.getId_Professor();
              
            }
       
            }
         p = new Professor();
           p.setId_Professor(Id_Professor);
           p.setId_Usuario(Id_Usuario);
      
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return p;
    }  
        
	
}
