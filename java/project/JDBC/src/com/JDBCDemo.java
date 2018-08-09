package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {
  public Connection getConnection() {
    Connection conn = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/jd?useSSL=false&serverTimetone=UTC";
      String user = "root";
      String password = "root";
      conn = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      //e.printStackTrace();
      System.out.println("Database Driver Error");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return conn;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    JDBCDemo jdbc = new JDBCDemo();
    Connection conn = jdbc.getConnection();
    System.out.println("conn=" + conn);
  }

}
