/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Connector to Jingdong/Joybuy MySQL database. */
public class JDBCDemo {
  public static final int ID = 4;
  public static final String PASSWORD = "333***";
  public static final String PHONE = "13712345678";
  public static final String USERNAME = "用户0010";

  /**
   * Get a Jd database connection with root user.
   *
   * @return the Jd database connection
   */
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

  /**
   * Insert below record into user info table in Jd database.
   *
   * <pre>
   *   User Name {@value USERNAME}
   *   Password  {@value PASSWORD}
   *   Phone     {@value PHONE}
   * </pre>
   */
  public void saveUser() {
    Connection conn = getConnection();
    PreparedStatement ps = null;
    try {
      String sql = "insert user_info(user_name,password,phone)value(?,?,?)";
      ps = conn.prepareStatement(sql);
      ps.setString(1, USERNAME);
      ps.setString(2, PASSWORD);
      ps.setString(3, PHONE);
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

  /** Print info of the user whose id is {@value ID}. */
  public void queryUser() {
    Connection conn = getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      String sql = "select*from user_info where id=?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, ID);
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

  /** Test {@linkplain #queryUser() printing user info}. */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    JDBCDemo jdbc = new JDBCDemo();
    jdbc.queryUser();
  }
}
