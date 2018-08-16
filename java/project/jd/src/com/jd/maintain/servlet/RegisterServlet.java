/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.jd.maintain.servlet;

import com.jd.maintain.dao.UserInfoDao;
import com.jd.maintain.dto.UserInfoDto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet implementation for Jingdong/Joybuy register page. */
@WebServlet("/maintain/RegisterServlet")
public class RegisterServlet extends HttpServlet {

  /**
   * Manage register request and route to a new page. In database save register information if user
   * name of which is not occupied.
   *
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String userName = request.getParameter("userName");
    UserInfoDao userInfoDao = new UserInfoDao();
    String baseName = null;
    if (userInfoDao.queryByUserName(userName)) {
      baseName = "alreadyRegister";
    } else {
      String password = request.getParameter("password");
      String phone = request.getParameter("phone");
      UserInfoDto userInfoDto = new UserInfoDto(/*id*/ 0, userName, password, phone);
      userInfoDao.saveUserInfo(userInfoDto);
      baseName = "registerSuccess";
    }
    RequestDispatcher rd = request.getRequestDispatcher("../" + baseName + ".jsp");
    rd.forward(request, response);
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
