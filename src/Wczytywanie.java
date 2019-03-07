import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Wczytywanie {
    // Metoda wczytująca plik z danymi
    public static ArrayList<Wezel> czytajPlik(String sciezkadoPliku) throws FileNotFoundException {
        File plik = new File(sciezkadoPliku);
        Scanner skaner = new Scanner(plik);
        String sciezka = skaner.nextLine();
        Path sciezkaget = Paths.get(sciezka);
        // Lista będzie przechowywała kolejne linie odczytane z pliku jako String
        ArrayList<String> odczyt = new ArrayList<String>();
        try {
            // Wczytanie wszystkich linii do listy
            odczyt = (ArrayList) Files.readAllLines(sciezkaget);
        } catch (IOException ex) {
            System.out.println("Brak pliku!");
        }

        // Pobranie pierwszej linii z nagłówkami...
        String naglowki = odczyt.get(0);
        // ... następnie usunięcie jej
        odczyt.remove(0);
        // Wywołanie metody tworzącej obiekty i wypełniające je danymi z pliku
        //ArrayList<Wezel> wezely = doObiektow(odczyt);
        //return wezely;
        return null;
    }

}