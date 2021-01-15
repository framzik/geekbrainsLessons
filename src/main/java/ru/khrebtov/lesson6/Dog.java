package ru.khrebtov.lesson6;

public class Dog extends Animal {

  private static int countDog = 0;

  public Dog(String name) {
    super(name);
    countDog++;
  }

  public int getCountDog() {
    return countDog;
  }

  @Override
  public void run(int length) {
    if (length > 500) {
      length = 500;
    }
    super.run(length);
  }

  @Override
  public void swim(int length) {
    if (length > 10) {
      length = 10;
    }
    super.swim(length);
  }
}
