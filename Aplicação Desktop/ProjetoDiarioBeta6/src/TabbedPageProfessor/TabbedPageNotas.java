/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabbedPageProfessor;


import Interfaces.Professor.InserirMedia;
import Interfaces.Professor.Login;
import Modelo.Bean.Rest.Aluno;
import Modelo.Dao.Rest.AlunoREST;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Modelo.Dao.Rest.NotaREST;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import mercado.ModeloTabela;
import static Interfaces.Professor.ListarAvaliações.Id_BimestreNotas;
import static Interfaces.Professor.ListarAvaliações.Id_TurmaNotas;
import Modelo.Bean.Rest.Avaliacao;
import Modelo.Bean.Rest.Chamada;
import Modelo.Bean.Rest.Nota;
import Modelo.Dao.Rest.AvaliacaoREST;
import Modelo.Dao.Rest.ChamadaREST;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import mercado.ButtonColumn;

import mercado.ModeloTabelaBotão;
/**
 *
 * @author Scarlxrd2112
 */ 
public class TabbedPageNotas extends javax.swing.JFrame {
  public static String itemDoComboboxAvaliar;
  
      public static int Id_Avaliacao;
      public static String Titulo;
       public static int Id_TurmaInserirNotas;
      AvaliacaoREST dao = new AvaliacaoREST();
      ChamadaREST daochamada = new ChamadaREST();
      NotaREST daonota = new NotaREST();
      AlunoREST daoaluno = new AlunoREST();
       JTextField campo;
        ArrayList dados = new  ArrayList();
         public static String itemDoComboboxAvaliar2;
 
      public static int Id_Avaliacao2;
      public static String Titulo2;
       public static int Id_TurmaInserirNotas2;
      AvaliacaoREST dao2 = new AvaliacaoREST();
      ChamadaREST daochamada2 = new ChamadaREST();
    
       
       Nota nota = new Nota();
       public static int IdAlunoConsultar;
             String [] colunas = new String[]{"Numero_Chamada","Nome","Nota"};

     
   /**
     * Creates new form Tabela
     */
  

     
   /**
     * Creates new form Tabela
     */
   
     

      
    public TabbedPageNotas() throws Exception {
  
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
         Id_TurmaInserirNotas = Id_TurmaNotas;
         this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println(Id_TurmaInserirNotas);
     preencherTabela();
      Avaliacao a = new Avaliacao();
      a.setId_Turma(Id_TurmaNotas);
      a.setId_Bimestre(Id_BimestreNotas);
      a.setId_Professor(Login.Id_ProfessorLogin);
         for(Avaliacao t : dao.SelecionarAvaliacao(a)){
            jComboBoxAvaliacao.addItem(t.getTitulo().toString());
          
        }
          
            campo = new JTextField();
  Id_TurmaInserirNotas2 = Id_TurmaNotas;
         this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println(Id_TurmaInserirNotas);
     preencherTabelaConsulta();
             Avaliacao a2 = new Avaliacao();
      a2.setId_Turma(Id_TurmaNotas);
      a2.setId_Bimestre(Id_BimestreNotas);
      a2.setId_Professor(Login.Id_ProfessorLogin);
    
     

    
       
     
           
          
         
          /*
          rolagem.setViewportView(Jtabletabelaexcel);
        rolagem.setBounds(200,200,500,312);
        add(rolagem);
   */

    Jtabletabelaexcel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                
                try {
                    int Lin = Jtabletabelaexcel.getSelectedRow();
                    int Col = Jtabletabelaexcel.getSelectedColumn();
                    if(Lin == -1 && Col==-1){
                        Lin = 0;
                        Col = 0;
                    }
                    Jtabletabelaexcel.changeSelection(Lin,Col,false,false);
                    Jtabletabelaexcel.editCellAt(Lin, Col);
                    Component celula = Jtabletabelaexcel.getEditorComponent();
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
 
     
     
  
   
                  Chamada chame = new Chamada();
                  chame.setId_Turma(Id_TurmaInserirNotas);
             for (Chamada ch : daochamada.listarChamadaId_Turma(chame)) {
                
                    
                     
                     
                     
                     
                     
                
                     
                    
                      dados.add(new Object[]{
                      ch.getNumero_Chamada(),ch.getNome(),""
                      });
                     
                 
             
                 
     
                     
      
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
            Jtabletabelaexcel.setModel(modelo);  
      //((DefaultTableCellRenderer)Jtabletabelaexcel2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
          Jtabletabelaexcel.setForeground(Color.BLACK);
          Jtabletabelaexcel.setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel.getTableHeader().setForeground(Color.GREEN);
          Jtabletabelaexcel.setRowHeight(25);
          Jtabletabelaexcel.setGridColor(Color.BLACK);
          Jtabletabelaexcel.setShowGrid(true);
          Jtabletabelaexcel.setColumnSelectionAllowed(true);
          Jtabletabelaexcel.setRowSelectionAllowed(true);
          Jtabletabelaexcel.setCellSelectionEnabled(true);
               Jtabletabelaexcel.getColumnModel().getColumn(0).setPreferredWidth(50);
       Jtabletabelaexcel.getColumnModel().getColumn(0).setResizable(false);
              Jtabletabelaexcel.getColumnModel().getColumn(1).setPreferredWidth(180);
       Jtabletabelaexcel.getColumnModel().getColumn(1).setResizable(false);
              Jtabletabelaexcel.getColumnModel().getColumn(2).setPreferredWidth(50);
       Jtabletabelaexcel.getColumnModel().getColumn(2).setResizable(false);
   
    
             }
    
   
      
   
                 
             
}
    
    public void preencherTabelaConsulta() throws Exception{
        
             String [] colunas = new String[]{"Numero_Chamada","Nome","Observar Avaliações"};
          ArrayList dados = new  ArrayList();
//                filas[0]=rs.getString(1);
  Chamada chame = new Chamada();
                  chame.setId_Turma(Id_TurmaInserirNotas2);
             for (Chamada ch : daochamada2.listarChamadaId_Turma(chame)) {
        
                      dados.add(new Object[]{
                      ch.getNumero_Chamada(),ch.getNome(),"Ver"
                      });
                     
                 
             
                 
     
                     
      
        ModeloTabelaBotão modelo = new ModeloTabelaBotão(dados, colunas);
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
   

    Jtabletabelaexcel2.getColumnModel().getColumn(2).setCellRenderer(new ButtonColumn(Jtabletabelaexcel2,2));
    //Jtabletabelaexcel2.getColumnModel().getColumn(2).setCellEditor(new ButtonColumn(Jtabletabelaexcel2,2));
              Jtabletabelaexcel2.getColumnModel().getColumn(1).setPreferredWidth(180);
       Jtabletabelaexcel2.getColumnModel().getColumn(1).setResizable(false);
              Jtabletabelaexcel2.getColumnModel().getColumn(0).setPreferredWidth(50);
       Jtabletabelaexcel2.getColumnModel().getColumn(0).setResizable(false);
   
    
             }
}
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/Slide6.JPG"));
        Image image = icon.getImage();
        jDesktopPane2 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxAvaliacao = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtabletabelaexcel = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/Image/Slide6.JPG"));
        Image image2 = icon2.getImage();
        jDesktopPane3 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g2){
                g2.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtabletabelaexcel2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(805, 720));

        jPanel3.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inserir Notas");

        jLabel3.setFont(new java.awt.Font("DJB Chalk It Up", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Avaliação");

        jComboBoxAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAvaliacaoActionPerformed(evt);
            }
        });

        Jtabletabelaexcel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Jtabletabelaexcel);

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
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("DJB Chalk It Up", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jComboBoxAvaliacao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(301, 301, 301))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jButton4))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );

        jTabbedPane1.addTab("Cadastrar", jPanel3);

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 720));

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
        Jtabletabelaexcel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jtabletabelaexcel2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Jtabletabelaexcel2);

        jLabel2.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Consultar Notas");

        jButton8.setBackground(new java.awt.Color(204, 153, 0));
        jButton8.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Gerar Media");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jDesktopPane3.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(283, 283, 283))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(289, 289, 289))))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton8)
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane3)
        );

        jTabbedPane1.addTab("Consultar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAvaliacaoActionPerformed
        String b =  jComboBoxAvaliacao.getSelectedItem().toString();

        itemDoComboboxAvaliar = b;
        System.out.println(itemDoComboboxAvaliar);

        Avaliacao at;
        try {   Avaliacao ab = new Avaliacao();
            ab.setId_Turma(Id_TurmaNotas);
            ab.setId_Bimestre(Id_BimestreNotas);
            ab.setId_Professor(Login.Id_ProfessorLogin);
            ab.setTitulo(b);
            at = dao.SelecionarIdAvaliacao(ab);
            Id_Avaliacao = at.getId_Avaliacao();
            System.out.println("O Id da Avaliação selecionada é " +Id_Avaliacao);
        } catch (Exception ex) {
            Logger.getLogger(TabbedPageNotas.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAvaliacaoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser jfile = new JFileChooser();
        jfile.showOpenDialog(this);
        File file = jfile.getSelectedFile();
        System.out.println(file);
        File filer = new File(file.toString());
        FileInputStream fisPlanilha = null;
        String [] vetor = null;
        ArrayList<Double>nota = new ArrayList<Double>();
        ArrayList<String> l = new ArrayList<>();

        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator filaIterator = sheet.rowIterator();
            int numerodelinhas = sheet.getLastRowNum();
            for(int a = 1;a<=numerodelinhas;a++){
                Row linhas = sheet.getRow(a);
                String [] string = new String[numerodelinhas];

                nota.add(linhas.getCell(2).getNumericCellValue());
            }

            for(int i = 0;i<Jtabletabelaexcel.getRowCount();i++){
                Jtabletabelaexcel.setValueAt(nota.get(i), i, 2);
            }

            int indiceColumna=0;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TabbedPageNotas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TabbedPageNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser fc = new JFileChooser();
        int option = fc.showSaveDialog(Jtabletabelaexcel);
        if (option == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();
            String path = fc.getSelectedFile().getParentFile().getPath();
            int len = filename.length();
            String ext = "";
            String file = "";
            if (len > 4) {
                ext = filename.substring(len - 4, len);
            }
            if (ext.equals(".xls")) {
                file = path + "\\" + filename;
            } else {
                file = path + "\\" + filename + ".xls";
            }
            try {
                toExcel(Jtabletabelaexcel, new File(file));
            } catch (IOException ex) {
                Logger.getLogger(TabbedPageNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Jtabletabelaexcel.isEditing()) {
            Jtabletabelaexcel.getCellEditor().stopCellEditing();
        }

        try {
            if(SalvarNotas() == true){
                JOptionPane.showMessageDialog(null, "Salvo");
            }else{
                JOptionPane.showMessageDialog(null, "Erro");
            }     } catch (Exception ex) {
                Logger.getLogger(TabbedPageNotas.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void Jtabletabelaexcel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jtabletabelaexcel2MouseClicked
        int linha =  Jtabletabelaexcel2.rowAtPoint(evt.getPoint());
        int coluna =  Jtabletabelaexcel2.columnAtPoint(evt.getPoint());
        System.out.println(linha + "," + coluna);
    }//GEN-LAST:event_Jtabletabelaexcel2MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
          InserirMedia im;
        try {
            im = new InserirMedia();
            im.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TabbedPageNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed
public boolean SalvarNotas() throws Exception, Exception{
     try {
                    int tam = Jtabletabelaexcel.getRowCount();
      for(int i = 0;i<tam;i++){
           Nota nota = new Nota();
      nota.setId_Turma(Id_TurmaInserirNotas);
      nota.setId_Avaliacao(Id_Avaliacao);
      nota.setId_Bimestre(Id_BimestreNotas);
      nota.setNota(Double.parseDouble(Jtabletabelaexcel.getValueAt(i,2).toString()));
      nota.setId_Professor(Login.Id_ProfessorLogin);
      Aluno a = new Aluno();
      a.setId_Turma(Id_TurmaInserirNotas);
      a.setNome(Jtabletabelaexcel.getValueAt(i,1).toString());
                       
                            for( Aluno aluno : daoaluno.SelecionarId_Alunos(a)){
                                int id = aluno.getId_Aluno();
                                
                                nota.setId_Aluno(id);
                                
                            }     
                            daonota.Salvar(nota);
      }

       } catch (Exception ex) {
                            Logger.getLogger(TabbedPageNotas.class.getName()).log(Level.SEVERE, null, ex);
                        }
      return true;
 }
    
                                        
          
      
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
            java.util.logging.Logger.getLogger(TabbedPageNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabbedPageNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabbedPageNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabbedPageNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try {
                    new TabbedPageNotas().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TabbedPageNotas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtabletabelaexcel;
    private javax.swing.JTable Jtabletabelaexcel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBoxAvaliacao;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
