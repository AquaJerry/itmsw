/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.demo;

/** This is just a sample. */
public class Demo {

  /** Use Java array. */
  public static void main(String[] args) {
    // int[] num = new int[3];
    String[] str = new String[4];

    int[] num = new int[] {3, 5, 6}; // int[] num = {3, 5, 6};
    // String[] str = new String[] {"tom", "andy"};

    str[0] = "tom";
    str[1] = "andy";
    str[2] = "张三";
    str[3] = "李四";

    System.out.println(str.length);
    System.out.println(num.length);
    System.out.println(str[2]);
    for (int i = 0; i < str.length; ++i) {
      System.out.println("str[" + i + "]=" + str[i]);
    }

    String[][] names = {{"张三", "李四", "王五"}, {"u01", "u02", "u03"}};
    System.out.println(names[1][2]);
  }
}
