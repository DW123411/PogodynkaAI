import javax.swing.*;

public class Tabela {
    private JTable tabela;

    public Tabela(){
        tabela = null;
    }

    public Tabela(Object[][] dane){
        Object[][] rowData = new Object[dane.length-1][dane[0].length];
        for(int i=0;i<dane.length;i++){
            for(int j=0;j<dane[0].length;j++){
                if(i!=0){
                    rowData[i-1][j] = dane[i][j];
                }
            }
        }
        Object[] columnNames = new Object[dane[0].length];
        for(int i=0;i<dane[0].length;i++){
            columnNames[i] = dane[0][i];
        }
        tabela = new JTable(rowData,columnNames);
    }

    public JTable getTabela(){
        return tabela;
    }
}
