/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexão;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Scarlxrd2112
 */
public class conexaobanco {
    public Statement statement;//responsavel por preparar e realizar pesquisas banco de dados
    public ResultSet rs;//responsavel por amarzenar o resultado de uma pequisa passada pelo statement
    private String driver = "com.mysql.jdbc.Driver";//responsavel por indentificar o tipo de banco de dados
    private String caminho = "jdbc:mysql://localhost:80/diario_digitalbeta2";//responsavel por setar o local do bd de dados
    private String usuario = "root";
    private String senha = "";
    public Connection conex; //responsavel por realizar a conexão com o banco de dados
    
    public void conexao(){
        try {//tentativa inicial de executar o bloco abaixo
            System.setProperty("jdbc.Drivers", driver);//seta a propriedade do driver de conexão
            conex= DriverManager.getConnection(caminho, usuario, senha);//conexão com o banco
        } catch (SQLException ex) {//erro, exceto
            Logger.getLogger(conexaobanco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro" + "\n"+ ex.getMessage());
        }
                  }
    
    
    public void desconecta(){//metodo para fechar a conexão com o bd de dados
        try {
            conex.close();
            
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, " Erro ao fechar a conexão" + "\n"+ ex.getMessage());        }
    }
    
    public void executaSQL(String sql){
        try {
            statement = conex.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sql);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no executaSQL() \n" + ex);
        }
        
    }
    
}


    
 

