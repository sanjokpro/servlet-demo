/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.service;


import com.sanjok.generator.modules.usermgmt.dao.LoginDao;
import com.sanjok.generator.modules.usermgmt.model.User;
import com.sanjok.generator.utl.DBUtil;

import java.sql.SQLException;

/**
 * @author Sanjok
 */
public class LoginService {

    private String message;

    public String getMessage() {
        return message;
    }

    public LoginService() {
    }

    public void setMessage() {
        this.message = "<div id=\"msg_error_div\">\n"
                + " <p>Incorrect Login Credentials.</p>\n"
                + " </div>";
    }

    public static User userLogin(User user) {
        try {
            user = LoginDao.userLogin(user);

        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
        return user;
    }

}
