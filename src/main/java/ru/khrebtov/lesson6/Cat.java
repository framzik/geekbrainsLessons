package ru.khrebtov.lesson6;

public class Cat extends Animal {

  private static int countCat = 0;

  public Cat(String name) {
    super(name);
    countCat++;
  }

  public int getCountCat() {
    return countCat;
  }

  @Override
  public void run(int length) {
    if (length > 200) {
      length = 200;
    }
    super.run(length);
  }

  @Override
  public void swim(int length) {
    System.out.println("Коты не умеют плавать!");
  }
}
