
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
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
    JPopupMenu popupMenu, popupMenu2;
    JMenuItem wyczysc;
    JMenuItem zapisz;
    JMenuItem zamkn;
    JMenuItem wyczysc2;
    JMenuItem zapisz2;
    JMenuItem dodaj;
    boolean czyPrawyPanel = false;

    public Okno()  {
        wyswietlanie.setOkno(this);
        f= new JFrame("PogodynkaAI v.0.2");
        //ustawienie standardowej akcji po naciśnięciu przycisku zamkniecia
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //blokada zmiany rozmiaru okna
        f.setResizable (false);
        //rozmieszczenie elementow - menadzer rozkladu
        //FlowLayout ustawia elementy jeden za drugim
        //w tym przypadku dodatkowo wysrodkowane na ekranie, z odstępem w pionie i poziomie

        p = new JPanel(new BorderLayout(5,5));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        p2.setBorder(new TitledBorder(
                new TitledBorder(
                        LineBorder.createGrayLineBorder(),
                        "Dane"),
                "",
                TitledBorder.RIGHT,
                TitledBorder.BOTTOM));

        p.add(menu, BorderLayout.NORTH);
        p.add(new JScrollPane(wyswietlanie), BorderLayout.CENTER);

        popupMenu = new JPopupMenu();
        wyczysc = new JMenuItem("Wyczyść");
        wyczysc.setActionCommand("Wyczyść");
        zapisz = new JMenuItem("Zapisz obrazek");
        zapisz.setActionCommand("Zapisz obrazek");
        zamkn= new JMenuItem("Zamknij");
        zamkn.setActionCommand("Zamknij");
        popupMenu.add(wyczysc);
        popupMenu.add(zapisz);
        popupMenu.add(zamkn);

        popupMenu2 = new JPopupMenu();
        wyczysc2 = new JMenuItem("Wyczyść tabele");
        wyczysc2.setActionCommand("Wyczyść tabele");
        zapisz2 = new JMenuItem("Zapisz do pliku");
        zapisz2.setActionCommand("Zapisz do pliku");
        dodaj = new JMenuItem("Dodaj do tabeli ");
        dodaj.setActionCommand("Dodaj do tabeli");
        popupMenu2.add(wyczysc2);
        popupMenu2.add(zapisz2);
        popupMenu2.add(dodaj);

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
        zapisz2.addActionListener(this);
        zamkn.addActionListener(this);
        wyswietlanie.zmien_nazweMenuItem.addActionListener(this);
        wyswietlanie.usun_MenuItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String label = e.getActionCommand(); //M.Majzner zamienil na zrodlo linia nizej. NOTICE: bardziej pro
         Object zrodlo = e.getSource();
        if(zrodlo==menu.wyś){
            wyswietlanie.wyczysc();

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
                 JOptionPane.showMessageDialog(null, "Dane wejściowe wczytane poprawnie.");
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
                 
                  tabelaWyswietl.addMouseListener(new MouseAdapter() {
                      public void mouseReleased(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {
                    popupMenu2.show(tabelaWyswietl, e.getX(), e.getY());
                }
            }
        });
            }
            else if (!spr) {
                //JOptionPane.showMessageDialog(null, "Nie wczytałeś pliku.");
            }
        }
       /*  else if (zrodlo==menu.show_klasyfikacja){
           if(daneWejsciowe ==null){
              JOptionPane.showMessageDialog(null, "Nie wczytałeś klasyfikacji z pliku.");
            }
           else{wyswietlanie.show_klasyfikacja(daneWejsciowe);
            }
        }*/
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
        else if(zrodlo==menu.save||zrodlo==zapisz2)
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

    public void dopasujSieDoZawartosci()
    {
        //dostosowanie okna do zawartości
        pack();
        //wyśrodkowanie ramki
        setLocationRelativeTo(null);
    }

    private boolean otworzPlik(){
        JFileChooser otworz= new JFileChooser();

        FileNameExtensionFilter filtrCSV = new FileNameExtensionFilter("Pliki CSV", "csv");
        FileNameExtensionFilter filtr = new FileNameExtensionFilter("Pliki TXT", "txt");
         otworz.addChoosableFileFilter(filtr);
         otworz.addChoosableFileFilter(filtrCSV);
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
        FileNameExtensionFilter filtr = new FileNameExtensionFilter("Pliki TXT", "txt");
        FileNameExtensionFilter filtrCSV = new FileNameExtensionFilter("Pliki CSV", "csv");

        zapisz.addChoosableFileFilter(filtr);
        zapisz.addChoosableFileFilter(filtrCSV);
        zapisz.setFileFilter(filtrCSV);

        int wynik = zapisz.showSaveDialog(this);
        if (wynik == JFileChooser.APPROVE_OPTION)
        {
            sciezkaDoPliku = zapisz.getSelectedFile().getAbsolutePath();
            try {
            if(zapisz.getFileFilter() == filtrCSV)
                Zapis.zapisDoPlkiu((ElementDrzewa[][])daneWejsciowe.get_klasyfikacja(),sciezkaDoPliku,"csv");
            else if(zapisz.getFileFilter()== filtr)
                Zapis.zapisDoPlkiu((ElementDrzewa[][])daneWejsciowe.get_klasyfikacja(),sciezkaDoPliku,"txt");

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

    public void setDaneWejsciowe(DaneWejsciowe daneWejsciowe){
        this.daneWejsciowe = daneWejsciowe;
    }
}
