package ppa1;

import java.util.Scanner;

/**
 * @author Mikulas Mach
 * @version 1.0
 */
public class Ppa1u03b {

    /**
     * Vypocet doporuceni navstevi kina
     * @param args parametry prikazove radky
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("zacatek filmu A:");
        System.out.print("hodina: ");
        int filmZacatekHodinaA = sc.nextInt();
        System.out.print("minuta: ");
        int filmZacatekMinutaA = sc.nextInt();
        System.out.println("delka filmu A:");
        System.out.print("hodina: ");
        int filmDelkaHodinaA = sc.nextInt();
        System.out.print("minuta: ");
        int filmDelkaMinutaA = sc.nextInt();

        System.out.println();

        System.out.println("zacatek filmu B:");
        System.out.print("hodina: ");
        int filmZacatekHodinaB = sc.nextInt();
        System.out.print("minuta: ");
        int filmZacatekMinutaB = sc.nextInt();
        System.out.println("delka filmu B:");
        System.out.print("hodina: ");
        int filmDelkaHodinaB = sc.nextInt();
        System.out.print("minuta: ");
        int filmDelkaMinutaB = sc.nextInt();

        if(filmZacatekHodinaA < 4){
            filmZacatekHodinaA = filmZacatekHodinaA + 24;
        }

        if(filmZacatekHodinaB < 4){
            filmZacatekHodinaB = filmZacatekHodinaB + 24;
        }

        int filmZacatekVMinutachA = (filmZacatekHodinaA*60)+filmZacatekMinutaA;
        int filmDelkaVMinutachA = (filmDelkaHodinaA*60)+filmDelkaMinutaA;

        int filmZacatekVMinutachB = (filmZacatekHodinaB*60)+filmZacatekMinutaB;
        int filmDelkaVMinutachB = (filmDelkaHodinaB*60)+filmDelkaMinutaB;

        int filmKonecA = filmZacatekVMinutachA + filmDelkaVMinutachA;
        System.out.println(filmKonecA);
        int filmKonecB = filmZacatekVMinutachB + filmDelkaVMinutachB;
        System.out.println(filmKonecB);

        if(filmKonecA <= filmZacatekVMinutachB){
            System.out.println("doporuceni: v pohode ");
        }
        else if (filmKonecA > filmZacatekVMinutachB && filmKonecA < filmKonecB){
            int filmZbytekB = filmDelkaVMinutachB-(filmKonecB-filmKonecA);
            System.out.println("doporuceni: neuvidis " + filmZbytekB + " minut");
        }
        else{
            System.out.println("doporuceni: to nedas ");
        }
    }
}
