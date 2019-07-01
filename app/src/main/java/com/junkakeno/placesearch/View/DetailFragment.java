package com.junkakeno.placesearch.View;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.junkakeno.placesearch.InteractionListener;
import com.junkakeno.placesearch.Model.Detail.Detail;
import com.junkakeno.placesearch.Model.Detail.Venue;
import com.junkakeno.placesearch.Model.Tips.ItemsItem;
import com.junkakeno.placesearch.Model.Tips.Tips;
import com.junkakeno.placesearch.R;

import java.util.List;

public class DetailFragment extends Fragment implements OnMapReadyCallback {

    private static final String TAG = DetailFragment.class.getSimpleName();
    private static final String ARG1 = "venueDetail";
    private static final String ARG2 = "venueTips";

    View view;
    TextView name;
    TextView likes;
    TextView category;
    TextView openStatus;
    TextView address;
    TextView description;
    TextView web;
    TextView checkinCount;
    TextView visitCount;
    TextView usersCount;
    TextView noTipMsg;
    ImageView checkinIcon;
    ImageView visitIcon;
    ImageView usersIcon;
    RatingBar ratingBar;
    ToggleButton favorite;
    MapView mapView;
    GoogleMap googleMap;
    Detail venueDetail;
    Tips venueTips;
    Venue venue;
    List<ItemsItem> tips;
    InteractionListener listener;
    RecyclerView recyclerView;
    TipAdapter adapter;
    LinearLayoutManager layoutManager;

    public static DetailFragment newInstance(Detail venueDetail, Tips venueTips) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG1, venueDetail);
        args.putParcelable(ARG2, venueTips);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        if (getArguments() != null) {
            venueDetail = getArguments().getParcelable(ARG1);
            venueTips = getArguments().getParcelable(ARG2);
            if(venueDetail!=null) {
                venue = venueDetail.getResponse().getVenue();
            }
            if(venueTips!=null){
                tips = venueTips.getResponse().getTips().getItems();
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");

        view = inflater.inflate(R.layout.collapsing_toolbar,container,false);
        mapView = view.findViewById(R.id.map);
        name = view.findViewById(R.id.name);
        likes = view.findViewById(R.id.likes);
        category = view.findViewById(R.id.category);
        openStatus = view.findViewById(R.id.open_status);
        address = view.findViewById(R.id.address);
        description = view.findViewById(R.id.description);
        ratingBar = view.findViewById(R.id.rating);
        favorite = view.findViewById(R.id.favorite);
        web = view.findViewById(R.id.web);
        checkinCount = view.findViewById(R.id.check_count);
        visitCount = view.findViewById(R.id.visit_count);
        usersCount = view.findViewById(R.id.user_count);
        noTipMsg = view.findViewById(R.id.no_tips_msg);
        recyclerView = view.findViewById(R.id.tip_recycler_view);
        noTipMsg.setVisibility(View.VISIBLE);

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG,"onAttach");
        listener = (InteractionListener) context;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");

        initializeMapView();

        if(venue.getName()!=null) {
            name.setText(venue.getName());
        }else{
            name.setVisibility(View.INVISIBLE);
        }

        if(venue.getLikes().getSummary()!=null) {
            likes.setText(venue.getLikes().getSummary());
        }else{
            likes.setVisibility(View.INVISIBLE);
        }

        if(!venue.getCategories().isEmpty()) {
            category.setText(venue.getCategories().get(0).getName());
        }else{
            category.setVisibility(View.INVISIBLE);
        }

        if(venue.getHours() !=null) {
            if (venue.getHours().isIsOpen()) {
                openStatus.setText(getResources().getString(R.string.operation_status_open));
                openStatus.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                openStatus.setText(getResources().getString(R.string.operation_status_closed));
                openStatus.setTextColor(getResources().getColor(R.color.colorAccent));
            }
        }else{
            openStatus.setText(getResources().getString(R.string.operation_status_unknown));
        }

        if(venue.getLocation().getFormattedAddress() !=null) {
            if(!venue.getLocation().getFormattedAddress().isEmpty()) {
                String addressStr = "";

                for (String item :venue.getLocation().getFormattedAddress()) {
                    addressStr += item + "\n";
                }
                address.setText(addressStr);
            }
        }else{
            address.setVisibility(View.INVISIBLE);
        }

        if(venue.getUrl()!=null) {
            web.setText(venue.getUrl());
            web.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onWebInteraction(venue.getUrl());
                }
            });
        }else{
            web.setVisibility(View.INVISIBLE);
        }

        ratingBar.setRating((float)venue.getRating()/2);

        if(venue.getDescription()!=null) {
            description.setText(venue.getDescription());
        }else{
            description.setVisibility(View.INVISIBLE);
        }

        if(venue.isFavorite()) {
            favorite.setChecked(true);
        }else{
            favorite.setChecked(false);
        }

        if(venue.getStats()!=null){
            checkinCount.setText(String.valueOf(venue.getStats().getCheckinsCount()));
            visitCount.setText(String.valueOf(venue.getStats().getVisitsCount()));
            usersCount.setText(String.valueOf(venue.getStats().getUsersCount()));
        }

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(favorite.isChecked()){
                    listener.onFavoriteSaveInteraction(venue.getId());
                }else{
                    listener.onFavoriteDeleteInteraction(venue.getId());
                }
            }
        });

        if(!tips.isEmpty()){
            noTipMsg.setVisibility(View.INVISIBLE);

            adapter = new TipAdapter(getActivity(), tips);
            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach");
        listener = null;
    }

    public void initializeMapView() {
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG,"onMapReady()");
        this.googleMap = googleMap;
        this.googleMap.getUiSettings().setMapToolbarEnabled(false);

        setLocationMarkers();
    }

    private void setLocationMarkers() {
        if(mapView!=null) {

            double venueLat = venue.getLocation().getLat();
            double venueLng = venue.getLocation().getLng();
            LatLng venueLocation = new LatLng(venueLat,venueLng);
            LatLng seatleLocation = new LatLng(47.6,-122.3);

            googleMap.addMarker(new MarkerOptions().position(venueLocation).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            googleMap.addMarker(new MarkerOptions().position(seatleLocation).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

            LatLngBounds bounds = new LatLngBounds.Builder().include(venueLocation).include(seatleLocation).build();

            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, mapView.getWidth(),mapView.getHeight(),70);
            googleMap.moveCamera(cameraUpdate);

            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        }
    }
}