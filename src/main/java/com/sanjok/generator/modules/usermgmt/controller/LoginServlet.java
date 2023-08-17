/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.controller;

import com.sanjok.generator.modules.usermgmt.model.User;
import com.sanjok.generator.modules.usermgmt.service.LoginService;
import com.sanjok.generator.utl.Validation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Sanjok
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException
            , IOException {

        if (request.getParameter("username") != null
                && request.getParameter("password") != null) {
            User user = new User();
            user.setUsername(request.getParameter("username").trim());
            user.setPassword(request.getParameter("password").trim());
            System.out.println("credential received !");
            user = LoginService.userLogin(user);

            if (user.isValid) {
                HttpSession session = request.getSession(true);//create new session named "session"
                session.setAttribute("currentSessionUser", user);//add current user object in session attribute called "currentSessionUser"
                System.out.println("user is valid");
                response.sendRedirect("dashboard.jsp");

            } else {
                String error = "";
                LoginService lc = new LoginService();
                if (!Validation.checklength(user.getUsername())) {
                    error += "Empty Username!<br>";
                }
                if (!Validation.checklength(user.getPassword())) {
                    error += "Empty Password!<br>";
                }
                request.setAttribute("errMsg", error);
                lc.setMessage();
                request.setAttribute("user", user);
                request.setAttribute("LoginService", lc);
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
                System.out.println("user invalid");

            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //HttpSession session = request.getSession(false);
        // request.getSession().invalidate();
        if (request.getParameter("option") != null) {
            System.out.println("loging out...");
            request.getSession().invalidate();
            System.out.println("loged out success!........now redirecting to logon");
            response.sendRedirect("login.jsp");
        } else {
            processRequest(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("option") != null) {
            System.out.println("loging out...");
//            request.getSession().invalidate();
            System.out.println("loged out success!........now redirecting to logon");
            response.sendRedirect("login.jsp");
        } else {
            processRequest(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
