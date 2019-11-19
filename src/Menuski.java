import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Menuski extends JMenuBar {
    public JButton wycz, wyś, skalowanie, zam, zal, cred, save, tree, klasyfikacja_z_pliku, show_klasyfikacja, jpeg, pokaz, decyzja_okno;
    public JLabel zbior;
    public JTextArea rekord;
    public JTextField rekord2;
    public JLabel glebokosc;
    public JTextField glebokoscrekord;

    public Menuski() {
        //JPanel rozklad = new JPanel();


        setBorder(new TitledBorder(
                new TitledBorder(
                        LineBorder.createGrayLineBorder(),
                        "Menu"),
                "",
                TitledBorder.RIGHT,
                TitledBorder.BOTTOM));


        ImageIcon imgIcon = new ImageIcon(getClass().getResource("icons/info.png"));
        ImageIcon imgIcon2 = new ImageIcon(getClass().getResource("icons/save.png"));
        ImageIcon imgIcon3 = new ImageIcon(getClass().getResource("icons/cancel.png"));
        ImageIcon imgIcon4 = new ImageIcon(getClass().getResource("icons/saveText.png"));
        ImageIcon imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj.png"));
        ImageIcon imgIcon6 = new ImageIcon(getClass().getResource("icons/rysuj.png"));
        ImageIcon imgIcon7 = new ImageIcon(getClass().getResource("icons/delete.png"));
        ImageIcon imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
        ImageIcon imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie.png"));

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

        skalowanie = new JButton("<html></html>");
        skalowanie.setIcon(imgIcon9);
        skalowanie.setToolTipText("<html>Skalowanie 3/4 obrazu </html>");
        skalowanie.setPreferredSize(new Dimension(30, 30));
        skalowanie.setMaximumSize(new Dimension(30, 30));

        pokaz = new JButton("<html>Pokaz Tabele</html>");
        pokaz.setIcon(imgIcon9);
        pokaz.setToolTipText("<html>Pokazywanie tabelki </html>");
        pokaz.setPreferredSize(new Dimension(30, 30));
        pokaz.setMaximumSize(new Dimension(30, 30));


        tree = new JButton("<html></html>");
        tree.setIcon(imgIcon4);
        tree.setToolTipText("<html>Zapisz drzewo jako TXT</html>");
        tree.setPreferredSize(new Dimension(30, 30));
        tree.setMaximumSize(new Dimension(30, 30));

        klasyfikacja_z_pliku = new JButton("<html></html>");
        klasyfikacja_z_pliku.setIcon(imgIcon5);
        klasyfikacja_z_pliku.setToolTipText("<html>Wczytaj dane wejściowe<br />z pliku</html>");
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
        jpeg.setToolTipText("<html>Zapisz jako obraz</html>");
        jpeg.setPreferredSize(new Dimension(30, 30));
        jpeg.setMaximumSize(new Dimension(30, 30));

        decyzja_okno = new JButton("<html></html>");
        decyzja_okno.setIcon(imgIcon3);
        decyzja_okno.setToolTipText("<html>Wyświetl okno decyzji</html>");
        decyzja_okno.setPreferredSize(new Dimension(30, 30));
        decyzja_okno.setMaximumSize(new Dimension(30, 30));

        zbior = new JLabel("<html>Ilość rekordów</html>");
        zbior.setToolTipText("<html>Ilość rekordów:</html>");
        zbior.setPreferredSize(new Dimension(110, 30));
        zbior.setMaximumSize(new Dimension(110, 30));
        Border border = zbior.getBorder();
        Border margin = new EmptyBorder(10, 10, 10, 10);
        zbior.setBorder(new CompoundBorder(border, margin));


        int TA_ROWS = 1;
        int TA_COLS = 1;

        rekord2 = new JTextField("", 1);
        rekord2.setPreferredSize(new Dimension(50, 20));
        rekord2.setMaximumSize(new Dimension(50, 20));
        rekord2.setMargin(new Insets(0, 5, 0, 5));
        rekord2.setDocument(new Rekord(4));
        rekord2.setCaretPosition(0);


        //rekord = new JTextArea(TA_ROWS, TA_COLS);
        // rekord.setPreferredSize(new Dimension(50, 20));
        //rekord.setMaximumSize(new Dimension(50, 20));
        // rekord.setMargin( new Insets(0,10,0,10) );
        // rekord.setWrapStyleWord(true);
        // rekord.setLineWrap(true);
        // rekord.setDocument(new Rekord(4));
        //rekord.setCaretPosition(0);

        glebokosc = new JLabel("<html>Określ głębokość</html>");
        glebokosc.setToolTipText("<html>Określ głębokość:</html>");
        glebokosc.setPreferredSize(new Dimension(130, 30));
        glebokosc.setMaximumSize(new Dimension(130, 30));
        Border border2 = zbior.getBorder();
        Border margin2 = new EmptyBorder(10, 10, 10, 10);
        glebokosc.setBorder(new CompoundBorder(border, margin));

        glebokoscrekord = new JTextField("", 1);
        glebokoscrekord.setPreferredSize(new Dimension(50, 20));
        glebokoscrekord.setMaximumSize(new Dimension(50, 20));
        glebokoscrekord.setMargin(new Insets(0, 5, 0, 5));
        glebokoscrekord.setDocument(new Rekord(1));
        glebokoscrekord.setCaretPosition(0);

        add(wyś, BorderLayout.WEST);
        //add(zal, BorderLayout.WEST);
        add(klasyfikacja_z_pliku, BorderLayout.WEST);
        //add(show_klasyfikacja, BorderLayout.WEST);
        add(wycz, BorderLayout.WEST);
        add(save, BorderLayout.WEST);
        //add(tree, BorderLayout.WEST);
        add(jpeg, BorderLayout.WEST);
        add(zbior, BorderLayout.WEST);
        add(rekord2, BorderLayout.WEST);
        add(skalowanie, BorderLayout.WEST);
        add(cred, BorderLayout.WEST);
        add(pokaz, BorderLayout.WEST);
        add(decyzja_okno, BorderLayout.WEST);
        add(zam, BorderLayout.WEST);
        add(glebokosc, BorderLayout.WEST);
        add(glebokoscrekord, BorderLayout.WEST);
    }

}
