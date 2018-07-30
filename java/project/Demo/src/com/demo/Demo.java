package com.demo;

public class Demo {
  static int sum(int a, int b) {
    System.out.println("a=" + a);
    System.out.println("b=" + b);
    return a + b;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int s = sum(5, 6);
    System.out.println("s=" + s);
  }

}
