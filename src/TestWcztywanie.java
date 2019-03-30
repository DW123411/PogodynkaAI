

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestWcztywanie {
        Wczytywanie unit = new Wczytywanie();
    @Test
    public void loadFile()
    {        
     /*   Wczytywanie unit = new Wczytywanie();
        unit.wczytajDrzewoZPliku("src/test.txt");
        assertEquals("0", unit.wezly.get(0));
        assertEquals("Outlook", unit.wezly.get(1));
        assertEquals("null", unit.wezly.get(2));
        assertEquals("1", unit.wezly.get(3));
        assertEquals("0", unit.wezly.get(4));
        assertEquals("Sunny", unit.wezly.get(5));
        assertEquals("true", unit.wezly.get(6));
        assertEquals("Outlook", unit.wezly.get(7));
        assertEquals("1", unit.wezly.get(8));
        assertEquals("0", unit.wezly.get(9));
        assertEquals("Cloudy", unit.wezly.get(10));
        assertEquals("false", unit.wezly.get(11));
        assertEquals("Outlook", unit.wezly.get(12));*/
    }
    @Test(expected=IOException.class)
    public void czyPlikJestPusty() throws IOException {

        // Jesli tresc pliku nie istnieje (jest pusta)
        System.out.println("readFile");
        unit.wczytajDrzewoZPliku("src/test.txt");
        Drzewo<ElementDrzewa> result = unit.wczytajDrzewoZPliku("src/test.txt");
    }
    //Zastosowanie asercji @Test(excepcted=tunazwaklasywyjatku.class) buduje test (metodę), której wywołanie niezakończone wyrzuceniem wyjątku będzie uznawane za porażkę testu. 
    //Jest to bardzo użyteczny sposób na ich testowanie.

    @Test
    public void SprawdzanieTreści () throws Exception {

        // Jesli tresc pliku to 'Outlook'
           unit.wczytajDrzewoZPliku("test.txt");
           Drzewo<ElementDrzewa> result = unit.wczytajDrzewoZPliku("src/test.txt");
           assertEquals("test", result);

        }
    }     

