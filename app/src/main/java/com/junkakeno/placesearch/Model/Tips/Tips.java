package com.junkakeno.placesearch.Model.Tips;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tips implements Parcelable {

	@SerializedName("meta")
	@Expose
	private Meta meta;

	@SerializedName("response")
	@Expose
	private Response response;

	@SerializedName("count")
	@Expose
	private int count;

	@SerializedName("items")
	@Expose
	private List<ItemsItem> items;

	protected Tips(Parcel in) {
		count = in.readInt();
	}

	public static final Creator<Tips> CREATOR = new Creator<Tips>() {
		@Override
		public Tips createFromParcel(Parcel in) {
			return new Tips(in);
		}

		@Override
		public Tips[] newArray(int size) {
			return new Tips[size];
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

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(count);
	}
}