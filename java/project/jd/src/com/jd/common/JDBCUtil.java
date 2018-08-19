/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.jd.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Helper of Jingdong/Joybuy database operation. */
public class JDBCUtil {

  /**
   * Get a database connection.
   *
   * @return the database connection
   */
  public static Connection getConnection() {
    Connection conn = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url =
          "jdbc:mysql://localhost:3306/jd?useSSL=false&serverTimetone=UTC&characterEncoding=utf-8";
      String user = "root";
      String password = "root";
      conn = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
      System.out.println("Database Driver Error");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
      System.out.println("Database Connection Error");
    }
    return conn;
  }

  /**
   * Close in turn result set, prepared statement and/or connection of database operation.
   *
   * @param conn the connection
   * @param ps the prepared statement
   * @param rs the result set
   */
  public static void clear(Connection conn, PreparedStatement ps, ResultSet rs) {
    try {
      if (null != rs) {
        rs.close();
      }
      if (null != ps) {
        ps.close();
      }
      if (null != conn) {
        conn.close();
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
