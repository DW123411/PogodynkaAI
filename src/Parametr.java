public class Parametr implements ElementDrzewa {
    private String nazwa;
    private boolean wartosc;
    private boolean czyLiczba;
    private int wartoscLiczbowa;

    public Parametr(){
        nazwa = "";
        wartosc = false;
        czyLiczba = false;
        wartoscLiczbowa = 0;
    }

    public Parametr(String nazwa, boolean wartosc){
        this.nazwa = nazwa;
        this.wartosc = wartosc;
        czyLiczba = false;
    }

    public Parametr(String nazwa, int wartoscLiczbowa){
        this.nazwa = nazwa;
        this.wartoscLiczbowa = wartoscLiczbowa;
        czyLiczba = true;
    }

    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }

    public void setWartosc(boolean wartosc){
        this.wartosc = wartosc;
    }

    public void setCzyLiczba(boolean czyLiczba){
        this.czyLiczba = czyLiczba;
    }

    public void setWartoscLiczbowa(int wartoscLiczbowa){
        this.wartoscLiczbowa = wartoscLiczbowa;
    }

    public String getNazwa(){
        return nazwa;
    }

    public boolean getWartosc(){
        return wartosc;
    }

    public boolean getCzyLiczba(){
        return czyLiczba;
    }

    public int getWartoscLiczbowa(){
        return wartoscLiczbowa;
    }

    public String toString(){
        if(czyLiczba) {
            return nazwa + ", " + wartoscLiczbowa;
        }else{
            return nazwa + ", " + wartosc;
        }
    }
}
