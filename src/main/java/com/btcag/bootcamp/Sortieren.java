package com.btcag.bootcamp;

public class Sortieren {
    public static void main(String[] args) {
        int[] list = {5,13,6,8,11};

        sortArray(list);
        printArray(list);
    }

    private static void sortArray(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i+1] < list[i]){
                int tmp = list[i+1];
                list[i+1] = list[i];
                list[i] = tmp;
            }
        }
    }

    private static void printArray(int[] list) {
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
