/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Secretaria;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import Modelo.Bean.Rest.Turma;
import Modelo.Dao.Rest.TurmaREST;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import mercado.ModeloTabelaBoolean;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import mercado.ModeloTabela;
import mercado.TelaSuCessocomgif1;

/**
 *
 * @author Scarlxrd2112
 */


  
public class InserirTurma extends javax.swing.JFrame {
    
         JScrollPane rolagem;
 
     JTextField campo;
    
     JComboBox combo;
     JCheckBox check;
     JTable teste;
   
     Turma turma = new Turma();
     TurmaREST dao = new TurmaREST();

      public static String itemDoComboboxAvaliacao;
      public static int Id_Bimestre;
      public static String Bimestre;
    String [] colunas = new String[]{"Serie","Periodo"};
    ArrayList dados = new  ArrayList();
    /**
     * Creates new form InserirAvaliação
     */
  


  // The following methods override the defaults for performance reasons
 

       
    public InserirTurma() {
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
         this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         preencherTabela();

      

 
              campo = new JTextField();
        rolagem = new JScrollPane();
        combo = new JComboBox();  
        
        //Jtabletabelaexcel2.setModel(modelo);
         
   
    
      
     // modelo.addColumn("Incluir");
         //modelo.addColumn("Serie");
    
         
    //Jtabletabelaexcel2.getColumnModel().getColumn(0).setCellEditor( new MyBooleanEditor());
   //Jtabletabelaexcel2.getColumnModel().getColumn(0).setCellRenderer( new MyBooleanRenderer());
     //Jtabletabelaexcel2.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(check));
        
        
           
        
     
            
        
     
  
   
                  
     
                        
      /*
       
      //((DefaultTableCellRenderer)Jtabletabelaexcel2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
          Jtabletabelaexcel2.setForeground(Color.BLACK);
          Jtabletabelaexcel2.setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel2.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel2.getTableHeader().setForeground(Color.BLUE);
          Jtabletabelaexcel2.setRowHeight(25);
          Jtabletabelaexcel2.setGridColor(Color.BLACK);
          Jtabletabelaexcel2.setShowGrid(true);
          Jtabletabelaexcel2.setColumnSelectionAllowed(true);
          Jtabletabelaexcel2.setRowSelectionAllowed(true);
          Jtabletabelaexcel2.setCellSelectionEnabled(true);
                
          
  
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
 
    }
public void preencherTabela(){
           
          
//                filas[0]=rs.getString(1);
 
     
     
  
   
                     
                 
             
                 
     
                     
      
        ModeloTabelaBoolean modelo = new ModeloTabelaBoolean(dados, colunas);
         Jtabletabelaexcel2.setModel(modelo);  
      //((DefaultTableCellRenderer)Jtabletabelaexcel2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
          Jtabletabelaexcel2.setForeground(Color.BLACK);
          Jtabletabelaexcel2.setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel2.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel2.getTableHeader().setForeground(Color.BLUE);
          Jtabletabelaexcel2.setRowHeight(25);
          Jtabletabelaexcel2.setGridColor(Color.BLACK);
          Jtabletabelaexcel2.setShowGrid(true);
          Jtabletabelaexcel2.setColumnSelectionAllowed(true);
          Jtabletabelaexcel2.setRowSelectionAllowed(true);
          Jtabletabelaexcel2.setCellSelectionEnabled(true);
               Jtabletabelaexcel2.getColumnModel().getColumn(0).setPreferredWidth(180);
       Jtabletabelaexcel2.getColumnModel().getColumn(0).setResizable(false);
        Jtabletabelaexcel2.getColumnModel().getColumn(1).setPreferredWidth(180);
       Jtabletabelaexcel2.getColumnModel().getColumn(1).setResizable(false);    
     
             }

                          
  
          

       
               
            
           



 


    
      

    

       
       
       
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   

        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
        jLabel5 = new javax.swing.JLabel();
        jTextAno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtabletabelaexcel2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inserir Turmas");

        jLabel5.setFont(new java.awt.Font("DJB Chalk It Up", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ano");

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

        jButton2.setBackground(new java.awt.Color(204, 153, 0));
        jButton2.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Adiciona Linha");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonSalvar.setBackground(new java.awt.Color(204, 153, 0));
        jButtonSalvar.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextAno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonSalvar)
                            .addGap(4, 4, 4))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextAno, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButtonSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
                                    
     
      public String nulo;
    public boolean Testar() throws Exception{
      Turma turma = new Turma();
       TurmaREST turminhajunior = new TurmaREST();
       
         //Boolean valor = (Boolean) Jtabletabelaexcel2.getValueAt(Jtabletabelaexcel2.getSelectedRow(), Jtabletabelaexcel2.getSelectedColumn());
            int tam = Jtabletabelaexcel2.getRowCount();
            
         for(int i = 0;i<tam;i++){
      
   
  
        //avaliacao.setId_Bimestre(bimestre);
     
           
     
    

   
          
    
         turma.setSerie(Jtabletabelaexcel2.getValueAt(i,0).toString());
          turma.setAno(jTextAno.getText());
          turma.setPeriodo(Jtabletabelaexcel2.getValueAt(i,1).toString());
          turminhajunior.Salvar(turma);
    
             
           
         
        
}
         return true;
    }
             
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int tam = Jtabletabelaexcel2.getRowCount();

        dados.add(new Object[]{
            "",""
        });
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        Jtabletabelaexcel2.setModel(modelo);
        Jtabletabelaexcel2.scrollRectToVisible(Jtabletabelaexcel2.getCellRect(Jtabletabelaexcel2.getRowCount()-1,0,true));
        /*

        rolagem.getViewport().setViewPosition(new Point(0,maxValue));
        */
    }//GEN-LAST:event_jButton2ActionPerformed
public  void tocar() throws JavaLayerException, IOException{
       URL url = getClass().getResource("acabou.mp3");
    Player p = new Player(url.openStream());
       p.play();
   }
    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        if (Jtabletabelaexcel2.isEditing()) {
            Jtabletabelaexcel2.getCellEditor().stopCellEditing();
        }

        try {
            if(Testar()==true){
                TelaSuCessocomgif1 tg = new TelaSuCessocomgif1();
                tg.setVisible(true);
                tg.setModal(true);
                tg = null;
          
            }else{
                JOptionPane.showMessageDialog(null,nulo);
            }   } catch (Exception ex) {
                Logger.getLogger(InserirTurma.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_jButtonSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(InserirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
          
                    new InserirTurma().setVisible(true);
            
                 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtabletabelaexcel2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextAno;
    // End of variables declaration//GEN-END:variables
}
