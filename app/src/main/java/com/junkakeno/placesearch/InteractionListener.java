package com.junkakeno.placesearch;

import com.junkakeno.placesearch.Model.List.Result;
import com.junkakeno.placesearch.Model.List.VenuesItem;

public interface InteractionListener {

    void onSearchInteraction(String business);
    void onListItemSelectionInteraction(VenuesItem venuesItem);
    void onFavoriteSaveInteraction(String venueId);
    void onFavoriteDeleteInteraction(String venueId);
    void onMarkerOptionSelectionInteraction(VenuesItem venuesItem);
    void onFabInteraction(Result result);
    void onWebInteraction(String url);

}
