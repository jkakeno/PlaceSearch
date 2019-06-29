package com.junkakeno.placesearch.Model.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VenuePage{

	@SerializedName("id")
	@Expose
	private String id;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}