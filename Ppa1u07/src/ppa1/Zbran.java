package ppa1;

/**
 * @author Mikulas Mach
 * @version 211121
 */
public class Zbran {

    private final String nazev;
    private final int utok;
    private final int obrana;

    /**
     * Konstruktor zbrane
     * @param jmeno Jmeno zbrane
     * @param utok utocna sila zbrane
     * @param obrana obrana sila zbrane
     */
    public Zbran(String nazev, int utok, int obrana){
        this.nazev = nazev;
        this.utok = utok;
        this.obrana = obrana;
    }
    /**
     * Vrati utocnou silu zbrane
     */
    public int getUtok(){
        return utok;
    }

    /**
     * Vrati obranou silu zbrane
     */
    public int getObrana(){
        return obrana;
    }

    /**
     * Vypis informaci o zbrani
     */
    @Override
    public String toString(){
        return nazev + " (" + utok + "/" + obrana + ")";
    }
}
