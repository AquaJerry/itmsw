/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.jd.maintain.servlet;

import com.jd.common.MD5Encrypt;
import com.jd.maintain.dao.UserInfoDao;
import com.jd.maintain.dto.UserInfoDto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet implementation for Jingdong/Joybuy login page. */
@WebServlet("/maintain/LoginServlet")
public class LoginServlet extends HttpServlet {

  /**
   * Route on login page. Go to success page if correct user name and password are typed, otherwise
   * reload this page.
   *
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String userName = request.getParameter("userName");
    UserInfoDao userInfoDao = new UserInfoDao();
    UserInfoDto userInfoDto = userInfoDao.queryByUserName(userName);
    if (null != userInfoDto) {
      String password = request.getParameter("password");
      byte[] savedHash = userInfoDto.getPassword();
      boolean isPasswordValid = MD5Encrypt.validatePassword(password, savedHash);
      if (isPasswordValid) {
        RequestDispatcher rd = request.getRequestDispatcher("../loginSuccess.jsp");
        rd.forward(request, response);
        return;
      }
    }
    response.sendRedirect("../login.html?flag=loginError");
  }

  /**
   * Do as the same as {@link #doGet doGet}.
   *
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}
