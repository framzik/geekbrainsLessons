package ru.khrebtov.lesson4;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    private static final String DOT_EMPTY = ".";
    private static final String DOT_X = "X";
    private static final String DOT_O = "O";
    private static String[][] map;
    private static Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

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
        scanner.close();
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
        for (int i = 0; i < SIZE - DOTS_TO_WIN + 1; i++) {
            for (int j = 0; j < SIZE - DOTS_TO_WIN + 1; j++) {
                if (checkDiagonal(dot, i, j) | chekColumn(dot, i, j) | chekRows(dot, i, j)) return true;
            }
        }
        return false;
    }

    //Диагональ
    public static boolean checkDiagonal(String dot, int offsetX, int offsetY) {
        int countDot = 0;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[i + offsetX][i + offsetY].equals(dot)) {
                countDot++;
                if (countDot == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        countDot = 0;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            for (int j = 0; j < DOTS_TO_WIN; j++) {
                if (j == DOTS_TO_WIN - i - 1) {
                    if (map[i + offsetX][j + offsetY].equals(dot)) {
                        countDot++;
                    }
                    if (countDot == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Строки
    public static boolean chekRows(String dot, int offsetX, int offsetY) {
        int countDot = 0;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            for (int j = 0; j < DOTS_TO_WIN; j++) {
                if (map[i + offsetX][j + offsetY].equals(dot)) {
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
    public static boolean chekColumn(String dot, int offsetX, int offsetY) {
        int countDot = 0;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            for (int j = 0; j < DOTS_TO_WIN; j++) {
                if (map[j + offsetY][i + offsetX].equals(dot)) {
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
        if (map[y][x].equals(DOT_EMPTY)) {
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
