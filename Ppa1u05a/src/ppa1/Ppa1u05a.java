package ppa1;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Mikulas Mach
 * @version 1.0
 */
public class Ppa1u05a {
    private static final double epsilon = 0.000001;
    private static final Scanner sc = new Scanner(System.in);

    /** Funkce pro vypocet zadane funkce*/
    private static double funkceXYT(double x,double y,double t){
       return Math.sin(Math.sqrt((x*x)+(y*y)) - (2 * Math.PI * t));
   }

    /**
     * Vypocet zadaneho prikladu
     * @param args parametry prikazove radky
     */
    public static void main(String[] args) {

        sc.useLocale(Locale.US);
        System.out.print("x1: ");
        double x1 = sc.nextDouble();
        System.out.print("x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Xs: ");
        double xs = sc.nextDouble();

        System.out.print("y1: ");
        double y1 = sc.nextDouble();
        System.out.print("y2: ");
        double y2 = sc.nextDouble();
        System.out.print("Ys: ");
        double ys = sc.nextDouble();

        System.out.print("Ts: ");
        double ts = sc.nextDouble();

        double delkaX;
        double delkaY;

        if(x1 >= 0 && x2 > 0){
            delkaX = x2 - x1;
        }
        else  {
            delkaX = Math.abs(x1) + x2;
        }

        if(y1 >= 0 && y2 > 0) {
            delkaY = y2 - y1;
        }
        else  {
            delkaY = Math.abs(y1) + y2;
        }

        double krokX = delkaX * (1/(xs-1.0));
        double krokY = delkaY * (1/(ys-1.0));
        double krokT = 1.0/ts;

        System.out.println("x, y, z, t");
        for(double soucasneT = 0; soucasneT < 1; soucasneT += krokT){
            for(double soucasneY = y1; soucasneY <= y2 + epsilon; soucasneY += krokY) {

                for(double soucasneX = x1; soucasneX <= x2 + epsilon; soucasneX += krokX){
                    System.out.println(String.format(Locale.US,"%.6f, %.6f, %.6f, %.6f" , soucasneX, soucasneY, funkceXYT(soucasneX,soucasneY,soucasneT), soucasneT));
                }

            }

        }

    }
}
