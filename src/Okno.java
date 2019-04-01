
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        menu.savetree.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String label = e.getActionCommand();
        if(label.equals("Rysuj Drzewo")){
           /* Wezel<String> korzen = new Wezel<String>(null, "Outlook");

            Wezel<String> n1 = korzen.dodajDziecko("Sunny");
            Wezel<String> n2 = korzen.dodajDziecko("Overcast");
            Wezel<String> n3 = korzen.dodajDziecko("Rain");
            Wezel<String> n4 = n1.dodajDziecko("Humidity");
            Wezel<String> n14 = n2.dodajDziecko("No");

            Wezel<String> n6 = n3.dodajDziecko("Wind");
            Wezel<String> n7 = n4.dodajDziecko("High");
            Wezel<String> n8 = n4.dodajDziecko("Normal");
            Wezel<String> n9 = n7.dodajDziecko("Yes");
            Wezel<String> n10 = n8.dodajDziecko("No");
            Wezel<String> n11 = n6.dodajDziecko("Strong");
            Wezel<String> n12 = n6.dodajDziecko("Weak");
             Wezel<String> n13 = n11.dodajDziecko("Yes");
             Wezel<String> n15 = n12.dodajDziecko("No");
            korzen.setPoczatekDostepnegoMiejsca(0);
            korzen.setKoniecDostepnegoMiejsca(okno.getWidth());
            okno.obliczanieWspozednych(korzen,korzen);
            System.out.println("Test losowego wezla(obliczanie współżednych: "+korzen.getPoczatekDostepnegoMiejsca()+" "+korzen.getKoniecDostepnegoMiejsca()+" "+n2.getX());


               Drzewo<String> drzewo = new Drzewo<String>(korzen);
            drzewo.preOrder(korzen);
            System.out.println("test działania głębokość drzewa: "+drzewo.getHeight(drzewo.getKorzen()));

            System.out.println("Czy liść: "+drzewo.getKorzen().czyLisc());
            System.out.println("Czy liść: "+n4.getLiczbaDzieci());
            okno.obliczanieWspozednychY(korzen,okno.getHeight()/(drzewo.getHeight(drzewo.getKorzen())+2),drzewo,korzen);
            System.out.println("Test obliczania y: "+n1.getY());
            System.out.println("Czy liść: "+n4.getLiczbaDzieci());
           okno.rysujDrzewo(korzen,korzen);
            System.out.println("qqq"+korzen.toString().length());
            */
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

            DrzewoDecyzyjne dd = new DrzewoDecyzyjne();
            Drzewo<String> indukcja = dd.indukcja(klasyfikcaja,atrybuty,null);
            indukcja.getKorzen().setPoczatekDostepnegoMiejsca(0);
            indukcja.getKorzen().setKoniecDostepnegoMiejsca(okno.getWidth());
            okno.obliczanieWspozednych(indukcja.getKorzen(),indukcja.getKorzen());
            okno.obliczanieWspozednychY(indukcja.getKorzen(),okno.getHeight()/(indukcja.getHeight(indukcja.getKorzen())+2),indukcja,indukcja.getKorzen());
            okno.rysujDrzewo(indukcja.getKorzen(),indukcja.getKorzen());
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
         else if(label.equals("Zapisz plik"))
        {
            zapiszPlik();
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
    private void zapiszPlik(){
        JFileChooser zapisz= new JFileChooser();
        FileNameExtensionFilter filtr = new FileNameExtensionFilter("TXT Files", "txt");
        zapisz.setFileFilter(filtr);
        int wynik = zapisz.showSaveDialog(this);
        if (wynik == JFileChooser.APPROVE_OPTION)
        {
            sciezkaDoPliku = zapisz.getSelectedFile().getPath();
        }
    }
}
