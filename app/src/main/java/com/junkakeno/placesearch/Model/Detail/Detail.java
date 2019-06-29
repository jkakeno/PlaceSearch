package com.junkakeno.placesearch.Model.Detail;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail implements Parcelable {

	@SerializedName("meta")
	@Expose
	private Meta meta;

	@SerializedName("response")
	@Expose
	private Response response;

	protected Detail(Parcel in) {
	}

	public static final Creator<Detail> CREATOR = new Creator<Detail>() {
		@Override
		public Detail createFromParcel(Parcel in) {
			return new Detail(in);
		}

		@Override
		public Detail[] newArray(int size) {
			return new Detail[size];
		}
	};

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
	}
}