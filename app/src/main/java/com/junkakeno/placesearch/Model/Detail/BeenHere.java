package com.junkakeno.placesearch.Model.Detail;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeenHere{

	@SerializedName("marked")
	@Expose
	private boolean marked;

	@SerializedName("count")
	@Expose
	private int count;

	@SerializedName("unconfirmedCount")
	@Expose
	private int unconfirmedCount;

	@SerializedName("lastCheckinExpiredAt")
	@Expose
	private int lastCheckinExpiredAt;

	public void setMarked(boolean marked){
		this.marked = marked;
	}

	public boolean isMarked(){
		return marked;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setUnconfirmedCount(int unconfirmedCount){
		this.unconfirmedCount = unconfirmedCount;
	}

	public int getUnconfirmedCount(){
		return unconfirmedCount;
	}

	public void setLastCheckinExpiredAt(int lastCheckinExpiredAt){
		this.lastCheckinExpiredAt = lastCheckinExpiredAt;
	}

	public int getLastCheckinExpiredAt(){
		return lastCheckinExpiredAt;
	}
}