import java.util.ArrayList;

public class DrzewoDecyzyjne {
    public DrzewoDecyzyjne(){

    }

    public Drzewo<String> indukcja(String[][] przyklady, String[] atrybuty, Drzewo<String> def){
        int iloscY = 0;
        int iloscN = 0;
        for(int i=1;i<przyklady.length;i++){
            if(przyklady[i][4].equals("Yes")){
                iloscY++;
            }else{
                iloscN++;
            }
        }
        if(przyklady.length==1 || przyklady.length==0){
            return def;
        }else if(iloscY==(przyklady.length-1) || iloscN==(przyklady.length-1)){
            if(iloscY!=0) {
                return new Drzewo<String>(new Wezel<String>(def.getKorzen().getRodzic(), "Yes"));
            }else{
                return new Drzewo<String>(new Wezel<String>(def.getKorzen().getRodzic(), "No"));
            }
        }else if(atrybuty.length==0){
            return new Drzewo<String>(new Wezel<String>(def.getKorzen().getRodzic(),decyduj(przyklady)));
        }else{
            String najlepszy = wybierzAtrybut(atrybuty,przyklady);
            Wezel<String> tmp = new Wezel<String>(null, najlepszy);
            if(def!=null){
                tmp = new Wezel<String>(def.getKorzen().getRodzic(), najlepszy);
            }
            String[] wartosci = podajWartosci(najlepszy,przyklady);
            for(String obj : wartosci){
                tmp.dodajDziecko(new Wezel<String>(tmp,obj));
            }
            Drzewo<String> drzewo = new Drzewo<String>(tmp);
            for(Wezel<String> obj : drzewo.getKorzen().getDzieci()){
                String[][] przykladyDlaDanejWartosci = podajPrzykladyDlaWartosci(przyklady,obj.toString(),najlepszy);
                String[] tmpAtrybuty = new String[atrybuty.length-1];
                for(int i=1;i<atrybuty.length;i++){
                    tmpAtrybuty[i-1] = atrybuty[i];
                }
                Drzewo<String> galaz = indukcja(przykladyDlaDanejWartosci,tmpAtrybuty,new Drzewo<String>(new Wezel<String>(obj,decyduj(przyklady))));
                obj.dodajDziecko(galaz.getKorzen());
            }
            return drzewo;
        }
    }

    public String wybierzAtrybut(String[] atrybuty, String[][] przyklady){
        return atrybuty[0];
    }

    public String decyduj(String[][] przyklady){
        int liczYes = 0;
        int liczNo = 0;
        for(int i=1;i<przyklady.length;i++){
            if(przyklady[i][przyklady[i].length-1].equals("Yes")){
                liczYes++;
            }else{
                liczNo++;
            }
        }
        if(liczYes>=liczNo){
            return "Yes";
        }else{
            return "No";
        }
    }

    public String[] podajWartosci(String atrybut, String[][] przyklady){
        boolean czyNowy = true;
        ArrayList<String> wartosci = new ArrayList<String>();
        int kolumna = 0;
        for(int i=0;i<przyklady[0].length;i++){
            if(przyklady[0][i].equals(atrybut)){
                kolumna = i;
            }
        }
        for(int i=1;i<przyklady.length;i++){
            czyNowy = true;
            String tmp = przyklady[i][kolumna];
            for(String obj : wartosci){
                if(obj.equals(tmp)){
                    czyNowy = false;
                }
            }
            if(czyNowy){
                wartosci.add(tmp);
            }
        }
        String[] wartosciString = new String[wartosci.size()];
        int i = 0;
        for(String obj : wartosci){
            wartosciString[i++] = obj;
        }
        return wartosciString;
    }

    public String[][] podajPrzykladyDlaWartosci(String[][] przyklady, String wartosc, String atrybut){
        int liczWartosc = 0;
        int kolumna = 0;
        for(int i=0;i<przyklady[0].length;i++){
            if(przyklady[0][i].equals(atrybut)){
                kolumna = i;
            }
        }
        for(int i=1;i<przyklady.length;i++){
            if(przyklady[i][kolumna].equals(wartosc)){
                liczWartosc++;
            }
        }
        String[][] tmp = new String[liczWartosc+1][przyklady[0].length];
        for(int i=0;i<przyklady[0].length;i++){
            tmp[0][i] = przyklady[0][i];
        }
        int tablicaTmp = 1;
        for(int i=1;i<przyklady.length;i++){
            if(przyklady[i][kolumna].equals(wartosc)){
                for(int j=0;j<przyklady[i].length;j++){
                    tmp[tablicaTmp][j] = przyklady[i][j];
                }
                tablicaTmp++;
            }
        }
        return tmp;
    }

    public double entropia(String[][] przyklady){
        int iloscYes = 0;
        int iloscNo = 0;
        for(int i=1;i<przyklady.length;i++){
            if(przyklady[i][przyklady[i].length-1].equals("Yes")){
                iloscYes++;
            }else{
                iloscNo++;
            }
        }
        double suma = iloscYes+iloscNo;
        double pplus = iloscYes/suma;
        double pminus = iloscNo/suma;
        return -pplus*(Math.log(pplus)/Math.log(2))-pminus*(Math.log(pplus)/Math.log(2));
    }

    public double zysk(String[][] przyklady){
        return 0;
    }
}
