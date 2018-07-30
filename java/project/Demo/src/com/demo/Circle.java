package com.demo;

public class Circle extends Shape {

  public String print1(int str) {
    System.out.println(str + " in circle");
    return "hello";
  }

  public static void main(String[] args) {
    Circle c = new Circle();
    c.print1(100);
  }
}
