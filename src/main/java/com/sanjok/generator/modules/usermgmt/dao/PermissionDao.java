/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.dao;

import com.sanjok.generator.modules.usermgmt.model.Permission;
import com.sanjok.generator.utl.DBType;
import com.sanjok.generator.utl.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Sanjok
 */
public class PermissionDao {

    public static void addPermission(Permission perm) {
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
             PreparedStatement stmt = conn.prepareStatement("insert into permission (Perm_name,Associate) values(?,?)");) {

			stmt.setString(1, perm.getPermName());
            stmt.setString(2, perm.getAssociate());
            System.out.println("add permission query is: !" + stmt);
            if (stmt.execute()) {
                System.out.println("permission added sucessfully !" + stmt);
            } else {
                System.out.println("there was error addind permission .-->permissionDao.java");
            }
        } catch (SQLException e) {
            DBUtil.processException(e);
        }
    }

    public static void updatePermission(Permission perm) {
		System.out.println(perm.getPermName());
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement("UPDATE permission SET perm_name=?,associate=?, user_mgmt=?,course_mgmt=?,question_mgmt=? WHERE perm_id =?");) {
            System.out.println(stmt);
			stmt.setString(1, perm.getPermName());
            stmt.setString(2, perm.getAssociate());
			stmt.setBoolean(3, perm.isUserMgmt());
			stmt.setBoolean(4, perm.isCourseMgmt());
			stmt.setBoolean(5, perm.isQuestionMgmt());
			stmt.setInt(6, perm.getPermId());
            System.out.println(stmt);
            stmt.executeUpdate();
			System.out
					.println("Role added sucessfully !" + perm.getPermName() + perm.getAssociate() + perm.getPermId());

        } catch (Exception e) {
            DBUtil.processException((SQLException) e);
        }

    }

    public static void deletePermission(String id) {
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement("delete from Permission  where perm_id=?");) {
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            DBUtil.processException(e);
        }

    }

}
