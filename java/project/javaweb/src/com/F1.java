/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/** Servlet Filter implementation class F1 */
@WebFilter("/*")
public class F1 implements Filter {

  /** @see Filter@destroy() */
  public void destroy() {
    // TODO Auto-generated method stub
  }

  /** @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain) */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
    System.out.println("Enter Filter 1");

    // pass the request along the filter chain
    // chain.doFilter(request, response);
  }

  /** @see Filter@init(FilterConfig) */
  public void init(FilterConfig fConfig) {
    // TODO Auto-generated method stub
  }
}