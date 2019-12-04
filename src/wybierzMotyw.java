import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class wybierzMotyw {
    public int pwsz;
    public int darkmode;
    public String[] buttons = { "Jasny  (Windows Classic)", "Jasny (Windows Modern)", "Ciemny (Darkula)", "Jasny (Metal)"};

    public void wybierzMotyw() throws IOException, FileNotFoundException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException{



        int motyw = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Procedura przed startowa",
                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);

        switch(motyw) {
            case 0:
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                setPwsz(0);
                setDark(0);
                break;
            case 1:
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                setPwsz(0);
                setDark(0);
                break;
            case 2:
                UIManager.setLookAndFeel(new DarculaLaf());
                setPwsz(0);
                setDark(1);
                break;
            case 3:
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Metal".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }} catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                setPwsz(0);
                setDark(0);
                break;
            default :
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                setPwsz(0);
                setDark(0);
                break;

        }
    }

    public void setPwsz(int pwsz){
        this.pwsz=pwsz;
    }
    public int getPwsz(){
        return pwsz;
    }


    public void setDark(int dark){  this.darkmode=pwsz;
    }
    public int getDark(){
        return darkmode;
    }



}

