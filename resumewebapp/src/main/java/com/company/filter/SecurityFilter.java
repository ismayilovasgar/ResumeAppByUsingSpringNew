//package com.company.filter;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@WebFilter(filterName = "SecurityFilter", urlPatterns = {"*"})
//public class SecurityFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) {
//        try {
//            HttpServletRequest req = (HttpServletRequest) servletRequest;
//            HttpServletResponse res = (HttpServletResponse) servletResponse;
//
//            if (!req.getRequestURI().contains("/login") && req.getSession().getAttribute("loggedInUser") == null) {
////              ControllerUtil.errorPage(res, new IllegalArgumentException("Not Founded ! "));
//                res.sendRedirect("login");
//            } else {
//                filterChain.doFilter(servletRequest, servletResponse);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//}
