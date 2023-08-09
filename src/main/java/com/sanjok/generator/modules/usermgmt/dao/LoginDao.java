/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools , Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.dao;

import com.sanjok.generator.modules.usermgmt.model.User;
import com.sanjok.generator.utl.DBType;
import com.sanjok.generator.utl.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sanjok
 */
public class LoginDao {

    public static User userLogin(User user) throws SQLException {

        String username = user.getUsername();
        String password = user.getPassword();
        String roleName, associate, userId, email, courseMgmt, userMgmt, questionMgmt;
        int id;
        String searchQuery
                = "SELECT u.*,r.role_name,p.associate,course_mgmt,user_mgmt,question_mgmt from user u "
                + "INNER JOIN role r "
                + "ON u.role_id=r.role_id "
                + "INNER JOIN permission p "
                + "ON r.perm_id=p.perm_id "
                + "where username='"
                + username
                + "' AND password='"
                + password
                + "'";

        System.out.println("Your user name is " + username);
        System.out.println("Your password is " + password);
        System.out.println("Query: " + searchQuery);

        try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(searchQuery);) {

            if (rs.next()) {
                username = rs.getString("username");
                password = rs.getString("password");
                roleName = rs.getString("roleName");
                id = rs.getInt("userId");
                user.setUsername(username);
                user.setPassword(password);
                user.setRoleName(roleName);
//              user.setEmail(rs.getString("email"));
                user.setAssociate(rs.getString("associate")); 
				user.setCourseMgmt(rs.getBoolean("courseMgmt"));
				user.setUserMgmt((rs.getBoolean("userMgmt")));
				user.setQuestionMgmt((rs.getBoolean("questionMgmt")));
                user.setId(id);
                user.setValid(true);
            }

        } catch (SQLException e) {
            DBUtil.processException(e);
        }
        return user;

    }

}
