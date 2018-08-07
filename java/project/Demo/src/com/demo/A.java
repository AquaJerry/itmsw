package com.demo;

public class A {
  public void test() {
    try {
      System.out.println(5/1);
    } catch (ArithmeticException e) {
      System.out.println("Divide-by-zero Error");
    }
  }
  public static void main(String[] args) {
    A a = new A();
    a.test();
  }
}
