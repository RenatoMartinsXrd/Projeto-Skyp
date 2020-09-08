package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 
 * Classe respons�vel por conter os metodos criar e fechar o banco de dados.
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 01:54:02
 * @version 1.0
 */
public class ConnectionFactory {

	//Caminho do banco de dados.
	//private static final String DRIVER = "com.mysql.jdbc.Driver";
       // private static final String URL = "jdbc:mysql://projetodiario.mysql.database.azure.com:3306/projetodiario?useSSL=true&requireSSL=false";
	//private static final String USUARIO = "rootroot@projetodiario";
	//private static final String SENHA = "Root.Root";
        
    
    
      private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/diario_digitalbeta2";
private static final String USUARIO = "root";
private static final String SENHA = "";
    
        //private static final String DRIVER = "com.mysql.jdbc.Driver";
	  //private static final String URL = "jdbc:mysql://node174912-projetoskyp.jelasticlw.com.br/diario_digitalbeta2";
	  //private static final String USUARIO = "root";
	  //private static final String SENHA = "KZZkaz37644"; 

	/**
	 * 
	 * M�todo respons�vel por criar uma conexao com o banco 
	 *
	 * @return
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 01:51:54
	 * @version 1.0
	 */

	public static Connection criarConexao(){
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		} catch (Exception e) {
			System.out.println("Erro ao criar conex�o com o banco: " + URL);
			e.printStackTrace();
		}
		return conexao;
	}
	
	
	public static void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs){
		
		try {
			
			if(conexao != null){
				conexao.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
					
		} catch (Exception e) {
			System.out.println("Erro ao fechar conex�o com o banco: " + URL);
		}
	}
}

