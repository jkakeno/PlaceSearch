package com.junkakeno.placesearch.Model.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LabeledLatLngsItem{

	@SerializedName("lng")
	@Expose
	private double lng;

	@SerializedName("label")
	@Expose
	private String label;

	@SerializedName("lat")
	@Expose
	private double lat;

	public void setLng(double lng){
		this.lng = lng;
	}

	public double getLng(){
		return lng;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}
}