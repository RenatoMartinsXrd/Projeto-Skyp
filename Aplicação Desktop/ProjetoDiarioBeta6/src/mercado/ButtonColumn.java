/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado;


import Interfaces.Professor.ListarAvaliações;
import Interfaces.Professor.Login;
import Modelo.Bean.Rest.Aluno;
import Modelo.Bean.Rest.Avaliacao;
import Modelo.Bean.Rest.Nota;
import Modelo.Dao.Rest.AlunoREST;
import Modelo.Dao.Rest.AvaliacaoREST;
import Modelo.Dao.Rest.NotaREST;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Scarlxrd2112
 */
public class ButtonColumn extends AbstractCellEditor 
     implements TableCellRenderer, TableCellEditor, MouseListener{  
     JTable table;  
     JButton renderButton;  
     JButton editButton;  
     String text; 
     JFrame frame;
 public ButtonColumn(JTable table, int column)
     {
         super();
         this.table = table;
         renderButton = new JButton();
   
         editButton = new JButton();
         editButton.setFocusPainted( false );
         editButton.addMouseListener(this);
        // editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deskclin/resources/sair_menu.png")));
         editButton.setBackground(Color.green);
         TableColumnModel columnModel = table.getColumnModel();
         columnModel.getColumn(column).setCellRenderer( this );
         columnModel.getColumn(column).setCellEditor( this );
     }
   
     public Component getTableCellRendererComponent(
         JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
     {
         if (hasFocus)
         {
             renderButton.setForeground(table.getForeground());  
             renderButton.setBackground(UIManager.getColor("Button.background"));  
         }
         else if (isSelected)  
         {
             renderButton.setForeground(table.getSelectionForeground());  
              renderButton.setBackground(table.getSelectionBackground());  
         }
         else  
         {
             renderButton.setForeground(table.getForeground());  
             renderButton.setBackground(UIManager.getColor("Button.background"));  
         }
   
         renderButton.setText( (value == null) ? "" : value.toString() );
         return renderButton;
     }  
 
    @Override
     public Component getTableCellEditorComponent(
         JTable table, Object value, boolean isSelected, int row, int column)
     {
         text = (value == null) ? "" : value.toString();
         editButton.setText( text );
         return editButton;
     }

    @Override
     public Object getCellEditorValue()
     {
         return text;
     }
 

   

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int Id_Avaliacao = 0;
        double nota = 0;
         ArrayList<Integer> IdsAvaliacao = new ArrayList<Integer>();
         AvaliacaoREST ar = new AvaliacaoREST();
          String nome = "";
         
        ArrayList<Nota> arraynota = new ArrayList<Nota>();
         Avaliacao avaliar = new Avaliacao();
        Avaliacao avaliacao = new Avaliacao();
     int coluna = table.getSelectedColumn();
     int linha = table.getSelectedRow();
         System.out.println(linha + "  ,   coluna = " + coluna);
        String vaisefu = "";
         if(table.getSelectedRow()==linha){
             vaisefu = table.getValueAt(linha, 1).toString();
             AlunoREST alunor = new AlunoREST();
             Aluno alun = new Aluno();
             alun.setNome(vaisefu);
             alun.setId_Turma(ListarAvaliações.Id_TurmaNotas);
         try {
             int Id_Aluno = 0;
            for(Aluno a : alunor.SelecionarId_Alunos(alun)){
              Id_Aluno =  a.getId_Aluno();
            }
            NotaREST nr = new NotaREST();
            Nota notao = new Nota();
            notao.setId_Aluno(Id_Aluno);
            notao.setId_Professor(Login.Id_ProfessorLogin);
            notao.setId_Bimestre(ListarAvaliações.Id_BimestreNotas);
            notao.setId_Turma(ListarAvaliações.Id_TurmaNotas);
           
            for(Nota bri : nr.listarNotasBimestre(notao)){
                
               Id_Avaliacao = bri.getId_Avaliacao();
               
             IdsAvaliacao.add(Id_Avaliacao);
                System.out.println(Id_Avaliacao);
               arraynota.add(bri);
               nota = bri.getNota();
                
               
            
            }
             
            
       
            
               
          
           
          
                 
         //for(int i = 0;i<arraynota.size();i++){
          
        // }
         } catch (Exception ex) {
             Logger.getLogger(ButtonColumn.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
        double teste = 0;
       
         for(Nota nuta : arraynota ){
             teste = nuta.getNota();
                a.add(teste);
         }
         
      
         for(int f = 0;f<IdsAvaliacao.size();f++){
             avaliacao.setId_Avaliacao(IdsAvaliacao.get(f));
            try {
                avaliar = ar.SelecionarComIdAvaliacao(avaliacao);
                  b.add(avaliar.getTitulo());
            } catch (Exception ex) {
                Logger.getLogger(ButtonColumn.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println(b.get(f));
         }
         JanelaLousa dialog = new JanelaLousa(a,b); 
         dialog.setVisible(true);
         dialog.setModal(true);
         dialog = null;
//Deixa
       //JOptionPane.showMessageDialog(null,arraynota.get(0).Nota);
    }
 public static ArrayList<Double> a = new ArrayList<Double>();
  public static ArrayList<String> b = new ArrayList<String>();
    @Override
    public void mouseEntered(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }

   
   
     
    
    
}
