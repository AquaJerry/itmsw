package com.demo;

public class Demo {

  public static void main(String[] args) {
    int sum = 0;
    /*for (int i = 100; i >= 1; i--) {
      sum = sum + i;
    }
    System.out.println("sum=" + sum);*/
    int i = 1;
    while (i <= 10) {
      if (i < 5) {
        break;
      }
      System.out.println("i=" + i);
      i++;
    }

    /*int i = 11;
    do {
      System.out.println("i=" + i);
      i++;
    } while (i <= 10);*/



  }

}
