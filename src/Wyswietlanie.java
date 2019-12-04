import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class Wyswietlanie extends JPanel implements ActionListener {

    static BufferedImage okno;
    JFrame f;
    LinkedList<PrzyciskDrzewo> listaButton = new LinkedList<PrzyciskDrzewo>();
    JPopupMenu popupMenu = new JPopupMenu("Title");
    PrzyciskMenu zmien_nazweMenuItem = new PrzyciskMenu("Zmień nazwę");
    PrzyciskDrzewo dajDroge = new PrzyciskDrzewo("Droga");
    PrzyciskMenu usun_MenuItem = new PrzyciskMenu("Usuń");
    //Wezel wezeldobutton = new Wezel();
    Okno o;
    LinkedList<Wezel> wezly = new LinkedList<>();
    LinkedList<Wezel> wezlyN = new LinkedList<>();
    LinkedList<Wezel> wezlyDroga = new LinkedList<>();


    //konstruktor
    public Wyswietlanie() {
        super();
        //Dynamiczne dopasowanie do ekranu dla 1 monitora
        /*Dimension Rozmiar = Toolkit.getDefaultToolkit().getScreenSize();
        int szerokosc = (int) Rozmiar.getWidth();
        int wysokosc = (int)Rozmiar.getHeight();
        double zajetosc = 0.85;//Ułamek dziesiętny zajętej Wysokości


        //Obliczenia celem optymalnego rozłożenia okna dla danych typów ekranów, tj. 4:3, 5:4, 16:10 oraz 16:9
        if(szerokosc/wysokosc==4/3){

            szerokosc = (int) ((wysokosc*zajetosc)/3)*4;
        }

        else if (szerokosc/wysokosc==5/4) {
            szerokosc = (int) ((wysokosc*zajetosc)/4)*5;
        }
        else if (szerokosc/wysokosc==16/10){
            szerokosc = (int) ((wysokosc*zajetosc)/10)*16;
        }
           else if (szerokosc/wysokosc==16/9){
            szerokosc = (int) ((wysokosc*zajetosc)/9)*16;
        }
           else {
               szerokosc = (int) (szerokosc*zajetosc);
        }

        wysokosc = (int)(wysokosc*zajetosc);*/

        //setLayout(new GridLayout(2,1));
        //ustawRozmiar(new Dimension(szerokosc,wysokosc));
        ustawRozmiar(new Dimension(1920, 1920));
        ustawNasluchZdarzen();
        wyczysc();
    }

    public void wyczysc() {
        this.removeAll();

        listaButton = new LinkedList<PrzyciskDrzewo>();
        //wyrysowanie białego tła
        Graphics2D g = (Graphics2D) okno.getGraphics();
        g.setColor(Color.gray);
        g.fillRect(0, 0, okno.getWidth(), okno.getHeight());
        //ustalenie obramowania
        setBorder(BorderFactory.createLineBorder(Color.gray));
        repaint();
    }

    private void ustawNasluchZdarzen() {
        zmien_nazweMenuItem.addActionListener(this);
        usun_MenuItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        Object zrodlo = e.getSource();
        if (label == "Zmień nazwę") {
            PrzyciskMenu przyciskMenuu = (PrzyciskMenu) zrodlo;
            ElementDrzewa elementDrzewaa = przyciskMenuu.getElement();
            System.out.println("Test: " + elementDrzewaa);
            if (elementDrzewaa != null) {
                String dialgOptionn = JOptionPane.showInputDialog(null, "Podaj nową nazwę: ");
                if (dialgOptionn != null) {
                    System.out.println(dialgOptionn);
                    ElementDrzewa[][] tmp = o.daneWejsciowe.get_klasyfikacja();
                    ElementDrzewa[][] tmpUcz = o.daneWejsciowe.getZbiorUczacy();
                    ElementDrzewa[][] tmpTest = o.daneWejsciowe.getZbiorTestowy();
                    DaneWejsciowe daneWejsciowe = new DaneWejsciowe();
                    if (tmp != null) {
                        for (int i = 0; i < tmp.length; i++) {
                            for (int j = 0; j < tmp[i].length; j++) {
                                if (tmp[i][j].toString().equals(elementDrzewaa.toString())) {
                                    ElementDrzewa tmpp = tmp[i][j];
                                    tmpp.setNazwa(dialgOptionn);
                                    tmp[i][j] = tmpp;
                                }

                            }
                        }
                        daneWejsciowe = new DaneWejsciowe(tmp);
                    }
                    if (tmpUcz != null) {
                        for (int i = 0; i < tmpUcz.length; i++) {
                            for (int j = 0; j < tmpUcz[i].length; j++) {
                                if (tmpUcz[i][j].toString().equals(elementDrzewaa.toString())) {
                                    ElementDrzewa tmpp = tmpUcz[i][j];
                                    tmpp.setNazwa(dialgOptionn);
                                    tmpUcz[i][j] = tmpp;
                                }

                            }
                        }
                        daneWejsciowe.setZbiorUczacy(tmpUcz);
                    }
                    if (tmpTest != null) {
                        for (int i = 0; i < tmpTest.length; i++) {
                            for (int j = 0; j < tmpTest[i].length; j++) {
                                if (tmpTest[i][j].toString().equals(elementDrzewaa.toString())) {
                                    ElementDrzewa tmpp = tmpTest[i][j];
                                    tmpp.setNazwa(dialgOptionn);
                                    tmpTest[i][j] = tmpp;
                                }

                            }
                        }
                        daneWejsciowe.setZbiorTestowy(tmpTest);
                    }
                    daneWejsciowe.opcje();
                    o.setDaneWejsciowe(daneWejsciowe);
                    o.actionPerformed(new ActionEvent(o.menu.wycz, ActionEvent.ACTION_PERFORMED, null));
                    o.actionPerformed(new ActionEvent(o.menu.wyś, ActionEvent.ACTION_PERFORMED, null));
                    Tabela tabela = new Tabela(o.daneWejsciowe.get_klasyfikacja());
                    JTable tabelaWyswietl = tabela.getTabela();
                    tabelaWyswietl.setFillsViewportHeight(true);
                    o.p2 = new JPanel();
                    o.p2.add(new JScrollPane(tabelaWyswietl));
                    o.p2.setBorder(new TitledBorder(
                            new TitledBorder(
                                    LineBorder.createGrayLineBorder(),
                                    "Dane"),
                            "",
                            TitledBorder.RIGHT,
                            TitledBorder.BOTTOM));
                    o.p2.setMaximumSize(new Dimension(500, 500));
                    o.p.add(o.p2, BorderLayout.EAST);
                    o.dopasujSieDoZawartosci();
                    o.f.setVisible(true);
                    o.czyPrawyPanel = true;
                }
            }

        } else if (label == "Usuń") {
            PrzyciskMenu przyciskMenu = (PrzyciskMenu) zrodlo;
            ElementDrzewa elementDrzewa = przyciskMenu.getElement();
            System.out.println("Test: " + elementDrzewa);
            if (elementDrzewa != null) {
                int dialogOption = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunąć element " + elementDrzewa + "?");
                if (dialogOption == JOptionPane.YES_OPTION) {
                    ElementDrzewa[][] tmp = o.daneWejsciowe.get_klasyfikacja();
                    ElementDrzewa[][] tmpUcz = o.daneWejsciowe.getZbiorUczacy();
                    ElementDrzewa[][] tmpTest = o.daneWejsciowe.getZbiorTestowy();
                    DaneWejsciowe daneWejsciowe = new DaneWejsciowe();
                    if (tmp != null) {
                        if (elementDrzewa.getClass().getName().equals("Atrybut")) {
                            int kolumna = 0;
                            for (int i = 0; i < tmp[0].length; i++) {
                                if (tmp[0][i].toString().equals(elementDrzewa.toString())) {
                                    kolumna = i;
                                }
                            }
                            ElementDrzewa[][] nowyTmp = new ElementDrzewa[tmp.length][tmp[0].length - 1];
                            int k = 0;
                            for (int i = 0; i < tmp.length; i++) {
                                for (int j = 0; j < tmp[i].length; j++) {
                                    if (j != kolumna) {
                                        nowyTmp[i][k++] = tmp[i][j];
                                    }
                                }
                                k = 0;
                            }
                            daneWejsciowe = new DaneWejsciowe(nowyTmp);
                            kolumna = 0;
                            for (int i = 0; i < tmpUcz[0].length; i++) {
                                if (tmpUcz[0][i].toString().equals(elementDrzewa.toString())) {
                                    kolumna = i;
                                }
                            }
                            nowyTmp = new ElementDrzewa[tmpUcz.length][tmpUcz[0].length - 1];
                            k = 0;
                            for (int i = 0; i < tmpUcz.length; i++) {
                                for (int j = 0; j < tmpUcz[i].length; j++) {
                                    if (j != kolumna) {
                                        nowyTmp[i][k++] = tmpUcz[i][j];
                                    }
                                }
                                k = 0;
                            }
                            daneWejsciowe.setZbiorUczacy(tmpUcz);
                            kolumna = 0;
                            for (int i = 0; i < tmpTest[0].length; i++) {
                                if (tmpTest[0][i].toString().equals(elementDrzewa.toString())) {
                                    kolumna = i;
                                }
                            }
                            nowyTmp = new ElementDrzewa[tmpTest.length][tmpTest[0].length - 1];
                            k = 0;
                            for (int i = 0; i < tmpTest.length; i++) {
                                for (int j = 0; j < tmpTest[i].length; j++) {
                                    if (j != kolumna) {
                                        nowyTmp[i][k++] = tmpTest[i][j];
                                    }
                                }
                                k = 0;
                            }
                            daneWejsciowe.setZbiorTestowy(tmpTest);
                            o.setDaneWejsciowe(daneWejsciowe);
                        } else {
                            int kolumna = 0;
                            int liczWartosc = 0;
                            for (int i = 0; i < tmp.length; i++) {
                                for (int j = 0; j < tmp[i].length; j++) {
                                    if (elementDrzewa.toString().equals(tmp[i][j].toString())) {
                                        kolumna = j;
                                        liczWartosc++;
                                    }
                                }
                            }
                            ElementDrzewa[][] nowyTmp = new ElementDrzewa[tmp.length - liczWartosc][tmp[0].length];
                            int k = 0;
                            for (int i = 0; i < tmp.length; i++) {
                                if (!tmp[i][kolumna].toString().equals(elementDrzewa.toString())) {
                                    for (int j = 0; j < tmp[i].length; j++) {
                                        nowyTmp[k][j] = tmp[i][j];
                                    }
                                    k++;
                                }
                            }
                            daneWejsciowe = new DaneWejsciowe(nowyTmp);
                            kolumna = 0;
                            liczWartosc = 0;
                            for (int i = 0; i < tmpUcz.length; i++) {
                                for (int j = 0; j < tmpUcz[i].length; j++) {
                                    if (elementDrzewa.toString().equals(tmpUcz[i][j].toString())) {
                                        kolumna = j;
                                        liczWartosc++;
                                    }
                                }
                            }
                            nowyTmp = new ElementDrzewa[tmpUcz.length - liczWartosc][tmpUcz[0].length];
                            k = 0;
                            for (int i = 0; i < tmpUcz.length; i++) {
                                if (!tmpUcz[i][kolumna].toString().equals(elementDrzewa.toString())) {
                                    for (int j = 0; j < tmpUcz[i].length; j++) {
                                        nowyTmp[k][j] = tmpUcz[i][j];
                                    }
                                    k++;
                                }
                            }
                            daneWejsciowe.setZbiorUczacy(nowyTmp);
                            kolumna = 0;
                            liczWartosc = 0;
                            for (int i = 0; i < tmpTest.length; i++) {
                                for (int j = 0; j < tmpTest[i].length; j++) {
                                    if (elementDrzewa.toString().equals(tmpTest[i][j].toString())) {
                                        kolumna = j;
                                        liczWartosc++;
                                    }
                                }
                            }
                            nowyTmp = new ElementDrzewa[tmpTest.length - liczWartosc][tmpTest[0].length];
                            k = 0;
                            for (int i = 0; i < tmpTest.length; i++) {
                                if (!tmpTest[i][kolumna].toString().equals(elementDrzewa.toString())) {
                                    for (int j = 0; j < tmpTest[i].length; j++) {
                                        nowyTmp[k][j] = tmpTest[i][j];
                                    }
                                    k++;
                                }
                            }
                            daneWejsciowe.setZbiorTestowy(nowyTmp);
                            daneWejsciowe.opcje();
                            o.setDaneWejsciowe(daneWejsciowe);
                        }
                        o.actionPerformed(new ActionEvent(o.menu.wycz, ActionEvent.ACTION_PERFORMED, null));
                        o.actionPerformed(new ActionEvent(o.menu.wyś, ActionEvent.ACTION_PERFORMED, null));
                        Tabela tabela = new Tabela(o.daneWejsciowe.get_klasyfikacja());
                        JTable tabelaWyswietl = tabela.getTabela();
                        tabelaWyswietl.setFillsViewportHeight(true);
                        o.p2 = new JPanel();
                        o.p2.add(new JScrollPane(tabelaWyswietl));
                        o.p2.setBorder(new TitledBorder(
                                new TitledBorder(
                                        LineBorder.createGrayLineBorder(),
                                        "Dane"),
                                "",
                                TitledBorder.RIGHT,
                                TitledBorder.BOTTOM));
                        o.p2.setMaximumSize(new Dimension(500, 500));
                        o.p.add(o.p2, BorderLayout.EAST);
                        o.dopasujSieDoZawartosci();
                        o.f.setVisible(true);
                        o.czyPrawyPanel = true;
                    }
                }
            }
        } else if (label == "Droga") {
            //PrzyciskMenu przyciskMenu = (PrzyciskMenu) zrodlo;
            PrzyciskDrzewo przyciskDrzewo = (PrzyciskDrzewo) zrodlo;
            Wezel wezel = przyciskDrzewo.getWezel();
            wezlyDroga = new LinkedList<>();
            wezlyDroga = dajDrogeM(wezel,wezlyDroga);
            ElementDrzewa elementDrzewa[][] = o.daneWejsciowe.getZbiorUczacy();

           // var szerokosc= 0;
           int szerokosc= 0;

          

            for(int g=0;g<1;g++){
                for(int f=0;f<elementDrzewa[g].length;f++){
                    szerokosc++;
                }
            }
            ElementDrzewa elementJtable[][] = new ElementDrzewa[elementDrzewa.length][szerokosc];
            //ElementDrzewa elementDrzewa = przyciskMenu.getElement();
           // dajDrogeO(o.lista, elementDrzewa.toString());
            String nazwa;
           for(int o=1;o<wezlyDroga.size();o=o+2) {
                nazwa = wezlyDroga.get(o).toString();
                for (int i = 0; i < elementDrzewa.length; i++) {
                    if(i==0){
                        for (int x = 0; x < elementDrzewa[i].length; x++) {
                            elementJtable[i][x] = elementDrzewa[i][x];
                        }
                    }
                    for (int j = 0; j < elementDrzewa[i].length-1; j++) {

                            if(nazwa.equals(elementDrzewa[i][j].toString())) {
                                for (int p = 0; p < elementDrzewa[i].length; p++) {
                                    elementJtable[i][p] = elementDrzewa[i][p];
                                }
                                break;
                            }
                    }


               }
               ElementDrzewa elementTnmp[][] = new ElementDrzewa[elementJtable.length][szerokosc];
                int licznik =0;
                for(int k=0;k<elementJtable.length;k++){
                    if(elementJtable[k][0]!=null){

                    for(int u=0;u<elementJtable[k].length;u++) {
                        elementTnmp[licznik][u] = elementJtable[k][u];

                    }
                        licznik++;

                    }
                }

                elementJtable = new ElementDrzewa[licznik][szerokosc];
               licznik = 0;
               for(int l=0;l<elementJtable.length;l++){
                   for(int h=0;h<elementJtable[l].length;h++){
                       elementJtable[l][h]=elementTnmp[l][h];
                   }
               }
               elementDrzewa = new ElementDrzewa[elementJtable.length][szerokosc];
               for(int a=0;a<elementDrzewa.length;a++){
                   for(int z=0;z<elementDrzewa[a].length;z++){
                       elementDrzewa[a][z]=elementJtable[a][z];
                   }
               }
               elementJtable = new ElementDrzewa[elementDrzewa.length][szerokosc];
            }
            o.p.remove(o.p2);
            Tabela tabela = new Tabela(o.daneWejsciowe.get_klasyfikacja());
            Tabela tabelaZbiorUczacy = new Tabela(o.daneWejsciowe.getZbiorUczacy());
            Tabela tabelaZbiorTestowy = new Tabela(o.daneWejsciowe.getZbiorTestowy());
            Tabela tabelaDroga = new Tabela(elementDrzewa);
            Tabela tabelaZbiorDecyzja = new Tabela();
            if(o.daneWejsciowe2 != null) {
                tabelaZbiorDecyzja = new Tabela(o.daneWejsciowe2.get_klasyfikacja());
            }
            JTable tabelaWyswietl = tabela.getTabela();
            JTable tabelaWyswietlZbiorUczacy = tabelaZbiorUczacy.getTabela();
            JTable tabelaWyswietlZbiorTestowy = tabelaZbiorTestowy.getTabela();
            JTable tabelaWyswietlDroga = tabelaDroga.getTabela();
            JTable tabelaWyswietlDecyzje = new JTable();
            if(o.daneWejsciowe2 != null) {
                tabelaWyswietlDecyzje = tabelaZbiorDecyzja.getTabela(); //poprawić nazwy
            }
            tabelaWyswietl.setFillsViewportHeight(true);

            o.p2 = new JPanel();
            JTabbedPane tabelaDane = new JTabbedPane();
            tabelaDane.addTab("Dane",new JScrollPane(tabelaWyswietl));
            tabelaDane.addTab("Uczący",new JScrollPane(tabelaWyswietlZbiorUczacy));
            tabelaDane.addTab("Testowy",new JScrollPane(tabelaWyswietlZbiorTestowy));
            tabelaDane.addTab("Droga", new JScrollPane(tabelaWyswietlDroga));
            tabelaDane.addTab("Decyzja",new JScrollPane(tabelaWyswietlDecyzje));
            tabelaDane.setSelectedIndex(3);
            o.p2.add(tabelaDane);
            o.p2.setMaximumSize(new Dimension(500, 500));
            o.p.add(o.p2, BorderLayout.EAST);
            o.dopasujSieDoZawartosci();
            o.f.setVisible(true);
            o.czyPrawyPanel = true;


            tabelaWyswietl.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        o.popupMenu2.show(tabelaWyswietl, e.getX(), e.getY());
                    }
                }
            });
            tabelaWyswietlZbiorUczacy.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        o.popupMenu2.show(tabelaWyswietlZbiorUczacy, e.getX(), e.getY());
                    }
                }
            });
            tabelaWyswietlZbiorTestowy.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        o.popupMenu2.show(tabelaWyswietlZbiorTestowy, e.getX(), e.getY());
                    }
                }
            });
            tabelaWyswietlZbiorTestowy.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        o.popupMenu2.show(tabelaWyswietlDroga, e.getX(), e.getY());
                    }
                }
            });
            JTable finalTabelaWyswietlDecyzje = tabelaWyswietlDecyzje;
            tabelaWyswietlZbiorTestowy.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        o.popupMenu2.show(finalTabelaWyswietlDecyzje, e.getX(), e.getY());
                    }
                }
            });

           // for(int d=0;d<elementDrzewa.length;d++){
           //     for(int s=0;s<elementDrzewa[d].length;s++){
           //         System.out.print(elementDrzewa[d][s].toString()+" ");
           //     }
            //    System.out.println();
           // }

        }
    }

    public void ustawRozmiar(Dimension r) {
        okno = new BufferedImage((int) r.getWidth(), (int) r.getHeight(), BufferedImage.TYPE_INT_RGB);
        setPreferredSize(r);
        setMaximumSize(r);
    }

    public void obliczanieWspozednych(Wezel wezel, Wezel korzen) {
        if (wezel.equals(korzen)) {
            wezel.setX((wezel.getKoniecDostepnegoMiejsca() - wezel.getPoczatekDostepnegoMiejsca()) / 2);
        }
        int liczbaDzieci = wezel.getLiczbaDzieci(); //liczba dzieci rodzica wpowadzanego do metody
        int dostepnaPrzestrzen = (wezel.getKoniecDostepnegoMiejsca() - wezel.getPoczatekDostepnegoMiejsca()) / liczbaDzieci; //określenie ile przestrzeni(serokości) będą miały dzieci rodzica wprowadzonego do metody
        int koniecDostepnegoMiejsca = 0; //pomocnicza zmienna(nigdy nie zostanie użysta z wartością 0)
        for (int i = 0; i < liczbaDzieci; i++) {
            Wezel d = wezel.getDziecko(i); //zwrócenie pierwszego dziecka(dzieci liczone od 0)
            if (i == 0) //dla piewszego dziecka zawsze dostępne miejsce będzie zaczynało się od współrzędnych początka dostępnego miejsca rodzca
                d.setPoczatekDostepnegoMiejsca(d.getRodzic().getPoczatekDostepnegoMiejsca()); //ustalenie początka dostępnego miejsca dla dziecka
            else
                d.setPoczatekDostepnegoMiejsca(koniecDostepnegoMiejsca); //dla dzieci innych niż na pozycji 0(pierwsze dziecko) początek dostępnego miejca będzie zaczynał się tam gdzie kończy się dostępne miejsce poprzedniego dziecka
            koniecDostepnegoMiejsca = d.getPoczatekDostepnegoMiejsca() + dostepnaPrzestrzen; //ustalenie końca dostępnego miejsca poprzez dodanie wyliczonej odległości do początku dostępnego miejsca
            d.setKoniecDostepnegoMiejsca(koniecDostepnegoMiejsca); //zapisanie końca dostępnego miejsca do węzła
            d.setX(((d.getKoniecDostepnegoMiejsca() - d.getPoczatekDostepnegoMiejsca()) / 2) + d.getPoczatekDostepnegoMiejsca()); //określenie współrzednej x
        }
        LinkedList<Wezel> lista = new LinkedList<Wezel>();
        for (int i = 0; i < wezel.getDzieci().size(); i++) {
            lista.add((Wezel) wezel.getDzieci().get(i));
        } //list przechowująca dzieci
        while (!lista.isEmpty()) {
            Wezel p = lista.remove(0);
            if (!p.czyLisc()) {
                obliczanieWspozednych(p, korzen); //wykonanie rekurencjsi
            }
        }


    }


    public void obliczanieWspozednychY(Wezel wezel, int podzial, Drzewo drzewo, Wezel korzen) {
        if (wezel.equals(korzen)) {

            wezel.setY((drzewo.getLevel(wezel) + 1) * podzial);
        }
        if (!wezel.czyLisc()) {
            LinkedList<Wezel> lista = new LinkedList<Wezel>();
            for (int i = 0; i < wezel.getDzieci().size(); i++) {
                lista.add((Wezel) wezel.getDzieci().get(i));
            } //list przechowująca dzieci
            while (!lista.isEmpty()) {
                Wezel w = lista.remove(0);
                w.setY((drzewo.getLevel(w) + 1) * podzial);
                obliczanieWspozednychY(w, podzial, drzewo, korzen);
            }
        }


    }

    public void rysujDrzewo(Wezel wezel, Wezel korzen) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        Graphics2D g = (Graphics2D) okno.getGraphics();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.black);
        Graphics2D g3 = (Graphics2D) okno.getGraphics();
        g3.setStroke(new BasicStroke(2));
        g3.setColor(Color.white);
        PrzyciskDrzewo button;
        this.setLayout(null);
        //JTextField jtext;
        popupMenu = new JPopupMenu("Title");
        zmien_nazweMenuItem = new PrzyciskMenu("Zmień nazwę");
        zmien_nazweMenuItem.addActionListener(this);
        usun_MenuItem = new PrzyciskMenu("Usuń");
        usun_MenuItem.addActionListener(this);
        dajDroge= new PrzyciskDrzewo("Droga");
        dajDroge.addActionListener(this);

        usun_MenuItem.setForeground(Color.red);
        popupMenu.add(zmien_nazweMenuItem);
        popupMenu.addSeparator();
        popupMenu.add(usun_MenuItem);








     /*       Line2D.Double line = new Line2D.Double(270, 50, 200, 150);
        Line2D.Double line2 = new Line2D.Double(270, 50, 270, 150);
        Line2D.Double line3 = new Line2D.Double(270, 50, 340, 150);
        Line2D.Double line4 = new Line2D.Double(200, 150, 150, 250);
        Line2D.Double line5 = new Line2D.Double(340, 150, 370, 250);
        Line2D.Double line6 = new Line2D.Double(270, 150, 270, 250);
        Line2D.Double line7 = new Line2D.Double (150, 250, 120, 350);
        Line2D.Double line8 = new Line2D.Double (150, 250, 190, 350);

        Line2D.Double line9 = new Line2D.Double (190, 350, 200, 450);
        Line2D.Double line10 = new Line2D.Double (120, 350, 130, 450);


        Line2D.Double line11 = new Line2D.Double (370, 250, 340, 350);
        Line2D.Double line12 = new Line2D.Double (370, 250, 420, 350);

        Line2D.Double line13 = new Line2D.Double (340, 350, 350, 450);
        Line2D.Double line14 = new Line2D.Double (420, 350, 430, 450);



        g.draw(line);
        g.draw(line2);
        g.draw(line3);
        g.draw(line4);
        g.draw(line5);
        g.draw(line6);
        g.draw(line7);
        g.draw(line8);
        g.draw(line9);
        g.draw(line10);
        g.draw(line11);
        g.draw(line12);
        g.draw(line13);
        g.draw(line14);
            g3.drawString("Outlook", 270, 50);
        g3.drawString("Sunny", 180, 150);
        g3.drawString("Cloudy", 270, 150);
        g3.drawString("Rain", 340, 150);
        g3.drawString("Humidity", 150, 250);
        g3.drawString("Windy", 370, 250);
        g3.drawString("Yes", 270, 250);
        g3.drawString("High", 120, 350);
        g3.drawString("Normal", 190, 350);
        g3.drawString("False", 340, 350);
        g3.drawString("True", 420, 350);
        g3.drawString("Yes", 200, 450);
        g3.drawString("No", 130, 450);
        g3.drawString("Yes", 350, 450);
        g3.drawString("No", 430, 450);
     int odleglosc = 0;
     int liczba = 0;
        int poziom =  drzewo.getLevel(wezel);
        if(wezel.equals(korzen))
        g3.drawString(wezel.toString(), 270, 50);
        else
        g3.drawString(wezel.toString(), szerokosc, wysokosc);
        LinkedList<Wezel> lista = wezel.getDzieci();
        while(!lista.isEmpty()) {
            int podzial = lista.size()+1;
            Wezel w = lista.remove(0);
            if(w.czyLisc()) {
                System.out.println(w.toString());
                g3.drawString(w.toString(), szerokosc, wysokosc + 100);
            }

            else {
    if(liczba == 0) {
        szerokosc = (szerokosc+70) / podzial;
        odleglosc = szerokosc;
        liczba ++;
    }

                wysokosc = (poziom +2)*75;
                System.out.println(szerokosc+" "+wysokosc);

                rysujDrzewo(w, szerokosc, wysokosc,korzen);
                szerokosc = szerokosc + odleglosc;
            }


        }
        repaint();*/
        if (wezel.equals(korzen)) {
            g3.drawString(wezel.toString(), (wezel.getX() - (3 * wezel.toString().length())), wezel.getY());

            button = new PrzyciskDrzewo("<html>" + wezel.toString() + "<br> E = " + decimalFormat.format(((Atrybut) wezel.getDane()).getEntropia()) + "</html>");
            popupMenu = new JPopupMenu("Title");
            usun_MenuItem.setElement((ElementDrzewa) wezel.getDane());
            zmien_nazweMenuItem.setElement((ElementDrzewa) wezel.getDane());
            popupMenu.add(zmien_nazweMenuItem);
            popupMenu.addSeparator();
            popupMenu.add(usun_MenuItem);


            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setForeground(Color.white);
            button.setBackground(Color.blue);
            button.setBounds((wezel.getX() - decimalFormat.format((Double) ((Atrybut) wezel.getDane()).getEntropia()).length() * 6), wezel.getY() - 20, decimalFormat.format((Double) ((Atrybut) wezel.getDane()).getEntropia()).length() * 13, 40);
            button.setMargin(new Insets(0, 0, 0, 0));
            button.setVisible(true);
            button.setComponentPopupMenu(popupMenu);

            //this.add(button1);
            listaButton.add(button);

        }
        if (!wezel.czyLisc()) {
            LinkedList<Wezel> lista = new LinkedList<Wezel>();
            for (int i = 0; i < wezel.getDzieci().size(); i++) {
                lista.add((Wezel) wezel.getDzieci().get(i));
            } //list przechowująca dzieci
            while (!lista.isEmpty()) {
                Wezel w = lista.remove(0);
                g3.drawString(w.toString(), (w.getX() - (3 * w.toString().length())), w.getY());
                button = new PrzyciskDrzewo(w.toString());
                if (w.getDane().getClass().getName() == "Atrybut") {
                    button = new PrzyciskDrzewo("<html>" + w.toString() + "<br>E = " + decimalFormat.format(((Atrybut) w.getDane()).getEntropia()) + "</html>");
                    popupMenu = new JPopupMenu("Title");
                    usun_MenuItem.setElement((ElementDrzewa) w.getDane());
                    zmien_nazweMenuItem.setElement((ElementDrzewa) w.getDane());
                    popupMenu.add(zmien_nazweMenuItem);
                    popupMenu.addSeparator();
                    popupMenu.add(usun_MenuItem);
                    button.setComponentPopupMenu(popupMenu);
                    button.setBackground(Color.blue);


                } else if (w.getDane().getClass().getName() == "WartoscAtrybutu") {
                    button = new PrzyciskDrzewo(w.toString());
                    popupMenu = new JPopupMenu("Title");
                    usun_MenuItem.setElement((ElementDrzewa) w.getDane());
                    zmien_nazweMenuItem.setElement((ElementDrzewa) w.getDane());
                    popupMenu.add(zmien_nazweMenuItem);
                    popupMenu.addSeparator();
                    popupMenu.add(usun_MenuItem);
                    button.setComponentPopupMenu(popupMenu);
                    button.setBackground(Color.green);

                } else {
                    popupMenu = new JPopupMenu("Title");
                    dajDroge.setWezel((Wezel)w);
                    popupMenu.add(dajDroge);
                    button.setComponentPopupMenu(popupMenu);
                    button.setBackground(Color.cyan);
                    button.setWezel(w);


                }
                button.setForeground(Color.white);
                button.setBounds((w.getX() - w.toString().length() * 6), w.getY() - 20, w.toString().length() * 13, 30);
                if (w.getDane().getClass().getName() == "Atrybut") {
                    button.setBounds((w.getX() - decimalFormat.format((Double) ((Atrybut) w.getDane()).getEntropia()).length() * 6), w.getY() - 20, decimalFormat.format((Double) ((Atrybut) w.getDane()).getEntropia()).length() * 13, 40);
                }
                button.setMargin(new Insets(0, 0, 0, 0));
                button.setVisible(true);
                //button.setComponentPopupMenu(popupMenu);
                //this.add(button);
                listaButton.add(button);
                Line2D.Double line = new Line2D.Double(w.getX(), w.getY() - 20, w.getRodzic().getX(), w.getRodzic().getY() + 10);
                g.draw(line);
                rysujDrzewo(w, korzen);
            }
        }

        repaint();

    }

    public void rysujPrzyciski(LinkedList<PrzyciskDrzewo> lista) {
        int i = 0;
        while (i < lista.size()) {
            PrzyciskDrzewo b = (PrzyciskDrzewo)lista.get(i);


            i++;
            this.add((PrzyciskDrzewo)b);


        }
        repaint();
    }

    public void getDecyzja(Wezel wezel){
        ElementDrzewa decyzja[][] = o.daneWejsciowe2.get_klasyfikacja();
        for(int j=1; j<decyzja.length;j++) {
            decyzja[j][decyzja[j].length-1] = new Decyzja("");
            decyzja(wezel,decyzja,j);
        }
        o.daneWejsciowe2.set_klasyfikacja_tablica(decyzja);
        o.p.remove(o.p2);
        Tabela tabela = new Tabela(o.daneWejsciowe.get_klasyfikacja());
        Tabela tabelaZbiorUczacy = new Tabela(o.daneWejsciowe.getZbiorUczacy());
        Tabela tabelaZbiorTestowy = new Tabela(o.daneWejsciowe.getZbiorTestowy());
        Tabela tabelaZbiorDecyzja = new Tabela(o.daneWejsciowe2.get_klasyfikacja());
        JTable tabelaWyswietl = tabela.getTabela();
        JTable tabelaWyswietlZbiorUczacy = tabelaZbiorUczacy.getTabela();
        JTable tabelaWyswietlZbiorTestowy = tabelaZbiorTestowy.getTabela();
        JTable tabelaWyswietlDecyzje = tabelaZbiorDecyzja.getTabela(); //poprawić nazwy
        tabelaWyswietl.setFillsViewportHeight(true);
        o.p2 = new JPanel();
        JTabbedPane tabelaDane = new JTabbedPane();
        tabelaDane.addTab("Dane",new JScrollPane(tabelaWyswietl));
        tabelaDane.addTab("Uczący",new JScrollPane(tabelaWyswietlZbiorUczacy));
        tabelaDane.addTab("Testowy",new JScrollPane(tabelaWyswietlZbiorTestowy));
        tabelaDane.addTab("Decyzja",new JScrollPane(tabelaWyswietlDecyzje));
                /*tabelaWyswietl.setBorder(new TitledBorder(
                        new TitledBorder(
                                LineBorder.createGrayLineBorder(),
                                "Dane"),
                        "",
                        TitledBorder.RIGHT,
                        TitledBorder.BOTTOM));*/
        o.p2.add(tabelaDane);
        o.p2.setMaximumSize(new Dimension(500, 500));
        o.p.add(o.p2, BorderLayout.EAST);
        o.dopasujSieDoZawartosci();
        o.f.setVisible(true);
        o.czyPrawyPanel = true;
        o.ukryjTabele();
        tabelaWyswietl.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    o.popupMenu2.show(tabelaWyswietl, e.getX(), e.getY());
                }
            }
        });
        tabelaWyswietlZbiorUczacy.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    o.popupMenu2.show(tabelaWyswietlZbiorUczacy, e.getX(), e.getY());
                }
            }
        });
        tabelaWyswietlZbiorTestowy.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    o.popupMenu2.show(tabelaWyswietlZbiorTestowy, e.getX(), e.getY());
                }
            }
        });
        tabelaWyswietlZbiorTestowy.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    o.popupMenu2.show(tabelaWyswietlDecyzje, e.getX(), e.getY());
                }
            }
        });
    }
    private void decyzja(Wezel wezel,ElementDrzewa[][] decyzja,int j){
        int pozycja = 0;

        String nazwa = wezel.toString();
        for (int i = 0; i < decyzja[0].length - 1; i++) {
            if (decyzja[0][i].toString().equals(nazwa)) {
                pozycja = i;
            }
        }
        String nazwaSpr = decyzja[j][pozycja].toString();
        for(int p = 0; p<wezel.getDzieci().size(); p++){
            Wezel tmpW = wezel.getDziecko(p);
            decyzja[j][decyzja[j].length-1] = new Decyzja("Błąd-brak drogi");
            if(tmpW.toString().equals(nazwaSpr)){

                if(tmpW.getDzieci().size()!=0){
                    for(int a = 0; a<tmpW.getDzieci().size(); a++){
                        Wezel tmpww = tmpW.getDziecko(a);
                        if(tmpww.czyLisc()){

                                decyzja[j][decyzja[j].length-1] = new Decyzja(tmpww.toString());


                        }
                        else {
                            decyzja(tmpww,decyzja,j);
                        }

                    }
                }
                break;
            }

        }

    }



    public void sprawdzTestowy(Wezel wezel){
        ElementDrzewa zbiorTestowy[][] = o.daneWejsciowe.getZbiorTestowy();

        int szerokosc = 0;
        for(int g=0;g<1;g++){
            for(int f=0;f<zbiorTestowy[g].length;f++){
                szerokosc++;
            }
        }
        if(zbiorTestowy[0][szerokosc-1].toString().equals("Wynik Testu")){

        }
        else {
            ElementDrzewa tmp[][] = new ElementDrzewa[zbiorTestowy.length][szerokosc];
            for (int j = 0; j < tmp.length; j++) {
                for (int o = 0; o < tmp[j].length; o++) {
                    tmp[j][o] = zbiorTestowy[j][o];
                }
            }
            zbiorTestowy = new ElementDrzewa[tmp.length][szerokosc + 1];
            for (int j = 0; j < tmp.length; j++) {
                for (int o = 0; o < tmp[j].length; o++) {
                    if (j == 0) {

                        zbiorTestowy[j][zbiorTestowy[j].length - 1] = new Atrybut("Wynik Testu");
                    }
                    zbiorTestowy[j][o] = tmp[j][o];
                }
            }
        }
    for(int j=1; j<zbiorTestowy.length;j++){
        sprawdzTest(wezel,zbiorTestowy,j);
        }
        o.daneWejsciowe.setZbiorTestowy(zbiorTestowy);
        szerokosc=0;

        o.p.remove(o.p2);
        Tabela tabela = new Tabela(o.daneWejsciowe.get_klasyfikacja());
        Tabela tabelaZbiorUczacy = new Tabela(o.daneWejsciowe.getZbiorUczacy());
        Tabela tabelaZbiorTestowy = new Tabela(o.daneWejsciowe.getZbiorTestowy());
        JTable tabelaWyswietl = tabela.getTabela();
        JTable tabelaWyswietlZbiorUczacy = tabelaZbiorUczacy.getTabela();
        JTable tabelaWyswietlZbiorTestowy = tabelaZbiorTestowy.getTabela();
        tabelaWyswietl.setFillsViewportHeight(true);
        o.p2 = new JPanel();
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
        o.p2.add(tabelaDane);
        o.p2.setMaximumSize(new Dimension(500, 500));
        o.p.add(o.p2, BorderLayout.EAST);
        o.dopasujSieDoZawartosci();
        o.f.setVisible(true);
        o.czyPrawyPanel = true;
        o.ukryjTabele();
        tabelaWyswietl.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    o.popupMenu2.show(tabelaWyswietl, e.getX(), e.getY());
                }
            }
        });
        tabelaWyswietlZbiorUczacy.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    o.popupMenu2.show(tabelaWyswietlZbiorUczacy, e.getX(), e.getY());
                }
            }
        });
        tabelaWyswietlZbiorTestowy.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    o.popupMenu2.show(tabelaWyswietlZbiorTestowy, e.getX(), e.getY());
                }
            }
        });

    }

    private void sprawdzTest(Wezel wezel,ElementDrzewa[][] zbiorTestowy,int j){
        int pozycja = 0;

            String nazwa = wezel.toString();
            for (int i = 0; i < zbiorTestowy[0].length - 1; i++) {
                if (zbiorTestowy[0][i].toString().equals(nazwa)) {
                    pozycja = i;
                }
            }
            String nazwaSpr = zbiorTestowy[j][pozycja].toString();
            for(int p = 0; p<wezel.getDzieci().size(); p++){
                Wezel tmpW = wezel.getDziecko(p);
                zbiorTestowy[j][zbiorTestowy[j].length-1] = new WartoscAtrybutu("Błąd-brak drogi"); //może do zmiany Wartość atrybutu na coś innego
                if(tmpW.toString().equals(nazwaSpr)){

                    if(tmpW.getDzieci().size()!=0){
                        for(int a = 0; a<tmpW.getDzieci().size(); a++){
                            Wezel tmpww = tmpW.getDziecko(a);
                            if(tmpww.czyLisc()){
                                if(zbiorTestowy[j][zbiorTestowy[j].length-2].toString().equals(tmpww.toString())){
                                    zbiorTestowy[j][zbiorTestowy[j].length-1] = new WartoscAtrybutu("OK");
                                }
                                else {
                                    zbiorTestowy[j][zbiorTestowy[j].length-1] = new WartoscAtrybutu("Błąd");
                                }
                            }
                            else {
                                sprawdzTest(tmpww,zbiorTestowy,j);
                            }

                        }
                    }
                    break;
                }

            }

    }


    public void credits() {
        ImageIcon icon = new ImageIcon(getClass().getResource("icons/boink.png"));

        JOptionPane.showMessageDialog(null, "Program napisany w ramach Projektu Zespołowego \n" +
                        "Wersja : 0.3 Aircobra \n" +
                        "Autorzy : \n" +
                        "Główni programiści : \n" +
                        "Dominik Woźniak \n" +
                        "Adler Mateusz \n" +
                        "Testerzy : \n" +
                        "Jakub Gabryś \n" +
                        "Marcin Majzner \n" +
                        "Programista Pomocniczy \n" +
                        "Damian Staśkiewicz \n" +
                        "Projektant interfejsu : \n" +
                        "Adam Witasiak \n" +
                        "2019, PWSZ KALISZ ",
                "O Programie", JOptionPane.INFORMATION_MESSAGE, icon);
        //wyczysc();
        // Graphics2D g2 = (Graphics2D) okno.getGraphics();
        //g2.setStroke(new BasicStroke(2));

        // g2.setColor(Color.red);

        // g2.drawString("Program napisany w ramach Projektu Zespołowego",10, 10);
       /* g2.drawString("Wersja : Wczesna (2-gi Sprint) ",10, 20);
        g2.drawString("Autorzy : ",10, 30);
        g2.drawString("Główni programiści :  ",10, 40);
        g2.drawString("Dominik Woźniak ",20, 50);
        g2.drawString("Adler Mateusz",20, 60);
        g2.drawString("Testerzy : ",10, 70);
        g2.drawString("Jakub Gabryś ",20, 80);
        g2.drawString("Marcin Majzner ",20, 90);
        g2.drawString("Programista Pomocniczy :  ",10, 100);
        g2.drawString("Damian Staśkiewicz ",20, 110);
        g2.drawString("Projektant interfejsu : ",10, 120);
        g2.drawString("Adam Witasiak ",20, 130);
        g2.drawString("2019, PWSZ KALISZ, ",20, 140);

        repaint();
*/
    }

    public void show_klasyfikacja(DaneWejsciowe klasyfikacja) {
        String klasyfikacja_txt = klasyfikacja.print_string_format();

        JOptionPane.showMessageDialog(null, klasyfikacja_txt, "Klasyfikacja", JOptionPane.INFORMATION_MESSAGE);

    }

    //przesłonięta metoda paintComponent z klasy JPanel do rysowania
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //wyrysowanie naszego płótna na panelu 
        g2d.drawImage(okno, 0, 0, this);

    }

    public void setOkno(Okno o) {
        this.o = o;
    }

    /*public void rysujSkalowanie(Wezel wezel,Wezel korzen) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        Graphics2D g = (Graphics2D) okno.getGraphics();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.black);
        Graphics2D g3 = (Graphics2D) okno.getGraphics();
        g3.setStroke(new BasicStroke(2));
        g3.setColor(Color.white);
        JButton button;
        this.setLayout(null);
        //JTextField jtext;
        popupMenu = new JPopupMenu("Title");
        zmien_nazweMenuItem = new PrzyciskMenu("Zmień nazwę");
        zmien_nazweMenuItem.addActionListener(this);
        usun_MenuItem = new PrzyciskMenu("Usuń");
        usun_MenuItem.addActionListener(this);

        usun_MenuItem.setForeground(Color.red);
        popupMenu.add(zmien_nazweMenuItem);
        popupMenu.addSeparator();
        popupMenu.add(usun_MenuItem);


        if(wezel.equals(korzen)) {
            g3.drawString(wezel.toString(), (wezel.getX()/2-(3*wezel.toString().length())/2), wezel.getY()/2);

            button = new JButton("<html>"+wezel.toString()+"<br> E = "+decimalFormat.format(((Atrybut) wezel.getDane()).getEntropia())+"</html>");
            popupMenu = new JPopupMenu("Title");
            usun_MenuItem.setElement((ElementDrzewa) wezel.getDane());
            zmien_nazweMenuItem.setElement((ElementDrzewa) wezel.getDane());
            popupMenu.add(zmien_nazweMenuItem);
            popupMenu.addSeparator();
            popupMenu.add(usun_MenuItem);
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setForeground(Color.white);
            button.setBackground(Color.blue);
            //wezel.getDane()).getEntropia()).length() * 6 -- w prawo lub lewo
            //wezel.getY() - 20 -- w dol i  w góre
            //decimalFormat.format((Double) ((Atrybut) wezel.getDane()).getEntropia()).length() * 13 -- długość
            // wezel.getDane()).getEntropia()).length() *  40 -- wysokosc
            button.setBounds((wezel.getX()/2 - decimalFormat.format((Double) ((Atrybut) wezel.getDane()).getEntropia()).length() * 6/2), (wezel.getY() - 20)/2, decimalFormat.format((Double) ((Atrybut) wezel.getDane()).getEntropia()).length() * 13/2, 40/2);
            button.setMargin(new Insets(0,0,0,0));
            button.setVisible(true);
            button.setComponentPopupMenu(popupMenu);

            //this.add(button1);
            listaButton.add(button);

        }
        if(!wezel.czyLisc()){
            LinkedList<Wezel> lista = new LinkedList<Wezel>();
            for(int i=0; i<wezel.getDzieci().size(); i++){
                lista.add((Wezel) wezel.getDzieci().get(i));
            } //list przechowująca dzieci
            while (!lista.isEmpty()){
                Wezel w = lista.remove(0);
                //g3.drawString(w.toString(), (w.getX()-(3*w.toString().length())), w.getY()); --
                g3.drawString(w.toString(), (w.getX()/2-(3*w.toString().length())/2), w.getY()/2);
                button = new JButton(w.toString());
                if(w.getDane().getClass().getName()=="Atrybut"){
                    button = new JButton("<html>"+w.toString()+"<br>E = "+decimalFormat.format(((Atrybut)w.getDane()).getEntropia())+"</html>");
                    popupMenu = new JPopupMenu("Title");
                    usun_MenuItem.setElement((ElementDrzewa) w.getDane());
                    zmien_nazweMenuItem.setElement((ElementDrzewa) w.getDane());
                    popupMenu.add(zmien_nazweMenuItem);
                    popupMenu.addSeparator();
                    popupMenu.add(usun_MenuItem);
                    button.setComponentPopupMenu(popupMenu);
                    button.setBackground(Color.blue);
                }else if(w.getDane().getClass().getName()=="WartoscAtrybutu"){
                    popupMenu = new JPopupMenu("Title");
                    usun_MenuItem.setElement((ElementDrzewa) w.getDane());
                    zmien_nazweMenuItem.setElement((ElementDrzewa) w.getDane());
                    popupMenu.add(zmien_nazweMenuItem);
                    popupMenu.addSeparator();
                    popupMenu.add(usun_MenuItem);
                    button.setComponentPopupMenu(popupMenu);
                    button.setBackground(Color.green);
                }else{
                    button.setBackground(Color.cyan);
                }
                button.setForeground(Color.white);
                //wezel.getDane()).getEntropia()).length() * 6 -- w prawo lub lewo
                //wezel.getY() - 20 -- w dol i  w góre
                //decimalFormat.format((Double) ((Atrybut) wezel.getDane()).getEntropia()).length() * 13 -- długość
                // wezel.getDane()).getEntropia()).length() *  40 -- wysokosc
                button.setBounds(((w.getX()-w.toString().length()*6)/2), (w.getY()-20)/2,(w.toString().length()*13)/2,30/2);
                if(w.getDane().getClass().getName()=="Atrybut"){
                    button.setBounds((w.getX()/2 - decimalFormat.format((Double) ((Atrybut) w.getDane()).getEntropia()).length() * 6/2), (w.getY() - 20)/2, decimalFormat.format((Double) ((Atrybut) w.getDane()).getEntropia()).length() * 13/2, 40/2);
                    // ta wyzej linia nic nie robi?
                }
                button.setMargin(new Insets(0,0,0,0));
                button.setVisible(true);
                //button.setComponentPopupMenu(popupMenu);
                //this.add(button);
                listaButton.add(button);
                //Line2D.Double line = new Line2D.Double (w.getX(), w.getY()-120, w.getRodzic().getX(), w.getRodzic().getY()+10); -- długość lini , kierunek
                Line2D.Double line = new Line2D.Double (w.getX()/2, (w.getY()-20)/2, w.getRodzic().getX()/2, (w.getRodzic().getY()+10)/2);
                g.draw(line);
                rysujDrzewo(w,korzen);
            }
        }

        repaint();

    }*/


    public void rysujSkalowanie(Wezel wezel, Wezel korzen) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        Graphics2D g = (Graphics2D) okno.getGraphics();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.black);
        Graphics2D g3 = (Graphics2D) okno.getGraphics();
        g3.setStroke(new BasicStroke(2));
        g3.setColor(Color.white);
        PrzyciskDrzewo button;
        this.setLayout(null);
        //JTextField jtext;
        popupMenu = new JPopupMenu("Title");
        zmien_nazweMenuItem = new PrzyciskMenu("Zmień nazwę");
        zmien_nazweMenuItem.addActionListener(this);
        usun_MenuItem = new PrzyciskMenu("Usuń");
        usun_MenuItem.addActionListener(this);
        dajDroge= new PrzyciskDrzewo("Droga");
        dajDroge.addActionListener(this);
        usun_MenuItem.setForeground(Color.red);
        popupMenu.add(zmien_nazweMenuItem);
        popupMenu.addSeparator();
        popupMenu.add(usun_MenuItem);


        if (wezel.equals(korzen)) {
            //g3.drawString(wezel.toString(), (3*wezel.getX()/4-((3*3*wezel.toString().length()/4))), 3*wezel.getY()/4);

            button = new PrzyciskDrzewo("<html>" + wezel.toString() + "<br> E = " + decimalFormat.format(((Atrybut) wezel.getDane()).getEntropia()) + "</html>");
            popupMenu = new JPopupMenu("Title");
            usun_MenuItem.setElement((ElementDrzewa) wezel.getDane());
            zmien_nazweMenuItem.setElement((ElementDrzewa) wezel.getDane());
            popupMenu.add(zmien_nazweMenuItem);
            popupMenu.addSeparator();
            popupMenu.add(usun_MenuItem);
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setForeground(Color.white);
            button.setBackground(Color.blue);
            button.setBounds(((2 * wezel.getX()) / 2 - decimalFormat.format((Double) ((Atrybut) wezel.getDane()).getEntropia()).length() * 15 / 2), (1 * (wezel.getY() - 15)) / 3, decimalFormat.format((Double) ((Atrybut) wezel.getDane()).getEntropia()).length() * 13, 40);
            button.setMargin(new Insets(0, 0, 0, 0));
            button.setVisible(true);
            button.setComponentPopupMenu(popupMenu);

            //this.add(button1);
            listaButton.add(button);

        }
        if (!wezel.czyLisc()) {
            LinkedList<Wezel> lista = new LinkedList<Wezel>();
            for (int i = 0; i < wezel.getDzieci().size(); i++) {
                lista.add((Wezel) wezel.getDzieci().get(i));
            } //list przechowująca dzieci
            while (!lista.isEmpty()) {
                Wezel w = lista.remove(0);
                // g3.drawString(w.toString(), (w.getX()-(3*w.toString().length())), w.getY());
                button = new PrzyciskDrzewo(w.toString());
                if (w.getDane().getClass().getName() == "Atrybut") {
                    button = new PrzyciskDrzewo("<html>" + w.toString() + "<br>E = " + decimalFormat.format(((Atrybut) w.getDane()).getEntropia()) + "</html>");
                    popupMenu = new JPopupMenu("Title");
                    usun_MenuItem.setElement((ElementDrzewa) w.getDane());
                    zmien_nazweMenuItem.setElement((ElementDrzewa) w.getDane());
                    popupMenu.add(zmien_nazweMenuItem);
                    popupMenu.addSeparator();
                    popupMenu.add(usun_MenuItem);
                    button.setComponentPopupMenu(popupMenu);
                    button.setBackground(Color.blue);
                } else if (w.getDane().getClass().getName() == "WartoscAtrybutu") {
                    popupMenu = new JPopupMenu("Title");
                    usun_MenuItem.setElement((ElementDrzewa) w.getDane());
                    zmien_nazweMenuItem.setElement((ElementDrzewa) w.getDane());
                    popupMenu.add(zmien_nazweMenuItem);
                    popupMenu.addSeparator();
                    popupMenu.add(usun_MenuItem);
                    button.setComponentPopupMenu(popupMenu);
                    button.setBackground(Color.green);
                } else {
                    button.setBackground(Color.cyan);
                    popupMenu = new JPopupMenu("Title");
                    dajDroge.setWezel((Wezel)w);
                    popupMenu.add(dajDroge);
                    button.setComponentPopupMenu(popupMenu);
                    button.setBackground(Color.cyan);
                    button.setWezel(w);
                }
                button.setForeground(Color.white);
                //wezel.getDane()).getEntropia()).length() * 6 -- w prawo lub lewo
                //wezel.getY() - 20 -- w dol i  w góre
                //decimalFormat.format((Double) ((Atrybut) wezel.getDane()).getEntropia()).length() * 13 -- długość
                // wezel.getDane()).getEntropia()).length() *  40 -- wysokosc
                button.setBounds((w.getX() - w.toString().length()), (w.getY()) / 2, w.toString().length() * 13, 30);
                if (w.getDane().getClass().getName() == "Atrybut") {
                    button.setBounds((w.getX() - decimalFormat.format((Double) ((Atrybut) w.getDane()).getEntropia()).length() * 2), (2 * w.getY() - 3) / 4, decimalFormat.format((Double) ((Atrybut) w.getDane()).getEntropia()).length() * 13, 40);
                }
                button.setMargin(new Insets(0, 0, 0, 0));
                button.setVisible(true);
                //button.setComponentPopupMenu(popupMenu);
                //this.add(button);
                listaButton.add(button);
                Line2D.Double line = new Line2D.Double((2 * w.getX()) / 2, (1 * w.getY() - 15) / 1.9, (2 * w.getRodzic().getX()) / 2, (w.getRodzic().getY() + 5) / 1.9);
                g.draw(line);
                rysujSkalowanie(w, korzen);
            }
        }

        repaint();

    }

    public LinkedList dajWezly(Wezel wezel, LinkedList lista) {

        if (!wezel.czyLisc()) {
            LinkedList<Wezel> listaT = new LinkedList<Wezel>();
            for (int i = 0; i < wezel.getDzieci().size(); i++) {
                listaT.add((Wezel) wezel.getDzieci().get(i));
            } //list przechowująca dzieci
            while (!listaT.isEmpty()) {
                Wezel w = listaT.remove(0);
                if (w.czyLisc()) {
                    lista.add(w);
                } else {
                    dajWezly(w, lista);
                }
            }
        }

        return lista;
    }

    public void dajDroge(Wezel wezel) {
        if (wezel.getRodzic() != null) {
            // System.out.print(wezel.toString() + "-");
            dajDroge(wezel.getRodzic());
        } else {
            //System.out.print(wezel.toString());
        }
    }

    public LinkedList dajDrogeM(Wezel wezel, LinkedList lista) {
        if (wezel.getRodzic() != null) {
            // System.out.print(wezel.toString() + "-");
            dajDrogeM(wezel.getRodzic(), lista);
        } else {
            //System.out.print(wezel.toString());
        }
        lista.add(wezel);
        return lista;
    }

    public void dajDrogeF(LinkedList lista) {
        for (int i = 0; i < lista.size(); i++) {
            int j = i;
            Wezel w = (Wezel) lista.get(i);
            if (w.czyLisc()) {
                System.out.print("to D=" + w.toString());
            } else {

                Wezel wt = (Wezel) lista.get(i += 1);
                System.out.print(w.toString() + "=" + wt.toString() + "  ");
            }

        }
        System.out.println();

    }

    public void dajDrogeO(LinkedList lista, String decyzja) {
        LinkedList listaM = new LinkedList();
        LinkedList listaMo = new LinkedList();


        for (int i = 0; i < lista.size(); i++) {


            listaMo = dajDrogeM((Wezel) lista.get(i), listaM);
            Wezel tmp = (Wezel) listaMo.get(listaMo.size() - 1);
            if (tmp.toString() == decyzja) {
                dajDrogeF(listaMo);


            }
            listaMo = new LinkedList();
            listaM = new LinkedList();
        }
    }
}


