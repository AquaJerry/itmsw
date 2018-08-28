/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.demo;

import java.util.Random;

/** This is just a sample. */
public class Demo {

  /** Generate 4-bit validation code. */
  public static void main(String[] args) {
    String vcStr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int vcStrLength = vcStr.length();
    Random random = new Random();
    for (int i = 0; i < 4; ++i) {
      int randomNum = random.nextInt(vcStrLength);
      System.out.print(vcStr.charAt(randomNum));
    }
  }
}
