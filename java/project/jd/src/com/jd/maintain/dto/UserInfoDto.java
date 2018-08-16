/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.jd.maintain.dto;

/** Data transfer object for Jingdong/Joybuy user register/login. */
public class UserInfoDto {
  private int id;
  private String userName;
  private String password;
  private String phone;

  /** Initializes minimally required information of a user in register/login. */
  public UserInfoDto() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Initializes required information of a user in register/login from arguments.
   *
   * @param id an integer for database management, which should not be manually set
   * @param userName user name
   * @param password password
   * @param phone phone number
   */
  public UserInfoDto(int id, String userName, String password, String phone) {
    super();
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.phone = phone;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
