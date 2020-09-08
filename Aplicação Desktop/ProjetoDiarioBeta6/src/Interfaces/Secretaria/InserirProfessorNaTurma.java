/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Secretaria;



import Conexão.conexaobanco;
import Modelo.Bean.Rest.ProfessorCadastro;
import Modelo.Bean.Rest.TurmaProfessor;
import Modelo.Dao.Rest.ProfessorCadastroREST;
import Modelo.Dao.Rest.TurmaProfessorREST;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import Modelo.Bean.Rest.Turma;
import Modelo.Dao.Rest.TurmaREST;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mercado.ModeloTabelaBooleanProfessorTurma;

/**
 *
 * @author Scarlxrd2112
 */ 
public class InserirProfessorNaTurma extends javax.swing.JFrame {
    public static String itemDoComboboxProfessor;
     public static int Id_TurmaProfessor;
     public static String Nome;
      public static int Id_TurmaProfessorTurma;
         public static int Id_ProfessorProfessorTurma;
   JScrollPane rolagem;
    DefaultTableModel modelo;
     JTextField campo;
     ProfessorCadastro profcadastro = new ProfessorCadastro();
      ProfessorCadastro teste = new ProfessorCadastro();
     JComboBox combo;
  
    conexaobanco con = new conexaobanco();
     Turma turma = new Turma();

     TurmaProfessorREST tpdao = new TurmaProfessorREST();
     TurmaREST dao = new TurmaREST();
     ProfessorCadastroREST daoprof = new ProfessorCadastroREST();
     ProfessorCadastro prof = new ProfessorCadastro();
         ProfessorCadastroREST dao1 = new ProfessorCadastroREST();
              TurmaProfessor turmaprof = new TurmaProfessor();
   /**
     * Creates new form Tabela
     */
   String [] colunas = new String[]{"Nome","Diciplina","CPF"};
    
    ArrayList dados = new  ArrayList();
       ArrayList Nomes = new ArrayList();
       ArrayList Disciplina = new ArrayList();
          ArrayList arrayCPF = new ArrayList();
          String arraynome [];
         String arrayDisciplina [];
      
    public  InserirProfessorNaTurma() throws Exception {
  
        initComponents();
        Font roboto=null;
        try{
        roboto = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("Fonte/DJBChalkItUp.ttf"));
    }
    catch(IOException|FontFormatException e){
         System.out.println("Merda " + e);
    }
        roboto = roboto.deriveFont(Font.PLAIN, 30);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(roboto);  
        this.setFont(roboto);   
          preencherTabela();
           this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     

       
                                                                          
      
          
        
        campo = new JTextField();
        rolagem = new JScrollPane();
        combo = new JComboBox();
     

    
       
     
           
          
         
          /*
          rolagem.setViewportView(Jtabletabelaexcel);
        rolagem.setBounds(200,200,500,312);
        add(rolagem);
   */

    Jtabletabelaexcel2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                
                try {
                    int Lin = Jtabletabelaexcel2.getSelectedRow();
                    int Col = Jtabletabelaexcel2.getSelectedColumn();
                    if(Lin == -1 && Col==-1){
                        Lin = 0;
                        Col = 0;
                    }
                    Jtabletabelaexcel2.changeSelection(Lin,Col,false,false);
                    Jtabletabelaexcel2.editCellAt(Lin, Col);
                    Component celula = Jtabletabelaexcel2.getEditorComponent();
                    if(celula != null){
                        celula.requestFocus();
                    }
                } catch (Exception e) {}
            }
            @Override
            public void focusLost(FocusEvent fe) {
               
            }
              });
    
    campo.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
               ke.setKeyChar(Character.toUpperCase(ke.getKeyChar()));
            }

            @Override
            public void keyPressed(KeyEvent ke) {}

            @Override
            public void keyReleased(KeyEvent ke) {}
                

              });

    
    Jtabletabelaexcel3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                
                try {
                    int Lin = Jtabletabelaexcel3.getSelectedRow();
                    int Col = Jtabletabelaexcel3.getSelectedColumn();
                    if(Lin == -1 && Col==-1){
                        Lin = 0;
                        Col = 0;
                    }
                    Jtabletabelaexcel3.changeSelection(Lin,Col,false,false);
                    Jtabletabelaexcel3.editCellAt(Lin, Col);
                    Component celula = Jtabletabelaexcel3.getEditorComponent();
                    if(celula != null){
                        celula.requestFocus();
                    }
                } catch (Exception e) {}
            }
            @Override
            public void focusLost(FocusEvent fe) {
               
            }
              });
    
    campo.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
               ke.setKeyChar(Character.toUpperCase(ke.getKeyChar()));
            }

            @Override
            public void keyPressed(KeyEvent ke) {}

            @Override
            public void keyReleased(KeyEvent ke) {}
                

              });
    
    
    
    }
        
        
            
      public void preencherTabela() throws Exception{
           
          
//                filas[0]=rs.getString(1);
 
     
      String [] colunas = new String[]{"Incluir","Nome","CPF","Disciplina"};
          ArrayList dados = new  ArrayList();
//                filas[0]=rs.getString(1);
 
String [] colunas2 = new String[]{"Incluir","Serie","Período","Ano"};
          ArrayList dados2 = new  ArrayList();
     
     
  
   
                  
             for (ProfessorCadastro p : daoprof.ListarTodosProfessores()) {
                
                    
                     
                     
                     
                     
                     
                
                     
                    
                      dados.add(new Object[]{
                       turma.isIncluir(),p.getNome(),p.getCPF(),p.getDisciplina()
                      });
                     
  
                  
                  ModeloTabelaBooleanProfessorTurma modelo = new ModeloTabelaBooleanProfessorTurma(dados, colunas);
             Jtabletabelaexcel2.setModel(modelo);
              
        
   
                     
                 
             
                 
     
                     
      
      //((DefaultTableCellRenderer)Jtabletabelaexcel2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
          Jtabletabelaexcel2.setForeground(Color.BLACK);
          Jtabletabelaexcel2.setFont(new Font("DJB Chalk It Up",Font.BOLD,14));
          Jtabletabelaexcel2.getTableHeader().setFont(new Font("DJB Chalk It Up",Font.BOLD,18));
          Jtabletabelaexcel2.getTableHeader().setForeground(Color.BLUE);
          Jtabletabelaexcel2.setRowHeight(25);
          Jtabletabelaexcel2.setGridColor(Color.BLACK);
          Jtabletabelaexcel2.setShowGrid(true);
       Jtabletabelaexcel2.setColumnSelectionAllowed(true);
          Jtabletabelaexcel2.setRowSelectionAllowed(true);
          Jtabletabelaexcel2.setCellSelectionEnabled(false);
     Jtabletabelaexcel2.setFocusable(false);
       
          Jtabletabelaexcel2.getColumnModel().getColumn(0).setPreferredWidth(125);
       Jtabletabelaexcel2.getColumnModel().getColumn(0).setResizable(false);
        Jtabletabelaexcel2.getColumnModel().getColumn(1).setPreferredWidth(180);
       Jtabletabelaexcel2.getColumnModel().getColumn(1).setResizable(false);    
         Jtabletabelaexcel2.getColumnModel().getColumn(2).setPreferredWidth(180);
       Jtabletabelaexcel2.getColumnModel().getColumn(2).setResizable(false); 
          Jtabletabelaexcel2.getColumnModel().getColumn(3).setPreferredWidth(180);
       Jtabletabelaexcel2.getColumnModel().getColumn(3).setResizable(false);
             }
      
                       for (Turma t : dao.ListarTodasTurmas()) {
                
                    
                     
                     
                     
                     
                     
                
                     
                    
                      dados2.add(new Object[]{
                       turma.isIncluir(),t.getSerie(),t.getPeriodo(),t.getAno()
                      });
                     
  
                  
                   ModeloTabelaBooleanProfessorTurma modelo2 = new ModeloTabelaBooleanProfessorTurma(dados2, colunas2);
             Jtabletabelaexcel3.setModel(modelo2);
        
   
                     
                 
             
                 
     
                     
      
      //((DefaultTableCellRenderer)Jtabletabelaexcel2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
          Jtabletabelaexcel3.setForeground(Color.BLACK);
          Jtabletabelaexcel3.setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel3.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel3.getTableHeader().setForeground(Color.BLUE);
          Jtabletabelaexcel3.setRowHeight(25);
          Jtabletabelaexcel3.setGridColor(Color.BLACK);
          Jtabletabelaexcel3.setShowGrid(true);
          Jtabletabelaexcel3.setColumnSelectionAllowed(true);
          Jtabletabelaexcel3.setRowSelectionAllowed(true);
          Jtabletabelaexcel3.setCellSelectionEnabled(false);
          Jtabletabelaexcel3.setFocusable(false);
          Jtabletabelaexcel3.getColumnModel().getColumn(0).setPreferredWidth(50);
       Jtabletabelaexcel3.getColumnModel().getColumn(0).setResizable(false);
        Jtabletabelaexcel3.getColumnModel().getColumn(1).setPreferredWidth(180);
       Jtabletabelaexcel3.getColumnModel().getColumn(1).setResizable(false);    
         Jtabletabelaexcel3.getColumnModel().getColumn(2).setPreferredWidth(180);
       Jtabletabelaexcel3.getColumnModel().getColumn(2).setResizable(false); 
          Jtabletabelaexcel3.getColumnModel().getColumn(3).setPreferredWidth(180);
       Jtabletabelaexcel3.getColumnModel().getColumn(3).setResizable(false);
             }
    
    
        
      }
      
         
               
                

                       
   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/Slide6.JPG"));
        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtabletabelaexcel2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Jtabletabelaexcel3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("DJB Chalk It Up", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Atribuição de Turmas");

        Jtabletabelaexcel2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Jtabletabelaexcel2);

        Jtabletabelaexcel3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(Jtabletabelaexcel3);

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("DJB Chalk It Up", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SALVAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(148, 627, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(58, 58, 58))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        setSize(new java.awt.Dimension(824, 577));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            if(TabelaSerie()==true){

                System.out.println("Salvo");

                //System.out.println(Nomes.get(i));
                //System.out.println("teste");

                //for(ProfessorCadastro prof : dao1.SelecionarId_Professor(Nomes.get(i).toString(), Disciplina.get(i).toString())){
                    //System.out.println(prof.getId_Professor());
                    //i++;

                    JOptionPane.showMessageDialog(null,"Salvo");

                }else{
                    JOptionPane.showMessageDialog(null,nulo);
                }
            } catch (Exception ex) {
                Logger.getLogger(InserirProfessorNaTurma.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_jButton1ActionPerformed
      public String nulo;
    public boolean TabelaSerie() throws Exception{
//Boolean valor = (Boolean) Jtabletabelaexcel2.getValueAt(Jtabletabelaexcel2.getSelectedRow(), Jtabletabelaexcel2.getSelectedColumn());
          con.conexao();
       
         TurmaProfessorREST daoturmaprof = new  TurmaProfessorREST();
       
        
      int tam = Jtabletabelaexcel3.getRowCount();
       for(int z = 0;z<tam;z++){
       if(Jtabletabelaexcel3.getValueAt(z, 0).equals(true)){
           
        String Serie = Jtabletabelaexcel3.getValueAt(z,1).toString();
          
        turmaprof.setSerie(Serie);
        Turma TSerie = new Turma();
         System.out.println(Serie);
         TSerie.setSerie(Serie);
                TurmaProfessorREST turmaprofdao = new TurmaProfessorREST();
                      for(Turma Torma : dao.listarId_TurmaSerie(TSerie)){
                          
              Id_TurmaProfessorTurma = Torma.getId_Turma();  
                          System.out.println(Torma.getId_Turma());
   
                        turmaprof.setId_Turma(Id_TurmaProfessorTurma);
                           System.out.println(Id_TurmaProfessorTurma);  
                        
          }
                String Nome = "";
      String Disciplinas = "" ;
      String CPF = "" ;
          int tam1 = Jtabletabelaexcel2.getRowCount();
          for(int i = 0;i<tam1;i++){
         if(Jtabletabelaexcel2.getValueAt(i, 0).equals(true)){   
            profcadastro.setNome((Jtabletabelaexcel2.getValueAt(i, 1).toString()));
          profcadastro.setDisciplina(Jtabletabelaexcel2.getValueAt(i, 2).toString());    
          profcadastro.setCPF(Jtabletabelaexcel2.getValueAt(i,3).toString());
       Nome = Jtabletabelaexcel2.getValueAt(i, 1).toString();     
     CPF = Jtabletabelaexcel2.getValueAt(i, 2).toString();
      Disciplinas = Jtabletabelaexcel2.getValueAt(i, 3).toString();
     ProfessorCadastro profe = new ProfessorCadastro();
     profe.setCPF(CPF);
                for(ProfessorCadastro profTurma : dao1.listarIdProfessorCpf(profe)){  
                    Id_ProfessorProfessorTurma = profTurma.getId_Professor();
                        System.out.println( Id_ProfessorProfessorTurma);
       turmaprof.setId_Professor(Id_ProfessorProfessorTurma);
           
                }  
                
           tpdao.Salvar(turmaprof);         
       }
          }
       }
       }
       
       
         
                
        
            
          nulo = "Erro ao Salvar,verifique se todos os campos estão preenchidos corretamente";
             return true;
      
    }
    

    
    public boolean TabelaProfessor(){
  
        return true;   
    }
    String nome;
    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InserirProfessorNaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirProfessorNaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirProfessorNaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirProfessorNaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InserirProfessorNaTurma().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(InserirProfessorNaTurma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtabletabelaexcel2;
    private javax.swing.JTable Jtabletabelaexcel3;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
