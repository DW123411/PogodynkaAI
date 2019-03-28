import java.util.ArrayList;

public class DrzewoDecyzyjne {
    public DrzewoDecyzyjne(){

    }

    public Drzewo<String> indukcja(String[][] przyklady, String[] atrybuty, Drzewo<String> def){
        boolean czyJednorodne = false;
        int atrybut = 0;
        int iloscY = 0;
        int iloscN = 0;
        for(int i=0;i<przyklady.length;i++){
            if(przyklady[i][4].equals("Yes")){
                iloscY++;
            }else{
                iloscN++;
            }
        }
        if(przyklady.length==0){
            return def;
        }else if(iloscY==(przyklady.length) || iloscN==(przyklady.length)){
            if(iloscY!=0) {
                return new Drzewo<String>(new Wezel<String>(def.getKorzen(), "Yes"));
            }else{
                return new Drzewo<String>(new Wezel<String>(def.getKorzen(), "No"));
            }
        }else if(atrybuty.length==0){
            return new Drzewo<String>(new Wezel<String>(def.getKorzen(),decyduj(przyklady)));
        }else{
            String najlepszy = wybierzAtrybut(atrybuty,przyklady);
            atrybut++;
            Wezel<String> tmp = new Wezel<String>(def.getKorzen(),najlepszy);
            String[] wartosci = podajWartosci(atrybut,przyklady);
            for(String obj : wartosci){
                tmp.dodajDziecko(new Wezel<String>(tmp,obj));
            }
            Drzewo<String> drzewo = new Drzewo<String>(tmp);

        }
        return new Drzewo<String>();
    }

    public String wybierzAtrybut(String[] atrybuty, String[][] przyklady){
        return atrybuty[0];
    }
    public String decyduj(String[][] przyklady){
        int liczYes = 0;
        int liczNo = 0;
        for(int i=0;i<przyklady.length;i++){
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
    public String[] podajWartosci(int pozycja, String[][] przyklady){
        boolean czyNowy = true;
        ArrayList<String> wartosci = new ArrayList<String>();
        for(int i=0;i<przyklady.length;i++){
            String tmp = przyklady[i][pozycja];
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
}
