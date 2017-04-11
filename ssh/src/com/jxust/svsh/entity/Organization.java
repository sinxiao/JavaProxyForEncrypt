package com.jxust.svsh.entity;
// Generated 2017-4-11 10:04:36 by Hibernate Tools 5.1.2.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Organization generated by hbm2java
 */
public class Organization implements java.io.Serializable {

	private Integer idOrganization;
	private Integer parentToId;
	private String orgName;
	private Date orgGen;
	private String destription;
	private Set managers = new HashSet(0);

	public Organization() {
	}

	public Organization(Integer parentToId, String orgName, Date orgGen, String destription, Set managers) {
		this.parentToId = parentToId;
		this.orgName = orgName;
		this.orgGen = orgGen;
		this.destription = destription;
		this.managers = managers;
	}

	public Integer getIdOrganization() {
		return this.idOrganization;
	}

	public void setIdOrganization(Integer idOrganization) {
		this.idOrganization = idOrganization;
	}

	public Integer getParentToId() {
		return this.parentToId;
	}

	public void setParentToId(Integer parentToId) {
		this.parentToId = parentToId;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Date getOrgGen() {
		return this.orgGen;
	}

	public void setOrgGen(Date orgGen) {
		this.orgGen = orgGen;
	}

	public String getDestription() {
		return this.destription;
	}

	public void setDestription(String destription) {
		this.destription = destription;
	}

	public Set getManagers() {
		return this.managers;
	}

	public void setManagers(Set managers) {
		this.managers = managers;
	}

}
