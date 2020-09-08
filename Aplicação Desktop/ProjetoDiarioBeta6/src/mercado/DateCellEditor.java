/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import java.awt.Component;  
import java.text.SimpleDateFormat;
import java.util.Date;  
import javax.swing.AbstractCellEditor;  
import javax.swing.JTable;  
import javax.swing.table.TableCellEditor;  
  

/**
 *
 * @author Scarlxrd2112
 */

    public class DateCellEditor extends AbstractCellEditor implements  
        TableCellEditor {  
  
    private JDateChooser dateChooser = new JDateChooser();  
  
    public Component getTableCellEditorComponent(JTable table, Object value,  
            boolean isSelected, int row, int column) {  
  
        Date date = null;  
        if (value instanceof Date)  
            date = (Date) value;  
  
        dateChooser.setDate(date);  
  
        return dateChooser;  
    }  
  
    public Object getCellEditorValue() {  
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
        return formato.format(dateChooser.getDate());  
    }  
}  

