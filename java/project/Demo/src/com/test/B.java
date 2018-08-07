package com.test;

import com.demo.A;

public class B {
  public void print() {
    A a = new A();
    a.sayHello();
    //sayHello();
  }

  public static void main(String[] args) {
    B b = new B();
    b.print();
    //b.sayHello();
    A a = new A();
    a.sayHello();
  }
}
