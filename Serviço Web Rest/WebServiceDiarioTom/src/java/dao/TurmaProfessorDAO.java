/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;





import Modelo.Bean.TurmaProfessor;
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
public class TurmaProfessorDAO extends ConnectionFactory {
   
    private static TurmaProfessorDAO instance;
 public static TurmaProfessorDAO getInstance(){
		if(instance == null)
			instance = new TurmaProfessorDAO ();
		return instance;
	}
    public TurmaProfessorDAO() {
     
    }
    
         public boolean SalvarTurmaProfessor(TurmaProfessor Profecadastro){
        String sql = "Insert Into turma_professor(Id_Professor,Id_Turma,Serie) Values (?,?,?)";
        PreparedStatement pst = null;
        Connection conexao = null;
        conexao = criarConexao();
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement(sql);
         
           
            pst.setInt(1,Profecadastro.getId_Professor());
            pst.setInt(2,Profecadastro.getId_Turma());
            pst.setString(3,Profecadastro.getSerie());
            if(pst.executeUpdate()>0){
               retorno = true; 
            }
       
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
          
         
        }
        return retorno;
    }
         
     public ArrayList<TurmaProfessor> SelecionarTurmaProfessor(TurmaProfessor turma){
   
    Connection conex = null;
        conex = criarConexao();
    String sql = "Select * From turma_professor where Id_Professor = ? ";
        PreparedStatement pst = null; 
        ResultSet rs = null;
     
        ArrayList<TurmaProfessor> turmas = new ArrayList<>();
        try {
            pst = conex.prepareStatement(sql);
          pst.setInt(1,turma.getId_Professor());
             
            
            rs = pst.executeQuery();
            while(rs.next()){
           
            TurmaProfessor t = new TurmaProfessor();
         
             t.setId_Turma(rs.getInt("Id_Turma"));
     
             t.setSerie(rs.getString("Serie"));
               turmas.add(t);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return turmas;
    }
}
     

