package com.junkakeno.placesearch.Model.Detail;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Likes{

	@SerializedName("summary")
	@Expose
	private String summary;

	@SerializedName("count")
	@Expose
	private int count;

	@SerializedName("groups")
	@Expose
	private List<GroupsItem> groups;

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setGroups(List<GroupsItem> groups){
		this.groups = groups;
	}

	public List<GroupsItem> getGroups(){
		return groups;
	}
}