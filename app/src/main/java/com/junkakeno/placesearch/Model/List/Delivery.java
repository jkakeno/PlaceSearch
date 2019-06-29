package com.junkakeno.placesearch.Model.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Delivery{

	@SerializedName("provider")
	@Expose
	private Provider provider;

	@SerializedName("id")
	@Expose
	private String id;

	@SerializedName("url")
	@Expose
	private String url;

	public void setProvider(Provider provider){
		this.provider = provider;
	}

	public Provider getProvider(){
		return provider;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}