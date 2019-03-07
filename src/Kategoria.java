public class Kategoria implements ElementDrzewa {
    private String nazwa;

    public Kategoria(){
        nazwa = "";
    }

    public Kategoria(String nazwa){
        this.nazwa = nazwa;
    }

    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }

    public String getNazwa(){
        return nazwa;
    }

    public String toString(){
        return nazwa;
    }
}
