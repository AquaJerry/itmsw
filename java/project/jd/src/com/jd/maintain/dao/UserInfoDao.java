package com.jd.maintain.dao;

import com.jd.common.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoDao {
  private Connection conn;
  private PreparedStatement ps;
  private ResultSet rs;

  public boolean queryByUserName(String userName) {
    conn = JDBCUtil.getConnection();
    boolean flag = false;
    try {
      String sql = "select*from user_info where user_name=?";
      ps = conn.prepareStatement(sql);
      ps.setString(1, userName);
      rs = ps.executeQuery();
      if (rs.next()) {
        flag = true;
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      JDBCUtil.clear(conn, ps, rs);
    }
    return flag;
  }

  public void saveUserInfo(String userName, String password, String phone) {
    conn = JDBCUtil.getConnection();
    try {
      String sql = "insert user_info(user_name,password,phone)value(?,?,?)";
      ps = conn.prepareStatement(sql);
      ps.setString(1, userName);
      ps.setString(2, password);
      ps.setString(3, phone);
      ps.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      JDBCUtil.clear(conn, ps, null);
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    UserInfoDao userInfoDao = new UserInfoDao();
    boolean flag = userInfoDao.queryByUserName("user0xx");
    System.out.println("flag=" + flag);
    userInfoDao.saveUserInfo("user005", "aaa555", "13512341234");
  }
}
