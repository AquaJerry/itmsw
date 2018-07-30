package com.demo;

public class Shape {
  public Shape() {
    System.out.println("Parent class");
  }

  public void print() {
    System.out.println("Shape");
  }

  public static void main(String[] args) {
    Shape s = new Shape();
    s.print();
    System.out.println(s.getClass());
  }
}
