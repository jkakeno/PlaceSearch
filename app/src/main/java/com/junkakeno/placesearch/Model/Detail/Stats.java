package com.junkakeno.placesearch.Model.Detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats{

	@SerializedName("visitsCount")
	@Expose
	private int visitsCount;

	@SerializedName("checkinsCount")
	@Expose
	private int checkinsCount;

	@SerializedName("usersCount")
	@Expose
	private int usersCount;

	@SerializedName("tipCount")
	@Expose
	private int tipCount;

	public void setVisitsCount(int visitsCount){
		this.visitsCount = visitsCount;
	}

	public int getVisitsCount(){
		return visitsCount;
	}

	public void setCheckinsCount(int checkinsCount){
		this.checkinsCount = checkinsCount;
	}

	public int getCheckinsCount(){
		return checkinsCount;
	}

	public void setUsersCount(int usersCount){
		this.usersCount = usersCount;
	}

	public int getUsersCount(){
		return usersCount;
	}

	public void setTipCount(int tipCount){
		this.tipCount = tipCount;
	}

	public int getTipCount(){
		return tipCount;
	}
}