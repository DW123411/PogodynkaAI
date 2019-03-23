public class Atrybut implements ElementDrzewa {
    private String nazwa;

    public Atrybut(){
        nazwa = "";
    }

    public Atrybut(String nazwa){
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
