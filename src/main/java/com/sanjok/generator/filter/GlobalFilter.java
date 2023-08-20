package com.sanjok.generator.filter;

import com.sanjok.generator.modules.usermgmt.model.User;
import com.sanjok.generator.utl.URLMatcher;
import org.yaml.snakeyaml.Yaml;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = {"/*"})
public class GlobalFilter implements Filter {
    private Map<String, List<String>> rolURLMap;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        rolURLMap = new HashMap<>();
        InputStream inputStream = getClass().getResourceAsStream("/global-url-filter.yml");
        Yaml yaml = new Yaml();
        Map<String, List<String>> urls = yaml.load(inputStream);
        rolURLMap.putAll(urls);
        System.out.println("Global application filter init ok !");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("inside global application do filter ");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
        String servletPath = httpRequest.getRequestURI();
        handlePathAcess(request, response, chain, servletPath, "ROLE_ANONYMOUS");
        if (null != request.getAttribute("isPermitAll")) {
            System.out.println("url was listed in ROLE_ANONYMOUS . so no further processing required");
            return;
        }
        if (!isValidSession(session)) {
            System.out.println("you are not logged in! please login..");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else if (isValidSession(session)) {
            User currentUser = (User) session.getAttribute("currentUser");
            handleLogedInUser(request, response, chain, servletPath, currentUser);
        }
    }

    private static boolean isValidSession(HttpSession session) {
        try {
            return null != session && null != session.getAttribute("currentUser");
        } catch (Exception e) {
            System.out.println("session was already invalidated. ERR MSG:" + e.getMessage());
            return false;
        }
    }

    private void handleLogedInUser(ServletRequest request, ServletResponse response,
                                   FilterChain chain, String requestedURI, User currentUser) throws IOException, ServletException {
        if (rolURLMap.containsKey(currentUser.getRole().getRoleName())) {
            handlePathAcess(request, response, chain, requestedURI, currentUser.getRole().getRoleName());
        } else {
            System.out.println("this user has no role or invalid user");
            request.getRequestDispatcher("login.jsp")
                    .include(request, response);
        }
    }

    private void handlePathAcess(ServletRequest request,
                                 ServletResponse response,
                                 FilterChain chain,
                                 String requestedURI,
                                 String key) throws IOException, ServletException {

        String contextPath = ((HttpServletRequest) request).getContextPath();
        for (String allowedURI : rolURLMap.get(key)) {
            if (URLMatcher.matchUrl(contextPath + allowedURI, requestedURI)) {
                System.out.println("MATCHED " + requestedURI + " against " + allowedURI);
                System.out.println("request accepted for path:" + allowedURI );
                System.out.println("request accepted for role:" + key );
                chain.doFilter(request, response);
                request.setAttribute("isPermitAll", true);
            } else
                System.out.println("checked " + requestedURI + " against " + contextPath + allowedURI + " NO match!!");
        }
    }


    @Override
    public void destroy() {
        System.out.println("filter destroyed!!");
    }
}


