package com.jd.maintain.dto;

public class UserInfoDto {
  private int id;
  private String userName;
  private String password;
  private String phone;

  public UserInfoDto() {
    super();
    // TODO Auto-generated constructor stub
  }

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

  public static void main(String[] args) {
    UserInfoDto dto = new UserInfoDto();
    dto.setUserName("tom");
    System.out.println(dto.getUserName());
  }
}
