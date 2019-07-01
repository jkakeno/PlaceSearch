package com.junkakeno.placesearch.Model.Tips;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("firstName")
	@Expose
	private String firstName;

	@SerializedName("lastName")
	@Expose
	private String lastName;

	@SerializedName("gender")
	@Expose
	private String gender;

	@SerializedName("id")
	@Expose
	private String id;

	@SerializedName("photo")
	@Expose
	private Photo photo;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
}