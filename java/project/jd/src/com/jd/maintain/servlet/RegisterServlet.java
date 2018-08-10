package com.jd.maintain.servlet;

import com.jd.maintain.dao.UserInfoDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet implementation class RegisterServlet */
@WebServlet("/maintain/RegisterServlet")
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /** @see HttpServlet#HttpServlet() */
  public RegisterServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String phone = request.getParameter("phone");
    String validateCode = request.getParameter("validateCode");
    UserInfoDao userInfoDao = new UserInfoDao();
    String baseName = null;
    if (userInfoDao.queryByUserName(userName)) {
      System.out.println("User Already Exists");
      baseName = "alreadyRegister";
    } else {
      userInfoDao.saveUserInfo(userName, password, phone);
      System.out.println("User Information Saved in Database");
      baseName = "registerSuccess";
    }
    RequestDispatcher rd = request.getRequestDispatcher("../" + baseName + ".jsp");
    rd.forward(request, response);
  }

  /** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}
