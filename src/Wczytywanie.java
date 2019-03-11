import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wczytywanie {

    public List czytajKategoria(String sciezkadoPliku) throws FileNotFoundException {
        File plik = new File(sciezkadoPliku);
        //Scanner skaner = new Scanner(plik);
        //String sciezka = skaner.nextLine();
        Path sciezkaget = Paths.get(sciezkadoPliku);

        ArrayList<String> odczyt = new ArrayList<>();
        List<Kategoria> katList = new ArrayList<>();
        List<Parametr> parList = new ArrayList<>();

        try {

            odczyt = (ArrayList) Files.readAllLines(sciezkaget);


            for (String linia : odczyt) {
                String[] kategoriaposz = linia.split(",");

               // System.out.println(kategoriaposz[0]);
                if (kategoriaposz[0].equals("0")) {
                    Kategoria kategoria = new Kategoria();

                    kategoria.setNazwa(kategoriaposz[1]);
      //              System.out.println("kat="+kategoria);

                    katList.add(kategoria);

                }

        }


        } catch (IOException ex) {
            System.out.println("Brak pliku7!");
        }

        return katList;



    }
       /* public  List<Wezel> czytajWartosci(String sciezkadoPliku) throws FileNotFoundException {
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
            }*/

    }
