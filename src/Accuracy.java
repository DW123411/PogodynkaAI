
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adnin
 */
 public class Accuracy extends JFrame  implements ActionListener{

        private JLabel label1;    private JLabel label2;    private JButton buton;
        
             Drzewo<ElementDrzewa> temp_prepared_tree;
             DaneWejsciowe data_classified ;
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

        public Accuracy(     Drzewo<ElementDrzewa> temp, DaneWejsciowe dane){
           // super();
            temp_prepared_tree= temp;
            data_classified = dane; 
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
           public void setDoklUcz(int a){
            this.label1.setText("Dokładnośc ucząca : "+a+"%");
            
        }
          public void setDoklTest(int a){
            this.label2.setText("Dokładnośc testująca : "+a+"%");
            
        }
        public void popup(){
            
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

    }
