package com.demo;

public class Demo {
  static void sum(int a, float b) {
    System.out.println("a=" + a);
    System.out.println("b=" + b);
    //return a + b;
    System.out.println(a + "+" + b + "=" + (a+b));
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    sum(5, (float)6.5d);
    //System.out.println("s=" + s);
  }

}
