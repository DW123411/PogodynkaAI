package src;

import java.util.LinkedList;

public class Wezel<T> {
    private T dane;
    private Wezel<T> rodzic;
    private LinkedList<Wezel<T>> dzieci;
    private int x; //współrzedne x potrzebne do dynamycznego wyświetlania drzewa
    private int y; //współrzedne y potrzebne do dynamicznego wyświetlania drzewa
    private int poczatekDostepnegoMiejsca; //współrzędna określająca początek dostępnego miejsca dla danego węzła
    private int koniecDostepnegoMiejsca; //współrzędna określająca koniec dostępnego miejsca dla danego węzła


    public Wezel() {
        rodzic = null;
        dzieci = new LinkedList<Wezel<T>>();
    }

    public Wezel(Wezel<T> rodzic) {
        this();
        this.rodzic = rodzic;
    }

    public Wezel(Wezel<T> rodzic, T dane) {
        this(rodzic);
        this.dane = dane;
    }

    public Wezel<T> getRodzic() {
        return rodzic;
    }

    public void setRodzic(Wezel<T> rodzic) {
        this.rodzic = rodzic;
    }

    public T getDane() {
        return dane;
    }

    public void setDane(T dane) {
        this.dane = dane;
    }

    public int getStopien() {
        return dzieci.size();
    }

    public Wezel<T> getDziecko(int i) {
        return dzieci.get(i);
    }

    public boolean czyLisc() {
        return dzieci.isEmpty();
    }

    public Wezel<T> dodajDziecko(Wezel<T> dziecko) {
        dziecko.setRodzic(this);
        dzieci.add(dziecko);
        return dziecko;
    }

    public Wezel<T> dodajDziecko(T dane) {
        Wezel<T> dziecko = new Wezel<T>(this, dane);
        dzieci.add(dziecko);
        return dziecko;
    }

    public Wezel<T> usunDziecko(int i) {
        return dzieci.remove(i);
    }

    public void usunDzieci() {
        dzieci.clear();
    }

    public Wezel<T> getPierwszeDzieckoPoLewej() {
        if (dzieci.isEmpty()) return null;
        return dzieci.get(0);
    }

    public LinkedList<Wezel<T>> getDzieci() {
        if (dzieci.isEmpty()) return null;
        return dzieci;
    }

    public Wezel<T> getPraweRodzenstwo() {
        if (rodzic != null) {
            LinkedList<Wezel<T>> dzieciRodzic = rodzic.getDzieci();
            int pozycja = dzieciRodzic.indexOf(this);
            if (dzieciRodzic.size() > pozycja + 1)
                return dzieciRodzic.get(pozycja + 1);
        }
        return null;
    }

    public String toString() {
        return dane.toString();
    }

    public int getLiczbaDzieci() {
        if (dzieci.isEmpty()) return 0;
        return dzieci.size();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPoczatekDostepnegoMiejsca() {
        return poczatekDostepnegoMiejsca;
    }

    public void setPoczatekDostepnegoMiejsca(int w) {
        poczatekDostepnegoMiejsca = w;
    }

    public int getKoniecDostepnegoMiejsca() {
        return koniecDostepnegoMiejsca;
    }

    public void setKoniecDostepnegoMiejsca(int w) {
        koniecDostepnegoMiejsca = w;
    }

}
