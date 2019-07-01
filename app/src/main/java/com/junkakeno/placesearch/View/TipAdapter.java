package com.junkakeno.placesearch.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.junkakeno.placesearch.InteractionListener;
import com.junkakeno.placesearch.Model.List.CategoriesItem;
import com.junkakeno.placesearch.Model.List.Icon;
import com.junkakeno.placesearch.Model.List.VenuesItem;
import com.junkakeno.placesearch.Model.Tips.ItemsItem;
import com.junkakeno.placesearch.Model.Tips.Tips;
import com.junkakeno.placesearch.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TipAdapter extends RecyclerView.Adapter<TipAdapter.ViewHolder> {

    private static final String TAG = ListAdapter.class.getSimpleName();

    List<ItemsItem> tips;
    Context context;


    public TipAdapter(Context context, List<ItemsItem> tips) {
        this.tips = tips;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tip_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ItemsItem tipItem= tips.get(position);

        if(tipItem.getUser().getPhoto()!=null) {
            String photoPrefix = tipItem.getUser().getPhoto().getPrefix();
            String photoSufix = tipItem.getUser().getPhoto().getSuffix();
            final String photoUrl = photoPrefix + "500x500" + photoSufix;
            Picasso.with(context).load(photoUrl).fetch(new Callback() {
                @Override
                public void onSuccess() {
                    Picasso.with(context).load(photoUrl).into(holder.tip_image);
                }

                @Override
                public void onError() {

                }
            });
        }

        if(tipItem.getText()!=null) {
            String tipText = tipItem.getText();
            holder.tip_text.setText(tipText);
        }

    }

    @Override
    public int getItemCount() {
        if(tips !=null) {
            return tips.size();
        }else{
            return 1;
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView tip_image;
        TextView tip_text;

        public ViewHolder(View itemView) {
            super(itemView);
            tip_image =itemView.findViewById(R.id.tip_image);
            tip_text =itemView.findViewById(R.id.tip_text);
        }
    }
}
