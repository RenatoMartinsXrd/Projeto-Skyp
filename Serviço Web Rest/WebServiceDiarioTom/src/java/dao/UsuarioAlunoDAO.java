/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import Modelo.Bean.UsuarioAluno;
import factory.ConnectionFactory;
import static factory.ConnectionFactory.criarConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Scarlxrd2112
 */
public class UsuarioAlunoDAO extends ConnectionFactory{
    private static UsuarioAlunoDAO instance;
 public static UsuarioAlunoDAO getInstance(){
		if(instance == null)
			instance = new UsuarioAlunoDAO ();
		return instance;
	}
   
    
    
    
    
     public boolean Salvar(UsuarioAluno Profecadastro){
        String sql = "Insert Into usuario_aluno(Id_Aluno,Login,Senha) Values (?,?,?)";
        PreparedStatement pst = null;
         Connection conexao = null;
        boolean retorno = false;
        conexao = criarConexao();
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1,Profecadastro.getId_Aluno());
            pst.setString(2,Profecadastro.getLogin());
             pst.setString(3,Profecadastro.getSenha());
            if(pst.executeUpdate()>0){
                retorno = true;
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
         
         
        }
        return retorno;
     }
    public UsuarioAluno SelecionarId_UsuarioAluno(UsuarioAluno professor){
    
    String sql = "Select * From usuario_aluno where Login = ? and Senha = ? ";
        PreparedStatement pst = null; 
        ResultSet rs = null;
        Connection conexao = null;
        boolean retorno = false;
        conexao = criarConexao();
        
        UsuarioAluno profcadastro = new UsuarioAluno ();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,professor.getLogin());
             pst.setString(2,professor.getSenha());
            rs = pst.executeQuery();
            while(rs.next()){
           
            
            
                 profcadastro.setId_Usuario_Aluno(rs.getInt("Id_Usuario_Aluno"));
                    profcadastro.setId_Aluno(rs.getInt("Id_Aluno"));
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return profcadastro;
    }
}
