package ppa1;

/**
 * @author Mikulas Mach
 * @version 211121
 */
public class Postava {

    private final String jmeno;
    private final int sila;
    private final int hbitost;
    private final int vitalita;
    private int aktualniVitalita;
    private Zbran levaZbran = null;
    private Zbran pravaZbran = null;

    /**
     * Konstruktor postavy
     * @param jmeno Jmeno postavy
     * @param sila Sila postavy
     * @param hbitost Hbitost postavy
     * @param vitalita Vitalita postavy
     */
    public Postava(String jmeno, int sila, int hbitost, int vitalita){
        this.jmeno = jmeno;
        this.sila = sila;
        this.hbitost = hbitost;
        this.vitalita = vitalita;
        this.aktualniVitalita = vitalita;
    }

    /**
     * Priradi urcitou zbran do urcite ruky
     * @param ruka Ruka do ktere bude zbtan vlozena
     * @param zbran Zbran ktera bude vlozena
     */
    public boolean vezmiZbran(Ruka ruka, Zbran zbran){
        if(ruka == Ruka.LEVA){
            if(levaZbran == null){
                levaZbran = zbran;
                return true;
            }
            else{
                return false;
            }
        }
        else {
            if(pravaZbran == null){
                pravaZbran = zbran;
                return true;
            }
            else{
                return false;
            }
        }
    }

    /**
     * Odecte aktualni vitalitu podle toho jak silny je prichazejici utok a jakou ma postava obranou silu
     * @param utok prichazejici poskozeni
     */
    public int branSe(int utok){
        int ubrano;
        int obranaSila = hbitost;
        if(levaZbran != null){
            obranaSila += levaZbran.getObrana();
        }
        if(pravaZbran != null){
            obranaSila += pravaZbran.getObrana();
        }

        ubrano = utok - obranaSila;
        if(ubrano < 1){
            return 0;
        }
        else{
            aktualniVitalita -= ubrano;
            return ubrano;
        }
    }

    /**
     * Vrati soucet sily postavy a utok obou zbrani
     */
    public int zautoc(){

        int utocnaSila = sila;
        if(levaZbran != null){
            utocnaSila += levaZbran.getUtok();
        }

        if(pravaZbran != null){
            utocnaSila += pravaZbran.getUtok();
        }
        return utocnaSila;
    }

    /**
     * Urci zda postava je ziva
     */
    public boolean jeZiva(){

        if(aktualniVitalita > 0){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Vypis informaci o postave
     */
    @Override
    public String toString(){
        if(levaZbran == null && pravaZbran == null) {
            return jmeno + " [" + aktualniVitalita + "/" + vitalita + "] (" + sila + "/" + hbitost + ")";
        }
        else if(levaZbran != null && pravaZbran == null){
            return jmeno + " [" + aktualniVitalita + "/" + vitalita+ "] (" + (sila + levaZbran.getUtok()) + "/" + (hbitost + levaZbran.getObrana())  + ")";
        }
        else if (levaZbran == null) {
            return jmeno + " [" + aktualniVitalita + "/" + vitalita+ "] (" + (sila + pravaZbran.getUtok()) + "/" + (hbitost + pravaZbran.getObrana()) + ")";
        }
        else {
            return jmeno + " [" + aktualniVitalita + "/" + vitalita+ "] (" + (sila + levaZbran.getUtok() + pravaZbran.getUtok()) + "/" + (hbitost + levaZbran.getObrana() + pravaZbran.getObrana()) + ")";
        }
    }
}
