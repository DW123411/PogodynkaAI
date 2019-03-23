import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wczytywanie {

    /*public List czytajKategoria(String sciezkadoPliku) throws FileNotFoundException {
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
    }*/

    public static Drzewo<ElementDrzewa> wczytajDrzewoZPliku(String sciezka){
        File plik = new File(sciezka);
        Scanner skaner = null;
        try {
            skaner = new Scanner(plik); //inicjalizacja Scannera
        }catch(FileNotFoundException err){
            System.out.println(err.toString());
        }
        List<Wezel<ElementDrzewa>> wezly = new ArrayList<>(); //lista zawierająca węzły wczytywanego drzewa
        Drzewo<ElementDrzewa> drzewo = new Drzewo<>();
        try{
            skaner.useDelimiter("\\s*,\\s*");
            boolean czyPierwszy = true; //zmienna potrzebna do wykrycia pierwszej linii danych w pliku
            while (skaner.hasNextLine()){
                int tmp = skaner.nextInt(); //wczytanie liczby określającej typ danych (Kategoria lub Parametr)
                if (tmp == 0) { //Kategoria
                    Kategoria tmpKat = new Kategoria(skaner.next()); //utworzenie kategorii o nazwie wczytanej z pliku
                    String tmpNazwaRodzica = skaner.next(); //wczytanie nazwy rodzica Kategorii w drzewie
                    Wezel<ElementDrzewa> tmpRodzic = null;
                    for(Wezel<ElementDrzewa> obj : wezly){
                        if((obj.getDane().getNazwa().equals(tmpNazwaRodzica))){ //przeszukanie wczytanych już wcześniej węzłów w celu znalezienia rodzica dla nowo wczytanej kategorii
                            tmpRodzic = obj;
                        }
                    }
                    Wezel<ElementDrzewa> tmpWezel = new Wezel<>(tmpRodzic,tmpKat); //utworzenie węzła drzewa
                    wezly.add(tmpWezel);
                    if (czyPierwszy){ //w przypadku pierwszej Kategorii należy utworzyć nowy objekt klasy Drzewo
                        drzewo = new Drzewo<>(tmpWezel);
                        czyPierwszy = false;
                    }
                    if(tmpRodzic!=null){
                        tmpRodzic.dodajDziecko(tmpWezel); //dodanie utworzonego węzła do listy potomków jego rodzica w drzewie
                    }
                } else { //Parametr
                    Parametr tmpPar = null;
                    if(skaner.nextInt()==0) { //jeśli drugą wczytaną wartością jest 0 to oznacza że parametr ma wartość boolean
                        tmpPar = new Parametr(skaner.next(),skaner.nextBoolean());
                    }else{ //jeśli druga wczytana wartość wynosi 1 to oznacza że parametr ma wartość liczbową
                        tmpPar = new Parametr(skaner.next(),skaner.nextInt());
                    }
                    String tmpNazwaRodzica = skaner.next(); //wczytanie nazwy rodzica Parametru w drzewie
                    Wezel<ElementDrzewa> tmpRodzic = null;
                    for(Wezel<ElementDrzewa> obj : wezly){
                        if((obj.getDane().getNazwa().equals(tmpNazwaRodzica))){ //przeszukanie wczytanych już wcześniej węzłów w celu znalezienia rodzica dla nowo wczytanego parametru
                            tmpRodzic = obj;
                        }
                    }
                    Wezel<ElementDrzewa> tmpWezel = new Wezel<>(tmpRodzic,tmpPar); //utworzenie węzła drzewa
                    wezly.add(tmpWezel);
                    if(tmpRodzic!=null){
                        tmpRodzic.dodajDziecko(tmpWezel); //dodanie utworzonego węzła do listy potomków jego rodzica w drzewie
                    }
                }
            }
            skaner.close();
        }catch(NullPointerException err){
            System.out.println(err.toString());
        }
        return drzewo;
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
