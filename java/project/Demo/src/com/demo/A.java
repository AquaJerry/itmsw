package com.demo;

public class A {
  public void sayHello() {
    System.out.println("hello");
  }

  public void print() {
    this.sayHello();
  }

  public static void main(String[] args) {
    A a = new A();
    a.print();
    a.sayHello();
  }
}
