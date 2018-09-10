/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.jd.common;

import com.jd.maintain.dto.UserInfoDto;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Support personalized dashboards. */
@WebFilter("/manager/*")
public class AuthorityFilter implements Filter {

  /**
   * No operation.
   *
   * @see Filter@destroy()
   */
  public void destroy() {
    // TODO Auto-generated method stub
  }

  /**
   * Go to the dashboard if the user has logged in, otherwise go to the login page.
   *
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpSession session = httpRequest.getSession();
    UserInfoDto userInfoDto = (UserInfoDto) session.getAttribute("userInfoDto");
    if (null != userInfoDto) {
      // pass the request along the filter chain
      chain.doFilter(request, response);
    } else {
      HttpServletResponse httpResponse = (HttpServletResponse) response;
      httpResponse.sendRedirect("/jd/login.html");
    }
  }

  /**
   * No operation.
   *
   * @see Filter@init(FilterConfig)
   */
  public void init(FilterConfig fConfig) {
    // TODO Auto-generated method stub
  }
}
