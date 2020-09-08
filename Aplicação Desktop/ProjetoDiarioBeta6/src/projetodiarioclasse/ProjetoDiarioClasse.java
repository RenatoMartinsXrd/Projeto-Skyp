/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodiarioclasse;

import Interfaces.EscolhaDePerfil;
import java.sql.SQLException;

/**
 *
 * @author Scarlxrd2112
 */
public class ProjetoDiarioClasse {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       EscolhaDePerfil tela = new EscolhaDePerfil();
        tela.setVisible(true);
    }
    
}
