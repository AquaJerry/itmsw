package com.demo;

public class A {
  public void print() {
    System.out.println("print() in A");
  }
  public static void main(String[] args) {
    B b = new B();
    b.print();
  }

}

class B extends A {

  @Override
  public void print() {
    // TODO Auto-generated method stub
    //super.print();
    System.out.println("print() in B");
  }

}
