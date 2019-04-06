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


public class Menuski extends JMenuBar
{
    JButton wycz, wyś, zam, zal, cred, save, klasyfikacja_z_pliku, show_klasyfikacja ;
    



    public Menuski()
    {         
        //JPanel rozklad = new JPanel();
        
         cred = new JButton("O programie");
        cred.setPreferredSize(new Dimension(50, 50));
        save = new JButton("Zapisz");
        save.setPreferredSize(new Dimension(50, 50));
        klasyfikacja_z_pliku = new JButton("Wczytaj klasyfikację z pliku");
        klasyfikacja_z_pliku.setPreferredSize(new Dimension(50, 50));
        show_klasyfikacja = new JButton("Wyświetl klasyfikację");
        show_klasyfikacja.setPreferredSize(new Dimension(50, 50));
        wyś = new JButton("Rysuj Drzewo");
        wyś.setPreferredSize(new Dimension(50, 50));
        zal = new JButton("Wczytaj Drzewo");
        zal.setPreferredSize(new Dimension(50, 50));
        wycz = new JButton("Wyczyść");
        wycz.setPreferredSize(new Dimension(50, 50));
        zam = new JButton("Zamknij");
        zam.setPreferredSize(new Dimension(50, 50));
        add(zal, BorderLayout.CENTER); 
        add(wyś, BorderLayout.CENTER);
        add(klasyfikacja_z_pliku, BorderLayout.CENTER); 
        add(show_klasyfikacja, BorderLayout.CENTER);
        add(zam, BorderLayout.EAST);
        add(wycz, BorderLayout.EAST);
        add(cred, BorderLayout.EAST);
        add(save, BorderLayout.EAST);
    }
}
