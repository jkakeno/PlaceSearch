package com.junkakeno.placesearch.Model.Tips;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("tips")
	@Expose
	private Tips tips;

	public void setTips(Tips tips){
		this.tips = tips;
	}

	public Tips getTips(){
		return tips;
	}
}