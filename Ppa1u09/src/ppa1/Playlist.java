package ppa1;

import java.util.Random;

/**
 * @author Mikulas Mach
 * @version 211201
 */
public class Playlist {

    final Stopa[] stopy;

    /**
     * Konstruktor ktery vytvori playlist
     * @param stopy stopy vlozene do puvodniho playlistu
     */
    public Playlist(Stopa[] stopy){
        this.stopy = stopy;
    }

    /**
     * Metoda ktera vraci celkovou dobu playlistu
     */
    public int getCelkovaDelka(){

        int celkovaDoba = 0;

        for (Stopa stopa : stopy) {
            celkovaDoba += stopa.getDelka();
        }
        return celkovaDoba;
    }

    /**
     * Metoda ktera vytvori z playlistu novy, vybere pouze stopy
     * ktere maji vetsi nebo rovne hodnoceni jako jake je zadane v konstruktoru
     * @param minHodnoceni Minimalni hodnoceni ktere musi stopy splnovat
     */
    public Playlist filtrujHodnoceni(double minHodnoceni){

        int pocetStop = 0;

        for (Stopa stopa : stopy) {
            if (stopa.getHodnoceni() >= minHodnoceni) {
                pocetStop++;
            }
        }

        Stopa novyPlaylist[] = new Stopa[pocetStop];

        int index = 0;

        for(int i = 0; i < stopy.length; i++){
            if(stopy[i].getHodnoceni() >= minHodnoceni){
                novyPlaylist[index] = stopy[i];
                index++;
            }
        }

        return new Playlist(novyPlaylist);
    }

    /**
     * Metoda vytvori novy playlist ktery bude mit delku vetsi nebo rovnu parametru
     * @param minDelka Minimalni delka playlistu
     */
    public Playlist vyberCelkovouDelku(int minDelka){

        int pocetStop = 0;
        int aktualniDelka = 0;

        for(int i = 0; aktualniDelka < minDelka && i < stopy.length; i++){
            aktualniDelka += stopy[i].getDelka();
            pocetStop++;
        }

        Stopa novyPlaylist[] = new Stopa[pocetStop];

        for(int i = 0; i < pocetStop; i++){
            novyPlaylist[i] = stopy[i];
        }

        return new Playlist(novyPlaylist);
    }

    /**
     * Metoda ktera vytvori novy playlist, ktery bude mit nahodne prohazene stopy
     */
    public Playlist zamichej(){
        Random random = new Random();
        Stopa novyPlaylist[] = new Stopa[stopy.length];

        for(int i = 0; i < stopy.length; i++){
            novyPlaylist[i] = stopy[i];
        }

        for (int i = 0; i < stopy.length; i++) {

            int randomIndex = random.nextInt(novyPlaylist.length);
            Stopa vymena1 = novyPlaylist[i];
            Stopa vymena2 = novyPlaylist[randomIndex];
            novyPlaylist[randomIndex] = vymena1;
            novyPlaylist[i] = vymena2;
        }

        return new Playlist(novyPlaylist);
    }

    /**
     * Metoda vrati string ve kterem jsou vsechny infromace o danem playlistu
     */
    @Override
    public String toString(){
        String vystup = "";
        for(int i = 0; i < stopy.length; i++){
            vystup += stopy[i].toString() + "\n";
        }

        int sekundy = this.getCelkovaDelka(); //vypocet casu
        int minuty = 0;
        for(int i = 0; sekundy >= 60; sekundy -= 60){
            minuty++;
        }

        vystup += String.format("[%d:%02d]", minuty, sekundy);

        return vystup;
    }
}
