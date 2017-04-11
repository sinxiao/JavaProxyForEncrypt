package com.jxust.svsh.entity;
// Generated 2017-4-11 10:04:36 by Hibernate Tools 5.1.2.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * FriendList generated by hbm2java
 */
public class FriendList implements java.io.Serializable {

	private int idfriendList;
	private Euser euser;
	private Date genTime;
	private String friendListName;
	private Set friendListUsers = new HashSet(0);

	public FriendList() {
	}

	public FriendList(int idfriendList, Euser euser) {
		this.idfriendList = idfriendList;
		this.euser = euser;
	}

	public FriendList(int idfriendList, Euser euser, Date genTime, String friendListName, Set friendListUsers) {
		this.idfriendList = idfriendList;
		this.euser = euser;
		this.genTime = genTime;
		this.friendListName = friendListName;
		this.friendListUsers = friendListUsers;
	}

	public int getIdfriendList() {
		return this.idfriendList;
	}

	public void setIdfriendList(int idfriendList) {
		this.idfriendList = idfriendList;
	}

	public Euser getEuser() {
		return this.euser;
	}

	public void setEuser(Euser euser) {
		this.euser = euser;
	}

	public Date getGenTime() {
		return this.genTime;
	}

	public void setGenTime(Date genTime) {
		this.genTime = genTime;
	}

	public String getFriendListName() {
		return this.friendListName;
	}

	public void setFriendListName(String friendListName) {
		this.friendListName = friendListName;
	}

	public Set getFriendListUsers() {
		return this.friendListUsers;
	}

	public void setFriendListUsers(Set friendListUsers) {
		this.friendListUsers = friendListUsers;
	}

}