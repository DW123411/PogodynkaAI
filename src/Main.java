
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException,FileNotFoundException {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Okno();
            }
        });
    }
}
