package com.junkakeno.placesearch.Model.Detail;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Popular{

	@SerializedName("isOpen")
	@Expose
	private boolean isOpen;

	@SerializedName("timeframes")
	@Expose
	private List<TimeframesItem> timeframes;

	@SerializedName("isLocalHoliday")
	@Expose
	private boolean isLocalHoliday;

	@SerializedName("status")
	@Expose
	private String status;

	public void setIsOpen(boolean isOpen){
		this.isOpen = isOpen;
	}

	public boolean isIsOpen(){
		return isOpen;
	}

	public void setTimeframes(List<TimeframesItem> timeframes){
		this.timeframes = timeframes;
	}

	public List<TimeframesItem> getTimeframes(){
		return timeframes;
	}

	public void setIsLocalHoliday(boolean isLocalHoliday){
		this.isLocalHoliday = isLocalHoliday;
	}

	public boolean isIsLocalHoliday(){
		return isLocalHoliday;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}