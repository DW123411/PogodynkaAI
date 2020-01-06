import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;

public class wybierzMotyw {
    public int pwsz;
    public int darkmode;
    public String[] buttonsNonWin = {"Ciemny (Darkula)", "Jasny (Nimbus)","Domyślny"};
    public String[] buttonsWin= { "Jasny  (Windows Classic)", "Jasny (Domyślny)", "Ciemny (Darkula)", "Jasny (Nimbus)"};






    public void wybierzMotyw(String system) throws IOException, FileNotFoundException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException{
        if(system.equals("Linux")){
            int motyw = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Procedura przed startowa",
                    JOptionPane.WARNING_MESSAGE, 0, null, buttonsNonWin, buttonsNonWin[0]);

            switch(motyw) {
                case 0:
                    UIManager.setLookAndFeel(new DarculaLaf());
                    setPwsz(0);
                    setDark(1);
                    break;
                case 1:
                    try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                            if ("Nimbus".equals(info.getName())) {
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
                    case 2:
                        UIManager.setLookAndFeel(new DarculaLaf());
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
        else if(system.contains("Windows")){

            int motyw = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Procedura przed startowa",
                    JOptionPane.WARNING_MESSAGE, 0, null, buttonsWin, buttonsWin[0]);

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
                            if ("Nimbus".equals(info.getName())) {
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





