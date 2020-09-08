/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Professor;




import Modelo.Bean.Rest.Bimestre;
import Modelo.Bean.Rest.TurmaProfessor;
import Modelo.Dao.Rest.BimestreREST;
import Modelo.Dao.Rest.TurmaProfessorREST;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import Modelo.Bean.Rest.Turma;
import Modelo.Dao.Rest.TurmaREST;
import TabbedPageProfessor.TabbedPageNotas;
import java.awt.Font;
import javax.swing.WindowConstants;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Scarlxrd2112
 */
public class ListarAvaliações extends javax.swing.JFrame {
    public static String itemDoComboboxSerieNotas;
     public static String itemDoComboboxBimestreNotas;
      public static int Id_BimestreNotas;
      public static String BimestreNotas;
  public static int Id_TurmaNotas;
  BimestreREST bimestredao = new BimestreREST();
     TurmaProfessorREST daoturmaprofessor = new TurmaProfessorREST();
   TurmaREST dao = new TurmaREST();
    /**
     * Creates new form ListarNotas
     */
    public ListarAvaliações() throws Exception {
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
         TurmaProfessor b = new TurmaProfessor();
         b.setId_Professor(Login.Id_ProfessorLogin);
        for(TurmaProfessor t : daoturmaprofessor.listarTurmaProfesssor(b)){
            jComboBoxSerie.addItem(t.getSerie());
          
        }
         for(Bimestre bi : bimestredao.ListarTodosBimestres()){
            jComboBoxBimestre.addItem(bi.toString());
           
            
        }
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/Slide8.JPG"));
        Image image = icon.getImage();
        jDesktopPane3 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jComboBoxBimestre = new javax.swing.JComboBox<>();
        jComboBoxSerie = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bimestre");

        jComboBoxBimestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBimestreActionPerformed(evt);
            }
        });

        jComboBoxSerie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxSerieMouseClicked(evt);
            }
        });
        jComboBoxSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSerieActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Serie");

        jLabel3.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Listar Avaliações");

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane3.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jComboBoxBimestre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jComboBoxSerie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(87, 87, 87))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addGap(31, 31, 31)
                    .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBoxBimestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(85, Short.MAX_VALUE)))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(76, 76, 76))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(115, 115, 115)
                    .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGap(18, 18, 18)
                    .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxBimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addContainerGap(164, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane3)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxBimestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBimestreActionPerformed
        BimestreNotas =  jComboBoxBimestre.getSelectedItem().toString();
        System.out.println(BimestreNotas);
        itemDoComboboxBimestreNotas = BimestreNotas;
        Bimestre Nome = new Bimestre();
        Nome.setBimestre(itemDoComboboxBimestreNotas);
        try {
            for(Bimestre bi : bimestredao.ListarId_Bimestre(Nome)){
                Id_BimestreNotas = bi.getId_Bimestre();
                System.out.println( "O ID do bimestre relacionado é " + Id_BimestreNotas);
            }
        } catch (Exception ex) {
            Logger.getLogger(ListarAvaliações.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxBimestreActionPerformed

    private void jComboBoxSerieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxSerieMouseClicked

    }//GEN-LAST:event_jComboBoxSerieMouseClicked

    private void jComboBoxSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSerieActionPerformed

        String Serie =  jComboBoxSerie.getSelectedItem().toString();

        itemDoComboboxSerieNotas = Serie;
        System.out.println(itemDoComboboxSerieNotas);

        Turma SerieCombo = new Turma();
        SerieCombo.setSerie(itemDoComboboxSerieNotas);

        try {
            for(Turma turma : dao.listarId_TurmaSerie(SerieCombo)){
                System.out.println(turma.getId_Turma());
                Id_TurmaNotas = turma.getId_Turma();
                System.out.println("O Id da serie selecionada é " +Id_TurmaNotas);
            }
        } catch (Exception ex) {
            Logger.getLogger(ListarAvaliações.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBoxSerieActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println(Id_TurmaNotas);
        TabbedPageNotas in;
        try {
            in = new TabbedPageNotas();
            in.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ListarAvaliações.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ListarAvaliações.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarAvaliações.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarAvaliações.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarAvaliações.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                    new ListarAvaliações().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ListarAvaliações.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxBimestre;
    private javax.swing.JComboBox<Object> jComboBoxSerie;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
