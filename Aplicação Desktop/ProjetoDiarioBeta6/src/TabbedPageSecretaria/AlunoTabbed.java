/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabbedPageSecretaria;


import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import Interfaces.Secretaria.*;
import Modelo.Bean.Rest.Aluno;
import Modelo.Bean.Rest.ProfessorCadastro;

import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import Modelo.Bean.Rest.Turma;
import Modelo.Dao.Rest.AlunoREST;
import Modelo.Dao.Rest.TurmaREST;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.table.TableModel;
import mercado.ModeloTabela;
import mercado.ModeloTabelaBooleanAluno;


/**
 *
 * @author Scarlxrd2112
 */ 
public class AlunoTabbed extends javax.swing.JFrame {
    public static String itemDoComboboxProfessor;
    
     public static int Id_TurmaProfessor;
     public static String Nome;
      
   JScrollPane rolagem;
   
     JTextField campo;
     ProfessorCadastro profcadastro = new ProfessorCadastro();
      ProfessorCadastro teste = new ProfessorCadastro();
     JComboBox combo;
  

     
   /**
     * Creates new form Tabela
     */
   String [] colunas = new String[]{"Nome","RA","Data de Nascimento"};
        public static String itemDoComboboxAluno;
     public static int Id_TurmaAluno;
         public static String itemDoComboboxAluno1;
     public static int Id_TurmaAluno1;
    ArrayList dados = new  ArrayList();
       TurmaREST tr = new TurmaREST();
        AlunoREST dao1 = new AlunoREST();
      Font roboto=null;
      
    public AlunoTabbed() throws Exception {
  
        initComponents();
        
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
         
        for(Turma t : tr.ListarTodasTurmas()){
            jComboBoxSerie.addItem(t);
          
        }
        
           for(Turma t : tr.ListarTodasTurmas()){
            jComboBoxSerie1.addItem(t);
          
        }
        
       
           this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     
       
                                                                      
      
          
        
        campo = new JTextField();
        rolagem = new JScrollPane();
        combo = new JComboBox();
     

    
       
     
           
          
         
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
    
        
        
            
      public void preencherTabela(){
           
      
                    ModeloTabela modelo = new ModeloTabela(dados, colunas);
             Jtabletabelaexcel.setModel(modelo);
              
      //((DefaultTableCellRenderer)Jtabletabelaexcel2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
          Jtabletabelaexcel.setForeground(Color.BLACK);
          Jtabletabelaexcel.setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
          Jtabletabelaexcel.getTableHeader().setForeground(Color.BLUE);
          Jtabletabelaexcel.setRowHeight(25);
          Jtabletabelaexcel.setGridColor(Color.BLACK);
          Jtabletabelaexcel.setShowGrid(true);
          Jtabletabelaexcel.setColumnSelectionAllowed(true);
          Jtabletabelaexcel.setRowSelectionAllowed(true);
          Jtabletabelaexcel.setCellSelectionEnabled(true);
          Jtabletabelaexcel.getColumnModel().getColumn(0).setPreferredWidth(180);
       Jtabletabelaexcel.getColumnModel().getColumn(0).setResizable(false);
        Jtabletabelaexcel.getColumnModel().getColumn(1).setPreferredWidth(180);
       Jtabletabelaexcel.getColumnModel().getColumn(1).setResizable(false);    
          Jtabletabelaexcel.getColumnModel().getColumn(2).setPreferredWidth(180);
       Jtabletabelaexcel.getColumnModel().getColumn(2).setResizable(false); 

             }
    
    
        
     public void preencherTabelaConsulta() throws Exception{
           AlunoREST prest = new AlunoREST();
          
//                filas[0]=rs.getString(1);
 
      String [] colunas1 = new String[]{"Nome","RA","Data de Nascimento","Excluir"};
          ArrayList dados1 = new  ArrayList();
         
          
          Aluno a = new Aluno();
          a.setId_Turma(Id_TurmaAluno1);
         
     
          
                
         
           
          for(Aluno ch : prest.listarAlunos(a)){
             boolean check = false;
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

          dados1.add(new Object[]{
                      ch.getNome(),ch.getRA(),sdf.format(ch.getData_Nascimento()),ch.isExcluir(),
                      });
  
          }
           
        
   
                     
                 
             
                 
                 
                  ModeloTabelaBooleanAluno modelo = new  ModeloTabelaBooleanAluno(dados1, colunas1);
              Jtabletabelaexcel2.setModel(modelo);
                    
            
                
     
                     
      
      //((DefaultTableCellRenderer)Jtabletabelaexcel2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
          Jtabletabelaexcel2.setForeground(Color.BLACK);
          Jtabletabelaexcel2.setFont(new Font("DJB Chalk It Up",Font.BOLD,14));
          Jtabletabelaexcel2.getTableHeader().setFont(new Font("DJB Chalk It Up",Font.BOLD,18));
          Jtabletabelaexcel2.getTableHeader().setForeground(Color.BLACK);
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
         Jtabletabelaexcel2.getColumnModel().getColumn(2).setPreferredWidth(180);
       Jtabletabelaexcel2.getColumnModel().getColumn(2).setResizable(false); 
         Jtabletabelaexcel2.getColumnModel().getColumn(3).setPreferredWidth(70);
       Jtabletabelaexcel2.getColumnModel().getColumn(3).setResizable(false); 
             }
     
    public String nome;
  
  public boolean CadastrarAluno() throws Exception, Exception{
          Aluno aluno = new Aluno();
              Jtabletabelaexcel.editCellAt(Jtabletabelaexcel.getSelectedRow(),Jtabletabelaexcel.getSelectedColumn());
        Jtabletabelaexcel.removeEditor();
        int tam = Jtabletabelaexcel.getRowCount();
        for(int i = 0;i<tam;i++){
  
    
              aluno.setId_Turma(Id_TurmaAluno);
            aluno.setNome(Jtabletabelaexcel.getValueAt(i, 0).toString());
           aluno.setRA(Jtabletabelaexcel.getValueAt(i, 1).toString());
             if(Jtabletabelaexcel.getValueAt(i, 2).equals("")){
              JOptionPane.showMessageDialog(null, "Por favor preencha a Data os campos não serão salvos");    
 break;
           
           }else{
                
           
 
      String dataStr = Jtabletabelaexcel.getValueAt(i, 2).toString();
                 System.out.println(dataStr);
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
java.sql.Date datas = new java.sql.Date(format.parse(dataStr).getTime());
                 System.out.println(datas);
                
           aluno.setData_Nascimento(datas);
             }
            
         
           nome = aluno.getNome();
            System.out.println(nome);
           
                 dao1.Salvar(aluno);
            
           
        }
        
    
      
      return true;
      
  }
     

      
         
               
                

                       
   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/Slide6.JPG"));
        Image image = icon.getImage();
        jDesktopPane3 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxSerie = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtabletabelaexcel = new javax.swing.JTable();
        jTextFieldLoop = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/Image/Slide6.JPG"));
        Image image2 = icon2.getImage();
        jDesktopPane4 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxSerie1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtabletabelaexcel2 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inserir Aluno");

        jLabel6.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Serie");

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

        Jtabletabelaexcel.setBackground(new java.awt.Color(240, 240, 240));
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

        jButton3.setBackground(new java.awt.Color(204, 153, 0));
        jButton3.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Adicionar Aluno");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 153, 0));
        jButton4.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Importar do Excel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SALVAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane3.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jComboBoxSerie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jTextFieldLoop, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jDesktopPane3Layout.createSequentialGroup()
                            .addComponent(jTextFieldLoop, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(271, 271, 271)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jTextFieldLoop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(72, 72, 72))
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

        jTabbedPane1.addTab("Cadastrar", jPanel2);

        jLabel3.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Consultar Aluno");

        jLabel4.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome");

        jLabel5.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("RA");

        jLabel7.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Data de Nascimento");

        jLabel8.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Serie");

        jComboBoxSerie1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxSerie1MouseClicked(evt);
            }
        });
        jComboBoxSerie1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSerie1ActionPerformed(evt);
            }
        });

        Jtabletabelaexcel2.setBackground(new java.awt.Color(240, 240, 240));
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
        jScrollPane2.setViewportView(Jtabletabelaexcel2);

        jButton7.setBackground(new java.awt.Color(204, 153, 0));
        jButton7.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Exportar Excel");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 153, 0));
        jButton6.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("EXCLUIR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 153, 0));
        jButton5.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("ALTERAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(204, 153, 0));
        jButton10.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Buscar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jDesktopPane4.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jComboBoxSerie1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jButton10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane4Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(84, 84, 84))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10)))
                        .addContainerGap(75, Short.MAX_VALUE))))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane4)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane4)
        );

        jTabbedPane1.addTab("Consultar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSerieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxSerieMouseClicked

    }//GEN-LAST:event_jComboBoxSerieMouseClicked

    private void jComboBoxSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSerieActionPerformed

        try {
            String b =  jComboBoxSerie.getSelectedItem().toString();

            itemDoComboboxAluno = b;
            System.out.println(itemDoComboboxAluno);

            Turma turmaaa = new Turma();
            turmaaa.setSerie(itemDoComboboxAluno);

            for(Turma turma : tr.listarId_TurmaSerie(turmaaa)){
                Id_TurmaAluno = turma.getId_Turma();
                System.out.println("O Id da serie selecionada é " +Id_TurmaAluno);
            }
        } catch (Exception ex) {
            Logger.getLogger(AlunoTabbed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxSerieActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int zikadobagui = Integer.parseInt(jTextFieldLoop.getText().toString());
        ArrayList sla = new ArrayList();
        for(int i = 0;i<zikadobagui;i++){
            dados.add(new Object[]{
                "","",""

            });
        }

        Jtabletabelaexcel.scrollRectToVisible(Jtabletabelaexcel.getCellRect(Jtabletabelaexcel.getRowCount()-1,0,true));
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        Jtabletabelaexcel.setModel(modelo);
        /*
        /*

        int maxValue = rolagem.getVerticalScrollBar().getMaximum();
        rolagem.getViewport().setViewPosition(new Point(0,maxValue));
        */
    }//GEN-LAST:event_jButton3ActionPerformed

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
            Jtabletabelaexcel.setModel(modelo);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlunoTabbed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlunoTabbed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AlunoTabbed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            if(CadastrarAluno()==true){

                System.out.println("Salvo");
                ;
                //System.out.println(Nomes.get(i));
                //System.out.println("teste");

                //for(ProfessorCadastro prof : dao1.SelecionarId_Professor(Nomes.get(i).toString(), Disciplina.get(i).toString())){
                    //System.out.println(prof.getId_Professor());
                    //i++;

                    JOptionPane.showMessageDialog(null,"Salvo");

                }else{
                    JOptionPane.showMessageDialog(null,"Verifique se os campos estão todos preenchidos");
                }
            } catch (Exception ex) {
                Logger.getLogger(AlunoTabbed.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                preencherTabelaConsulta();
            } catch (Exception ex) {
                Logger.getLogger(AlunoTabbed.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxSerie1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxSerie1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSerie1MouseClicked

    private void jComboBoxSerie1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSerie1ActionPerformed
        try {
            String b =  jComboBoxSerie1.getSelectedItem().toString();

            itemDoComboboxAluno1 = b;
            System.out.println(itemDoComboboxAluno1);

            Turma turmaaa = new Turma();
            turmaaa.setSerie(itemDoComboboxAluno1);

            for(Turma turma : tr.listarId_TurmaSerie(turmaaa)){
                Id_TurmaAluno1 = turma.getId_Turma();
                System.out.println("O Id da serie selecionada é " +Id_TurmaAluno1);
            }
        } catch (Exception ex) {
            Logger.getLogger(AlunoTabbed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBoxSerie1ActionPerformed

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
                Logger.getLogger(AlunoTabbed.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        try {
            preencherTabelaConsulta();

            //                filas[0]=rs.getString(1);
        } catch (Exception ex) {
            Logger.getLogger(Chamada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(AlunoTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlunoTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlunoTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlunoTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try {
                    new AlunoTabbed().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(AlunoTabbed.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtabletabelaexcel;
    private javax.swing.JTable Jtabletabelaexcel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<Object> jComboBoxSerie;
    private javax.swing.JComboBox<Object> jComboBoxSerie1;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldLoop;
    // End of variables declaration//GEN-END:variables
}
