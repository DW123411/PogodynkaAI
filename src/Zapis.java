import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;



public class Zapis {

    public static void zapisDoPlkiu(ElementDrzewa tablica[][],String sciezka) throws FileNotFoundException {
        try {
            PrintWriter zapis = new PrintWriter(sciezka+".txt");
            zapis.print("Day,");
            for (int i = 0; i < tablica.length; i++) {
                if(i!=0){
                    zapis.print("D"+i+",");
                }
                for (int j = 0; j < tablica[i].length; j++) {
                    if(i==0 && j==tablica[i].length-1){
                        zapis.print("Decision,");
                    }
                   else {
                        zapis.print(tablica[i][j].getNazwa() + ",");
                    }

                }
                zapis.println();
            }
            zapis.close();
        } catch (IOException ex) {
            System.out.println("Problem z dostępem do pliku");


        }
    }
    public static void  zapiszDrzewoDoPliku(String sciezka,Drzewo<ElementDrzewa> ed) throws IOException,ClassNotFoundException{
        ObjectOutputStream pl=null;
        try{
            ElementDrzewa korzen = (ElementDrzewa) ed.getKorzen().getDane();
            LinkedList<Wezel<ElementDrzewa>> dzieci = ed.getKorzen().getDzieci();
            for(int i=0;i<ed.getHeight(ed.getKorzen())-1;i++) {

            }
            FileOutputStream fileOut = new FileOutputStream(sciezka);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            DataOutputStream fas = new DataOutputStream(out);
            out.writeObject(ed);
            out.close();
            fileOut.close();

        }
        catch (IOException i) {
            i.printStackTrace();
        }


    }
    public static void save_jpeg() throws IOException {

        BufferedImage okno = Wyswietlanie.okno;

        JFileChooser jpegSave = new JFileChooser();
        jpegSave.setAcceptAllFileFilterUsed(false);
        jpegSave.addChoosableFileFilter(new FileNameExtensionFilter("Pliki JPEG","jpeg"));
        jpegSave.addChoosableFileFilter(new FileNameExtensionFilter("Pliki JPG","jpg"));
        jpegSave.addChoosableFileFilter(new FileNameExtensionFilter("Pliki PNG","png"));
        jpegSave.addChoosableFileFilter(new FileNameExtensionFilter("Pliki bitmapy","bmp"));


        jpegSave.setFileFilter(jpegSave.getChoosableFileFilters()[0]);


        if (jpegSave.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File outputfile = jpegSave.getSelectedFile();
            String path = outputfile.getAbsolutePath();
            // save to file

            try {
                if(jpegSave.getFileFilter()== jpegSave.getChoosableFileFilters()[0]){
                    outputfile=new File(path+".jpeg");
                    ImageIO.write(okno, "jpeg", outputfile);
                    }
                if(jpegSave.getFileFilter()== jpegSave.getChoosableFileFilters()[1]){
                    outputfile=new File(path+".jpg");
                    ImageIO.write(okno, "jpg", outputfile);

                }

                if(jpegSave.getFileFilter()== jpegSave.getChoosableFileFilters()[2]){
                    outputfile=new File(path+".png");
                    ImageIO.write(okno, "png", outputfile);

                }

                if(jpegSave.getFileFilter()== jpegSave.getChoosableFileFilters()[3]){
                    outputfile=new File(path+".bmp");
                    ImageIO.write(okno, "bmp", outputfile);

                }

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
