public class Klasyfikacja{
     private String[][] tablica;
     private Object[][] dane;
     /**
      *  zwykły konstruktor klasy klasyfikacja ze stałym rozmiarem 50x50
      */
    public Klasyfikacja(){
        this.tablica = new String[50][50];
        this.dane = new Object[50][50];
    }
     /**
      *  konstruktor klasy klasyfikacja z ustalonym rozmiarem tablicy danymi wejsciowymi x i y
      */
    public Klasyfikacja(int y, int x){
        this.tablica = new String[y][x];
           this.dane = new Object[y][x];
    }
    /**
     * konstruktor ze zmienna ścieżka typu string. buduje klase na podstawie podanej ścieżki pliku
     */
    public Klasyfikacja(String Ścieżka){
        this.tablica = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja_string();    
                this.dane = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja();
            }
    /**
     * seter tablicy klasyfikacji ze zmienna wejsciowa sciezka pliku
     */
    public void set_klasyfikacja_z_pliku_string(String Ścieżka){
    this.tablica = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja_string();
        
    }
    /**
     * seter tablicy klasyfikacji ze zmienna wejsciowa sciezka pliku
     */
    public void set_klasyfikacja_z_pliku(String Ścieżka){
    this.dane = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja();
        
    }
    /**
     * seter tablicy klasyfikacji ze zmienna wejsciowa tablica dwuwymiarowa typu String[][]
     */
    public void set_klasyfikacja_tablica(Object[][] tab){
    this.dane= tab;
    }
     /**
     * seter tablicy klasyfikacji ze zmienna wejsciowa tablica dwuwymiarowa typu String[][]
     */
    public void set_klasyfikacja_tablica_string(String[][] tab){
    this.tablica= tab;
    }
    /**
     * geter klasyfikacji, ktory zwraca tablice 2 wymiarowa
     */
    public Object[][] get_klasyfikacja(){
    return this.dane;
    }
    /**
     * geter klasyfikacji, ktory zwraca tablice 2 wymiarowa
     */
    public String[][] get_klasyfikacja_string(){
    return this.tablica;
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
