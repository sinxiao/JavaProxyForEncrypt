package com.jxust.svsh.entity;
// Generated 2017-4-11 10:04:36 by Hibernate Tools 5.1.2.Final

/**
 * TagRelationId generated by hbm2java
 */
public class TagRelationId implements java.io.Serializable {

	private Integer twitterid;
	private Integer media;
	private Integer dataid;
	private Integer tagid;

	public TagRelationId() {
	}

	public TagRelationId(Integer twitterid, Integer media, Integer dataid, Integer tagid) {
		this.twitterid = twitterid;
		this.media = media;
		this.dataid = dataid;
		this.tagid = tagid;
	}

	public Integer getTwitterid() {
		return this.twitterid;
	}

	public void setTwitterid(Integer twitterid) {
		this.twitterid = twitterid;
	}

	public Integer getMedia() {
		return this.media;
	}

	public void setMedia(Integer media) {
		this.media = media;
	}

	public Integer getDataid() {
		return this.dataid;
	}

	public void setDataid(Integer dataid) {
		this.dataid = dataid;
	}

	public Integer getTagid() {
		return this.tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TagRelationId))
			return false;
		TagRelationId castOther = (TagRelationId) other;

		return ((this.getTwitterid() == castOther.getTwitterid()) || (this.getTwitterid() != null
				&& castOther.getTwitterid() != null && this.getTwitterid().equals(castOther.getTwitterid())))
				&& ((this.getMedia() == castOther.getMedia()) || (this.getMedia() != null
						&& castOther.getMedia() != null && this.getMedia().equals(castOther.getMedia())))
				&& ((this.getDataid() == castOther.getDataid()) || (this.getDataid() != null
						&& castOther.getDataid() != null && this.getDataid().equals(castOther.getDataid())))
				&& ((this.getTagid() == castOther.getTagid()) || (this.getTagid() != null
						&& castOther.getTagid() != null && this.getTagid().equals(castOther.getTagid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTwitterid() == null ? 0 : this.getTwitterid().hashCode());
		result = 37 * result + (getMedia() == null ? 0 : this.getMedia().hashCode());
		result = 37 * result + (getDataid() == null ? 0 : this.getDataid().hashCode());
		result = 37 * result + (getTagid() == null ? 0 : this.getTagid().hashCode());
		return result;
	}

}
