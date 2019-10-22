import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import  java.io.FileWriter;





public class Zapis {

    public static void zapisDoPlkiu(ElementDrzewa tablica[][],String sciezka,String plik) throws FileNotFoundException {

       String save;
        try {
            PrintWriter zapis = new PrintWriter(sciezka + "." + plik);
            //zapis.print("Day,");
            for (int i = 0; i < tablica.length; i++) {
                //     if(i!=0){
                //          zapis.print("D"+i+",");
                //      }
                for (int j = 0; j < tablica[i].length; j++) {
                    //        if(i==0 && j==tablica[i].length-1){
                    //            zapis.print("Decision,");
                    //       }
                    //       else {

                    zapis.print(tablica[i][j].getNazwa() + ",");
                    //         }

                }
               zapis.println();
            }
            zapis.close();

            File nf = new File(sciezka + "." + plik);
            BufferedWriter FileWriter = new BufferedWriter(new FileWriter(sciezka+"1."+plik));
            try{
                Scanner scanner = new Scanner(nf);
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    if(line.endsWith(",")){
                        System.out.println(line);
                        System.out.println(line.substring(0,line.length()-1));

                       FileWriter.write(line.substring(0,line.length()-1));
                       FileWriter.newLine();
                    }

                }
                FileWriter.close();
                File f1 = new File(sciezka+"."+plik);
               File f2 = new File(sciezka+"1."+plik);
               boolean a =f1.delete();
              boolean b = f2.renameTo(f1);
            } catch (IOException e) {
                System.out.println("Problem z dostępem do pliku");
            }
        } catch (IOException ex) {
            System.out.println("Problem z dostępem do pliku");

            }

    }

    public static void  zapiszDrzewoDoPliku(String sciezka,Drzewo<ElementDrzewa> ed) throws IOException{
        ObjectOutputStream pl=null;
        FileWriter writer = new FileWriter(sciezka+".txt");
        BufferedWriter bw = new BufferedWriter(writer);

        LinkedList<Wezel<ElementDrzewa>> test = ed.preOrderToList(ed.getKorzen(),new LinkedList<Wezel<ElementDrzewa>>());
        try {
            //int iterowanie = 0;
            for (Wezel<ElementDrzewa> element : test) {
                String nazwaKlasy = element.getDane().getClass().getName();
                if (nazwaKlasy.equals("Atrybut")) {
                    bw.write("0,");
                    bw.write(element.toString() + ",");
                    if (element.getRodzic() == null) {
                        bw.write("null,");
                    } else {
                        bw.write(element.getRodzic().toString() + ",");
                    }
                } else if (nazwaKlasy.equals("WartoscAtrybutu")) {
                    bw.write("1,");
                    bw.write(element.toString() + ",");
                    bw.write(element.getRodzic().toString() + ",");

                } else if (nazwaKlasy.equals("Decyzja")) {
                    bw.write("2,");
                    bw.write(element.toString() + ",");
                    //if(){
                    // bw.write(element.getRodzic().toString());
                    //}
                    //else{
                    bw.write(element.getRodzic().toString() + ",");
                    //}
                }
                bw.write("\n");


                //bw.write(zapis.get(i));


                //ElementDrzewa korzen = (ElementDrzewa) ed.getKorzen().getDane();
                //LinkedList<Wezel<ElementDrzewa>> dzieci = ed.getKorzen().getDzieci();
                //for(int i=0;i<ed.getHeight(ed.getKorzen())-1;i++) {

                //}

            }
            bw.close();
        }
        catch (IOException e1) {
            e1.printStackTrace();
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
    }}


