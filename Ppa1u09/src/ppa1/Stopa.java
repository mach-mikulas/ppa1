package ppa1;

/**
 * @author Mikulas Mach
 * @version 211201
 */
public class Stopa {

    final String nazev;
    final int delka;
    final double hodnoceni;

    /**
     * Konstruktor ktery vytvori novou stopu
     * @param nazev nazev stopy
     * @param delka delka stopy v sekundach
     * @param hodnoceni hodnoceni stopy od 1.00(nejhorsi) do 5.00(nejlepsi)
     */
    public Stopa(String nazev, int delka, double hodnoceni){
        this.nazev = nazev;
        this.delka = delka;
        this.hodnoceni = hodnoceni;
    }

    /**
     * Metoda vrati delku stopy v sekundach
     */
    public int getDelka(){
        return delka;
    }

    /**
     * Metoda vrati hodnoceni stopy
     */
    public double getHodnoceni(){
        return hodnoceni;
    }

    /**
     * Metoda vrati string ve kterem jsou vsechny infromace o stope
     */
    @Override
    public String toString(){

        double hodnoceni = getHodnoceni();
        String hodnoceniString = "";
        int sekundy = this.getDelka();
        int minuty = 0;
        for(int i = 0; sekundy >= 60; sekundy -= 60){
            minuty++;
        }

        for(int i = 0; hodnoceni >= 1; hodnoceni -= 1){
            hodnoceniString += "*";
        }

        if(hodnoceni >= 0.75){
            hodnoceniString += "*";
        }
        else if(hodnoceni >= 0.25){
            hodnoceniString += ".";
        }
        String meziVystup = String.format("[%d:%02d]", minuty, sekundy);
        String vystup = this.nazev + " " + meziVystup + " ("+hodnoceniString+")";
        return vystup;
    }
}
