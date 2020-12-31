package ru.khrebtov.lesson4;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    private static final String DOT_EMPTY = ".";
    private static final String DOT_X = "X";
    private static final String DOT_O = "O";
    private static String[][] map;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWinByLoop(DOT_X)) {
                System.out.println("Выиграл человек!");
                break;
            }
            if (checkFullMap()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWinByLoop(DOT_O)) {
                System.out.println("Выиграл ИИ!");
                break;
            }
            if (checkFullMap()) {
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Конец игры!");
    }


    private static boolean checkFullMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j].equals(DOT_EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWinByLoop(String dot) {
        return chekRows(dot) | chekColumn(dot) | chekDiagonal(dot);
    }

    //Диагональ
    public static boolean chekDiagonal(String dot) {
        int countDot = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (map[i][j].equals(dot)) {
                        countDot++;
                        if (countDot == DOTS_TO_WIN) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    //Строки
    public static boolean chekRows(String dot) {
        int countDot = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j].equals(dot)) {
                    countDot++;
                    if (countDot == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
            countDot = 0;
        }
        return false;
    }

    //Столбцы
    public static boolean chekColumn(String dot) {
        int countDot = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i].equals(dot)) {
                    countDot++;
                    if (countDot == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
            countDot = 0;
        }
        return false;
    }

    private static boolean checkWin(String dot) {
        //Строки
        if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) return true;
        if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
        if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) return true;
        //Столбцы
        if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) return true;
        if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) return true;
        if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) return true;
        //Диагонали
        if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) return true;
        if (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot) return true;

        return false;
    }

    private static void aiTurn() {
        int x = -1;
        int y = -1;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    private static void humanTurn() {
        int x = -1;
        int y = -1;
        do {
            try {
                System.out.println("Введите Х и У:");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Вы ввели не число!");
                scanner = new Scanner(System.in);
            }
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initMap() {
        map = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

}
