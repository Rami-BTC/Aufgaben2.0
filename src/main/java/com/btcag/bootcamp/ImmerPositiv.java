package com.btcag.bootcamp;

import java.util.Scanner;

public class ImmerPositiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gebe eine ganze Zahl ein: ");
        int num = sc.nextInt();

        System.out.print("Die positive Zahl ist: " + convertToPos(num));
    }

    public static int convertToPos(int num){
        if (num < 0){ return num * (-1);
        } else { return num;}
    }
}
