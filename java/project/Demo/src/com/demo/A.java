package com.demo;

public class A {
  String userName;
  public A(String userName) {
    this.userName = userName;
    System.out.println("userName=" + userName);
  }
  public A() {

    System.out.println("A()");
    // TODO Auto-generated constructor stub
  }
  public void print() {
    System.out.println("print() in A");
  }
  public void sayHello() {
    System.out.println("sayHello() in A");
  }
  public static void main(String[] args) {
    B b = new B();
    b.print();
  }

}

class B extends A {

  public B() {
    super("tom");
    System.out.println("B()");
    // TODO Auto-generated constructor stub
  }

  @Override
  public void print() {
    // TODO Auto-generated method stub
    super.sayHello();
    System.out.println("print() in B");
  }

  public void sayHello() {
    System.out.println("sayHello() in B");
  }
}
