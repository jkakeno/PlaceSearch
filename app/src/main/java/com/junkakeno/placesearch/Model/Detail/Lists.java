package com.junkakeno.placesearch.Model.Detail;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lists{

	@SerializedName("groups")
	@Expose
	private List<GroupsItem> groups;

	public void setGroups(List<GroupsItem> groups){
		this.groups = groups;
	}

	public List<GroupsItem> getGroups(){
		return groups;
	}
}