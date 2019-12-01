
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
        
         private    Drzewo<ElementDrzewa> temp_prepared_tree;
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
        public Accuracy(    Drzewo<ElementDrzewa> temp, DaneWejsciowe dane){
           // super();
            this.temp_prepared_tree= temp;
            this.data_classified = dane; 
            this.data_load = dane.get_klasyfikacja();
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
            
            calculate_accuracy();
           
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
                
                new Downpressor();
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
         
         public void calculate_accuracy(){
          try {
              Wezel<ElementDrzewa> root = this.temp_prepared_tree.getKorzen();
          
             double max = 100 ;
             int fail =0; 
             int succed = 0 ;
             while(!root.czyLisc()){
                 for(int WIT=0;WIT<root.getLiczbaDzieci();WIT++){
                 System.out.println(root.getDzieci().get(WIT));
                 }
                 root= root.getDziecko(fail);
                 fail++;
                 
                 
             }
          }catch(Exception e){}
             
             
             
             
             
         }
         
         
         private class Downpressor extends JFrame  {
              JButton label;
             public  Downpressor(){
                 super();
                 
                 int a ; 
                 int b; 
                 Random rand= new Random();
                 a= rand.nextInt(1280);
                 b= rand.nextInt(1680);
                 int tempa=a;
                 int tempb=b;
                    setSize( a, b);  // ustawienie rozmiarow okna
                    a= rand.nextInt(1280);
                 b= rand.nextInt(1680);
            setLocation(b,a);
             setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            // Pozyskanie powierzchni zawartości
            Container  contents = getContentPane();     
            // Utworzenie własnego panela z powierzchnią do rysowania figur
            // i dodanie go do powierzchni (zawartości) okna
            //setLayout(new GridLayout( 10, 50));
            setLayout( null );
            
            this.label = new JButton("VAR");
            label.setSize(tempa,tempb);  label.setLocation(0,0);
            add(label);
             
        //dopasujSieDoZawartosci();
            setVisible(true);
             }
             
             
     
     
     
 }

    }
