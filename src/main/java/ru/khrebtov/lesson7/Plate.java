package ru.khrebtov.lesson7;

public class Plate {

  private int food;

  public Plate(int food) {
    this.food = food;
  }

  public int getFood() {
    return food;
  }

  public void decreaseFood(int n) {
    food -= n;
  }

  public void info() {
    System.out.println("plate: " + food);
  }

  public void addFood(int food) {
    if (food < 0) {
      System.out.println("Мы не можем отобрать еду у котиков");
    }
    this.food += food;
  }
}
