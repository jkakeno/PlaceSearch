package com.junkakeno.placesearch.Model.Detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageInfo{

	@SerializedName("description")
	@Expose
	private String description;

	@SerializedName("banner")
	@Expose
	private String banner;

	@SerializedName("links")
	@Expose
	private Links links;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setBanner(String banner){
		this.banner = banner;
	}

	public String getBanner(){
		return banner;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}
}