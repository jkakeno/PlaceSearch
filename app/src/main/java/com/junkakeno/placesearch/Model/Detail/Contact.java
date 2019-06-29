package com.junkakeno.placesearch.Model.Detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact{

	@SerializedName("twitter")
	@Expose
	private String twitter;

	@SerializedName("facebook")
	@Expose
	private String facebook;

	@SerializedName("phone")
	@Expose
	private String phone;

	@SerializedName("facebookUsername")
	@Expose
	private String facebookUsername;

	@SerializedName("formattedPhone")
	@Expose
	private String formattedPhone;

	@SerializedName("instagram")
	@Expose
	private String instagram;

	@SerializedName("facebookName")
	@Expose
	private String facebookName;

	public void setTwitter(String twitter){
		this.twitter = twitter;
	}

	public String getTwitter(){
		return twitter;
	}

	public void setFacebook(String facebook){
		this.facebook = facebook;
	}

	public String getFacebook(){
		return facebook;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setFacebookUsername(String facebookUsername){
		this.facebookUsername = facebookUsername;
	}

	public String getFacebookUsername(){
		return facebookUsername;
	}

	public void setFormattedPhone(String formattedPhone){
		this.formattedPhone = formattedPhone;
	}

	public String getFormattedPhone(){
		return formattedPhone;
	}

	public void setInstagram(String instagram){
		this.instagram = instagram;
	}

	public String getInstagram(){
		return instagram;
	}

	public void setFacebookName(String facebookName){
		this.facebookName = facebookName;
	}

	public String getFacebookName(){
		return facebookName;
	}
}