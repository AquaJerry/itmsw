package com.demo;

public class A {

  public static void main(String[] args) {
    A a1 = new A();
    System.out.println(a1);
    A a2 = new A();
    System.out.println(a2);
    System.out.println(a1 == a2);
  }
}
