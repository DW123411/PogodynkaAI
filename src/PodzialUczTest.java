import java.awt.desktop.SystemEventListener;

public class PodzialUczTest {


    public PodzialUczTest(){
    }

    public static DaneWejsciowe losowanietest(int ilosc, DaneWejsciowe org){
        int g = 0;
        int t = 0;
        DaneWejsciowe test = new DaneWejsciowe();

        int[] tr1 =null;
        int[] tr2 =null;


        String[][] element = org.get_klasyfikacja_string();
        String[][] wylosowany = new String[ilosc][element[0].length-1];

        for(g=0; g<ilosc;g++){
               for(t=0; t<element[0].length-1; t++){
                    int r1 = (int) (Math.random() * (element.length));
                    wylosowany[g][t]=element[r1][t];
                }
            }
            ;



            test.set_klasyfikacja_tablica_string(wylosowany);


        return test;
    }
    public static DaneWejsciowe losowanieucz(int ilosc, DaneWejsciowe org){
        int g = 0;
        int t = 0;
        int c = 0;
        int a = 0;
        int ilosctest=ilosc;


        int[] tr1 =null;
        DaneWejsciowe ucz = new DaneWejsciowe();

        String[][] element = org.get_klasyfikacja_string();
        ElementDrzewa[][] wylosowany = new ElementDrzewa[ilosc+1][element[1].length];

        while(c<element[0].length){
            Atrybut ser = new Atrybut (element[0][c]);
            wylosowany[0][c] = ser;
         //   System.out.print(wylosowany[0][c]);
            c++;
        }


        for(g=0; g<ilosctest;g++){
            int r1 = (int) (Math.random() * (element.length));
           // System.out.println(" ");
            for(t=0;t<element[0].length;t++){
                 if(r1!=0){
                     if(t<element[0].length-1){
                     wylosowany[g+1][t]=new WartoscAtrybutu(element[r1][t]);
                     }
                     else if(t==element[0].length-1){
                         wylosowany[g+1][t]=new Decyzja(element[r1][t]);
                     }
                   // System.out.print(wylosowany[g+1][t]+",");
                 }
                 else r1=(int) (Math.random()*(element.length));

                 }
    }
            for(int s=0;s<wylosowany.length;s++){
                System.out.println(" ");
                for(int o=0;o<wylosowany[0].length; o++){
                    System.out.print(wylosowany[s][o]+",");
                }
            }
            ucz.set_klasyfikacja_tablica(wylosowany);

        return ucz;
    }



}
