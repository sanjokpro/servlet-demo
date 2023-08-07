package com.sanjok.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController", urlPatterns = {"/login", "/"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        handleLogedOnUser(req, resp);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession currentSession = request.getSession();
        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("username pwd matches!!!!");
            System.out.println("creating new session");
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("last_login", System.currentTimeMillis());
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("/");
        }
    }

    void handleLogedOnUser(HttpServletRequest req, HttpServletResponse response) throws IOException {
        if (null != req.getSession().getAttribute("last_login")) {
            System.out.println("session exists!!  Redirectig to welcome page.");
            response.sendRedirect("welcome.jsp");
        }
    }
}