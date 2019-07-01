package com.junkakeno.placesearch.Model.Tips;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("code")
	@Expose
	private int code;

	@SerializedName("requestId")
	@Expose
	private String requestId;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setRequestId(String requestId){
		this.requestId = requestId;
	}

	public String getRequestId(){
		return requestId;
	}
}