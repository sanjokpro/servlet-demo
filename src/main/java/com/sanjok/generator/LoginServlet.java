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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginController", urlPatterns = {"/login", "/"})
public class LoginServlet extends HttpServlet {
    UserDao userDao;

    public void init() throws ServletException {
        super.init();
        userDao =new UserDao();

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("inside do get!!!!!!!!!!!!!");
        resp.sendRedirect("login.jsp");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDao.getUserByUserName(username);
        HttpSession session = request.getSession(true);
        session.setAttribute("currentUser",user);
        System.out.println("receive from db "+user);
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            System.out.println("username pwd matches!!!!");
            List<String> options = new ArrayList<>();
            options.add("User Management");
            options.add("Course Management");
            options.add("Data Entry");
            request.setAttribute("options", options);
            request.getRequestDispatcher("welcome.jsp")
                    .forward(request, response);
        } else {
            System.out.println("password mismatch!!!!!!!!!!!!!!");
            response.sendRedirect("login.jsp");
        }
    }

}