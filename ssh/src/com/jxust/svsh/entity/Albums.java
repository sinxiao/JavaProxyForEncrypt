package com.jxust.svsh.entity;
// Generated 2017-4-11 10:04:36 by Hibernate Tools 5.1.2.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Albums generated by hbm2java
 */
public class Albums implements java.io.Serializable {

	private Integer albumId;
	private String nameEg;
	private String nameCh;
	private Integer artistId;
	private String pubDate;
	private Set musicses = new HashSet(0);

	public Albums() {
	}

	public Albums(String nameEg, String nameCh, Integer artistId, String pubDate, Set musicses) {
		this.nameEg = nameEg;
		this.nameCh = nameCh;
		this.artistId = artistId;
		this.pubDate = pubDate;
		this.musicses = musicses;
	}

	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getNameEg() {
		return this.nameEg;
	}

	public void setNameEg(String nameEg) {
		this.nameEg = nameEg;
	}

	public String getNameCh() {
		return this.nameCh;
	}

	public void setNameCh(String nameCh) {
		this.nameCh = nameCh;
	}

	public Integer getArtistId() {
		return this.artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public String getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public Set getMusicses() {
		return this.musicses;
	}

	public void setMusicses(Set musicses) {
		this.musicses = musicses;
	}

}
