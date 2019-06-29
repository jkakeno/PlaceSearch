package com.junkakeno.placesearch.Model.Detail;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("firstName")
	@Expose
	private String firstName;

	@SerializedName("gender")
	@Expose
	private String gender;

	@SerializedName("lists")
	@Expose
	private Lists lists;

	@SerializedName("homeCity")
	@Expose
	private String homeCity;

	@SerializedName("contact")
	@Expose
	private Contact contact;

	@SerializedName("photo")
	@Expose
	private Photo photo;

	@SerializedName("bio")
	@Expose
	private String bio;

	@SerializedName("id")
	@Expose
	private String id;

	@SerializedName("type")
	@Expose
	private String type;

	@SerializedName("tips")
	@Expose
	private Tips tips;

	@SerializedName("lastName")
	@Expose
	private String lastName;

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

	public void setLists(Lists lists){
		this.lists = lists;
	}

	public Lists getLists(){
		return lists;
	}

	public void setHomeCity(String homeCity){
		this.homeCity = homeCity;
	}

	public String getHomeCity(){
		return homeCity;
	}

	public void setContact(Contact contact){
		this.contact = contact;
	}

	public Contact getContact(){
		return contact;
	}

	public void setPhoto(Photo photo){
		this.photo = photo;
	}

	public Photo getPhoto(){
		return photo;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTips(Tips tips){
		this.tips = tips;
	}

	public Tips getTips(){
		return tips;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}
}