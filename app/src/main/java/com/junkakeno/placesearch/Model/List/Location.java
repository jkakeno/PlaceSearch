package com.junkakeno.placesearch.Model.List;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("cc")
	@Expose
	private String cc;

	@SerializedName("country")
	@Expose
	private String country;

	@SerializedName("address")
	@Expose
	private String address;

	@SerializedName("labeledLatLngs")
	@Expose
	private List<LabeledLatLngsItem> labeledLatLngs;

	@SerializedName("lng")
	@Expose
	private double lng;

	@SerializedName("distance")
	@Expose
	private int distance;

	@SerializedName("formattedAddress")
	@Expose
	private List<String> formattedAddress;

	@SerializedName("city")
	@Expose
	private String city;

	@SerializedName("postalCode")
	@Expose
	private String postalCode;

	@SerializedName("state")
	@Expose
	private String state;

	@SerializedName("crossStreet")
	@Expose
	private String crossStreet;

	@SerializedName("lat")
	@Expose
	private double lat;

	public void setCc(String cc){
		this.cc = cc;
	}

	public String getCc(){
		return cc;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setLabeledLatLngs(List<LabeledLatLngsItem> labeledLatLngs){
		this.labeledLatLngs = labeledLatLngs;
	}

	public List<LabeledLatLngsItem> getLabeledLatLngs(){
		return labeledLatLngs;
	}

	public void setLng(double lng){
		this.lng = lng;
	}

	public double getLng(){
		return lng;
	}

	public void setDistance(int distance){
		this.distance = distance;
	}

	public int getDistance(){
		return distance;
	}

	public void setFormattedAddress(List<String> formattedAddress){
		this.formattedAddress = formattedAddress;
	}

	public List<String> getFormattedAddress(){
		return formattedAddress;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setCrossStreet(String crossStreet){
		this.crossStreet = crossStreet;
	}

	public String getCrossStreet(){
		return crossStreet;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}
}