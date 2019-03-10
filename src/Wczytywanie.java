import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wczytywanie {
    public List<Kategoria> czytajKategoria(String sciezkadoPliku) throws FileNotFoundException {
        File plik = new File(sciezkadoPliku);
        Scanner skaner = new Scanner(plik);
        String sciezka = skaner.nextLine();
        Path sciezkaget = Paths.get(sciezka);
        boolean czyKategoria = false;
        ArrayList<String> odczyt = new ArrayList<>();
        List<Kategoria> katList = new ArrayList<>();

        try {

            odczyt = (ArrayList) Files.readAllLines(sciezkaget);


        } catch (IOException ex) {
            System.out.println("Brak pliku!");
        }
        Kategoria kategoria = new Kategoria();
        for (String linia : odczyt) {
            if (!czyKategoria) {
                czyKategoria = true;
                String[] kategoriaposz = linia.split(",");
                kategoria.setNazwa(kategoriaposz[0]);
                kategoria.setNazwa(kategoriaposz[1]);
                kategoria.setNazwa(kategoriaposz[2]);
                kategoria.setNazwa(kategoriaposz[3]);
                kategoria.setNazwa(kategoriaposz[4]);
                kategoria.setNazwa(kategoriaposz[5]);

                katList.add(kategoria);

            }


        }
        return katList;
    }
        public  List<Wezel> czytajWartosci(String sciezkadoPliku) throws FileNotFoundException {
            File plik = new File(sciezkadoPliku);
            Scanner skaner = new Scanner(plik);
            String sciezka = skaner.nextLine();
            Path sciezkaget = Paths.get(sciezka);
            List<Wezel> wezList = new ArrayList<>();

            ArrayList<String> odczyt = new ArrayList<>();


            try {
                // Wczytanie wszystkich linii do listy
                odczyt = (ArrayList) Files.readAllLines(sciezkaget);


            } catch (IOException ex) {
                System.out.println("Brak pliku!");
            }
            String naglowki = odczyt.get(0);

            odczyt.remove(0);


            for (String linia : odczyt) {



                }

                return wezList;
            }

    }
