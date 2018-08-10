package com.demo;

public class A {
  public void test() {
    try {
      System.out.println(5 / 0);
      System.out.println(Class.forName("com.demo.B2"));
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ArithmeticException e) {
      System.out.println("Divide-by-zero Error");
    }
  }

  public static void main(String[] args) {
    A a = new A();
    a.test();
  }
}
