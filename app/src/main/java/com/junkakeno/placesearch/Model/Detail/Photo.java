package com.junkakeno.placesearch.Model.Detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo{

	@SerializedName("prefix")
	@Expose
	private String prefix;

	@SerializedName("suffix")
	@Expose
	private String suffix;

	@SerializedName("createdAt")
	@Expose
	private int createdAt;

	@SerializedName("visibility")
	@Expose
	private String visibility;

	@SerializedName("width")
	@Expose
	private int width;

	@SerializedName("id")
	@Expose
	private String id;

	@SerializedName("height")
	@Expose
	private int height;

	public void setPrefix(String prefix){
		this.prefix = prefix;
	}

	public String getPrefix(){
		return prefix;
	}

	public void setSuffix(String suffix){
		this.suffix = suffix;
	}

	public String getSuffix(){
		return suffix;
	}

	public void setCreatedAt(int createdAt){
		this.createdAt = createdAt;
	}

	public int getCreatedAt(){
		return createdAt;
	}

	public void setVisibility(String visibility){
		this.visibility = visibility;
	}

	public String getVisibility(){
		return visibility;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}
}