package com.btcag.bootcamp;

public class Sortieren {
    public static void main(String[] args) {
        int[] list = {5,13,6,8,11};

        for (int i = 0; i < list.length - 1; i++) {
            if (list[i+1] < list[i]){
                int tmp = list[i+1];
                list[i+1] = list[i];
                list[i] = tmp;
            }
        }

        System.out.print("[");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
            if (i < list.length - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
