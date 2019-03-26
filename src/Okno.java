
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Okno extends JFrame implements ActionListener
{
    Menuski menu = new Menuski();
    Wyswietlanie okno = new Wyswietlanie();
    String sciezkaDoPliku;
    Drzewo<ElementDrzewa> wczytywanie;
    Drzewo<ElementDrzewa> zapis;
    Drzewo drzewo;
    public Okno() {  
        super("Projekt Zespołowy");
        //ustawienie standardowej akcji po naciśnięciu przycisku zamkniecia
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //blokada zmiany rozmiaru okna
        setResizable (false);
        //rozmieszczenie elementow - menadzer rozkladu
        //FlowLayout ustawia elementy jeden za drugim
        //w tym przypadku dodatkowo wysrodkowane na ekranie, z odstępem w pionie i poziomie
        setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        //ustawienie stworzonego menu
        setJMenuBar(menu);
        //dodanie paneli
        add(okno); 
        //przypisanie obsługi akcji
        ustawNasluchZdarzen();        
        dopasujSieDoZawartosci();
        //wyswietlenie naszej ramki
        setVisible(true);

    }

    private void ustawNasluchZdarzen()
    {
        menu.showtree.addActionListener(this);
        menu.tree.addActionListener(this);
        menu.exit.addActionListener(this);
        menu.clean.addActionListener(this);
        menu.credits.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String label = e.getActionCommand();
        if(label.equals("Rysuj Drzewo")){
            Wezel<String> korzen = new Wezel<String>(null, "Outlook");

            Wezel<String> n1 = korzen.dodajDziecko("Sunny");
            Wezel<String> n2 = korzen.dodajDziecko("Overcast");
            Wezel<String> n3 = korzen.dodajDziecko("Rain");
            Wezel<String> n4 = n1.dodajDziecko("Humidity");
            Wezel<String> n5 = n2.dodajDziecko("No");

            Wezel<String> n6 = n3.dodajDziecko("Wind");
            Wezel<String> n7 = n4.dodajDziecko("High");
            Wezel<String> n8 = n4.dodajDziecko("Normal");
            Wezel<String> n9 = n7.dodajDziecko("Yes");
            Wezel<String> n10 = n8.dodajDziecko("No");
            // Wezel<String> n11 = n6.dodajDziecko("Strong");
            // Wezel<String> n12 = n6.dodajDziecko("Weak");
            // Wezel<String> n13 = n11.dodajDziecko("Yes");
            // Wezel<String> n14 = n12.dodajDziecko("No");



            //   Drzewo<String> drzewo = new Drzewo<String>(korzen);
            okno.rysujDrzewo(korzen,550,50,korzen);
            //System.out.println("Coś tam");
        }

        else if(label.equals("Wczytaj drzewo z Pliku")) {
            boolean spr = otworzPlik();
            if (spr) {
                wczytywanie = Wczytywanie.wczytajDrzewoZPliku(sciezkaDoPliku);
                drzewo = new Drzewo(wczytywanie.getKorzen());
            }
            else if (!spr) {
                JOptionPane.showMessageDialog(null, "Nie wczytałeś pliku");
            }
        }

        else if (label.equals("O programie")){
            okno.credits();
        }

        else if (label.equals("Wyjdź z programu")){
            System.exit(0);
        }
        else if (label.equals("Wyczyść")){
            okno.wyczysc();

        }

    }

    private void dopasujSieDoZawartosci()
    {
        //dostosowanie okna do zawartości
        pack();
        //wyśrodkowanie ramki
        setLocationRelativeTo(null);
    }

    private boolean otworzPlik(){
        JFileChooser otworz= new JFileChooser();
        FileNameExtensionFilter filtr = new FileNameExtensionFilter("TXT Files", "txt");
        FileNameExtensionFilter filtrCSV = new FileNameExtensionFilter("CSV", "csv");
        otworz.setFileFilter(filtr);
        otworz.setFileFilter(filtrCSV);
        otworz.setAcceptAllFileFilterUsed(false);
        int wynik = otworz.showOpenDialog(this);
        boolean check = false;
        if (wynik == JFileChooser.APPROVE_OPTION)
        {
            sciezkaDoPliku = otworz.getSelectedFile().getPath();
            check = true;
        }
        return check;
    }

    private boolean zapiszPlik(){
        JFileChooser zapisz= new JFileChooser();
        FileNameExtensionFilter filtr = new FileNameExtensionFilter("TXT Files", "txt");
        zapisz.setFileFilter(filtr);
        int wynik = zapisz.showSaveDialog(this);
        boolean check = false;
        if (wynik == JFileChooser.APPROVE_OPTION)
        {
            sciezkaDoPliku = zapisz.getSelectedFile().getPath();
            check = true;
        }
        return check;
    }
}
