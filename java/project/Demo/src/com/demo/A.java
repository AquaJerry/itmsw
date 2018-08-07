package com.demo;

public class A {
  private void sayHello() {
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

class B {
  public void print() {
    A a = new A();
    //a.sayHello();
  }
}
