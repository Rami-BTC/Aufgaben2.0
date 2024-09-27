package com.btcag.bootcamp;

import java.util.Objects;
import java.util.Scanner;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||
// Warum die ganzen Kommentare? : Damit ich das Programm notfalls erklären kann, ohne Vorbereitung :)   ||
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||

public class Connect4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] playArea = new String[6][7];

        String player1 = userLogin(sc, 1);
        String[][] player1Slots = new String[6][7];

        String player2 = userLogin(sc, 2);
        String[][] player2Slots = new String[6][7];

        //Ja, ich hätte auch nur ein Array machen können, aber das Leben ist nun mal schwierig :'(

        gameLoop(playArea, player1Slots, player2Slots, player1, player2, sc);
    }

    public static String userLogin(Scanner sc, int num) {
        System.out.println("Spieler "+ num +": Bitte gebe einen Namen ein: ");

        String username;
        do {
            username = sc.next();
            if (username.length() < 3 || username.length() > 15) {
                System.out.println("Der Name darf nur min. 3 und max. 15 Zeichen lang sein!");
            }
        } while (username.length() < 3 || username.length() > 15);

        return username;
    }

    public static void createField(String[][] area, String[][] player1, String[][] player2, String user1, String user2) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                System.out.print("[");

                //------Print the Players first Char || Print an empty String-----
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

        //-----Print available numbers/fields------
        System.out.println("[#1][#2][#3][#4][#5][#6][#7]");
    }

    public static void playerTurn(Scanner sc, String[][] playerSlots, String playerName, String[][] playArea) {
        System.out.println(playerName + " ist dran!");

        boolean turnOver = false;
        do {
            int num = sc.nextInt();

            //-----Make sure, the player isn't out of bounce----
            if (num <= 7 && num >= 1) {
                num -= 1;
                for (int i = playArea.length - 1; i >= 0; i--) {

                    //-----Update 'Overall Field Status' && 'Player Slots Status'
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

    private static void gameLoop(String[][] playArea, String[][] player1Slots, String[][] player2Slots, String player1, String player2, Scanner sc) {
        int round = 1;

        boolean gameOver = false;
        while (!gameOver) {
            createField(playArea, player1Slots, player2Slots, player1, player2);
            if (round % 2 == 0) {
                playerTurn(sc, player2Slots, player2, playArea);

                //Check if game is over
                gameOver = checkForWin(player2Slots);

            } else {
                playerTurn(sc, player1Slots, player1, playArea);

                //Check if game is over
                gameOver = checkForWin(player1Slots);
            }
            round++;
        }

        //----Print Final Field && Print Winner
        createField(playArea, player1Slots, player2Slots, player1, player2);
        if (round % 2 == 0) {
            System.out.println(player1 + " hat gewonnen!");
        } else {
            System.out.println(player2 + " hat gewonnen!");

        }
    }

    public static boolean checkForWin(String[][] playerSlots) {
        return checkHorizontal(playerSlots) || checkVertical(playerSlots) || checkDiagonal(playerSlots);
    }

    private static boolean checkHorizontal(String[][] playerSlots) {
        int neighbours = 0;

        //----For each neighbouring disk: neighbours++----
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
            neighbours = 0;
        }
        return false;
    }

    private static boolean checkVertical(String[][] playerSlots) {
        int neighbours = 0;

        //----For each neighbouring disk: neighbours++----
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
            neighbours = 0;
        }
        return false;
    }

    private static boolean checkDiagonal(String[][] playerSlots) {
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
