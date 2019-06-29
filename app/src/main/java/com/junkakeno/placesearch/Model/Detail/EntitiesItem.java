package com.junkakeno.placesearch.Model.Detail;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EntitiesItem{

	@SerializedName("indices")
	@Expose
	private List<Integer> indices;

	@SerializedName("type")
	@Expose
	private String type;

	public void setIndices(List<Integer> indices){
		this.indices = indices;
	}

	public List<Integer> getIndices(){
		return indices;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}