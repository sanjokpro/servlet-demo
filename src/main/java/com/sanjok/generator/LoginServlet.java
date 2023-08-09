package com.sanjok.generator;

import com.sanjok.generator.modules.usermgmt.dao.UserDao;
import com.sanjok.generator.modules.usermgmt.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = {"/login", "/"})
public class LoginServlet extends HttpServlet {
    UserDao userDao;

    public void init() throws ServletException {
        super.init();
        userDao =new UserDao();

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("inside do get!!!!!!!!!!!!!");
        handleLogedOnUser(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDao.getUserByUserName(username);
        System.out.println("receive from db "+user);
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            System.out.println("username pwd matches!!!!");
            response.sendRedirect("welcome.jsp");
        } else {
            System.out.println("password mismatch!!!!!!!!!!!!!!");
            response.sendRedirect("index.jsp");
        }
    }

    void handleLogedOnUser(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        if (null != req.getSession().getAttribute("last_login")) {
            System.out.println("session exists!!  Redirectig to welcome page.");
            response.sendRedirect("welcome.jsp");
        }

        System.out.println("handelling get request:");
//        response.sendRedirect("index.jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, response);
    }
}