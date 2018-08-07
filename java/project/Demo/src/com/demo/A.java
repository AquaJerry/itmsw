package com.demo;

public class A {
  public void test() {
    try {
      System.out.println(5/0);
    } catch (ArithmeticException e) {
      System.out.println("Divide-by-zero Error");
    } finally {
      System.out.println("You can see me.");
    }
  }
  public static void main(String[] args) {
    A a = new A();
    a.test();
  }
}
