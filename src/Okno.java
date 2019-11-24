import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.LinkedList;

public class Okno extends JFrame implements ActionListener {
    Menuski menu = new Menuski();
    Wyswietlanie wyswietlanie = new Wyswietlanie();
    String sciezkaDoPliku;
    Drzewo<ElementDrzewa> wczytywanie;
    Drzewo<ElementDrzewa> zapis;
    ElementDrzewa[][] przyklad;
    Drzewo drzewo;
    DaneWejsciowe daneWejsciowe = null;
    DaneWejsciowe daneWejsciowe2 = null;
    String puste = "null";
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
    JMenuItem pokaz;
    JLabel label;
    LinkedList lista = new LinkedList();
    boolean czyPrawyPanel = false;

    public Okno() {
        wyswietlanie.setOkno(this);
        f = new JFrame("PogodynkaAI v.0.2");
        //ustawienie standardowej akcji po naciśnięciu przycisku zamkniecia
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //blokada zmiany rozmiaru okna
        f.setResizable(false);
        //rozmieszczenie elementow - menadzer rozkladu
        //FlowLayout ustawia elementy jeden za drugim
        //w tym przypadku dodatkowo wysrodkowane na ekranie, z odstępem w pionie i poziomie

        p = new JPanel(new BorderLayout(5, 5));
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
        zamkn = new JMenuItem("Zamknij");
        zamkn.setActionCommand("Zamknij");
        popupMenu.add(wyczysc);
        popupMenu.add(zapisz);
        popupMenu.add(zamkn);

        popupMenu2 = new JPopupMenu();
        wyczysc2 = new JMenuItem("Ukryj Tabelę");
        wyczysc2.setActionCommand("Ukryj tabele");
        zapisz2 = new JMenuItem("Zapisz do pliku");
        zapisz2.setActionCommand("Zapisz do pliku");
        dodaj = new JMenuItem("Dodaj do tabeli ");
        dodaj.setActionCommand("Dodaj do tabeli");
        popupMenu2.add(wyczysc2);
        // popupMenu2.add(pokaz);
        popupMenu2.add(zapisz2);
        popupMenu2.add(dodaj);

        wyswietlanie.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
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

    private void ustawNasluchZdarzen() {
        menu.wyś.addActionListener(this);
        menu.zal.addActionListener(this);
        menu.wycz.addActionListener(this);
        menu.zam.addActionListener(this);
        menu.cred.addActionListener(this);
        menu.save.addActionListener(this);
        menu.tree.addActionListener(this);
        menu.rekord3.addActionListener(this);
        menu.klasyfikacja_z_pliku.addActionListener(this);
        menu.klasyfikacja_z_pliku2.addActionListener(this);
        menu.show_klasyfikacja.addActionListener(this);
        menu.decyzja_okno.addActionListener(this);
        menu.jpeg.addActionListener(this);
        menu.show_klasyfikacja.addActionListener(this);
        menu.glebokoscrekord.addActionListener(this);
        menu.skalowanie.addActionListener(this);
        menu.pokaz.addActionListener(this);
        wyczysc.addActionListener(this);
        zapisz.addActionListener(this);
        zapisz2.addActionListener(this);
        wyczysc2.addActionListener(this);
        zamkn.addActionListener(this);
        wyswietlanie.zmien_nazweMenuItem.addActionListener(this);
        wyswietlanie.usun_MenuItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand(); //M.Majzner zamienil na zrodlo linia nizej. NOTICE: bardziej pro
        Object zrodlo = e.getSource();
        if (zrodlo == menu.wyś) {
            wyswietlanie.wyczysc();
            ukryjTabele();
            if (daneWejsciowe != null) {
                DrzewoDecyzyjne dd = new DrzewoDecyzyjne(daneWejsciowe);
                Drzewo<ElementDrzewa> indukcja = dd.indukcja((ElementDrzewa[][]) daneWejsciowe.getZbiorUczacy(), daneWejsciowe.get_klasyfikacja_atrybuty(), null);
                zapis = indukcja;
                lista = new LinkedList();
                LinkedList listaT = new LinkedList();
                //lista = wyswietlanie.dajWezly(indukcja.getKorzen(), listaT);

                System.out.println();
                wyswietlanie.sprawdzTestowy(indukcja.getKorzen());
                wyswietlanie.getDecyzja(indukcja.getKorzen());
                indukcja.getKorzen().setPoczatekDostepnegoMiejsca(0);
                indukcja.getKorzen().setKoniecDostepnegoMiejsca(wyswietlanie.getWidth());
                wyswietlanie.obliczanieWspozednych(indukcja.getKorzen(), indukcja.getKorzen());
                wyswietlanie.obliczanieWspozednychY(indukcja.getKorzen(), wyswietlanie.getHeight() / (indukcja.getHeight(indukcja.getKorzen()) + 2), indukcja, indukcja.getKorzen());
                wyswietlanie.rysujDrzewo(indukcja.getKorzen(), indukcja.getKorzen());
                wyswietlanie.rysujPrzyciski(wyswietlanie.listaButton);
            }
        } else if (zrodlo == menu.decyzja_okno) {
            if (daneWejsciowe != null) {

                try {
                    TableRenderDemo.createAndShowGUI(daneWejsciowe);
                } catch (Exception de) {
                    JOptionPane.showMessageDialog(null, "Nie wczytałeś klasyfikacji.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error.");
            }
        } else if (zrodlo == menu.glebokoscrekord) {

            menu.glebokoscrekord.addKeyListener(new KeyListener() {
                public void keyTyped(KeyEvent e) {

                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        //String  s = menu.rekord2.getText();
                        //JOptionPane.showMessageDialog(null, s);
                        //pobieranie tekstu wpisanego i potwierdzenie go enterem.
                        //String s = menu.rekord.getText();
                        //System.out.println(s);
                    }
                }

                public void keyReleased(java.awt.event.KeyEvent evt) {

                    //int s = Integer.parseInt(menu.rekord2.getText());

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        boolean close = true;
                        boolean close2 = true;
                        String m = menu.glebokoscrekord.getText();
                        try {
                            int s = Integer.parseInt(menu.glebokoscrekord.getText());
                            menu.glebokoscrekord.setEnabled(false);
                            menu.glebokoscrekord.setText("");
                            menu.glebokoscrekord.setEnabled(true);
                            close = false;
                            if (s <= 0 && close == true) {

                                JOptionPane.showMessageDialog(f, "Głebokość nie może być na minusie lub zerowa");
                                // JOptionPane("Hello world", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);


                            }
                            //int s = Integer.parseInt(menu.rekord2.getText());
                            else {
                                System.out.println(menu.rekord2.getText());
                                System.out.println("Cyfra : " + Integer.parseInt(menu.rekord2.getText()));
                                //PodzialUczTest.losowanietest(s, daneWejsciowe);
                                //PodzialUczTest.losowanieucz(s, daneWejsciowe);
                                wyswietlanie.wyczysc();
                                if (daneWejsciowe != null) {

                                } else if (daneWejsciowe == null) {
                                    menu.glebokoscrekord.setEnabled(false);
                                    menu.glebokoscrekord.setText("");
                                    menu.glebokoscrekord.setEnabled(true);
                                    close = false;

                                    //JOptionPane.showMessageDialog(f,"Nie podałeś liczby rekordów");
                                }

                            }

                        } catch (NumberFormatException ee) {
                            if (close == true) {
                                JOptionPane.showMessageDialog(f, "Błędnie określona głębokość");

                                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                    menu.glebokoscrekord.setEnabled(false);
                                    menu.glebokoscrekord.setText("");
                                    menu.glebokoscrekord.setEnabled(true);

                                }

                            }

                        }


                    }}});
        } else if (zrodlo == menu.zal) {
            boolean spr = otworzPlik();
            if (spr) {
                wczytywanie = Wczytywanie.wczytajDrzewoZPliku(sciezkaDoPliku);
                drzewo = new Drzewo(wczytywanie.getKorzen());
            } else if (!spr) {
                JOptionPane.showMessageDialog(null, "Nie wczytałeś pliku.");
            }
        } else if (zrodlo == wyczysc2) {
           ukryjTabele();
        } else if (zrodlo == menu.klasyfikacja_z_pliku) {
            boolean spr = otworzPlik();
            if (spr) {
                p.remove(p2);
                daneWejsciowe = Wczytywanie.wczytajKlasyfikacjeZPliku(sciezkaDoPliku);
                if (!menu.rekord2.getText().equals("")) {
                    if (Integer.parseInt(menu.rekord2.getText()) > 0 && Integer.parseInt(menu.rekord2.getText()) <= daneWejsciowe.get_klasyfikacja().length - 1) {
                        daneWejsciowe.podzialZbioru(Integer.parseInt(menu.rekord2.getText()));
                    } else {
                        int ilosc = daneWejsciowe.get_klasyfikacja().length;
                        daneWejsciowe.podzialZbioru(ilosc / 2);
                    }
                } else {
                    int ilosc = daneWejsciowe.get_klasyfikacja().length;
                    daneWejsciowe.podzialZbioru(ilosc / 2);
                }

                JOptionPane.showMessageDialog(null, "Dane wejściowe wczytane poprawnie.");
                Tabela tabela = new Tabela(daneWejsciowe.get_klasyfikacja());
                Tabela tabelaZbiorUczacy = new Tabela(daneWejsciowe.getZbiorUczacy());
                Tabela tabelaZbiorTestowy = new Tabela(daneWejsciowe.getZbiorTestowy());
                JTable tabelaWyswietl = tabela.getTabela();
                JTable tabelaWyswietlZbiorUczacy = tabelaZbiorUczacy.getTabela();
                JTable tabelaWyswietlZbiorTestowy = tabelaZbiorTestowy.getTabela();
                tabelaWyswietl.setFillsViewportHeight(true);
                p2 = new JPanel();
                JTabbedPane tabelaDane = new JTabbedPane();
                tabelaDane.addTab("Dane",new JScrollPane(tabelaWyswietl));
                tabelaDane.addTab("Uczący",new JScrollPane(tabelaWyswietlZbiorUczacy));
                tabelaDane.addTab("Testowy",new JScrollPane(tabelaWyswietlZbiorTestowy));
                /*tabelaWyswietl.setBorder(new TitledBorder(
                        new TitledBorder(
                                LineBorder.createGrayLineBorder(),
                                "Dane"),
                        "",
                        TitledBorder.RIGHT,
                        TitledBorder.BOTTOM));*/
                p2.add(tabelaDane);
                p2.setMaximumSize(new Dimension(500, 500));
                p.add(p2, BorderLayout.EAST);
                dopasujSieDoZawartosci();
                f.setVisible(true);
                czyPrawyPanel = true;

                tabelaWyswietl.addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            popupMenu2.show(tabelaWyswietl, e.getX(), e.getY());
                        }
                    }
                });
                tabelaWyswietlZbiorUczacy.addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            popupMenu2.show(tabelaWyswietlZbiorUczacy, e.getX(), e.getY());
                        }
                    }
                });
                tabelaWyswietlZbiorTestowy.addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            popupMenu2.show(tabelaWyswietlZbiorTestowy, e.getX(), e.getY());
                        }
                    }
                });
            } else if (!spr) {
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
    else if (zrodlo == menu.klasyfikacja_z_pliku2) {
            boolean spr = otworzPlik();
            if (spr) {

                daneWejsciowe2 = Wczytywanie.wczytajKlasyfikacjeZPliku(sciezkaDoPliku);


            }
        }
        else if (zrodlo == menu.wycz || zrodlo == wyczysc) {
            wyswietlanie.wyczysc();

        } else if (zrodlo == menu.pokaz) {
            p.remove(p2);
            Tabela tabela = new Tabela(daneWejsciowe.get_klasyfikacja());
            Tabela tabelaZbiorUczacy = new Tabela(daneWejsciowe.getZbiorUczacy());
            Tabela tabelaZbiorTestowy = new Tabela(daneWejsciowe.getZbiorTestowy());
            Tabela tabelaZbiorDecyzja = new Tabela(daneWejsciowe2.get_klasyfikacja());
            JTable tabelaWyswietl = tabela.getTabela();
            JTable tabelaWyswietlZbiorUczacy = tabelaZbiorUczacy.getTabela();
            JTable tabelaWyswietlZbiorTestowy = tabelaZbiorTestowy.getTabela();
            JTable tabelaWyswietlDecyzje = tabelaZbiorDecyzja.getTabela(); //poprawić nazwy
            tabelaWyswietl.setFillsViewportHeight(true);
            p2 = new JPanel();
            JTabbedPane tabelaDane = new JTabbedPane();
            tabelaDane.addTab("Dane",new JScrollPane(tabelaWyswietl));
            tabelaDane.addTab("Uczący",new JScrollPane(tabelaWyswietlZbiorUczacy));
            tabelaDane.addTab("Testowy",new JScrollPane(tabelaWyswietlZbiorTestowy));
            tabelaDane.addTab("Decyzja",new JScrollPane(tabelaWyswietlDecyzje));
            p2.add(tabelaDane);
            p2.setMaximumSize(new Dimension(500, 500));
            p.add(p2, BorderLayout.EAST);
            dopasujSieDoZawartosci();
            f.setVisible(true);
            czyPrawyPanel = true;

            tabelaWyswietl.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        popupMenu2.show(tabelaWyswietl, e.getX(), e.getY());
                    }
                }
            });
            tabelaWyswietlZbiorUczacy.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        popupMenu2.show(tabelaWyswietlZbiorUczacy, e.getX(), e.getY());
                    }
                }
            });
            tabelaWyswietlZbiorTestowy.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        popupMenu2.show(tabelaWyswietlZbiorTestowy, e.getX(), e.getY());
                    }
                }
            });
            tabelaWyswietlZbiorTestowy.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        popupMenu2.show(tabelaWyswietlDecyzje, e.getX(), e.getY());
                    }
                }
            });
        } else if (zrodlo == menu.wycz) {
            wyswietlanie.wyczysc();

        } else if (zrodlo == menu.cred) {
            wyswietlanie.credits();
        } else if (zrodlo == menu.zam || zrodlo == zamkn) {
            System.exit(0);
        } else if (zrodlo == menu.save || zrodlo == zapisz2) {
            zapiszPlik();
        } else if (zrodlo == menu.tree) {
            zapiszPlikDrzewa();
        } else if (zrodlo == menu.rekord3) {

            boolean close = true;
            boolean close2 = true;
            String m = menu.rekord2.getText();
            wyswietlanie.wyczysc();
            ukryjTabele();
            if (daneWejsciowe != null) {
                if (!menu.rekord2.getText().equals("")) {
                    if (Integer.parseInt(menu.rekord2.getText()) > 0 && Integer.parseInt(menu.rekord2.getText()) <= daneWejsciowe.get_klasyfikacja().length - 1) {
                        daneWejsciowe.podzialZbioru(Integer.parseInt(menu.rekord2.getText()));
                    } else {
                        int ilosc = daneWejsciowe.get_klasyfikacja().length;
                        daneWejsciowe.podzialZbioru(ilosc / 2);
                    }
                } else {
                    int ilosc = daneWejsciowe.get_klasyfikacja().length;
                    daneWejsciowe.podzialZbioru(ilosc / 2);
                }
                DrzewoDecyzyjne dd = new DrzewoDecyzyjne(daneWejsciowe);
                Drzewo<ElementDrzewa> indukcja = dd.indukcja((ElementDrzewa[][]) daneWejsciowe.getZbiorUczacy(), daneWejsciowe.get_klasyfikacja_atrybuty(), null);
                zapis = indukcja;
                indukcja.getKorzen().setPoczatekDostepnegoMiejsca(0);
                indukcja.getKorzen().setKoniecDostepnegoMiejsca(wyswietlanie.getWidth());
                wyswietlanie.obliczanieWspozednych(indukcja.getKorzen(), indukcja.getKorzen());
                wyswietlanie.obliczanieWspozednychY(indukcja.getKorzen(), wyswietlanie.getHeight() / (indukcja.getHeight(indukcja.getKorzen()) + 2), indukcja, indukcja.getKorzen());
                wyswietlanie.rysujDrzewo(indukcja.getKorzen(), indukcja.getKorzen());
                wyswietlanie.rysujPrzyciski(wyswietlanie.listaButton);
            }




        } else if (zrodlo == menu.jpeg || zrodlo == zapisz) {
            try {
                Zapis.save_jpeg();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (zrodlo == menu.skalowanie) {
            wyswietlanie.wyczysc();

            if (daneWejsciowe != null) {
                DrzewoDecyzyjne dd = new DrzewoDecyzyjne(daneWejsciowe);
                Drzewo<ElementDrzewa> indukcja = dd.indukcja((ElementDrzewa[][]) daneWejsciowe.getZbiorUczacy(), daneWejsciowe.get_klasyfikacja_atrybuty(), null);
                zapis = indukcja;
                indukcja.getKorzen().setPoczatekDostepnegoMiejsca(0);
                indukcja.getKorzen().setKoniecDostepnegoMiejsca(wyswietlanie.getWidth());
                wyswietlanie.obliczanieWspozednych(indukcja.getKorzen(), indukcja.getKorzen());
                //wyswietlanie.getHeight() wysokosc
                //indukcja.getHeight(indukcja.getKorzen()
                wyswietlanie.obliczanieWspozednychY(indukcja.getKorzen(), wyswietlanie.getHeight() / (indukcja.getHeight(indukcja.getKorzen()) + 2), indukcja, indukcja.getKorzen());
                wyswietlanie.rysujSkalowanie(indukcja.getKorzen(), indukcja.getKorzen());
                wyswietlanie.rysujPrzyciski(wyswietlanie.listaButton);


            } else if (zrodlo == menu.jpeg || zrodlo == zapisz) {
                try {
                    Zapis.save_jpeg();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }


    }

    public void dopasujSieDoZawartosci() {
        //dostosowanie okna do zawartości
        pack();
        //wyśrodkowanie ramki
        setLocationRelativeTo(null);
    }

    private boolean otworzPlik() {
        JFileChooser otworz = new JFileChooser();

        FileNameExtensionFilter filtrCSV = new FileNameExtensionFilter("Pliki CSV", "csv");
        FileNameExtensionFilter filtr = new FileNameExtensionFilter("Pliki TXT", "txt");
        otworz.addChoosableFileFilter(filtr);
        otworz.addChoosableFileFilter(filtrCSV);
        otworz.setFileFilter(filtrCSV);

        otworz.setAcceptAllFileFilterUsed(false);
        int wynik = otworz.showOpenDialog(this);
        boolean check = false;
        if (wynik == JFileChooser.APPROVE_OPTION) {
            sciezkaDoPliku = otworz.getSelectedFile().getPath();
            check = true;
        }
        return check;
    }

    private void zapiszPlik() {
        JFileChooser zapisz = new JFileChooser();
        FileNameExtensionFilter filtr = new FileNameExtensionFilter("Pliki TXT", "txt");
        FileNameExtensionFilter filtrCSV = new FileNameExtensionFilter("Pliki CSV", "csv");

        zapisz.addChoosableFileFilter(filtr);
        zapisz.addChoosableFileFilter(filtrCSV);
        zapisz.setFileFilter(filtrCSV);

        int wynik = zapisz.showSaveDialog(this);
        if (wynik == JFileChooser.APPROVE_OPTION) {
            sciezkaDoPliku = zapisz.getSelectedFile().getAbsolutePath();
            try {
                if (zapisz.getFileFilter() == filtrCSV)
                    Zapis.zapisDoPlkiu((ElementDrzewa[][]) daneWejsciowe.get_klasyfikacja(), sciezkaDoPliku, "csv");
                else if (zapisz.getFileFilter() == filtr)
                    Zapis.zapisDoPlkiu((ElementDrzewa[][]) daneWejsciowe.get_klasyfikacja(), sciezkaDoPliku, "txt");

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    private void zapiszPlikDrzewa() {
        JFileChooser zapisz = new JFileChooser();
        FileNameExtensionFilter filtr = new FileNameExtensionFilter("TXT Files", "txt");
        zapisz.setFileFilter(filtr);
        int wynik = zapisz.showSaveDialog(this);
        if (wynik == JFileChooser.APPROVE_OPTION) {
            sciezkaDoPliku = zapisz.getSelectedFile().getPath();
            try {

                Zapis.zapiszDrzewoDoPliku(sciezkaDoPliku, zapis);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    public void setDaneWejsciowe(DaneWejsciowe daneWejsciowe) {
        this.daneWejsciowe = daneWejsciowe;
    }

    public void ukryjTabele(){
        p.remove(p2);
        //Tabela tabela = new Tabela();
        //JTable tabelaWyswietl = tabela.getTabela();
        p2 = new JPanel();
        //p2.add(new JScrollPane(tabela));
        p2.setBorder(new TitledBorder(
                new TitledBorder(
                        LineBorder.createGrayLineBorder(),
                        "Tabela"),
                "",
                TitledBorder.RIGHT,
                TitledBorder.BOTTOM));
        p2.setMaximumSize(new Dimension(500, 500));
        p.add(p2, BorderLayout.EAST);
        dopasujSieDoZawartosci();
        f.setVisible(true);
        czyPrawyPanel = true;
    }
}