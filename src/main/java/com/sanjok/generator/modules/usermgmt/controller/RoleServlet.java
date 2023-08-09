/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.controller;

import com.sanjok.generator.modules.usermgmt.service.RoleService;

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
@WebServlet(name = "RoleController", urlPatterns = {"/RoleController", "/roleManagement", "/userRole", "/role"})
public class RoleServlet extends HttpServlet {

    private RequestDispatcher rd;
    private String viewPage;
    private final RoleService roleService;

    public RoleServlet() {
        this.roleService = new RoleService();
    }

    protected void processRequest(HttpServletRequest request)
            throws ServletException, IOException {
        String action = "";

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        switch (action) {

            case "add":
                viewPage = roleService.addPage(request);
                break;
            case "edit":
                viewPage = roleService.editPage(request);
                break;
            case "modify":
                viewPage = roleService.saveOrUpdate(request);
                System.out.println("redirecting to" + viewPage);
                break;
            case "delete":
                viewPage = roleService.deleteRole(request);
                break;
            case "search":
                viewPage = roleService.searchPage(request);
                break;
            case "searchPost":
                viewPage = roleService.getRoleBySearch(request);
                break;

            default:
                viewPage = roleService.getAllRole(request);
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request);
        System.out.println(viewPage);
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
}
