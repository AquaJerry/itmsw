package com.demo;

public class Circle extends Shape {

  public int print1(int str) {
    System.out.println(str + " in circle");
    return 50;
  }

  public static void main(String[] args) {
    Circle c = new Circle();
    c.print1(100);
  }
}
