package com.junkakeno.placesearch.Model.Detail;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeframesItem{

	@SerializedName("includesToday")
	@Expose
	private boolean includesToday;

	@SerializedName("days")
	@Expose
	private String days;

	@SerializedName("open")
	@Expose
	private List<OpenItem> open;

	@SerializedName("segments")
	@Expose
	private List<Object> segments;

	public void setIncludesToday(boolean includesToday){
		this.includesToday = includesToday;
	}

	public boolean isIncludesToday(){
		return includesToday;
	}

	public void setDays(String days){
		this.days = days;
	}

	public String getDays(){
		return days;
	}

	public void setOpen(List<OpenItem> open){
		this.open = open;
	}

	public List<OpenItem> getOpen(){
		return open;
	}

	public void setSegments(List<Object> segments){
		this.segments = segments;
	}

	public List<Object> getSegments(){
		return segments;
	}
}