import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Menuski extends JMenuBar {
    public JButton wycz, wyś, skalowanie, zam, zal, cred, save, tree, klasyfikacja_z_pliku, klasyfikacja_z_pliku2, show_klasyfikacja, accuracy, jpeg, pokaz, rekord3,glebokosc1,theme;
    public JLabel zbior;
    public JTextArea rekord;
    public JTextField rekord2;
    public JLabel glebokosc;
    public JTextField glebokoscrekord;
    private int motyw;
    private int dark;


    public Menuski() {
        //JPanel rozklad = new JPanel();
        javax.swing.ToolTipManager.sharedInstance().setInitialDelay(500);
        javax.swing.ToolTipManager.sharedInstance().setDismissDelay(1000);

        if(Okno.dark==1){
            setDark(1);
        }
        else setDark(0);
        if(Okno.moty==1){
            setMotyw(1);
        }
        else setMotyw(0);
        
        
        
        
        setBorder(new TitledBorder(
                new TitledBorder(
                        LineBorder.createGrayLineBorder(),
                        "Menu"),
                "",
                TitledBorder.RIGHT,
                TitledBorder.BOTTOM));
        ImageIcon imgIcon = null;
        ImageIcon imgIcon2 = null;
        ImageIcon imgIcon3 = null;
        ImageIcon imgIcon4 = null;
        ImageIcon imgIcon5 = null;
        ImageIcon imgIcon6 = null;
        ImageIcon imgIcon7 =null;
        ImageIcon imgIcon8 = null;
        ImageIcon imgIcon9 = null;
        ImageIcon imgIcon10=null;
        ImageIcon imgIcon11=null;
        ImageIcon imgIcon12=null;
        ImageIcon imgIcon13=null;
        ImageIcon imgIcon14=null;
        ImageIcon imgIcon_theme = null;

        if(motyw==0){
            if(dark==0){
                imgIcon = new ImageIcon(getClass().getResource("icons/info.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/rysuj.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/delete.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/show2.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes.png"));
            }
            if(dark==1){
                imgIcon = new ImageIcon(getClass().getResource("icons/info.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/rysuj.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowaniedrk.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/show2.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth.png"));
                imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes.png"));
            }}
        else if(motyw==1){
            imgIcon = new ImageIcon(getClass().getResource("icons/dudko.png"));
            imgIcon2 = new ImageIcon(getClass().getResource("icons/hudymson.png"));
            imgIcon3 = new ImageIcon(getClass().getResource("icons/husar.png"));
            imgIcon4 = new ImageIcon(getClass().getResource("icons/karpinski.png"));
            imgIcon5 = new ImageIcon(getClass().getResource("icons/knychalson.png"));
            imgIcon6 = new ImageIcon(getClass().getResource("icons/macowiec.png"));
            imgIcon7 = new ImageIcon(getClass().getResource("icons/marciniak.png"));
            imgIcon8 = new ImageIcon(getClass().getResource("icons/tetris.png"));
            imgIcon9 = new ImageIcon(getClass().getResource("icons/zuraw.png"));
            imgIcon10 = new ImageIcon(getClass().getResource("icons/wojtech.png"));
            imgIcon11 = new ImageIcon(getClass().getResource("icons/sygula.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes.png"));
        }


        cred = new JButton("<html></html>");
        cred.setIcon(imgIcon);
        cred.setToolTipText("<html>O Programie</html>");
        cred.setPreferredSize(new Dimension(32, 32));
        cred.setMaximumSize(new Dimension(32, 32));

        save = new JButton("<html></html>");
        save.setIcon(imgIcon4);
        save.setToolTipText("<html>Zapisz Jako TXT</html>");
        save.setPreferredSize(new Dimension(32, 32));
        save.setMaximumSize(new Dimension(32, 32));

        skalowanie = new JButton("<html></html>");
        skalowanie.setIcon(imgIcon9);
        skalowanie.setToolTipText("<html>Skalowanie 3/4 obrazu </html>");
        skalowanie.setPreferredSize(new Dimension(32, 32));
        skalowanie.setMaximumSize(new Dimension(32, 32));

        pokaz = new JButton("<html>Pokaz Tabele</html>");
        pokaz.setIcon(imgIcon12);
        pokaz.setToolTipText("<html>Pokazywanie tabelki </html>");
        pokaz.setPreferredSize(new Dimension(32, 32));
        pokaz.setMaximumSize(new Dimension(32, 32));


        tree = new JButton("<html></html>");
        tree.setIcon(imgIcon4);
        tree.setToolTipText("<html>Zapisz drzewo jako TXT</html>");
        tree.setPreferredSize(new Dimension(32, 32));
        tree.setMaximumSize(new Dimension(32, 32));

        klasyfikacja_z_pliku = new JButton("<html></html>");
        klasyfikacja_z_pliku.setIcon(imgIcon5);
        klasyfikacja_z_pliku.setToolTipText("<html>Wczytaj dane wejściowe<br />z pliku</html>");
        klasyfikacja_z_pliku.setPreferredSize(new Dimension(32, 32));
        klasyfikacja_z_pliku.setMaximumSize(new Dimension(32, 32));

        klasyfikacja_z_pliku2 = new JButton("<html></html>");
        klasyfikacja_z_pliku2.setIcon(imgIcon11);
        klasyfikacja_z_pliku2.setToolTipText("<html>Wczytaj dane do<br />wyboru decyzji</html>");
        klasyfikacja_z_pliku2.setPreferredSize(new Dimension(32, 32));
        klasyfikacja_z_pliku2.setMaximumSize(new Dimension(32, 32));

        show_klasyfikacja = new JButton("<html></html>");
        show_klasyfikacja.setIcon(imgIcon8);
        show_klasyfikacja.setToolTipText("<html>Wyświetl Klasyfikację</html>");
        show_klasyfikacja.setPreferredSize(new Dimension(32, 32));
        show_klasyfikacja.setMaximumSize(new Dimension(32, 32));

        wyś = new JButton("<html></html>");
        wyś.setIcon(imgIcon6);
        wyś.setToolTipText("<html>Rysuj  Drzewo</html>");
        wyś.setPreferredSize(new Dimension(32, 32));
        wyś.setMaximumSize(new Dimension(32, 32));

        zal = new JButton("<html></html>");
        zal.setToolTipText("<html>Wczytaj Drzewo</html>");
        zal.setIcon(imgIcon5);
        zal.setPreferredSize(new Dimension(32, 32));
        zal.setMaximumSize(new Dimension(32, 32));

        wycz = new JButton("<html></html>");
        wycz.setIcon(imgIcon7);
        wycz.setToolTipText("<html>Wyczyść</html>");
        wycz.setPreferredSize(new Dimension(32, 32));
        wycz.setMaximumSize(new Dimension(32, 32));

        rekord3 = new JButton("<html></html>");
        rekord3.setIcon(imgIcon13);
        rekord3.setToolTipText("<html>Rozmiary Zbiorów</html>");
        rekord3.setPreferredSize(new Dimension(32, 32));
        rekord3.setMaximumSize(new Dimension(32, 32));

        zam = new JButton("<html></html>");
        zam.setIcon(imgIcon3);
        zam.setToolTipText("<html>Wyjście z programu</html>");
        zam.setPreferredSize(new Dimension(32, 32));
        zam.setMaximumSize(new Dimension(32, 32));

        jpeg = new JButton("<html></html>");
        jpeg.setIcon(imgIcon2);
        jpeg.setToolTipText("<html>Zapisz jako obraz</html>");
        jpeg.setPreferredSize(new Dimension(32, 32));
        jpeg.setMaximumSize(new Dimension(32, 32));


     accuracy = new JButton("<html></html>");
        accuracy.setIcon(imgIcon10);
        accuracy.setToolTipText("<html>Dokładność.</html>");
        accuracy.setPreferredSize(new Dimension(32, 32));
        accuracy.setMaximumSize(new Dimension(32, 32));

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


        glebokosc1 = new JButton("<html></html>");
        glebokosc1.setIcon(imgIcon14);
        glebokosc1.setToolTipText("<html>Rozmiar maksymalnej głębokości</html>");
        glebokosc1.setPreferredSize(new Dimension(30, 30));
        glebokosc1.setMaximumSize(new Dimension(30, 30));


        theme = new JButton("<html></html>");
        theme.setIcon(imgIcon_theme);
        theme.setToolTipText("<html>Wybieranie Motywu </html>");
        theme.setPreferredSize(new Dimension(30, 30));
        theme.setMaximumSize(new Dimension(30, 30));
        
        
        add(wyś, BorderLayout.WEST);
        //add(zal, BorderLayout.WEST);
        add(klasyfikacja_z_pliku, BorderLayout.WEST);
        add(klasyfikacja_z_pliku2, BorderLayout.WEST);
        //add(show_klasyfikacja, BorderLayout.WEST);
        add(wycz, BorderLayout.WEST);
        add(save, BorderLayout.WEST);
        //add(tree, BorderLayout.WEST);
        add(jpeg, BorderLayout.WEST);
        //add(zbior, BorderLayout.WEST);
        //add(rekord2, BorderLayout.WEST);
        add(rekord3, BorderLayout.WEST);
        add(glebokosc1, BorderLayout.WEST);
        add(skalowanie, BorderLayout.WEST);
        add(cred, BorderLayout.WEST);
        add(pokaz, BorderLayout.WEST);

                add(accuracy, BorderLayout.WEST);
       
                    add(theme, BorderLayout.WEST);
                add(zam, BorderLayout.EAST);

    
        //add(glebokosc, BorderLayout.WEST);
        //add(glebokoscrekord, BorderLayout.WEST);
    }
    public void setMotyw(int motyw){
        this.motyw=motyw;
    }

    public void setDark(int dark){
        this.dark=dark;
    }
    public int getMotyw(){
        return motyw;
    }



}
