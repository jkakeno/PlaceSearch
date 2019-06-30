package com.junkakeno.placesearch.View;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.junkakeno.placesearch.Database.Database;
import com.junkakeno.placesearch.InteractionListener;
import com.junkakeno.placesearch.Model.List.Result;
import com.junkakeno.placesearch.Model.List.VenuesItem;
import com.junkakeno.placesearch.Network.ApiInterface;
import com.junkakeno.placesearch.Network.ApiUtils;
import com.junkakeno.placesearch.R;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    private static final String TAG = MapFragment.class.getSimpleName();
    private static final String ARG = "result";

    View view;
    MapView mapView;
    GoogleMap googleMap;
    Result result;
    ArrayList<VenuesItem> venues;
    InteractionListener listener;

    public static MapFragment newInstance(Result result) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG, result);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        if (getArguments() != null) {
            result = getArguments().getParcelable(ARG);
            if(result!=null){
                venues=result.getResponse().getVenues();
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        view = inflater.inflate(R.layout.map_fragment, container, false);
        mapView = view.findViewById(R.id.map);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
        listener = (InteractionListener) context;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

        initializeMapView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
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
        this.googleMap.setOnInfoWindowClickListener(this);

        setLocationMarkers(venues);
    }


    private void setLocationMarkers(ArrayList<VenuesItem> venues) {
        Log.d(TAG,"setMapLocation");
        googleMap.clear();

        if(mapView !=null){
            LatLngBounds.Builder builder = new LatLngBounds.Builder();

            for (VenuesItem venue:venues){
                double venueLat = venue.getLocation().getLat();
                double venueLng = venue.getLocation().getLng();
                LatLng venueLocation = new LatLng(venueLat, venueLng);
                String venueName = venue.getName();

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(venueLocation);
                markerOptions.title(venueName);
                markerOptions.snippet(venue.getId());
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                googleMap.addMarker(markerOptions);
                builder.include(venueLocation);
            }

            LatLngBounds bounds = builder.build();
            CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, mapView.getWidth(),mapView.getHeight(),100);
            googleMap.moveCamera(cu);
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Log.d(TAG,"Marker clicked is: " + marker.getTitle());

        for (VenuesItem venue:venues){
            if(venue.getId().equals(marker.getSnippet())){
                listener.onMarkerOptionSelectionInteraction(venue);
            }
        }
    }
}

