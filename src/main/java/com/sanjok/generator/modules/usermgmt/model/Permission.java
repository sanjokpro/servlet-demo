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
public class Permission implements Serializable {

    private String permName;
    private String associate;
    private int permId;
    private boolean isAddQn, isUpdateQn, isDeleteQn, isSearchQn, isUserMgmt, isCourseMgmt, isQuestionMgmt;

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getAssociate() {
        return associate;
    }

    public void setAssociate(String associate) {
        this.associate = associate;
    }

    public int getPermId() {
        return permId;
    }

    public void setPermId(int permId) {
        this.permId = permId;
    }


    public boolean isAddQn() {
        return isAddQn;
    }

    public void setAddQn(boolean addQn) {
        isAddQn = addQn;
    }

    public boolean isUpdateQn() {
        return isUpdateQn;
    }

    public void setUpdateQn(boolean updateQn) {
        isUpdateQn = updateQn;
    }

    public boolean isDeleteQn() {
        return isDeleteQn;
    }

    public void setDeleteQn(boolean deleteQn) {
        isDeleteQn = deleteQn;
    }

    public boolean isSearchQn() {
        return isSearchQn;
    }

    public void setSearchQn(boolean searchQn) {
        isSearchQn = searchQn;
    }

    public boolean isUserMgmt() {
        return isUserMgmt;
    }

    public void setUserMgmt(boolean userMgmt) {
        isUserMgmt = userMgmt;
    }

    public boolean isCourseMgmt() {
        return isCourseMgmt;
    }

    public void setCourseMgmt(boolean courseMgmt) {
        isCourseMgmt = courseMgmt;
    }

    public boolean isQuestionMgmt() {
        return isQuestionMgmt;
    }

    public void setQuestionMgmt(boolean questionMgmt) {
        isQuestionMgmt = questionMgmt;
    }
}
