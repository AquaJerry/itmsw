package com.demo;

public class A {
  String userName;
  int age;

  public void sayHello() {
    System.out.println("Hello");
  }

  public void print() {
    System.out.println("print()");
    this.sayHello();
    System.out.println("userName=" + userName);
    System.out.println("age=" + age);
  }

  public static void main(String[] args) {
    A a = new A();
    a.print();
  }

}
