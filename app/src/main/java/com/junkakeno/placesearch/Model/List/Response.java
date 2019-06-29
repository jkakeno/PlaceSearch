package com.junkakeno.placesearch.Model.List;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("venues")
	@Expose
	private ArrayList<VenuesItem> venues;

	public void setVenues(ArrayList<VenuesItem> venues){
		this.venues = venues;
	}

	public ArrayList<VenuesItem> getVenues(){
		return venues;
	}
}