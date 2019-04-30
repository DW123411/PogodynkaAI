
import java.awt.*;
import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello3");
        System.out.println("Hello Test GitHub!");
        Wyswietlanie test = new Wyswietlanie();

        Wezel<String> korzen = new Wezel<String>(null, "G");

        Wezel<String> n1 = korzen.dodajDziecko("E");
        Wezel<String> n2 = korzen.dodajDziecko("C");
        Wezel<String> n3 = korzen.dodajDziecko("V");
        Wezel<String> n7 = n1.dodajDziecko("Z");
        Wezel<String> n4 = n1.dodajDziecko("M");
        Wezel<String> n8 = n1.dodajDziecko("P");
        Wezel<String> n9 = n4.dodajDziecko("J");
        Wezel<String> n5 = n2.dodajDziecko("X");
        Wezel<String> n10 = n5.dodajDziecko("H");
        Wezel<String> n11  = n5.dodajDziecko("O");
        Wezel<String> n12 = n3.dodajDziecko("B");
        Wezel<String> n6 = n3.dodajDziecko("S");
        Wezel<String> n13 = n6.dodajDziecko("F");

        Drzewo<String> drzewo = new Drzewo<String>(korzen);

        System.out.print("Pre Order: ");
        drzewo.preOrder(korzen);
        System.out.println(drzewo.getLevel(n1));
        System.out.println("test które dziecko" +korzen.getLiczbaDzieci());
        korzen.setPoczatekDostepnegoMiejsca(0);
        korzen.setKoniecDostepnegoMiejsca(600);
        test.obliczanieWspozednych(korzen,korzen);
        System.out.println("Test losowego wezla(obliczanie współżednych: "+n6.getPoczatekDostepnegoMiejsca()+" "+n6.getKoniecDostepnegoMiejsca()+" "+n6.getX());



        //Wczytywanie plik = new Wczytywanie();

        //Object test = plik.czytajKategoria("D:/Mateusz/Pulpit/test.txt");

        Drzewo<ElementDrzewa> testWczytywania = Wczytywanie.wczytajDrzewoZPliku("src/test.txt");


        System.out.println("Test:");
        testWczytywania.preOrder(testWczytywania.getKorzen());
        System.out.println();
        Drzewo drzewow = new Drzewo(testWczytywania.getKorzen());

        //LinkedList<Wezel> lista = drzewow.getKorzen().getDzieci();
        //System.out.println(lista.size());
        //Wezel w = lista.remove(0);
        //System.out.println(w.czyLisc());

        String[] atrybuty = {"Outlook","Humidity","Wind"};

        String[][] klasyfikcaja = {{"Day","Outlook","Humidity","Wind","Decision"},
                {"D1","Sunny","High","Weak","No"},
                {"D2","Sunny","High","Strong","No"},
                {"D3","Overcast","High","Weak","Yes"},
                {"D4","Rain","High","Weak","Yes"},
                {"D5","Rain","Normal","Weak","Yes"},
                {"D6","Rain","Normal","Strong","No"},
                {"D7","Overcast","Normal","Strong","Yes"},
                {"D8","Sunny","High","Weak","No"},
                {"D9","Sunny","Normal","Weak","Yes"},
                {"D10","Rain","Normal","Weak","Yes"},
                {"D11","Sunny","Normal","Strong","Yes"},
                {"D12","Overcast","High","Strong","Yes"},
                {"D13","Overcast","Normal","Weak","Yes"},
                {"D14","Rain","High","Strong","No"}
        };

        for(int i=0;i<klasyfikcaja.length;i++) {
            for (int j=0; j<klasyfikcaja[i].length; j++)
            System.out.print(klasyfikcaja[i][j]+"   ");

            System.out.println();
        }


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Okno();
            }
        });
    }
}
