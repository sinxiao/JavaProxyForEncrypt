package com.jxust.svsh.entity;
// Generated 2017-4-11 10:04:36 by Hibernate Tools 5.1.2.Final

import java.util.HashSet;
import java.util.Set;

/**
 * TwTypes generated by hbm2java
 */
public class TwTypes implements java.io.Serializable {

	private Integer idTwTypes;
	private String name;
	private Set twitters = new HashSet(0);

	public TwTypes() {
	}

	public TwTypes(String name) {
		this.name = name;
	}

	public TwTypes(String name, Set twitters) {
		this.name = name;
		this.twitters = twitters;
	}

	public Integer getIdTwTypes() {
		return this.idTwTypes;
	}

	public void setIdTwTypes(Integer idTwTypes) {
		this.idTwTypes = idTwTypes;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getTwitters() {
		return this.twitters;
	}

	public void setTwitters(Set twitters) {
		this.twitters = twitters;
	}

}
