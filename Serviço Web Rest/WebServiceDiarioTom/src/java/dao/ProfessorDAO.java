/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import Modelo.Bean.Professor;
import Modelo.Bean.ProfessorCadastro;
import Modelo.Bean.Usuario;
import factory.ConnectionFactory;
import static factory.ConnectionFactory.criarConexao;
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
public class ProfessorDAO extends ConnectionFactory{
    private static ProfessorDAO instance;
 public static ProfessorDAO getInstance(){
		if(instance == null)
			instance = new ProfessorDAO ();
		return instance;
	}
   
    
    
    
    
     public boolean SalvarId_ProfessorComId_Usuario(Professor Profecadastro){
        String sql = "Insert Into professor(Id_Professor,Id_Usuario) Values (?,?)";
        PreparedStatement pst = null;
         Connection conexao = null;
        boolean retorno = false;
        conexao = criarConexao();
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1,Profecadastro.getId_Professor());
            pst.setInt(2,Profecadastro.getId_Usuario());
         
            if(pst.executeUpdate()>0){
                retorno = true;
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
         
         
        }
        return retorno;
     }
    public ArrayList<Professor> SelecionarId_Professor(Professor professor){
    
    String sql = "Select * From professor where Id_Usuario = ? ";
        PreparedStatement pst = null; 
        ResultSet rs = null;
        Connection conexao = null;
        boolean retorno = false;
        conexao = criarConexao();
        
        ArrayList<Professor> professores = new ArrayList<>();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,professor.getId_Usuario().getId_Usuario());
            
            rs = pst.executeQuery();
            while(rs.next()){
               Professor prof = new Professor();
               ProfessorCadastro profcadastro = new ProfessorCadastro();
               profcadastro.setId_Professor(rs.getInt("Id_Professor"));
             prof.setId_Professor(profcadastro);
             Usuario usu = new Usuario();
             usu.setId_Usuario(rs.getInt("Id_Usuario"));
             prof.setId_Usuario(usu);
                professores.add(prof);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return professores;
    }
}
