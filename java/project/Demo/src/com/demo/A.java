package com.demo;

public class A {
  public void test() {
    try {
      System.out.println(5/1);
      System.out.println(Class.forName("com.demo.B2"));
    } catch (ArithmeticException e) {
      System.out.println("Divide-by-zero Error");
    } catch (Exception e) {
      System.out.println("Class B2 Not Found");
    } finally {
      System.out.println("You can see me.");
    }
  }
  public static void main(String[] args) {
    A a = new A();
    a.test();
  }
}
