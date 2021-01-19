package ru.khrebtov.lesson7;


public class Main {

  public static void main(String[] args) {
    Cat[] cats = new Cat[]{
        new Cat("Barsik", 5),
        new Cat("Vaska", 7),
        new Cat("Petka", 9)};

    Plate plate = new Plate(18);
    plate.info();
    catEat(cats,plate);
    plate.addFood(50);
    plate.info();
    catEat(cats,plate);

  }
   public static void catEat(Cat[] cats,Plate plate){
     for (Cat cat : cats) {
       cat.eat(plate);
       if (cat.isSatiety()) {
         System.out.println(cat.getName() + " покушал. Еды осталось: ");
         plate.info();
         System.out.println(cat.getName() + " сыт.");
       } else {
         System.out.println(cat.getName() + " остался голоден.");
       }
     }
   }
}
