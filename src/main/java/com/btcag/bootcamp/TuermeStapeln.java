package com.btcag.bootcamp;

import java.util.Arrays;

public class TürmeStapeln {
    public static int[] src = {1,2,3,4};
    public static int[] middle = {0, 0, 0, 0};
    public static int[] dest = {0, 0, 0, 0};

    public static int disk = 4;

    public static void main(String[] args) {

        spaceCheck(disk, src, middle, dest);

        System.out.print(Arrays.toString(src) + "\n" + Arrays.toString(middle) + "\n"
                + Arrays.toString(dest) + "\n-----------------------\n");
    }

    public static void spaceCheck(int disk, int[] src, int[] middle, int[] dest){
        if (disk == 1){
            move(src, dest);
            return;
        }


        spaceCheck(disk - 1, src, dest, middle);
        move(src, dest);
        spaceCheck(disk - 1, middle, src, dest);
    }

    public static void move(int[] src, int[] dst){
        int srcFirst = firstPlate(src);
        int disk = src[srcFirst];
        int destFirst = firstPlate(dst) - 1;

        dst[destFirst] = disk;
        src[srcFirst] = 0;

    }

    public static int firstPlate(int[] src){
        for (int i = 0; i < src.length; i++){
            if (src[i] != 0){
                return i;
            }
        }
        return src.length;
    }
}
