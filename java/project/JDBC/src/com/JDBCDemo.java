package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
      // e.printStackTrace();
      System.out.println("Database Driver Error");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return conn;
  }

  public void saveUser() {
    Connection conn = getConnection();
    PreparedStatement ps = null;
    try {
      String sql = "insert user_info(user_name,password,phone)value(?,?,?)";
      ps = conn.prepareStatement(sql);
      ps.setString(1, "用户0010");
      ps.setString(2, "333***");
      ps.setString(3, "13712345678");
      ps.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      if (ps != null) {
        try {
          ps.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }

  public void queryUser() {
    Connection conn = getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      String sql = "select * from user_info";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      System.out.println("id\tuser_name\tpassword\tphone");
      while (rs.next()) {
        System.out.println(
            rs.getInt("id")
                + "\t"
                + rs.getString("user_name")
                + "\t"
                + rs.getString("password")
                + "\t"
                + rs.getString("phone"));
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (ps != null) {
        try {
          ps.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    JDBCDemo jdbc = new JDBCDemo();
    jdbc.queryUser();
  }
}
