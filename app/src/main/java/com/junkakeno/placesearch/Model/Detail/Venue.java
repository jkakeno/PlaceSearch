package com.junkakeno.placesearch.Model.Detail;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venue{

	@SerializedName("shortUrl")
	@Expose
	private String shortUrl;

	@SerializedName("rating")
	@Expose
	private double rating;

	@SerializedName("description")
	@Expose
	private String description;

	@SerializedName("photos")
	@Expose
	private Photos photos;

	@SerializedName("tips")
	@Expose
	private Tips tips;

	@SerializedName("hereNow")
	@Expose
	private HereNow hereNow;

	@SerializedName("createdAt")
	@Expose
	private int createdAt;

	@SerializedName("stats")
	@Expose
	private Stats stats;

	@SerializedName("contact")
	@Expose
	private Contact contact;

	@SerializedName("ratingColor")
	@Expose
	private String ratingColor;

	@SerializedName("id")
	@Expose
	private String id;

	@SerializedName("categories")
	@Expose
	private List<CategoriesItem> categories;

	@SerializedName("popular")
	@Expose
	private Popular popular;

	@SerializedName("likes")
	@Expose
	private Likes likes;

	@SerializedName("hours")
	@Expose
	private Hours hours;

	@SerializedName("canonicalUrl")
	@Expose
	private String canonicalUrl;

	@SerializedName("venueChains")
	@Expose
	private List<Object> venueChains;

	@SerializedName("verified")
	@Expose
	private boolean verified;

	@SerializedName("timeZone")
	@Expose
	private String timeZone;

	@SerializedName("storeId")
	@Expose
	private String storeId;

	@SerializedName("url")
	@Expose
	private String url;

	@SerializedName("beenHere")
	@Expose
	private BeenHere beenHere;

	@SerializedName("bestPhoto")
	@Expose
	private BestPhoto bestPhoto;

	@SerializedName("ratingSignals")
	@Expose
	private int ratingSignals;

	@SerializedName("listed")
	@Expose
	private Listed listed;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("location")
	@Expose
	private Location location;

	@SerializedName("attributes")
	@Expose
	private Attributes attributes;

	@SerializedName("page")
	@Expose
	private Page page;

	@SerializedName("pageUpdates")
	@Expose
	private PageUpdates pageUpdates;

	@SerializedName("phrases")
	@Expose
	private List<PhrasesItem> phrases;

	@SerializedName("inbox")
	@Expose
	private Inbox inbox;

	boolean isFavorite;

	public void setShortUrl(String shortUrl){
		this.shortUrl = shortUrl;
	}

	public String getShortUrl(){
		return shortUrl;
	}

	public void setRating(double rating){
		this.rating = rating;
	}

	public double getRating(){
		return rating;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setPhotos(Photos photos){
		this.photos = photos;
	}

	public Photos getPhotos(){
		return photos;
	}

	public void setTips(Tips tips){
		this.tips = tips;
	}

	public Tips getTips(){
		return tips;
	}

	public void setHereNow(HereNow hereNow){
		this.hereNow = hereNow;
	}

	public HereNow getHereNow(){
		return hereNow;
	}

	public void setCreatedAt(int createdAt){
		this.createdAt = createdAt;
	}

	public int getCreatedAt(){
		return createdAt;
	}

	public void setStats(Stats stats){
		this.stats = stats;
	}

	public Stats getStats(){
		return stats;
	}

	public void setContact(Contact contact){
		this.contact = contact;
	}

	public Contact getContact(){
		return contact;
	}

	public void setRatingColor(String ratingColor){
		this.ratingColor = ratingColor;
	}

	public String getRatingColor(){
		return ratingColor;
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

	public void setPopular(Popular popular){
		this.popular = popular;
	}

	public Popular getPopular(){
		return popular;
	}

	public void setLikes(Likes likes){
		this.likes = likes;
	}

	public Likes getLikes(){
		return likes;
	}

	public void setHours(Hours hours){
		this.hours = hours;
	}

	public Hours getHours(){
		return hours;
	}

	public void setCanonicalUrl(String canonicalUrl){
		this.canonicalUrl = canonicalUrl;
	}

	public String getCanonicalUrl(){
		return canonicalUrl;
	}

	public void setVenueChains(List<Object> venueChains){
		this.venueChains = venueChains;
	}

	public List<Object> getVenueChains(){
		return venueChains;
	}

	public void setVerified(boolean verified){
		this.verified = verified;
	}

	public boolean isVerified(){
		return verified;
	}

	public void setTimeZone(String timeZone){
		this.timeZone = timeZone;
	}

	public String getTimeZone(){
		return timeZone;
	}

	public void setStoreId(String storeId){
		this.storeId = storeId;
	}

	public String getStoreId(){
		return storeId;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setBeenHere(BeenHere beenHere){
		this.beenHere = beenHere;
	}

	public BeenHere getBeenHere(){
		return beenHere;
	}

	public void setBestPhoto(BestPhoto bestPhoto){
		this.bestPhoto = bestPhoto;
	}

	public BestPhoto getBestPhoto(){
		return bestPhoto;
	}

	public void setRatingSignals(int ratingSignals){
		this.ratingSignals = ratingSignals;
	}

	public int getRatingSignals(){
		return ratingSignals;
	}

	public void setListed(Listed listed){
		this.listed = listed;
	}

	public Listed getListed(){
		return listed;
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

	public void setAttributes(Attributes attributes){
		this.attributes = attributes;
	}

	public Attributes getAttributes(){
		return attributes;
	}

	public void setPage(Page page){
		this.page = page;
	}

	public Page getPage(){
		return page;
	}

	public void setPageUpdates(PageUpdates pageUpdates){
		this.pageUpdates = pageUpdates;
	}

	public PageUpdates getPageUpdates(){
		return pageUpdates;
	}

	public void setPhrases(List<PhrasesItem> phrases){
		this.phrases = phrases;
	}

	public List<PhrasesItem> getPhrases(){
		return phrases;
	}

	public void setInbox(Inbox inbox){
		this.inbox = inbox;
	}

	public Inbox getInbox(){
		return inbox;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean favorite) {
		isFavorite = favorite;
	}
}