package ppa1;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Mikulas Mach
 * @version 2.0
 */
public class Ppa1u05b {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * hledani primitivni pythagorejske trojice
     * @param args parametry prikazove radky
     */
    public static void main(String[] args) {

        sc.useLocale(Locale.US);

        System.out.print("c: ");
        najdi(sc.nextInt());


    }


    /**
     * overeni soudelnosti zadanych cisel
     * @param a nalezene funkci najdi
     * @param b nalezene funkci najdi
     * @param c vstup uzivatele
     */
    private static boolean soudelnost(int a, int b, int c){
        for(int i = 2; i <= a; i++){
            if(a % i == 0 && b % i == 0 && c % i == 0){
                return true;
            }
        }
        return false;
    }

    /**
     * hledani b a c
     * @param c vstup uzivatele
     */
    private static boolean najdi(int c){

        for(int a = 1;a < c-1; a++){
            for(int b = 1; b < c; b++){
                if(a*a+b*b == c*c){
                    if(!soudelnost(a,b,c)) {
                        System.out.println(a + "^2" + " + " + b + "^2 = " + c + "^2");
                        return true;
                    }
                }
            }
        }
        System.out.println("Reseni neexistuje.");
        return false;
    }
}
