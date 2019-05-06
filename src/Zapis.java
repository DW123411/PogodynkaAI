import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Zapis {

    public static void zapisDoPlkiu(ElementDrzewa tablica[][],String sciezka) throws FileNotFoundException {
        try {
            PrintWriter zapis = new PrintWriter(sciezka+".txt");
            zapis.print("Day,");
            for (int i = 0; i < tablica.length; i++) {
                if(i!=0){
                    zapis.print("D"+i+",");
                }
                for (int j = 0; j < tablica[i].length; j++) {
                    if(i==0 && j==tablica[i].length-1){
                        zapis.print("Decision,");
                    }
                   else {
                        zapis.print(tablica[i][j].getNazwa() + ",");
                    }

                }
                zapis.println();
            }
            zapis.close();
        } catch (IOException ex) {
            System.out.println("Problez z dostępem do pliku");


        }
    }
}
