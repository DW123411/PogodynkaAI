import javax.swing.*;

public class PrzyciskDrzewo extends JButton {
    private Wezel wezel;

    public PrzyciskDrzewo(String s) {
        super(s);
    }

    public Wezel getWezel() {
        return wezel;
    }

    public void setWezel(Wezel wezel) {
        this.wezel = wezel;
    }

    public void addActionListener(Okno okno) {
    }
}
