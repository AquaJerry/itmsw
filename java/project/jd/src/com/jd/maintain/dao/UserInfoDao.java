package com.jd.maintain.dao;

import com.jd.common.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoDao {
  public boolean queryByUserName(String userName) {
    Connection conn = JDBCUtil.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
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

  public void saveUserInfo() {
    Connection conn = JDBCUtil.getConnection();
    PreparedStatement ps = null;
    try {
      String sql = "insert user_info(user_name,password,phone)value(?,?,?)";
      ps = conn.prepareStatement(sql);
      ps.setString(1, "用户999");
      ps.setString(2, "333***");
      ps.setString(3, "13712345678");
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
    userInfoDao.saveUserInfo();
  }
}
