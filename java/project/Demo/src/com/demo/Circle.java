/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.demo;

/** This is just a sample. */
public class Circle extends Shape {

  @Override
  public void print() {
    System.out.println("In Circle");
  }

  /** Print something. */
  public static void main(String[] args) {
    // Circle c = new Circle();
    // c.print1(100);
    Shape s = new Shape();
    s.print();
    s = new Circle();
    s.print();
  }
}
