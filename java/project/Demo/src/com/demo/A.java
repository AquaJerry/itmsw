package com.demo;

public class A {
  private final int age = 10;
  private final String name = "tom";
  private final Demo demo = new Demo();
  public void sayHello() {
    System.out.println("hello");
  }
  public static void main(String[] args) {
    A a = new A();
    //a.age = 10;
    //a.name = "andy";
    a.demo = new Demo();
  }

}
