package ppa1;

import java.util.Scanner;

/**
 * @author Mikulas Mach
 * @version 211128
 */
public class Ppa1u08 {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * hlavni metoda
     */
    public static void main(String[] args) {


        Svet svet = new Svet(7, 5, new char[] {
                '#','#','#','#','#','#','#',
                '#',' ','#',' ',' ',' ','#',
                '#',' ','#',' ',' ',' ','#',
                '#',' ',' ',' ','#',' ','#',
                '#','#','#','#','#','#','#',
        });
        GUI gui = new GUI(7, 5, sc);
        Postava postava = new Postava(svet,2,3,3,2);

        if(spust(gui, svet, postava)){
            System.out.println("Konecne doma... ");
        }
        else{
            System.out.println("Asi jsem se ztratil...");
        }

    }

    /**
     * metoda zajistujici beh programu
     */
    public static boolean spust(GUI gui, Svet svet, Postava postava){
        while(true){
            gui.smaz();
            svet.vykresli(gui);
            postava.vykresli(gui);
            gui.vykresli();
            boolean muzeJit = postava.jdi(gui.nactiAkci());
            if(!muzeJit){
                return false;
            }
            if(postava.jeDoma()){
                return true;
            }
        }
    }
}
