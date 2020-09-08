
package mercado;


import Modelo.Bean.TurmaProfessor;
import Modelo.Bean.Turmacerta;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

 
public class ModeloTabela extends AbstractTableModel{
    
     private ArrayList linhas= null;
     private String [] colunas = null;
 
 public ModeloTabela (ArrayList lin, String[] col){
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

    
           

            @Override
            public boolean isCellEditable(int row, int column)
            {
                if (column == 0){
                    
                    return true;  
                }else if(column == 1) {
                     return true; 
                }
                    return true;
       
               
            }
           public void setValueAt(Object value, int row, int col) {
       Object[] linha = (Object[]) linhas.get(row);
	linha[col] = value;
	fireTableDataChanged();
          Turmacerta t = new Turmacerta();
      
        
   }
       
          
      
    
   
         public void addLinha(){ 
    this.linhas.add(new Object[]{});
    this.fireTableDataChanged();
}
         public void limpaTabela() {
		linhas.clear();
 		      	fireTableDataChanged();
	}
        };



