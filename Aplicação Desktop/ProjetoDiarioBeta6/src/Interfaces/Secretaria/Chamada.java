/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Secretaria;


import java.util.Date;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Modelo.Bean.Rest.Aluno;
import Modelo.Bean.Rest.Turma;
import Modelo.Dao.Rest.AlunoREST;
import Modelo.Dao.Rest.ChamadaREST;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import mercado.ModeloTabela;

/**
 *
 * @author renato.malmeida
 */
public class Chamada extends javax.swing.JFrame {
public static String itemDoComboboxAlunoChamada;
     public static int Id_TurmaAlunoChamada;
       public static int Id_TurmaAlunoChamada2;
       public static int retorno = 0;
     TurmaREST dao = new TurmaREST();
     AlunoREST alunodao = new AlunoREST();
         Modelo.Bean.Rest.Chamada chamada = new Modelo.Bean.Rest.Chamada();

          ChamadaREST daochamada = new ChamadaREST();
          AlunoREST daoaluno = new AlunoREST();
     
      Turma turma = new Turma();
         String [] colunas = new String[]{"Numero_Chamada","Nome"};
          ArrayList dados = new  ArrayList();
           ModeloTabela modelo;
    /**
     * Creates new form Chamada
     */
    public Chamada() throws Exception {
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
       
         for(Turma t : dao.ListarTodasTurmas()){
            jComboBoxSerie.addItem(t);
          
        }
  
         

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
           
       
      
              
     
              
      
                 
                
           
              
                  int tam = Jtabletabelaexcel2.getRowCount();
        
                for(int i = 1;i<tam;i++){
                      
                            dados.clear();
         int a = 1;
            Aluno Id_Turma = new Aluno();
            Id_Turma.setId_Turma(Id_TurmaAlunoChamada);
               for (Aluno aluno : alunodao.listarAlunos(Id_Turma)) {
                
          
                   
               
             
                     System.out.println(aluno.getNome());
                    
                      dados.add(new Object[]{
                      a++,aluno.getNome()
                      });
                     
         
             
                 
     
                       }
      
       
        }
                if(dados.isEmpty()){
                    JOptionPane.showMessageDialog(null, "A Tabela não possui dados para mostrar");
                }else{
                    modelo = new ModeloTabela(dados, colunas);
            Jtabletabelaexcel2.setModel(modelo);  
                }
        
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
        jComboBoxSerie = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtabletabelaexcel2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Serie");

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

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Jtabletabelaexcel2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Jtabletabelaexcel2);

        jButton2.setBackground(new java.awt.Color(204, 153, 0));
        jButton2.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Chamada");

        jButton4.setBackground(new java.awt.Color(204, 153, 0));
        jButton4.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Importar do Excel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(204, 153, 0));
        jButton7.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Exportar Excel");

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jComboBoxSerie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(218, 218, 218))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(33, 33, 33)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jComboBoxSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)
                        .addGap(68, 68, 68))))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton7))
                .addContainerGap())
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
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSerieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxSerieMouseClicked

    }//GEN-LAST:event_jComboBoxSerieMouseClicked

    private void jComboBoxSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSerieActionPerformed

        try {
            String b =  jComboBoxSerie.getSelectedItem().toString();

            itemDoComboboxAlunoChamada = b;
            System.out.println(itemDoComboboxAlunoChamada);
            Turma ttt = new Turma();
            ttt.setSerie(itemDoComboboxAlunoChamada);
            for(Turma turma : dao.listarId_TurmaSerie(ttt)){
                Id_TurmaAlunoChamada = turma.getId_Turma();
                System.out.println("O Id da serie selecionada é " +Id_TurmaAlunoChamada);

            }
        } catch (Exception ex) {
            Logger.getLogger(Chamada.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBoxSerieActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            preencherTabela();

            //                filas[0]=rs.getString(1);
        } catch (Exception ex) {
            Logger.getLogger(Chamada.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            if(CadastraChamada()){
                JOptionPane.showMessageDialog(null, "Inserido");
            }else{
                JOptionPane.showMessageDialog(null, "Erro");
            }
        } catch (Exception ex) {
            Logger.getLogger(Chamada.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed
   public void toExcel(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        FileWriter excel = new FileWriter(file);
        for (int i = 0; i < model.getColumnCount(); i++) {
            excel.write(model.getColumnName(i) + "\t");
        }
        excel.write("\n");
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                excel.write(model.getValueAt(i, j).toString() + "\t");
            }
            excel.write("\n");
        }
        excel.close();
        System.out.println("write out to: " + file);
    }      
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser jfile = new JFileChooser();
        jfile.showOpenDialog(this);
        File file = jfile.getSelectedFile();
        System.out.println(file);
        File filer = new File(file.toString());
        FileInputStream fisPlanilha = null;
        String [] vetor = null;

        ArrayList<String> l = new ArrayList<>();

        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator filaIterator = sheet.rowIterator();
            int numerodelinhas = sheet.getLastRowNum();
            for(int a = 1;a<=numerodelinhas;a++){
                Row linhas = sheet.getRow(a);
                String [] string = new String[numerodelinhas];
                ArrayList Ra = new ArrayList<>();

                String date =  linhas.getCell(2).getDateCellValue().toString();
                SimpleDateFormat formatnow = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy", Locale.ENGLISH);
                SimpleDateFormat formatneeded=new SimpleDateFormat("dd/MM/YYYY");
                Date date1 = formatnow.parse(date);
                String date2 = formatneeded.format(date1);
                if(linhas.getCell(1).getCellType() == Cell.CELL_TYPE_STRING && linhas.getCell(1).equals("")){
                    Ra.add("");

                }else{
                    switch (linhas.getCell(1).getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                        Ra.add(linhas.getCell(1).getStringCellValue());
                        System.out.println(linhas.getCell(1).getRichStringCellValue());
                        System.out.println(Ra);
                        break;
                        case Cell.CELL_TYPE_NUMERIC:

                        Ra.add((long )linhas.getCell(1).getNumericCellValue());

                        System.out.println(Ra);
                        break;

                    }
                }
                int c = 0;
                dados.add(new Object[]{
                    linhas.getCell(0).getStringCellValue(), Ra.get(c), date2

                });
                c++;                          }

            int indiceColumna=0;

            ModeloTabela modelo = new ModeloTabela(dados, colunas);
            Jtabletabelaexcel2.setModel(modelo);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Chamada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Chamada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Chamada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    boolean autenticar = false;
    public boolean CadastraChamada() throws Exception{
    
  
  
    int tam = Jtabletabelaexcel2.getRowCount();
  String texto ="";
     Modelo.Bean.Rest.Chamada cv = new  Modelo.Bean.Rest.Chamada(); 
              
      cv.setId_Turma(Id_TurmaAlunoChamada);
       daochamada.DeletarChamada(cv);
      for(int i = 0;i<tam;i++){

                      
      chamada.setId_Turma(Id_TurmaAlunoChamada);
          chamada.setNome(Jtabletabelaexcel2.getValueAt(i, 1).toString());
          chamada.setNumero_Chamada(Integer.parseInt(Jtabletabelaexcel2.getValueAt(i, 0).toString()));
          Aluno an = new Aluno();
          an.setId_Turma(Id_TurmaAlunoChamada);
          an.setNome(Jtabletabelaexcel2.getValueAt(i,1).toString());
          for( Aluno aluno : daoaluno.SelecionarId_Alunos(an)){
              int id = aluno.getId_Aluno();
               chamada.setId_Aluno(id);
               
          }      
        
                    
           daochamada.Salvar(chamada);
          
           
            
      }
        return true;
    }
    
   
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
            java.util.logging.Logger.getLogger(Chamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Chamada().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Chamada.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtabletabelaexcel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<Object> jComboBoxSerie;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
