package com.jd.maintain.dao;

import com.jd.common.JDBCUtil;
import com.jd.maintain.dto.UserInfoDto;
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

  public boolean queryUserInfo(String userName, String password) {
    conn = JDBCUtil.getConnection();
    boolean flag = false;
    try {
      String sql = "select*from user_info where user_name=?&&password=?";
      ps = conn.prepareStatement(sql);
      ps.setString(1, userName);
      ps.setString(2, password);
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

  public void saveUserInfo(UserInfoDto userInfoDto) {
    conn = JDBCUtil.getConnection();
    try {
      String sql = "insert user_info(user_name,password,phone)value(?,?,?)";
      ps = conn.prepareStatement(sql);
      ps.setString(1, userInfoDto.getUserName());
      ps.setString(2, userInfoDto.getPassword());
      ps.setString(3, userInfoDto.getPhone());
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
    boolean flag = userInfoDao.queryByUserName("用户009");
    System.out.println("flag=" + flag);
  }
}
