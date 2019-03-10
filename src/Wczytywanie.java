import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wczytywanie {
    // Metoda wczytująca plik z danymi
    public static ArrayList<Wezel> czytajPlik(String sciezkadoPliku) throws FileNotFoundException {
        File plik = new File(sciezkadoPliku);
        Scanner skaner = new Scanner(plik);
        String sciezka = skaner.nextLine();
        Path sciezkaget = Paths.get(sciezka);
        boolean czyKategoria = false;
        int index = 0;
        // Lista będzie przechowywała kolejne linie odczytane z pliku jako String
        ArrayList<String> odczyt = new ArrayList<String>();
        List<Kategoria> katList = new ArrayList<>();

        try {
            // Wczytanie wszystkich linii do listy
            odczyt = (ArrayList) Files.readAllLines(sciezkaget);


        } catch (IOException ex) {
            System.out.println("Brak pliku!");
        }

        ArrayList<Wezel> wezely = new ArrayList<>();
        for (String linia : odczyt) {
            if(!czyKategoria){
                czyKategoria=true;
                String[] kategoriaposz = linia.split(",");
                Kategoria kategoria = new Kategoria();
                kategoria.setNazwa(kategoriaposz[0]);
                kategoria.setNazwa(kategoriaposz[1]);
                kategoria.setNazwa(kategoriaposz[2]);
                kategoria.setNazwa(kategoriaposz[3]);
                kategoria.setNazwa(kategoriaposz[4]);
                kategoria.setNazwa(kategoriaposz[5]);

                katList.add(kategoria);

            }
            else {
                String[] wartposz = linia.split(",");

            }

        }



                // use comma as separator



        // Wywołanie metody tworzącej obiekty i wypełniające je danymi z pliku
        //ArrayList<Wezel> wezely = doObiektow(odczyt);
        //return wezely;
        return null;
    }

}