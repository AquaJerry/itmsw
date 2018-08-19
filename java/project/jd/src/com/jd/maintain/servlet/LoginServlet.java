/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.jd.maintain.servlet;

import com.jd.maintain.dao.UserInfoDao;
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
    String password = request.getParameter("password");
    UserInfoDao userInfoDao = new UserInfoDao();
    boolean flag = userInfoDao.queryUserInfo(userName, password);
    if (flag) {
      RequestDispatcher rd = request.getRequestDispatcher("../loginSuccess.jsp");
      rd.forward(request, response);
    } else {
      response.sendRedirect("../login.html?flag=loginError");
    }
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
