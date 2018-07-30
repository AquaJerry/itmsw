package com.demo;

public class Student {
  String name;
  int age;

  public Student() {
    System.out.println("Student instance created.");
  }

  public Student(String userName) {
    System.out.println("userName=" + userName);
    name = userName;
  }

  public void printName() {
    System.out.println("name=" + name);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String str = new String("hello");
    Student s1 = new Student("tom");
    System.out.println("s1.name=" + s1.name);
    s1.printName();
    Student s2 = new Student("andy");
    s2.printName();
  }

}
