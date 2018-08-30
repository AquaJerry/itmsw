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
import javax.servlet.http.HttpSession;

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
    String baseName = null;
    String validationCode = request.getParameter("validationCode");
    HttpSession session = request.getSession();
    String correctValidationCode = (String) session.getAttribute("correctValidationCode");
    boolean isValid = correctValidationCode.equalsIgnoreCase(validationCode);
    if (isValid) {
      request.setCharacterEncoding("utf-8");
      String userName = request.getParameter("userName");
      UserInfoDao userInfoDao = new UserInfoDao();
      if (null != userInfoDao.queryByUserName(userName)) {
        baseName = "alreadyRegister";
      } else {
        String password = request.getParameter("password");
        byte[] passwordHash = MD5Encrypt.encryptByMD5(password);
        String phone = request.getParameter("phone");
        UserInfoDto userInfoDto = new UserInfoDto(/*id*/ 0, userName, passwordHash, phone);
        userInfoDao.saveUserInfo(userInfoDto);
        baseName = "registerSuccess";
      }
    } else {
      baseName = "validationCodeError";
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
