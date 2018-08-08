package com.demo;

public class A {
  public void test() throws Exception {

    throw new Exception();

  }

  public static void main(String[] args) {
    A a = new A();
    try {
      a.test();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      //e.printStackTrace();
      System.out.println("Exception Found");
    }
  }
}
