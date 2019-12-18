
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
        
         private    Wezel<ElementDrzewa> temp_prepared_tree;
          private   DaneWejsciowe data_classified ;
          private   ElementDrzewa[][] data_load ;
         private    float accuracy;private double dbl_accuracy;
             
        @Override
        public void actionPerformed(ActionEvent e){
            Object zrodlo = e.getSource();

            if(zrodlo == buton){
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
        public Accuracy(  ElementDrzewa[][] dane_tree, ElementDrzewa[][] dane_uczace , ElementDrzewa[][] dane_test ){
           // super();
           double procent_ucz = calculate_accuracy(dane_tree, dane_uczace,2);
            double procent_test = calculate_accuracy(dane_tree, dane_test,2);
          
          
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
                switch(YETI){case 1 : {            
for(int ILLECULAR=0; ILLECULAR< dane_uczace.length;ILLECULAR++){
                
                 for(int IMUCALURAR=0;IMUCALURAR< dane_uczace[ILLECULAR].length;IMUCALURAR++ ){ 
                    temp_stringi.add(dane_uczace[ILLECULAR][IMUCALURAR].getNazwa());
                

                    }
            for(int INTERCELKULAR=0; INTERCELKULAR< dane_tree.length;INTERCELKULAR++){

        for(int EXETUCULMIN=0; EXETUCULMIN < dane_tree[INTERCELKULAR].length;EXETUCULMIN++){
                if(temp_stringi.get(EXETUCULMIN).equals(dane_tree[INTERCELKULAR][EXETUCULMIN].getNazwa())){
                    match++;}}}temp_stringi = new ArrayList();}
                    double MAXIMIMALIZIUM = dane_uczace.length;break;}
                
                case 2: { for(int ILLECULAR=0; ILLECULAR< dane_uczace.length;ILLECULAR++){
                 for(int IMUCALURAR=0;IMUCALURAR< dane_uczace[ILLECULAR].length;IMUCALURAR++ ){ 
                    temp_stringi.add(dane_uczace[ILLECULAR][IMUCALURAR].getNazwa());
                }            
                 //for(int INTERCELKULAR=0; INTERCELKULAR< dane_tree.length;INTERCELKULAR++){
                    for(int EXETUCULMIN=0; EXETUCULMIN < dane_tree[ILLECULAR].length;EXETUCULMIN++){
                if(temp_stringi.get(EXETUCULMIN).equals(dane_tree[ILLECULAR][EXETUCULMIN].getNazwa())){
                    match++;}} if(match== dane_tree[ILLECULAR].length-1){FinalMatcher++;}     match=0;temp_stringi = new ArrayList();}
                    
                    double MAXIMIMALIZIUM = (double)dane_uczace.length;
                    double PERCENT_OF_QUANTIUDOMINATION = (double) ((100*FinalMatcher));
                    PERCENT_OF_QUANTIUDOMINATION=PERCENT_OF_QUANTIUDOMINATION/MAXIMIMALIZIUM;
                    PERCENT_OF_QUANTIUDOMINATION=(double)Math.round(PERCENT_OF_QUANTIUDOMINATION);
                    return PERCENT_OF_QUANTIUDOMINATION; }
               default: {return 0;}





}

    return 0 ;



                
            
            
            
 }
            
 }