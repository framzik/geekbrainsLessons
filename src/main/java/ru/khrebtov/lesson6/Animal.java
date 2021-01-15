package ru.khrebtov.lesson6;


public class Animal {

  private String name;
  private static int countAnimal = 0;

  public Animal(String name) {
    this.name = name;
    countAnimal++;
  }

  public int getCountAnimal() {
    return countAnimal;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void run(int length) {

    System.out.printf("%s %s пробежал %s м.\n", kindOfAnimal(this), name, length);
  }

  public void swim(int length) {
    System.out.printf("%s %s проплыл %s м.\n", kindOfAnimal(this), name, length);
  }

  private String kindOfAnimal(Animal animal) {
    String kindOfAnimal = "";
    if (this instanceof Cat) {
      kindOfAnimal = "Кот";
    }
    if (this instanceof Dog) {
      kindOfAnimal = "Пёс";
    }
    return kindOfAnimal;
  }
}
