package ppa1;

/**
 * @author Mikulas Mach
 * @version 1.0
 */

import java.util.Locale;
import java.util.Scanner;

public class Ppa1u02a {
    /**
     * Vstup uzivatele a vypocet cen
     * @param args parametry prikazove radky
     */
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.print("Zadej cenu vstupenky [Kc]: ");
        double cenaVstupenka = sc.nextDouble();
        System.out.print("Zadej cenu klubove karty [Kc]: ");
        double cenaKarta = sc.nextDouble();
        System.out.print("Zadej slevu [%]: ");
        double sleva = sc.nextDouble();

        double klubovaCena = cenaVstupenka*((100-sleva)/100);

        System.out.println("cena vstupenky: " +String.format(Locale.US,"%.1f",+cenaVstupenka));
        System.out.println("klubova cena: " +String.format(Locale.US,"%.1f",+klubovaCena));
        System.out.println("1 akce: " +String.format(Locale.US,"%.1f",(cenaKarta+klubovaCena)));
        System.out.println("2 akce: " +String.format(Locale.US,"%.1f",(cenaKarta/2+klubovaCena)));
        System.out.println("3 akce: " +String.format(Locale.US,"%.1f",(cenaKarta/3+klubovaCena)));
    }
}

