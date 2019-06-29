package com.junkakeno.placesearch.View;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.junkakeno.placesearch.InteractionListener;
import com.junkakeno.placesearch.R;


public class SearchFragment extends Fragment {

    private static final String TAG = DetailFragment.class.getSimpleName();

    View view;
    TextView appName;
    SearchView searchView;
    InputMethodManager imm;
    InteractionListener listener;

    public SearchFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");

        view = inflater.inflate(R.layout.search_fragment,container,false);
        appName = view.findViewById(R.id.app_name);
        searchView = view.findViewById(R.id.search);

        Animation itemAnimationFallDown = AnimationUtils.loadAnimation(getActivity(), R.anim.item_animation_fall_down);
        appName.startAnimation(itemAnimationFallDown);

        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

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

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                listener.onSearchInteraction(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                return false;
            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach");
        listener = null;
    }
}


