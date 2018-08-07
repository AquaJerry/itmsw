package com.demo;

public class A {
  private final int age;
  public void sayHello() {
    System.out.println("hello");
  }
  public static void main(String[] args) {
    A a = new A();
    a.age = 10;
  }

}
