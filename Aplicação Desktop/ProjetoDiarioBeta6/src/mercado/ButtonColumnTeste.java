/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class ButtonColumnTeste extends AbstractCellEditor  
     implements TableCellRenderer, TableCellEditor, MouseListener, ActionListener{  
     JTable table;  
     JButton renderButton;  
     JButton editButton;  
     String text; 
 public ButtonColumnTeste(JTable table, int column)
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
             renderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("NaoSeleciondo.png")));
        
         }
         else if (isSelected)  
         {
             renderButton.setForeground(table.getSelectionForeground());  
              renderButton.setBackground(table.getSelectionBackground());  
               renderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("NaoSeleciondo.png")));
         }
         else  
         {
             renderButton.setForeground(table.getForeground());  
             renderButton.setBackground(UIManager.getColor("Button.background")); 
             renderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("NaoSeleciondo.png")));
         }
   
         renderButton.setText( (value == null) ? "" : value.toString() );
  renderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("ok.png")));
      
         // renderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("ok.png")));
       
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
 public void actionPerformed(ActionEvent event)  
     {
           JButton button = (JButton)event.getSource();
         
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
        
     int coluna = table.getSelectedColumn();
     int linha = table.getSelectedRow();
         System.out.println(linha + "  ,   coluna = " + coluna);
        String vaisefuder = "";
         if(table.getSelectedRow()==linha){
             vaisefuder = table.getValueAt(linha, 1).toString();
         }
       
          JOptionPane.showMessageDialog(null, linha + "  ,   coluna = " + coluna + "vai" + vaisefuder);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }

   
   
     
    
    
}
