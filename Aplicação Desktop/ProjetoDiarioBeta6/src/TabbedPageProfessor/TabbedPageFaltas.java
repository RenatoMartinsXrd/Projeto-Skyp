/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabbedPageProfessor;


import static Interfaces.Professor.ListarAvaliações.Id_BimestreNotas;
import Interfaces.Professor.Login;
import Modelo.Bean.Rest.Aluno;
import Modelo.Bean.Rest.Bimestre;
import Modelo.Bean.Rest.Chamada;
import Modelo.Bean.Rest.ConteudoProgramatico;
import Modelo.Bean.Rest.Frequencia;
import Modelo.Bean.Rest.Turma;
import Modelo.Bean.Rest.TurmaProfessor;
import Modelo.Dao.Rest.AlunoREST;
import Modelo.Dao.Rest.BimestreREST;
import Modelo.Dao.Rest.ChamadaREST;
import Modelo.Dao.Rest.ConteudoProgramaticoREST;
import Modelo.Dao.Rest.FrequenciaREST;
import Modelo.Dao.Rest.TurmaProfessorREST;
import Modelo.Dao.Rest.TurmaREST;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import mercado.ModeloTabelaBooleanFaltas;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import mercado.ModeloTabela;


/**
 *
 * @author Scarlxrd2112
 */ 
public class TabbedPageFaltas extends javax.swing.JFrame {
 public static String itemDoComboboxFaltasSerie;
   public static String itemDoComboboxFaltasBimestre;
      public static int Id_BimestreFaltas;
       public static int Id_turmaFaltas;
      public static String Titulo;
       public static  java.sql.Date Data_Conteudo;
      
      ChamadaREST daochamada = new ChamadaREST();
      BimestreREST bimestredao = new BimestreREST();
     TurmaProfessorREST daoturmaprofessor = new TurmaProfessorREST();
   TurmaREST dao = new TurmaREST();
   AlunoREST daoaluno = new AlunoREST();
   FrequenciaREST faltardao = new FrequenciaREST();
       JTextField campo;

     
   /**
     * Creates new form Tabela
     */
  

     
   /**
     * Creates new form Tabela
     */
   
     

      
    public TabbedPageFaltas() throws Exception {
  
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
        for(TurmaProfessor t1 : daoturmaprofessor.listarTurmaProfesssor(b)){
            jComboBoxSerie.addItem(t1.getSerie());
          
        }
         for(Bimestre bi1 : bimestredao.ListarTodosBimestres()){
            jComboBoxBimestre.addItem(bi1.toString());
           
            
        }
         
            for(TurmaProfessor t : daoturmaprofessor.listarTurmaProfesssor(b)){
            jComboBoxSerie1.addItem(t.getSerie());
          
        }
         for(Bimestre bi : bimestredao.ListarTodosBimestres()){
            jComboBoxBimestre1.addItem(bi.toString());
           
            
        }
          
            campo = new JTextField();
  
    
     

    
       
     
           
          
         
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
    }
    public void preencherTabela() throws Exception{
        
             String [] colunas = new String[]{"Numero_Chamada","Nome","Presente"};
          ArrayList dados = new  ArrayList();
//                filas[0]=rs.getString(1);
 
     
      dados.clear();
  
                   Frequencia falta = new Frequencia();
                  //boolean bolano = true;
                  Chamada chame = new Chamada();
                  falta.setChecar(true);
                  chame.setId_Turma(Id_turmaFaltas);
             for (Chamada ch : daochamada.listarChamadaId_Turma(chame)) {
                
                    
                     
                     
                     
                    
                     
                
                  
                    
                      dados.add(new Object[]{
                      ch.getNumero_Chamada(),ch.getNome(),falta.isChecar(),
                      });
                     
                 
             }
                 
     
                     if(dados.isEmpty()){
                    JOptionPane.showMessageDialog(null, "A Tabela não possui dados para mostrar");
                }else{
                ModeloTabelaBooleanFaltas modelo2 = new ModeloTabelaBooleanFaltas(dados,colunas);
            Jtabletabelaexcel.setModel(modelo2);  
                }
      
        
             
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
    
     public void preencherTabelaConsulta() throws Exception{
        
             String [] colunas = new String[]{"Numero_Chamada","Nome","Total Faltas"};
          ArrayList dados = new  ArrayList();
//                filas[0]=rs.getString(1);
 
     
      dados.clear();
  
                   Frequencia falta = new Frequencia();
                    Frequencia fre = new Frequencia();
                  //boolean bolano = true;
                  Chamada chame = new Chamada();
                  falta.setChecar(true);
                  chame.setId_Turma(Id_turmaFaltas);
             for (Chamada ch : daochamada.listarChamadaId_Turma(chame)) {
                 int Id_Aluno = 0;
                 Aluno a = new Aluno();
                 a.setNome(ch.getNome());
                 a.setId_Turma(Id_turmaFaltas);
                 for(Aluno alunao : daoaluno.SelecionarId_Alunos(a)){
                    Id_Aluno = alunao.getId_Aluno();
                 }
                 
                 
                fre.setFalta("F");
                fre.setId_Professor(Login.Id_ProfessorLogin);
                Date data1 = Calendario1.getDate();
       long d1 = data1.getTime();
       java.sql.Date novo1 =  new java.sql.Date(d1);
           Date data2 = Calendario2.getDate();
       long d2 = data2.getTime();
       java.sql.Date novo2 =  new java.sql.Date(d2);
                fre.setId_Turma(Id_turmaFaltas);
                fre.setData(novo1);
                fre.setData_Saida(novo2);
                fre.setId_Aluno(Id_Aluno);
                int Total = 0;
                    for(Frequencia faltou : faltardao.listarFrequenciaPorData(fre)){
                       Total = faltou.getTotal_Falta();
                    }
                     
                     
                     
                    
                     
                
                  
                    
                      dados.add(new Object[]{
                      ch.getNumero_Chamada(),ch.getNome(),Total,
                      });
                     
             }
             
                 
     
                     if(dados.isEmpty()){
                    JOptionPane.showMessageDialog(null, "A Tabela não possui dados para mostrar");
                }else{
                ModeloTabela modelo2 = new ModeloTabela(dados,colunas);
            Jtabletabelaexcel2.setModel(modelo2);  
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
               Jtabletabelaexcel2.getColumnModel().getColumn(0).setPreferredWidth(50);
       Jtabletabelaexcel2.getColumnModel().getColumn(0).setResizable(false);
              Jtabletabelaexcel2.getColumnModel().getColumn(1).setPreferredWidth(180);
       Jtabletabelaexcel2.getColumnModel().getColumn(1).setResizable(false);
              Jtabletabelaexcel2.getColumnModel().getColumn(2).setPreferredWidth(50);
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
        jLabel3 = new javax.swing.JLabel();
        Calendario = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaConteudo = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxBimestre = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxSerie = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtabletabelaexcel = new javax.swing.JTable();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxSerie1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxBimestre1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        Calendario1 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        Calendario2 = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        Jtabletabelaexcel2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inserir Faltas");

        jLabel3.setFont(new java.awt.Font("DJB Chalk It Up", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data");

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

        jLabel4.setFont(new java.awt.Font("DJB Chalk It Up", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Conteúdo da aula");

        jTextAreaConteudo.setColumns(20);
        jTextAreaConteudo.setRows(5);
        jScrollPane2.setViewportView(jTextAreaConteudo);

        jLabel5.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bimestre");

        jComboBoxBimestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBimestreActionPerformed(evt);
            }
        });

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

        jButton3.setBackground(new java.awt.Color(204, 153, 0));
        jButton3.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("DJB Chalk It Up", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane3.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(Calendario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jComboBoxBimestre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jComboBoxSerie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxBimestre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(3, 3, 3)
                                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37))))
                            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jScrollPane1)
                                .addGap(37, 37, 37)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                .addGap(302, 302, 302))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 48, Short.MAX_VALUE)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxBimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
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

        jLabel9.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Consultar Faltas");

        jLabel7.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Serie");

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

        jLabel8.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Bimestre");

        jComboBoxBimestre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBimestre1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Data");

        Calendario1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Calendario1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Calendario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Calendario1MouseClicked(evt);
            }
        });
        Calendario1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                Calendario1InputMethodTextChanged(evt);
            }
        });
        Calendario1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Calendario1PropertyChange(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Até");

        Calendario2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Calendario2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Calendario2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Calendario2MouseClicked(evt);
            }
        });
        Calendario2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                Calendario2InputMethodTextChanged(evt);
            }
        });
        Calendario2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Calendario2PropertyChange(evt);
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
        jScrollPane3.setViewportView(Jtabletabelaexcel2);

        jButton4.setBackground(new java.awt.Color(204, 153, 0));
        jButton4.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Consultar por Data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 153, 0));
        jButton5.setFont(new java.awt.Font("DJB Chalk It Up", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Consultar por Bimestre");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jDesktopPane4.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jComboBoxSerie1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jComboBoxBimestre1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(Calendario1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(Calendario2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addComponent(Calendario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addComponent(jComboBoxSerie1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxBimestre1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Calendario2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)))
                .addGap(335, 335, 335))
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addContainerGap(422, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxBimestre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(32, 32, 32)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Calendario1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Calendario2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton7))
                .addGap(42, 42, 42))
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
                Logger.getLogger(TabbedPageFaltas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void CalendarioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_CalendarioAncestorAdded

    }//GEN-LAST:event_CalendarioAncestorAdded

    private void CalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalendarioMouseClicked

    }//GEN-LAST:event_CalendarioMouseClicked

    private void CalendarioInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_CalendarioInputMethodTextChanged

    }//GEN-LAST:event_CalendarioInputMethodTextChanged

    private void CalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalendarioPropertyChange

    }//GEN-LAST:event_CalendarioPropertyChange

    private void jComboBoxBimestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBimestreActionPerformed
        String BimestreNotas =  jComboBoxBimestre.getSelectedItem().toString();

        itemDoComboboxFaltasBimestre = BimestreNotas;
        Bimestre Nome = new Bimestre();
        Nome.setBimestre(itemDoComboboxFaltasBimestre);
        try {
            for(Bimestre bi : bimestredao.ListarId_Bimestre(Nome)){
                Id_BimestreNotas = bi.getId_Bimestre();
                System.out.println( "O ID do bimestre relacionado é " + Id_BimestreNotas);
            }
        } catch (Exception ex) {
            Logger.getLogger(TabbedPageFaltas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxBimestreActionPerformed

    private void jComboBoxSerieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxSerieMouseClicked

    }//GEN-LAST:event_jComboBoxSerieMouseClicked

    private void jComboBoxSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSerieActionPerformed

        String Serie =  jComboBoxSerie.getSelectedItem().toString();

        itemDoComboboxFaltasSerie = Serie;
        System.out.println( itemDoComboboxFaltasSerie);

        Turma SerieCombo = new Turma();
        SerieCombo.setSerie(itemDoComboboxFaltasSerie);

        try {
            for(Turma turma : dao.listarId_TurmaSerie(SerieCombo)){
                System.out.println(turma.getId_Turma());
                Id_turmaFaltas = turma.getId_Turma();
                System.out.println("O Id da serie selecionada é " +Id_turmaFaltas);
            }
        } catch (Exception ex) {
            Logger.getLogger(TabbedPageFaltas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBoxSerieActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            preencherTabela();

            //                filas[0]=rs.getString(1);
        } catch (Exception ex) {
            Logger.getLogger(Chamada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
public boolean SalvarNotas() throws Exception, Exception{
     Frequencia nota = new Frequencia();
     Aluno a = new Aluno();
     String Comparecido = "C";
     String Faltou = "F";
     if (Jtabletabelaexcel.isEditing()) {
    Jtabletabelaexcel.getCellEditor().stopCellEditing();
}
         
     try {
                    int tam = Jtabletabelaexcel.getRowCount();
      for(int i = 0;i<tam;i++){
             if(Jtabletabelaexcel.getValueAt(i, 2).equals(true)){
                   nota.setFalta("C");
             }else{
                  nota.setFalta("F");
             }
             
           
      nota.setId_Turma(Id_turmaFaltas);
      nota.setId_Bimestre(Id_BimestreNotas);
  
     
      nota.setId_Professor(Login.Id_ProfessorLogin);
      
      a.setId_Turma(Id_turmaFaltas);
      a.setNome(Jtabletabelaexcel.getValueAt(i,1).toString());
               for( Aluno aluno : daoaluno.SelecionarId_Alunos(a)){
                                int id = aluno.getId_Aluno();
                                
                                nota.setId_Aluno(id);
                                
                            }
      Date data = Calendario.getDate();
      long d = data.getTime();
     java.sql.Date novo =  new java.sql.Date(d);
     Data_Conteudo = novo;
       System.out.println(novo);
        nota.setData(novo);
                            faltardao.Salvar(nota);
                            
             
      }
         ConteudoProgramatico cp = new ConteudoProgramatico();
         cp.setId_Bimestre(Id_BimestreNotas);
         cp.setConteudoProgramatico(jTextAreaConteudo.getText());
         cp.setData_ConteudoProgramatico(Data_Conteudo);
         cp.setId_Professor(Login.Id_ProfessorLogin);
         cp.setId_Turma(Id_turmaFaltas);
         ConteudoProgramaticoREST cpr = new ConteudoProgramaticoREST();
         cpr.Salvar(cp);
       } catch (Exception ex) {
                            Logger.getLogger(TabbedPageFaltas.class.getName()).log(Level.SEVERE, null, ex);
                        }
      return true;
 }
   
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
                Logger.getLogger(TabbedPageFaltas.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxSerie1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxSerie1MouseClicked

    }//GEN-LAST:event_jComboBoxSerie1MouseClicked

    private void jComboBoxSerie1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSerie1ActionPerformed

        String Serie =  jComboBoxSerie1.getSelectedItem().toString();

        itemDoComboboxFaltasSerie = Serie;
        System.out.println( itemDoComboboxFaltasSerie);

        Turma SerieCombo = new Turma();
        SerieCombo.setSerie(itemDoComboboxFaltasSerie);

        try {
            for(Turma turma : dao.listarId_TurmaSerie(SerieCombo)){
                System.out.println(turma.getId_Turma());
                Id_turmaFaltas = turma.getId_Turma();
                System.out.println("O Id da serie selecionada é " +Id_turmaFaltas);
            }
        } catch (Exception ex) {
            Logger.getLogger(TabbedPageFaltas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

        } catch (Exception ex) {
            Logger.getLogger(TabbedPageFaltas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxSerie1ActionPerformed

    private void jComboBoxBimestre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBimestre1ActionPerformed
        String BimestreNotas =  jComboBoxBimestre1.getSelectedItem().toString();

        itemDoComboboxFaltasBimestre = BimestreNotas;
        Bimestre Nome = new Bimestre();
        Nome.setBimestre(itemDoComboboxFaltasBimestre);
        try {
            for(Bimestre bi : bimestredao.ListarId_Bimestre(Nome)){
                Id_BimestreNotas = bi.getId_Bimestre();
                System.out.println( "O ID do bimestre relacionado é " + Id_BimestreNotas);
            }
        } catch (Exception ex) {
            Logger.getLogger(TabbedPageFaltas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxBimestre1ActionPerformed

    private void Calendario1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Calendario1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_Calendario1AncestorAdded

    private void Calendario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Calendario1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Calendario1MouseClicked

    private void Calendario1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Calendario1InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Calendario1InputMethodTextChanged

    private void Calendario1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Calendario1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_Calendario1PropertyChange

    private void Calendario2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Calendario2AncestorAdded

    }//GEN-LAST:event_Calendario2AncestorAdded

    private void Calendario2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Calendario2MouseClicked

    }//GEN-LAST:event_Calendario2MouseClicked

    private void Calendario2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Calendario2InputMethodTextChanged

    }//GEN-LAST:event_Calendario2InputMethodTextChanged

    private void Calendario2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Calendario2PropertyChange

    }//GEN-LAST:event_Calendario2PropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
           preencherTabelaConsulta();

            //                filas[0]=rs.getString(1);
        } catch (Exception ex) {
            Logger.getLogger(Chamada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed
public String nulo;
    
    public String nome;
    
    
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
            java.util.logging.Logger.getLogger(TabbedPageFaltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabbedPageFaltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabbedPageFaltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabbedPageFaltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TabbedPageFaltas().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TabbedPageFaltas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Calendario;
    private com.toedter.calendar.JDateChooser Calendario1;
    private com.toedter.calendar.JDateChooser Calendario2;
    private javax.swing.JTable Jtabletabelaexcel;
    private javax.swing.JTable Jtabletabelaexcel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBoxBimestre;
    private javax.swing.JComboBox<String> jComboBoxBimestre1;
    private javax.swing.JComboBox<Object> jComboBoxSerie;
    private javax.swing.JComboBox<Object> jComboBoxSerie1;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaConteudo;
    // End of variables declaration//GEN-END:variables
}
