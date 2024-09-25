package com.btcag.bootcamp;

import java.util.Scanner;

public class QuadraGleichungen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quadratische Gleichung:\nf(x)=ax^2 + bx +c\n\nGebe eine Zahl für [ a ] ein: ");
        double a = sc.nextDouble(); //Bisher kann a = 0 sein, aber nach Validierungen ist nicht gefragt?

        System.out.println("Gebe eine Zahl für [ b ] ein: ");
        double b = sc.nextDouble();

        System.out.println("Gebe eine Zahl für [ c ] ein: ");
        double c = sc.nextDouble();

        disCalculator(a,b,c);
    }

    public static void disCalculator(double a, double b, double c){
        double res = (b*b) - (4*a*c); //Diskriminante; Dis > 0 = 2 Lösungen, Dis < 0 = 0 Lösungen, Dis = 0 = 1 Lösung
        if (res > 0){
            System.out.println("Es gibt insgesamt 2 Lösungen, da " + res + " > 0 ist.");
        } else if (res < 0) {
            System.out.println("Es gibt insgesamt 0 Lösungen, da " + res + " < 0 ist.");
        } else {
            System.out.println("Es gibt insgesamt 1 Lösung, da " + res + " == 0 ist.");
        }
    }
}
