package ru.khrebtov.lesson1;

public class Main {

  public static void main(String[] args) {
    byte b = 127;
    short s = 324;
    int i = 525;
    long l = 123L;
    float f = 124.5f;
    double d = 124.5;
    char c = 'd';
    boolean bool = true;
  }

  public static float calculate(float a, float b, float c, float d) {
    return a * (b + (c / d));
  }

  public static boolean isInTheLimit(int a, int b) {
    return (a + b) >= 10 && (a + b) <= 20;
  }

  public static void positiveOrNot(int a) {
    if (a >= 0) {
      System.out.println("Было переданно положительное число");
    } else {
      System.out.println("Было переданно отрицательное число");
    }
  }

  //на счет а=0 ситуация не оговоренна,принял ее из задания номер 5
  public static boolean isNegative(int a) {
    return a < 0;
  }

  public static void consoleName(String name) {
    System.out.println("Привет, " + name + "!");
  }

  public static void leapYear(int year) {
    if (year % 400 == 0) {
      System.out.println("Год " + year + " высокосный");
    } else if (year % 4 == 0 && year % 10 != 0) {
      System.out.println("Год " + year + " высокосный");
    } else {
      System.out.println("Год " + year + " не высокосный");
    }
  }
}
