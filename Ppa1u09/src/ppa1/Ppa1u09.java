package ppa1;

import java.util.Scanner;


/**
 * @author Mikulas Mach
 * @version 211201
 */
public class Ppa1u09 {

    static final Scanner sc = new Scanner(System.in);

    /**
     * Hlavni metoda
     * @param args prvni udava min Hodnoceni a druhy min Delku
     */
    public static void main(String[] args) {

        Playlist playlist = vytvorPlaylist(sc);

        double minHodnoceni = Double.parseDouble(args[0]);
        int minDelka = Integer.parseInt(args[1]);

        Playlist finalniPlaylist = vyberStopy(minHodnoceni, minDelka, playlist);

        System.out.print(finalniPlaylist.toString());
        if(finalniPlaylist.getCelkovaDelka() < minDelka){
            System.out.print("\nPOZOR! Playlist je kratky");
        }
    }


    /**
     * Metoda ktera nacte ze vstupu data a vytvori novy playlist
     */
    public static Playlist vytvorPlaylist(Scanner sc){

        int pocetStop = Integer.parseInt(sc.nextLine());
        Stopa stopyPlaylistu[] = new Stopa[pocetStop];

        for(int i = 0; i < pocetStop; i++){

            String nazev = sc.nextLine();
            int delka = Integer.parseInt(sc.nextLine());
            double hodnoceni = Double.parseDouble(sc.nextLine());

            stopyPlaylistu[i] = (new Stopa(nazev, delka, hodnoceni));
        }

        return new Playlist(stopyPlaylistu);
    }

    /**
     * Metoda vybere playlist podle pozadavku
     */

    public static Playlist vyberStopy(double minHodnoceni, int minDelka, Playlist playlist){

        Playlist vystup = playlist.filtrujHodnoceni(minHodnoceni);
        vystup = vystup.zamichej();
        vystup = vystup.vyberCelkovouDelku(minDelka);

        return vystup;
    }
}
