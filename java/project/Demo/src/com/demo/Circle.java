package com.demo;

public class Circle extends Shape {

  @Override
  public void print() {
    System.out.println("In Circle");
  }

  public static void main(String[] args) {
    // Circle c = new Circle();
    // c.print1(100);
    Shape s = new Shape();
    s.print();
    s = new Circle();
    s.print();
  }
}
