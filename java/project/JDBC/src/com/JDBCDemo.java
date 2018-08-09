package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/jd?useSSL=false";
      String user = "root";
      String password = "root";
      Connection conn = DriverManager.getConnection(url, user, password);
      System.out.println("conn=" + conn);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      //e.printStackTrace();
      System.out.println("Database Driver Error");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
