/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.demo;

/** This is just a sample. */
public class Student implements IStudent, ITest {
  public void sayHello() {
    System.out.println("sayHello()");
  }

  @Override
  public void print() {
    // TODO Auto-generated method stub
    System.out.println("print()");
    System.out.println("num=" + num);
  }

  @Override
  public void printName() {
    // TODO Auto-generated method stub
    System.out.println("printName() from ITest");
  }

  public static void main(String[] args) {
    IStudent s = new Student();
    s.print();
    s.sayHello();
  }
}
