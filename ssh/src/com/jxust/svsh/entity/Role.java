package com.jxust.svsh.entity;
// Generated 2017-4-11 10:04:36 by Hibernate Tools 5.1.2.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

	private Integer idRole;
	private String rname;
	private String desription;
	private String parentRId;
	private Date genTime;
	private Set managers = new HashSet(0);
	private Set rolerightreltions = new HashSet(0);

	public Role() {
	}

	public Role(String rname) {
		this.rname = rname;
	}

	public Role(String rname, String desription, String parentRId, Date genTime, Set managers, Set rolerightreltions) {
		this.rname = rname;
		this.desription = desription;
		this.parentRId = parentRId;
		this.genTime = genTime;
		this.managers = managers;
		this.rolerightreltions = rolerightreltions;
	}

	public Integer getIdRole() {
		return this.idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getDesription() {
		return this.desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public String getParentRId() {
		return this.parentRId;
	}

	public void setParentRId(String parentRId) {
		this.parentRId = parentRId;
	}

	public Date getGenTime() {
		return this.genTime;
	}

	public void setGenTime(Date genTime) {
		this.genTime = genTime;
	}

	public Set getManagers() {
		return this.managers;
	}

	public void setManagers(Set managers) {
		this.managers = managers;
	}

	public Set getRolerightreltions() {
		return this.rolerightreltions;
	}

	public void setRolerightreltions(Set rolerightreltions) {
		this.rolerightreltions = rolerightreltions;
	}

}
