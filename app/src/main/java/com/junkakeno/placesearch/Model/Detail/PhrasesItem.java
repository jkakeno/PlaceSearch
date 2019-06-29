package com.junkakeno.placesearch.Model.Detail;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhrasesItem{

	@SerializedName("phrase")
	@Expose
	private String phrase;

	@SerializedName("count")
	@Expose
	private int count;

	@SerializedName("sample")
	@Expose
	private Sample sample;

	public void setPhrase(String phrase){
		this.phrase = phrase;
	}

	public String getPhrase(){
		return phrase;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setSample(Sample sample){
		this.sample = sample;
	}

	public Sample getSample(){
		return sample;
	}
}