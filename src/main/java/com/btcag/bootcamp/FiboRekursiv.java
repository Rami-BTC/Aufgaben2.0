package com.btcag.bootcamp;

public class FiboRekursiv {

    public static int a = 0;
    public static int b = 1;

    public static void main(String[] args) {
        System.out.print("0 1 ");
        fibonacci(1);
    }

    public static int fibonacci(int n){
        n = a + b;
        a = b;
        b = n;

        if (n > 100){
            return 0;
        } else{
            System.out.print(n + " ");
            return fibonacci(n);
        }
    }
}