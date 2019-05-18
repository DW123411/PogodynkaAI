import javax.swing.*;
import java.io.*;
import java.util.*;


public class Wczytywanie {

    /**
     * metoda zwraca klase Drzewo z podanej ścieżki do pliku jako zmienna wejściowa
     */
    public static Drzewo<ElementDrzewa> wczytajDrzewoZPliku(String sciezka){
        File plik = new File(sciezka);
        Scanner skaner = null;

        try {
            skaner = new Scanner(plik); //inicjalizacja Scannera
        }catch(FileNotFoundException err){
            System.out.println(err.toString());
        }
        if(plik.length()==0) {
            JOptionPane.showMessageDialog(null, "Wrzucasz pusty plik");

        }

        List<Wezel<ElementDrzewa>> wezly = new ArrayList<>(); //lista zawierająca węzły wczytywanego drzewa
        Drzewo<ElementDrzewa> drzewo = new Drzewo<>();
        try {
            skaner.useDelimiter("\\s*,\\s*");
            boolean czyPierwszy = true; //zmienna potrzebna do wykrycia pierwszej linii danych w pliku
            boolean blad = false; // zmienna do błędu
            while (skaner.hasNextLine()) {

                int tmp = skaner.nextInt(); //wczytanie liczby określającej typ danych (Atrybut lub WartoscAtrybutu)
                if (tmp == 0) { //Atrybut
                    Atrybut tmpAtr = new Atrybut(skaner.next()); //utworzenie kategorii o nazwie wczytanej z pliku
                    String tmpNazwaRodzica = skaner.next(); //wczytanie nazwy rodzica Atrybutu w drzewie
                    Wezel<ElementDrzewa> tmpRodzic = null;
                    for (Wezel<ElementDrzewa> obj : wezly) {
                        if ((obj.getDane().getNazwa().equals(tmpNazwaRodzica))) { //przeszukanie wczytanych już wcześniej węzłów w celu znalezienia rodzica dla nowo wczytanego atrybutu
                            tmpRodzic = obj;
                        }
                    }
                    Wezel<ElementDrzewa> tmpWezel = new Wezel<>(tmpRodzic, tmpAtr); //utworzenie węzła drzewa
                    wezly.add(tmpWezel);
                    if (czyPierwszy) { //w przypadku pierwszego Atrybutu należy utworzyć nowy objekt klasy Drzewo
                        drzewo = new Drzewo<>(tmpWezel);
                        czyPierwszy = false;
                    }
                    if (tmpRodzic != null) {
                        tmpRodzic.dodajDziecko(tmpWezel); //dodanie utworzonego węzła do listy potomków jego rodzica w drzewie
                    }


                } /*else { //WartoscAtrybutu
                    WartoscAtrybutu tmpWA = null;
                    if (skaner.nextInt() == 0) { //jeśli drugą wczytaną wartością jest 0 to oznacza że WartoscAtrybutu ma wartość boolean
                        tmpWA = new WartoscAtrybutu(skaner.next(), skaner.nextBoolean());
                    } else { //jeśli druga wczytana wartość wynosi 1 to oznacza że WartoscAtrybutu ma wartość liczbową
                        tmpWA = new WartoscAtrybutu(skaner.next(), skaner.nextInt());
                    }
                    String tmpNazwaRodzica = skaner.next(); //wczytanie nazwy rodzica WartosciAtrybutu w drzewie
                    Wezel<ElementDrzewa> tmpRodzic = null;
                    for (Wezel<ElementDrzewa> obj : wezly) {
                        if ((obj.getDane().getNazwa().equals(tmpNazwaRodzica))) { //przeszukanie wczytanych już wcześniej węzłów w celu znalezienia rodzica dla nowo wczytanej WartosciAtrybutu
                            tmpRodzic = obj;
                        }
                    }
                    Wezel<ElementDrzewa> tmpWezel = new Wezel<>(tmpRodzic, tmpWA); //utworzenie węzła drzewa
                    wezly.add(tmpWezel);
                    if (tmpRodzic != null) {
                        tmpRodzic.dodajDziecko(tmpWezel); //dodanie utworzonego węzła do listy potomków jego rodzica w drzewie
                    } else if (tmpRodzic == null) {
                        JOptionPane.showMessageDialog(null, "Nieprawidlowe dane , Wezel musi mieć rodziców");
                        blad = true;
                        break;
                    }
                }*/

            if (blad != true) {
                //JOptionPane.showMessageDialog(null, wezly.toString());
            }
        }
            skaner.close();
        }catch(NullPointerException err){
            System.out.println(err.toString());
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(null, "Nieprawidlowe dane");
            System.out.println(e.toString());
        }


        return drzewo;
    }
    /**
     * metoda zwraca klase Klasyfikacja z podanej ścieżki do pliku jako zmienna wejściowa
     */
    public static DaneWejsciowe wczytajKlasyfikacjeZPliku(String Ścieżka){
        File file = new File(Ścieżka);
                Scanner scanner = null;
                String[][] temp_table;
                ElementDrzewa[][] temp_table_obj;
                Atrybut[] temp_table_atrybuty;
          try {
            scanner = new Scanner(file); //inicjalizacja Scannera
        }catch(FileNotFoundException err){
            System.out.println(err.toString());
        }
        /**
         * Sprawdzenie pliku pod wzgledem przygotowania rozmiaru tablicy dwuwymiarowej
         */
        int max_szerokosc=0; 
        int max_wysokosc=0;
        int y=0;
        while(scanner.hasNextLine()){
        String linia = scanner.nextLine();
        int x=0;
        y++;
        String wyraz="";
        for(int i=0;i<linia.length();i++)
        {   
            if(linia.charAt(i)==','){
                //System.out.println(wyraz);
                wyraz="";x++;}
            else{
                wyraz+=linia.charAt(i);
               
            }
        }
            if(x>max_szerokosc){max_szerokosc=x;}
        
        }
            if(y>max_wysokosc){max_wysokosc=y;}
       
            scanner.close();     // zamkniecie skanera
        /**
        * przygotowanie tablicy
        */
           temp_table= new String[max_wysokosc][max_szerokosc];
           temp_table_obj = new ElementDrzewa[max_wysokosc][max_szerokosc];
           temp_table_atrybuty= new Atrybut[max_szerokosc-2];
          try {
            scanner = new Scanner(file); //inicjalizacja Scannera na nowo
        }catch(FileNotFoundException err){
            System.out.println(err.toString());
        }
        /**
         * wpisanie danych z pliku do tablicy
         */
        
        y=0; boolean atrybuty=true; boolean pierwszy = true; int atr_x=0;
        while(scanner.hasNextLine()){
        String linia = scanner.nextLine();
         int x=0;
        String wyraz=""; int kol = 0; 
           for(int k=0;k<linia.length();k++){
            if(linia.charAt(k)==','){
            kol++;
            }
                    }  
        for(int i=0;i<linia.length();i++)
        {   
               
            if(linia.charAt(i)==','){
                temp_table[y][x]=wyraz;
                if(y!=0){
                    if(pierwszy){
                    temp_table_obj[y][x]=new WartoscAtrybutu(wyraz);
                    pierwszy=false;
                }else {
                if(atrybuty){
                    if(x==kol-1){
                        temp_table_obj[y][x]=new Decyzja(wyraz);
                    }
                    else{
                    temp_table_obj[y][x]=new Atrybut(wyraz);
                    temp_table_atrybuty[atr_x]= new Atrybut(wyraz);
                    atr_x++;
                }
                }
                if(!atrybuty){
                    if(x==kol-1){
                temp_table_obj[y][x]=new Decyzja(wyraz);
                }else{
                                        temp_table_obj[y][x]=new WartoscAtrybutu(wyraz);
                                    }
                }
                }
                    }
                        else {
                            if(pierwszy){
                    temp_table_obj[y][x]=new WartoscAtrybutu(wyraz);
                    pierwszy=false;
                }else {
                if(atrybuty){
                     if(x==kol-1){
                            temp_table_obj[y][x]=new Decyzja(wyraz);
                        }else{
                    temp_table_obj[y][x]=new Atrybut(wyraz);
                     temp_table_atrybuty[atr_x]= new Atrybut(wyraz);
                    atr_x++;
                }
            }
                if(!atrybuty){
                     if(x==kol-1){
                            temp_table_obj[y][x]=new Decyzja(wyraz);
                        }else{
                                        temp_table_obj[y][x]=new WartoscAtrybutu(wyraz);
                }
            }
                        }
                      }
                wyraz="";x++;
            }
            else{
                wyraz+=linia.charAt(i);
            }
        }
         y++; atrybuty = false; pierwszy =true; 
        }
           scanner.close();
        DaneWejsciowe KS = new DaneWejsciowe();
        KS.set_klasyfikacja_tablica_string(temp_table);
        KS.set_klasyfikacja_tablica(temp_table_obj);
        KS.set_klasyfikacja_tablica_atrybuty( temp_table_atrybuty);
    return KS;
    }

}