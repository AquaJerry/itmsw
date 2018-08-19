/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.demo;

import java.io.File;

/** This is just a sample. */
public class Demo {

  /** Use Java File Object. */
  public static void main(String[] args) {
    File file = new File(".");
    System.out.println("Name\t" + file.getName());
    System.out.println("Path\t" + file.getPath());
    System.out.println("Exist\t" + file.exists());
    System.out.println("Size\t" + file.length());
    if (file.isDirectory()) {
      System.out.println("List");
      String[] str = file.list();
      for (String s : str) {
        System.out.println("\t" + s);
      }
    }
  }
}
