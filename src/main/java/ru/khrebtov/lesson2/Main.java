package ru.khrebtov.lesson2;

public class Main {

  public static void main(String[] args) {
    //#1
    int[] its = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    swap(its);
    System.out.print("Первое задание проверка результата: ");
    printArray(its);

    //#2
    int[] array = new int[8];
    arrayEight(array);
    System.out.print("Второе задание проверка результата: ");
    printArray(array);

    //3
    int[] task3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    arrayX2(task3);
    System.out.print("Третье задание проверка результата: ");
    printArray(task3);

    //4
    int sideQuantity = 7;
    int[][] squareArray = squareArray(sideQuantity);
    System.out.println("Четвертое задание проверка результата: ");
    printArray2X2(squareArray, sideQuantity);

    //5
    System.out.print("Пятое задание проверка результата: ");
    maksAndMinValue(new int[]{1, 2, 3, 4, 8, -225, 12, 0, 0, 1, 0, 1, 0, 1,});

    //6
    System.out.print("Шестое задание проверка результата: ");
    int[] equality = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
    System.out.println(isEquality(equality));

    //7
    System.out.println("Седьмое задание проверка результата: ");
    int[] arrMove = new int[]{6, 1, 3, 5};
    printArray(arrMove);
    int n = 4;
    System.out.println("n = " + n);
    printArray(moveElements(arrMove, n));

  }

  public static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
    }
    System.out.println();
  }

  public static void printArray2X2(int[][] array, int sideQuantity) {
    for (int i = 0; i < sideQuantity; i++) {
      for (int y = 0; y < sideQuantity; y++) {
        System.out.print(" " + array[i][y] + " ");
      }
      System.out.println();
    }
  }

  public static void swap(int[] its) {
    for (int i = 0; i < its.length; i++) {
      int temporary = its[i];
      if (temporary == 1) {
        its[i] = 0;
      } else {
        its[i] = 1;
      }
    }
  }

  public static void arrayEight(int[] array) {
    array[0] = 0;
    for (int i = 1; i < array.length; i++) {
      array[i] = array[i - 1] + 3;
    }
  }

  public static void arrayX2(int[] task3) {
    for (int i = 0; i < task3.length; i++) {
      if (task3[i] < 6) {
        task3[i] *= 2;
      }
    }
  }

  public static int[][] squareArray(int sideQuantity) {
    int[][] squareArray = new int[sideQuantity][sideQuantity];
    for (int i = 0; i < sideQuantity; i++) {
      for (int y = 0; y < sideQuantity; y++) {
        if (i == y) {
          squareArray[i][y] = 1;
        }
      }
    }
    return squareArray;
  }

  public static void maksAndMinValue(int[] array) {
    System.out.print("Максимальное значие в массиве: " + maksValue(array) + ". Минимальное"
        + " значие в массиве: " + minValue(array) + ".");
    System.out.println();
  }

  public static int maksValue(int[] array) {
    int max = -2147483648;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    return max;
  }

  public static int minValue(int[] array) {
    int min = 2147483647;
    for (int i = 0; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }
    return min;
  }

  public static boolean isEquality(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int removal = sumLeft(array, i) - sumRight(array, i);
      if (removal == 0) {
        return true;
      }
    }
    return false;
  }

  public static int sumLeft(int[] arr, int index) {
    int leftSum = 0;
    for (int i = 0; i <= index; i++) {
      leftSum += arr[i];
    }
    return leftSum;
  }

  public static int sumRight(int[] arr, int index) {
    int rightSum = 0;
    for (int i = arr.length - 1; i > index; i--) {
      rightSum += arr[i];
    }
    return rightSum;
  }

  public static int[] moveElements(int[] arr, int n) {
    if (n > 0) {
      for (int i = 0; i < n; i++) {
        int vault = arr[arr.length - 1];
        for (int j = arr.length - 1; j > 0; j--) {
          arr[j] = arr[j - 1];
        }
        arr[0] = vault;
      }
    }
    if (n < 0) {
      for (int i = 0; i > n; i--) {
        int vault = arr[0];
        for (int j = 0; j < arr.length - 1; j++) {
          arr[j] = arr[j + 1];
        }
        arr[arr.length - 1] = vault;
      }
    }
    return arr;
  }
}
