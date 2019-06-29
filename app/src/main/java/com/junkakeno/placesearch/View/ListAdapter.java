package com.junkakeno.placesearch.View;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.junkakeno.placesearch.InteractionListener;
import com.junkakeno.placesearch.Model.List.CategoriesItem;
import com.junkakeno.placesearch.Model.List.Icon;
import com.junkakeno.placesearch.Model.List.VenuesItem;
import com.junkakeno.placesearch.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private static final String TAG = ListAdapter.class.getSimpleName();

    InteractionListener listener;
    ArrayList<VenuesItem> venuesItems;
    Context context;


    public ListAdapter(Context context, ArrayList<VenuesItem> venuesItems, InteractionListener listener) {
        this.venuesItems = venuesItems;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final VenuesItem venuesItem = venuesItems.get(position);

        String name = venuesItem.getName();

        List<CategoriesItem> categories = venuesItem.getCategories();

        double distanceValue = venuesItem.getLocation().getDistance()/1000f;
        String distance = String.valueOf(String.format("%.1f",distanceValue));
        String distanceUnit = distance + context.getResources().getString(R.string.distance_unit_US);

        if(!categories.isEmpty()) {
            String category = categories.get(0).getName();
            holder.category.setText(category);

            Icon icon = categories.get(0).getIcon();
            //https://developer.foursquare.com/docs/api/venues/categories
            final String iconUrl = icon.getPrefix()+"bg_88"+icon.getSuffix();
            Picasso.with(context).load(iconUrl).fetch(new Callback() {
                @Override
                public void onSuccess() {
                    Picasso.with(context).load(iconUrl).into(holder.icon);
                }

                @Override
                public void onError() {

                }
            });
        }

        holder.name.setText(name);
        holder.distance.setText(distanceUnit);

        if(venuesItem.isFavorite()){
            holder.favorite.setImageResource(R.drawable.ic_favorite_active);
        }else{
            holder.favorite.setImageResource(R.drawable.ic_favorite_inactive);
        }

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onListItemSelectionInteraction(venuesItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(venuesItems !=null) {
            return venuesItems.size();
        }else{
            return 1;
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView name;
        TextView category;
        TextView distance;
        ImageView favorite;
        View item;

        public ViewHolder(View itemView) {
            super(itemView);
            icon =itemView.findViewById(R.id.icon);
            name =itemView.findViewById(R.id.name);
            category =itemView.findViewById(R.id.category);
            distance =itemView.findViewById(R.id.distance);
            favorite =itemView.findViewById(R.id.favorite);
            item =itemView.findViewById(R.id.item);

        }
    }
}
