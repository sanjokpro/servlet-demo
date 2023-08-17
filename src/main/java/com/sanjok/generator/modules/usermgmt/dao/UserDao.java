/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.dao;

import com.sanjok.generator.modules.usermgmt.model.User;
import com.sanjok.generator.utl.DBType;
import com.sanjok.generator.utl.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanjok
 */
public class UserDao {

    public static void addUser(User user) {
        System.out.println("addStudent()");
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL); PreparedStatement stmt = conn.prepareStatement("insert into user " + "(username, email, password,role_id) " + "values (?, ?, ?,?)");) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getRoleId());
            System.out.println(stmt);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }

    public static void updateUser(User user) {
        System.out.println("updating user....");
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL); PreparedStatement stmt = conn.prepareStatement("update user set " + " username=?, password=?, email=?,role_id=? " + " where user_id=? ");) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setInt(4, user.getRoleId());
            stmt.setInt(5, user.getId());
            System.out.println(stmt);
            stmt.executeUpdate();
            System.out.println("user updated!");

        } catch (SQLException e) {
            DBUtil.processException(e);
        }
    }

    public static List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL); Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); ResultSet rs = stmt.executeQuery("select user_id,username,password,email,role_name from user,role where user.role_id=role.role_id");) {
            while (rs.next()) {

                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setRoleName(rs.getString("role_name"));
                System.out.println(rs.getString("username"));
                users.add(user);

            }

        } catch (Exception e) {
            DBUtil.processException((SQLException) e);

        }

        return users;

    }

    public static List<User> getUserBySearch(User user) {
        System.out.println("getting user by search");
        List<User> userList;
        userList = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection(DBType.MYSQL); Statement stmt = conn.createStatement();) {

//            String sql = "select * from user u, role r where u.role_id = r.role_id and "
//                    + "u.username like '%" + user.getUsername()
//                    + "%' or u.email like '%" + user.getEmail()
//                    + "%' or r.role_name like '%" + user.getRole_name() + "%'";
            String sql = "select distinct user.*,role.role_name \n" + " from role\n" + "  RIGHT JOIN user\n" + " ON user.role_id=role.role_id " + " where username like '%" + user.getUsername() + "%'" + " or email like '%" + user.getEmail() + "%'" + " or role_name like '%" + user.getRoleName() + "%'" + " and user.role_id=role.role_id";
            System.out.println(sql);
            try (ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    User u = new User();

                    u.setId(rs.getInt("user_id"));
                    u.setUsername(rs.getString("username"));
                    u.setEmail(rs.getString("email"));
                    u.setRoleName(rs.getString("role_name"));

                    userList.add(u);

                }
                // rs.close();
            }
        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }

//        userList.forEach(u -> System.out.println(u));
        return userList;
    }

    public static void deleteUser(String id) {
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL); PreparedStatement stmt = conn.prepareStatement("delete from user  where user_id=?");) {
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            DBUtil.processException(e);
        }

    }

    public static User getUserById(int userId) {
        User user = new User();
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL); PreparedStatement stmt = conn.prepareStatement("select u.*,r.role_name  from user u LEFT JOIN role r ON u.role_id =r.role_id where u.user_id=? ");) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            System.out.println(stmt);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRoleName(rs.getString("role_name"));
                user.setRoleId(rs.getInt("role_id"));
            }

        } catch (SQLException e) {
            DBUtil.processException(e);

        }
        return user;
    }

    public static User getUserByUserName(String username) {
        User user = new User();
        String sql = "SELECT u.*,r.`role_name` FROM USER u JOIN role r ON u.`role_id`=r.`role_id` where u.username=? ";
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            System.out.println(stmt);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRoleName(rs.getString("role_name"));
                user.setRoleId(rs.getInt("role_id"));
            }

        } catch (SQLException e) {
            DBUtil.processException(e);

        }
        return user;
    }
}
