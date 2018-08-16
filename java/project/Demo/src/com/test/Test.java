/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.test;

import com.demo.Shape;
import com.demo.Student;

/** Test {@link Shape} and {@link Student}. */
public class Test {

  /** Fire the test. */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Student s = new Student();
    s.printName("tom");
    Shape shape = new Shape();
    shape.print();
    com.Student s2 = new com.Student();
    s2.sayHello();
  }
}
