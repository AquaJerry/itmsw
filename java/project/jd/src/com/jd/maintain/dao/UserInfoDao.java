/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.jd.maintain.dao;

import com.jd.common.JDBCUtil;
import com.jd.maintain.dto.UserInfoDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Data access object of Jingdong/Joybuy user info. */
public class UserInfoDao {
  private Connection conn;
  private PreparedStatement ps;
  private ResultSet rs;

  /**
   * Query if the user name to be registered is occupied so that the registering fails.
   *
   * @param userName the user name
   * @return the query
   */
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

  /**
   * Try to login.
   *
   * @param userName user name
   * @param password password
   * @return if it is successful
   */
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

  /**
   * Save registering information as a record.
   *
   * @param userInfoDto the information
   */
  public void saveUserInfo(UserInfoDto userInfoDto) {
    conn = JDBCUtil.getConnection();
    try {
      String sql = "insert user_info(user_name,password,phone)value(?,?,?)";
      ps = conn.prepareStatement(sql);
      ps.setString(1, userInfoDto.getUserName());
      ps.setBytes(2, userInfoDto.getPassword());
      ps.setString(3, userInfoDto.getPhone());
      ps.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      JDBCUtil.clear(conn, ps, null);
    }
  }
}
