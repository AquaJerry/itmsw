package com.demo;

public class A {
  public void test() {
    System.out.println(5/0);
  }
  public static void main(String[] args) {
    A a = new A();
    a.test();
  }
}
