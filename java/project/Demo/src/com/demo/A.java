package com.demo;

public class A {
  private final int age = 10;
  private final String name = "tom";
  private final Demo demo = new Demo();
  public void sayHello() {
    final int num = 10;
    System.out.println("num=" + num);
    num = 20;
    System.out.println("hello");
  }
  public static void main(String[] args) {
    A a = new A();
    a.sayHello();
    //a.age = 10;
    //a.name = "andy";
    //a.demo = new Demo();
  }

}
