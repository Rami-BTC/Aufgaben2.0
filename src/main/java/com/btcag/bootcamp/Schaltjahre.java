package com.btcag.bootcamp;

import java.util.Scanner;

public class Schaltjahre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int leapYear;
        while (true){
            System.out.println("Gebe ein Jahr ein: ");
            leapYear = sc.nextInt();
            leapYearCal(leapYear);
        }
    }

    public static void leapYearCal(int leapYear){
        if (leapYear % 4 == 0){
            if (leapYear % 100 == 0 && leapYear % 400 != 0){
                System.out.println(leapYear + " ist kein Schaltjahr.\n");
            } else{
                System.out.println(leapYear + " ist ein Schaltjahr.\n");
            }
        }
    }
}
