package com.junkakeno.placesearch.Model.Detail;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroupsItem{

	@SerializedName("count")
	@Expose
	private int count;

	@SerializedName("type")
	@Expose
	private String type;

	@SerializedName("items")
	@Expose
	private List<Object> items;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setItems(List<Object> items){
		this.items = items;
	}

	public List<Object> getItems(){
		return items;
	}
}