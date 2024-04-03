//package com.company.filter;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
////**: V1-@Annotation Yolu
//@WebFilter(filterName = "JSPFileFilter", urlPatterns = {"*.jsp"})
//public class JspFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) {
//        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        try {
//            res.sendRedirect("error?msg=not found_!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}


//**: V2-Web.xml yolu
//public class JspFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) {
//        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//
//
//        if (req.getRequestURI().endsWith(".jsp")) {
//            try {
//                res.sendRedirect("error.jsp?msg=not found ! ");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//}

