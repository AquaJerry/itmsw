package com.demo;

public class A {
  /*public void sum(int a, int b) {
    System.out.println("int a+b=" + (a+b));
  }*/

  public void sum(int a, int b, int c) {
    System.out.println("int a+b+c=" + (a+b+c));
  }

  public void sum(float a, float b) {
    System.out.println("float a+b=" + (a+b));
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    A a = new A();
    a.sum(5, 6);
    a.sum(5.6f, 6.1f);
    a.sum(3, 4, 5);
  }

}
