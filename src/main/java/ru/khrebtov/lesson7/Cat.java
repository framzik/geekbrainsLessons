package ru.khrebtov.lesson7;

public class Cat {

  private String name;
  private int appetite;
  private boolean satiety;

  public Cat(String name, int appetite) {
    this.name = name;
    this.appetite = appetite;
  }

  public String getName() {
    return name;
  }

  public boolean isSatiety() {
    return satiety;
  }

  public void eat(Plate p) {
    if (p.getFood() >= appetite) {
      p.decreaseFood(appetite);
      satiety = true;
    } else {
      System.out.printf("Аппетит котика %s больше еды в тарелке! Он не смог поесть((\n", name);
    }
  }

}
