/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modelo.Bean.Avaliacao;
import Modelo.Bean.ConteudoProgramatico;
import static factory.ConnectionFactory.criarConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Scarlxrd2112
 */
public class ConteudoProgramaticoDAO {
    	private static ConteudoProgramaticoDAO instance;
	
	
	/**
	 * 
	 * M�todo respons�vel por criar uma instancia da classe ClienteDAO (Singleton)
	 *
	 * @return
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 02:03:47
	 * @version 1.0
	 */
	public static ConteudoProgramaticoDAO getInstance(){
		if(instance == null)
			instance = new ConteudoProgramaticoDAO();
		return instance;
	}
       public boolean Salvar(ConteudoProgramatico avaliar){
        
        String sql = "Insert Into conteudo_programatico(Id_Turma,Id_Professor,Id_Bimestre,Conteudo_Programatico,Data_Conteudo) Values (?,?,?,?,?)";
     
        
        PreparedStatement pst = null;
        Connection conex = null;     
        conex = criarConexao();
        boolean retorno = false;
        try {
             pst = conex.prepareStatement(sql);
            pst.setInt(1, avaliar.getId_Turma());
            pst.setInt(2,avaliar.getId_Professor());      
            pst.setInt(3, avaliar.getId_Bimestre());
            pst.setString(4,avaliar.getConteudoProgramatico());
            pst.setDate(5,avaliar.getData_ConteudoProgramatico());
            
            if(pst.executeUpdate()>0){
            retorno = true;                
            }
             
          
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
       
        } 
        return retorno;

        
        }
}
