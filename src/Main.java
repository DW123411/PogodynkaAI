import java.awt.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello3");
        System.out.println("Hello Test GitHub!");

        Wezel<String> korzen = new Wezel<String>(null, "G");

        Wezel<String> n1 = korzen.dodajDziecko("E");
        Wezel<String> n2 = korzen.dodajDziecko("C");
        Wezel<String> n3 = korzen.dodajDziecko("V");
        n1.dodajDziecko("Z");
        Wezel<String> n4 = n1.dodajDziecko("M");
        n1.dodajDziecko("P");
        n4.dodajDziecko("J");
        Wezel<String> n5 = n2.dodajDziecko("X");
        n5.dodajDziecko("H");
        n5.dodajDziecko("O");
        n3.dodajDziecko("B");
        Wezel<String> n6 = n3.dodajDziecko("S");
        n6.dodajDziecko("F");

        Drzewo<String> drzewo = new Drzewo<String>(korzen);

        System.out.print("Pre Order: ");
        drzewo.preOrder(korzen);

        //Wczytywanie plik = new Wczytywanie();

        //Object test = plik.czytajKategoria("D:/Mateusz/Pulpit/test.txt");

        Drzewo<ElementDrzewa> testWczytywania = Wczytywanie.wczytajDrzewoZPliku("D:/Mateusz/Pulpit/test.txt");

        System.out.println("Test:");
        testWczytywania.preOrder(testWczytywania.getKorzen());


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Okno();
            }
        });
    }
}
