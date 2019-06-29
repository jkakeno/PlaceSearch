package com.junkakeno.placesearch.Model.Detail;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sample{

	@SerializedName("entities")
	@Expose
	private List<EntitiesItem> entities;

	@SerializedName("text")
	@Expose
	private String text;

	public void setEntities(List<EntitiesItem> entities){
		this.entities = entities;
	}

	public List<EntitiesItem> getEntities(){
		return entities;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}
}