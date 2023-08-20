/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.service;

import com.sanjok.generator.modules.usermgmt.dao.UserDao;
import com.sanjok.generator.modules.usermgmt.model.User;
import com.sanjok.generator.utl.Validation;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sanjok
 */
public class UserService {

    private final UserDao studentDao;

    private final String addOrEditPage, loginPage, searchPage, listPage, dataEntryPage;

    public UserService() {
        studentDao = new UserDao();
        dataEntryPage = "/WEB-INF/view/data_entry.jsp";
        addOrEditPage = "/WEB-INF/view/user_edit.jsp";
        searchPage = "/WEB-INF/view/user_list.jsp";
        listPage = "/WEB-INF/view/user_list.jsp";
        loginPage = "login.jsp";
    }

    public String addPage(HttpServletRequest request) {
        return addOrEditPage;
    }

    public String editPage(HttpServletRequest request) {

        request.setAttribute("users", UserDao.getUserById(Integer.parseInt(request.getParameter("id"))));

        return addOrEditPage;
    }

    public String searchPage(HttpServletRequest request) {

        return searchPage;
    }

    public String saveOrUpdate(HttpServletRequest request) {
        User user = new User();
        String id = request.getParameter("id");
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        System.out.println(request.getParameter("role" + "-------------------------------------------------------"));
        //---------------------------------------------------------------------------------------
        if (!request.getParameter("role").isEmpty() && request.getParameter("role") != null) {
            user.getRole().setId(Integer.parseInt(request.getParameter("role")));
            System.out.println(request.getParameter("role"));
        }
//-----------------------------------------------------------------------------------------------

        if (id == null || id.isEmpty()) {
            System.out.println("this is add case! --> " + id);
            UserDao.addUser(user);
        } else {
            user.setId(Integer.parseInt(id));
            System.out.println("this is update case!");
            UserDao.updateUser(user);
        }
//        System.out.println("calling getalluser...");
        return this.getAllUser(request);
    }

    public String getUserBySearch(HttpServletRequest request) {
        User user = new User();
        user.setEmail(request.getParameter("search"));
        user.setUsername(request.getParameter("search"));
        user.getRole().setRoleName(request.getParameter("search"));
//        System.out.println(request.getParameter("search" + "from userservice"));
        System.out.println("getting all search reasult into 'searchedUsers' attribute");
        request.setAttribute("searchedUsers", UserDao.getUserBySearch(user));
        System.out.println("called searchPage!");
        return listPage;

    }

    public String getAllUser(HttpServletRequest request) {
        request.setAttribute("users", UserDao.getAllUser());
//        System.out.println("called getalluser!");

        return listPage;

    }

    public String deleteUser(HttpServletRequest request) {
        UserDao.deleteUser(request.getParameter("id"));
        return this.getAllUser(request);
    }

    public String doDataEntry(HttpServletRequest request) {

        return dataEntryPage;
    }

    public String registerUser(HttpServletRequest request) {
        User user = new User();
        boolean equals = true;
        String errMsg = "";
        String email = request.getParameter("email").trim();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String confPassword = request.getParameter("confPassword").trim();
        if (!Validation.email(email)) {
            errMsg += "Invalid Email!<br>";
        }
        if (Validation.isEmpty(username)) {
            errMsg += "Empty Username!<br>";
        }
        if (!password.equals(confPassword)) {
            errMsg += "Conform Password do not match!<br>";
            equals = false;
        }
        if (Validation.isEmpty(password) || Validation.isEmpty(confPassword)) {
            errMsg += "One of the password is empty <br>";
            equals = false;
        }

        if (equals && "".equals(errMsg)) {
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            UserDao.addUser(user);
            request.setAttribute("userReg", "success!");
        }
        request.setAttribute("errMsg", errMsg);

        return loginPage;
    }
}
