package ppa1;

import java.util.Scanner;

/**
 * @author Mikulas Mach
 * @version 211128
 */
public class GUI {

    final int sirka;
    final int vyska;
    final Scanner sc;
    final char[] platno;

    /**
     * Konstruktor gui
     */
    public GUI(int sirka, int vyska, Scanner sc){
      this.sirka = sirka;
      this.vyska = vyska;
      this.sc = sc;
      this.platno = new char[sirka*vyska];
    }

    /**
     * Smaze vsechny prvky platna
     */
    public void smaz(){
            for(int i = 0; i < sirka*vyska; i++){
                platno[i] = ' ';
            }
        }

    /**
     * Zapise dany znak na dane souradnice v platne
     */
    public void zapis(int x, int y, char znak){
        int pozice = (sirka*y)+x;
        platno[pozice] = znak;
    }

    /**
     * Vykresli cele platnou na konzoli
     */
    public void vykresli(){
        int odsazeni = 0;
        for(int posun = 0; posun <=platno.length-1; posun += sirka){
            for(int i = 0+posun; i < sirka+posun; i++){
                System.out.print(platno[i]);
            }
            if(odsazeni < vyska-1) {
                System.out.print("\n");
            }
            odsazeni +=1;
        }
    }

    /**
     * Nacte akci od uzivatele
     */
    public Smer nactiAkci(){
        System.out.print("\nKam dal? ");
        switch(sc.nextInt()){
            case 8:
                return Smer.SEVER;
            case 6:
                return Smer.VYCHOD;
            case 2:
                return Smer.JIH;
            case 4:
                return Smer.ZAPAD;
            default:
                return null;
        }
    }
}
