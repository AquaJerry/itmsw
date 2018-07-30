package com.demo;

public class Circle extends Shape {
  public Circle() {
    System.out.println("Child class");
  }

  public static void main(String[] args) {
    Circle c = new Circle();
    c.print();
  }
}
