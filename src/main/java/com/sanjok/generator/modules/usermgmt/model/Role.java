/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.model;

import java.io.Serializable;

/**
 * @author Sanjok
 */
public class Role extends Permission implements Serializable {
    private int id;
    private String roleName;
    private String roleDesc;

    @Override
    public int getRoleId() {
        return id;
    }

    @Override
    public void setRoleId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
