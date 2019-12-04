import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;



public class Main {

    public static int moty;
    public static int dark;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, IOException {
        wybierzMotyw motyw = new wybierzMotyw();
        motyw.wybierzMotyw();
        moty=motyw.getPwsz();
        dark=motyw.getDark();


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Okno();
            }
        });

    }}





