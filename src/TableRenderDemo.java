/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

/*
 * TableRenderDemo.java requires no other files.
 */

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.util.*;
/** 
 * TableRenderDemo is just like TableDemo, except that it
 * explicitly initializes column sizes and it uses a combo box
 * as an editor for the Sport column.
 */
public class TableRenderDemo extends JPanel {
    private boolean DEBUG = false;
    String[] dane_wejsciowe_kolumny ; Object[][] dane_wejsciowe_dane;
    String[][] pelna_tabelka_klasyfikacji;
    private DaneWejsciowe klasyfikacja;
    private JButton sprawdz_decyzje, a,b,c,d;
    public TableRenderDemo( DaneWejsciowe k) {
        super(new GridLayout(0,1));
        // klasyfikacja=Wczytywanie.wczytajKlasyfikacjeZPliku("src/test_klasyfikacji.txt");
        this.klasyfikacja= k;
        this.dane_wejsciowe_kolumny = new String[klasyfikacja.ile_atrybutow()+1];
        for(int i=0;i<klasyfikacja.ile_atrybutow();i++){
            dane_wejsciowe_kolumny[i]=klasyfikacja.get_klasyfikacja_atrybuty()[i].getNazwa();
        }
        dane_wejsciowe_kolumny[klasyfikacja.ile_atrybutow()]="Decision";
        this.dane_wejsciowe_dane = klasyfikacja.get_klasyfikacja_wart_dec();
             Object[][]        dane = dane_wejsciowe_dane;
        String[] kolumny = dane_wejsciowe_kolumny;
        this.pelna_tabelka_klasyfikacji = klasyfikacja.get_klasyfikacja_string();
        //   Object[][]        dane = dane_wejsciowe_dane;
        //             Object[][]        dane = new Object[klasyfikacja.ile_atrybutow()+1][1];
        //          for(int i=0;i<dane_wejsciowe_dane.length;i++)
        //          {
        //              dane[0][i]=dane_wejsciowe_dane[i][0];
        //             
        //             }
   

        //  Object[][]        dane = {{dane_wejsciowe_dane[0][1]},{dane_wejsciowe_dane[0][1]},
        //      {dane_wejsciowe_dane[0][2]},{dane_wejsciowe_dane[0][3]},{dane_wejsciowe_dane[0][4]}
        //     };
        Object[] typy = {"Jane", "Kathy",
                "None of the above",
                "w/e", "w/e"};

        if(DEBUG){
            System.out.println();
            System.out.println();
        
            System.out.println("print in consol tabelki");
            this.klasyfikacja.print_in_console();
            System.out.println("print_in_console_ATR (wartosci_atr_i_decyzja table)");
            this.klasyfikacja.print_in_console_ATR();
            System.out.println();
//            System.out.println("print_in_console_atrybuty (this.atrybuty) ");
//            this.klasyfikacja.print_in_console_atrybuty();
//            System.out.println();
//            System.out.println("print_in_console_clasy (this.dane classy) i>j ");
//            this.klasyfikacja.print_in_console_classes();
//            System.out.println();
//            System.out.println("print_in_console_dane stringi (this.dane.getnazwa()) i > j ");
//            this.klasyfikacja.print_in_console_dane_stringi();
//            System.out.println();
//            System.out.println("print_in_console_dane stringi20  (this.wartosci_atr_i_decyzja  i>j) ");
//            this.klasyfikacja.print_in_console_dane_stringi_20();
//            System.out.println();
//            System.out.println("print_in_console_dane stringi odwr  (this.dane.getNazwa()  )  j> i ");
//            this.klasyfikacja.print_in_console_dane_stringi_odwrotnie();
//            System.out.println();
         //   System.out.println("print_in_console_dane stringi_odw20  wartosci_atr_i_decyzja   j>i ");
       //     this.klasyfikacja.print_in_console_dane_stringi_odwrotnie_20();
            System.out.println();

                System.out.println("tworzenie konstuktora tabelki");
        }
        JTable table = new JTable(new MyTableModel(kolumny, dane , typy, klasyfikacja));
        table.setPreferredScrollableViewportSize(new Dimension(600, 110));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Set up column sizes.
        initColumnSizes(table);

        //Fiddle with the Sport column's cell editors/renderers.
        int ilk = 0 ; 
        while(ilk!=klasyfikacja.ile_atrybutow()){
        setUpSportColumn(table, ilk);
ilk++;
    }
        //   setUpSportColumn(table, 4);  decyzja

        // setUpSportColumn(table, table.getColumnModel().getColumn(1));
        // setUpSportColumn(table, table.getColumnModel().getColumn(2));
        // setUpSportColumn(table, table.getColumnModel().getColumn(3));
        //Add the scroll pane to this panel.
        add(scrollPane);

    }

    /*
     * This method picks good column sizes.
     * If all column heads are wider than the column's cells'
     * contents, then you can just use column.sizeWidthToFit().
     */
    private void initColumnSizes(JTable table) {
        MyTableModel model = (MyTableModel)table.getModel();
        TableColumn column = null;
        Component comp = null;
        int headerWidth = 0;
        int cellWidth = 0;
        Object[] longValues = model.longValues;
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

            if (DEBUG) {
                System.out.println("Initializing width of column "
                    + i + ". "
                    + "headerWidth = " + headerWidth
                    + "; cellWidth = " + cellWidth);
            }

            column.setPreferredWidth(Math.max(headerWidth, cellWidth));
        }
    }

    // setUpSportColumn(table, table.getColumnModel().getColumn(2));
    public void setUpSportColumn(JTable table, int numerkolumny)
    // TableColumn sportColumn) 
    {
        //Set up the editor for the sport cells.

        //         for(int i=0;i<dane_wejsciowe_dane.length;i++){
        //         for(int j=0;j<dane_wejsciowe_dane[i].length;j++){
        //         
        //         
        //         }
        //         
        //         }

        JComboBox comboBox = new JComboBox();
        for(int i=0;i<dane_wejsciowe_dane[numerkolumny].length;i++){
            comboBox.addItem(dane_wejsciowe_dane[i][numerkolumny]);
            // System.out.println(dane_wejsciowe_dane[i][numerkolumny]);
        }

        TableColumn  sportColumn =  table.getColumnModel().getColumn(numerkolumny);
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer =
            new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        sportColumn.setCellRenderer(renderer);
    }

    class MyTableModel extends AbstractTableModel {
        private String[] columnNames ;
        //         = {"First Name",
        //                                         "Last Name",
        //                                         "Sport",
        //                                         "# of Years",
        //                                         "Vegetarian"}
        ;
        private Object[][] data ;
        private DaneWejsciowe klasyfikacja;
        private String[][]                pelna_tabelka_klasyfikacji;
        //         = 
        //         {
        //         {"Kathy", "Smith",
        //          "Snowboarding", new Integer(5), new Boolean(false)},
        //         {"John", "Doe",
        //          "Rowing", new Integer(3), new Boolean(true)},
        //         {"Sue", "Black",
        //          "Knitting", new Integer(2), new Boolean(false)},
        //         {"Jane", "White",
        //          "Speed reading", new Integer(20), new Boolean(true)},
        //         {"Joe", "Brown",
        //          "Pool", new Integer(10), new Boolean(false)}
        //         }
        ;

        public  Object[] longValues = {"Jane", "Kathy",
                "None of the above",
                new Integer(20), Boolean.TRUE};
        int numer_kolumny_decyzji;
        
        int row_temp ;
        int col_temp; 

        public MyTableModel(String[] kolumny, Object[][] dane, Object[] typydanych, DaneWejsciowe dane_wejsciowe){
             if(DEBUG){
                        System.out.println("\n wejscie konstruktora myTableModel ");
                    }
            
            this.columnNames = kolumny;
            this.data = dane;
            this.longValues = typydanych;
            this.klasyfikacja = dane_wejsciowe;
            this.pelna_tabelka_klasyfikacji=dane_wejsciowe.get_klasyfikacja_string();
            
            row_temp = 0; 
                        col_temp = 0; 
            String decision = "Decision";
            for(int i=0;i<kolumny.length;i++){
                if(decision.equals(kolumny[i])){
                    if(DEBUG){
                        System.out.println("\n sprawdzene kolumny w ktorej jest decyzja"+decision.equals(kolumny[i]));
                    }
                    
                    this.numer_kolumny_decyzji=i;}
            }
        }

        public int getColumnCount() {
         
            return columnNames.length;
        }

        public int getRowCount() {
            // return data.length;
//            return 1;
return 1;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            if(DEBUG){

                System.out.println("MyTableRender -> public Object getvalueAt(int row, int col) where col="+col+"row"+row+" "+data[row][col]);}

            return data[row][col];

        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            //             if (col < 2) {
            //                 return false;
            //             } else {
            //                 return true;
            //             }
            String decision = "Decision";
            if(decision.equals(getColumnName(col))){return false;}

            return true;
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                if(value!=null){
                    System.out.println("Setting value at " + row + "," + col
                        + " to " + value
                        + " (an instance of "
                        + value.getClass() + ")");
                }
            else{
                System.out.println("Setting value at " + row + "," + col
                    + " to " + value
                    + " (an instance of "
                    + "null)");
            }
            }
            //                     if(value!=null){
            //             data[row][col] = value;
            //             fireTableCellUpdated(row, col);
            //         }
            //         else {
            //             JOptionPane.showMessageDialog(null, "Nie wczytałeś pliku.");
            //             
            //         }
            if(value!=null){
            data[row][col] = value;
        }
             fireTableCellUpdated(row, col);
                 updateDecision(row, col);
//             if(row_temp!=null&&col_temp!=null){
//                
//             }
            
            

           
            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void updateDecision(int row, int col){
            boolean decyzja=false;
            ArrayList<String> jakie_decyzje = new ArrayList();
            ArrayList<String> jakie_w_kolumnie = new ArrayList();
            // odczytanie decyzji
            for(int i=0;i<getColumnCount()-1;i++)
            {
                jakie_decyzje.add(getValueAt(0,i).toString());

            }
            if(DEBUG){
                System.out.print("Wybrane decyzje : ");
                for (int k=0;k<jakie_decyzje.size();k++){
                    System.out.print(jakie_decyzje.get(k)+" ");              
                }

            }
            boolean czy_decyzja=false;
            if(DEBUG){
                System.out.println( "\n przed sprawdzeniem pelna_tabelka_klasyfikacji[0].length  =  "+pelna_tabelka_klasyfikacji[0].length+" pelna_tabelka_klasyfikacji.length = "+pelna_tabelka_klasyfikacji.length+"\n");
            }

            // sprawdzenie
            jakie_w_kolumnie = new ArrayList();
            int nr_wiersz = 1;
            int nr_kol = getColumnCount()-1;
            for(int i=1;i<pelna_tabelka_klasyfikacji.length;i++){
                if(DEBUG){
                    System.out.println( "    +++ ROW updateDecision-SPRAWDZANIE ");
                }
                for(int j=0;j<=pelna_tabelka_klasyfikacji[i].length-1;j++){
                    if(DEBUG){
                        if(pelna_tabelka_klasyfikacji[i][j]!=null){
                            System.out.print(pelna_tabelka_klasyfikacji[i][j].toString()+" ");}
                        else{
                            System.out.print(" []");
                        }
                    }
                    jakie_w_kolumnie.add(pelna_tabelka_klasyfikacji[i][j].toString());
                    //             

                }
                 int TRUEKE = 0 ;
                if(DEBUG){
                    System.out.println("\n #####SPRAWDZANIE ");
                }
                for(int h=0;h<jakie_w_kolumnie.size();h++)
                {
                     if(DEBUG){
                  
                    System.out.print(jakie_w_kolumnie.get(h).toString()+" --");
//                    System.out.println("jakie_decyzje.get(0) :#"+jakie_decyzje.get(0)+ ";       jakie_w_kolumnie.get(0).toString(): #"+jakie_w_kolumnie.get(0).toString()
//                         +"      equals: #"+jakie_decyzje.get(0).equals(jakie_w_kolumnie.get(0).toString()));
//                         System.out.println("jakie_decyzje.get(1) :#"+jakie_decyzje.get(1)+ ";       jakie_w_kolumnie.get(1).toString(): #"+jakie_w_kolumnie.get(1).toString()
//                          +"      equals: #"+jakie_decyzje.get(1).equals(jakie_w_kolumnie.get(1).toString()));
//                         System.out.println("jakie_decyzje.get(2) :#"+jakie_decyzje.get(2)+ ";       jakie_w_kolumnie.get(2).toString(): #"+jakie_w_kolumnie.get(2).toString()
//                          +"      equals: #"+jakie_decyzje.get(2).equals(jakie_w_kolumnie.get(2).toString()));
//                         System.out.println("jakie_decyzje.get(3) :#"+jakie_decyzje.get(3)+ ";       jakie_w_kolumnie.get(3).toString(): #"+jakie_w_kolumnie.get(3).toString()
//                          +"      equals: #"+jakie_decyzje.get(3).equals(jakie_w_kolumnie.get(3).toString()));
                     }
                   
                   
                    
                    }
                
                 for(int yk = 0 ; yk <jakie_decyzje.size(); yk++ ){
                        if(jakie_decyzje.get(yk).toString().equals(jakie_w_kolumnie.get(yk).toString()))
                            TRUEKE++;
                        
                    }
                if(TRUEKE==jakie_decyzje.size()){
                        czy_decyzja=true;
                     nr_wiersz = i;
                    nr_kol= this.numer_kolumny_decyzji;
                }
                TRUEKE=0;
                jakie_w_kolumnie= new ArrayList();

                if(DEBUG){
                    System.out.println("\n koniec sprawdzania jakie_w_kolumnie \n" );
                }
            
             if(czy_decyzja){decyzja=true;
            data[0][nr_kol]=pelna_tabelka_klasyfikacji[i][nr_kol];
           
             fireTableCellUpdated(0,numer_kolumny_decyzji);
            break;
             }
             
            }
            
            if(!czy_decyzja){
                
                data[0][nr_kol]=new Decyzja("Brak danych");
                  fireTableCellUpdated(0,numer_kolumny_decyzji);
            }
            
            
            
            
           

            //             if(decyzja){    pelna_tabelka_klasyfikacji[row][numer_kolumny_decyzji] = new Decyzja("Yes");}
            //             else{ pelna_tabelka_klasyfikacji[row][numer_kolumny_decyzji] = new Decyzja("No");}
//            if(decyzja){  
//                String tak = "yes";
//                data[0][numer_kolumny_decyzji] = tak;}
//            else{ 
//                String nie = "no";
//                data[0][numer_kolumny_decyzji] = nie;}
//            fireTableCellUpdated(0,numer_kolumny_decyzji);
//            czy_decyzja=false;
//            decyzja=false;

        };

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI(DaneWejsciowe klasyfikacja) {
        //Create and set up the window.
        JFrame frame = new JFrame("Sprawdź decyzję");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // odczytanie danych do tablic dla konstruktora TableRenderDemo
//         String[] string_atrybuty = new String[klasyfikacja.ile_atrybutow()];
//         for(int i=0;i<klasyfikacja.ile_atrybutow();i++){
//             string_atrybuty[i]=klasyfikacja.get_klasyfikacja_atrybuty()[i].getNazwa();
//         }
//         Object[][] dane = klasyfikacja.get_klasyfikacja_wart_dec();
        //Create and set up the content pane.
        //        TableRenderDemo newContentPane = new TableRenderDemo(        );
          //  TableRenderDemo newContentPane = new TableRenderDemo(Wczytywanie.wczytajKlasyfikacjeZPliku("src/test_klasyfikacji.txt"));
        TableRenderDemo newContentPane = new TableRenderDemo(klasyfikacja);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI(Wczytywanie.wczytajKlasyfikacjeZPliku("src/test_klasyfikacji.txt"));
                }
            });
    }
}