/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.service;

import com.sanjok.generator.modules.usermgmt.dao.PermissionDao;
import com.sanjok.generator.modules.usermgmt.model.Permission;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Sanjok
 */
public class PermissionService {

    private final PermissionDao permissionDao;

    private final String addOrEditPage;
    private final String searchPage;
    private final String listPage;

    public PermissionService() {
        permissionDao = new PermissionDao();
        addOrEditPage = "/WEB-INF/view/permission_edit.jsp";
        searchPage = "/WEB-INF/view/permission_search.jsp";
        listPage = "/WEB-INF/view/permission_list.jsp";
    }

    public String addPage(HttpServletRequest request) {
        return addOrEditPage;
    }

    public String editPage(HttpServletRequest request) {
        System.out.println(request.getParameter("id"));
        request.setAttribute("id", request.getParameter("id"));

        return addOrEditPage;
    }

    public String saveOrUpdate(HttpServletRequest request) {
        String id = request.getParameter("id");
        Permission perm = new Permission();

		perm.setPermName(request.getParameter("perm_name"));
        perm.setAssociate(request.getParameter("associate"));
		perm.setUserMgmt(Boolean.parseBoolean(request.getParameter("user_mgmt")));
		perm.setQuestionMgmt(Boolean.parseBoolean(request.getParameter("question_mgmt")));
		perm.setCourseMgmt(Boolean.parseBoolean(request.getParameter("course_mgmt")));

        System.out.println(request.getParameter("perm_name"));
        if (id == null || id.isEmpty()) {
            System.out.println("this is add case! --> " + id);
            PermissionDao.addPermission(perm);
        } else {
			perm.setPermId(Integer.parseInt(id));
            System.out.println("this is update case!");
            PermissionDao.updatePermission(perm);
        }
        System.out.println("calling getAllRole...");
        return this.getAllPermission(request);
    }

    public String deletePermission(HttpServletRequest request) {
        PermissionDao.deletePermission(request.getParameter("id"));
        return this.listPage;
    }

    public String searchPage(HttpServletRequest request) {
        return searchPage;
    }

    public String getRoleBySearch(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAllPermission(HttpServletRequest request) {
        return listPage;
    }

    public String getPermissionBySearch(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
