import java.util.LinkedList;
import java.util.List;

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
     /**
      *  zwykły konstruktor klasy klasyfikacja ze stałym rozmiarem 50x50
      */
    public DaneWejsciowe(){
        this.tablica = new String[50][50];
        this.dane = new ElementDrzewa[50][50];
         this.atrybuty = new Atrybut[50];
         this.atrybuty_z_wartosciami_i_decyzja = new String[50][50];
         this.wartosci_atr_i_decyzja = new Object[50][50];
    }
     /**
      *  konstruktor klasy klasyfikacja z ustalonym rozmiarem tablicy danymi wejsciowymi x i y
      */
    public DaneWejsciowe(int y, int x){
        this.tablica = new String[y][x];
           this.dane = new ElementDrzewa[y][x];
           this.atrybuty = new Atrybut[x];
           this.atrybuty_z_wartosciami_i_decyzja = new String[y][x];
         this.wartosci_atr_i_decyzja = new Object[y][x];
    }

    public DaneWejsciowe(ElementDrzewa[][] dane){
        this.dane = dane;
        Atrybut[] tmp = new Atrybut[dane[0].length-2];
        int j = 0;
        for(int i=1;i<dane[0].length-1;i++){
            tmp[j++] = (Atrybut) dane[0][i];
        }
        atrybuty = tmp;
      //  tablica = null;
        opcje();
          wartosci_i_decyzje_z_elementow_drzewa();
        this.tablica = get_klasyfikacja_string();  
        this.atrybuty = get_klasyfikacja_atrybuty();
        this.atrybuty_z_wartosciami_i_decyzja= new Object[this.tablica.length-1][this.tablica.length];
      this.wartosci_atr_i_decyzja = new Object[this.atrybuty.length+1][this.atrybuty.length+1];
      
        this.wartosci_atr_i_decyzja= get_klasyfikacja_wart_dec();
        this.atrybuty_z_wartosciami_i_decyzja = get_klasyfikacja_string();
    }
    /**
     * konstruktor ze zmienna ścieżka typu string. buduje klase na podstawie podanej ścieżki pliku
     */
    public DaneWejsciowe(String Ścieżka){
       DaneWejsciowe to = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka);
       this.tablica = to.get_klasyfikacja_string();    
                this.dane = to.get_klasyfikacja();
                this.atrybuty = to.get_klasyfikacja_atrybuty();
                   // !! zamienic 5 na okreslana max. wartosc rozmiaru dlugosc tablicy 
      this.atrybuty_z_wartosciami_i_decyzja= new Object[this.tablica.length-1][this.tablica.length];
      this.wartosci_atr_i_decyzja = new Object[this.atrybuty.length+1][this.atrybuty.length+1];
      
        this.wartosci_atr_i_decyzja= to.get_klasyfikacja_wart_dec();
        this.atrybuty_z_wartosciami_i_decyzja = to.get_klasyfikacja_string();
                opcje();
            }
    /**
     * seter tablicy nazw [ stringow] klasyfikacji ze zmienna wejsciowa sciezka pliku
     */
    public void set_klasyfikacja_z_pliku_string(String Ścieżka){
    this.tablica = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja_string();
        
    }
    /**
     * seter tablicy objektow wszystkich [ decyzja,wart.atrybutu, atrybut] klasyfikacji ze zmienna wejsciowa sciezka pliku
     */
    public void set_klasyfikacja_z_pliku(String Ścieżka){
    this.dane = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja();
        
    }
    /**
     * seter tablicy atrybutow klasyfikacji ze zmienna wejsciowa sciezka pliku
     */
    public void set_klasyfikacja_z_pliku_atrybut(String Ścieżka){
    this.atrybuty = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja_atrybuty();
        
    }
    /**
     * seter tablicy wszystkich objektow klasyfikacji ze zmienna wejsciowa tablica dwuwymiarowa typu Object[][]
     */
    public void set_klasyfikacja_tablica(ElementDrzewa[][] tab){
    this.dane= tab;
    }
     /**
     * seter tablicy wszystkich objektow klasyfikacji ze zmienna wejsciowa tablica dwuwymiarowa typu Object[][]
     */
    public void set_klasyfikacja_tablica_atrybuty_i_decyzje(Object[][] tab){
    this.wartosci_atr_i_decyzja= tab;
    }
     /**
     * seter tablicy stringow [ nazw] klasyfikacji ze zmienna wejsciowa tablica dwuwymiarowa typu String[][]
     */
    public void set_klasyfikacja_tablica_string(String[][] tab){
    this.tablica= tab;
    }
    /**
     * seter tablicy stringow [ nazw] klasyfikacji ze zmienna wejsciowa tablica dwuwymiarowa typu String[][]
     */
    public void set_klasyfikacja_tablica_atrybuty(Atrybut[] tab){
    this.atrybuty= tab;
    }
    /**
     * geter klasyfikacji, ktory zwraca tablice objektow 2 wymiarowa
     */
    public ElementDrzewa[][] get_klasyfikacja(){
    return this.dane;
    }
    /**
     * geter klasyfikacji, ktory zwraca tablice stringow 2 wymiarowa
     */
    public String[][] get_klasyfikacja_string(){
    return this.tablica;
    }
    /**
     * geter klasyfikacji, ktory zwraca tablice atrybutow 1 wymiarowa
     */
    public Atrybut[] get_klasyfikacja_atrybuty(){
    return this.atrybuty;
    }
    /**
     * geter klasyfikacji wart i decyzji, ktory zwraca tablice atrybutow 2 wymiarowa
     */
    public Object[][] get_klasyfikacja_wart_dec(){
    return this.wartosci_atr_i_decyzja;
    }
    public String getOpcja1(){
        return opcja1;
    }

    public String getOpcja2(){
        return opcja2;
    }
    /**
     *  metoda zwracajaca liczbe elementow w tablicy
     */
    public int ile_elementow(){
        int ilosc = 0;
        for(int i=0;i<this.dane.length;i++){
            for(int j=0;j<this.dane[i].length;j++)
            {
                if(this.dane[i][j]!=null){
                ilosc++;
                }
            }
        }
        return ilosc;
    }

    public void opcje(){
        int szerokosc = dane[0].length;
        opcja1 = dane[1][szerokosc].getNazwa();
        for(int i=1;i<dane.length;i++){
            if(dane[i][szerokosc].getNazwa()!=opcja1){
                opcja2 = dane[i][szerokosc].getNazwa();
                break;
            }
        }
    }

    public void podzialZbioru(){
        int iloscWierszy = dane.length-1;
        int iloscKolumn = dane[0].length;
        if(iloscWierszy%2==0){
            zbiorUczacy = new ElementDrzewa[(iloscWierszy/2)+1][iloscKolumn];
            zbiorTestowy = new ElementDrzewa[(iloscWierszy/2)+1][iloscKolumn];
        }else{
            zbiorUczacy = new ElementDrzewa[((int)(iloscWierszy/2))+2][iloscKolumn];
            zbiorTestowy = new ElementDrzewa[((int)(iloscWierszy/2))+1][iloscKolumn];
        }
        LinkedList<ElementDrzewa[]> opcja1Tmp = new LinkedList<ElementDrzewa[]>();
        LinkedList<ElementDrzewa[]> opcja2Tmp = new LinkedList<ElementDrzewa[]>();
        for(int i=0;i<dane.length;i++){
            if(dane[i][iloscKolumn-1].getNazwa()==opcja1){
                opcja1Tmp.add(dane[i]);
            }else{
                opcja2Tmp.add(dane[i]);
            }
        }
        int opcja1TmpWielkosc = opcja1Tmp.size();
        int opcja2TmpWielkosc = opcja2Tmp.size();
        while(czyZbiorPelny(zbiorUczacy)){
            int i = 0;
            if(Math.random()<0.5 && !opcja1Tmp.isEmpty() && (opcja1TmpWielkosc-opcja1Tmp.size())<(zbiorUczacy.length/2)){
                int los = (int)(Math.random()*opcja1Tmp.size());
                if(sprawdzZbior(zbiorUczacy,opcja1Tmp.get(los))){
                    zbiorUczacy[i++] = opcja1Tmp.get(los);
                    opcja1Tmp.remove(los);
                }
            }else if(!opcja2Tmp.isEmpty()){
                int los = (int)(Math.random()*opcja2Tmp.size());
                if(sprawdzZbior(zbiorUczacy,opcja2Tmp.get(los))){
                    zbiorUczacy[i++] = opcja2Tmp.get(los);
                    opcja2Tmp.remove(los);
                }
            }
        }
    }

    public boolean sprawdzZbior(ElementDrzewa[][] zbior, ElementDrzewa[] wiersz){
        int tmp = 0;
        for(int i=0;i<zbior.length;i++){
            for(int j=0;j<zbior[i].length;j++){
                if(zbior[i][j].getNazwa()==wiersz[j].getNazwa()){
                    tmp = 0;
                }
            }
            if(tmp==zbior[i].length){
                return false;
            }
        }
        return true;
    }

    public boolean czyZbiorPelny(ElementDrzewa[][] zbior){
        for(int i=0;i<zbior.length;i++){
            if(zbior[i][0]==null){
                return false;
            }
        }
        return true;
    }

    /**
     * metoda drukujaca tablice w konsoli
     */
    public void print_in_console(){
        for(int i=0;i<this.tablica.length;i++){
            for(int j=0;j<this.tablica[i].length;j++)
            {
                if(this.tablica[i][j]!=null){
                System.out.print("["+this.tablica[i][j]+"]");
                }
                else{
                System.out.print("[]");
                }
            }
             System.out.println();
        }
        
    }
     /**
     * metoda drukujaca tablice w konsoli
     */
    public void print_in_console_classes(){
        for(int i=0;i<this.dane.length;i++){
            for(int j=0;j<this.dane[i].length;j++)
            {
                if(this.dane[i][j]!=null){
                System.out.print("["+this.dane[i][j].getClass()+"]");
                }
                else{
                System.out.print("[]");
                }
            }
             System.out.println();
        }
        
    }
     /**
     * metoda drukujaca tablice w konsoli
     */
    public void print_in_console_ATR(){
        for(int i=0;i<this.wartosci_atr_i_decyzja.length;i++){
            for(int j=0;j<this.wartosci_atr_i_decyzja[i].length;j++)
            {
                if(this.wartosci_atr_i_decyzja[j][i]!=null){
                System.out.print("["+this.wartosci_atr_i_decyzja[j][i]+"]");
                }
                else{
                System.out.print("[]");
                }
            }
             System.out.println();
        }
        
    }
   
        /**
     * metoda drukujaca tablice stringow klas w konsoli
     */
    public void print_in_console_dane_stringi(){
        int ixx =0;
        for(int i=1;i<this.dane.length;i++){
            for(int j=1;j<this.dane[i].length;j++)
            {
                if(this.dane[i][j]!=null){
                System.out.print("["+this.dane[i][j].getNazwa()+" "+ixx+"]");
                ixx++;
                }
                else{
                System.out.print("[]");
                }
            }
             System.out.println();
        }
        
    }
         /**
     * metoda drukujaca tablice klas w konsoli
     */
    public void print_in_console_dane_stringi_odwrotnie(){
        int ixx =0;
        for(int i=1;i<this.dane[i].length;i++){
            for(int j=1;j<this.dane.length;j++)
            {
                if(this.dane[j][i]!=null){
                System.out.print("["+this.dane[j][i].getNazwa()+" "+ixx+"]");
                ixx++;
                }
                else{
                System.out.print("[]");
                }
            }
             System.out.println();
        }
        
    }
    /**
     * metoda tworzaca tabelke wartosci atrybutow i decyzji na podstawie danych
     * 
     **/
    public void wartosci_i_decyzje_z_elementow_drzewa(){
//        this.tablica
for(int i=0;i<this.dane.length;i++){
    
    for(int j=0;j<this.dane[i].length;j++){
        this.tablica[i][j] = this.dane[i][j].getNazwa();
    }
}
       
    }
       /**
     * metoda drukujaca tablice wartosci i decyzji w konsoli 2.0
     */
    public void print_in_console_dane_stringi_20(){
        int ixx =0;
        for(int i=0;i<this.wartosci_atr_i_decyzja.length;i++){
            for(int j=0;j<this.wartosci_atr_i_decyzja[i].length;j++)
            {
                if(this.wartosci_atr_i_decyzja[i][j]!=null){
                System.out.print("["+this.wartosci_atr_i_decyzja[i][j]+" "+ixx+"]");
                ixx++;
                }
                else{
                System.out.print("[]");
                }
            }
             System.out.println();
        }
        
    }
         /**
     * metoda drukujaca tablice wartosci i decyzji w konsoli 2.0
     */
    public void print_in_console_dane_stringi_odwrotnie_20(){
        int ixx =0;
        for(int i=0;i<this.wartosci_atr_i_decyzja.length;i++){
            for(int j=0;j<this.wartosci_atr_i_decyzja[i].length;j++)
            {
                if(this.wartosci_atr_i_decyzja[j][i]!=null){
                System.out.print("["+this.wartosci_atr_i_decyzja[j][i]+" "+ixx+"]");
               
                }
                else{
                System.out.print("["+ixx+"]");
                }
                 ixx++;
            }
             System.out.println();
        }
        
    }
     /**
     * metoda zwracajaca klasyfikacje do stringa
     */
    public String print_string_format(){
        String temp="";
        boolean atrybuty=true;
        for(int i=0;i<this.tablica.length;i++){
            for(int j=0;j<this.tablica[i].length;j++)
            {
                if(this.tablica[i][j]!=null){
                temp+="["+this.tablica[i][j]+"]";
                
                }
                else{
                    temp+=" , ";
                }
            }
             temp+=" \n ";
        }
        return temp;
    }
    
    /**
     * metoda drukujaca w consoli tablice atrybutow klasyfikacji
     */
    public void print_in_console_atrybuty()
    {
            for(int i=0;i<this.atrybuty.length;i++)
            {
                if(this.atrybuty[i]!=null){
                System.out.print("["+this.atrybuty[i].getNazwa()+"]");
                }
                else{
                System.out.print("[]");
                }
            }
             System.out.println("");
    }
          /**
     * metoda zwracajaca ilosc atrybutow 
     */
    public int ile_atrybutow(){

    return atrybuty.length;
    }
    
        public static String klasyfikacja(String outlook, boolean windy, double humidity) {
    if (outlook.equals("sunny")) {
        if (humidity <= 75) {
            return "yes";
        }
        else if (humidity > 75) {
            return "no";
        }
    }
    else if (outlook.equals("overcast")) {
        return "yes";
    }
    else if (outlook.equals("rainy")) {
        if (windy == true) {
            return "no";
        }
        else if (windy == false) {
            return "yes";
        }
    }
    return null;
}
}
