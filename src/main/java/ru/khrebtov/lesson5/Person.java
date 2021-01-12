package ru.khrebtov.lesson5;

public class Person {

  //ФИО
  private String fullName;
  //Должность
  private String position;
  //Email
  private String email;
  //Телефон
  private String phone;
  //Зарплата
  private int salary;
  //Возраст
  private int age;

  public Person(String fullName, String position, String email, String phone, int salary,
      int age) {
    this.fullName = fullName;
    this.position = position;
    this.email = email;
    this.phone = phone;
    this.salary = salary;
    this.age = age;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void printInfo() {
    System.out.println("Full name: " + fullName);
    System.out.println("Position: " + position);
    System.out.println("Email: " + email);
    System.out.println("Phone: " + phone);
    System.out.println("Salary: " + salary);
    System.out.println("Age: " + age);
    System.out.println();
  }


}
