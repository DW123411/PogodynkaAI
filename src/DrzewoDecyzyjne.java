public class DrzewoDecyzyjne {
    public static Drzewo<String> indukcja(String[][] przyklady, String[] atrybuty, Drzewo<String> def){
        boolean czyJednorodne = false;
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
        }else if(iloscY==(przyklady.length+1) || iloscN==(przyklady.length+1)){
            if(iloscY!=0) {
                return new Drzewo<String>(new Wezel<String>(null, "Yes"));
            }else{
                return new Drzewo<String>(new Wezel<String>(null, "No"));
            }
        }
        return new Drzewo<String>();
    }

    public String wybierzAtrybut(String[] atrybuty, String[][] przyklady){
        return "";
    }
}
