package com.demo;

public class Demo {

  public static void main(String[] args) {
    int grade = 61;
    if (grade >= 0 && grade < 60) {
      System.out.println("grade=" + grade + "Failed");
    } else if (grade >= 60 && grade < 70) {
      System.out.println("grade=" + grade + "Passed");
    }

  }

}
