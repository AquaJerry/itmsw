package com.demo;

public class A {
  public void test() {
    try {
      System.out.println(5/1);
      System.out.println(Class.forName("com.demo.B"));
    } catch (ArithmeticException e) {
      System.out.println("Divide-by-zero Error");
    } catch (ClassNotFoundException e) {
      System.out.println("Class B Not Found");
    } finally {
      System.out.println("You can see me.");
    }
  }
  public static void main(String[] args) {
    A a = new A();
    a.test();
  }
}
