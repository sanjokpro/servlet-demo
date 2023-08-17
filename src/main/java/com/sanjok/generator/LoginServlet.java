package com.sanjok.generator;

import com.sanjok.generator.modules.usermgmt.dao.UserDao;
import com.sanjok.generator.modules.usermgmt.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = {"/login", "/logout"})
public class LoginServlet extends HttpServlet {
    UserDao userDao;

    public void init() throws ServletException {
        super.init();
        userDao = new UserDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Reached doGet");
        String action = "";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        if (action.equals("logout")) {
            System.out.println("logging out....");
            request.getSession().invalidate();
            response.sendRedirect("login.jsp");

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDao.getUserByUserName(username);
        HttpSession session = null;
        if (0 < user.getId()) {
            session = request.getSession(true);
            session.setAttribute("currentUser", user);
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                System.out.println("username pwd matches!!!!");
                request.getRequestDispatcher("dashboard.jsp")
                        .forward(request, response);
            }
        }
        System.out.println("receive from db " + user);
        System.out.println("password mismatch!!!!!!!!!!!!!!");
        request.setAttribute("errorMessage", "Sorry, bad credentials. Please try again");
        request.getRequestDispatcher("login.jsp")
                .forward(request, response);

    }

}