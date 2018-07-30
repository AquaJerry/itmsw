package com.demo;

public class Demo {
  static void sum(int a, double b) {
    System.out.println("a=" + a);
    System.out.println("b=" + b);
    //return a + b;
    System.out.println(a + "+" + b + "=" + (a+b));
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    sum(5, 6.5f);
    //System.out.println("s=" + s);
  }

}
