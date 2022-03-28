package ppa1;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Mikulas Mach
 * @version 2.0
 */
public class Ppa1u04b {
    /**
     * Vypocet weighted moving average
     * @param args parametry prikazove radky
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double vstup1;
        double vstup2 = 0;
        double vstup3 = 0;
        double vstup4 = 0;
        int poradi = 1;
        String vypis;

        while((vstup1 = sc.nextDouble()) != 0){

            vypis = poradi + ";" + String.format(Locale.US,"%.2f", vstup1) + ";";

            if(vstup4 != 0 && vstup3 != 0 && vstup2 != 0){
                double wma = 0.1*vstup4+0.2*vstup3+0.3*vstup2+0.4*vstup1;
                vypis = vypis + String.format(Locale.US,"%.2f", wma);
            }

            vstup4 = vstup3;
            vstup3 = vstup2;
            vstup2 = vstup1;

            poradi++;

            System.out.println(vypis);
        }
    }
}
