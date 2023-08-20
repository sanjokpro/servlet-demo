/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.service;

import com.sanjok.generator.modules.usermgmt.dao.RoleDao;
import com.sanjok.generator.modules.usermgmt.model.Role;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Sanjok
 */
public class RoleService {

    private final RoleDao roleDao;

    private final String addOrEditPage;
    private final String searchPage;
    private final String listPage;

    public RoleService() {
        roleDao = new RoleDao();
        addOrEditPage = "/WEB-INF/view/role_edit.jsp";
        searchPage = "/WEB-INF/view/role_search.jsp";
        listPage = "/WEB-INF/view/role_list.jsp";
    }

    public String addPage(HttpServletRequest request) {
        System.out.println("redirecting to role add page");
        //  request.setAttribute("role", "add");
        System.out.println("request attribute 'role'='add' is set .");
        return addOrEditPage;
    }

    public String editPage(HttpServletRequest request) {
        System.out.println("redirecting to role edit page");
        request.setAttribute("id", request.getParameter("id"));
        System.out.println("request attribute 'id'='id' is set. ");

        return addOrEditPage;
    }

    public String searchPage(HttpServletRequest request) {
        return searchPage;
    }

    public String saveOrUpdate(HttpServletRequest request) {
        String id = request.getParameter("id");
        Role role = new Role();

        role.setRoleName(request.getParameter("role_name"));
        role.setRoleDesc(request.getParameter("role_desc"));
        //  --------------------------------------------------------------
        if (!request.getParameter("permission").isEmpty() || request.getParameter("permission") == null) {
			role.getPermission().setPermId(Integer.parseInt(request.getParameter("permission")));
        }
//  --------------------------------------------------------------
        System.out.println(request.getParameter("role_name"));
        if (id == null || id.isEmpty()) {
            System.out.println("this is add case! --> ");
            RoleDao.addRole(role);
        } else {
            role.setId(Integer.parseInt(id));
            System.out.println("this is update case!" + id);
            RoleDao.updateRole(role);
        }
        System.out.println("calling getallrole...");
        return this.getAllRole(request);
    }

    public String getRoleBySearch(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAllRole(HttpServletRequest request) {
        //request.setAttribute("roles", RoleDao.getAllRole());
        // System.out.println("called getallrole!");

        return listPage;

    }

    public String deleteRole(HttpServletRequest request) {
        RoleDao.deleteRole(request.getParameter("id"));
        return this.getAllRole(request);
    }

}
