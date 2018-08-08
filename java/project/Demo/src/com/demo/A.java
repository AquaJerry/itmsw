package com.demo;

public class A {
  public void test() throws Exception {

    throw new Exception();

  }

  public static void main(String[] args) throws Exception {
    A a = new A();
    a.test();
  }
}
