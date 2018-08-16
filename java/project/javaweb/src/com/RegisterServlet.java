/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet implementation for Jingdong/Joybuy register page. */
@WebServlet("/maintain/RegisterServlet")
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Print request details, render response messages, dispatch to another location.
   *
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    request.setCharacterEncoding("utf-8");
    System.out.println("userName=" + request.getParameter("userName"));
    System.out.println("method=" + request.getMethod());
    System.out.println("queryString=" + request.getQueryString());
    System.out.println("uri=" + request.getRequestURI());
    System.out.println("url=" + request.getRequestURL());
    // response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    out.print("<h1 style='color:red' onclick='alert(100)'>Hello中国</h1>");
    // response.sendRedirect("/javaweb/NewFile.jsp");
    RequestDispatcher rd = request.getRequestDispatcher("/NewFile.jsp");
    rd.forward(request, response);
  }

  /**
   * Do as the same as {@linkplain #doGet doGet}.
   *
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}
