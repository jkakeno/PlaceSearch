package com.junkakeno.placesearch.Model.Detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Page{

	@SerializedName("pageInfo")
	@Expose
	private PageInfo pageInfo;

	@SerializedName("user")
	@Expose
	private User user;

	public void setPageInfo(PageInfo pageInfo){
		this.pageInfo = pageInfo;
	}

	public PageInfo getPageInfo(){
		return pageInfo;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}
}