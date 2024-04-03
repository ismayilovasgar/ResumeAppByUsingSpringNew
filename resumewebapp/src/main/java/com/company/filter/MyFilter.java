//package com.company.filter;
//
//import javax.servlet.*;
//import java.io.IOException;
//
//public class MyFilter implements Filter {
//    private FilterConfig filterConfig = null;
//    private ServletContext servletContext = null;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        this.filterConfig = filterConfig;
//        this.servletContext = filterConfig.getServletContext();
//        servletContext.log("RequestLoggingFilter initialized");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//    }
//}
