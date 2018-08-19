/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.demo;

/** This is just a sample. */
public class A {

  /** Test {@code ClassNotFoundException} and {@code ArithmeticException}. */
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

  /** Fire the {@link #test test}. */
  public static void main(String[] args) {
    A a = new A();
    a.test();
  }
}
