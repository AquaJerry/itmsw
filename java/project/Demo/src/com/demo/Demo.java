package com.demo;

public class Demo {
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    byte b = 65;
    short s = b;
    //char c = b;
    char c = '中';
    s = (short)c;
    c = (char)s;
    int i = c;
    i = s;
    long l = i;
    float f = l;
    double d = f;
    f = (float)d;
    int num = 65;
    char ch = (char)num;

    double d2 = 5.123456789;
    System.out.println("d2=" + d2);
  }

}
