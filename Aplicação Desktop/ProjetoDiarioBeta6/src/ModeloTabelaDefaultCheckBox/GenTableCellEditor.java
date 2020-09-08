/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTabelaDefaultCheckBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;

/**
 *
 * @author Automação
 */
public class GenTableCellEditor extends DefaultCellEditor implements ItemListener {
     protected static JCheckBox checkBox = new JCheckBox();
 
    public GenTableCellEditor() {
        super(checkBox);
        checkBox.setHorizontalAlignment(SwingConstants.CENTER);
        checkBox.setBackground(Color.white);
    }
 
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (value == null)
            return checkBox;
        checkBox.addItemListener(this);
        if (((Boolean) value).booleanValue())
            checkBox.setSelected(true);
        else
            checkBox.setSelected(false);
 
        return checkBox;
    }
 
    public Object getCellEditorValue() {
        if(checkBox.isSelected() == true)
            return new Boolean(true);
        else
            return new Boolean(false);
    }
 
    @Override
    public void addCellEditorListener(CellEditorListener l) {
        // TODO Auto-generated method stub
    }
 
    @Override
    public void cancelCellEditing() {
        // TODO Auto-generated method stub
 
    }
 
    @Override
    public boolean isCellEditable(EventObject anEvent) {
        // TODO Auto-generated method stub
        return true;
    }
 
    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        // TODO Auto-generated method stub
 
    }
 
    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        // TODO Auto-generated method stub
        return true;
    }
 
    @Override
    public boolean stopCellEditing() {
        // TODO Auto-generated method stub
        return true;
    }
 
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Firing!");
    }
}
