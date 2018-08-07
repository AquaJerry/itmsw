package com.test;

import com.demo.A;

public class B extends A {
  public void print() {
    //A a = new A();
    //a.sayHello();
    sayHello();
  }

  public static void main(String[] args) {
    B b = new B();
    b.print();
    b.sayHello();
  }
}
