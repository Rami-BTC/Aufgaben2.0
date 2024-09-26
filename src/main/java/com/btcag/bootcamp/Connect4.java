package com.btcag.bootcamp;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Connect4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] playArea = new String[6][7];

        System.out.println("Spieler 1: Bitte gebe einen Namen ein: ");
        String player1 = userLogin(sc);
        String[][] player1Slots = new String[6][7];


        System.out.println("\nSpieler 2: Bitte gebe einen Namen ein: ");
        String player2 = userLogin(sc);
        String[][] player2Slots = new String[6][7];

        gameLoop(playArea, player1Slots, player2Slots, player1, player2, sc);
    }

    private static void gameLoop(String[][] playArea, String[][] player1Slots, String[][] player2Slots, String player1, String player2, Scanner sc) {
        int round = 1;

        boolean gameOver = false;
        while (!gameOver) {
            if (round % 2 == 0) {
                createField(playArea, player1Slots, player2Slots, player1, player2);
                turn(sc, player2Slots, player2, playArea);
                gameOver = checkForWin(player2Slots, player2);

            } else {
                createField(playArea, player1Slots, player2Slots, player1, player2);
                turn(sc, player1Slots, player1, playArea);
                gameOver = checkForWin(player1Slots, player1);
            }
            round++;
        }

        createField(playArea, player1Slots, player2Slots, player1, player2);
    }

    public static void turn(Scanner sc, String[][] playerSlots, String playerName, String[][] playArea) {
        System.out.println(playerName + " ist dran!");

        boolean turnOver = false;
        do {
            int num = sc.nextInt();

            if (num <= 7 && num >= 1) {
                num -= 1;
                for (int i = playArea.length - 1; i >= 0; i--) {
                    if (playArea[i][num] == null) {
                        playArea[i][num] = "X";
                        playerSlots[i][num] = "X";
                        turnOver = true;
                        break;
                    }
                }
            }
        } while (!turnOver);
    }

    public static void createField(String[][] area, String[][] player1, String[][] player2, String user1, String user2) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                System.out.print("[");
                if (Objects.equals(area[i][j], player1[i][j]) && player1[i][j] != null) {
                    System.out.print(user1.charAt(0) + " ");
                } else if (Objects.equals(area[i][j], player2[i][j]) && player2[i][j] != null) {
                    System.out.print(user2.charAt(0) + " ");
                } else {
                    System.out.print("  ");
                }
                System.out.print("]");
            }
            System.out.println();
        }
        System.out.println("[#1][#2][#3][#4][#5][#6][#7]");
    }

    public static String userLogin(Scanner sc) {
        String username = "";

        do {
            username = sc.next();

            if (username.length() < 3 || username.length() > 15) {
                System.out.println("Der Name darf nur min. 3 und max. 15 Zeichen lang sein!");
            }
        } while (username.length() < 3 || username.length() > 15);

        return username;
    }

    public static boolean checkForWin(String[][] playerSlots, String player) {
        if (CheckHorizontal(playerSlots, player) || CheckVertical(playerSlots, player) || CheckDiagonal(playerSlots, player)){
            System.out.println(player + " hat gewonnen!");
            return true;
        }
        return false;
    }

    private static boolean CheckHorizontal(String[][] playerSlots, String player) {
        int neighbours = 0;
        for (int j = playerSlots.length-1; j > -1; j--){
            for (int i = playerSlots.length-1; i > -1; i--) {
                if (playerSlots[i][j] != null){
                    neighbours++;
                } else {
                    neighbours = 0;
                }

                if (neighbours == 4){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean CheckVertical(String[][] playerSlots, String player) {
        int neighbours = 0;
        for (int j = playerSlots.length-1; j > -1; j--){
            for (int i = playerSlots.length-1; i > -1; i--) {
                if (playerSlots[j][i] != null){
                    neighbours++;
                } else {
                    neighbours = 0;
                }

                if (neighbours == 4){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean CheckDiagonal(String[][] playerSlots, String player) {
        for (int j = playerSlots.length - 1; j >= 3; j--) {
            for (int i = playerSlots[j].length - 1; i >= 3; i--) {
                if (playerSlots[j][i] != null &&
                        playerSlots[j - 1][i - 1] != null &&
                        playerSlots[j - 2][i - 2] != null &&
                        playerSlots[j - 3][i - 3] != null) {
                    return true;
                }
            }
        }
        for (int j = playerSlots.length - 1; j >= 3; j--) {
            for (int i = 0; i <= playerSlots[j].length - 4; i++) {
                if (playerSlots[j][i] != null &&
                        playerSlots[j - 1][i + 1] != null &&
                        playerSlots[j - 2][i + 2] != null &&
                        playerSlots[j - 3][i + 3] != null) {
                    return true;
                }
            }
        }
        return false;
    }

}