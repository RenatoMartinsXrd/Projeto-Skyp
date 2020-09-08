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
import Modelo.Bean.Avaliacao;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import Modelo.Bean.Rest.ProfessorCadastro;
import Modelo.Dao.Rest.ProfessorCadastroREST;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableModel;
import mercado.ModeloTabela;
import mercado.ModeloTabelaBooleanProfessor;


/**
 *
 * @author Scarlxrd2112
 */ 
public class ProfessorTabbed extends javax.swing.JFrame {
  public static String itemDoComboboxProfessor;
     public static int Id_TurmaProfessor;
     public static String Nome;
      
   JScrollPane rolagem;
    DefaultTableModel modelo;
     JTextField campo;
     ProfessorCadastro profcadastro = new ProfessorCadastro();
      ProfessorCadastro teste = new ProfessorCadastro();
     JComboBox combo;
  

     
   /**
     * Creates new form Tabela
     */
   String [] colunas = new String[]{"Nome","Diciplina","CPF"};
    
    ArrayList dados = new  ArrayList();
       ArrayList Nomes = new ArrayList();
       ArrayList Disciplina = new ArrayList();
          String arraynome [];
         String arrayDisciplina [];
      Font roboto=null;
  

     
   /**
     * Creates new form Tabela
     */
   
     

      
    public ProfessorTabbed() throws Exception {
  
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
            preencherTabelaConsulta();
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
           
          
//                filas[0]=rs.getString(1);
 
     
     
  
                  
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
           ProfessorCadastroREST prest = new ProfessorCadastroREST();
          
//                filas[0]=rs.getString(1);
 
      String [] colunas = new String[]{"Nome","CPF","Disciplina","Excluir"};
          ArrayList dados = new  ArrayList();
      
          boolean check = false;
          for(ProfessorCadastro ch : prest.ListarTodosProfessores()){
          
          dados.add(new Object[]{
                      ch.getNome(),ch.getCPF(),ch.getDisciplina(),check
                      });
  
          }
                   ModeloTabelaBooleanProfessor modelo = new  ModeloTabelaBooleanProfessor(dados, colunas);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtabletabelaexcel = new javax.swing.JTable();
        jTextFieldLoop = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/Image/Slide6.JPG"));
        Image image2 = icon2.getImage();
        jDesktopPane4 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtabletabelaexcel2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inserir Professor");

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
        jButton3.setText("Adicionar Professor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
        jDesktopPane3.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jTextFieldLoop, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldLoop, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addContainerGap(83, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addGap(88, 88, 88)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jTextFieldLoop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
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

        jLabel9.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Consultar Professor");

        jLabel4.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome");

        jLabel3.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CPF");

        jLabel5.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Disciplina");

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

        jDesktopPane4.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(89, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(84, 84, 84))))
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane4Layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addGap(81, 81, 81)))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(49, 49, 49)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(464, 464, 464)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addGap(42, 42, 42))
            .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane4Layout.createSequentialGroup()
                    .addGap(174, 174, 174)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(175, Short.MAX_VALUE)))
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
                Logger.getLogger(ProfessorTabbed.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
public String nulo;
    public boolean Testar() throws Exception{
      
        Avaliacao avaliacao = new Avaliacao();
       Avaliacao teste = new Avaliacao();
       
       
         //Boolean valor = (Boolean) Jtabletabelaexcel2.getValueAt(Jtabletabelaexcel2.getSelectedRow(), Jtabletabelaexcel2.getSelectedColumn());
        
        boolean a = false;
        boolean b;
      
     
       
        ProfessorCadastroREST dao = new ProfessorCadastroREST();
         
        Jtabletabelaexcel.editCellAt(Jtabletabelaexcel.getSelectedRow(),Jtabletabelaexcel.getSelectedColumn());
        Jtabletabelaexcel.removeEditor();
      int tam = Jtabletabelaexcel.getRowCount();
        for(int i = 0;i<tam;i++){
      
              
            profcadastro.setNome((Jtabletabelaexcel.getValueAt(i, 0).toString()));
           Jtabletabelaexcel.getValueAt(i, 0).toString();
          profcadastro.setDisciplina(Jtabletabelaexcel.getValueAt(i, 1).toString());
         Jtabletabelaexcel.getValueAt(i, 1).toString();
          profcadastro.setCPF(Jtabletabelaexcel.getValueAt(i,2).toString());
       
       dao.Salvar(profcadastro);
     
        }
          nulo = "Erro ao Salvar,verifique se todos os campos estão preenchidos corretamente";
             return true;
      }
    public String nome;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            if(Testar()==true){

                System.out.println("Salvo");
                ;
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
                Logger.getLogger(ProfessorTabbed.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                preencherTabelaConsulta();
            } catch (Exception ex) {
                Logger.getLogger(ProfessorTabbed.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(ProfessorTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfessorTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfessorTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfessorTabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ProfessorTabbed().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ProfessorTabbed.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtabletabelaexcel;
    private javax.swing.JTable Jtabletabelaexcel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
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
