package com.demo;

public class Circle extends Shape {

  @Override
  public String print(String str) {
    System.out.println(str + " in circle");
    return "hello";
  }

  public static void main(String[] args) {
    Circle c = new Circle();
    c.print("tom");
  }
}
