package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet implementation class TestServlet */
@WebServlet("/maintain/RegisterServlet")
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
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
    RequestDispatcher rd = request.getRequestDispatcher("/javaweb/NewFile.jsp");
    rd.forward(request, response);
  }

  /** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}
