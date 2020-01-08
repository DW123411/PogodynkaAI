import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Menuski extends JMenuBar {
    public JButton wycz, wyś, skalowanie, zam, zal, cred, save, tree, klasyfikacja_z_pliku,wyswietl_decyzje, klasyfikacja_z_pliku2, show_klasyfikacja, accuracy, jpeg, pokaz, rekord3,glebokosc1,theme;
    public JLabel zbior;
    public JTextArea rekord;
    public JTextField rekord2;
    public JLabel glebokosc;
    public JTextField glebokoscrekord;
    public int motyw;
    public int dark;
    public int colormode;
private ImageIcon imgIcon = null;
        private ImageIcon imgIcon2 = null;
        private ImageIcon imgIcon3 = null;
        private ImageIcon imgIcon4 = null;
        private ImageIcon imgIcon5 = null;
        private ImageIcon imgIcon6 = null;
        private ImageIcon imgIcon7 =null;
        private ImageIcon imgIcon8 = null;
        private ImageIcon imgIcon9 = null;
        private ImageIcon imgIcon10=null;
        private ImageIcon imgIcon11=null;
        private ImageIcon imgIcon12=null;
        private ImageIcon imgIcon13=null;
        private ImageIcon imgIcon14=null;
        private ImageIcon imgIcon_theme = null;

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
        switch(Okno.colormode){
            case 0 : { setColorMode(0);break;}
            case 1 : { setColorMode(1);break;}
            case 2 : { setColorMode(2);break;}
            case 3 : { setColorMode(3);break;}
            case 4 : { setColorMode(4);break;}
            default: { setColorMode(1);  break;}
            
        }
        
        
        
        
        setBorder(new TitledBorder(
                new TitledBorder(
                        LineBorder.createGrayLineBorder(),
                        "Menu"),
                "",
                TitledBorder.RIGHT,
                TitledBorder.BOTTOM));
         imgIcon = null;
         imgIcon2 = null;
         imgIcon3 = null;
         imgIcon4 = null;
         imgIcon5 = null;
         imgIcon6 = null;
         imgIcon7 =null;
         imgIcon8 = null;
         imgIcon9 = null;
         imgIcon10=null;
         imgIcon11=null;
         imgIcon12=null;
         imgIcon13=null;
         imgIcon14=null;
         imgIcon_theme = null;
         
         setMotywButtony(motyw, dark,colormode);

         kreujButtony();
        
        add(wyś, BorderLayout.WEST);

        //add(zal, BorderLayout.WEST);
        add(klasyfikacja_z_pliku, BorderLayout.WEST);
        add(klasyfikacja_z_pliku2, BorderLayout.WEST);
        //add(wyswietl_decyzje,BorderLayout.WEST);
        //add(show_klasyfikacja, BorderLayout.WEST);
      
        
       
        //add(tree, BorderLayout.WEST);
    
        //add(zbior, BorderLayout.WEST);
        //add(rekord2, BorderLayout.WEST);
        add(rekord3, BorderLayout.WEST);
        
        add(glebokosc1, BorderLayout.WEST);
        add(skalowanie, BorderLayout.WEST);
     
       

                add(accuracy, BorderLayout.WEST);
       
           
              
                             add(theme, BorderLayout.WEST);
                               add(new JSeparator());
                                add(pokaz, BorderLayout.EAST);
                               add(wycz, BorderLayout.EAST);
                     add(save, BorderLayout.EAST);   
                    add(jpeg, BorderLayout.EAST);
                        
                       add(cred, BorderLayout.EAST);
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
    
    public void setColorMode(int col){
        this.colormode= col;
    }
    public int getColorMode(){
        return this.colormode;
    }
    
    public void kreujButtony() {
        
        cred = new JButton("<html></html>");
        cred.setIcon(imgIcon);
        cred.setToolTipText("<html>O Programie</html>");
        cred.setPreferredSize(new Dimension(32, 32));
        cred.setMaximumSize(new Dimension(32, 32));

        wyswietl_decyzje = new JButton("<html></html>");
        wyswietl_decyzje.setIcon(imgIcon);
        wyswietl_decyzje.setToolTipText("<html>Wyświetl decyzję</html>");
        wyswietl_decyzje.setPreferredSize(new Dimension(32, 32));
        wyswietl_decyzje.setMaximumSize(new Dimension(32, 32));

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
        accuracy.setToolTipText("<html>Dokładność</html>");
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
        
        
    
    }
    public void setMotywButtony(int motyw, int dark, int col){
        
        if(motyw==0){
            if(dark==0){
                     switch(col){
                        case 0 : { imgIcon = new ImageIcon(getClass().getResource("icons/info_red.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG_red.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit_red.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT_red.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj_red.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree_red.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear_red.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view_red.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie_red.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy_dark_red.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file_red.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/view_red.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size_red.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth_red.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes.png")); break;}
                        case 1 : { imgIcon = new ImageIcon(getClass().getResource("icons/info.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie_green.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/view_green.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth_green.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes.png")); break;}
                        case 2 : { imgIcon = new ImageIcon(getClass().getResource("icons/info_yellow.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG_yellow.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit_yellow.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT_yellow.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj_yellow.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree_yellow.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear_yellow.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie_yellow.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy_dark_yellow.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file_yellow.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/view_yellow.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size_yellow.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth_yellow.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes.png"));; break;}
                        case 3 : { imgIcon = new ImageIcon(getClass().getResource("icons/info_blue.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG_blue.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit_blue.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT_blue.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj_blue.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree_blue.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear_blue.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie_blue.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy_dark_blue.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file_blue.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/view_blue.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size_blue.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth_blue.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes.png")); break;}
                        case 4 : { imgIcon = new ImageIcon(getClass().getResource("icons/info_purple.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG_purple.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit_purple.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT_purple.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj_purple.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree_purple.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear_purple.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view_purple.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie_purple.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy_dark_purple.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file_purple.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/view_purple.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size_purple.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth_purple.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes.png")); break;}
                        default : {
                            
                            
                            imgIcon = new ImageIcon(getClass().getResource("icons/info.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie_red.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/show2.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes.png"));break;}
                    }
                
            }
            if(dark==1){
              switch(col){
                        case 0 : { imgIcon = new ImageIcon(getClass().getResource("icons/info_red.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG_red.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit_red.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT_red.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj_red.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree_red.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear_red.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie_red.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy_red.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file_red.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/view_red.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size_red.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth_red.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes_dark.png")); break;}
                        case 1 : { imgIcon = new ImageIcon(getClass().getResource("icons/info.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie_green.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy_dark_green.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/view_green.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth_green.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes_dark.png")); break;}
                        case 2 : { imgIcon = new ImageIcon(getClass().getResource("icons/info_yellow.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG_yellow.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit_yellow.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT_yellow.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj_yellow.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree_yellow.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear_yellow.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie_yellow.png"));
               imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy_yellow.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file_yellow.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/view_yellow.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size_yellow.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth_yellow.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes_dark.png")); break;}
                        case 3 : { imgIcon = new ImageIcon(getClass().getResource("icons/info_blue.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG_blue.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit_blue.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT_blue.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj_blue.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree_blue.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear_blue.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie_blue.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy_blue.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file_blue.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/view_blue.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size_blue.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth_blue.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes_dark.png")); break;}
                        case 4 : { imgIcon = new ImageIcon(getClass().getResource("icons/info_purple.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG_purple.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit_purple.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT_purple.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj_purple.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree_purple.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear_purple.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowanie_purple.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy_purple.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file_purple.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/view_purple.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size_purple.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth_purple.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes_dark.png")); break;}
                        default : {
                            
                            
                            imgIcon = new ImageIcon(getClass().getResource("icons/info.png"));
                imgIcon2 = new ImageIcon(getClass().getResource("icons/saveJPG.png"));
                imgIcon3 = new ImageIcon(getClass().getResource("icons/exit.png"));
                imgIcon4 = new ImageIcon(getClass().getResource("icons/saveTXT.png"));
                imgIcon5 = new ImageIcon(getClass().getResource("icons/wczytaj.png"));
                imgIcon6 = new ImageIcon(getClass().getResource("icons/make_tree.png"));
                imgIcon7 = new ImageIcon(getClass().getResource("icons/clear.png"));
                imgIcon8 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon9 = new ImageIcon(getClass().getResource("icons/skalowaniedrk.png"));
                imgIcon10 = new ImageIcon(getClass().getResource("icons/accuracy.png"));
                imgIcon11 = new ImageIcon(getClass().getResource("icons/file.png"));
                imgIcon12 = new ImageIcon(getClass().getResource("icons/view.png"));
                imgIcon13 = new ImageIcon(getClass().getResource("icons/size.png"));
                imgIcon14 = new ImageIcon(getClass().getResource("icons/sizeDepth.png"));
            imgIcon_theme = new ImageIcon(getClass().getResource("icons/themes.png"));break;}
                    }
            }}
        else if(motyw==1){
            motyw=0;}
        if(motyw==1){
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
    
        
    }



}
