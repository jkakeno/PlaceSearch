package com.junkakeno.placesearch.Model.List;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VenuesItem implements Parcelable {

	@SerializedName("hasPerk")
	@Expose
	private boolean hasPerk;

	@SerializedName("referralId")
	@Expose
	private String referralId;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("location")
	@Expose
	private Location location;

	@SerializedName("id")
	@Expose
	private String id;

	@SerializedName("categories")
	@Expose
	private List<CategoriesItem> categories;

	@SerializedName("delivery")
	@Expose
	private Delivery delivery;

	@SerializedName("venuePage")
	@Expose
	private VenuePage venuePage;

	private boolean isFavorite;


	protected VenuesItem(Parcel in) {
		hasPerk = in.readByte() != 0;
		referralId = in.readString();
		name = in.readString();
		id = in.readString();
		isFavorite = in.readByte() != 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeByte((byte) (hasPerk ? 1 : 0));
		dest.writeString(referralId);
		dest.writeString(name);
		dest.writeString(id);
		dest.writeByte((byte) (isFavorite ? 1 : 0));
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<VenuesItem> CREATOR = new Creator<VenuesItem>() {
		@Override
		public VenuesItem createFromParcel(Parcel in) {
			return new VenuesItem(in);
		}

		@Override
		public VenuesItem[] newArray(int size) {
			return new VenuesItem[size];
		}
	};

	public void setHasPerk(boolean hasPerk){
		this.hasPerk = hasPerk;
	}

	public boolean isHasPerk(){
		return hasPerk;
	}

	public void setReferralId(String referralId){
		this.referralId = referralId;
	}

	public String getReferralId(){
		return referralId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategories(List<CategoriesItem> categories){
		this.categories = categories;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	public void setDelivery(Delivery delivery){
		this.delivery = delivery;
	}

	public Delivery getDelivery(){
		return delivery;
	}

	public void setVenuePage(VenuePage venuePage){
		this.venuePage = venuePage;
	}

	public VenuePage getVenuePage(){
		return venuePage;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean favorite) {
		isFavorite = favorite;
	}
}