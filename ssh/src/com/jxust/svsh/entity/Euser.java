package com.jxust.svsh.entity;
// Generated 2017-4-11 10:04:36 by Hibernate Tools 5.1.2.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Euser generated by hbm2java
 */
public class Euser implements java.io.Serializable {

	private Integer uid;
	private String inEmail;
	private String inPwd;
	private String nickName;
	private String phone;
	private Integer islock;
	private String createtime;
	private String infor;
	private Set euserDetails = new HashSet(0);
	private Set friendListUsers = new HashSet(0);
	private Set twitterLoves = new HashSet(0);
	private Set imageses = new HashSet(0);
	private Set informationsForFromId = new HashSet(0);
	private Set longTwitters = new HashSet(0);
	private Set managers = new HashSet(0);
	private Set informationsForToId = new HashSet(0);
	private Set traceses = new HashSet(0);
	private Set locationses = new HashSet(0);
	private Set medias = new HashSet(0);
	private Set twitterComments = new HashSet(0);
	private Set twitters = new HashSet(0);
	private Set newsComments = new HashSet(0);
	private Set friendLists = new HashSet(0);

	public Euser() {
	}

	public Euser(String inEmail, String inPwd, String nickName) {
		this.inEmail = inEmail;
		this.inPwd = inPwd;
		this.nickName = nickName;
	}

	public Euser(String inEmail, String inPwd, String nickName, String phone, Integer islock, String createtime,
			String infor, Set euserDetails, Set friendListUsers, Set twitterLoves, Set imageses,
			Set informationsForFromId, Set longTwitters, Set managers, Set informationsForToId, Set traceses,
			Set locationses, Set medias, Set twitterComments, Set twitters, Set newsComments, Set friendLists) {
		this.inEmail = inEmail;
		this.inPwd = inPwd;
		this.nickName = nickName;
		this.phone = phone;
		this.islock = islock;
		this.createtime = createtime;
		this.infor = infor;
		this.euserDetails = euserDetails;
		this.friendListUsers = friendListUsers;
		this.twitterLoves = twitterLoves;
		this.imageses = imageses;
		this.informationsForFromId = informationsForFromId;
		this.longTwitters = longTwitters;
		this.managers = managers;
		this.informationsForToId = informationsForToId;
		this.traceses = traceses;
		this.locationses = locationses;
		this.medias = medias;
		this.twitterComments = twitterComments;
		this.twitters = twitters;
		this.newsComments = newsComments;
		this.friendLists = friendLists;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getInEmail() {
		return this.inEmail;
	}

	public void setInEmail(String inEmail) {
		this.inEmail = inEmail;
	}

	public String getInPwd() {
		return this.inPwd;
	}

	public void setInPwd(String inPwd) {
		this.inPwd = inPwd;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIslock() {
		return this.islock;
	}

	public void setIslock(Integer islock) {
		this.islock = islock;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getInfor() {
		return this.infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

	public Set getEuserDetails() {
		return this.euserDetails;
	}

	public void setEuserDetails(Set euserDetails) {
		this.euserDetails = euserDetails;
	}

	public Set getFriendListUsers() {
		return this.friendListUsers;
	}

	public void setFriendListUsers(Set friendListUsers) {
		this.friendListUsers = friendListUsers;
	}

	public Set getTwitterLoves() {
		return this.twitterLoves;
	}

	public void setTwitterLoves(Set twitterLoves) {
		this.twitterLoves = twitterLoves;
	}

	public Set getImageses() {
		return this.imageses;
	}

	public void setImageses(Set imageses) {
		this.imageses = imageses;
	}

	public Set getInformationsForFromId() {
		return this.informationsForFromId;
	}

	public void setInformationsForFromId(Set informationsForFromId) {
		this.informationsForFromId = informationsForFromId;
	}

	public Set getLongTwitters() {
		return this.longTwitters;
	}

	public void setLongTwitters(Set longTwitters) {
		this.longTwitters = longTwitters;
	}

	public Set getManagers() {
		return this.managers;
	}

	public void setManagers(Set managers) {
		this.managers = managers;
	}

	public Set getInformationsForToId() {
		return this.informationsForToId;
	}

	public void setInformationsForToId(Set informationsForToId) {
		this.informationsForToId = informationsForToId;
	}

	public Set getTraceses() {
		return this.traceses;
	}

	public void setTraceses(Set traceses) {
		this.traceses = traceses;
	}

	public Set getLocationses() {
		return this.locationses;
	}

	public void setLocationses(Set locationses) {
		this.locationses = locationses;
	}

	public Set getMedias() {
		return this.medias;
	}

	public void setMedias(Set medias) {
		this.medias = medias;
	}

	public Set getTwitterComments() {
		return this.twitterComments;
	}

	public void setTwitterComments(Set twitterComments) {
		this.twitterComments = twitterComments;
	}

	public Set getTwitters() {
		return this.twitters;
	}

	public void setTwitters(Set twitters) {
		this.twitters = twitters;
	}

	public Set getNewsComments() {
		return this.newsComments;
	}

	public void setNewsComments(Set newsComments) {
		this.newsComments = newsComments;
	}

	public Set getFriendLists() {
		return this.friendLists;
	}

	public void setFriendLists(Set friendLists) {
		this.friendLists = friendLists;
	}

}
