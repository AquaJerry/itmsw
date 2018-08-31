/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.jd.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/** Filter character encoding of servlet request and response. */
@WebFilter("/*")
public class EncodingFilter implements Filter {

  /**
   * No operation.
   *
   * @see Filter@destroy()
   */
  public void destroy() {
    // TODO Auto-generated method stub
  }

  /**
   * Set character encoding of servlet request and response as utf-8.
   *
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    // pass the request along the filter chain
    chain.doFilter(request, response);
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
