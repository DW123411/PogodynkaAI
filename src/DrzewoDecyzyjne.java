import java.util.ArrayList;

public class DrzewoDecyzyjne {
    public DrzewoDecyzyjne(){

    }

    public Drzewo<String> indukcja(String[][] przyklady, String[] atrybuty, Drzewo<String> def){
        //sprawdzenie ilości "Yes" i "No" w celu określenia ewentualnej jednorodności decyzji
        int iloscY = 0;
        int iloscN = 0;
        for(int i=1;i<przyklady.length;i++){
            if(przyklady[i][przyklady[i].length-1].equals("Yes")){
                iloscY++;
            }else{
                iloscN++;
            }
        }
        //jeśli tablica przykładów jest pusta to zwracamy drzewo przekazane rekurencyjnie
        if(przyklady.length==1 || przyklady.length==0){
            return def;
        //jeśli decyzja jest jednorodna (tylko Yes lub tylko No) to zwracamy nowy węzeł z tą decyzją i rodzicem z drzewa przekazanego rekurencyjnie
        }else if(iloscY==(przyklady.length-1) || iloscN==(przyklady.length-1)){
            if(iloscY!=0) {
                return new Drzewo<String>(new Wezel<String>(def.getKorzen().getRodzic(), "Yes"));
            }else{
                return new Drzewo<String>(new Wezel<String>(def.getKorzen().getRodzic(), "No"));
            }
        //jeśli tablica atrybutów jest pusta to zwracamy nowe drzewo z decyzją z pozostałych przykładów oraz rodzicem z drzewa przekazanego rekurencyjnie
        }else if(atrybuty.length==0){
            return new Drzewo<String>(new Wezel<String>(def.getKorzen().getRodzic(),decyduj(przyklady)));
        }else{
            //wybór najlepszego atrybutu i stworzenie węzła
            String najlepszy = wybierzAtrybut(atrybuty,przyklady);
            Wezel<String> tmp = new Wezel<String>(null, najlepszy);
            if(def!=null){
                tmp = new Wezel<String>(def.getKorzen().getRodzic(), najlepszy);
            }
            //pobranie możliwych wartości i dodanie ich do węzłą atrybutu
            String[] wartosci = podajWartosci(najlepszy,przyklady);
            for(String obj : wartosci){
                tmp.dodajDziecko(new Wezel<String>(tmp,obj));
            }
            //utworzenie drzewa z korzeniem w wybranym atrybucie
            Drzewo<String> drzewo = new Drzewo<String>(tmp);
            //dla każdej wartości atrybutu...
            for(Wezel<String> obj : drzewo.getKorzen().getDzieci()){
                //...wybór przykładów zawierających daną wartość atrybutu
                String[][] przykladyDlaDanejWartosci = podajPrzykladyDlaWartosci(przyklady,obj.toString(),najlepszy);
                //skrócenie listy atrybutów kosztem wybranego wcześniej najlepszego atrybutu
                String[] tmpAtrybuty = new String[atrybuty.length-1];
                int j = 0;
                for(int i=0;i<atrybuty.length;i++){
                    if(!atrybuty[i].equals(najlepszy)){
                        tmpAtrybuty[j] = atrybuty[i];
                        j++;
                    }
                }
                //rekurencyjne wywołanie indukcji w danej gałęzi powstającego drzewa
                Drzewo<String> galaz = indukcja(przykladyDlaDanejWartosci,tmpAtrybuty,new Drzewo<String>(new Wezel<String>(obj,decyduj(przyklady))));
                //dodanie gałęzi do węzła wartości atrybutu
                obj.dodajDziecko(galaz.getKorzen());
            }
            return drzewo;
        }
    }

    public String wybierzAtrybut(String[] atrybuty, String[][] przyklady){
        String najlepszy = atrybuty[0];
        double najlepszyZysk = 0;
        for(String atrybut : atrybuty){
            double tmpZysk = zysk(przyklady,atrybut);
            if(tmpZysk>najlepszyZysk){
                najlepszyZysk = tmpZysk;
                najlepszy = atrybut;
            }
        }
        return najlepszy;
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
        double pplus = 0;
        double logplus = 0;
        if(iloscYes!=0) {
            pplus = iloscYes / suma;
            logplus = (Math.log(pplus) / Math.log(2));
        }
        double pminus = 0;
        double logminus = 0;
        if(iloscNo!=0){
            pminus = iloscNo/suma;
            logminus = (Math.log(pminus)/Math.log(2));
        }
        return -pplus*logplus-pminus*logminus;
    }

    public double zysk(String[][] przyklady, String atrybut){
        String[] wartosci = podajWartosci(atrybut,przyklady);
        double zysk = 0;
        for(String wartosc : wartosci){
            String[][] przykladyDlaWartosci = podajPrzykladyDlaWartosci(przyklady,wartosc,atrybut);
            zysk += (((double)przykladyDlaWartosci.length-1)*entropia(przykladyDlaWartosci))/((double)przyklady.length-1);
        }
        zysk = entropia(przyklady)-zysk;
        return zysk;
    }
}
