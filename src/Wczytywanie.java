import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wczytywanie {

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
                int tmp = skaner.nextInt(); //wczytanie liczby określającej typ danych (Atrybut lub WartoscAtrybutu)
                if (tmp == 0) { //Atrybut
                    Atrybut tmpAtr = new Atrybut(skaner.next()); //utworzenie kategorii o nazwie wczytanej z pliku
                    String tmpNazwaRodzica = skaner.next(); //wczytanie nazwy rodzica Atrybutu w drzewie
                    Wezel<ElementDrzewa> tmpRodzic = null;
                    for(Wezel<ElementDrzewa> obj : wezly){
                        if((obj.getDane().getNazwa().equals(tmpNazwaRodzica))){ //przeszukanie wczytanych już wcześniej węzłów w celu znalezienia rodzica dla nowo wczytanego atrybutu
                            tmpRodzic = obj;
                        }
                    }
                    Wezel<ElementDrzewa> tmpWezel = new Wezel<>(tmpRodzic,tmpAtr); //utworzenie węzła drzewa
                    wezly.add(tmpWezel);
                    if (czyPierwszy){ //w przypadku pierwszego Atrybutu należy utworzyć nowy objekt klasy Drzewo
                        drzewo = new Drzewo<>(tmpWezel);
                        czyPierwszy = false;
                    }
                    if(tmpRodzic!=null){
                        tmpRodzic.dodajDziecko(tmpWezel); //dodanie utworzonego węzła do listy potomków jego rodzica w drzewie
                    }
                } else { //WartoscAtrybutu
                    WartoscAtrybutu tmpWA = null;
                    if(skaner.nextInt()==0) { //jeśli drugą wczytaną wartością jest 0 to oznacza że WartoscAtrybutu ma wartość boolean
                        tmpWA = new WartoscAtrybutu(skaner.next(),skaner.nextBoolean());
                    }else{ //jeśli druga wczytana wartość wynosi 1 to oznacza że WartoscAtrybutu ma wartość liczbową
                        tmpWA = new WartoscAtrybutu(skaner.next(),skaner.nextInt());
                    }
                    String tmpNazwaRodzica = skaner.next(); //wczytanie nazwy rodzica WartosciAtrybutu w drzewie
                    Wezel<ElementDrzewa> tmpRodzic = null;
                    for(Wezel<ElementDrzewa> obj : wezly){
                        if((obj.getDane().getNazwa().equals(tmpNazwaRodzica))){ //przeszukanie wczytanych już wcześniej węzłów w celu znalezienia rodzica dla nowo wczytanej WartosciAtrybutu
                            tmpRodzic = obj;
                        }
                    }
                    Wezel<ElementDrzewa> tmpWezel = new Wezel<>(tmpRodzic,tmpWA); //utworzenie węzła drzewa
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
}
