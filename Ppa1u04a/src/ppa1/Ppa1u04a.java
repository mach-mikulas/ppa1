package ppa1;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Mikulas Mach
 * @version 1.0
 */
public class Ppa1u04a {

    /**
     * Vypocet zadane funkce
     */
    static double funkceFX(double x, double a, double b, double c){
        return Math.cos(x) + a * Math.cos(b * x + c);
    }

    /**
     * Hledani minim a maxim
     * @param args parametry prikazove radky
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("a=");
        double a = sc.nextDouble();
        System.out.print(", b=");
        double b = sc.nextDouble();
        System.out.print(", c=");
        double c = sc.nextDouble();
        System.out.print(", x1=");
        double x1 = sc.nextDouble();
        System.out.print(", x2=");
        double x2 = sc.nextDouble();


        final double delta = 1.0 / 1024;
        int min = 0;
        int max = 0;

        while(x1 <= x2){
            double prvniZnamenko = funkceFX(x1 - delta, a, b, c) - funkceFX(x1, a, b, c);
            double druheZnamenko = funkceFX(x1, a, b, c) - funkceFX(x1 + delta, a, b, c);

            if(prvniZnamenko > 0 && druheZnamenko <= 0){
                min++;
            }

            if(prvniZnamenko <= 0 && druheZnamenko > 0){
                max++;
            }

            x1 = x1 + delta;
        }

        System.out.println("min: " + min);
        System.out.println("max: " + max);

    }
}
