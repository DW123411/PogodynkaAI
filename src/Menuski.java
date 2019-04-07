import javax.swing.*;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.*;

public class Menuski extends JMenuBar
{
    JButton wycz, wyś, zam, zal, cred, save, klasyfikacja_z_pliku, show_klasyfikacja, jpeg ;



    public Menuski()
    {         
        //JPanel rozklad = new JPanel();
        
        
        setBorder(new TitledBorder (
        new TitledBorder(
        LineBorder.createGrayLineBorder(),
            "Menu"),
            "",
            TitledBorder.RIGHT,
            TitledBorder.BOTTOM));
    
         cred = new JButton("<html>O Programie</html>");
         cred.setToolTipText("<html>O Programie</html>");
        cred.setPreferredSize(new Dimension(55, 50));
        cred.setMaximumSize(new Dimension(111, 50));

        save = new JButton("<html>Zapisz Jako TXT</html>");
        save.setToolTipText("<html>Zapisz Jako TXT</html>");
        save.setPreferredSize(new Dimension(50, 50));
        save.setMaximumSize(new Dimension(111, 50));

        klasyfikacja_z_pliku = new JButton("<html>Wczytaj Klasyfikację<br />z Pliku</html>");
        klasyfikacja_z_pliku.setToolTipText("<html>Wczytaj Klasyfikację<br />z Pliku</html>");
        klasyfikacja_z_pliku.setPreferredSize(new Dimension(50, 50));
        klasyfikacja_z_pliku.setMaximumSize(new Dimension(111, 50));

        show_klasyfikacja = new JButton("<html>Wyświetl Klasyfikację</html>");
        show_klasyfikacja.setToolTipText("<html>Wyświetl Klasyfikację</html>");
        show_klasyfikacja.setPreferredSize(new Dimension(50, 50));
        show_klasyfikacja.setMaximumSize(new Dimension(111, 50));

        wyś = new JButton("<html>Rysuj  Drzewo</html>");
        wyś.setToolTipText("<html>Rysuj  Drzewo</html>");
        wyś.setPreferredSize(new Dimension(50, 50));
        wyś.setMaximumSize(new Dimension(111, 50));

        zal = new JButton("<html>Wczytaj Drzewo</html>");
        zal.setToolTipText("<html>Wczytaj Drzewo</html>");
        zal.setPreferredSize(new Dimension(50, 50));
        zal.setMaximumSize(new Dimension(111, 50));

        wycz = new JButton("<html>Wyczyść</html>");
        wycz.setToolTipText("<html>Wyczyść</html>");
        wycz.setPreferredSize(new Dimension(50, 50));
        wycz.setMaximumSize(new Dimension(111, 50));

        zam = new JButton("<html>Zamknij</html>");
        zam.setToolTipText("<html>Wyjście z programu</html>");
        zam.setPreferredSize(new Dimension(50, 50));
        zam.setMaximumSize(new Dimension(111, 50));

        jpeg = new JButton("<html>Zapisz Jako Obraz</html>");
        jpeg.setToolTipText("<html>Zapisz Jako Obraz</html>");
        jpeg.setPreferredSize(new Dimension(50, 50));
        jpeg.setMaximumSize(new Dimension(111, 50));



        add(zal, BorderLayout.WEST); 
        add(wyś, BorderLayout.WEST);
        add(klasyfikacja_z_pliku, BorderLayout.WEST); 
        add(show_klasyfikacja, BorderLayout.WEST);
        add(wycz, BorderLayout.WEST);
        add(save, BorderLayout.WEST);
        add(jpeg, BorderLayout.WEST);
        add(cred, BorderLayout.WEST);
        add(zam, BorderLayout.WEST);
    }
}
