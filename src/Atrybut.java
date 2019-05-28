public class Atrybut implements ElementDrzewa {
    private String nazwa;
    private double entropia;

    public Atrybut(){
        nazwa = "";
        entropia = 0;
    }

    public Atrybut(String nazwa){
        this.nazwa = nazwa;
        entropia = 0;
    }

    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }

    public void setEntropia(double entropia){
        this.entropia = entropia;
    }

    public String getNazwa(){
        return nazwa;
    }

    public double getEntropia(){
        return entropia;
    }

    public String toString(){
        return nazwa;
    }
}
