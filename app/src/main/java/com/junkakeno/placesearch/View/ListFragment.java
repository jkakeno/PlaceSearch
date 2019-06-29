package com.junkakeno.placesearch.View;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.junkakeno.placesearch.InteractionListener;
import com.junkakeno.placesearch.Model.List.Result;
import com.junkakeno.placesearch.Model.List.VenuesItem;
import com.junkakeno.placesearch.R;

import java.util.ArrayList;


public class ListFragment extends Fragment{
    private static final String TAG = ListFragment.class.getSimpleName();
    private static final String ARG = "result";

    View view;
    TextView msg;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    ListAdapter adapter;
    LinearLayoutManager layoutManager;
    Result result;
    InteractionListener listener;

    public ListFragment() {
    }

    public static ListFragment newInstance(Result result) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG, result);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        if (getArguments() != null) {
            result = getArguments().getParcelable(ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");
        view = inflater.inflate(R.layout.list_fragment,container,false);
        recyclerView = view.findViewById(R.id.list);
        msg = view.findViewById(R.id.msg);
        fab = view.findViewById(R.id.fab);

        ArrayList<VenuesItem> venues = result.getResponse().getVenues();

        if(!venues.isEmpty()) {
            msg.setVisibility(View.INVISIBLE);
            adapter = new ListAdapter(getActivity(), venues, listener);
            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);

            //Animate the fab to hide when scrolling
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (dy > 0 && fab.getVisibility() == View.VISIBLE) {
                        fab.hide();
                    } else if (dy < 0 && fab.getVisibility() != View.VISIBLE) {
                        fab.show();
                    }
                }
            });

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onFabInteraction(result);
                }
            });
        }

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
        if(adapter!=null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach");
        listener=null;
    }

}

