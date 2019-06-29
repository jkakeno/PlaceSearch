package com.junkakeno.placesearch.Model.Detail;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("venue")
	@Expose
	private Venue venue;

	public void setVenue(Venue venue){
		this.venue = venue;
	}

	public Venue getVenue(){
		return venue;
	}
}