package com.demo;

public class B {
  public void print() {
    A a = new A();
    a.sayHello();
  }

  public static void main(String[] args) {
    B b = new B();
    b.print();
  }
}
