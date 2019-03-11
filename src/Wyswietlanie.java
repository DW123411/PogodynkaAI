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

    public void rysujDrzewo() {
        Graphics2D g = (Graphics2D) okno.getGraphics();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.black);
        Graphics2D g3 = (Graphics2D) okno.getGraphics();
        g3.setStroke(new BasicStroke(2));
        g3.setColor(Color.red);


            Line2D.Double line = new Line2D.Double(250, 250, 500, 500);

            g.draw(line);
            g3.drawString("Outlook", 250, 250);


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
