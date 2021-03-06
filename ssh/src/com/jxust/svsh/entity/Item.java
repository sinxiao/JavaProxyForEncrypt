package com.jxust.svsh.entity;
// Generated 2017-4-11 10:04:36 by Hibernate Tools 5.1.2.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Item generated by hbm2java
 */
public class Item implements java.io.Serializable {

	private Integer iditem;
	private Item item;
	private String name;
	private String ename;
	private Integer showathome;
	private Set newses = new HashSet(0);
	private Set items = new HashSet(0);

	public Item() {
	}

	public Item(Item item, String name, String ename, Integer showathome, Set newses, Set items) {
		this.item = item;
		this.name = name;
		this.ename = ename;
		this.showathome = showathome;
		this.newses = newses;
		this.items = items;
	}

	public Integer getIditem() {
		return this.iditem;
	}

	public void setIditem(Integer iditem) {
		this.iditem = iditem;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getShowathome() {
		return this.showathome;
	}

	public void setShowathome(Integer showathome) {
		this.showathome = showathome;
	}

	public Set getNewses() {
		return this.newses;
	}

	public void setNewses(Set newses) {
		this.newses = newses;
	}

	public Set getItems() {
		return this.items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

}
