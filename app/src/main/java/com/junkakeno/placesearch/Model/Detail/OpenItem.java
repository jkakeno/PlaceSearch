package com.junkakeno.placesearch.Model.Detail;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpenItem{

	@SerializedName("renderedTime")
	@Expose
	private String renderedTime;

	public void setRenderedTime(String renderedTime){
		this.renderedTime = renderedTime;
	}

	public String getRenderedTime(){
		return renderedTime;
	}
}