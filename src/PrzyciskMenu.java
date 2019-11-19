import javax.swing.*;

public class PrzyciskMenu extends JMenuItem {
    private ElementDrzewa element;

    public PrzyciskMenu(String s) {
        super(s);
    }

    public ElementDrzewa getElement() {
        return element;
    }

    public void setElement(ElementDrzewa element) {
        this.element = element;
    }

    public void addActionListener(Okno okno) {
    }
}
