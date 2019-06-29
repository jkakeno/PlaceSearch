package com.junkakeno.placesearch.Model.Detail;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Icon{

	@SerializedName("prefix")
	@Expose
	private String prefix;

	@SerializedName("suffix")
	@Expose
	private String suffix;

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
}