package dao;

import Modelo.Bean.Aluno;
import Modelo.Bean.Chamada;
import Modelo.Bean.Professor;
import Modelo.Bean.ProfessorCadastro;
import Modelo.Bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import factory.ConnectionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

/**
 * 
 * Classe respons�vel por conter os metodos do CRUD
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 01:55:13
 * @version 1.0
 */
public class ChamadaDAO extends ConnectionFactory {

	private static ChamadaDAO instance;
	private String fodase;
	
	/**
	 * 
	 * M�todo respons�vel por criar uma instancia da classe ClienteDAO (Singleton)
	 *
	 * @return
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 02:03:47
	 * @version 1.0
	 */
	public static ChamadaDAO getInstance(){
		if(instance == null)
			instance = new ChamadaDAO();
              
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
        
         public boolean InserirChamada(Chamada chamada){
    
        ResultSet rs = null;
        PreparedStatement pst = null;
        	Connection conexao = null;
                conexao = criarConexao();
        String sql = "Insert Into chamada(Id_Turma,Id_Aluno,Numero_Chamada,Nome) Values (?,?,?,?)";
       try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,chamada.getId_Turma());
            pst.setInt(2,chamada.getId_Aluno());
            pst.setInt(3,chamada.getNumero_Chamada());
            pst.setString(4,chamada.getNome());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        
        }       
}
    
    public boolean AutenticarListaChamada(Chamada coisas){
    	Connection conexao = null;
                conexao = criarConexao();
    String sql = "Select * From chamada where Nome = ? and Numero_Chamada =?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean autenticar = false;
        
       
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,coisas.getNome());
             pst.setInt(2,coisas.getNumero_Chamada());
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
    
          public ArrayList<Chamada> SelecionarChamada(Chamada Id_Turma){
    
     	Connection conexao = null;
                conexao = criarConexao();
    String sql = "Select * From chamada where Id_Turma = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
       
        
       ArrayList<Chamada> chamadas = new ArrayList<>();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id_Turma.getId_Turma());
            rs = pst.executeQuery();
            while(rs.next()){
                
                Chamada ch = new Chamada();
                Aluno a = new Aluno();
               
           ch.setId_Aluno(rs.getInt("Id_Aluno"));
           ch.setNome(rs.getString("Nome"));
           ch.setNumero_Chamada(rs.getInt("Numero_Chamada"));
               
                 chamadas.add(ch);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
       
        }
            return  chamadas;
    

    
    }
       public boolean ExcluirChamada(Chamada Id_Turma){
    	Connection conexao = null;
                conexao = criarConexao();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "DELETE FROM chamada WHERE Id_Turma = ?";
       try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,Id_Turma.getId_Turma());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        
        }       
}   
    
    }

        
        
	

