package ppa1;

import java.util.Scanner;


/**
 * @author Mikulas Mach
 * @version 211121
 */
public class Ppa1u07 {

    private static final Scanner sc = new Scanner(System.in);
    /**
     * Prubeh programu
     * @param args Jmeno postavy
     */
    public static void main(String[] args) {
        Postava postava1 = nactiPostavu(sc);
        Zbran levaP1 = nactiZbran(sc);
        Zbran pravaP1 = nactiZbran(sc);
        vyzbrojPostavu(postava1, levaP1, pravaP1);

        Postava postava2 = nactiPostavu(sc);
        Zbran levaP2 = nactiZbran(sc);
        Zbran pravaP2 = nactiZbran(sc);
        vyzbrojPostavu(postava2, levaP2, pravaP2);

        System.out.println("Vitez: " + souboj(postava1, postava2).toString());
    }

    /**
     * Nacte postavu
     */
    public static Postava nactiPostavu(Scanner sc){
        String jmeno = sc.nextLine();
        int sila = Integer.parseInt(sc.nextLine());
        int hbitost = Integer.parseInt(sc.nextLine());
        int vitalita = Integer.parseInt(sc.nextLine());
        return new Postava(jmeno, sila, hbitost, vitalita);
    }

    /**
     * Nacte zbran
     */
    public static Zbran nactiZbran(Scanner sc){
        String nazev = sc.nextLine();
        if(nazev.isEmpty()){
            return null;
        }
        else {
            int utok = Integer.parseInt(sc.nextLine());
            int obrana = Integer.parseInt(sc.nextLine());
            return new Zbran(nazev, utok, obrana);
        }
    }

    /**
     * Vyzbroji postavu
     */
    public static void vyzbrojPostavu(Postava postava, Zbran leva, Zbran prava){
        postava.vezmiZbran(Ruka.LEVA, leva);
        postava.vezmiZbran(Ruka.PRAVA, prava);
    }

    /**
     * Vyhodnoti prubeh souboje
     */
    public static Postava souboj(Postava postava1, Postava postava2){
        Postava vitez = null;

        //System.out.println(postava1.toString());
        //System.out.println(postava2.toString());


        while (postava1.jeZiva() && postava2.jeZiva()) {
            postava2.branSe(postava1.zautoc());
            //System.out.println("utoci " + postava1.toString() + " a dava " + postava2.branSe(postava1.zautoc()) + " zraneni");
            if(postava2.jeZiva() == false){
                vitez = postava1;
                return vitez;
            }
            else {
                postava1.branSe(postava2.zautoc());
                //System.out.println("utoci " + postava2.toString() + " a dava " + postava1.branSe(postava2.zautoc()) + " zraneni");
                if(postava1.jeZiva() == false){
                    vitez = postava2;
                    return vitez;
                }
            }
        }
        return vitez;
    }
}
