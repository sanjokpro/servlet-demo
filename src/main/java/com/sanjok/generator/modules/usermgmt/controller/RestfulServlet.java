package com.sanjok.generator.modules.usermgmt.controller;

import com.google.gson.Gson;
import com.sanjok.generator.modules.usermgmt.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RestfulServlet", value = "/getUserJson")
public class RestfulServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student user = new Student();
        user.setId(12312);
        user.setUsername("sanjok");
        user.setId(11);

        response.setContentType("application/json");

        Gson gson = new Gson();
        String json = gson.toJson(user);

        PrintWriter out = response.getWriter();

        out.print(json);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    class Student{
        private int id;
        private String username;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
 
