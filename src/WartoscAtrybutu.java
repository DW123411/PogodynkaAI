public class WartoscAtrybutu implements ElementDrzewa {
    private String nazwa;

    public WartoscAtrybutu() {
        nazwa = "";
    }

    public WartoscAtrybutu(String nazwa) {
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
