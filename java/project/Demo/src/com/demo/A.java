/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.demo;

/** This is just a sample. */
public abstract class A {

  /** Print something. */
  public abstract void print();

  /** Try to construct an object of type A. */
  public static void main(String[] args) {
    // A a = new A();
    B b = new B();
    b.print();
  }
}
