package com.sanjok.generator.modules.usermgmt.controller;

import com.sanjok.generator.modules.usermgmt.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter(filterName = "/UserFilter", urlPatterns = {"/UserController", "/user", "/DataEntry", "/Usermanagement"})
public class UserFilter implements Filter {

    public UserFilter() {

    }

    public void destroy() {
        System.err.println("-----------------------inside userFilter-destroy()----------------------");
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("-----------------------inside userFilter-----------------------");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        User user = (User) httpServletRequest.getSession()
                .getAttribute("currentSessionUser");

        if (null != user) {
            if (user.isQuestionMgmt()) {// Question manage garne permission xa ki
                // xaina ?
                System.err.println("-----------------------this user has  User_mgmt permission -----------");
                chain.doFilter(httpServletRequest, httpServletResponse);// allow this request to reach
                // it`s destination

            } else {
                System.err.println("-----------------------this user has no User_mgmt permission !-----------");
                RequestDispatcher rd = request.getRequestDispatcher("/acessdenied.jsp");
                rd.forward(request, response);
            }

        }
    }


    public void init(FilterConfig fConfig) throws ServletException {
        System.err.println("-----------------------inside userFilter-init(FilterConfig fConfig)----------------------");
    }

}
