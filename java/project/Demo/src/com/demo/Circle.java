package com.demo;

public class Circle extends Shape {

  @Override
  public String print1(int str) {
    System.out.println(str + " in circle");
    return "hello";
  }

  public static void main(String[] args) {
    // Circle c = new Circle();
    // c.print1(100);
    Shape s = new Shape();
    s.print1(200);
    s = new Circle();
    s.print1(200);
  }
}
