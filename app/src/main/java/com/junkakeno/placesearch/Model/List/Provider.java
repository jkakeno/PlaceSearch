package com.junkakeno.placesearch.Model.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Provider{

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("icon")
	@Expose
	private Icon icon;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIcon(Icon icon){
		this.icon = icon;
	}

	public Icon getIcon(){
		return icon;
	}
}