package com.junkakeno.placesearch.Model.Detail;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links{

	@SerializedName("count")
	@Expose
	private int count;

	@SerializedName("items")
	@Expose
	private List<ItemsItem> items;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}