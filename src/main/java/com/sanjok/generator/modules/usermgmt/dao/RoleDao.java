/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.dao;

import com.sanjok.generator.modules.usermgmt.model.Role;
import com.sanjok.generator.utl.DBType;
import com.sanjok.generator.utl.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Sanjok
 */
public class RoleDao {

    public static Object getRoleById(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void addRole(Role role) {
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
             PreparedStatement stmt = conn.prepareStatement("insert into role (role_name,role_desc,perm_id) values(?,?,?)");) {

            stmt.setString(1, role.getRoleName());
            stmt.setString(2, role.getRoleDesc());
			stmt.setInt(3, role.getPermId());
            System.out.println("Role added sucessfully !" + stmt);
            if (stmt.execute()) {
                System.out.println("Role added sucessfully !" + stmt);
            }
        } catch (SQLException e) {
            DBUtil.processException(e);
        }
    }

    public static void updateRole(Role role) {
        System.out.println(role.getRoleName());
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement("UPDATE role SET role_name=?,role_desc=?,perm_id=? WHERE role_id =?");) {
            System.out.println(stmt);
            stmt.setString(1, role.getRoleName());
            stmt.setString(2, role.getRoleDesc());
			stmt.setInt(3, role.getPermId());
            stmt.setInt(4, role.getRoleId());
            stmt.executeUpdate();
            System.out.println("Role added sucessfully !" + role.getRoleName() + role.getRoleDesc() + role.getRoleId());

        } catch (Exception e) {
            DBUtil.processException((SQLException) e);
        }

    }

    public static Object getAllRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void deleteRole(String id) {
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement("delete from role  where role_id=?");) {
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            DBUtil.processException(e);
        }

    }

}
