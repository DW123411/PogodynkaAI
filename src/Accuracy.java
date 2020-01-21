
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.*;
/*
 dokladnosc : 
ze zbioru wczytanych danych , porownac z decyzjami w drzewie i obliczyc dokladnosc . [ w procentach]
 */

/**
 *
 * @author 
 * 
 *  ^^^^^^^^^  ^^   ^^  ^^^^^^^
 *  ^^^^       ^^  ^^   ^^  ^^^
 *  ^^^^^^^^^  ^^^^     ^^^^^^^
 *       ^^^^  ^^  ^^       ^^^
 *  ^^^^^^^^^  ^^   ^^  ^^^^^^^
 */
 public class Accuracy extends JFrame  implements ActionListener{

        private JLabel label1;    private JLabel label2;    private JButton buton;
        private boolean DEBUG = false;
         private    Wezel<ElementDrzewa> temp_prepared_tree;
          private   DaneWejsciowe data_classified ;
          private   ElementDrzewa[][] data_load ;
         private    float accuracy;private double dbl_accuracy;
             private Okno host ; 
        @Override
        public void actionPerformed(ActionEvent e){
            Object zrodlo = e.getSource();

            if(zrodlo == buton){
                host.set_accuracy_open(false);
                dispose();
                
            }
        }

        
        private void dopasujSieDoZawartosci()
        {
            //dostosowanie okna do zawartości
            pack();   
            //wyśrodkowanie ramki
            setLocationRelativeTo(null);           
        }
        public Accuracy(){}
        /*
        konstr. z danymi ze sprawdzenia zbiorow uczacych i testujacych 
        */
        public Accuracy(int TestMax, int TestSucces, int TeachMax, int TeachSucces, Okno parent){
             
            buton = new JButton("OK");
            label1 = new JLabel("Dokładność ucząca : ");
            label2 = new JLabel("Dokładność testująca : ");
            setSize( 250, 250);  // ustawienie rozmiarow okna
            setLocation(500,500);
            // Pozyskanie powierzchni zawartości
            Container  contents = getContentPane();     
            // Utworzenie własnego panela z powierzchnią do rysowania figur
            // i dodanie go do powierzchni (zawartości) okna
            //setLayout(new GridLayout( 10, 50));
            setLayout( null );
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            label1.setSize(200,25);  label1.setLocation(10,50);

            label2.setSize(200,25);  label2.setLocation(10,75);

            buton.setSize(100,25);  buton.setLocation(50,100);
            add(label1);
             add(label2);
            buton.addActionListener(this);
            this.host = parent;
            add(buton);
        //dopasujSieDoZawartosci();
            setVisible(true);
            double ProcentTest = ObliczAccuracyMain(TestMax, TestSucces);
            double ProcentTeach = ObliczAccuracyMain(TeachMax, TeachSucces);
            
            setDoklUcz(ProcentTeach); setDoklTest(ProcentTest);
           
        }
        public Accuracy(  ElementDrzewa[][] dane_tree, ElementDrzewa[][] dane_uczace , ElementDrzewa[][] dane_test , Wezel root){
           // super();
//           double procent_ucz = calculate_accuracy(dane_tree, dane_uczace,2);
//            double procent_test = calculate_accuracy(dane_tree, dane_test,1);
          
           double procent_ucz = calculate_accuracy_from_tree(root, dane_uczace);
            double procent_test = calculate_accuracy_from_tree(root, dane_test);
            
            
            buton = new JButton("OK");
            label1 = new JLabel("Dokładność ucząca : ");
            label2 = new JLabel("Dokładność testująca : ");
            setSize( 250, 250);  // ustawienie rozmiarow okna
            setLocation(500,500);
            // Pozyskanie powierzchni zawartości
            Container  contents = getContentPane();     
            // Utworzenie własnego panela z powierzchnią do rysowania figur
            // i dodanie go do powierzchni (zawartości) okna
            //setLayout(new GridLayout( 10, 50));
            setLayout( null );
            label1.setSize(200,25);  label1.setLocation(10,50);

            label2.setSize(200,25);  label2.setLocation(10,75);

            buton.setSize(100,25);  buton.setLocation(50,100);
            add(label1);
             add(label2);
            buton.addActionListener(this);

            add(buton);
        //dopasujSieDoZawartosci();
            setVisible(true);
            
            setDoklUcz(procent_ucz); setDoklTest(procent_test);
           
        }

        public double ObliczAccuracyMain(int Max, int Succes){
            
            double MAXIMIMALIZIUM = (double)Max;
                    double PERCENT_OF_QUANTIUDOMINATION = (double) ((100*Succes));
                    PERCENT_OF_QUANTIUDOMINATION=PERCENT_OF_QUANTIUDOMINATION/MAXIMIMALIZIUM;
                    PERCENT_OF_QUANTIUDOMINATION=(double)Math.round(PERCENT_OF_QUANTIUDOMINATION);
                    
            return PERCENT_OF_QUANTIUDOMINATION;
        }
        /**
         * metoda ustawia napis labela z atrybutem wejsciowym 
         * 1 dla pierwszego(uczaca dokladnosc) 
         * 2 dla drugiego (tesutjaca dokladnosc) 
         */
        public void setlabel(int l, String a){

            if(l==1){
                //dokladnosc uczaca
                this.label1= new JLabel(a);
            }
            if(l==2){
                //dokladnosc testujaca 
                this.label2= new JLabel(a);
            }

        }
           public void setDoklUcz(double a){
            this.label1.setText("Dokładnośc ucząca : "+a+"%");
            
        }
          public void setDoklTest(double a){
            this.label2.setText("Dokładnośc testująca : "+a+"%");
            
        }
        public  void popup(){
            int a = 0; 
            while(a!=100){
                
             
                a++;
            }
            
            
        }
        
        public void sprawdz_dane_testujace(){
            if(this.data_classified.getZbiorTestowy()!=null){
                
                
            }
            else {
                
                  JOptionPane.showMessageDialog(null, "Nie ma danych testujących.");
            }
            
        }
         public void sprawdz_dane_uczace(){
            if(this.data_classified.getZbiorUczacy()!=null){
                
                
            }
            else {
                
                  JOptionPane.showMessageDialog(null, "Nie ma danych uczących.");
            }
            
        }
         
      
         /**
          * ogolnie to powinna tablica drzewa byc wieksza wydaje mis ie 
          */
            public double calculate_accuracy(ElementDrzewa[][] dane_tree, ElementDrzewa[][]  dane_uczace, int YETI){

                
                ArrayList<String> temp_stringi = new ArrayList();
                double match =0;
                double FinalMatcher =0;
                switch(YETI){case 1 : { for(int ILLECULAR=0; ILLECULAR< dane_uczace.length;ILLECULAR++){
                 for(int IMUCALURAR=0;IMUCALURAR< dane_uczace[ILLECULAR].length-1;IMUCALURAR++ ){ 
                    temp_stringi.add(dane_uczace[ILLECULAR][IMUCALURAR].getNazwa());
                }            
                 for(int INTERCELKULAR=0; INTERCELKULAR< dane_tree.length;INTERCELKULAR++){
                    for(int EXETUCULMIN=0; EXETUCULMIN < dane_tree[INTERCELKULAR].length;EXETUCULMIN++){
                if(temp_stringi.get(EXETUCULMIN).equals(dane_tree[INTERCELKULAR][EXETUCULMIN].getNazwa())){
                    match++;}
                    }
                  if(match== dane_tree[INTERCELKULAR].length-1){FinalMatcher++;}   }  match=0;temp_stringi = new ArrayList();}
                    
                    double MAXIMIMALIZIUM = (double)dane_tree.length;
                    double PERCENT_OF_QUANTIUDOMINATION = (double) ((100*FinalMatcher));
                    PERCENT_OF_QUANTIUDOMINATION=PERCENT_OF_QUANTIUDOMINATION/MAXIMIMALIZIUM;
                    PERCENT_OF_QUANTIUDOMINATION=(double)Math.round(PERCENT_OF_QUANTIUDOMINATION);
                    return PERCENT_OF_QUANTIUDOMINATION; }
                
                case 2: { for(int ILLECULAR=0; ILLECULAR< dane_uczace.length;ILLECULAR++){
                 for(int IMUCALURAR=0;IMUCALURAR< dane_uczace[ILLECULAR].length;IMUCALURAR++ ){ 
                    temp_stringi.add(dane_uczace[ILLECULAR][IMUCALURAR].getNazwa());
                }            
                if(DEBUG)
                    System.out.println(temp_stringi.size());
                 for(int Etgr=0;Etgr<temp_stringi.size();Etgr++){
                if(DEBUG)
                     System.out.print(temp_stringi.get(Etgr));
                 
                 }
                 for(int INTERCELKULAR=0; INTERCELKULAR< dane_tree.length;INTERCELKULAR++){
                    for(int EXETUCULMIN=0; EXETUCULMIN < dane_tree[INTERCELKULAR].length;EXETUCULMIN++){
                if(temp_stringi.get(EXETUCULMIN).equals(dane_tree[INTERCELKULAR][EXETUCULMIN].getNazwa())){
                    match++;}
                    }
                  if(match== dane_tree[INTERCELKULAR].length-1){FinalMatcher++;}     match=0;}temp_stringi = new ArrayList();}
                    
                    double MAXIMIMALIZIUM = (double)dane_tree.length;
                    double PERCENT_OF_QUANTIUDOMINATION = (double) ((100*FinalMatcher));
                    PERCENT_OF_QUANTIUDOMINATION=PERCENT_OF_QUANTIUDOMINATION/MAXIMIMALIZIUM;
                    PERCENT_OF_QUANTIUDOMINATION=(double)Math.round(PERCENT_OF_QUANTIUDOMINATION);
                    return PERCENT_OF_QUANTIUDOMINATION; }
               default: {return 0;}
}       
 }
            
            public double calculate_accuracy_from_tree(Wezel root, ElementDrzewa[][] dane){
                int MAXIM= 0; 
                
           
                
                
             
            
              return 0;
           
 }
            
            public void dalejdrzewo(Wezel root){
                
                
             while (!root.czyLisc()) {
            LinkedList<Wezel> lista = new LinkedList<Wezel>();
            for (int i = 0; i < root.getDzieci().size(); i++) {
                lista.add((Wezel) root.getDzieci().get(i));
            } //list przechowująca dzieci
            while (!lista.isEmpty()) {
                Wezel<ElementDrzewa> w = lista.remove(0);
                if(DEBUG)
                System.out.println("nazwa"+w.getDane().getNazwa());
                if(DEBUG) 
                System.out.println("klasa"+w.getDane().getClass());
                 
              
                 
            }
            
          
            
            
        }
                
            }
            
            
            
 }                  //end class





//                
//                
//                
//                g3.drawString(w.toString(), (w.getX() - (3 * w.toString().length())), w.getY());
//                button = new PrzyciskDrzewo(w.toString());
//                if (w.getDane().getClass().getName() == "Atrybut") {
//                    usun_MenuItem.setElement((ElementDrzewa) w.getDane());
//                    zmien_nazweMenuItem.setElement((ElementDrzewa) w.getDane());
//                   
//
//
//                } else if (w.getDane().getClass().getName() == "WartoscAtrybutu") {
//                    button = new PrzyciskDrzewo(w.toString());
//                    button.setToolTipText(button.getText());
//                    ToolTipManager.sharedInstance().registerComponent(button);
//                    popupMenu = new JPopupMenu("Title");
//                    usun_MenuItem.setElement((ElementDrzewa) w.getDane());
//                    zmien_nazweMenuItem.setElement((ElementDrzewa) w.getDane());
//                    popupMenu.add(zmien_nazweMenuItem);
//                    popupMenu.addSeparator();
//                    popupMenu.add(usun_MenuItem);
//                    button.setComponentPopupMenu(popupMenu);
//                    button.setBackground(Color.green);
//
//                } else {
//                    popupMenu = new JPopupMenu("Title");
//                    dajDroge.setWezel((Wezel)w);
//                    popupMenu.add(dajDroge);
//                    button.setComponentPopupMenu(popupMenu);
//                    button.setBackground(Color.cyan);
//                    button.setWezel(w);
//                }
             
            
            
            