/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces.Professor;

import static Interfaces.Professor.ListarAvaliações.Id_BimestreNotas;
import static Interfaces.Professor.ListarAvaliações.Id_TurmaNotas;
import Modelo.Bean.Media;
import Modelo.Bean.Rest.Aluno;
import Modelo.Bean.Rest.Avaliacao;
import Modelo.Bean.Rest.Chamada;
import Modelo.Bean.Rest.Nota;
import Modelo.Dao.Rest.AlunoREST;


import Modelo.Dao.Rest.AvaliacaoREST;
import Modelo.Dao.Rest.ChamadaREST;
import Modelo.Dao.Rest.MediaREST;
import Modelo.Dao.Rest.NotaREST;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import mercado.JanelaMedia;
import static mercado.JanelaMedia.pesos;
import mercado.ModeloTabela;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
/**
 *
 * @author renato.malmeida
 */
public class InserirMedia extends javax.swing.JFrame {
  public static String itemDoComboboxAvaliar;
  
      public static int Id_Avaliacao;
      public static String Titulo;
       public static int Id_TurmaInserirNotas;
      AvaliacaoREST dao = new AvaliacaoREST();
      ChamadaREST daochamada = new ChamadaREST();
      MediaREST daoMedia = new MediaREST();
      AlunoREST daoaluno = new AlunoREST();
       JTextField campo;
       ArrayList<Avaliacao> quantAvaliacao = new ArrayList<Avaliacao>();
      
    /**
     * Creates new form InserirNotas
     */
        private static InserirMedia instance;
       
    
  
public static InserirMedia  getInstance() throws Exception{
		if(instance == null)
			instance = new InserirMedia();
		return instance;
	}


    public InserirMedia() throws Exception {
       
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
       
     quantAvaliacao = dao.SelecionarAvaliacao(a);
          
      
          
            campo = new JTextField();
  
    
     

    
       
     
           
          
         
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
    }
      
    public void preencherTabela() throws Exception{
        
             String [] colunas = new String[]{"Numero_Chamada","Nome","Nota"};
          ArrayList dados = new  ArrayList();
//                filas[0]=rs.getString(1);
 
     
     
  
   
                  Chamada chame = new Chamada();
                  chame.setId_Turma(Id_TurmaInserirNotas);
             for (Chamada ch : daochamada.listarChamadaId_Turma(chame)) {
                
                    
                     
                     
                     
                     
                     
                
                     
                    
                      dados.add(new Object[]{
                      ch.getNumero_Chamada(),ch.getNome(),""
                      });
                     
                 
             
                 
     
                     
      
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
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
               Jtabletabelaexcel2.getColumnModel().getColumn(0).setPreferredWidth(50);
       Jtabletabelaexcel2.getColumnModel().getColumn(0).setResizable(false);
              Jtabletabelaexcel2.getColumnModel().getColumn(1).setPreferredWidth(180);
       Jtabletabelaexcel2.getColumnModel().getColumn(1).setResizable(false);
              Jtabletabelaexcel2.getColumnModel().getColumn(2).setPreferredWidth(50);
       Jtabletabelaexcel2.getColumnModel().getColumn(2).setResizable(false);
   
    
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

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/Slide6.JPG"));
        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxMedia = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtabletabelaexcel2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("DJB Chalk It Up", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Media");

        jLabel3.setFont(new java.awt.Font("DJB Chalk It Up", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Escolha de Tipo de Media");

        jComboBoxMedia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Média Livre", "Média Simples", "Média Ponderada", " " }));
        jComboBoxMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMediaActionPerformed(evt);
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

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("DJB Chalk It Up", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jComboBoxMedia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGap(408, 408, 408)
                            .addComponent(jButton1))
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGap(207, 207, 207)
                            .addComponent(jLabel1))
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBoxMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(72, Short.MAX_VALUE)))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel1)
                    .addGap(37, 37, 37)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBoxMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(35, 35, 35)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(25, 25, 25)))
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

    private void jComboBoxMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMediaActionPerformed
        String c =  jComboBoxMedia.getSelectedItem().toString();
        double resultado = 0;
        double MediaFinal = 0;
        int Id_Avaliacao = 0;
        int NumeroDeAvaliacoes = 0;
        ArrayList<Double> a = new ArrayList<Double>();
        ArrayList<String> b = new ArrayList<String>();

        Aluno alun = new Aluno();
        ArrayList<Integer> IdsAvaliacao = new ArrayList<Integer>();
        AvaliacaoREST ar = new AvaliacaoREST();
        String nome = "";

        ArrayList<Nota> arraynota = new ArrayList<Nota>();
        AlunoREST alunor = new AlunoREST();
        Avaliacao avaliar = new Avaliacao();
        Avaliacao avaliacao = new Avaliacao();
        System.out.println("Voce escolheu " + b);
        String vaisefu = "";

        switch(c){
            case "Média Simples":
            int conte = Jtabletabelaexcel2.getRowCount();
            for(int i = 0;i<conte;i++){
                double notaResult= 0;
                vaisefu = Jtabletabelaexcel2.getValueAt(i, 1).toString();

                alun.setNome(vaisefu);
                alun.setId_Turma(ListarAvaliações.Id_TurmaNotas);
                try {
                    int Id_Aluno = 0;
                    for(Aluno al : alunor.SelecionarId_Alunos(alun)){
                        Id_Aluno =  al.getId_Aluno();
                    }
                    NotaREST nr = new NotaREST();
                    Nota notao = new Nota();
                    notao.setId_Aluno(Id_Aluno);
                    notao.setId_Professor(Login.Id_ProfessorLogin);
                    notao.setId_Bimestre(ListarAvaliações.Id_BimestreNotas);
                    notao.setId_Turma(ListarAvaliações.Id_TurmaNotas);
                    double nota = 0;
                    for(Nota bri : nr.listarNotasBimestre(notao)){

                        Id_Avaliacao = bri.getId_Avaliacao();

                        nota = bri.getNota();

                        NumeroDeAvaliacoes = quantAvaliacao.size();

                        resultado = notaResult +=nota;

                        MediaFinal = resultado/NumeroDeAvaliacoes;

                    }
                    String resultado2 = String.format("%.2f", MediaFinal);

                    Jtabletabelaexcel2.setValueAt(resultado2, i, 2);

                } catch (Exception ex) {
                    Logger.getLogger(InserirMedia.class.getName()).log(Level.SEVERE, null, ex);
                }

                double teste = 0;

                //for(Nota nuta : arraynota ){
                    //    teste = nuta.getNota();
                    //       a.add(teste);
                    //       System.out.println(teste);
                    //}

            }

            // for(double Media : a){

                //}

            break;
            case "Média Livre":

            break;
            case "Média Ponderada":
            JanelaMedia jm = null;
            try {
                jm = new JanelaMedia();
                jm.setVisible(true);
                jm.setModal(true);
                jm = null;

            } catch (Exception ex) {
                Logger.getLogger(InserirMedia.class.getName()).log(Level.SEVERE, null, ex);
            }
            retornarMediaPonderada(pesos);

        }

    }//GEN-LAST:event_jComboBoxMediaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Jtabletabelaexcel2.isEditing()) {
            Jtabletabelaexcel2.getCellEditor().stopCellEditing();
        }

        try {
            if(SalvarMedia() == true){
                JOptionPane.showMessageDialog(null, "Salvo");
            }else{
                JOptionPane.showMessageDialog(null, "Erro");
            }     } catch (Exception ex) {
                Logger.getLogger(InserirMedia.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_jButton1ActionPerformed
 public boolean SalvarMedia() throws Exception, Exception{
     try {
       
                    int tam = Jtabletabelaexcel2.getRowCount();
      for(int i = 0;i<tam;i++){
           Media nota = new Media();
      nota.setId_Turma(Id_TurmaInserirNotas);
      nota.setId_Bimestre(Id_BimestreNotas);
      nota.setId_Professor(Login.Id_ProfessorLogin);
                NumberFormat df = NumberFormat.getCurrencyInstance(Locale.US);
		((DecimalFormat)df).applyPattern("0.00");
                double doub = Double.parseDouble(Jtabletabelaexcel2.getValueAt(i, 2).toString().replace(',', '.'));
             System.out.println(doub);
      nota.setMedia(doub);
      Aluno a = new Aluno();
      a.setId_Turma(Id_TurmaInserirNotas);
      a.setNome(Jtabletabelaexcel2.getValueAt(i,1).toString());
             
                            for( Aluno aluno : daoaluno.SelecionarId_Alunos(a)){
                                int id = aluno.getId_Aluno();
                                
                                nota.setId_Aluno(id);
                                
                            }     
                            daoMedia.Salvar(nota);
      }

       } catch (Exception ex) {
                            Logger.getLogger(InserirMedia.class.getName()).log(Level.SEVERE, null, ex);
                        }
      return true;
 }
    public void refrescar(ArrayList<String> j) throws Exception{
      
     
             String [] colunas = new String[]{"Numero_Chamada","Nome","Nota"};
          ArrayList dados = new  ArrayList();
//                filas[0]=rs.getString(1);
 
     
     
  
   
                  Chamada chame = new Chamada();
                  chame.setId_Turma(Id_TurmaInserirNotas);
                    for(int i = 0;i<Jtabletabelaexcel2.getRowCount();i++){
           
             for (Chamada ch : daochamada.listarChamadaId_Turma(chame)) {
                
                    
                     
                     
                     
                     
                     
                
                     
                    
                      dados.add(new Object[]{
                      ch.getNumero_Chamada(),ch.getNome(),j.get(i)
                      });
             }
                    }
             
                 
     
                     
      
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
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
               Jtabletabelaexcel2.getColumnModel().getColumn(0).setPreferredWidth(50);
       Jtabletabelaexcel2.getColumnModel().getColumn(0).setResizable(false);
              Jtabletabelaexcel2.getColumnModel().getColumn(1).setPreferredWidth(180);
       Jtabletabelaexcel2.getColumnModel().getColumn(1).setResizable(false);
              Jtabletabelaexcel2.getColumnModel().getColumn(2).setPreferredWidth(50);
       Jtabletabelaexcel2.getColumnModel().getColumn(2).setResizable(false);
   
    
             
    }
    
    
    
    public void retornarMediaPonderada(ArrayList<Double> j){
     System.out.println(j);
     for(double titulo : j){
          teste.add(titulo);
     }
    System.out.println(teste);
      
      double resultadoSomaTodosPesos =0;
      
         double MediaFinal = 0;
        int Id_Avaliacao = 0;
           int NumeroDeAvaliacoes = 0;
        ArrayList<Double> a = new ArrayList<Double>();
        ArrayList<String> b = new ArrayList<String>();
        
        Aluno alun = new Aluno();
         ArrayList<Integer> IdsAvaliacao = new ArrayList<Integer>();
         AvaliacaoREST ar = new AvaliacaoREST();
          String nome = "";
         
        ArrayList<Nota> arraynota = new ArrayList<Nota>();
          AlunoREST alunor = new AlunoREST();
         Avaliacao avaliar = new Avaliacao();
        Avaliacao avaliacao = new Avaliacao(); 
      
      String vaisefu = "";
      
     
               int conte = Jtabletabelaexcel2.getRowCount();
               for(int i = 0;i<conte;i++){
                   double   somadospeso= 0;
                   double resultado = 0;
                     vaisefu = Jtabletabelaexcel2.getValueAt(i, 1).toString();
           
            
             alun.setNome(vaisefu);
             alun.setId_Turma(ListarAvaliações.Id_TurmaNotas);
         try {
             int Id_Aluno = 0;
            for(Aluno al : alunor.SelecionarId_Alunos(alun)){
              Id_Aluno =  al.getId_Aluno();
            }
            NotaREST nr = new NotaREST();
            Nota notao = new Nota();
            notao.setId_Aluno(Id_Aluno);
            notao.setId_Professor(Login.Id_ProfessorLogin);
            notao.setId_Bimestre(ListarAvaliações.Id_BimestreNotas);
            notao.setId_Turma(ListarAvaliações.Id_TurmaNotas);
             double nota = 0;
              int contando = 0;
            for(Nota bri : nr.listarNotasBimestre(notao)){
              double test = 0;
               Id_Avaliacao = bri.getId_Avaliacao();
               
               nota = bri.getNota();
            
            NumeroDeAvaliacoes = quantAvaliacao.size();
      
        test = resultado = resultado + (nota * teste.get(contando));
                 
              resultadoSomaTodosPesos = somadospeso += teste.get(contando);
             MediaFinal = test/somadospeso;
                
            contando ++;
             
           
          
            }
             System.out.println("A soma dos peso é " + somadospeso);
                  System.out.println("A multiplicação nota e peso ´é " + resultado);
            String resultado2 = String.format("%.2f", MediaFinal);
           
           Jtabletabelaexcel2.setValueAt(resultado2, i, 2);

         } catch (Exception ex) {
             Logger.getLogger(InserirMedia.class.getName()).log(Level.SEVERE, null, ex);
         }
               }
        double teste = 0;
   
}
   ArrayList<Double> teste = new ArrayList<Double>();
        

    

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
            java.util.logging.Logger.getLogger(InserirMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new InserirMedia().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(InserirMedia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtabletabelaexcel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxMedia;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
