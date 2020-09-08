
package mercado;


import Modelo.Bean.TurmaProfessor;
import Modelo.Bean.Turmacerta;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

 
public final class ModeloTabelaBotãoTeste extends AbstractTableModel{
    
     private ArrayList linhas= null;
     private String [] colunas = null;
 
 public ModeloTabelaBotãoTeste (ArrayList lin, String[] col){
     setLinhas (lin);
     setColunas(col);
 }

  
    public ArrayList getLinhas(){
        return linhas;
    }
    public void setLinhas(ArrayList dados) {
         linhas = dados;
    }
    public String[] getColunas() {
        return colunas;
    }
    public void setColunas(String[] nomes) {
        colunas = nomes;
        }
    
      public int getColumnCount(){
            return colunas.length;
    }
        public int getRowCount(){
            return linhas.size();
}
        public String getColumnName(int numCol){
           return colunas [numCol];
        }
        
        public Object getValueAt(int numLin, int numCol){
            Object[] linha = (Object[])getLinhas().get(numLin);
            return linha [numCol];
     
     }

     
         private static final long serialVersionUID = 1L;
        
            @Override
            public Class getColumnClass(int column) {
                  Class type = String.class;
                switch (column) {
                    case 2://como só tem uma coluna eu deixei default
                         getValueAt(2, column).getClass();
                          type = new JButton().getClass();
                    break;
                  
                      
                }
     return type;
            }
           

            @Override
            public boolean isCellEditable(int row, int column)
            {
                if (column == 0){
                    
                    return false;  
                }else if(column == 1) {
                     return false; 
                }else if(column == 2){
                      return true;
                }
         return false;
                  
       
               
            }
          
          
         public void setValueAt(Object value, int row, int col) {
       Object[] linha = (Object[]) linhas.get(row);
	linha[col] = value;
	fireTableDataChanged();
         
       
   }
        };



