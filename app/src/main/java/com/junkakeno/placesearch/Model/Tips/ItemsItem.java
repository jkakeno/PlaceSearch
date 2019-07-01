package com.junkakeno.placesearch.Model.Tips;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemsItem{

	@SerializedName("canonicalUrl")
	@Expose
	private String canonicalUrl;

	@SerializedName("photo")
	@Expose
	private Photo photo;

	@SerializedName("type")
	@Expose
	private String type;

	@SerializedName("disagreeCount")
	@Expose
	private int disagreeCount;

	@SerializedName("todo")
	@Expose
	private Todo todo;

	@SerializedName("createdAt")
	@Expose
	private int createdAt;

	@SerializedName("photourl")
	@Expose
	private String photourl;

	@SerializedName("logView")
	@Expose
	private boolean logView;

	@SerializedName("agreeCount")
	@Expose
	private int agreeCount;

	@SerializedName("id")
	@Expose
	private String id;

	@SerializedName("text")
	@Expose
	private String text;

	@SerializedName("lang")
	@Expose
	private String lang;

	@SerializedName("user")
	@Expose
	private User user;

	@SerializedName("likes")
	@Expose
	private Likes likes;

	public void setCanonicalUrl(String canonicalUrl){
		this.canonicalUrl = canonicalUrl;
	}

	public String getCanonicalUrl(){
		return canonicalUrl;
	}

	public void setPhoto(Photo photo){
		this.photo = photo;
	}

	public Photo getPhoto(){
		return photo;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setDisagreeCount(int disagreeCount){
		this.disagreeCount = disagreeCount;
	}

	public int getDisagreeCount(){
		return disagreeCount;
	}

	public void setTodo(Todo todo){
		this.todo = todo;
	}

	public Todo getTodo(){
		return todo;
	}

	public void setCreatedAt(int createdAt){
		this.createdAt = createdAt;
	}

	public int getCreatedAt(){
		return createdAt;
	}

	public void setPhotourl(String photourl){
		this.photourl = photourl;
	}

	public String getPhotourl(){
		return photourl;
	}

	public void setLogView(boolean logView){
		this.logView = logView;
	}

	public boolean isLogView(){
		return logView;
	}

	public void setAgreeCount(int agreeCount){
		this.agreeCount = agreeCount;
	}

	public int getAgreeCount(){
		return agreeCount;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setLang(String lang){
		this.lang = lang;
	}

	public String getLang(){
		return lang;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setLikes(Likes likes){
		this.likes = likes;
	}

	public Likes getLikes(){
		return likes;
	}
}