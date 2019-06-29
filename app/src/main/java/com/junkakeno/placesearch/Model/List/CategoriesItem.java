package com.junkakeno.placesearch.Model.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriesItem{

	@SerializedName("pluralName")
	@Expose
	private String pluralName;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("icon")
	@Expose
	private Icon icon;

	@SerializedName("id")
	@Expose
	private String id;

	@SerializedName("shortName")
	@Expose
	private String shortName;

	@SerializedName("primary")
	@Expose
	private boolean primary;

	public void setPluralName(String pluralName){
		this.pluralName = pluralName;
	}

	public String getPluralName(){
		return pluralName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIcon(Icon icon){
		this.icon = icon;
	}

	public Icon getIcon(){
		return icon;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setShortName(String shortName){
		this.shortName = shortName;
	}

	public String getShortName(){
		return shortName;
	}

	public void setPrimary(boolean primary){
		this.primary = primary;
	}

	public boolean isPrimary(){
		return primary;
	}
}