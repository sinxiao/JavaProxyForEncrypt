package com.jxust.svsh.entity;
// Generated 2017-4-11 10:04:36 by Hibernate Tools 5.1.2.Final

/**
 * CountStatisId generated by hbm2java
 */
public class CountStatisId implements java.io.Serializable {

	private Integer userhot;
	private Integer twitterid;
	private Integer uid;
	private Integer readsum;
	private Integer pinglunsum;
	private Integer likesum;
	private Integer mediaid;
	private Integer data;
	private Integer recommend;

	public CountStatisId() {
	}

	public CountStatisId(Integer userhot, Integer twitterid, Integer uid, Integer readsum, Integer pinglunsum,
			Integer likesum, Integer mediaid, Integer data, Integer recommend) {
		this.userhot = userhot;
		this.twitterid = twitterid;
		this.uid = uid;
		this.readsum = readsum;
		this.pinglunsum = pinglunsum;
		this.likesum = likesum;
		this.mediaid = mediaid;
		this.data = data;
		this.recommend = recommend;
	}

	public Integer getUserhot() {
		return this.userhot;
	}

	public void setUserhot(Integer userhot) {
		this.userhot = userhot;
	}

	public Integer getTwitterid() {
		return this.twitterid;
	}

	public void setTwitterid(Integer twitterid) {
		this.twitterid = twitterid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getReadsum() {
		return this.readsum;
	}

	public void setReadsum(Integer readsum) {
		this.readsum = readsum;
	}

	public Integer getPinglunsum() {
		return this.pinglunsum;
	}

	public void setPinglunsum(Integer pinglunsum) {
		this.pinglunsum = pinglunsum;
	}

	public Integer getLikesum() {
		return this.likesum;
	}

	public void setLikesum(Integer likesum) {
		this.likesum = likesum;
	}

	public Integer getMediaid() {
		return this.mediaid;
	}

	public void setMediaid(Integer mediaid) {
		this.mediaid = mediaid;
	}

	public Integer getData() {
		return this.data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Integer getRecommend() {
		return this.recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CountStatisId))
			return false;
		CountStatisId castOther = (CountStatisId) other;

		return ((this.getUserhot() == castOther.getUserhot()) || (this.getUserhot() != null
				&& castOther.getUserhot() != null && this.getUserhot().equals(castOther.getUserhot())))
				&& ((this.getTwitterid() == castOther.getTwitterid()) || (this.getTwitterid() != null
						&& castOther.getTwitterid() != null && this.getTwitterid().equals(castOther.getTwitterid())))
				&& ((this.getUid() == castOther.getUid()) || (this.getUid() != null && castOther.getUid() != null
						&& this.getUid().equals(castOther.getUid())))
				&& ((this.getReadsum() == castOther.getReadsum()) || (this.getReadsum() != null
						&& castOther.getReadsum() != null && this.getReadsum().equals(castOther.getReadsum())))
				&& ((this.getPinglunsum() == castOther.getPinglunsum()) || (this.getPinglunsum() != null
						&& castOther.getPinglunsum() != null && this.getPinglunsum().equals(castOther.getPinglunsum())))
				&& ((this.getLikesum() == castOther.getLikesum()) || (this.getLikesum() != null
						&& castOther.getLikesum() != null && this.getLikesum().equals(castOther.getLikesum())))
				&& ((this.getMediaid() == castOther.getMediaid()) || (this.getMediaid() != null
						&& castOther.getMediaid() != null && this.getMediaid().equals(castOther.getMediaid())))
				&& ((this.getData() == castOther.getData()) || (this.getData() != null && castOther.getData() != null
						&& this.getData().equals(castOther.getData())))
				&& ((this.getRecommend() == castOther.getRecommend()) || (this.getRecommend() != null
						&& castOther.getRecommend() != null && this.getRecommend().equals(castOther.getRecommend())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserhot() == null ? 0 : this.getUserhot().hashCode());
		result = 37 * result + (getTwitterid() == null ? 0 : this.getTwitterid().hashCode());
		result = 37 * result + (getUid() == null ? 0 : this.getUid().hashCode());
		result = 37 * result + (getReadsum() == null ? 0 : this.getReadsum().hashCode());
		result = 37 * result + (getPinglunsum() == null ? 0 : this.getPinglunsum().hashCode());
		result = 37 * result + (getLikesum() == null ? 0 : this.getLikesum().hashCode());
		result = 37 * result + (getMediaid() == null ? 0 : this.getMediaid().hashCode());
		result = 37 * result + (getData() == null ? 0 : this.getData().hashCode());
		result = 37 * result + (getRecommend() == null ? 0 : this.getRecommend().hashCode());
		return result;
	}

}
