package com.demo;

public class A {
  public void test() {
    try {
      throw new Exception();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      //e.printStackTrace();
      System.out.println("Oops! Something goes wrong.");
    }
  }

  public static void main(String[] args) {
    A a = new A();
    a.test();
  }
}
