public class WartoscAtrybutu implements ElementDrzewa {
    private String nazwa;
    private boolean wartosc;
    private boolean czyLiczba;
    private int wartoscLiczbowa;
    private int iloscTrue;
    private int iloscFalse;

    public WartoscAtrybutu(){
        nazwa = "";
        wartosc = false;
        czyLiczba = false;
        wartoscLiczbowa = 0;
        iloscTrue = 0;
        iloscFalse = 0;
    }

    public WartoscAtrybutu(String nazwa, boolean wartosc){
        this.nazwa = nazwa;
        this.wartosc = wartosc;
        czyLiczba = false;
        if(wartosc){
            iloscTrue = 1;
            iloscFalse = 0;
        }else{
            iloscTrue = 0;
            iloscFalse = 1;
        }
    }

    public WartoscAtrybutu(String nazwa, int wartoscLiczbowa){
        this.nazwa = nazwa;
        this.wartoscLiczbowa = wartoscLiczbowa;
        czyLiczba = true;
        if(wartosc){
            iloscTrue = 1;
            iloscFalse = 0;
        }else{
            iloscTrue = 0;
            iloscFalse = 1;
        }
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

    public void setIloscTrue(int iloscTrue){
        this.iloscTrue = iloscTrue;
    }

    public void setIloscFalse(int iloscFalse){
        this.iloscFalse = iloscFalse;
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

    public int getIloscTrue(){
        return iloscTrue;
    }

    public int getIloscFalse(){
        return iloscFalse;
    }

    public void iloscTrueInc(){
        iloscTrue++;
    }

    public void iloscFalseInc(){
        iloscFalse++;
    }

    public String toString(){
        if(czyLiczba) {
            return nazwa + ", " + wartoscLiczbowa;
        }else{
            return nazwa + ", " + wartosc;
        }
    }
}
