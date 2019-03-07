public class Parametr implements ElementDrzewa {
    private String nazwa;
    private boolean wartosc;

    public Parametr(){
        nazwa = "";
        wartosc = false;
    }

    public Parametr(String nazwa, boolean wartosc){
        this.nazwa = nazwa;
        this.wartosc = wartosc;
    }

    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }

    public void setWartosc(boolean wartosc){
        this.wartosc = wartosc;
    }

    public String getNazwa(){
        return nazwa;
    }

    public boolean getWartosc(){
        return wartosc;
    }

    public String toString(){
        return nazwa+", "+wartosc;
    }
}
