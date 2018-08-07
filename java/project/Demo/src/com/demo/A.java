package com.demo;

public class A {
  public void sayHello() {
    System.out.println("Hello");
  }

  public void print() {
    System.out.println("print()");
    this.sayHello();
  }

  public static void main(String[] args) {
    A a = new A();
    a.print();
  }

}
