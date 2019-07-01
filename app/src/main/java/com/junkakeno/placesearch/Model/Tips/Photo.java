package com.junkakeno.placesearch.Model.Tips;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo{

	@SerializedName("createdAt")
	@Expose
	private int createdAt;

	@SerializedName("visibility")
	@Expose
	private String visibility;

	@SerializedName("prefix")
	@Expose
	private String prefix;

	@SerializedName("width")
	@Expose
	private int width;

	@SerializedName("id")
	@Expose
	private String id;

	@SerializedName("source")
	@Expose
	private Source source;

	@SerializedName("suffix")
	@Expose
	private String suffix;

	@SerializedName("height")
	@Expose
	private int height;

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

	public void setPrefix(String prefix){
		this.prefix = prefix;
	}

	public String getPrefix(){
		return prefix;
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

	public void setSource(Source source){
		this.source = source;
	}

	public Source getSource(){
		return source;
	}

	public void setSuffix(String suffix){
		this.suffix = suffix;
	}

	public String getSuffix(){
		return suffix;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}
}