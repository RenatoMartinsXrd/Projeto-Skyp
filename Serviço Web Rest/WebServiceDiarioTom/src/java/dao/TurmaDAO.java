/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;








import Modelo.Bean.Turma;
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
public class TurmaDAO extends ConnectionFactory {
    private static TurmaDAO instance;
 public static TurmaDAO getInstance(){
		if(instance == null)
			instance = new TurmaDAO ();
		return instance;
	}

    public TurmaDAO() {
   
    }
    
    public boolean Salvar(Turma turma){
        String sql = "Insert Into turma(Serie,Ano,Periodo) Values (?,?,?)";
        PreparedStatement pst = null;
        Connection conexao = null;
        boolean retorno = false;
        conexao = criarConexao();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,turma.getSerie());
            pst.setString(2,turma.getAno());
            pst.setString(3,turma.getPeriodo());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
          
        } 
        return retorno;
         
    }

     
  
   
    public ArrayList<Turma> SelecionarTodasTurmas(){
     
      
    String sql = "Select * From turma";
        PreparedStatement pst = null; 
        ResultSet rs = null;
        Connection conex = null;
        boolean retorno = false;
        conex = criarConexao();
        ArrayList<Turma> turmas = new ArrayList<>();
        try {
            pst = conex.prepareStatement(sql);
          
            
            rs = pst.executeQuery();
            while(rs.next()){
               Turma turma = new Turma();
        
             turma.setId_Turma(rs.getInt("Id_Turma"));
  turma.setSerie(rs.getString("Serie"));
  turma.setPeriodo(rs.getString("Periodo"));
  turma.setAno(rs.getString("Ano"));
               turmas.add(turma);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return turmas;
    }
   
   
   
    public ArrayList<Turma> SelecionarId_TurmaSerie(Turma tur){
     
       
    String sql = "Select * From turma where Serie = ?";
        PreparedStatement pst = null; 
        ResultSet rs = null;
           Connection conex = null;
        boolean retorno = false;
        conex = criarConexao();
        ArrayList<Turma> turmas = new ArrayList<>();
        try {
            pst = conex.prepareStatement(sql);
           pst.setString(1,tur.getSerie());
            
            rs = pst.executeQuery();
            while(rs.next()){
               Turma turma = new Turma();
               
             
        turma.setId_Turma(rs.getInt("Id_Turma"));
  turma.setSerie(rs.getString("Serie"));
               turmas.add(turma);
            }
           
        
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
        }
        return turmas;
    }
    
    
    
    
    

     
}
