package ppa1;


import java.util.Locale;
import java.util.Scanner;

/**
 * @author Mikulas Mach
 * @version 1.0
 */
public class Ppa1u03a {

    /**
     * Vypocet korenu kvadraticke rovnice v realnych cislech a urceni toho zda se nachazeji v danem intervalu
     * @param args parametry prikazove radky
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("Zadej koeficient a: ");
        double a = sc.nextDouble();
        System.out.print("Zadej koeficient b: ");
        double b = sc.nextDouble();
        System.out.print("Zadej koeficient c: ");
        double c = sc.nextDouble();
        System.out.print("Zadej pocatek intervalu x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Zadej konec intervalu x2: ");
        double x2 = sc.nextDouble();

        int pocetReseni = 0;
        double koren1, koren2;

        double disktriminant = (b*b)-(4*a*c);
        System.out.println(disktriminant);
        double odmocnenejDisktriminant = Math.sqrt(disktriminant);

        if(disktriminant < 0){
            System.out.println("reseni: neexistuje");
        }

        else if(disktriminant == 0){
            koren1 = (-b+odmocnenejDisktriminant)/(2*a);

            if (x1 < koren1 && koren1 < x2){
                System.out.println("reseni: existuje jedno");
            }
            else {
                System.out.println("reseni: neexistuje");
            }
        }
        else{
            koren1 = (-b+odmocnenejDisktriminant)/(2*a);
            System.out.println(koren1);
            koren2 = (-b-odmocnenejDisktriminant)/(2*a);
            System.out.println(koren2);

            if (x1 < koren1 && koren1 < x2){
                pocetReseni++;
            }
            if (x1 < koren2 && koren2 < x2){
                pocetReseni++;
            }


            if(pocetReseni == 0){
                System.out.println("reseni: neexistuje");
            }
            if(pocetReseni == 1){
                System.out.println("reseni: existuje jedno");
            }
            if(pocetReseni == 2) {
                System.out.println("reseni: existuji dve");
            }
        }
    }
}
