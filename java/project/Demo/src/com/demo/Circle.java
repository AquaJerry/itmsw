package com.demo;

public class Circle extends Shape {
  public Circle() {
    System.out.println("Child class");
  }

  public static void main(String[] args) {
    //Shape s = new Shape();
    Circle c = new Circle();
  }
}
