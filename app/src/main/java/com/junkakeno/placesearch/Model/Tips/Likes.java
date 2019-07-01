package com.junkakeno.placesearch.Model.Tips;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Likes{

	@SerializedName("count")
	@Expose
	private int count;

	@SerializedName("groups")
	@Expose
	private List<Object> groups;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setGroups(List<Object> groups){
		this.groups = groups;
	}

	public List<Object> getGroups(){
		return groups;
	}
}