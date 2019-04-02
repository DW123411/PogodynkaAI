public class Klasyfikacja{
     private String[][] tablica;
     
     /**
      *  zwykły konstruktor klasy klasyfikacja ze stałym rozmiarem 50x50
      */
    public Klasyfikacja(){
        this.tablica = new String[50][50];
    
    }
    /**
     * konstruktor ze zmienna ścieżka typu string. buduje klase na podstawie podanej ścieżki pliku
     */
    public Klasyfikacja(String Ścieżka){
        this.tablica = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja();
    }
    /**
     * seter tablicy klasyfikacji ze zmienna wejsciowa sciezka pliku
     */
    public void set_klasyfikacja_z_pliku(String Ścieżka){
    this.tablica = Wczytywanie.wczytajKlasyfikacjeZPliku(Ścieżka).get_klasyfikacja();
        
    }
    /**
     * geter klasyfikacji, ktory zwraca tablice 2 wymiarowa
     */
    public String[][] get_klasyfikacja(){
    return this.tablica;
    }
    /**
     *  metoda zwracajaca liczbe elementow w tablicy
     */
    public int ile_elementow(){
        int ilosc = 0;
        for(int i=0;i<this.tablica.length;i++){
            for(int j=0;j<this.tablica[i].length;j++)
            {
                if(this.tablica[i][j]!=null){
                ilosc++;
                }
            }
        }
        return ilosc;
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
