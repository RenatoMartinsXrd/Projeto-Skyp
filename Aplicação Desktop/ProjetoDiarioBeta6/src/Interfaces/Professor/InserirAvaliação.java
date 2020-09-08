/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Professor;


import Conexão.conexaobanco;
import Modelo.Bean.Rest.Avaliacao;
import Modelo.Bean.Rest.Bimestre;
import Modelo.Bean.Rest.Turma;
import Modelo.Bean.Rest.TurmaProfessor;
import Modelo.Dao.Rest.AvaliacaoREST;
import Modelo.Dao.Rest.BimestreREST;
import Modelo.Dao.Rest.TurmaProfessorREST;
import Modelo.Dao.Rest.TurmaREST;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import mercado.ModeloTabelaBoolean;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.WindowConstants;

/**
 *
 * @author Scarlxrd2112
 */


  
public class InserirAvaliação extends javax.swing.JFrame {
    
         JScrollPane rolagem;
 
     JTextField campo;
    
     JComboBox combo;
     JCheckBox check;
     JTable teste;
    conexaobanco con = new conexaobanco();
     Turma turma = new Turma();
     TurmaProfessorREST dao = new TurmaProfessorREST();
     Avaliacao avaliar = new Avaliacao();
     //DefaultTableModel modelo = new DefaultTableModel();
     AvaliacaoREST avaliardao = new AvaliacaoREST();
     BimestreREST bimestredao = new BimestreREST();
      public static String itemDoComboboxAvaliacao;
      public static int Id_Bimestre;
      public static String Bimestre;
      public static int Id_TurmaAvaliação;
       public static String SerieAvaliação;
       AvaliacaoREST dao2;
                Avaliacao avaliacao;
        ArrayList arraySerie = new ArrayList();
    /**
     * Creates new form InserirAvaliação
     */
  


  // The following methods override the defaults for performance reasons
 

       
    public InserirAvaliação() throws Exception {
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

      
       dao2 = new AvaliacaoREST();
       avaliacao = new Avaliacao();
       Avaliacao teste = new Avaliacao();
 
              campo = new JTextField();
        rolagem = new JScrollPane();
        combo = new JComboBox();  
        
        //Jtabletabelaexcel2.setModel(modelo);
         
   
    
      
     // modelo.addColumn("Incluir");
         //modelo.addColumn("Serie");
    
      check =  new JCheckBox();
         check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
            

  
        });
 
         
    //Jtabletabelaexcel2.getColumnModel().getColumn(0).setCellEditor( new MyBooleanEditor());
   //Jtabletabelaexcel2.getColumnModel().getColumn(0).setCellRenderer( new MyBooleanRenderer());
     //Jtabletabelaexcel2.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(check));
        
       for(Bimestre bi : bimestredao.ListarTodosBimestres()){
            jComboBoxBimestre.addItem(bi.toString());
           
            
        }
           
        
     
            
        
     
  
   
                  
     
                        
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
public void preencherTabela() throws Exception{
             String [] colunas = new String[]{"Incluir","Serie"};
          ArrayList dados = new  ArrayList();
//                filas[0]=rs.getString(1);

                  TurmaProfessor t = new TurmaProfessor();
                  t.setId_Professor(Login.Id_ProfessorLogin);
             for (TurmaProfessor torma : dao.listarTurmaProfesssor(t)) {

                      dados.add(new Object[]{
                       torma.isIncluir(),torma.getSerie()
                      });

        ModeloTabelaBoolean modelo = new ModeloTabelaBoolean(dados, colunas);
            Jtabletabelaexcel2.setModel(modelo);  
      //((DefaultTableCellRenderer)Jtabletabelaexcel2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
          Jtabletabelaexcel2.setForeground(Color.BLACK);
          Jtabletabelaexcel2.setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel2.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel2.getTableHeader().setForeground(Color.GREEN);
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
}
                          
  
  
         
       
               
            
           


     

 


    
      
    class MyBooleanRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        JCheckBox check = new JCheckBox();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);
            if (obj instanceof Boolean) {
                return check;
            }
            return cell;
        }
    }

    public class MyBooleanEditor extends AbstractCellEditor implements TableCellEditor {

        private JCheckBox check = new JCheckBox();

        @Override
        public Object getCellEditorValue() {
            return check.isSelected();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value instanceof Boolean) {
                check.setSelected((Boolean)value);
            }
            return check;
        }
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
        jDesktopPane3 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxBimestre = new javax.swing.JComboBox<>();
        Calendario = new com.toedter.calendar.JDateChooser();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtabletabelaexcel2 = new javax.swing.JTable();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DJB Chalk It Up", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data");

        jLabel1.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Avaliação");

        jLabel5.setFont(new java.awt.Font("DJB Chalk It Up", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bimestre");

        jComboBoxBimestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBimestreActionPerformed(evt);
            }
        });

        Calendario.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                CalendarioAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Calendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalendarioMouseClicked(evt);
            }
        });
        Calendario.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                CalendarioInputMethodTextChanged(evt);
            }
        });
        Calendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CalendarioPropertyChange(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DJB Chalk It Up", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Título");

        jLabel3.setFont(new java.awt.Font("DJB Chalk It Up", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descrição");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescricao);

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

        jButtonSalvar.setBackground(new java.awt.Color(204, 153, 0));
        jButtonSalvar.setFont(new java.awt.Font("DJB Chalk It Up", 0, 14)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jDesktopPane3.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jComboBoxBimestre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(Calendario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jTextFieldTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jButtonSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane3Layout.createSequentialGroup()
                            .addGap(300, 300, 300)
                            .addComponent(jButtonSalvar))
                        .addGroup(jDesktopPane3Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jDesktopPane3Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane3Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBoxBimestre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4))
                    .addContainerGap(200, Short.MAX_VALUE)))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(82, 82, 82)
                .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jButtonSalvar)
                .addGap(40, 40, 40))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addContainerGap(79, Short.MAX_VALUE)
                    .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxBimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel4)
                    .addGap(494, 494, 494)))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
                                    
     
      public String nulo;
    public boolean Testar() throws Exception, Exception{
       
       
       
         //Boolean valor = (Boolean) Jtabletabelaexcel2.getValueAt(Jtabletabelaexcel2.getSelectedRow(), Jtabletabelaexcel2.getSelectedColumn());
            int tam = Jtabletabelaexcel2.getRowCount();
    
         for(int i = 0;i<tam;i++){
        
              
      if(Jtabletabelaexcel2.getValueAt(i, 0).equals(true)){
        //bimestre.setId_Bimestre(Id_Bimestre);
 
        
        avaliacao.setId_Professor(Login.Id_ProfessorLogin);
        //avaliacao.setId_Bimestre(bimestre);
        avaliacao.setBimestre(Bimestre);
       
        avaliacao.setId_Bimestre(Id_Bimestre);
        String Serie;
        Serie = Jtabletabelaexcel2.getValueAt(i,1).toString();
        
         
         
               //arraySerie.add(Serie);
               //System.out.println(arraySerie.get(i));
                TurmaREST turmaprofdao = new TurmaREST();
               Turma tmp = new Turma();
                       tmp.setSerie(Serie);
                      for(Turma turma : turmaprofdao.listarId_TurmaSerie(tmp)){
                       
              Id_TurmaAvaliação = turma.getId_Turma();
                       System.out.println(Id_TurmaAvaliação);
                     
                      
                        avaliacao.setId_Turma(Id_TurmaAvaliação);
          }
       
        avaliacao.setTitulo(jTextFieldTitulo.getText());
        avaliacao.setDescrição(jTextAreaDescricao.getText());
            Date data = Calendario.getDate();
       long d = data.getTime();
       java.sql.Date novo =  new java.sql.Date(d);
         System.out.println(novo);
         avaliacao.setData_Avaliacao(novo);
          
    
          avaliacao.setSerie(Jtabletabelaexcel2.getValueAt(i,1).toString());
          dao2.Salvar(avaliacao);
         }else{
          nulo = "Erro ao Salvar,verifique se todos os campos estão preenchidos corretamente";
      }
             
           
         
        
}
              return true;
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jComboBoxBimestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBimestreActionPerformed

        try {
            Bimestre =  jComboBoxBimestre.getSelectedItem().toString();
            System.out.println(Bimestre);
            itemDoComboboxAvaliacao = Bimestre;
            Bimestre bis = new Bimestre();
            bis.setBimestre(itemDoComboboxAvaliacao);
            for(Bimestre bi : bimestredao.ListarId_Bimestre(bis)){
                Id_Bimestre = bi.getId_Bimestre();
                System.out.println( "O ID do bimestre relacionado é " + Id_Bimestre);
            }
        } catch (Exception ex) {
            Logger.getLogger(InserirAvaliação.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxBimestreActionPerformed

    private void CalendarioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_CalendarioAncestorAdded

    }//GEN-LAST:event_CalendarioAncestorAdded

    private void CalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalendarioMouseClicked

    }//GEN-LAST:event_CalendarioMouseClicked

    private void CalendarioInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_CalendarioInputMethodTextChanged

    }//GEN-LAST:event_CalendarioInputMethodTextChanged

    private void CalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalendarioPropertyChange

    }//GEN-LAST:event_CalendarioPropertyChange

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        try {
            if(Testar()==true){

                JOptionPane.showMessageDialog(null,"Salvo");
            }else{
                JOptionPane.showMessageDialog(null,nulo);
            }   } catch (Exception ex) {
                Logger.getLogger(InserirAvaliação.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(InserirAvaliação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirAvaliação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirAvaliação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirAvaliação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          
                try {
                    new InserirAvaliação().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(InserirAvaliação.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Calendario;
    private javax.swing.JTable Jtabletabelaexcel2;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxBimestre;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
