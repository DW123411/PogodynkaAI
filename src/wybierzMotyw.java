import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;

public class wybierzMotyw {
    private int pwsz;
    private int darkmode;
    private int colormode;
    public String[] buttonsNonWin = {"Ciemny (Darkula)", "Jasny (Nimbus)","Domyślny"};
    public String[] buttonsWin= { "Jasny  (Windows Classic)", "Jasny (Domyślny)", "Ciemny (Darkula)", "Jasny (Nimbus)"};
    public String[] Colors = {"Czerwony", "Zielony", "Żółty","Niebieski", "Fioletowy"};
       





    public void setMotyw(String system) throws IOException, FileNotFoundException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException{
        if(system.contains("Linux")){
            int motyw = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Wybierz Motyw", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,  new ImageIcon(getClass().getResource("icons/themes.png")), buttonsNonWin, buttonsNonWin[0]);
            
            switch(motyw) {
                case 0:
                    UIManager.setLookAndFeel(new DarculaLaf());
                    setPwsz(0);
                    setDark(1);
                    int color = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Wybierz Motyw", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,  new ImageIcon(getClass().getResource("icons/themes.png")), Colors,null);
                    switch(color){
                        case 0 : { setColor(0); break;}
                        case 1 : { setColor(1); break;}
                        case 2 : { setColor(2); break;}
                        case 3 : { setColor(3); break;}
                        case 4 : { setColor(4); break;}
                        default : {break;}
                    }
                    
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
                    color = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Wybierz Motyw", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,  new ImageIcon(getClass().getResource("icons/themes.png")), Colors,null);
                    switch(color){
                        case 0 : { setColor(0); break;}
                        case 1 : { setColor(1); break;}
                        case 2 : { setColor(2); break;}
                        case 3 : { setColor(3); break;}
                        case 4 : { setColor(4); break;}
                        default : {break;}
                    }
                    break;
                    case 2:
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        setPwsz(0);
                        setDark(0);
                        color = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Wybierz Motyw", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,  new ImageIcon(getClass().getResource("icons/themes.png")), Colors,null);
                        switch(color){
                            case 0 : { setColor(0); break;}
                            case 1 : { setColor(1); break;}
                            case 2 : { setColor(2); break;}
                            case 3 : { setColor(3); break;}
                            case 4 : { setColor(4); break;}
                            default : {break;}
                        }
                        break;
                default :
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    setPwsz(0);
                    setDark(0);
                    break;

            }
        }
        else if(system.contains("Windows")){

            int motyw = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Wybierz Motyw",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("icons/themes.png")), buttonsWin, buttonsWin[0]);

            switch(motyw) {
                case 0:{
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                    setPwsz(0);
                    setDark(0);
                     int color = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Wybierz Motyw", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,  new ImageIcon(getClass().getResource("icons/themes.png")), Colors,Colors[1]);
                  
                     switch(color){
                        case 0 : { setColor(0); break;}
                        case 1 : { setColor(1); break;}
                        case 2 : { setColor(2); break;}
                        case 3 : { setColor(3); break;}
                        case 4 : { setColor(4); break;}
                        default : {break;}
                    }
                    
                    break;}
                case 1: {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    setPwsz(0);
                    setDark(0);
                       int color = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Wybierz Motyw", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,  new ImageIcon(getClass().getResource("icons/themes.png")), Colors,Colors[1]);
                    switch(color){
                        case 0 : { setColor(0); break;}
                        case 1 : { setColor(1); break;}
                        case 2 : { setColor(2); break;}
                        case 3 : { setColor(3); break;}
                        case 4 : { setColor(4); break;}
                        default : {break;}
                    }
                    break;}
                case 2:{
                    UIManager.setLookAndFeel(new DarculaLaf());
                    setPwsz(0);
                    setDark(1);
                       int color = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Wybierz Motyw", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,  new ImageIcon(getClass().getResource("icons/themes.png")), Colors,Colors[1]);
                    switch(color){
                        case 0 : { setColor(0); break;}
                        case 1 : { setColor(1); break;}
                        case 2 : { setColor(2); break;}
                        case 3 : { setColor(3); break;}
                        case 4 : { setColor(4); break;}
                        default : {break;}
                    }
                    break;}
                case 3:{
                    try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                            if ("Nimbus".equals(info.getName())) {
                                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                   int color = JOptionPane.showOptionDialog(null, "Wybierz jaki chcesz motyw", "Wybierz Motyw", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,  new ImageIcon(getClass().getResource("icons/themes.png")), Colors,Colors[1]);
                    switch(color){
                        case 0 : { setColor(0); break;}
                        case 1 : { setColor(1); break;}
                        case 2 : { setColor(2); break;}
                        case 3 : { setColor(3); break;}
                        case 4 : { setColor(4); break;}
                        default : {break;}
                    }
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
                }
                default : {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    setPwsz(0);
                    setDark(0);
                    break;
                }
            }
        }
        else{ JOptionPane.showMessageDialog(null, "Motywy nie są wspierane w tym Systemie Operacyjnym", "Wybierz Motyw",
                    JOptionPane.WARNING_MESSAGE);
        }




    }

    public void setPwsz(int pwsz){
        this.pwsz=pwsz;
    }
    public int getPwsz(){
        return this.pwsz;
    }


    public void setDark(int dark){  this.darkmode=dark;
    }

    public int getDark(){
        return this.darkmode;
    }

    public void setColor(int col){this.colormode = col;}
    
    public int getColorMode(){return this.colormode;}


}





