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

    double d2 = 5.123_456_789;
    System.out.println("d2=" + d2);
    float fl = (float)d2;
    System.out.println("fl=" + fl);
    int i2 = (int)d2;
    System.out.println("i2=" + i2);
  }

}
