/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** This is just a sample. */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

  /**
   * Dispatch requests to {@code jsp2.jsp}.
   *
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    String userName = request.getParameter("userName");
    System.out.println("userName=" + userName);
    request.setAttribute("requestAttr", "请求属性");
    HttpSession session = request.getSession();
    session.setAttribute("sessionAttr", "会话属性");
    // request.getRequestDispatcher("jsp2.jsp").forward(request, response);
    response.sendRedirect("jsp2.jsp");
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
