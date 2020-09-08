/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado;

import Interfaces.Professor.InserirMedia;
import Interfaces.Professor.ListarAvaliações;
import Interfaces.Professor.Login;
import Modelo.Bean.Rest.Avaliacao;
import Modelo.Dao.Rest.AvaliacaoREST;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Scarlxrd2112
 */
public class JanelaMedia extends javax.swing.JDialog {
   JTextField campo;
   public static ArrayList<Double> pesos = new ArrayList<>();
    /**
     * Creates new form JanelaLousa
     */
    public JanelaMedia() throws Exception {
        
        initComponents();
        setModal(true);
        Font roboto=null;
          
        campo = new JTextField();
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
        String hex = "13CE66";
        
        jTable2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                
                try {
                    int Lin = jTable2.getSelectedRow();
                    int Col = jTable2.getSelectedColumn();
                    if(Lin == -1 && Col==-1){
                        Lin = 0;
                        Col = 0;
                    }
                    jTable2.changeSelection(Lin,Col,false,false);
                    jTable2.editCellAt(Lin, Col);
                    Component celula = jTable2.getEditorComponent();
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
jTable2.setShowGrid(true);

  
  
jTable2.setBackground(converteRGB(hex));
  jTable2.setColumnSelectionAllowed(false);
 
    // jTable2.getBorder().isBorderOpaque();
    jTable2.setBorder(null);
     jTable2.getTableHeader().setBackground(converteRGB(hex));
    jTable2.getTableHeader().setVisible(true);
    jTable2.setRowHeight(25);
    jTable2.setFont(new Font("DJB Chalk It Up",Font.BOLD,14));
         jTable2.getTableHeader().setFont(new Font("DJB Chalk It Up",Font.BOLD,18));
          
    jTable2.setColumnSelectionAllowed(false);
         jTable2.setRowSelectionAllowed(false);
         jTable2.setCellSelectionEnabled(false);
preencher();
           
       
         }

   
        private Color converteRGB(String hex)
{ 
String sr = hex.substring(0,2);
String sg = hex.substring(2,4);
String sb = hex.substring(4,6);

     int r = Integer.parseInt(sr, 16);
     int g = Integer.parseInt(sg, 16);
     int b = Integer.parseInt(sb, 16);

     Color color = new Color(r,g,b);

     return color;
}
    
    public void preencher() throws Exception{
                 String [] colunas = new String[]{"Avaliações","Peso"};
          ArrayList dados = new  ArrayList();
//                filas[0]=rs.getString(1);
  
        
   AvaliacaoREST ar = new AvaliacaoREST();
   Avaliacao ava = new Avaliacao();
   ava.setId_Professor(Login.Id_ProfessorLogin);
   ava.setId_Bimestre(ListarAvaliações.Id_BimestreNotas);
   ava.setId_Turma(ListarAvaliações.Id_TurmaNotas);
                for(Avaliacao a : ar.SelecionarAvaliacao(ava) ){
                    dados.add(new Object[]{
                    a.getTitulo(), ""
                              
                      });
                }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTable2.setModel(modelo);  
      //((DefaultTableCellRenderer)Jtabletabelaexcel2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
         DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
headerRenderer.setBackground(converteRGB("13CE66"));
      
  for (int i = 0; i < jTable2.getModel().getColumnCount(); i++) {
    jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
}
 jTable2.getColumnModel().getColumn(0).setPreferredWidth(100);
      jTable2.getColumnModel().getColumn(0).setResizable(false);
     jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
      jTable2.getColumnModel().getColumn(1).setResizable(false);
   

    
    //Jtabletabelaexcel2.getColumnModel().getColumn(2).setCellEditor(new ButtonColumn(Jtabletabelaexcel2,2));
           


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(184, 151, 126));
        setForeground(new java.awt.Color(184, 151, 126));
        setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(184, 151, 126));
        jPanel6.setForeground(new java.awt.Color(184, 151, 126));

        jPanel5.setBackground(new java.awt.Color(19, 206, 102));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
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
        jTable2.setGridColor(new java.awt.Color(19, 206, 102));
        jTable2.setOpaque(false);
        jTable2.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jTable2.setSelectionForeground(new java.awt.Color(0, 204, 0));
        jScrollPane3.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecione o peso das notas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(110, 110, 110))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton1.setBackground(new java.awt.Color(59, 72, 89));
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   if (jTable2.isEditing()) {
    jTable2.getCellEditor().stopCellEditing();
}
           ArrayList<String> teste = new ArrayList<String>();
     for(int i =0 ;i<jTable2.getRowCount();i++){
         pesos.add(Double.parseDouble(jTable2.getValueAt(i, 1).toString()));
       
     }
      for(int i =0 ;i<10;i++){
       teste.add("Joseçpsm");
    
     }
       try {
          // InserirMedia.getInstance().retornarArray(pesos);
           //InserirMedia.getInstance().refrescar(teste);
       } catch (Exception ex) {
           Logger.getLogger(JanelaMedia.class.getName()).log(Level.SEVERE, null, ex);
       }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
public static int numero;
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
            java.util.logging.Logger.getLogger(JanelaMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaMedia dialog = null;
                try {
                    dialog = new JanelaMedia();
                } catch (Exception ex) {
                    Logger.getLogger(JanelaMedia.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
