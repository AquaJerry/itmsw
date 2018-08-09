package com.demo;

public class Demo {

  public static void main(String[] args) {
    int grade = 91;
    if (grade >= 0 && grade < 60) {
      System.out.println("grade=" + grade + "Failed");
    } else if (grade >= 60 && grade < 70) {
      System.out.println("grade=" + grade + "Passed");
    } else if (grade >= 70 && grade < 90) {
      System.out.println("grade=" + grade + "Good");
    } else if (grade >= 90 && grade <= 100) {
      System.out.println("grade=" + grade + "Excellent");
    } else {
      System.out.println("The grade is illegal.");
    }

  }

}
