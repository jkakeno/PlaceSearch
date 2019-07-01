package com.junkakeno.placesearch.Network;

import com.junkakeno.placesearch.Model.Detail.Detail;
import com.junkakeno.placesearch.Model.List.Result;
import com.junkakeno.placesearch.Model.Tips.Tips;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    String CLIENT_ID = "1XWV2HAM2LDKUYS3D3GLQ2JKEAHL4SGHK4UYEXYWO1BOMTBQ";
    String CLIENT_SECRETE = "0UCQRENTVJKBLK1X1QKXZN4FPGMKTNENG022M13LO50YM3LR";

    //https://api.foursquare.com/v2/venues/search?client_id=1XWV2HAM2LDKUYS3D3GLQ2JKEAHL4SGHK4UYEXYWO1BOMTBQ&client_secret=0UCQRENTVJKBLK1X1QKXZN4FPGMKTNENG022M13LO50YM3LR&v=20190101&ll=47.6,-122.3&radius=2000&query=tacos&limit=20

    @GET("/v2/venues/search?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRETE)
    Observable<Result> getResult(@Query("v") String yyymmdd, @Query("ll") String coordinates, @Query("radius") String radius, @Query("query") String query);

    @GET("/v2/venues/{id}?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRETE)
    Observable<Detail> getDetails(@Path("id") String id,@Query("v") String yyymmdd);

    @GET("/v2/venues/{id}/tips?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRETE)
    Observable<Tips> getTips(@Path("id") String venueId,@Query("v") String yyymmdd);
}
