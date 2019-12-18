import java.util.LinkedList;

public class DaneWejsciowe {
    private String[][] tablica;
    private ElementDrzewa[][] dane;
    private Atrybut[] atrybuty;
    private ElementDrzewa[][] zbiorUczacy;
    private ElementDrzewa[][] zbiorTestowy;
    private String opcja1;
    private String opcja2;
    private Object[][] atrybuty_z_wartosciami_i_decyzja;
    private Object[][] wartosci_atr_i_decyzja;
    private Object[][] wartosci_atr_i_decyzja_uczace ;
    private Object[][] wartosci_atr_i_decyzja_testujace ;
    private int maxGlebokosc;
   boolean DEBUG = false; 
    /**
     * zwykły konstruktor klasy klasyfikacja ze stałym rozmiarem 50x50
     */
    public DaneWejsciowe() {
        this.tablica = new String[50][50];
        this.dane = new ElementDrzewa[50][50];
        this.atrybuty = new Atrybut[50];
        this.atrybuty_z_wartosciami_i_decyzja = new String[50][50];
        this.wartosci_atr_i_decyzja = new Object[50][50];
    }

    /**
     * konstruktor klasy klasyfikacja z ustalonym rozmiarem tablicy danymi wejsciowymi x i y
     */
    public DaneWejsciowe(int y, int x) {
        this.tablica = new String[y][x];
        this.dane = new ElementDrzewa[y][x];
        this.atrybuty = new Atrybut[x];
        this.atrybuty_z_wartosciami_i_decyzja = new String[y][x];
        this.wartosci_atr_i_decyzja = new Object[y][x];
    }

    public DaneWejsciowe(ElementDrzewa[][] dane) {
        this.dane = dane;
        Atrybut[] tmp = new Atrybut[dane[0].length - 2];
        int j = 0;
        for (int i = 1; i < dane[0].length - 1; i++) {
            tmp[j++] = (Atrybut) dane[0][i];
        }
        atrybuty = tmp;
        //  tablica = null;
        wartosci_i_decyzje_z_elementow_drzewa();
        this.tablica = get_klasyfikacja_string();
        this.atrybuty = get_klasyfikacja_atrybuty();
        this.atrybuty_z_wartosciami_i_decyzja = new Object[this.tablica.length - 1][this.tablica.length];
        this.wartosci_atr_i_decyzja = new Object[this.atrybuty.length + 1][this.atrybuty.length + 1];

        this.wartosci_atr_i_decyzja = get_klasyfikacja_wart_dec();
        this.atrybuty_z_wartosciami_i_decyzja = get_klasyfikacja_string();
        
                if(DEBUG){
            System.out.println("konstruktor IN - elementdrzewa[][] ");
            System.out.println("print_in_console  (this.tablica)" );
            print_in_console();
            System.out.println("print_in_console_ATR  (this.wartosci_atr_i_decyzja)" );
            print_in_console_ATR();
              System.out.println("print_in_console_atrybuty  (this.atrybuty)" );
            print_in_console_atrybuty();
              System.out.println("print_in_console_classes  (this.dane[i][j].getClass)" );            
            print_in_console_classes();
              System.out.println("print_in_console_dane_stringi  (this.dane[i][j].getNazwa())" );                        
            print_in_console_dane_stringi();
                          System.out.println("print_in_console_dane_stringi_20  (this.wartosci_atr_i_decyzja[i][j])" );                        
            print_in_console_dane_stringi_20();
             System.out.println("print_in_console_dane_stringi_odwrotnie  (this.dane[j][i].getNazwa())" );        
            print_in_console_dane_stringi_odwrotnie();
            
                         System.out.println("print_in_console_dane_stringi_odwrotnie_20  (this.wartosci_atr_i_decyzja[j][i]+");        
            print_in_console_dane_stringi_odwrotnie_20();
        }
    }

    /**
     * konstruktor ze zmienna ścieżka typu string. buduje klase na podstawie podanej ścieżki pliku
     */
    public DaneWejsciowe(String Ścieżka) {
        DaneWejsciowe to = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka);
        this.tablica = to.get_klasyfikacja_string();
        this.dane = to.get_klasyfikacja();
        this.atrybuty = to.get_klasyfikacja_atrybuty();
        // !! zamienic 5 na okreslana max. wartosc rozmiaru dlugosc tablicy
        this.atrybuty_z_wartosciami_i_decyzja = new Object[this.tablica.length - 1][this.tablica.length];
        this.wartosci_atr_i_decyzja = new Object[this.atrybuty.length + 1][this.atrybuty.length + 1];

        this.wartosci_atr_i_decyzja = to.get_klasyfikacja_wart_dec();
        this.atrybuty_z_wartosciami_i_decyzja = to.get_klasyfikacja_string();
        opcje();
    }

    public static String klasyfikacja(String outlook, boolean windy, double humidity) {
        if (outlook.equals("sunny")) {
            if (humidity <= 75) {
                return "yes";
            } else if (humidity > 75) {
                return "no";
            }
        } else if (outlook.equals("overcast")) {
            return "yes";
        } else if (outlook.equals("rainy")) {
            if (windy == true) {
                return "no";
            } else if (windy == false) {
                return "yes";
            }
        }
        return null;
    }

    /**
     * seter tablicy nazw [ stringow] klasyfikacji ze zmienna wejsciowa sciezka pliku
     */
    public void set_klasyfikacja_z_pliku_string(String Ścieżka) {
        this.tablica = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja_string();

    }

    /**
     * seter tablicy objektow wszystkich [ decyzja,wart.atrybutu, atrybut] klasyfikacji ze zmienna wejsciowa sciezka pliku
     */
    public void set_klasyfikacja_z_pliku(String Ścieżka) {
        this.dane = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja();

    }

    /**
     * seter tablicy atrybutow klasyfikacji ze zmienna wejsciowa sciezka pliku
     */
    public void set_klasyfikacja_z_pliku_atrybut(String Ścieżka) {
        this.atrybuty = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja_atrybuty();

    }

    /**
     * seter tablicy wszystkich objektow klasyfikacji ze zmienna wejsciowa tablica dwuwymiarowa typu Object[][]
     */
    public void set_klasyfikacja_tablica(ElementDrzewa[][] tab) {
        this.dane = tab;
    }

    /**
     * seter tablicy wszystkich objektow klasyfikacji ze zmienna wejsciowa tablica dwuwymiarowa typu Object[][]
     */
    public void set_klasyfikacja_tablica_atrybuty_i_decyzje(Object[][] tab) {
        this.wartosci_atr_i_decyzja = tab;
    }

    /**
     * seter tablicy stringow [ nazw] klasyfikacji ze zmienna wejsciowa tablica dwuwymiarowa typu String[][]
     */
    public void set_klasyfikacja_tablica_string(String[][] tab) {
        this.tablica = tab;
    }

    /**
     * seter tablicy stringow [ nazw] klasyfikacji ze zmienna wejsciowa tablica dwuwymiarowa typu String[][]
     */
    public void set_klasyfikacja_tablica_atrybuty(Atrybut[] tab) {
        this.atrybuty = tab;
    }

    /**
     * geter klasyfikacji, ktory zwraca tablice objektow 2 wymiarowa
     */
    public ElementDrzewa[][] get_klasyfikacja() {
        return this.dane;
    }

    /**
     * geter klasyfikacji, ktory zwraca tablice stringow 2 wymiarowa
     */
    public String[][] get_klasyfikacja_string() {
        return this.tablica;
    }

    /**
     * geter klasyfikacji, ktory zwraca tablice atrybutow 1 wymiarowa
     */
    public Atrybut[] get_klasyfikacja_atrybuty() {
        return this.atrybuty;
    }

    /**
     * geter klasyfikacji wart i decyzji, ktory zwraca tablice atrybutow 2 wymiarowa
     */
    public Object[][] get_klasyfikacja_wart_dec() {
        return this.wartosci_atr_i_decyzja;
    }

    public String getOpcja1() {
        return opcja1;
    }

    public String getOpcja2() {
        return opcja2;
    }

    public ElementDrzewa[][] getZbiorUczacy() {
        return zbiorUczacy;
    }

    public ElementDrzewa[][] getZbiorTestowy() {
        return zbiorTestowy;
    }

    public void setZbiorUczacy(ElementDrzewa[][] zbiorUczacy) { this.zbiorUczacy = zbiorUczacy; }

    public void setZbiorTestowy(ElementDrzewa[][] zbiorTestowy) { this.zbiorTestowy = zbiorTestowy; }

    public void setMaxGlebokosc(int maxGlebokosc) { this.maxGlebokosc = maxGlebokosc; }

    public int getMaxGlebokosc() { return maxGlebokosc; }

    /**
     * metoda zwracajaca liczbe elementow w tablicy
     */
    public int ile_elementow() {
        int ilosc = 0;
        for (int i = 0; i < this.dane.length; i++) {
            for (int j = 0; j < this.dane[i].length; j++) {
                if (this.dane[i][j] != null) {
                    ilosc++;
                }
            }
        }
        return ilosc;
    }

    public void opcje() {
        int szerokosc = dane[0].length - 1;
        opcja1 = dane[1][szerokosc].getNazwa();
        for (int i = 1; i < dane.length; i++) {
            if (!dane[i][szerokosc].getNazwa().equals(opcja1)) {
                opcja2 = dane[i][szerokosc].getNazwa();
                break;
            }
        }
    }

    public void podzialZbioru(int wielkoscZbioruUczacego) {
        opcje();
        int iloscWierszy = dane.length;
        int iloscKolumn = dane[0].length;
        zbiorUczacy = new ElementDrzewa[wielkoscZbioruUczacego + 1][iloscKolumn];
        zbiorTestowy = new ElementDrzewa[iloscWierszy - wielkoscZbioruUczacego][iloscKolumn];
        LinkedList<ElementDrzewa[]> opcja1Tmp = new LinkedList<ElementDrzewa[]>();
        LinkedList<ElementDrzewa[]> opcja2Tmp = new LinkedList<ElementDrzewa[]>();
        for (int i = 0; i < zbiorUczacy[0].length; i++) {
            zbiorUczacy[0][i] = dane[0][i];
            zbiorTestowy[0][i] = dane[0][i];
        }
        for (int i = 1; i < dane.length; i++) {
            if (dane[i][iloscKolumn - 1].getNazwa().equals(opcja1)) {
                opcja1Tmp.add(dane[i]);
            } else {
                opcja2Tmp.add(dane[i]);
            }
        }
        int opcja1TmpWielkosc = opcja1Tmp.size();
        int i = 1;
        while (i < zbiorUczacy.length) {
            if (!opcja1Tmp.isEmpty() && (opcja1TmpWielkosc - opcja1Tmp.size()) < (wielkoscZbioruUczacego / 2)) {
                int los = (int) (Math.random() * opcja1Tmp.size());
                zbiorUczacy[i++] = opcja1Tmp.get(los);
                opcja1Tmp.remove(los);
            } else if (!opcja2Tmp.isEmpty()) {
                int los = (int) (Math.random() * opcja2Tmp.size());
                zbiorUczacy[i++] = opcja2Tmp.get(los);
                opcja2Tmp.remove(los);
            }else{
                if(!opcja1Tmp.isEmpty()) {
                    int los = (int) (Math.random() * opcja1Tmp.size());
                    zbiorUczacy[i++] = opcja1Tmp.get(los);
                    opcja1Tmp.remove(los);
                }else if(!opcja2Tmp.isEmpty()){
                    int los = (int) (Math.random() * opcja2Tmp.size());
                    zbiorUczacy[i++] = opcja2Tmp.get(los);
                    opcja2Tmp.remove(los);
                }
            }
        }
        for (int j = 1; j < zbiorTestowy.length; j++) {
            if (!opcja1Tmp.isEmpty()) {
                ElementDrzewa[] element = opcja1Tmp.getFirst();
                zbiorTestowy[j] = element;
                opcja1Tmp.remove(element);
            } else {
                ElementDrzewa[] element = opcja2Tmp.getFirst();
                zbiorTestowy[j] = element;
                opcja2Tmp.remove(element);
            }
        }
    }

    /**
     * metoda drukujaca tablice w konsoli
     */
    public void print_in_console() {
        for (int i = 0; i < this.tablica.length; i++) {
            for (int j = 0; j < this.tablica[i].length; j++) {
                if (this.tablica[i][j] != null) {
                    System.out.print("[" + this.tablica[i][j] + "]");
                } else {
                    System.out.print("[]");
                }
            }
            System.out.println();
        }

    }

    /**
     * metoda drukujaca tablice w konsoli
     */
    public void print_in_console_classes() {
        for (int i = 0; i < this.dane.length; i++) {
            for (int j = 0; j < this.dane[i].length; j++) {
                if (this.dane[i][j] != null) {
                    System.out.print("[" + this.dane[i][j].getClass() + "]");
                } else {
                    System.out.print("[]");
                }
            }
            System.out.println();
        }

    }

    /**
     * metoda drukujaca tablice w konsoli
     */
    public void print_in_console_ATR() {
        for (int i = 0; i < this.wartosci_atr_i_decyzja.length; i++) {
            for (int j = 0; j < this.wartosci_atr_i_decyzja[i].length; j++) {
                if (this.wartosci_atr_i_decyzja[i][j] != null) {
                    System.out.print("[" + this.wartosci_atr_i_decyzja[i][j] + "]");
                } else {
                    System.out.print("[]");
                }
            }
            System.out.println();
        }

    }

    /**
     * metoda drukujaca tablice stringow klas w konsoli
     */
    public void print_in_console_dane_stringi() {
        int ixx = 0;
        for (int i = 1; i < this.dane.length; i++) {
            for (int j = 1; j < this.dane[i].length; j++) {
                if (this.dane[i][j] != null) {
                    System.out.print("[" + this.dane[i][j].getNazwa() + " " + ixx + "]");
                    ixx++;
                } else {
                    System.out.print("[]");
                }
            }
            System.out.println();
        }

    }

    /**
     * metoda drukujaca tablice klas w konsoli
     */
    public void print_in_console_dane_stringi_odwrotnie() {
        int ixx = 0;
        for (int i = 1; i < this.dane[i].length; i++) {
            for (int j = 1; j < this.dane.length; j++) {
                if (this.dane[j][i] != null) {
                    System.out.print("[" + this.dane[j][i].getNazwa() + " " + ixx + "]");
                    ixx++;
                } else {
                    System.out.print("[]");
                }
            }
            System.out.println();
        }

    }

    /**
     * metoda tworzaca tabelke wartosci atrybutow i decyzji na podstawie danych
     **/
    public void wartosci_i_decyzje_z_elementow_drzewa() {
//        this.tablica
        if(this.tablica == null){
            this.tablica = new String[this.dane.length][this.dane[0].length];
        }
        for (int i = 0; i < this.dane.length; i++) {

            for (int j = 0; j < this.dane[i].length; j++) {
                this.tablica[i][j] = this.dane[i][j].getNazwa();
            }
        }

    }

    /**
     * metoda drukujaca tablice wartosci i decyzji w konsoli 2.0
     */
    public void print_in_console_dane_stringi_20() {
        int ixx = 0;
        for (int i = 0; i < this.wartosci_atr_i_decyzja.length; i++) {
            for (int j = 0; j < this.wartosci_atr_i_decyzja[i].length; j++) {
                if (this.wartosci_atr_i_decyzja[i][j] != null) {
                    System.out.print("[" + this.wartosci_atr_i_decyzja[i][j] + " " + ixx + "]");
                    ixx++;
                } else {
                    System.out.print("[]");
                }
            }
            System.out.println();
        }

    }

    /**
     * metoda drukujaca tablice wartosci i decyzji w konsoli 2.0
     */
    public void print_in_console_dane_stringi_odwrotnie_20() {
        int ixx = 0;
        for (int i = 0; i < this.wartosci_atr_i_decyzja.length; i++) {
            for (int j = 0; j < this.wartosci_atr_i_decyzja[i].length; j++) {
                if (this.wartosci_atr_i_decyzja[j][i] != null) {
                    System.out.print("[" + this.wartosci_atr_i_decyzja[j][i] + " " + ixx + "]");

                } else {
                    System.out.print("[" + ixx + "]");
                }
                ixx++;
            }
            System.out.println();
        }

    }

    /**
     * metoda zwracajaca klasyfikacje do stringa
     */
    public String print_string_format() {
        String temp = "";
        boolean atrybuty = true;
        for (int i = 0; i < this.tablica.length; i++) {
            for (int j = 0; j < this.tablica[i].length; j++) {
                if (this.tablica[i][j] != null) {
                    temp += "[" + this.tablica[i][j] + "]";

                } else {
                    temp += " , ";
                }
            }
            temp += " \n ";
        }
        return temp;
    }

    /**
     * metoda drukujaca w consoli tablice atrybutow klasyfikacji
     */
    public void print_in_console_atrybuty() {
        for (int i = 0; i < this.atrybuty.length; i++) {
            if (this.atrybuty[i] != null) {
                System.out.print("[" + this.atrybuty[i].getNazwa() + "]");
            } else {
                System.out.print("[]");
            }
        }
        System.out.println("");
    }

    /**
     * metoda zwracajaca ilosc atrybutow
     */
    public int ile_atrybutow() {

        return atrybuty.length;
    }
    
    
    public static void DEBUG_PRINT_TABLE(ElementDrzewa[][] tab){
        for(int i=0;i<tab.length;i++){
        for(int j=0; j < tab[i].length;j++){
            System.out.print("["+tab[i][j].getNazwa()+"]");
        }
            System.out.println();
        }
    
    
    }
}