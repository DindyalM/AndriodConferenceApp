package com.example.dindyal_mursingh_assignment1.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.battleent.ribbonviews.RibbonLayout;
import com.example.dindyal_mursingh_assignment1.Model.Item;
import com.example.dindyal_mursingh_assignment1.Adapter.CustomViewHolder;
import com.example.dindyal_mursingh_assignment1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Speakers_Adapter_class extends RecyclerView.Adapter<CustomViewHolder> {

    Context context;
    List<Item> itemList;

    public Speakers_Adapter_class(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_listitem_speakers,viewGroup,false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
            Item item = itemList.get(i);
            if(item.type == 0){
                customViewHolder.ribbonLayout.setShowBottom(true);
                customViewHolder.ribbonLayout.setShowBottom(true);
                customViewHolder.ribbonLayout.setHeaderRibbonColor(Color.parseColor("#2B323A"));
                customViewHolder.ribbonLayout.setHeaderTextColor(Color.parseColor("#FFFFFF"));

                customViewHolder.ribbonLayout.setHeaderText(item.headerText);
                customViewHolder.ribbonLayout.setBottomText(item.bottomText);
                Picasso.with(context).load(item.imageURL)
                        .into(customViewHolder.imageView);

            }
            else if(item.type == 1){
                customViewHolder.ribbonLayout.setShowBottom(true);
                customViewHolder.ribbonLayout.setShowBottom(true);
                customViewHolder.ribbonLayout.setHeaderRibbonColor(Color.parseColor("#B94948"));
                customViewHolder.ribbonLayout.setHeaderTextColor(Color.parseColor("#FFFFFF"));

                customViewHolder.ribbonLayout.setHeaderText(item.headerText);
                customViewHolder.ribbonLayout.setBottomText(item.bottomText);
                Picasso.with(context).load(item.imageURL)
                        .into(customViewHolder.imageView);

            }
            else{
                customViewHolder.ribbonLayout.setShowBottom(false);
                customViewHolder.ribbonLayout.setShowBottom(false);
                Picasso.with(context).load(item.imageURL)
                        .into(customViewHolder.imageView);
            }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
