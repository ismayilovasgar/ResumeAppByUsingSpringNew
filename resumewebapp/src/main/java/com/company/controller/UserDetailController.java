///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package com.company.controller;
//
//import com.company.dao.impl.UserRepositoryCustom;
//import com.company.dao.impl.UserRepositoryCustomImpl;
//import com.company.entity.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author asgar
// */
//@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
//public class UserDetailController extends HttpServlet {
//
//    private UserRepositoryCustom userDao = new UserRepositoryCustomImpl();
//
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        int id = Integer.parseInt(request.getParameter("id"));
//        String action = request.getParameter("action");
//        if (action.equals("update")) {
//            String name = request.getParameter("name");
//            String surname = request.getParameter("surname");
//
//            System.out.println("Name / Surname " + name + surname);
//
//            User user = userDao.getById(id);
//            user.setName(name);
//            user.setSurname(surname);
//
//            userDao.updateUser(user);
//        } else if (action.equals("delete")) {
//            userDao.removeUser(id);
//        }
//        response.sendRedirect("users");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            String userIdStr = request.getParameter("id");
//            if (userIdStr == null || userIdStr.trim().isEmpty()) {
//                throw new IllegalArgumentException("id is not valid !");
//            }
//
//            Integer userId = Integer.parseInt(userIdStr);
//
////            UserDaoInter userDao = Context.instanceUserDao();
//            User u = userDao.getById(userId);
//            if (u == null) {
//                throw new IllegalArgumentException("There is no user with this id");
//            }
//
//            request.setAttribute("user", u);
//            request.getRequestDispatcher("userdetail.jsp").forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.sendRedirect("error?msg=" + e.getMessage());
//        }
//
//    }
//
//
//}
