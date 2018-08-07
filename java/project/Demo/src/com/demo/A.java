package com.demo;

public class A {
  String userName;
  int age;



  public A() {
    System.out.println("A()");
  }


  public A(String userName) {
    this.userName = userName;
  }


  public A(String userName, int age) {
    this.userName = userName;
    this.age = age;
  }


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
    A a = new A("tom", 12);
    a.print();
    this.sayHello();
  }

}
