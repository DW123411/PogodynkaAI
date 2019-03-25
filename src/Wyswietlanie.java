import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

public class Wyswietlanie extends JPanel
{
    
    BufferedImage okno;
    //konstruktor
    public Wyswietlanie() 
    {
        super();   
        setLayout(new GridLayout(2,1));
        ustawRozmiar(new Dimension(600,600));
        wyczysc();
    }
   
       public void wyczysc()
    {
        //wyrysowanie białego tła
        Graphics2D g = (Graphics2D) okno.getGraphics();
        g.setColor(Color.gray);
        g.fillRect(0, 0, okno.getWidth(), okno.getHeight());
        //ustalenie obramowania
        setBorder(BorderFactory.createLineBorder(Color.gray)); 
        repaint();
    }

    public void ustawRozmiar(Dimension r)
    {
        okno = new BufferedImage((int)r.getWidth(), (int)r.getHeight(), BufferedImage.TYPE_INT_RGB);
        setPreferredSize(r);     
        setMaximumSize(r);
    }

    public void rysujDrzewo(Wezel wezel,int szerokosc,int wysokosc,Wezel korzen) {
        Graphics2D g = (Graphics2D) okno.getGraphics();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.black);
        Graphics2D g3 = (Graphics2D) okno.getGraphics();
        g3.setStroke(new BasicStroke(2));
        g3.setColor(Color.white);
        Drzewo drzewo = new Drzewo(korzen);

     /*       Line2D.Double line = new Line2D.Double(270, 50, 200, 150);
        Line2D.Double line2 = new Line2D.Double(270, 50, 270, 150);
        Line2D.Double line3 = new Line2D.Double(270, 50, 340, 150);
        Line2D.Double line4 = new Line2D.Double(200, 150, 150, 250);
        Line2D.Double line5 = new Line2D.Double(340, 150, 370, 250);
        Line2D.Double line6 = new Line2D.Double(270, 150, 270, 250);
        Line2D.Double line7 = new Line2D.Double (150, 250, 120, 350);
        Line2D.Double line8 = new Line2D.Double (150, 250, 190, 350);

        Line2D.Double line9 = new Line2D.Double (190, 350, 200, 450);
        Line2D.Double line10 = new Line2D.Double (120, 350, 130, 450);


        Line2D.Double line11 = new Line2D.Double (370, 250, 340, 350);
        Line2D.Double line12 = new Line2D.Double (370, 250, 420, 350);

        Line2D.Double line13 = new Line2D.Double (340, 350, 350, 450);
        Line2D.Double line14 = new Line2D.Double (420, 350, 430, 450);



        g.draw(line);
        g.draw(line2);
        g.draw(line3);
        g.draw(line4);
        g.draw(line5);
        g.draw(line6);
        g.draw(line7);
        g.draw(line8);
        g.draw(line9);
        g.draw(line10);
        g.draw(line11);
        g.draw(line12);
        g.draw(line13);
        g.draw(line14);
            g3.drawString("Outlook", 270, 50);
        g3.drawString("Sunny", 180, 150);
        g3.drawString("Cloudy", 270, 150);
        g3.drawString("Rain", 340, 150);
        g3.drawString("Humidity", 150, 250);
        g3.drawString("Windy", 370, 250);
        g3.drawString("Yes", 270, 250);
        g3.drawString("High", 120, 350);
        g3.drawString("Normal", 190, 350);
        g3.drawString("False", 340, 350);
        g3.drawString("True", 420, 350);
        g3.drawString("Yes", 200, 450);
        g3.drawString("No", 130, 450);
        g3.drawString("Yes", 350, 450);
        g3.drawString("No", 430, 450);*/
     int odleglosc = 0;
     int liczba = 0;
        int poziom =  drzewo.getLevel(wezel);
        if(wezel.equals(korzen))
        g3.drawString(wezel.toString(), 270, 50);
        else
        g3.drawString(wezel.toString(), szerokosc, wysokosc);
        LinkedList<Wezel> lista = wezel.getDzieci();
        while(!lista.isEmpty()) {
            int podzial = lista.size()+1;
            Wezel w = lista.remove(0);
            if(w.czyLisc()) {
                System.out.println(w.toString());
                g3.drawString(w.toString(), szerokosc, wysokosc + 100);
            }

            else {
    if(liczba == 0) {
        szerokosc = (szerokosc+70) / podzial;
        odleglosc = szerokosc;
        liczba ++;
    }

                wysokosc = (poziom +2)*75;
                System.out.println(szerokosc+" "+wysokosc);

                rysujDrzewo(w, szerokosc, wysokosc,korzen);
                szerokosc = szerokosc + odleglosc;
            }


        }
        repaint();
    }


    //przesłonięta metoda paintComponent z klasy JPanel do rysowania
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //wyrysowanie naszego płótna na panelu 
        g2d.drawImage(okno, 0, 0, this);
    }    
}
