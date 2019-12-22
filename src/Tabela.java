import java.awt.Component;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class Tabela {
    private JTable tabela;
    private Object[][] data;
    private Object[] columns;
    private String[] columns_strings;
    public Tabela() {
        tabela = null;
    }

    public Tabela(Object[][] dane) {
        Object[][] rowData = new Object[dane.length - 1][dane[0].length+1];
        int helpterj = 0;
        for (int i = 0; i < dane.length; i++) {
            for (int j = 0; j < dane[0].length+1; j++) {
                if (i != 0) {
                    
                    if(j==0){
                            rowData[i-1][j]= new WartoscAtrybutu(String.valueOf(i));
                                 }
                    else {
                    rowData[i - 1][j] = dane[i][helpterj];   
                     helpterj++;      }
                }
            }
            helpterj =0 ;
        }
        Object[] columnNames = new Object[dane[0].length+1];
            columnNames[0]= new Atrybut("Nr");
        for (int i = 0; i < dane[0].length; i++) {
            columnNames[i+1] = dane[0][i];
        }
         tabela = new JTable(rowData, columnNames);
         TableMyModel TMM = new TableMyModel(rowData, columnNames);
        tabela.setModel(TMM);
        this.data = dane;
        this.columns = columnNames;
        this.columns_strings = TMM.getColumnsString();
         initColumnSizes(tabela);
          //  TableModel TM = tabela.getModel();
            
 
    }

    public JTable getTabela() {
        return tabela;
    }
    public Object[] getColumnsTable(){
        return columns;
        
    }
    
    private void initColumnSizes(JTable table) {
        TableMyModel model = (TableMyModel)tabela.getModel();
        TableColumn column = null;
        Component comp = null;
        int headerWidth = 0;
        int cellWidth = 0;
        String[] longValues = model.getColumnsString();
        TableCellRenderer headerRenderer =
            table.getTableHeader().getDefaultRenderer();

        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);

            comp = headerRenderer.getTableCellRendererComponent(
                null, column.getHeaderValue(),
                false, false, 0, 0);
            headerWidth = comp.getPreferredSize().width;

            comp = table.getDefaultRenderer(model.getColumnClass(i)).
            getTableCellRendererComponent(
                table, longValues[i],
                false, false, 0, i);
            cellWidth = comp.getPreferredSize().width;
            column.setPreferredWidth(Math.max(headerWidth, cellWidth));
        }
    }
    
    
   
private class TableMyModel extends  AbstractTableModel{
    
    private Object[][] rowdata;
    private String[] columns;
    public TableMyModel(Object[][] data, Object[] columnsnames){
       super();
        this.rowdata = data;
        columns = new String[columnsnames.length];
        for(int i=0; i< columnsnames.length;i++){
            columns[i]= columnsnames[i].toString();
            
        }
        
        
    }
    public String[] getColumnsString(){
        return columns;
    }
    
    
    @Override
    public boolean isCellEditable(int row, int column) {
       if(column==0){
       return false;
       }else{
           return true;}
       }
    
    
       @Override
        public int getRowCount() {
            return this.rowdata.length;
        }

        @Override
        public int getColumnCount() {
        return this.rowdata[0].length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
                    return this.rowdata[rowIndex][columnIndex];
        }

        @Override
        public String getColumnName(int columnIndex) {
                return this.columns[columnIndex];
        }
        
        @Override
        public void setValueAt(Object value, int row, int col) {
            if(col!=0){
            rowdata[row][col] = value;
            fireTableCellUpdated(row,col);
            }
        }
    
    
    
    
    
} 
    
}

