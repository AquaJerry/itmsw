package com.demo;

public class A {
  private void sayHello() {
    System.out.println("hello");
  }

  public void print() {
    sayHello();
  }

  public static void main(String[] args) {
    A a = new A();
    a.print();
  }
}
