package ru.khrebtov.lesson6;


public class Main {

  public static void main(String[] args) {
    Cat vaska = new Cat("Васька");
    Dog rolf = new Dog("Рольф");
    Dog lord = new Dog("Лорд");
    Cat petka = new Cat("Петька");
    Animal someAnimal = new Animal("Мирон");

    vaska.run(300);
    vaska.swim(20);
    System.out.println();
    rolf.run(420);
    rolf.swim(20);

    System.out
        .printf("\nБыло создано %s животных. Из них %s кота и %s собаки.\n",
            someAnimal.getCountAnimal(),
            vaska.getCountCat(), rolf.getCountDog());
  }
}
