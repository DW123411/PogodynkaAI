public class Decyzja implements ElementDrzewa {
    private String nazwa;

    public Decyzja() {
        nazwa = "";
    }

    public Decyzja(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String toString() {
        return nazwa;
    }
}
