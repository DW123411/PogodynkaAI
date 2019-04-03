import javax.swing.*;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Menuski extends JMenuBar
{
    JMenu operacje = new JMenu ("Operacje...");

    JMenuItem showtree = new JMenuItem("Rysuj drzewo");
    JMenuItem tree = new JMenuItem("Wczytaj drzewo z pliku");
    JMenuItem klasyfikacja_z_pliku= new JMenuItem("Wczytaj klasyfikację z pliku");
    JMenuItem show_klasyfikacja= new JMenuItem("Wyświetl klasyfikację");
    JMenuItem clean = new JMenuItem("Wyczyść");
    JMenuItem credits = new JMenuItem("O programie");
    JMenuItem exit = new JMenuItem("Wyjdź z programu");

    /**
     * do zrobienia
     */
    JMenuItem savetree = new JMenuItem("Zapisz Drzewo");


    public Menuski()
    {         
        //JPanel rozklad = new JPanel();
        operacje.add(showtree);
        operacje.add(tree);
        operacje.add(klasyfikacja_z_pliku);
        operacje.add(show_klasyfikacja);
        operacje.add(clean);
        operacje.add(new JSeparator());
        operacje.add(credits);

        operacje.add(exit);

        add(operacje);

    }
}
