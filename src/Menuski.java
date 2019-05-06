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
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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
           
            
            ImageIcon imgIcon = new ImageIcon("icons/info.png");
            ImageIcon imgIcon2 = new ImageIcon("icons/save.png");
            ImageIcon imgIcon3 = new ImageIcon("icons/cancel.png");
            ImageIcon imgIcon4 = new ImageIcon("icons/saveText.png");
            ImageIcon imgIcon5 = new ImageIcon("icons/wczytaj.png");
            ImageIcon imgIcon6 = new ImageIcon("icons/rysuj.png");
            ImageIcon imgIcon7 = new ImageIcon("icons/delete.png");
            ImageIcon imgIcon8 = new ImageIcon("icons/view.png");
         cred = new JButton("<html></html>");
         cred.setIcon(imgIcon);
         cred.setToolTipText("<html>O Programie</html>");
        cred.setPreferredSize(new Dimension(30, 30));
        cred.setMaximumSize(new Dimension(30, 30));

        save = new JButton("<html></html>");
        save.setIcon(imgIcon4);
        save.setToolTipText("<html>Zapisz Jako TXT</html>");
        save.setPreferredSize(new Dimension(30, 30));
        save.setMaximumSize(new Dimension(30, 30));

        klasyfikacja_z_pliku = new JButton("<html></html>");
        klasyfikacja_z_pliku.setIcon(imgIcon5);
        klasyfikacja_z_pliku.setToolTipText("<html>Wczytaj Klasyfikację<br />z Pliku</html>");
        klasyfikacja_z_pliku.setPreferredSize(new Dimension(30, 30));
        klasyfikacja_z_pliku.setMaximumSize(new Dimension(30, 30));

        show_klasyfikacja = new JButton("<html></html>");
        show_klasyfikacja.setIcon(imgIcon8);
        show_klasyfikacja.setToolTipText("<html>Wyświetl Klasyfikację</html>");
        show_klasyfikacja.setPreferredSize(new Dimension(30, 30));
        show_klasyfikacja.setMaximumSize(new Dimension(30, 30));

        wyś = new JButton("<html></html>");
        wyś.setIcon(imgIcon6);
        wyś.setToolTipText("<html>Rysuj  Drzewo</html>");
        wyś.setPreferredSize(new Dimension(30, 30));
        wyś.setMaximumSize(new Dimension(30, 30));

        zal = new JButton("<html></html>");
        zal.setToolTipText("<html>Wczytaj Drzewo</html>");
        zal.setIcon(imgIcon5);
        zal.setPreferredSize(new Dimension(30, 30));
        zal.setMaximumSize(new Dimension(30, 30));

        wycz = new JButton("<html></html>");
        wycz.setIcon(imgIcon7);
        wycz.setToolTipText("<html>Wyczyść</html>");
        wycz.setPreferredSize(new Dimension(30, 30));
        wycz.setMaximumSize(new Dimension(30, 30));

        zam = new JButton("<html></html>");
        zam.setIcon(imgIcon3);
        zam.setToolTipText("<html>Wyjście z programu</html>");
        zam.setPreferredSize(new Dimension(30, 30));
        zam.setMaximumSize(new Dimension(30, 30));

        jpeg = new JButton("<html></html>");
        jpeg.setIcon(imgIcon2);
        jpeg.setToolTipText("<html>Zapisz Jako Obraz</html>");
        jpeg.setPreferredSize(new Dimension(30, 30));
        jpeg.setMaximumSize(new Dimension(30, 30));


        add(wyś, BorderLayout.WEST);
        add(zal, BorderLayout.WEST); 
        add(klasyfikacja_z_pliku, BorderLayout.WEST); 
        add(show_klasyfikacja, BorderLayout.WEST);
        add(wycz, BorderLayout.WEST);
        add(save, BorderLayout.WEST);
        add(jpeg, BorderLayout.WEST);
        add(cred, BorderLayout.WEST);
        add(zam, BorderLayout.WEST);
    }
    
}
