import java.util.ArrayList;

public class DrzewoDecyzyjne {
    DaneWejsciowe daneWejsciowe;

    public DrzewoDecyzyjne(DaneWejsciowe daneWejsciowe) {
        this.daneWejsciowe = daneWejsciowe;
    }

    public Drzewo<ElementDrzewa> indukcja(ElementDrzewa[][] przyklady, Atrybut[] atrybuty, Drzewo<ElementDrzewa> def) {
        //sprawdzenie ilości "Yes" i "No" w celu określenia ewentualnej jednorodności decyzji
        int iloscY = 0;
        int iloscN = 0;
        for (int i = 1; i < przyklady.length; i++) {
            if (przyklady[i][przyklady[i].length - 1].toString().equals(daneWejsciowe.getOpcja1())) {
                iloscY++;
            } else {
                iloscN++;
            }
        }
        //jeśli tablica przykładów jest pusta to zwracamy drzewo przekazane rekurencyjnie
        if (przyklady.length == 1 || przyklady.length == 0) {
            return def;
            //jeśli decyzja jest jednorodna (tylko Yes lub tylko No) to zwracamy nowy węzeł z tą decyzją i rodzicem z drzewa przekazanego rekurencyjnie
        } else if (iloscY == (przyklady.length - 1) || iloscN == (przyklady.length - 1)) {
            if (iloscY != 0) {
                return new Drzewo<ElementDrzewa>(new Wezel<ElementDrzewa>(def.getKorzen().getRodzic(), new Decyzja(daneWejsciowe.getOpcja1())));
            } else {
                return new Drzewo<ElementDrzewa>(new Wezel<ElementDrzewa>(def.getKorzen().getRodzic(), new Decyzja(daneWejsciowe.getOpcja2())));
            }
            //jeśli tablica atrybutów jest pusta to zwracamy nowe drzewo z decyzją z pozostałych przykładów oraz rodzicem z drzewa przekazanego rekurencyjnie
        } else if (atrybuty.length == 0) {
            return new Drzewo<ElementDrzewa>(new Wezel<ElementDrzewa>(def.getKorzen().getRodzic(), decyduj(przyklady)));
        } else {
            //wybór najlepszego atrybutu i stworzenie węzła
            Atrybut najlepszy = wybierzAtrybut(atrybuty, przyklady);
            najlepszy.setEntropia(entropia(przyklady));
            Wezel<ElementDrzewa> tmp = new Wezel<ElementDrzewa>(null, najlepszy);
            if (def != null) {
                tmp = new Wezel<ElementDrzewa>(def.getKorzen().getRodzic(), najlepszy);
            }
            //pobranie możliwych wartości i dodanie ich do węzła atrybutu
            WartoscAtrybutu[] wartosci = podajWartosci(najlepszy, przyklady);
            for (WartoscAtrybutu obj : wartosci) {
                tmp.dodajDziecko(new Wezel<ElementDrzewa>(tmp, obj));
            }
            //utworzenie drzewa z korzeniem w wybranym atrybucie
            Drzewo<ElementDrzewa> drzewo = new Drzewo<ElementDrzewa>(tmp);
            //dla każdej wartości atrybutu...
            for (Wezel<ElementDrzewa> obj : drzewo.getKorzen().getDzieci()) {
                //...wybór przykładów zawierających daną wartość atrybutu
                ElementDrzewa[][] przykladyDlaDanejWartosci = podajPrzykladyDlaWartosci(przyklady, (WartoscAtrybutu) obj.getDane(), najlepszy);
                //skrócenie listy atrybutów kosztem wybranego wcześniej najlepszego atrybutu
                Atrybut[] tmpAtrybuty = new Atrybut[atrybuty.length - 1];
                int j = 0;
                for (int i = 0; i < atrybuty.length; i++) {
                    if (!atrybuty[i].toString().equals(najlepszy.toString())) {
                        tmpAtrybuty[j] = atrybuty[i];
                        j++;
                    }
                }
                //rekurencyjne wywołanie indukcji w danej gałęzi powstającego drzewa
                Drzewo<ElementDrzewa> galaz = indukcja(przykladyDlaDanejWartosci, tmpAtrybuty, new Drzewo<ElementDrzewa>(new Wezel<ElementDrzewa>(obj, decyduj(przyklady))));
                //dodanie gałęzi do węzła wartości atrybutu
                obj.dodajDziecko(galaz.getKorzen());
            }
            return drzewo;
        }
    }

    public Atrybut wybierzAtrybut(Atrybut[] atrybuty, ElementDrzewa[][] przyklady) {
        Atrybut najlepszy = atrybuty[0];
        double najlepszyZysk = 0;
        for (Atrybut atrybut : atrybuty) {
            double tmpZysk = zysk(przyklady, atrybut);
            if (tmpZysk > najlepszyZysk) {
                najlepszyZysk = tmpZysk;
                najlepszy = atrybut;
            }
        }
        return najlepszy;
    }

    public Decyzja decyduj(ElementDrzewa[][] przyklady) {
        int liczYes = 0;
        int liczNo = 0;
        for (int i = 1; i < przyklady.length; i++) {
            if (przyklady[i][przyklady[i].length - 1].toString().equals(daneWejsciowe.getOpcja1())) {
                liczYes++;
            } else {
                liczNo++;
            }
        }
        if (liczYes >= liczNo) {
            return new Decyzja(daneWejsciowe.getOpcja1());
        } else {
            return new Decyzja(daneWejsciowe.getOpcja2());
        }
    }

    public WartoscAtrybutu[] podajWartosci(Atrybut atrybut, ElementDrzewa[][] przyklady) {
        boolean czyNowy = true;
        ArrayList<WartoscAtrybutu> wartosci = new ArrayList<WartoscAtrybutu>();
        int kolumna = 0;
        for (int i = 0; i < przyklady[0].length; i++) {
            if (przyklady[0][i].toString().equals(atrybut.toString())) {
                kolumna = i;
            }
        }
        for (int i = 1; i < przyklady.length; i++) {
            czyNowy = true;
            WartoscAtrybutu tmp = (WartoscAtrybutu) przyklady[i][kolumna];
            for (WartoscAtrybutu obj : wartosci) {
                if (obj.toString().equals(tmp.toString())) {
                    czyNowy = false;
                }
            }
            if (czyNowy) {
                wartosci.add(tmp);
            }
        }
        WartoscAtrybutu[] wartosciString = new WartoscAtrybutu[wartosci.size()];
        int i = 0;
        for (WartoscAtrybutu obj : wartosci) {
            wartosciString[i++] = obj;
        }
        return wartosciString;
    }

    public ElementDrzewa[][] podajPrzykladyDlaWartosci(ElementDrzewa[][] przyklady, WartoscAtrybutu wartosc, Atrybut atrybut) {
        int liczWartosc = 0;
        int kolumna = 0;
        for (int i = 0; i < przyklady[0].length; i++) {
            if (przyklady[0][i].toString().equals(atrybut.toString())) {
                kolumna = i;
            }
        }
        for (int i = 1; i < przyklady.length; i++) {
            if (przyklady[i][kolumna].toString().equals(wartosc.toString())) {
                liczWartosc++;
            }
        }
        ElementDrzewa[][] tmp = new ElementDrzewa[liczWartosc + 1][przyklady[0].length];
        for (int i = 0; i < przyklady[0].length; i++) {
            tmp[0][i] = przyklady[0][i];
        }
        int tablicaTmp = 1;
        for (int i = 1; i < przyklady.length; i++) {
            if (przyklady[i][kolumna].toString().equals(wartosc.toString())) {
                for (int j = 0; j < przyklady[i].length; j++) {
                    tmp[tablicaTmp][j] = przyklady[i][j];
                }
                tablicaTmp++;
            }
        }
        return tmp;
    }

    public double entropia(ElementDrzewa[][] przyklady) {
        int iloscYes = 0;
        int iloscNo = 0;
        for (int i = 1; i < przyklady.length; i++) {
            if (przyklady[i][przyklady[i].length - 1].toString().equals(daneWejsciowe.getOpcja1())) {
                iloscYes++;
            } else {
                iloscNo++;
            }
        }
        double suma = iloscYes + iloscNo;
        double pplus = 0;
        double logplus = 0;
        if (iloscYes != 0) {
            pplus = iloscYes / suma;
            logplus = (Math.log(pplus) / Math.log(2));
        }
        double pminus = 0;
        double logminus = 0;
        if (iloscNo != 0) {
            pminus = iloscNo / suma;
            logminus = (Math.log(pminus) / Math.log(2));
        }
        return -pplus * logplus - pminus * logminus;
    }

    public double zysk(ElementDrzewa[][] przyklady, Atrybut atrybut) {
        WartoscAtrybutu[] wartosci = podajWartosci(atrybut, przyklady);
        double zysk = 0;
        for (WartoscAtrybutu wartosc : wartosci) {
            ElementDrzewa[][] przykladyDlaWartosci = podajPrzykladyDlaWartosci(przyklady, wartosc, atrybut);
            zysk += (((double) przykladyDlaWartosci.length - 1) * entropia(przykladyDlaWartosci)) / ((double) przyklady.length - 1);
        }
        zysk = entropia(przyklady) - zysk;
        return zysk;
    }
}