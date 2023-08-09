/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.controller;

import com.sanjok.generator.modules.usermgmt.service.PermissionService;

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
@WebServlet(name = "PermissionController", urlPatterns = {"/PermissionController", "/permission", "/permissionmgmt"})
public class PermissionServlet extends HttpServlet {

    private RequestDispatcher rd;
    private String viewPage;
    private final PermissionService permissionService;

    public PermissionServlet() {
        this.permissionService = new PermissionService();
    }

    protected void processRequest(HttpServletRequest request)
            throws ServletException, IOException {
        String action = "";

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        switch (action) {

            case "add":
                viewPage = permissionService.addPage(request);
                break;
            case "edit":
                viewPage = permissionService.editPage(request);
                break;
            case "modify":
                viewPage = permissionService.saveOrUpdate(request);
                System.out.println("redirecting to" + viewPage);
                break;
            case "delete":
                viewPage = permissionService.deletePermission(request);
                break;
            case "search":
                viewPage = permissionService.searchPage(request);
                break;
            case "searchPost":
                viewPage = permissionService.getPermissionBySearch(request);
                break;

            default:
                viewPage = permissionService.getAllPermission(request);
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
