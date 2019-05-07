import java.io.*;

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
            System.out.println("Problez z dostępem do pliku");


        }
    }
    public static void  zapiszDrzewoDoPliku(String sciezka,Drzewo<ElementDrzewa> ed) throws IOException,ClassNotFoundException{
        ObjectOutputStream pl=null;
        try{
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
}
