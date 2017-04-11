package com.jxust.svsh.entity;
// Generated 2017-4-11 10:04:36 by Hibernate Tools 5.1.2.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Twitter generated by hbm2java
 */
public class Twitter implements java.io.Serializable {

	private Integer twitterId;
	private Euser euser;
	private TwTypes twTypes;
	private String datatime;
	private String detial;
	private int uid;
	private Integer targetId;
	private Integer targetType;
	private Integer pinglunSum;
	private Integer zhuangfaSum;
	private String topic;
	private String linked;
	private Integer loveSum;
	private Set twitterLoves = new HashSet(0);
	private Set twitterComments = new HashSet(0);

	public Twitter() {
	}

	public Twitter(String detial, int uid) {
		this.detial = detial;
		this.uid = uid;
	}

	public Twitter(Euser euser, TwTypes twTypes, String datatime, String detial, int uid, Integer targetId,
			Integer targetType, Integer pinglunSum, Integer zhuangfaSum, String topic, String linked, Integer loveSum,
			Set twitterLoves, Set twitterComments) {
		this.euser = euser;
		this.twTypes = twTypes;
		this.datatime = datatime;
		this.detial = detial;
		this.uid = uid;
		this.targetId = targetId;
		this.targetType = targetType;
		this.pinglunSum = pinglunSum;
		this.zhuangfaSum = zhuangfaSum;
		this.topic = topic;
		this.linked = linked;
		this.loveSum = loveSum;
		this.twitterLoves = twitterLoves;
		this.twitterComments = twitterComments;
	}

	public Integer getTwitterId() {
		return this.twitterId;
	}

	public void setTwitterId(Integer twitterId) {
		this.twitterId = twitterId;
	}

	public Euser getEuser() {
		return this.euser;
	}

	public void setEuser(Euser euser) {
		this.euser = euser;
	}

	public TwTypes getTwTypes() {
		return this.twTypes;
	}

	public void setTwTypes(TwTypes twTypes) {
		this.twTypes = twTypes;
	}

	public String getDatatime() {
		return this.datatime;
	}

	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}

	public String getDetial() {
		return this.detial;
	}

	public void setDetial(String detial) {
		this.detial = detial;
	}

	public int getUid() {
		return this.uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Integer getTargetId() {
		return this.targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public Integer getTargetType() {
		return this.targetType;
	}

	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}

	public Integer getPinglunSum() {
		return this.pinglunSum;
	}

	public void setPinglunSum(Integer pinglunSum) {
		this.pinglunSum = pinglunSum;
	}

	public Integer getZhuangfaSum() {
		return this.zhuangfaSum;
	}

	public void setZhuangfaSum(Integer zhuangfaSum) {
		this.zhuangfaSum = zhuangfaSum;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getLinked() {
		return this.linked;
	}

	public void setLinked(String linked) {
		this.linked = linked;
	}

	public Integer getLoveSum() {
		return this.loveSum;
	}

	public void setLoveSum(Integer loveSum) {
		this.loveSum = loveSum;
	}

	public Set getTwitterLoves() {
		return this.twitterLoves;
	}

	public void setTwitterLoves(Set twitterLoves) {
		this.twitterLoves = twitterLoves;
	}

	public Set getTwitterComments() {
		return this.twitterComments;
	}

	public void setTwitterComments(Set twitterComments) {
		this.twitterComments = twitterComments;
	}

}