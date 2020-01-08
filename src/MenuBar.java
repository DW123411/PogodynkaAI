
/**
 *
 * @author majzner marcin
 */
import javax.swing.*;

public class MenuBar extends JMenuBar {
JMenu plik = new JMenu("Plik");
//
private Okno parent;
 JMenuItem wczytalldata = new JMenuItem("Wczytaj dane.");
JMenuItem wczytdladecyzji = new JMenuItem("Wczytaj dane bez decyzji.");
JSeparator endwczytaj = new JSeparator();
///
JMenuItem zapiszPlikJPG = new JMenuItem("Zapisz obraz.");
JMenuItem zapiszPlikTXT = new JMenuItem("Zapisz do pliku tekstowego.");
JSeparator endzapis = new JSeparator();
JMenuItem exit = new JMenuItem("Zakończ.");

///

JMenu edycja = new JMenu("Edycja");
//

JMenuItem rysujdrzewo = new JMenuItem("Rysuj drzewo.");
    JMenuItem wyswietlDecyzje = new JMenuItem("Wyświetl decyzję.");
JMenuItem wyczysc = new JMenuItem("Wyczyść.");
JSeparator endrys = new JSeparator();
///
JMenuItem ustawrozmiarzbiorow = new JMenuItem("Ustaw rozmiary zbiorów.");
JMenuItem ustawmaxglebokosc = new JMenuItem("Ustaw maksymalną głębokość.");
//

JMenu widok = new JMenu("Widok");
JMenuItem pokatabele = new JMenuItem("Pokaż tabelę.");
JMenuItem pokaaccuracy = new JMenuItem("Dokładność.");
JMenuItem schowajMenu = new JMenuItem("Schowaj menu.");
JSeparator endtabela = new JSeparator();
///
JMenuItem scalowanie = new JMenuItem("Skalowanie.");
JSeparator endskalowanie = new JSeparator();
///
JMenuItem motywy = new JMenuItem("Wybór motywu.");
// 
JMenu info = new JMenu("Info");
JMenuItem credits = new JMenuItem("O programie.");


public MenuBar(Okno parent){
    super();

    plik.add(wczytalldata);
plik.add(wczytdladecyzji);
plik.add(endwczytaj);
   plik.add(zapiszPlikJPG);
plik.add(zapiszPlikTXT);
plik.add(endzapis);
plik.add(exit);

edycja.add( rysujdrzewo  );
edycja.add (wyswietlDecyzje);
edycja.add( wyczysc  );
edycja.add( endrys  );
edycja.add( ustawrozmiarzbiorow  );
edycja.add( ustawmaxglebokosc  );

widok.add( pokatabele  );
widok.add( pokaaccuracy  );
widok.add(schowajMenu);
widok.add( endtabela  );
widok.add( scalowanie  );
widok.add(  endskalowanie );
widok.add(  motywy );

info.add( credits  );

add(plik);
add(edycja);
add(widok);
add(info);
    
    
    
    
}



    
}
