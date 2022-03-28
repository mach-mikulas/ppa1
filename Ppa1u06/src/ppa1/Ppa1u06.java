package ppa1;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Mikulas Mach
 * @version 1.0
 */
public class Ppa1u06 {

    private static final Scanner sc = new Scanner(System.in);

    /** Funkce pro overeni zda zadane cislo je prvocislo*/
    public static boolean jePrvocislo(int cislo){

        if(cislo == 1){
            return false;
        }

        for (int i = 2; i<= cislo/2; i++) {
            if ((cislo % i) == 0) {
                return false;
            }
        }
        return true;
    }
    /** Funkce pro nalezeni dvou prvocisel jejichz soucet je zadane cislo*/
    public static int jeSoucetPrvocisel(int cislo){
        for(int prvocislo1 = 2; prvocislo1 < cislo; prvocislo1++){

            for(int prvocislo2 = 2; prvocislo2 < cislo; prvocislo2++){

                if(jePrvocislo(prvocislo1) && jePrvocislo(prvocislo2)){
                    if(prvocislo1 + prvocislo2 == cislo){
                        System.out.println("Lze rozlozit: " + prvocislo1 + " + " + prvocislo2);
                        return prvocislo2;
                    }
                }
            }
        }
        System.out.println("Nelze rozlozit.");
        return 0;
    }
    /** Funkce pro zajisteni vstupu*/
    public static int nactiPrirozeneCislo(Scanner sc){
        sc.useLocale(Locale.US);

        System.out.print("Zadej prirozene cislo: ");
        int vstup = sc.nextInt();

        while(vstup < 1){
            System.out.print("Zadej prirozene cislo: ");
            vstup = sc.nextInt();
        }
        return vstup;
    }


    public static void main(String[] args) {
        sc.useLocale(Locale.US);
        jeSoucetPrvocisel(nactiPrirozeneCislo(sc));
    }
}
