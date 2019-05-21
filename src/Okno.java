
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Okno extends JFrame implements ActionListener
{
    Menuski menu = new Menuski();
    Wyswietlanie wyswietlanie = new Wyswietlanie();
    String sciezkaDoPliku;
    Drzewo<ElementDrzewa> wczytywanie;
    Drzewo<ElementDrzewa> zapis;
    ElementDrzewa[][] przyklad;
    Drzewo drzewo;
    DaneWejsciowe daneWejsciowe = null;
    String puste= "null";
    JPanel p;
    JPanel p2 = new JPanel();
    JFrame f;
    JPopupMenu popupMenu;
    JMenuItem wyczysc;
    JMenuItem zapisz;
    JMenuItem zamkn;
    boolean czyPrawyPanel = false;

    public Okno()  {

        f= new JFrame("Projekt Zespołowy - drzewo decyzyjne");
        //ustawienie standardowej akcji po naciśnięciu przycisku zamkniecia
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //blokada zmiany rozmiaru okna
        f.setResizable (false);
        //rozmieszczenie elementow - menadzer rozkladu
        //FlowLayout ustawia elementy jeden za drugim
        //w tym przypadku dodatkowo wysrodkowane na ekranie, z odstępem w pionie i poziomie
        //setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        p = new JPanel(new BorderLayout(5,5));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //ustawienie stworzonego menu
        //f.setJMenuBar(menu);
        //dodanie paneli
        //f.add(wyswietlanie);
        //JLabel test1 = new JLabel("test1test1");
        //JLabel test2 = new JLabel("test2test1");
        p2.setBorder(new TitledBorder(
                new TitledBorder(
                        LineBorder.createGrayLineBorder(),
                        "Dane"),
                "",
                TitledBorder.RIGHT,
                TitledBorder.BOTTOM));

        p.add(menu, BorderLayout.NORTH);
        p.add(wyswietlanie, BorderLayout.CENTER);
        //p2.add(test1,BorderLayout.EAST);
        //p2.add(test2,BorderLayout.EAST);
        //p.add(p2,BorderLayout.EAST);

        //p.setBackground(Color.white);
        popupMenu = new JPopupMenu();
        wyczysc = new JMenuItem("Wyczyść");
        wyczysc.setActionCommand("Wyczyść");
        zapisz = new JMenuItem("Zapisz Obłazek");
        zapisz.setActionCommand("Zapisz Obłazek");
        zamkn= new JMenuItem("Zamknij");
        zamkn.setActionCommand("Zamknij");
        popupMenu.add(wyczysc);
        popupMenu.add(zapisz);
        popupMenu.add(zamkn);



        wyswietlanie.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(wyswietlanie, e.getX(), e.getY());
                }
            }
        });




        //przypisanie obsługi akcji
        ustawNasluchZdarzen();        
        dopasujSieDoZawartosci();
        //wyswietlenie naszej ramki

        f.setVisible(true);
        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(1200, 700);

        //f.show();
    }

    private void ustawNasluchZdarzen()
    {
        menu.wyś.addActionListener(this);
        menu.zal.addActionListener(this);
        menu.wycz.addActionListener(this);
        menu.zam.addActionListener(this);
        menu.cred.addActionListener(this);
        menu.save.addActionListener(this);
        menu.tree.addActionListener(this);
        menu.klasyfikacja_z_pliku.addActionListener(this);
        menu.show_klasyfikacja.addActionListener(this);
        menu.jpeg.addActionListener(this);
        wyczysc.addActionListener(this);
        zapisz.addActionListener(this);
        zamkn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String label = e.getActionCommand(); //M.Majzner zamienil na zrodlo linia nizej. NOTICE: bardziej pro
         Object zrodlo = e.getSource();
        if(zrodlo==menu.wyś){
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
            korzen.setKoniecDostepnegoMiejsca(wyswietlanie.getWidth());
            wyswietlanie.obliczanieWspozednych(korzen,korzen);
            System.out.println("Test losowego wezla(obliczanie współżednych: "+korzen.getPoczatekDostepnegoMiejsca()+" "+korzen.getKoniecDostepnegoMiejsca()+" "+n2.getX());

            Drzewo<String> drzewo = new Drzewo<String>(korzen);
            drzewo.preOrder(korzen);
            System.out.println("test działania głębokość drzewa: "+drzewo.getHeight(drzewo.getKorzen()));

            System.out.println("Czy liść: "+drzewo.getKorzen().czyLisc());
            System.out.println("Czy liść: "+n4.getLiczbaDzieci());
            wyswietlanie.obliczanieWspozednychY(korzen,wyswietlanie.getHeight()/(drzewo.getHeight(drzewo.getKorzen())+2),drzewo,korzen);
            System.out.println("Test obliczania y: "+n1.getY());
            System.out.println("Czy liść: "+n4.getLiczbaDzieci());
            wyswietlanie.rysujDrzewo(korzen,korzen);
            System.out.println("qqq"+korzen.toString().length());
             */
            /*String[] atrybuty = {"Outlook","Humidity","Wind"};

            String[][] klasyfikacja = {{"Day","Outlook","Humidity","Wind","Decision"},
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
                };*/
            /*if(klasyfikacja!=null) {
                //Klasyfikacja klasyfikacjaZPliku = new Klasyfikacja("src/test_klasyfikacji.txt");
                String[][] klasyfikacjaTablica = klasyfikacja.get_klasyfikacja();
                String[] atrybuty = new String[klasyfikacjaTablica[0].length - 2];
                int j = 0;
                for (int i = 1; i < klasyfikacjaTablica[0].length - 1; i++) {
                    atrybuty[j] = klasyfikacjaTablica[0][i];
                    j++;
                }

                DrzewoDecyzyjne dd = new DrzewoDecyzyjne();
                Drzewo<String> indukcja = dd.indukcja(klasyfikacjaTablica, atrybuty, null);
                indukcja.getKorzen().setPoczatekDostepnegoMiejsca(0);
                indukcja.getKorzen().setKoniecDostepnegoMiejsca(wyswietlanie.getWidth());
                wyswietlanie.obliczanieWspozednych(indukcja.getKorzen(), indukcja.getKorzen());
                wyswietlanie.obliczanieWspozednychY(indukcja.getKorzen(), wyswietlanie.getHeight() / (indukcja.getHeight(indukcja.getKorzen()) + 2), indukcja, indukcja.getKorzen());
                wyswietlanie.rysujDrzewo(indukcja.getKorzen(), indukcja.getKorzen());
            }*/
            /*Atrybut[] atrybuty = {new Atrybut("Outlook"),new Atrybut("Humidity"),new Atrybut("Wind")};
            ElementDrzewa[][] przyklady = {
                    {new Atrybut("Outlook"),new Atrybut("Humidity"),new Atrybut("Wind"),new Atrybut()},
                    {new WartoscAtrybutu("Sunny"),new WartoscAtrybutu("High"),new WartoscAtrybutu("Weak"),new Decyzja("No")},
                    {new WartoscAtrybutu("Sunny"),new WartoscAtrybutu("High"),new WartoscAtrybutu("Strong"),new Decyzja("No")},
                    {new WartoscAtrybutu("Overcast"),new WartoscAtrybutu("High"),new WartoscAtrybutu("Weak"),new Decyzja("Yes")},
                    {new WartoscAtrybutu("Rain"),new WartoscAtrybutu("High"),new WartoscAtrybutu("Weak"),new Decyzja("Yes")},
                    {new WartoscAtrybutu("Rain"),new WartoscAtrybutu("Normal"),new WartoscAtrybutu("Weak"),new Decyzja("Yes")},
                    {new WartoscAtrybutu("Rain"),new WartoscAtrybutu("Normal"),new WartoscAtrybutu("Strong"),new Decyzja("No")},
                    {new WartoscAtrybutu("Overcast"),new WartoscAtrybutu("Normal"),new WartoscAtrybutu("Strong"),new Decyzja("Yes")},
                    {new WartoscAtrybutu("Sunny"),new WartoscAtrybutu("High"),new WartoscAtrybutu("Weak"),new Decyzja("No")},
                    {new WartoscAtrybutu("Sunny"),new WartoscAtrybutu("Normal"),new WartoscAtrybutu("Weak"),new Decyzja("Yes")},
                    {new WartoscAtrybutu("Rain"),new WartoscAtrybutu("Normal"),new WartoscAtrybutu("Weak"),new Decyzja("Yes")},
                    {new WartoscAtrybutu("Sunny"),new WartoscAtrybutu("Normal"),new WartoscAtrybutu("Strong"),new Decyzja("Yes")},
                    {new WartoscAtrybutu("Overcast"),new WartoscAtrybutu("High"),new WartoscAtrybutu("Strong"),new Decyzja("Yes")},
                    {new WartoscAtrybutu("Overcast"),new WartoscAtrybutu("Normal"),new WartoscAtrybutu("Weak"),new Decyzja("Yes")},
                    {new WartoscAtrybutu("Rain"),new WartoscAtrybutu("High"),new WartoscAtrybutu("Strong"),new Decyzja("No")}
            };*/
            if(daneWejsciowe!=null) {
                DrzewoDecyzyjne dd = new DrzewoDecyzyjne();
                Drzewo<ElementDrzewa> indukcja = dd.indukcja((ElementDrzewa[][]) daneWejsciowe.get_klasyfikacja(), daneWejsciowe.get_klasyfikacja_atrybuty(), null);
                zapis = indukcja;
                indukcja.getKorzen().setPoczatekDostepnegoMiejsca(0);
                indukcja.getKorzen().setKoniecDostepnegoMiejsca(wyswietlanie.getWidth());
                wyswietlanie.obliczanieWspozednych(indukcja.getKorzen(), indukcja.getKorzen());
                wyswietlanie.obliczanieWspozednychY(indukcja.getKorzen(), wyswietlanie.getHeight() / (indukcja.getHeight(indukcja.getKorzen()) + 2), indukcja, indukcja.getKorzen());
                wyswietlanie.rysujDrzewo(indukcja.getKorzen(), indukcja.getKorzen());
                wyswietlanie.rysujPrzyciski(wyswietlanie.listaButton);
            }
        }

        else if(zrodlo==menu.zal) {
            boolean spr = otworzPlik();
            if (spr) {
                wczytywanie = Wczytywanie.wczytajDrzewoZPliku(sciezkaDoPliku);
                drzewo = new Drzewo(wczytywanie.getKorzen());
            }
            else if (!spr) {
                JOptionPane.showMessageDialog(null, "Nie wczytałeś pliku.");
            }
        }
         else if(zrodlo==menu.klasyfikacja_z_pliku) {
            boolean spr = otworzPlik();
            if (spr) {
                daneWejsciowe = Wczytywanie.wczytajKlasyfikacjeZPliku(sciezkaDoPliku);
                 JOptionPane.showMessageDialog(null, "Klasyfikacja wczytana poprawnie.");
                 Tabela tabela = new Tabela(daneWejsciowe.get_klasyfikacja());
                 JTable tabelaWyswietl = tabela.getTabela();
                 tabelaWyswietl.setFillsViewportHeight(true);
                 p2 = new JPanel();
                 p2.add(new JScrollPane(tabelaWyswietl));
                 p2.setBorder(new TitledBorder(
                         new TitledBorder(
                                 LineBorder.createGrayLineBorder(),
                                 "Dane"),
                         "",
                         TitledBorder.RIGHT,
                         TitledBorder.BOTTOM));
                 p2.setMaximumSize(new Dimension(500, 500));
                 p.add(p2, BorderLayout.EAST);
                 dopasujSieDoZawartosci();
                 f.setVisible(true);
                 czyPrawyPanel = true;
            }
            else if (!spr) {
                JOptionPane.showMessageDialog(null, "Nie wczytałeś pliku.");
            }
        }
         else if (zrodlo==menu.show_klasyfikacja){
           if(daneWejsciowe ==null){
              JOptionPane.showMessageDialog(null, "Nie wczytałeś klasyfikacji z pliku.");
            }
           else{wyswietlanie.show_klasyfikacja(daneWejsciowe);
            }
        }
         else if (zrodlo==menu.wycz||zrodlo==wyczysc){
            wyswietlanie.wyczysc();

        }
        else if (zrodlo==menu.wycz){
            wyswietlanie.wyczysc();

        }
        else if (zrodlo==menu.cred){
            wyswietlanie.credits();
        }
        else if (zrodlo==menu.zam||zrodlo==zamkn){
            System.exit(0);
        }
        else if(zrodlo==menu.save)
        {
            zapiszPlik();
        }
        else if(zrodlo==menu.tree)
        {
            zapiszPlikDrzewa();
        }
        else if (zrodlo==menu.jpeg||zrodlo==zapisz){
            try {
                Zapis.save_jpeg();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
         otworz.setFileFilter(filtrCSV);
        otworz.setFileFilter(filtr);
      
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
            try {

                Zapis.zapisDoPlkiu((ElementDrzewa[][])daneWejsciowe.get_klasyfikacja(),sciezkaDoPliku);
            }catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    private void zapiszPlikDrzewa(){
        JFileChooser zapisz= new JFileChooser();
        FileNameExtensionFilter filtr = new FileNameExtensionFilter("TXT Files", "txt");
        zapisz.setFileFilter(filtr);
        int wynik = zapisz.showSaveDialog(this);
        if (wynik == JFileChooser.APPROVE_OPTION)
        {
            sciezkaDoPliku = zapisz.getSelectedFile().getPath();
            try {

                Zapis.zapiszDrzewoDoPliku(sciezkaDoPliku,zapis);
            }catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }
}
