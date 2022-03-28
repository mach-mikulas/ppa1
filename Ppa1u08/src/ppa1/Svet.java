package ppa1;

/**
 * @author Mikulas Mach
 * @version 211128
 */
public class Svet {

    final int sirka;
    final int vyska;
    final char[] data;

    /**
     * Konstruktor sveta
     */
    public Svet(int sirka, int vyska, char[] data){
        this.sirka = sirka;
        this.vyska = vyska;
        this.data = data;
    }

    /**
     * Metoda ktera vrati uzemi ktere se nachazi na zadanych souradnicich
     */
    public char uzemi(int x, int y){
        if(x >= sirka || x < 0 || y >= vyska || y < 0){
            return 0;
        }
        else {
            int pozice = (sirka * y) + x;
            return data[pozice];
        }
    }

    /**
     * Metoda vykresli svet na platno
     */
    public void vykresli(GUI gui){
        int pozice;
        char znak;
        for(int radek = 0; radek < sirka; radek++){
            for(int sloupec = 0; sloupec < vyska; sloupec++){
                pozice = (sirka * sloupec) + radek;
                znak = data[pozice];
                gui.zapis(radek, sloupec, znak);
            }
        }
    }
}
