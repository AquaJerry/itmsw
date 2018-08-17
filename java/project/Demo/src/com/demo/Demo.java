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
  }
}
