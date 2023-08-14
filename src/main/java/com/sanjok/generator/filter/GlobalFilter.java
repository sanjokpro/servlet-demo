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
        if (servletPath.startsWith(httpRequest.getContextPath()+"/login")) {
            System.out.println("skipping global filter for the path:" + servletPath);
            chain.doFilter(request, response);
        }
        if (null == session) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else if (null != session.getAttribute("current_user")) {
            User currentUser = (User) session.getAttribute("current_user");
            handleLogedInUser(request, response, chain, session, servletPath, currentUser);
        }
    }

    private void handleLogedInUser(ServletRequest request, ServletResponse response, FilterChain chain, HttpSession session, String requestedURI, User currentUser) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        String contextPath = httpServletRequest.getContextPath();
        if (rolURLMap.containsKey(currentUser.getRoleId())) {
            for (String allowedURI : rolURLMap.get(currentUser.getRoleId())) {
                if (URLMatcher.matchUrl(contextPath +allowedURI,requestedURI)) {
                    System.out.println("MATCHED "+requestedURI+" against " + allowedURI);
                    System.out.println("accepted  for :" + allowedURI);
                    chain.doFilter(request, response);
                    return;
                }
                System.out.println("checked " + requestedURI + " against "+contextPath + allowedURI+ " NO match!!");
            }
        }
    }


    @Override
    public void destroy() {
        System.out.println("filter destroyed!!");
    }
}


