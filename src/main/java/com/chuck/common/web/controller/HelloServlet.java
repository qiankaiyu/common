//package com.chuck.common.web.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author Chuck
// * @since 4/9/2021
// * @version 0.0.1
// *
// **/
//@Slf4j
//public class HelloServlet extends HttpServlet {
//
//    /**
//     *
//     */
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println("Hello,World");
//    }
//
//    @Override
//    public void init() throws ServletException {
//        log.info("Servlet {} has Started.", this.getServletName());
//    }
//
//    @Override
//    public void destroy() {
//        log.info("Servlet %s has Stoped.", this.getServletName());
//    }
//}
