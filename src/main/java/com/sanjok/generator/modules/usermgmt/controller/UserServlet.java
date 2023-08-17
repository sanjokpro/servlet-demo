/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.controller;

import com.sanjok.generator.modules.usermgmt.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Sanjok
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController", "/user", "/DataEntry", "/Usermanagement"})
public class UserServlet extends HttpServlet {
 
	private static final long serialVersionUID = -1045596565696725836L;
	private final UserService userService;
    private RequestDispatcher rd;
    private String viewPage;

    public UserServlet() {
        this.userService = new UserService();
    }

    protected void processRequest(HttpServletRequest request)
            throws ServletException, IOException {
        String action = "";

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        switch (action) {

            case "add":
                viewPage = userService.addPage(request);
                break;
            case "edit":
                viewPage = userService.editPage(request);
                break;
            case "modify":
                viewPage = userService.saveOrUpdate(request);
                System.out.println("redirecting to" + viewPage);
                break;
            case "delete":
                viewPage = userService.deleteUser(request);
                break;
            case "search":
                viewPage = userService.searchPage(request);
                break;
            case "searchPost":
                viewPage = userService.getUserBySearch(request);
                break;
            case "qnmgmt":
            case "dataEntry":
                viewPage = userService.doDataEntry(request);
                break;
            case "home":
                viewPage = "dashboard.jsp";
                break;
            case "signup":
                viewPage = userService.registerUser(request);
                System.out.println("re directing to" + viewPage);
                break;
            case "usermgmt":
            default:
                viewPage = userService.getAllUser(request);
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request);

        rd = request.getRequestDispatcher(viewPage);
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request);

        rd = request.getRequestDispatcher(viewPage);
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "this is a controller for user module";
    }

}
