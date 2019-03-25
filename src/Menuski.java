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

    JMenuItem tree = new JMenuItem("Wczytaj drzewo z Pliku");
    
    JMenuItem showtree = new JMenuItem("Rysuj Drzewo");

    JMenuItem exit = new JMenuItem("Wyjdź z programu");

    JMenuItem credits = new JMenuItem("O programie");

    JMenuItem clean = new JMenuItem("Wyczyść");
    public Menuski()
    {         
        //JPanel rozklad = new JPanel();
        operacje.add(showtree);
        operacje.add(tree);
        operacje.add(clean);
        operacje.add(credits);

        operacje.add(exit);
       
        add(operacje);
        
    }
}
