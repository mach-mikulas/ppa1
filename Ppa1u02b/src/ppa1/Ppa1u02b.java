package ppa1;
/**
 * @author Mikulas Mach
 * @version 2.0
 */

import java.util.Locale;
import java.util.Scanner;

public class Ppa1u02b {
    /**
     * Vypocet zbyvajicich bodu a nasledny jejich vypis
     * @param args parametry prikazove radky
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Zadej Ax: ");
        double ax = sc.nextDouble();
        System.out.print("Zadej Ay: ");
        double ay = sc.nextDouble();
        System.out.print("Zadej Dx: ");
        double dx = sc.nextDouble();
        System.out.print("Zadej Dy: ");
        double dy = sc.nextDouble();

        double vektorADx = (dx - ax);
        double vektorADy = (dy - ay);

        double vektorDAx = ax - dx;
        double vektorDAy = ay - dy;

        double bx = (-(vektorADy) /2.0) + ax;
        double by = (vektorADx /2.0) + ay;

        double cx = ((vektorDAy /2.0) + dx);
        double cy = (-(vektorDAx /2.0) + dy);

        System.out.println("Bx = " +String.format(Locale.US,"%.3f", bx));
        System.out.println("By = " +String.format(Locale.US,"%.3f", by));
        System.out.println("Cx = " +String.format(Locale.US,"%.3f", cx));
        System.out.println("Cy = " +String.format(Locale.US,"%.3f", cy));



    }
}

