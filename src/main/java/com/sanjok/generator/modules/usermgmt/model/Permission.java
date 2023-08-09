/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.model;

/**
 *
 * @author Sanjok
 */
public class Permission {

	private String permName;
	private String associate;
	private int permId;
	private int roleId;
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int id) {
		this.roleId = id;
	}

	public boolean isAddQn() {
		return isAddQn;
	}

	public void setAddQn(boolean isAddQn) {
		this.isAddQn = isAddQn;
	}

	public boolean isUpdateQn() {
		return isUpdateQn;
	}

	public void setUpdateQn(boolean isUpdateQn) {
		this.isUpdateQn = isUpdateQn;
	}

	public boolean isDeleteQn() {
		return isDeleteQn;
	}

	public void setDeleteQn(boolean isDeleteQn) {
		this.isDeleteQn = isDeleteQn;
	}

	public boolean isSearchQn() {
		return isSearchQn;
	}

	public void setSearchQn(boolean isSearchQn) {
		this.isSearchQn = isSearchQn;
	}

	public boolean isUserMgmt() {
		return isUserMgmt;
	}

	public void setUserMgmt(boolean isUserMgmt) {
		this.isUserMgmt = isUserMgmt;
	}

	public boolean isCourseMgmt() {
		return isCourseMgmt;
	}

	public void setCourseMgmt(boolean isCourseMgmt) {
		this.isCourseMgmt = isCourseMgmt;
	}

	public boolean isQuestionMgmt() {
		return isQuestionMgmt;
	}

	public void setQuestionMgmt(boolean isQuestionMgmt) {
		this.isQuestionMgmt = isQuestionMgmt;
	}

}
