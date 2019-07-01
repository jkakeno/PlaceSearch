package com.junkakeno.placesearch.Controller;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.junkakeno.placesearch.Database.Database;
import com.junkakeno.placesearch.InteractionListener;
import com.junkakeno.placesearch.Model.Detail.Detail;
import com.junkakeno.placesearch.Model.DetailAndTips;
import com.junkakeno.placesearch.Model.List.Result;
import com.junkakeno.placesearch.Model.List.VenuesItem;
import com.junkakeno.placesearch.Model.Tips.Tips;
import com.junkakeno.placesearch.Network.ApiInterface;
import com.junkakeno.placesearch.Network.ApiUtils;
import com.junkakeno.placesearch.R;
import com.junkakeno.placesearch.View.DetailFragment;
import com.junkakeno.placesearch.View.ListFragment;
import com.junkakeno.placesearch.View.MapFragment;
import com.junkakeno.placesearch.View.ProgressBarDialog;
import com.junkakeno.placesearch.View.SearchFragment;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements InteractionListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String SEARCH_FRAGMENT = "searchFragment";
    private static final String LIST_FRAGMENT = "listFragment";
    private static final String DETAIL_FRAGMENT = "detailFragment";
    private static final String MAP_FRAGMENT = "mapFragment";
    private static final String RESULT = "result";
    private static final String VENUE_DETAIL = "venueDetail";
    private static final String PROGRESS_DIALOG = "progress_dialog";

    FragmentManager fragmentManager;
    ApiInterface foursquareInterface;
    Result foursquareResult;
    Detail venueDetail;
    Tips venueTips;
    Database db;
    ArrayList<String> favoriteList;
    Disposable resultDisposable;
    Disposable detailDisposable;
    Disposable detailAndTipsDisposable;
    ProgressBarDialog progressDialog = new ProgressBarDialog();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        foursquareInterface = ApiUtils.foursquareInterface();

        db = new Database(this);
        favoriteList = db.getFavorites();

        SearchFragment searchFragment = new SearchFragment();
        fragmentManager.beginTransaction().replace(R.id.root, searchFragment, SEARCH_FRAGMENT).commit();

    }

    @Override
    public void onSearchInteraction(String business) {
        Log.d(TAG,"Query is: " + business);

        foursquareInterface.getResult(getResources().getString(R.string.date)
                ,getResources().getString(R.string.seattle_coordinates)
                ,getResources().getString(R.string.area_radius),business)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG,"Subscribed to get result");
                        resultDisposable = d;
                        progressDialog.show(fragmentManager,PROGRESS_DIALOG);
                    }

                    @Override
                    public void onNext(Result result) {
                        foursquareResult = result;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,"Getting result error: " + e.getMessage());
                        progressDialog.cancel();
                        showErrorDialog(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        for(VenuesItem venuesItem : foursquareResult.getResponse().getVenues()){
                            for(String venueId : favoriteList){
                                if(venuesItem.getId().equals(venueId)){
                                    venuesItem.setFavorite(true);
                                }
                            }
                        }

                        progressDialog.cancel();
                        ListFragment coverListFragment = ListFragment.newInstance(foursquareResult);
                        fragmentManager.beginTransaction().replace(R.id.root, coverListFragment, LIST_FRAGMENT).addToBackStack(SEARCH_FRAGMENT).commit();
                    }
                });
    }

    @Override
    public void onListItemSelectionInteraction(final VenuesItem venuesItem) {
        Log.d(TAG,"Venue selected is: " + venuesItem.getName() + venuesItem.getId());
        getVenueDetails(venuesItem);
    }

    @Override
    public void onFavoriteSaveInteraction(String venueId) {
        Log.d(TAG,"Add " + venueId + " to favorite");
        db.saveFavorite(venueId);

        Fragment listFragment = fragmentManager.findFragmentByTag(LIST_FRAGMENT);
        for(VenuesItem venuesItem : foursquareResult.getResponse().getVenues()){
            if(venuesItem.getId().equals(venueId)){
                venuesItem.setFavorite(true);
            }
        }
        listFragment.getArguments().putParcelable(RESULT,foursquareResult);

        Fragment detailFragment = fragmentManager.findFragmentByTag(DETAIL_FRAGMENT);
        venueDetail.getResponse().getVenue().setFavorite(true);
        detailFragment.getArguments().putParcelable(VENUE_DETAIL,venueDetail);
    }

    @Override
    public void onFavoriteDeleteInteraction(String venueId) {
        Log.d(TAG,"Delete " + venueId + " from favorite");
        db.deleteFavorite(venueId);

        Fragment listFragment = fragmentManager.findFragmentByTag(LIST_FRAGMENT);
        for(VenuesItem venuesItem : foursquareResult.getResponse().getVenues()){
            if(venuesItem.getId().equals(venueId)){
                venuesItem.setFavorite(false);
            }
        }
        listFragment.getArguments().putParcelable(RESULT,foursquareResult);

        Fragment detailFragment = fragmentManager.findFragmentByTag(DETAIL_FRAGMENT);
        venueDetail.getResponse().getVenue().setFavorite(false);
        detailFragment.getArguments().putParcelable(VENUE_DETAIL,venueDetail);
    }

    @Override
    public void onMarkerOptionSelectionInteraction(final VenuesItem venuesItem) {
        Log.d(TAG,"Venue selected is: " + venuesItem.getName() + venuesItem.getId());

        getVenueDetails(venuesItem);

    }

    public void getVenueDetails(final VenuesItem venuesItem){
        if(venuesItem.getId()!=null) {

            /*Get an observable apod object when calling apod api.*/
            Observable<Detail> detailsObservable = foursquareInterface.getDetails(venuesItem.getId(),getResources().getString(R.string.date)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

            /*Get an observable epic object when calling epic api.*/
            Observable<Tips> tipsObservable = foursquareInterface.getTips(venuesItem.getId(),getResources().getString(R.string.date)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

            /*Combine the 2 observables apod and epic.*/
            Observable<DetailAndTips> combinedObservable = Observable.zip(detailsObservable, tipsObservable, new BiFunction<Detail, Tips, DetailAndTips>() {
                @Override
                public DetailAndTips apply(Detail detail, Tips tips) throws Exception {
                    return new DetailAndTips(detail, tips);
                }
            });

            combinedObservable.subscribe(new Observer<DetailAndTips>() {
                @Override
                public void onSubscribe(Disposable d) {
                    Log.d(TAG, "Subscribed to get detail and tips");
                    detailAndTipsDisposable = d;
                }

                @Override
                public void onNext(DetailAndTips detailAndTips) {
                    venueDetail = detailAndTips.getDetail();
                    venueTips = detailAndTips.getTips();
                }

                @Override
                public void onError(Throwable e) {
                    Log.d(TAG, "Getting detail and tips error: " + e.getMessage());
                    showErrorDialog(e.getMessage());
                }

                @Override
                public void onComplete() {

                    venueDetail.getResponse().getVenue().setFavorite(venuesItem.isFavorite());

                    DetailFragment detailFragment = DetailFragment.newInstance(venueDetail, venueTips);
                    fragmentManager.beginTransaction().replace(R.id.root, detailFragment, DETAIL_FRAGMENT).addToBackStack(LIST_FRAGMENT).commit();

                }
            });
        }
    }

    @Override
    public void onFabInteraction(Result result) {
        if(result!=null){
            MapFragment mapFragment = MapFragment.newInstance(result);
            fragmentManager.beginTransaction().replace(R.id.root, mapFragment, MAP_FRAGMENT).addToBackStack(LIST_FRAGMENT).commit();
        }
    }

    @Override
    public void onWebInteraction(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(resultDisposable!=null) {
            resultDisposable.dispose();
        }
        if(detailDisposable!=null) {
            detailDisposable.dispose();
        }
        if(detailAndTipsDisposable!=null){
            detailAndTipsDisposable.dispose();
        }
    }

    private void showErrorDialog(String type) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        switch (type){
            case "HTTP 400 ":
                alertDialogBuilder.setTitle(getResources().getString(R.string.error_400_title));
                alertDialogBuilder.setMessage(getResources().getString(R.string.error_400_message));
                break;
            case "HTTP 403 ":
                alertDialogBuilder.setTitle(getResources().getString(R.string.error_403_title));
                alertDialogBuilder.setMessage(getResources().getString(R.string.error_403_message));
                break;
            case "HTTP 404 ":
                alertDialogBuilder.setTitle(getResources().getString(R.string.error_404_title));
                alertDialogBuilder.setMessage(getResources().getString(R.string.error_404_message));
                break;
            case "HTTP 429 ":
                alertDialogBuilder.setTitle(getResources().getString(R.string.error_429_title));
                alertDialogBuilder.setMessage(getResources().getString(R.string.error_429_message));
                break;
            case "HTTP 500 ":
                alertDialogBuilder.setTitle(getResources().getString(R.string.error_500_title));
                alertDialogBuilder.setMessage(getResources().getString(R.string.error_500_message));
                break;
        }

        alertDialogBuilder.setPositiveButton(getResources()
                .getString(R.string.error_alert_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog errorDialog = alertDialogBuilder.create();
        errorDialog.show();
    }
}
