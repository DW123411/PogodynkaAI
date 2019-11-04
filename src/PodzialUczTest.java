public class PodzialUczTest {

    public PodzialUczTest(){
    }

    public static DaneWejsciowe losowanietest(int ilosc, DaneWejsciowe org){
        int g = 0;
        int t = 0;

        int[] tr1 =null;
        int[] tr2 =null;

        DaneWejsciowe test = new DaneWejsciowe();

        String[][] element = org.get_klasyfikacja_string();
        String[][] wylosowany = new String[ilosc][element[0].length];

        for(g=0; g<ilosc;g++){
               for(t=0; t<element[0].length-1; t++){
                    int r1 = (int) (Math.random() * (element.length));
                    wylosowany[g][t]=element[r1][t];
                }
            }



            test.set_klasyfikacja_tablica_string(wylosowany);


        return test;
    }
    public static DaneWejsciowe losowanieucz(int ilosc, DaneWejsciowe org){
        int g = 0;
        int t = 0;

        int[] tr1 =null;
        DaneWejsciowe ucz = new DaneWejsciowe();

        String[][] element = org.get_klasyfikacja_string();
        String[][] wylosowany = new String[ilosc][element[0].length];

        for(g=0; g<ilosc;g++){
            for(t=0; t<element[0].length; t++){
                int r1 = (int) (Math.random() * (element.length));
                wylosowany[g][t]=element[r1][t];
            }
        }

            ucz.set_klasyfikacja_tablica_string(wylosowany);

        return ucz;
    }




}
