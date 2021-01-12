package ru.khrebtov.lesson5;

public class Main {

  public static void main(String[] args) {
    Person[] people = new Person[5];
    people[0] = new Person("Бердянский Николай Иванович", "Инженер", "892312312", "", 30000,
        30);
    people[1] = new Person("Petrov Petr Petrovich", "Director", "dir@ya.ru", "8978989832", 1000000,
        78);
    people[2] = new Person("Ivanov Ivan", "GlavBuh", "gb@ya.ru", "8978989833", 200000,
        55);
    people[3] = new Person("Yuhno Zoya", "Buhgalter", "buh@ya.ru", "8978989834", 50000,
        25);
    people[4] = new Person("Nedosekin Evgeniy", "Zam directora", "zam_dir@ya.ru", "8978989835",
        350000,
        41);
    for (Person p : people) {
      if (p.getAge() > 40) {
        p.printInfo();
      }
    }
  }
}
