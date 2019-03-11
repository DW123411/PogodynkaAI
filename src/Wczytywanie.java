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

    public static Drzewo<ElementDrzewa> wczytajDrzewoZPliku(String sciezka){
        File plik = new File(sciezka);
        Scanner skaner = null;
        try {
            skaner = new Scanner(plik);
        }catch(FileNotFoundException err){
            System.out.println(err.toString());
        }
        List<Wezel<ElementDrzewa>> wezly = new ArrayList<>();
        Drzewo<ElementDrzewa> drzewo = new Drzewo<>();
        try {
            skaner = new Scanner(plik);
        }catch(FileNotFoundException err){
            System.out.println(err.toString());
        }
        try{
            boolean czyPierwszy = true;
            while (skaner.hasNextLine()){
                int tmp = skaner.nextInt();
                if (tmp == 0) {
                    Kategoria tmpKat = new Kategoria(skaner.next());
                    String tmpNazwaRodzica = skaner.next();
                    Wezel<ElementDrzewa> tmpRodzic = null;
                    for(Wezel<ElementDrzewa> obj : wezly){
                        if((obj.getDane().getNazwa().equals(tmpNazwaRodzica))){
                            tmpRodzic = obj;
                        }
                    }
                    Wezel<ElementDrzewa> tmpWezel = new Wezel<>(tmpRodzic,tmpKat);
                    wezly.add(tmpWezel);
                    if (czyPierwszy){
                        drzewo = new Drzewo<>(tmpWezel);
                        czyPierwszy = false;
                    }
                } else {
                    Parametr tmpPar = null;
                    if(skaner.nextInt()==0) {
                        tmpPar = new Parametr(skaner.next(),skaner.nextBoolean());
                    }else{
                        tmpPar = new Parametr(skaner.next(),skaner.nextInt());
                    }
                    String tmpNazwaRodzica = skaner.next();
                    Wezel<ElementDrzewa> tmpRodzic = null;
                    for(Wezel<ElementDrzewa> obj : wezly){
                        if((obj.getDane().getNazwa().equals(tmpNazwaRodzica))){
                            tmpRodzic = obj;
                        }
                    }
                    Wezel<ElementDrzewa> tmpWezel = new Wezel<>(tmpRodzic,tmpPar);
                    wezly.add(tmpWezel);
                }
            }
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
