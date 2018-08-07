package com.demo;

public class A {
  private static B b = new B();

  public A() {
    System.out.println("A()");
  }

  public static void sayHello() {
    System.out.println("hello");
  }

  public static void main(String[] args) {
    System.out.println(A.b);
    /*A a1 = new A();
    System.out.println(a1);
    A a2 = new A();
    System.out.println(a2);
    System.out.println(a1 == a2);
    System.out.println("a1.b=" + a1.b);
    System.out.println("a2.b=" + a2.b);
    System.out.println("b=" + A.b);
    System.out.println(a1.b == a2.b);
    A.sayHello();
    sayHello();
    System.out.println(b);*/
  }
}
