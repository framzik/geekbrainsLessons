package ru.khrebtov.lesson3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner mainScanner = new Scanner(System.in);
    System.out.println("Выберите игру: \n1 – Угадай число \n2 – Слова");
    int gameSelection;
    try {
      do {
        gameSelection = mainScanner.nextInt();
        if (gameSelection == 1) {
          guessTheNumber();
        } else if (gameSelection == 2) {
          guessTheWord();
        } else {
          System.out.println("Варианты: либо 1, либо 2!");
        }
      } while (gameSelection < 1 || gameSelection > 2);

    } catch (
        InputMismatchException e) {
      System.out.println("Вы ввели не число, перезапустите игру!");
    }
    mainScanner.close();
  }

  public static void guessTheNumber() {
    int range = 9;
    int number = (int) (Math.random() * range);
    int tryNumber = 0;
    int numberOfAttempts = 3;
    String delimiter = "*******************************************";
    Scanner scannerNumber = new Scanner(System.in);
    System.out.printf("Я, ИИ-Вася, загадал число от 0 до %s, попробуй угадать! У Вас %s попытки \n",
        range, numberOfAttempts);
    while (true) {
      int version = -1;
      try {
        do {
          version = scannerNumber.nextInt();
          if (version < 0 || version > 9) {
            System.out.printf("Я загадал число от 0 до %s. Будьтье внимательны! \n", range);
          }
        } while (version < 0 || version > 9);
      } catch (InputMismatchException e) {
        System.out.println("Вы ввели не число, игра будет перезапущенна!");
        System.out.println(delimiter);
        guessTheNumber();
      }
      if (version == number) {
        System.out.println("Вы угадали!:)");
        break;
      } else if (version < number) {
        tryNumber++;
        System.out.println("Загаданное число больше");
      } else {
        tryNumber++;
        System.out.println("Загаданное число меньше");
      }
      if (tryNumber == numberOfAttempts) {
        System.out.println("Вы проиграли!:(");
        break;
      }
    }
    System.out.println(delimiter);
    System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
    try {
      int reNewGame = scannerNumber.nextInt();
      if (reNewGame == 1) {
        guessTheNumber();
      }
    } catch (InputMismatchException e) {
      System.out.println("Вы ввели не число, игра будет перезапущенна!");
      System.out.println(delimiter);
      guessTheNumber();
    }
    scannerNumber.close();
  }

  public static void guessTheWord() {
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
        "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
        "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    int index = (int) (Math.random() * (words.length - 1));
    String word = words[index];
    System.out.println(
        "Угадайте слово! Варианты : \"apple\", \"orange\", \"lemon\", \"banana\", \"apricot\", \"avocado\", \"broccoli\",\n"
            + "        \"carrot\", \"cherry\", \"garlic\", \"grape\", \"melon\", \"leak\", \"kiwi\", \"mango\", \"mushroom\", \"nut\",\n"
            + "        \"olive\", \"pea\", \"peanut\", \"pear\", \"pepper\", \"pineapple\", \"pumpkin\", \"potato\"");

    Scanner scannerWords = new Scanner(System.in);
    boolean isLose = true;
    String version = "";
    while (isLose) {
      version = scannerWords.nextLine();
      if (word.equals(version)) {
        System.out.println("Правильно!");
        isLose = false;
      }
      if (version.equals("exit")) {
        isLose = false;
      } else {
        char[] wordByCharacter = word.toCharArray();
        char[] versionByCharacter = version.toCharArray();
        int minArrayLength =
            wordByCharacter.length < versionByCharacter.length ? wordByCharacter.length
                : versionByCharacter.length;
        String help = "";

        //Определяю совпадающие позиции варианта и загаданного слова.
        for (int i = 0; i < minArrayLength; i++) {
          if (wordByCharacter[i] == versionByCharacter[i]) {
            help += versionByCharacter[i];
          } else {
            help += "#";
          }
        }

        //Добавляю # до 15 символов.
        if (help.length() < 15) {
          int quantity = 15 - help.length();
          for (int i = 0; i < quantity; i++) {
            help += "#";
          }
        }

        System.out.println(help);
      }
    }
    System.out.println("*************************");
    System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
    try {
      int reNewGame = scannerWords.nextInt();
      if (reNewGame == 1) {
        guessTheNumber();
      }
    } catch (InputMismatchException e) {
      System.out.println("Вы ввели не число, игра будет перезапущенна!");
      System.out.println("***************************");
      guessTheWord();
    }

    scannerWords.close();
  }

}
